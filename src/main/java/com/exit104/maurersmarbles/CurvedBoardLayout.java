/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import com.google.common.base.Preconditions;

import java.util.Map;
import java.util.TreeMap;

/**
 * The CurvedBoardLayout class implements the BoardLayout interface to provide a dynamic and smooth
 * board layout. The spaces along a player's home are a straight line and the spaces in between
 * players are a smooth curve.
 *
 * @author Daniel Uppenkamp
 */
public class CurvedBoardLayout implements BoardLayout {

  /**
   * The board for the layout.
   */
  protected final transient Board board;
  /**
   * The card scale factor relative to the size of a grid cell.
   */
  protected static final float CARD_SCALE_FACTOR = 0.65f;
  /**
   * The size of a grid cell on the board.
   */
  protected transient float gridCellSize;
  /**
   * The marble scale factor relative to the size of a grid cell.
   */
  protected static final float MARBLE_SCALE_FACTOR = 0.98f;
  /**
   * The space scale factor relative to the size of a grid cell.
   */
  protected static final float SPACE_SCALE_FACTOR = 0.75f;
  /**
   * The map that contains the angles for each board index. The key into the map is the board index
   * and the value is the angle.
   */
  protected final transient Map<Integer, Float> boardIndexToAngleMap = new TreeMap<>();
  /**
   * The map that contains the bounds for each board index. The key into the map is the board index
   * and the value is the bounds.
   */
  protected final transient Map<Integer, Rectangle> boardIndexToBoundsMap = new TreeMap<>();
  /**
   * The bounds for the card deck on the board.
   */
  protected transient Rectangle cardDeckRectangle;
  /**
   * The bounds for the discard pile on the board.
   */
  protected transient Rectangle discardPileRectangle;

  /**
   * Creates a new CurvedBoardLayout for the given board. By default, the width and height of the
   * board layout is defined to be a unit square (1.0 x 1.0).
   *
   * @param board the board
   * @throws NullPointerException if the given board is null
   */
  public CurvedBoardLayout(Board board) {
    Preconditions.checkNotNull(board, "Null board");
    this.board = board;
    update(1.0f, 1.0f);
  }

  /**
   * Makes the interpolated spaces between the given player number and the next player number.
   *
   * @param playerNumber the player number to make the interpolated spaces for
   * @param point1 the starting point for the given player number
   * @param point2 the middle control point for the bezier curve
   * @param point3 the ending point for the next player number
   */
  protected void makeInterpolatedSpaces(int playerNumber, Point point1, Point point2,
      Point point3) {
    makeInterpolatedSpaces(playerNumber, point1, point2, point3,
        board.getSafeBoardIndex(playerNumber), 11);
  }

  /**
   * Makes the interpolated spaces for the given player number starting with the given board index
   * and interpolating the given number of spaces.
   *
   * @param playerNumber the player number to make the interpolated spaces for
   * @param point1 the starting point for the given player number
   * @param point2 the middle control point for the bezier curve
   * @param point3 the ending point for the next player number
   * @param boardIndex the board index to start interpolating at
   * @param numberOfSpaces the number of spaces to interpolate
   */
  protected void makeInterpolatedSpaces(int playerNumber, Point point1, Point point2,
      Point point3, int boardIndex, int numberOfSpaces) {

    // TODO preconditions?
    SmoothBezierInterpolator interpolator = new SmoothBezierInterpolator(
        point1.getX(), point1.getY(),
        point2.getX(), point2.getY(),
        point3.getX(), point3.getY());

    for (int i = 0; i < numberOfSpaces; i++) {

      float weight = (float) i / (float) (numberOfSpaces - 1);
      float centerX = interpolator.interpolateX(weight);
      float centerY = interpolator.interpolateY(weight);
      boardIndexToBoundsMap.put(boardIndex + i,
          new Rectangle(centerX - (gridCellSize / 2.0f), centerY - (gridCellSize / 2.0f),
              gridCellSize, gridCellSize));

      float angleFrom = boardIndexToAngleMap.get(board.getHomeEntryBoardIndex(playerNumber));
      float angleTo = boardIndexToAngleMap.get(board.getHomeEntryBoardIndex((playerNumber + 1)
          % board.getNumberOfPlayers()));
      // interpolate to find the angle for this space
      float angle = (float) (((angleTo - angleFrom) + (Math.PI * 3.0f)) % (Math.PI * 2.0f)
          - Math.PI);
      // calculate the shortest angle path so the space doesn't spin in a circle
      angle = angleFrom + angle * ((float) i / (float) (numberOfSpaces - 1));
      boardIndexToAngleMap.put(boardIndex + i, angle);

    }

  }

  /**
   * Makes the spaces for the given player number.
   *
   * @param playerNumber the player number to make the spaces for
   * @param homeEntryCenterX the center x location for the player's home entry space
   * @param homeEntryCenterY the center y location for the player's home entry space
   * @param angle the angle for the given player number
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  protected void makePlayerSpaces(int playerNumber, float homeEntryCenterX, float homeEntryCenterY,
      float angle) {

    // TODO preconditions?
    // spaces along the player's home entry
    for (int offset = 2; offset >= -2; offset--) {
      float centerX = (float) (homeEntryCenterX
          + (offset * gridCellSize * Math.cos(angle + Math.PI / 2.0f)));
      float centerY = (float) (homeEntryCenterY
          - (offset * gridCellSize * Math.sin(angle + Math.PI / 2.0f)));
      if (offset == 2) {
        boardIndexToBoundsMap.put(board.getSafeBoardIndex(playerNumber),
            new Rectangle(centerX - (gridCellSize / 2.0f), centerY - (gridCellSize / 2.0f),
                gridCellSize, gridCellSize));
        boardIndexToAngleMap.put(board.getSafeBoardIndex(playerNumber), angle);
      } else {
        boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(playerNumber) + offset,
            new Rectangle(centerX - (gridCellSize / 2.0f), centerY - (gridCellSize / 2.0f),
                gridCellSize, gridCellSize));
        boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(playerNumber) + offset, angle);
      }
    }

    // home spaces
    for (int offset = 0; offset < 4; offset++) {
      float centerX = (float) (homeEntryCenterX + ((1 + offset) * gridCellSize * Math.cos(angle)));
      float centerY = (float) (homeEntryCenterY - ((1 + offset) * gridCellSize * Math.sin(angle)));
      boardIndexToBoundsMap.put(board.getHomeMinBoardIndex(playerNumber) + offset,
          new Rectangle(centerX - (gridCellSize / 2.0f), centerY - (gridCellSize / 2.0f),
              gridCellSize, gridCellSize));
      boardIndexToAngleMap.put(board.getHomeMinBoardIndex(playerNumber) + offset,
          angle - (float) Math.PI / 2.0f);
    }

    // start spaces
    float startCenterX = (float) (homeEntryCenterX
        + (1.5f * gridCellSize * Math.cos(angle + Math.PI / 2.0f))
        + (gridCellSize * Math.cos(angle + Math.PI)));
    float startCenterY = (float) (homeEntryCenterY
        - (1.5f * gridCellSize * Math.sin(angle + Math.PI / 2.0f))
        - (gridCellSize * Math.sin(angle + Math.PI)));
    for (int offset = 0; offset < 4; offset++) {
      float centerX = (float) (startCenterX
          + (offset * gridCellSize * Math.cos(angle - Math.PI / 2.0f)));
      float centerY = (float) (startCenterY
          - (offset * gridCellSize * Math.sin(angle - Math.PI / 2.0f)));
      boardIndexToBoundsMap.put(board.getStartMinBoardIndex(playerNumber) + offset,
          new Rectangle(centerX - (gridCellSize / 2.0f), centerY - (gridCellSize / 2.0f),
              gridCellSize, gridCellSize));
      boardIndexToAngleMap.put(board.getStartMinBoardIndex(playerNumber) + offset, angle);
    }

  }

  /**
   * Updates the board layout using the given width and height.
   *
   * @param width the width of the board
   * @param height the height of the board
   */
  public final void update(float width, float height) {

    // TODO preconditions?
    switch (board.getNumberOfPlayers()) {
      case 4:
        updateFourPlayers(width, height);
        break;
      case 6:
        updateSixPlayers(width, height);
        break;
      case 8:
        updateEightPlayers(width, height);
        break;
      case 10:
        updateTenPlayers(width, height);
        break;
      case 12:
        updateTwelvePlayers(width, height);
        break;
      default:
        throw new IllegalStateException("Invalid player number: " + board.getNumberOfPlayers());
    }

    float cardWidth = Card.WIDTH * gridCellSize * CARD_SCALE_FACTOR;
    float cardHeight = Card.HEIGHT * gridCellSize * CARD_SCALE_FACTOR;
    cardDeckRectangle = new Rectangle(width / 4.0f, height / 2.0f
        - cardHeight / 2.0f, cardWidth, cardHeight);
    discardPileRectangle = new Rectangle(3.0f * width / 4.0f - cardWidth, height / 2.0f
        - cardHeight / 2.0f, cardWidth, cardHeight);

  }

  /**
   * Updates the board layout for eight players using the given width and height.
   *
   * @param width the width of the board
   * @param height the height of the board
   */
  protected void updateEightPlayers(float width, float height) {

    float gridSize = 16.0f;

    gridCellSize = Math.min(width / gridSize, height / gridSize);

    // player 0, bottom left center
    float homeEntryCenterX = width / 2.75f;
    float homeEntryCenterY = height - (gridCellSize * 1.5f);
    float angle = (float) Math.PI / 2.0f;
    makePlayerSpaces(0, homeEntryCenterX, homeEntryCenterY, angle);

    // player 1, bottom left corner
    homeEntryCenterX = gridCellSize * 2.35f;
    homeEntryCenterY = height - (gridCellSize * 2.14f);
    angle = (float) Math.PI / 3.0f;
    makePlayerSpaces(1, homeEntryCenterX, homeEntryCenterY, angle);

    // player 2, top left corner
    homeEntryCenterX = gridCellSize * 2.35f;
    homeEntryCenterY = gridCellSize * 2.14f;
    angle = 5.0f * (float) Math.PI / 3.0f;
    makePlayerSpaces(2, homeEntryCenterX, homeEntryCenterY, angle);

    // player 3, top left center
    homeEntryCenterX = width / 2.75f;
    homeEntryCenterY = gridCellSize * 1.5f;
    angle = 3.0f * (float) Math.PI / 2.0f;
    makePlayerSpaces(3, homeEntryCenterX, homeEntryCenterY, angle);

    // player 4, top right center
    homeEntryCenterX = width - (width / 2.75f);
    homeEntryCenterY = gridCellSize * 1.5f;
    angle = 3.0f * (float) Math.PI / 2.0f;
    makePlayerSpaces(4, homeEntryCenterX, homeEntryCenterY, angle);

    // player 5, top right corner
    homeEntryCenterX = width - (gridCellSize * 2.35f);
    homeEntryCenterY = gridCellSize * 2.14f;
    angle = 4.0f * (float) Math.PI / 3.0f;
    makePlayerSpaces(5, homeEntryCenterX, homeEntryCenterY, angle);

    // player 6, bottom right corner
    homeEntryCenterX = width - (gridCellSize * 2.35f);
    homeEntryCenterY = height - (gridCellSize * 2.14f);
    angle = 2.0f * (float) Math.PI / 3.0f;
    makePlayerSpaces(6, homeEntryCenterX, homeEntryCenterY, angle);

    // player 7, bottom right center
    homeEntryCenterX = width - (width / 2.75f);
    homeEntryCenterY = height - (gridCellSize * 1.5f);
    angle = (float) Math.PI / 2.0f;
    makePlayerSpaces(7, homeEntryCenterX, homeEntryCenterY, angle);

    // player 0, bottom left center
    Rectangle rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(0));
    Point point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(1) - 2);
    Point point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    Point point2 = new Point(width / 3.5f, height / 2.75f);
    makeInterpolatedSpaces(0, point1, point2, point3);

    // player 1, bottom left corner
    rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(1));
    point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(2) - 2);
    point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    point2 = new Point(width / 6.0f, height / 2.0f);
    makeInterpolatedSpaces(1, point1, point2, point3);

    // player 2, top left corner
    rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(2));
    point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(3) - 2);
    point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    point2 = new Point(width / 3.5f, height - (height / 2.75f));
    makeInterpolatedSpaces(2, point1, point2, point3);

    // player 3, top left center
    rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(3));
    point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(4) - 2);
    point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    point2 = new Point((point1.getX() + point3.getX()) / 2.0f, height - (height / 2.75f));
    makeInterpolatedSpaces(3, point1, point2, point3);

    // player 4, top right center
    rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(4));
    point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(5) - 2);
    point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    point2 = new Point(width - (width / 3.5f), height - (height / 2.75f));
    makeInterpolatedSpaces(4, point1, point2, point3);

    // player 5, top right corner
    rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(5));
    point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(6) - 2);
    point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    point2 = new Point(width - (width / 6.0f), height / 2.0f);
    makeInterpolatedSpaces(5, point1, point2, point3);

    // player 6, bottom right
    rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(6));
    point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(7) - 2);
    point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    point2 = new Point(width - (width / 3.5f), height / 2.75f);
    makeInterpolatedSpaces(6, point1, point2, point3);

    // player 7, bottom right center
    rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(7));
    point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(0) - 2);
    point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    point2 = new Point((point1.getX() + point3.getX()) / 2.0f, height / 2.75f);
    makeInterpolatedSpaces(7, point1, point2, point3);

  }

  /**
   * Updates the board layout for four players using the given width and height.
   *
   * @param width the width of the board
   * @param height the height of the board
   */
  protected void updateFourPlayers(float width, float height) {

    float gridSize = 15.0f;

    gridCellSize = Math.min(width / gridSize, height / gridSize);

    // player 0, bottom
    float homeEntryCenterX = width / 2.0f;
    float homeEntryCenterY = height - (gridCellSize * 1.5f);
    float angle = (float) Math.PI / 2.0f;
    makePlayerSpaces(0, homeEntryCenterX, homeEntryCenterY, angle);

    // player 1, left
    homeEntryCenterX = gridCellSize * 1.5f;
    homeEntryCenterY = height / 2.0f;
    angle = 0.0f;
    makePlayerSpaces(1, homeEntryCenterX, homeEntryCenterY, angle);

    // player 2, top
    homeEntryCenterX = width / 2.0f;
    homeEntryCenterY = gridCellSize * 1.5f;
    angle = 3.0f * (float) Math.PI / 2.0f;
    makePlayerSpaces(2, homeEntryCenterX, homeEntryCenterY, angle);

    // player 3, right
    homeEntryCenterX = width - (gridCellSize * 1.5f);
    homeEntryCenterY = height / 2.0f;
    angle = (float) Math.PI;
    makePlayerSpaces(3, homeEntryCenterX, homeEntryCenterY, angle);

    // player 0, bottom
    Rectangle rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(0));
    Point point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(1) - 2);
    Point point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    Point point2 = new Point(point1.getX(), point3.getY());
    makeInterpolatedSpaces(0, point1, point2, point3);

    // player 1, left
    rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(1));
    point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(2) - 2);
    point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    point2 = new Point(point3.getX(), point1.getY());
    makeInterpolatedSpaces(1, point1, point2, point3);

    // player 2, top
    rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(2));
    point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(3) - 2);
    point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    point2 = new Point(point1.getX(), point3.getY());
    makeInterpolatedSpaces(2, point1, point2, point3);

    // player 3, right
    rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(3));
    point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(0) - 2);
    point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    point2 = new Point(point3.getX(), point1.getY());
    makeInterpolatedSpaces(3, point1, point2, point3);

  }

  /**
   * Updates the board layout for six players using the given width and height.
   *
   * @param width the width of the board
   * @param height the height of the board
   */
  protected void updateSixPlayers(float width, float height) {

    float gridSize = 15.0f;

    gridCellSize = Math.min(width / gridSize, height / gridSize);

    // player 0, bottom center
    float homeEntryCenterX = width / 2.0f;
    float homeEntryCenterY = height - (gridCellSize * 1.5f);
    float angle = (float) Math.PI / 2.0f;
    makePlayerSpaces(0, homeEntryCenterX, homeEntryCenterY, angle);

    // player 1, bottom left
    homeEntryCenterX = gridCellSize * 2.3f;
    homeEntryCenterY = height - (gridCellSize * 2.3f);
    angle = (float) Math.PI / 4.0f;
    makePlayerSpaces(1, homeEntryCenterX, homeEntryCenterY, angle);

    // player 2, top left
    homeEntryCenterX = gridCellSize * 2.3f;
    homeEntryCenterY = gridCellSize * 2.3f;
    angle = 7.0f * (float) Math.PI / 4.0f;
    makePlayerSpaces(2, homeEntryCenterX, homeEntryCenterY, angle);

    // player 3, top center
    homeEntryCenterX = width / 2.0f;
    homeEntryCenterY = gridCellSize * 1.5f;
    angle = 3.0f * (float) Math.PI / 2.0f;
    makePlayerSpaces(3, homeEntryCenterX, homeEntryCenterY, angle);

    // player 4, top right
    homeEntryCenterX = width - (gridCellSize * 2.3f);
    homeEntryCenterY = gridCellSize * 2.3f;
    angle = 5.0f * (float) Math.PI / 4.0f;
    makePlayerSpaces(4, homeEntryCenterX, homeEntryCenterY, angle);

    // player 5, bottom right
    homeEntryCenterX = width - (gridCellSize * 2.3f);
    homeEntryCenterY = height - (gridCellSize * 2.3f);
    angle = 3.0f * (float) Math.PI / 4.0f;
    makePlayerSpaces(5, homeEntryCenterX, homeEntryCenterY, angle);

    // player 0, bottom center
    Rectangle rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(0));
    Point point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(1) - 2);
    Point point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    Point point2 = new Point(width / 2.3f, height / 2.5f);
    makeInterpolatedSpaces(0, point1, point2, point3);

    // player 1, bottom left
    rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(1));
    point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(2) - 2);
    point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    point2 = new Point(width / 4.3f, height / 2.0f);
    makeInterpolatedSpaces(1, point1, point2, point3);

    // player 2, top left
    rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(2));
    point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(3) - 2);
    point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    point2 = new Point(width / 2.3f, height - (height / 2.5f));
    makeInterpolatedSpaces(2, point1, point2, point3);

    // player 3, top center
    rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(3));
    point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(4) - 2);
    point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    point2 = new Point(width - (width / 2.3f), height - (height / 2.5f));
    makeInterpolatedSpaces(3, point1, point2, point3);

    // player 4, top right
    rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(4));
    point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(5) - 2);
    point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    point2 = new Point(width - (width / 4.3f), height / 2.0f);
    makeInterpolatedSpaces(4, point1, point2, point3);

    // player 5, bottom right
    rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(5));
    point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(0) - 2);
    point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
        rectangle.getY() + (rectangle.getHeight() / 2.0f));
    point2 = new Point(width - (width / 2.3f), height / 2.5f);
    makeInterpolatedSpaces(5, point1, point2, point3);

  }

  /**
   * Updates the board layout for ten players using the given width and height.
   *
   * @param width the width of the board
   * @param height the height of the board
   */
  protected void updateTenPlayers(float width, float height) {

    float gridSize = 16.0f;

    gridCellSize = Math.min(width / gridSize, height / gridSize);

    // player 0, bottom center
    float homeEntryCenterX = width / 2.0f;
    float homeEntryCenterY = height - (gridCellSize * 1.5f);
    float angle = (float) Math.PI / 2.0f;
    makePlayerSpaces(0, homeEntryCenterX, homeEntryCenterY, angle);

    // player 1, bottom left center
    homeEntryCenterX = 3.0f * width / 10.0f;
    homeEntryCenterY = height - (gridCellSize * 1.5f);
    angle = (float) Math.PI / 2.0f;
    makePlayerSpaces(1, homeEntryCenterX, homeEntryCenterY, angle);

    // player 2, bottom left corner
    homeEntryCenterX = gridCellSize * 2.45f;
    homeEntryCenterY = height - (gridCellSize * 1.95f);
    angle = (float) Math.PI / 2.5f;
    makePlayerSpaces(2, homeEntryCenterX, homeEntryCenterY, angle);

    // player 3, top left corner
    homeEntryCenterX = gridCellSize * 2.45f;
    homeEntryCenterY = gridCellSize * 1.95f;
    angle = 4.0f * (float) Math.PI / 2.5f;
    makePlayerSpaces(3, homeEntryCenterX, homeEntryCenterY, angle);

    // player 4, top left center
    homeEntryCenterX = 3.0f * width / 10.0f;
    homeEntryCenterY = gridCellSize * 1.5f;
    angle = 3.0f * (float) Math.PI / 2.0f;
    makePlayerSpaces(4, homeEntryCenterX, homeEntryCenterY, angle);

    // player 5, top center
    homeEntryCenterX = 5.0f * width / 10.0f;
    homeEntryCenterY = gridCellSize * 1.5f;
    angle = 3.0f * (float) Math.PI / 2.0f;
    makePlayerSpaces(5, homeEntryCenterX, homeEntryCenterY, angle);

    // player 6, top right center
    homeEntryCenterX = 7.0f * width / 10.0f;
    homeEntryCenterY = gridCellSize * 1.5f;
    angle = 3.0f * (float) Math.PI / 2.0f;
    makePlayerSpaces(6, homeEntryCenterX, homeEntryCenterY, angle);

    // player 7, top right corner
    homeEntryCenterX = width - (gridCellSize * 2.45f);
    homeEntryCenterY = gridCellSize * 1.95f;
    angle = 3.5f * (float) Math.PI / 2.5f;
    makePlayerSpaces(7, homeEntryCenterX, homeEntryCenterY, angle);

    // player 8, bottom right corner
    homeEntryCenterX = width - (gridCellSize * 2.45f);
    homeEntryCenterY = height - (gridCellSize * 1.95f);
    angle = 1.5f * (float) Math.PI / 2.5f;
    makePlayerSpaces(8, homeEntryCenterX, homeEntryCenterY, angle);

    // player 9, bottom right center
    homeEntryCenterX = 7.0f * width / 10.0f;
    homeEntryCenterY = height - (gridCellSize * 1.5f);
    angle = (float) Math.PI / 2.0f;
    makePlayerSpaces(9, homeEntryCenterX, homeEntryCenterY, angle);

    for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {

      // left side
      Rectangle rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(playerNumber));
      angle = boardIndexToAngleMap.get(board.getSafeBoardIndex(playerNumber));
      float spaceCenterX = rectangle.getX() + (rectangle.getWidth() / 2.0f);
      float spaceCenterY = rectangle.getY() + (rectangle.getHeight() / 2.0f);
      for (int offset = 1; offset <= 3; offset++) {
        float centerX = (float) (spaceCenterX + offset * gridCellSize * Math.cos(angle)
            + offset * 0.15f * gridCellSize * Math.cos(angle - Math.PI / 2.0f));
        float centerY = (float) (spaceCenterY - offset * gridCellSize * Math.sin(angle));
        boardIndexToBoundsMap.put(board.getSafeBoardIndex(playerNumber) + offset,
            new Rectangle(centerX - (gridCellSize / 2.0f), centerY - (gridCellSize / 2.0f),
                gridCellSize, gridCellSize));
        boardIndexToAngleMap.put(board.getSafeBoardIndex(playerNumber) + offset,
            angle - (float) Math.PI / 2.0f);
      }

      // right side
      rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(playerNumber) - 2);
      spaceCenterX = rectangle.getX() + (rectangle.getWidth() / 2.0f);
      spaceCenterY = rectangle.getY() + (rectangle.getHeight() / 2.0f);
      for (int offset = 1; offset <= 3; offset++) {
        float centerX = (float) (spaceCenterX + offset * gridCellSize * Math.cos(angle)
            + offset * 0.15f * gridCellSize * Math.cos(angle + Math.PI / 2.0f));
        float centerY = (float) (spaceCenterY - offset * gridCellSize * Math.sin(angle));
        boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(playerNumber) - 2 - offset,
            new Rectangle(centerX - (gridCellSize / 2.0f), centerY - (gridCellSize / 2.0f),
                gridCellSize, gridCellSize));
        boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(playerNumber) - 2 - offset,
            angle - (float) Math.PI / 2.0f);
      }

    }

    // connector spaces
    for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {

      if (playerNumber == 2 || playerNumber == 7) {

        angle = boardIndexToAngleMap.get(board.getSafeBoardIndex(playerNumber));
        Rectangle rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(playerNumber));
        Point point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
            rectangle.getY() + (rectangle.getHeight() / 2.0f));
        rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(
            (playerNumber + 1) % board.getNumberOfPlayers()) - 2);
        Point point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
            rectangle.getY() + (rectangle.getHeight() / 2.0f));
        Point point2 = new Point(width / 2.0f - width / 2.5f * (float) Math.sin(angle),
            height / 2.0f);
        makeInterpolatedSpaces(playerNumber, point1, point2, point3);

      } else {

        angle = boardIndexToAngleMap.get(board.getSafeBoardIndex(playerNumber));
        Rectangle rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(playerNumber) + 3);
        Point point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
            rectangle.getY() + (rectangle.getHeight() / 2.0f));
        rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(
            (playerNumber + 1) % board.getNumberOfPlayers()) - 5);
        Point point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
            rectangle.getY() + (rectangle.getHeight() / 2.0f));
        Point point2 = new Point((point1.getX() + point3.getX()) / 2.0f,
            height / 2.0f + height / 15.0f * (float) Math.sin(angle));
        makeInterpolatedSpaces(playerNumber, point1, point2, point3,
            board.getSafeBoardIndex(playerNumber) + 3, 5);

      }

    }

  }

  /**
   * Updates the board layout for twelve players using the given width and height.
   *
   * @param width the width of the board
   * @param height the height of the board
   */
  protected void updateTwelvePlayers(float width, float height) {

    float gridSize = 18.0f;

    gridCellSize = Math.min(width / gridSize, height / gridSize);

    // player 0
    float homeEntryCenterX = 5.0f * width / 12.0f;
    float homeEntryCenterY = height - (gridCellSize * 1.5f);
    float angle = (float) Math.PI / 2.0f;
    makePlayerSpaces(0, homeEntryCenterX, homeEntryCenterY, angle);

    // player 1
    homeEntryCenterX = 3.0f * width / 12.0f;
    homeEntryCenterY = height - (gridCellSize * 1.5f);
    angle = (float) Math.PI / 2.0f;
    makePlayerSpaces(1, homeEntryCenterX, homeEntryCenterY, angle);

    // player 2
    homeEntryCenterX = gridCellSize * 2.45f;
    homeEntryCenterY = height - (gridCellSize * 1.95f);
    angle = (float) Math.PI / 2.5f;
    makePlayerSpaces(2, homeEntryCenterX, homeEntryCenterY, angle);

    // player 3
    homeEntryCenterX = gridCellSize * 2.45f;
    homeEntryCenterY = gridCellSize * 1.95f;
    angle = 4.0f * (float) Math.PI / 2.5f;
    makePlayerSpaces(3, homeEntryCenterX, homeEntryCenterY, angle);

    // player 4
    homeEntryCenterX = 3.0f * width / 12.0f;
    homeEntryCenterY = gridCellSize * 1.5f;
    angle = 3.0f * (float) Math.PI / 2.0f;
    makePlayerSpaces(4, homeEntryCenterX, homeEntryCenterY, angle);

    // player 5
    homeEntryCenterX = 5.0f * width / 12.0f;
    homeEntryCenterY = gridCellSize * 1.5f;
    angle = 3.0f * (float) Math.PI / 2.0f;
    makePlayerSpaces(5, homeEntryCenterX, homeEntryCenterY, angle);

    // player 6
    homeEntryCenterX = 7.0f * width / 12.0f;
    homeEntryCenterY = gridCellSize * 1.5f;
    angle = 3.0f * (float) Math.PI / 2.0f;
    makePlayerSpaces(6, homeEntryCenterX, homeEntryCenterY, angle);

    // player 7
    homeEntryCenterX = 9.0f * width / 12.0f;
    homeEntryCenterY = gridCellSize * 1.5f;
    angle = 3.0f * (float) Math.PI / 2.0f;
    makePlayerSpaces(7, homeEntryCenterX, homeEntryCenterY, angle);

    // player 8
    homeEntryCenterX = width - (gridCellSize * 2.45f);
    homeEntryCenterY = gridCellSize * 1.95f;
    angle = 3.5f * (float) Math.PI / 2.5f;
    makePlayerSpaces(8, homeEntryCenterX, homeEntryCenterY, angle);

    // player 9
    homeEntryCenterX = width - (gridCellSize * 2.45f);
    homeEntryCenterY = height - (gridCellSize * 1.95f);
    angle = 1.5f * (float) Math.PI / 2.5f;
    makePlayerSpaces(9, homeEntryCenterX, homeEntryCenterY, angle);

    // player 10
    homeEntryCenterX = 9.0f * width / 12.0f;
    homeEntryCenterY = height - (gridCellSize * 1.5f);
    angle = (float) Math.PI / 2.0f;
    makePlayerSpaces(10, homeEntryCenterX, homeEntryCenterY, angle);

    // player 11
    homeEntryCenterX = 7.0f * width / 12.0f;
    homeEntryCenterY = height - (gridCellSize * 1.5f);
    angle = (float) Math.PI / 2.0f;
    makePlayerSpaces(11, homeEntryCenterX, homeEntryCenterY, angle);

    for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {

      // left side
      Rectangle rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(playerNumber));
      angle = boardIndexToAngleMap.get(board.getSafeBoardIndex(playerNumber));
      float spaceCenterX = rectangle.getX() + (rectangle.getWidth() / 2.0f);
      float spaceCenterY = rectangle.getY() + (rectangle.getHeight() / 2.0f);
      for (int offset = 1; offset <= 3; offset++) {
        float centerX = (float) (spaceCenterX + offset * gridCellSize * Math.cos(angle)
            + offset * 0.15f * gridCellSize * Math.cos(angle - Math.PI / 2.0f));
        float centerY = (float) (spaceCenterY - offset * gridCellSize * Math.sin(angle));
        boardIndexToBoundsMap.put(board.getSafeBoardIndex(playerNumber) + offset,
            new Rectangle(centerX - (gridCellSize / 2.0f), centerY - (gridCellSize / 2.0f),
                gridCellSize, gridCellSize));
        boardIndexToAngleMap.put(board.getSafeBoardIndex(playerNumber) + offset,
            angle - (float) Math.PI / 2.0f);
      }

      // right side
      rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(playerNumber) - 2);
      spaceCenterX = rectangle.getX() + (rectangle.getWidth() / 2.0f);
      spaceCenterY = rectangle.getY() + (rectangle.getHeight() / 2.0f);
      for (int offset = 1; offset <= 3; offset++) {
        float centerX = (float) (spaceCenterX + offset * gridCellSize * Math.cos(angle)
            + offset * 0.15f * gridCellSize * Math.cos(angle + Math.PI / 2.0f));
        float centerY = (float) (spaceCenterY - offset * gridCellSize * Math.sin(angle));
        boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(playerNumber) - 2 - offset,
            new Rectangle(centerX - (gridCellSize / 2.0f), centerY - (gridCellSize / 2.0f),
                gridCellSize, gridCellSize));
        boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(playerNumber) - 2 - offset,
            angle - (float) Math.PI / 2.0f);
      }

    }

    // connector spaces
    for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {

      if (playerNumber == 2 || playerNumber == 8) {

        angle = boardIndexToAngleMap.get(board.getSafeBoardIndex(playerNumber));
        Rectangle rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(playerNumber));
        Point point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
            rectangle.getY() + (rectangle.getHeight() / 2.0f));
        rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(
            (playerNumber + 1) % board.getNumberOfPlayers()) - 2);
        Point point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
            rectangle.getY() + (rectangle.getHeight() / 2.0f));
        Point point2 = new Point(width / 2.0f - width / 2.5f * (float) Math.sin(angle),
            height / 2.0f);
        makeInterpolatedSpaces(playerNumber, point1, point2, point3);

      } else {

        angle = boardIndexToAngleMap.get(board.getSafeBoardIndex(playerNumber));
        Rectangle rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(playerNumber) + 3);
        Point point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
            rectangle.getY() + (rectangle.getHeight() / 2.0f));
        rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(
            (playerNumber + 1) % board.getNumberOfPlayers()) - 5);
        Point point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
            rectangle.getY() + (rectangle.getHeight() / 2.0f));
        Point point2 = new Point((point1.getX() + point3.getX()) / 2.0f,
            height / 2.0f + height / 15.0f * (float) Math.sin(angle));
        makeInterpolatedSpaces(playerNumber, point1, point2, point3,
            board.getSafeBoardIndex(playerNumber) + 3, 5);

      }

    }

  }

  @Override
  public float getAngleForBoardIndex(int boardIndex) {
    Preconditions.checkArgument(boardIndex >= 0
        && boardIndex < board.getNumberOfPlayableSpaces(), "Invalid board index");
    return boardIndexToAngleMap.get(boardIndex);
  }

  @Override
  public Rectangle getBoundsForBoardIndex(int boardIndex) {
    Preconditions.checkArgument(boardIndex >= 0
        && boardIndex < board.getNumberOfPlayableSpaces(), "Invalid board index");
    return boardIndexToBoundsMap.get(boardIndex);
  }

  @Override
  public Rectangle getBoundsForCardDeck() {
    return cardDeckRectangle;
  }

  @Override
  public Rectangle getBoundsForDiscardPile() {
    return discardPileRectangle;
  }

  @Override
  @SuppressWarnings("PMD.ShortVariable")
  public Rectangle getBoundsForMarble(int boardIndex) {

    Rectangle rectangle = getBoundsForBoardIndex(boardIndex);
    float width = rectangle.getWidth() * MARBLE_SCALE_FACTOR;
    float height = rectangle.getHeight() * MARBLE_SCALE_FACTOR;
    float x = rectangle.getX() + (rectangle.getWidth() - width) / 2.0f;
    float y = rectangle.getY() + (rectangle.getHeight() - height) / 2.0f;

    return new Rectangle(x, y, width, height);

  }

  @Override
  @SuppressWarnings("PMD.ShortVariable")
  public Rectangle getBoundsForSpace(int boardIndex) {

    Rectangle rectangle = getBoundsForBoardIndex(boardIndex);
    float width = rectangle.getWidth() * SPACE_SCALE_FACTOR;
    float height = rectangle.getHeight() * SPACE_SCALE_FACTOR;
    float x = rectangle.getX() + (rectangle.getWidth() - width) / 2.0f;
    float y = rectangle.getY() + (rectangle.getHeight() - height) / 2.0f;

    return new Rectangle(x, y, width, height);

  }

  /**
   * The SmoothBezierInterpolator class is used to interpolate evenly distributed points along a
   * bezier curve.
   */
  protected static class SmoothBezierInterpolator {

    /**
     * The number of samples in the bezier curve.
     */
    protected static final int NUMBER_OF_SAMPLES = 100;
    /**
     * The distance from the starting point to each sampled point. The index into the array is the
     * point number and the value is the distance from the first control point to that point.
     */
    protected final transient float[] distances = new float[NUMBER_OF_SAMPLES + 1];
    /**
     * The x location for the first control point.
     */
    protected final transient float point1X;
    /**
     * The y location for the first control point.
     */
    protected final transient float point1Y;
    /**
     * The x location for the second control point.
     */
    protected final transient float point2X;
    /**
     * The y location for the second control point.
     */
    protected final transient float point2Y;
    /**
     * The x location for the third control point.
     */
    protected final transient float point3X;
    /**
     * The y location for the third control point.
     */
    protected final transient float point3Y;

    /**
     * Creates a new SmoothBezierInterpolator.
     *
     * @param point1X the x location of the first control point
     * @param point1Y the y location of the first control point
     * @param point2X the x location of the second control point
     * @param point2Y the y location of the second control point
     * @param point3X the x location of the third control point
     * @param point3Y the y location of the third control point
     */
    public SmoothBezierInterpolator(float point1X, float point1Y, float point2X, float point2Y,
        float point3X, float point3Y) {

      this.point1X = point1X;
      this.point1Y = point1Y;
      this.point2X = point2X;
      this.point2Y = point2Y;
      this.point3X = point3X;
      this.point3Y = point3Y;

      float distance = 0.0f;
      distances[0] = distance;

      float currentX;
      float currentY;
      float previousX = point1X;
      float previousY = point1Y;

      for (int i = 1; i <= NUMBER_OF_SAMPLES; i++) {
        float weight = (float) i / (float) NUMBER_OF_SAMPLES;
        currentX = bezier(point1X, point2X, point3X, weight);
        currentY = bezier(point1Y, point2Y, point3Y, weight);
        float deltaX = currentX - previousX;
        float deltaY = currentY - previousY;
        distance += Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        distances[i] = distance;
        previousX = currentX;
        previousY = currentY;
      }

    }

    /**
     * Returns the point on the bezier curve using the given control points and weight t.
     *
     * @param point1 the first control point
     * @param point2 the second control point
     * @param point3 the third control point
     * @param t the weight on the curve
     * @return the point on the bezier curve using the given control points and weight t
     */
    @SuppressWarnings("PMD.ShortVariable")
    protected final float bezier(float point1, float point2, float point3, float t) {
      return (1.0f - t) * (1.0f - t) * point1
          + 2.0f * (1.0f - t) * t * point2
          + t * t * point3;
    }

    /**
     * Returns the interpolated point using the given control points and given weight.
     *
     * @param point1 the first control point
     * @param point2 the second control point
     * @param point3 the third control point
     * @param weight the weight on the bezier curve
     * @return the interpolated point using the given control points and given weight
     */
    protected float interpolate(float point1, float point2, float point3, float weight) {

      float targetLength = weight * distances[NUMBER_OF_SAMPLES];

      int low = 0;
      int high = NUMBER_OF_SAMPLES;
      int index = 0;
      while (low < high) {
        index = low + (((high - low) / 2));
        if (distances[index] < targetLength) {
          low = index + 1;
        } else {
          high = index;
        }
      }
      if (distances[index] > targetLength) {
        index--;
      }

      float lengthBefore = distances[index];
      float newWeight;
      if (lengthBefore == targetLength) {
        newWeight = (float) index / (float) NUMBER_OF_SAMPLES;
      } else {
        newWeight = (index + (targetLength - lengthBefore) / (distances[index + 1] - lengthBefore))
            / NUMBER_OF_SAMPLES;
      }

      return bezier(point1, point2, point3, newWeight);

    }

    /**
     * Returns the interpolated x point using the given weight.
     *
     * @param weight the weight on the curve
     * @return the interpolated x point using the given weight
     */
    public float interpolateX(float weight) {
      return interpolate(point1X, point2X, point3X, weight);
    }

    /**
     * Returns the interpolated y point using the given weight
     *
     * @param weight the weight on the curve
     * @return the interpolated y point using the given weight
     */
    public float interpolateY(float weight) {
      return interpolate(point1Y, point2Y, point3Y, weight);
    }

  }

}
