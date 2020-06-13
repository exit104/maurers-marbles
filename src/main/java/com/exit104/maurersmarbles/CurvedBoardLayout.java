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
   * The number of interpolated spaces in between each player's row of spaces and the next player's
   * row of spaces.
   */
  protected static final int NUMBER_OF_INTERPOLATED_SPACES = 11;
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

    // TODO preconditions?
    SmoothBezierInterpolator interpolator = new SmoothBezierInterpolator(
        point1.getX(), point1.getY(),
        point2.getX(), point2.getY(),
        point3.getX(), point3.getY());

    for (int i = 0; i < NUMBER_OF_INTERPOLATED_SPACES; i++) {

      float weight = (float) i / (float) (NUMBER_OF_INTERPOLATED_SPACES - 1);
      float centerX = interpolator.interpolateX(weight);
      float centerY = interpolator.interpolateY(weight);
      boardIndexToBoundsMap.put(board.getSafeBoardIndex(playerNumber) + i,
          new Rectangle(centerX - (gridCellSize / 2.0f), centerY - (gridCellSize / 2.0f),
              gridCellSize, gridCellSize));

      float angleFrom = boardIndexToAngleMap.get(board.getHomeEntryBoardIndex(playerNumber));
      float angleTo = boardIndexToAngleMap.get(board.getHomeEntryBoardIndex((playerNumber + 1)
          % board.getNumberOfPlayers()));
      // interpolate to find the angle for this space
      float angle = (float) (((angleTo - angleFrom) + (Math.PI * 3.0f)) % (Math.PI * 2.0f)
          - Math.PI);
      // calculate the shortest angle path so the space doesn't spin in a circle
      angle = angleFrom + angle * ((float) i / (float) (NUMBER_OF_INTERPOLATED_SPACES - 1));
      boardIndexToAngleMap.put(board.getSafeBoardIndex(playerNumber) + i, angle);

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
  protected void makePlayerSpaces(int playerNumber, float homeEntryCenterX, float homeEntryCenterY,
      float angle) {

    // TODO preconditions?
    // spaces along the player's home entry
    for (int offset = -2; offset <= 2; offset++) {
      float centerX = (float) (homeEntryCenterX + (offset * gridCellSize * Math.cos(angle)));
      float centerY = (float) (homeEntryCenterY + (offset * gridCellSize * Math.sin(angle)));
      if (offset == -2) {
        boardIndexToBoundsMap.put(board.getSafeBoardIndex(playerNumber),
            new Rectangle(centerX - (gridCellSize / 2.0f), centerY - (gridCellSize / 2.0f),
                gridCellSize, gridCellSize));
        boardIndexToAngleMap.put(board.getSafeBoardIndex(playerNumber), angle
            - (float) Math.PI / 2.0f);
      } else {
        boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(playerNumber) - offset,
            new Rectangle(centerX - (gridCellSize / 2.0f), centerY - (gridCellSize / 2.0f),
                gridCellSize, gridCellSize));
        boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(playerNumber) - offset,
            angle - (float) Math.PI / 2.0f);
      }
    }

    // home spaces
    for (int offset = 0; offset < 4; offset++) {
      float centerX = (float) (homeEntryCenterX - ((1 + offset) * gridCellSize
          * Math.cos(angle + (Math.PI / 2.0f))));
      float centerY = (float) (homeEntryCenterY - ((1 + offset) * gridCellSize
          * Math.sin(angle + (Math.PI / 2.0f))));
      boardIndexToBoundsMap.put(board.getHomeMinBoardIndex(playerNumber) + offset,
          new Rectangle(centerX - (gridCellSize / 2.0f), centerY - (gridCellSize / 2.0f),
              gridCellSize, gridCellSize));
      boardIndexToAngleMap.put(board.getHomeMinBoardIndex(playerNumber) + offset,
          angle - (float) Math.PI / 2.0f);
    }

    // start spaces
    float startCenterX = (float) (homeEntryCenterX + (-1.5 * gridCellSize * Math.cos(angle))
        + (gridCellSize * Math.cos(angle + Math.PI / 2.0f)));
    float startCenterY = (float) (homeEntryCenterY + (-1.5 * gridCellSize * Math.sin(angle))
        + (gridCellSize * Math.sin(angle + Math.PI / 2.0f)));
    for (int offset = 0; offset < 4; offset++) {
      float centerX = (float) (startCenterX + (offset * gridCellSize * Math.cos(angle)));
      float centerY = (float) (startCenterY + (offset * gridCellSize * Math.sin(angle)));
      boardIndexToBoundsMap.put(board.getStartMinBoardIndex(playerNumber) + offset,
          new Rectangle(centerX - (gridCellSize / 2.0f), centerY - (gridCellSize / 2.0f),
              gridCellSize, gridCellSize));
      boardIndexToAngleMap.put(board.getStartMinBoardIndex(playerNumber) + offset,
          angle - (float) Math.PI / 2.0f);
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
    float gridSize;

    switch (board.getNumberOfPlayers()) {

      case 4:

        gridSize = 13.0f;
        gridCellSize = Math.min(width / gridSize, height / gridSize);

        for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {

          // define the center point for the player's home entry space
          float homeEntryCenterX = 0.0f;
          float homeEntryCenterY = 0.0f;
          switch (playerNumber) {
            case 0:
              // bottom
              homeEntryCenterX = width / 2.0f;
              homeEntryCenterY = height - (gridCellSize * 1.5f);
              break;
            case 1:
              // left
              homeEntryCenterX = gridCellSize * 1.5f;
              homeEntryCenterY = height / 2.0f;
              break;
            case 2:
              // top
              homeEntryCenterX = width / 2.0f;
              homeEntryCenterY = gridCellSize * 1.5f;
              break;
            case 3:
              // right
              homeEntryCenterX = width - (gridCellSize * 1.5f);
              homeEntryCenterY = height / 2.0f;
              break;
            default:
              throw new IllegalStateException("Invalid player number: " + playerNumber);
          }

          float angle = (float) (2.0 * Math.PI * ((float) playerNumber
              / (float) board.getNumberOfPlayers()));

          makePlayerSpaces(playerNumber, homeEntryCenterX, homeEntryCenterY, angle);

        }

        for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {

          // current player's safe space
          Rectangle rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(playerNumber));
          Point point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
              rectangle.getY() + (rectangle.getHeight() / 2.0f));
          // next player's right most space along the home entry spaces
          rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex((playerNumber + 1)
              % board.getNumberOfPlayers()) - 2);
          Point point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
              rectangle.getY() + (rectangle.getHeight() / 2.0f));

          // define the middle control point for the bezier curve
          Point point2 = null;
          switch (playerNumber) {
            case 0:
              point2 = new Point(point1.getX(), point3.getY());
              break;
            case 1:
              point2 = new Point(point3.getX(), point1.getY());
              break;
            case 2:
              point2 = new Point(point1.getX(), point3.getY());
              break;
            case 3:
              point2 = new Point(point3.getX(), point1.getY());
              break;
            default:
              throw new IllegalStateException("Invalid player number: " + playerNumber);
          }

          makeInterpolatedSpaces(playerNumber, point1, point2, point3);

        }

        break;

      case 6:

        gridSize = 18.0f;
        gridCellSize = Math.min(width / gridSize, height / gridSize);

        for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {

          // define the center point for the player's home entry space
          float homeEntryCenterX = 0.0f;
          float homeEntryCenterY = 0.0f;
          float angle = 0.0f;
          switch (playerNumber) {
            case 0:
              if (width > height) {
                // bottom left
                homeEntryCenterX = width / 3.0f;
                homeEntryCenterY = height - (gridCellSize * 1.5f);
                angle = (float) (2.0 * Math.PI);
              } else {
                // bottom
                homeEntryCenterX = width / 2.0f;
                homeEntryCenterY = height - (gridCellSize * 1.5f);
                angle = (float) (2.0 * Math.PI);
              }
              break;
            case 1:
              if (width > height) {
                // left
                homeEntryCenterX = gridCellSize * 1.5f;
                homeEntryCenterY = height / 2.0f;
                angle = (float) (2.0 * Math.PI * 0.25f);
              } else {
                // left bottom
                homeEntryCenterX = gridCellSize * 1.5f;
                homeEntryCenterY = height / 3.0f * 2.0f;
                angle = (float) (2.0 * Math.PI * 0.25f);
              }
              break;
            case 2:
              if (width > height) {
                // top left
                homeEntryCenterX = width / 3.0f;
                homeEntryCenterY = gridCellSize * 1.5f;
                angle = (float) (2.0 * Math.PI * 0.5f);
              } else {
                // left top
                homeEntryCenterX = gridCellSize * 1.5f;
                homeEntryCenterY = height / 3.0f;
                angle = (float) (2.0 * Math.PI * 0.25f);
              }
              break;
            case 3:
              if (width > height) {
                // top right
                homeEntryCenterX = width / 3.0f * 2.0f;
                homeEntryCenterY = gridCellSize * 1.5f;
                angle = (float) (2.0 * Math.PI * 0.5f);
              } else {
                // top
                homeEntryCenterX = width / 2.0f;
                homeEntryCenterY = gridCellSize * 1.5f;
                angle = (float) (2.0 * Math.PI * 0.5f);
              }
              break;
            case 4:
              if (width > height) {
                // right
                homeEntryCenterX = width - (gridCellSize * 1.5f);
                homeEntryCenterY = height / 2.0f;
                angle = (float) (2.0 * Math.PI * 0.75f);
              } else {
                // right top
                homeEntryCenterX = width - (gridCellSize * 1.5f);
                homeEntryCenterY = height / 3.0f;
                angle = (float) (2.0 * Math.PI * 0.75f);
              }
              break;
            case 5:
              if (width > height) {
                // bottom right
                homeEntryCenterX = width / 3.0f * 2.0f;
                homeEntryCenterY = height - (gridCellSize * 1.5f);
                angle = (float) (2.0 * Math.PI);
              } else {
                // right bottom
                homeEntryCenterX = width - (gridCellSize * 1.5f);
                homeEntryCenterY = height / 3.0f * 2.0f;
                angle = (float) (2.0 * Math.PI) * 0.75f;
              }
              break;
            default:
              throw new IllegalStateException("Invalid player number: " + playerNumber);
          }

          makePlayerSpaces(playerNumber, homeEntryCenterX, homeEntryCenterY, angle);

        }

        for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {

          // current player's safe space
          Rectangle rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(playerNumber));
          Point point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
              rectangle.getY() + (rectangle.getHeight() / 2.0f));
          // next player's right most space along the home entry spaces
          rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex((playerNumber + 1)
              % board.getNumberOfPlayers()) - 2);
          Point point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
              rectangle.getY() + (rectangle.getHeight() / 2.0f));

          // define the middle control point for the bezier curve
          Point point2 = null;
          switch (playerNumber) {
            case 0:
              // bottom
              point2 = new Point(point1.getX(), point3.getY());
              break;
            case 1:
              if (width > height) {
                // left top
                point2 = new Point(point3.getX(), point1.getY());
              } else {
                // left bottom
                point2 = new Point(width / 2.0f, (point1.getY() + point3.getY()) / 2.0f);
              }
              break;
            case 2:
              if (width > height) {
                // top left
                point2 = new Point((point1.getX() + point3.getX()) / 2.0f, height / 2.0f);
              } else {
                // left top
                point2 = new Point(point3.getX(), point1.getY());
              }
              break;
            case 3:
              // top
              point2 = new Point(point1.getX(), point3.getY());
              break;
            case 4:
              if (width > height) {
                // right
                point2 = new Point(point3.getX(), point1.getY());
              } else {
                // right top
                point2 = new Point(width / 2.0f, (point1.getY() + point3.getY()) / 2.0f);
              }
              break;
            case 5:
              if (width > height) {
                // bottom right
                point2 = new Point((point1.getX() + point3.getX()) / 2.0f, height / 2.0f);
              } else {
                // right bottom
                point2 = new Point(point3.getX(), point1.getY());
              }
              break;
            default:
              throw new IllegalStateException("Invalid player number: " + playerNumber);
          }

          makeInterpolatedSpaces(playerNumber, point1, point2, point3);

        }

        break;

      case 8:

        gridSize = 22.0f;
        gridCellSize = Math.min(width / gridSize, height / gridSize);

        for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {

          // define the center point for the player's home entry space
          float homeEntryCenterX = 0.0f;
          float homeEntryCenterY = 0.0f;
          float angle = 0.0f;
          switch (playerNumber) {
            case 0:
              // bottom left
              homeEntryCenterX = width / 3.0f;
              homeEntryCenterY = height - (gridCellSize * 1.5f);
              angle = (float) (2.0 * Math.PI);
              break;
            case 1:
              // left bottom
              homeEntryCenterX = gridCellSize * 1.5f;
              homeEntryCenterY = height / 3.0f * 2.0f;
              angle = (float) (2.0 * Math.PI * 0.25f);
              break;
            case 2:
              // left top
              homeEntryCenterX = gridCellSize * 1.5f;
              homeEntryCenterY = height / 3.0f;
              angle = (float) (2.0 * Math.PI * 0.25f);
              break;
            case 3:
              // top left
              homeEntryCenterX = width / 3.0f;
              homeEntryCenterY = gridCellSize * 1.5f;
              angle = (float) (2.0 * Math.PI * 0.5f);
              break;
            case 4:
              // top right
              homeEntryCenterX = width / 3.0f * 2.0f;
              homeEntryCenterY = gridCellSize * 1.5f;
              angle = (float) (2.0 * Math.PI * 0.5f);
              break;
            case 5:
              // right top
              homeEntryCenterX = width - (gridCellSize * 1.5f);
              homeEntryCenterY = height / 3.0f;
              angle = (float) (2.0 * Math.PI * 0.75f);
              break;
            case 6:
              // right bottom
              homeEntryCenterX = width - (gridCellSize * 1.5f);
              homeEntryCenterY = height / 3.0f * 2.0f;
              angle = (float) (2.0 * Math.PI * 0.75f);
              break;
            case 7:
              // bottom right
              homeEntryCenterX = width / 3.0f * 2.0f;
              homeEntryCenterY = height - (gridCellSize * 1.5f);
              angle = (float) (2.0 * Math.PI);
              break;
            default:
              throw new IllegalStateException("Invalid player number: " + playerNumber);
          }

          makePlayerSpaces(playerNumber, homeEntryCenterX, homeEntryCenterY, angle);

        }

        for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {

          // current player's safe space
          Rectangle rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(playerNumber));
          Point point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
              rectangle.getY() + (rectangle.getHeight() / 2.0f));
          // next player's right most space along the home entry spaces
          rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex((playerNumber + 1)
              % board.getNumberOfPlayers()) - 2);
          Point point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
              rectangle.getY() + (rectangle.getHeight() / 2.0f));

          // define the middle control point for the bezier curve
          Point point2 = null;
          switch (playerNumber) {
            case 0:
              // bottom left
              point2 = new Point(point1.getX(), point3.getY());
              break;
            case 1:
              // left bottom
              point2 = new Point(width / 3.0f, (point1.getY() + point3.getY()) / 2.0f);
              break;
            case 2:
              // left top
              point2 = new Point(point3.getX(), point1.getY());
              break;
            case 3:
              // top left
              point2 = new Point((point1.getX() + point3.getX()) / 2.0f, height / 3.0f);
              break;
            case 4:
              // top right
              point2 = new Point(point1.getX(), point3.getY());
              break;
            case 5:
              // right top
              point2 = new Point(width / 3.0f * 2.0f, (point1.getY() + point3.getY()) / 2.0f);
              break;
            case 6:
              // right bottom
              point2 = new Point(point3.getX(), point1.getY());
              break;
            case 7:
              // bottom right
              point2 = new Point((point1.getX() + point3.getX()) / 2.0f, height / 3.0f * 2.0f);
              break;
            default:
              throw new IllegalStateException("Invalid player number: " + playerNumber);
          }

          makeInterpolatedSpaces(playerNumber, point1, point2, point3);

        }

        break;

      case 10:

        gridSize = 26.0f;
        gridCellSize = Math.min(width / gridSize, height / gridSize);

        for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {

          // define the center point for the player's home entry space
          float homeEntryCenterX = 0.0f;
          float homeEntryCenterY = 0.0f;
          float angle = 0.0f;
          switch (playerNumber) {
            case 0:
              if (width > height) {
                // bottom center
                homeEntryCenterX = width / 2.0f;
                homeEntryCenterY = height - (gridCellSize * 1.5f);
                angle = (float) (2.0 * Math.PI);
              } else {
                // bottom left
                homeEntryCenterX = width / 3.0f;
                homeEntryCenterY = height - (gridCellSize * 1.5f);
                angle = (float) (2.0 * Math.PI);
              }
              break;
            case 1:
              if (width > height) {
                // bottom left
                homeEntryCenterX = width / 4.0f;
                homeEntryCenterY = height - (gridCellSize * 1.5f);
                angle = (float) (2.0 * Math.PI);
              } else {
                // left bottom
                homeEntryCenterX = gridCellSize * 1.5f;
                homeEntryCenterY = height / 4.0f * 3.0f;
                angle = (float) (2.0 * Math.PI * 0.25f);
              }
              break;
            case 2:
              if (width > height) {
                // left bottom
                homeEntryCenterX = gridCellSize * 1.5f;
                homeEntryCenterY = height / 3.0f * 2.0f;
                angle = (float) (2.0 * Math.PI * 0.25f);
              } else {
                // left center
                homeEntryCenterX = gridCellSize * 1.5f;
                homeEntryCenterY = height / 2.0f;
                angle = (float) (2.0 * Math.PI * 0.25f);
              }
              break;
            case 3:
              if (width > height) {
                // left top
                homeEntryCenterX = gridCellSize * 1.5f;
                homeEntryCenterY = height / 3.0f;
                angle = (float) (2.0 * Math.PI * 0.25f);
              } else {
                // left top
                homeEntryCenterX = gridCellSize * 1.5f;
                homeEntryCenterY = height / 4.0f;
                angle = (float) (2.0 * Math.PI * 0.25f);
              }
              break;
            case 4:
              if (width > height) {
                // top left
                homeEntryCenterX = width / 4.0f;
                homeEntryCenterY = gridCellSize * 1.5f;
                angle = (float) (2.0 * Math.PI * 0.5f);
              } else {
                // top left
                homeEntryCenterX = width / 3.0f;
                homeEntryCenterY = gridCellSize * 1.5f;
                angle = (float) (2.0 * Math.PI * 0.5f);
              }
              break;
            case 5:
              if (width > height) {
                // top center
                homeEntryCenterX = width / 2.0f;
                homeEntryCenterY = gridCellSize * 1.5f;
                angle = (float) (2.0 * Math.PI * 0.5f);
              } else {
                // top right
                homeEntryCenterX = width / 3.0f * 2.0f;
                homeEntryCenterY = gridCellSize * 1.5f;
                angle = (float) (2.0 * Math.PI * 0.5f);
              }
              break;
            case 6:
              if (width > height) {
                // top right
                homeEntryCenterX = width / 4.0f * 3.0f;
                homeEntryCenterY = gridCellSize * 1.5f;
                angle = (float) (2.0 * Math.PI * 0.5f);
              } else {
                // right top
                homeEntryCenterX = width - (gridCellSize * 1.5f);
                homeEntryCenterY = height / 4.0f;
                angle = (float) (2.0 * Math.PI * 0.75f);
              }
              break;
            case 7:
              if (width > height) {
                // right top
                homeEntryCenterX = width - (gridCellSize * 1.5f);
                homeEntryCenterY = height / 3.0f;
                angle = (float) (2.0 * Math.PI * 0.75f);
              } else {
                // right center
                homeEntryCenterX = width - (gridCellSize * 1.5f);
                homeEntryCenterY = height / 4.0f * 2.0f;
                angle = (float) (2.0 * Math.PI * 0.75f);
              }
              break;
            case 8:
              if (width > height) {
                // right bottom
                homeEntryCenterX = width - (gridCellSize * 1.5f);
                homeEntryCenterY = height / 3.0f * 2.0f;
                angle = (float) (2.0 * Math.PI * 0.75f);
              } else {
                // right bottom
                homeEntryCenterX = width - (gridCellSize * 1.5f);
                homeEntryCenterY = height / 4.0f * 3.0f;
                angle = (float) (2.0 * Math.PI * 0.75f);
              }
              break;
            case 9:
              if (width > height) {
                // bottom right
                homeEntryCenterX = width / 4.0f * 3.0f;
                homeEntryCenterY = height - (gridCellSize * 1.5f);
                angle = (float) (2.0 * Math.PI);
              } else {
                // bottom right
                homeEntryCenterX = width / 3.0f * 2.0f;
                homeEntryCenterY = height - (gridCellSize * 1.5f);
                angle = (float) (2.0 * Math.PI);
              }
              break;
            default:
              throw new IllegalStateException("Invalid player number: " + playerNumber);

          }

          makePlayerSpaces(playerNumber, homeEntryCenterX, homeEntryCenterY, angle);

        }

        for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {

          // current player's safe space
          Rectangle rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(playerNumber));
          Point point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
              rectangle.getY() + (rectangle.getHeight() / 2.0f));
          // next player's right most space along the home entry spaces
          rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex((playerNumber + 1)
              % board.getNumberOfPlayers()) - 2);
          Point point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
              rectangle.getY() + (rectangle.getHeight() / 2.0f));

          // define the middle control point for the bezier curve
          Point point2 = null;
          float center = Math.min(width / 2.0f, height / 2.0f);
          switch (playerNumber) {
            case 0:
              if (width > height) {
                // bottom center
                point2 = new Point((point1.getX() + point3.getX()) / 2.0f, height - center);
              } else {
                // bottom left
                point2 = new Point(point1.getX(), point3.getY());
              }
              break;
            case 1:
              if (width > height) {
                // bottom left
                point2 = new Point(point1.getX(), point3.getY());
              } else {
                point2 = new Point(center, (point1.getY() + point3.getY()) / 2.0f);
              }
              break;
            case 2:
              // left bottom
              point2 = new Point(center, (point1.getY() + point3.getY()) / 2.0f);
              break;
            case 3:
              // left top
              point2 = new Point(point3.getX(), point1.getY());
              break;
            case 4:
              // top left
              point2 = new Point((point1.getX() + point3.getX()) / 2.0f, center);
              break;
            case 5:
              if (width > height) {
                // top center
                point2 = new Point((point1.getX() + point3.getX()) / 2.0f, center);
              } else {
                // top right
                point2 = new Point(point1.getX(), point3.getY());
              }
              break;
            case 6:
              if (width > height) {
                // top right
                point2 = new Point(point1.getX(), point3.getY());
              } else {
                // right top
                point2 = new Point(width - center, (point1.getY() + point3.getY()) / 2.0f);
              }
              break;
            case 7:
              // right top
              point2 = new Point(width - center, (point1.getY() + point3.getY()) / 2.0f);
              break;
            case 8:
              // right bottom
              point2 = new Point(point3.getX(), point1.getY());
              break;
            case 9:
              // bottom right
              point2 = new Point((point1.getX() + point3.getX()) / 2.0f, height - center);
              break;
            default:
              throw new IllegalStateException("Invalid player number: " + playerNumber);
          }

          makeInterpolatedSpaces(playerNumber, point1, point2, point3);

        }

        break;

      case 12:

        gridSize = 28.0f;
        gridCellSize = Math.min(width / gridSize, height / gridSize);

        for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {

          // define the center point for the player's home entry space
          float homeEntryCenterX = 0.0f;
          float homeEntryCenterY = 0.0f;
          float angle = 0.0f;
          switch (playerNumber) {
            case 0:
              // bottom center
              homeEntryCenterX = width / 2.0f;
              homeEntryCenterY = height - (gridCellSize * 1.5f);
              angle = (float) (2.0 * Math.PI);
              break;
            case 1:
              // bottom left
              homeEntryCenterX = width / 4.0f;
              homeEntryCenterY = height - (gridCellSize * 1.5f);
              angle = (float) (2.0 * Math.PI);
              break;
            case 2:
              // left bottom
              homeEntryCenterX = gridCellSize * 1.5f;
              homeEntryCenterY = height / 4.0f * 3.0f;
              angle = (float) (2.0 * Math.PI * 0.25f);
              break;
            case 3:
              // left center
              homeEntryCenterX = gridCellSize * 1.5f;
              homeEntryCenterY = height / 2.0f;
              angle = (float) (2.0 * Math.PI * 0.25f);
              break;
            case 4:
              // left top
              homeEntryCenterX = gridCellSize * 1.5f;
              homeEntryCenterY = height / 4.0f;
              angle = (float) (2.0 * Math.PI * 0.25f);
              break;
            case 5:
              // top left
              homeEntryCenterX = width / 4.0f;
              homeEntryCenterY = gridCellSize * 1.5f;
              angle = (float) (2.0 * Math.PI * 0.5f);
              break;
            case 6:
              // top center
              homeEntryCenterX = width / 2.0f;
              homeEntryCenterY = gridCellSize * 1.5f;
              angle = (float) (2.0 * Math.PI * 0.5f);
              break;
            case 7:
              // top right
              homeEntryCenterX = width / 4.0f * 3.0f;
              homeEntryCenterY = gridCellSize * 1.5f;
              angle = (float) (2.0 * Math.PI * 0.5f);
              break;
            case 8:
              // right top
              homeEntryCenterX = width - (gridCellSize * 1.5f);
              homeEntryCenterY = height / 4.0f;
              angle = (float) (2.0 * Math.PI * 0.75f);
              break;
            case 9:
              // right center
              homeEntryCenterX = width - (gridCellSize * 1.5f);
              homeEntryCenterY = height / 2.0f;
              angle = (float) (2.0 * Math.PI * 0.75f);
              break;
            case 10:
              // right bottom
              homeEntryCenterX = width - (gridCellSize * 1.5f);
              homeEntryCenterY = height / 4.0f * 3.0f;
              angle = (float) (2.0 * Math.PI * 0.75f);
              break;
            case 11:
              // bottom right
              homeEntryCenterX = width / 4.0f * 3.0f;
              homeEntryCenterY = height - (gridCellSize * 1.5f);
              angle = (float) (2.0 * Math.PI);
              break;
            default:
              throw new IllegalStateException("Invalid player number: " + playerNumber);

          }

          makePlayerSpaces(playerNumber, homeEntryCenterX, homeEntryCenterY, angle);

        }

        for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {

          // current player's safe space
          Rectangle rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(playerNumber));
          Point point1 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
              rectangle.getY() + (rectangle.getHeight() / 2.0f));
          // next player's right most space along the home entry spaces
          rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex((playerNumber + 1)
              % board.getNumberOfPlayers()) - 2);
          Point point3 = new Point(rectangle.getX() + (rectangle.getWidth() / 2.0f),
              rectangle.getY() + (rectangle.getHeight() / 2.0f));

          // define the middle control point for the bezier curve
          Point point2 = null;
          float center = Math.min(width / 2.0f, height / 2.0f);
          switch (playerNumber) {
            case 0:
              // bottom center
              point2 = new Point((point1.getX() + point3.getX()) / 2.0f, height - center);
              break;
            case 1:
              // bottom left
              point2 = new Point(point1.getX(), point3.getY());
              break;
            case 2:
              // left bottom
              point2 = new Point(center, (point1.getY() + point3.getY()) / 2.0f);
              break;
            case 3:
              // left center
              point2 = new Point(center, (point1.getY() + point3.getY()) / 2.0f);
              break;
            case 4:
              // left top
              point2 = new Point(point3.getX(), point1.getY());
              break;
            case 5:
              // top left
              point2 = new Point((point1.getX() + point3.getX()) / 2.0f, center);
              break;
            case 6:
              // top center
              point2 = new Point((point1.getX() + point3.getX()) / 2.0f, center);
              break;
            case 7:
              // top right
              point2 = new Point(point1.getX(), point3.getY());
              break;
            case 8:
              // right top
              point2 = new Point(width - center, (point1.getY() + point3.getY()) / 2.0f);
              break;
            case 9:
              // right center
              point2 = new Point(width - center, (point1.getY() + point3.getY()) / 2.0f);
              break;
            case 10:
              // right bottom
              point2 = new Point(point3.getX(), point1.getY());
              break;
            case 11:
              // bottom right
              point2 = new Point((point1.getX() + point3.getX()) / 2.0f, height - center);
              break;
            default:
              throw new IllegalStateException("Invalid player number: " + playerNumber);
          }

          makeInterpolatedSpaces(playerNumber, point1, point2, point3);

        }

        break;

      default:
        throw new IllegalStateException("Invalid player number: " + board.getNumberOfPlayers());

    }

    // calculate the size of a card on the board based using the grid size
    float cardWidth = Card.WIDTH * gridCellSize * CARD_SCALE_FACTOR;
    float cardHeight = Card.HEIGHT * gridCellSize * CARD_SCALE_FACTOR;
    discardPileRectangle = new Rectangle(width / 2.0f - cardWidth / 2.0f, height / 2.0f
        - cardHeight / 2.0f, cardWidth, cardHeight);

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
