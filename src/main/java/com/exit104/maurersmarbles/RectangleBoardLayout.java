/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import com.google.common.base.Preconditions;

import java.util.Map;
import java.util.TreeMap;

/**
 * The RectangleBoardLayout class implements the BoardLayout interface to provide a dynamic board
 * layout that spans the perimeter of the screen.
 *
 * @author Daniel Uppenkamp
 */
public class RectangleBoardLayout implements BoardLayout {

  /**
   * The board for the layout.
   */
  protected final transient Board board;
  /**
   * The card scale factor relative to the size of a grid cell.
   */
  protected static final float CARD_SCALE_FACTOR = 0.5f;
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
   * The bounds for the discard pile on the board.
   */
  protected transient Rectangle discardPileRectangle;

  /**
   * Creates a new RectangleBoardLayout for the given board. By default, the width and height of the
   * board layout is defined to be a unit square (1.0 x 1.0).
   *
   * @param board the board
   * @throws NullPointerException if the given board is null
   */
  public RectangleBoardLayout(Board board) {
    Preconditions.checkNotNull(board, "Null board");
    this.board = board;
    update(1.0f, 1.0f);
  }

  /**
   * Updates the board layout using the given width and height.
   *
   * @param width the width of the board
   * @param height the height of the board
   */
  public final void update(float width, float height) {

    // calculate the distance for the perimeter spaces
    float totalDistance = width / 2.0f + height / 2.0f;
    int spacesPerPlayer = board.getNumberOfPerimeterSpaces() / board.getNumberOfPlayers() + 1;
    float distancePerPlayer = totalDistance / spacesPerPlayer;

    // calculate the best row/col split to fill the screen
    int numberOfRows;
    int numberOfColumns;
    if (width > height) {
      numberOfRows = (int) ((height / 2.0f) / distancePerPlayer) + 1;
      numberOfRows = Math.max(3, numberOfRows);
      numberOfColumns = spacesPerPlayer - numberOfRows;
    } else {
      numberOfColumns = (int) ((width / 2.0f) / distancePerPlayer);
      numberOfColumns = Math.max(2, numberOfColumns);
      numberOfRows = spacesPerPlayer - numberOfColumns;
    }

    // calculate the grid cell size based on the number of rows and columns
    gridCellSize = Math.min(height / (numberOfRows * 2 + 1), width / (numberOfColumns * 2 + 3));

    float xSpacing = (width / 2.0f - gridCellSize * 1.5f) / numberOfColumns;
    float ySpacing = (height / 2.0f - gridCellSize / 2.0f) / numberOfRows;

    // player 0 / player 2
    for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber += 2) {

      float angle = (float) (2.0 * Math.PI * ((float) playerNumber
          / (float) board.getNumberOfPlayers()));

      for (int i = 1; i < numberOfRows - 1; i++) {
        float centerX = width / 2.0f - (float) Math.cos(angle) * width / 2.0f - gridCellSize * 1.5f;
        float centerY = height / 2.0f + (float) Math.cos(angle) * height / 2.0f
            - gridCellSize * 1.5f - ySpacing * i;
        int boardIndex = (board.getHomeEntryBoardIndex(playerNumber) + i + numberOfColumns)
            % board.getNumberOfPerimeterSpaces();
        boardIndexToBoundsMap.put(boardIndex, new Rectangle(
            centerX - (gridCellSize / 2.0f), centerY - (gridCellSize / 2.0f), gridCellSize,
            gridCellSize));
        boardIndexToAngleMap.put(boardIndex, angle);
      }

      for (int i = 0; i <= numberOfColumns; i++) {
        float centerX = width / 2.0f + (float) Math.cos(angle) * -xSpacing * i;
        float centerY = height / 2.0f + (float) Math.cos(angle) * height / 2.0f
            - gridCellSize * 1.5f;
        int boardIndex = (board.getHomeEntryBoardIndex(playerNumber) + i)
            % board.getNumberOfPerimeterSpaces();
        boardIndexToBoundsMap.put(boardIndex, new Rectangle(
            centerX - (gridCellSize / 2.0f), centerY - (gridCellSize / 2.0f), gridCellSize,
            gridCellSize));
        if (i == numberOfColumns) {
          boardIndexToAngleMap.put(boardIndex, angle - (float) Math.PI / 4.0f);
        } else {
          boardIndexToAngleMap.put(boardIndex, angle - (float) Math.PI / 2.0f);
        }
      }

    }

    // player 1 / player 3
    for (int playerNumber = 1; playerNumber < board.getNumberOfPlayers(); playerNumber += 2) {

      float angle = (float) (2.0 * Math.PI * ((float) playerNumber
          / (float) board.getNumberOfPlayers()));

      for (int i = 0; i < numberOfRows; i++) {
        float centerX = width / 2.0f - (float) Math.sin(angle) * width / 2.0f - gridCellSize * 1.5f;
        float centerY = height / 2.0f + (float) Math.sin(angle) * -ySpacing * i;
        int boardIndex = (board.getHomeEntryBoardIndex(playerNumber) + i)
            % board.getNumberOfPerimeterSpaces();
        boardIndexToBoundsMap.put(boardIndex, new Rectangle(
            centerX - (gridCellSize / 2.0f), centerY - (gridCellSize / 2.0f), gridCellSize,
            gridCellSize));
        if (i == numberOfRows - 1) {
          boardIndexToAngleMap.put(boardIndex, angle - (float) Math.PI / 4.0f);
        } else {
          boardIndexToAngleMap.put(boardIndex, angle - (float) Math.PI / 2.0f);
        }
      }

      for (int i = 1; i < numberOfColumns; i++) {
        float centerX = width / 2.0f - (float) Math.sin(angle) * width / 2.0f
            - gridCellSize * 1.5f - xSpacing * i;
        float centerY = height / 2.0f - (float) Math.sin(angle) * height / 2.0f
            - gridCellSize * 1.5f;
        int boardIndex = (board.getHomeEntryBoardIndex(playerNumber) + i + numberOfRows - 1)
            % board.getNumberOfPerimeterSpaces();
        boardIndexToBoundsMap.put(boardIndex, new Rectangle(
            centerX - (gridCellSize / 2.0f), centerY - (gridCellSize / 2.0f), gridCellSize,
            gridCellSize));
        boardIndexToAngleMap.put(boardIndex, angle);
      }

    }

    for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {

      float angle = (float) (2.0 * Math.PI * ((float) playerNumber
          / (float) board.getNumberOfPlayers()));

      // home spaces
      Rectangle rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(playerNumber));
      float homeEntryCenterX = rectangle.getX() + (rectangle.getWidth() / 2.0f);
      float homeEntryCenterY = rectangle.getY() + (rectangle.getHeight() / 2.0f);
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

}
