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
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public final void update(float width, float height) {

    // calculate the perimeter distance of the entire screen
    float perimeterDistance = width * 2.0f + height * 2.0f;

    // calculate the distance per space
    float distancePerSpace = perimeterDistance / board.getNumberOfPerimeterSpaces();

    // calculate the number of rows that will fit on the screen based on the height
    int numberOfRows = (int) (height / distancePerSpace) + 1;
    // make sure the number of rows is odd
    if (numberOfRows % 2 == 0) {
      numberOfRows++;
    }
    // make sure we have at least 11 rows for the player spaces
    numberOfRows = Math.max(11, numberOfRows);
    int numberOfColumns = (board.getNumberOfPerimeterSpaces() - (numberOfRows * 2)) / 2 + 2;
    // make sure we have at least 11 columns for the player spaces
    if (numberOfColumns < 11) {
      numberOfColumns = 11;
      numberOfRows = (board.getNumberOfPerimeterSpaces() - (numberOfColumns * 2)) / 2 + 2;
    }

    // add 2 to the rows and columns to account for the start spaces in the grid
    numberOfRows += 2;
    numberOfColumns += 2;

    // calculate the size of the grid cells
    gridCellSize = Math.min(height / numberOfRows, width / numberOfColumns);

    // calculate the spacing in the x and y directions
    float spacingX = width / numberOfColumns;
    float spacingY = height / numberOfRows;

    // calculate the board index offset for the space in the upper left corner
    int boardIndex;
    if (board.getNumberOfPlayers() == 4) {
      boardIndex = board.getHomeEntryBoardIndex(2) - ((numberOfColumns - 2) / 2);
    } else if (board.getNumberOfPlayers() == 6) {
      if (width > height) {
        boardIndex = board.getHomeEntryBoardIndex(1) + ((numberOfRows - 2) / 2);
      } else {
        boardIndex = board.getHomeEntryBoardIndex(3) - ((numberOfColumns - 2) / 2);
      }
    } else if (board.getNumberOfPlayers() == 8) {
      if (width > height) {
        boardIndex = board.getHomeEntryBoardIndex(2) + ((numberOfRows - 2) / 2);
      } else {
        boardIndex = board.getHomeEntryBoardIndex(4) - ((numberOfColumns - 2) / 2);
      }
    } else {
      if (width > height) {
        boardIndex = board.getHomeEntryBoardIndex(5) - ((numberOfColumns - 2) / 2);
      } else {
        boardIndex = board.getHomeEntryBoardIndex(2) + ((numberOfRows - 2) / 2);
      }
    }

    int column;
    int row;

    // top
    row = 1;
    for (column = 1; column < numberOfColumns - 2; column++) {
      boardIndexToBoundsMap.put(boardIndex, new Rectangle(column * spacingX, row * spacingY,
          gridCellSize, gridCellSize));
      if (column == 1) {
        boardIndexToAngleMap.put(boardIndex, 7.0f * (float) Math.PI / 4.0f);
      } else {
        boardIndexToAngleMap.put(boardIndex, 3.0f * (float) Math.PI / 2.0f);
      }
      boardIndex = (boardIndex + 1) % board.getNumberOfPerimeterSpaces();
    }

    // right
    column = numberOfColumns - 2;
    for (row = 1; row <= numberOfRows - 3; row++) {
      boardIndexToBoundsMap.put(boardIndex, new Rectangle(column * spacingX, row * spacingY,
          gridCellSize, gridCellSize));
      if (row == 1) {
        boardIndexToAngleMap.put(boardIndex, 5.0f * (float) Math.PI / 4.0f);
      } else {
        boardIndexToAngleMap.put(boardIndex, (float) Math.PI);
      }
      boardIndex = (boardIndex + 1) % board.getNumberOfPerimeterSpaces();
    }

    // bottom
    row = numberOfRows - 2;
    for (column = numberOfColumns - 2; column >= 2; column--) {
      boardIndexToBoundsMap.put(boardIndex, new Rectangle(column * spacingX, row * spacingY,
          gridCellSize, gridCellSize));
      if (column == numberOfColumns - 2) {
        boardIndexToAngleMap.put(boardIndex, 3.0f * (float) Math.PI / 4.0f);
      } else {
        boardIndexToAngleMap.put(boardIndex, (float) Math.PI / 2.0f);
      }
      boardIndex = (boardIndex + 1) % board.getNumberOfPerimeterSpaces();
    }

    // left
    column = 1;
    for (row = numberOfRows - 2; row >= 2; row--) {
      boardIndexToBoundsMap.put(boardIndex, new Rectangle(column * spacingX, row * spacingY,
          gridCellSize, gridCellSize));
      if (row == numberOfRows - 2) {
        boardIndexToAngleMap.put(boardIndex, (float) Math.PI / 4.0f);
      } else {
        boardIndexToAngleMap.put(boardIndex, 0.0f);
      }
      boardIndex = (boardIndex + 1) % board.getNumberOfPerimeterSpaces();
    }

    for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {

      float angle = boardIndexToAngleMap.get(board.getHomeEntryBoardIndex(playerNumber));
      Rectangle rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(playerNumber));

      // home spaces
      for (int offset = 0; offset < 4; offset++) {
        float homeX = (float) (rectangle.getX() + ((1 + offset) * gridCellSize * Math.cos(angle)));
        float homeY = (float) (rectangle.getY() - ((1 + offset) * gridCellSize * Math.sin(angle)));
        boardIndexToBoundsMap.put(board.getHomeMinBoardIndex(playerNumber) + offset,
            new Rectangle(homeX, homeY, gridCellSize, gridCellSize));
        boardIndexToAngleMap.put(board.getHomeMinBoardIndex(playerNumber) + offset, angle);
      }

      float firstStartX = (float) (rectangle.getX()
          + (1.5 * gridCellSize * Math.cos(angle + Math.PI / 2.0f))
          + (gridCellSize * Math.cos(angle + Math.PI)));
      float firstStartY = (float) (rectangle.getY()
          - (1.5 * gridCellSize * Math.sin(angle + Math.PI / 2.0f))
          - (gridCellSize * Math.sin(angle + Math.PI)));
      for (int offset = 0; offset < 4; offset++) {
        float startX = (float) (firstStartX + (offset * gridCellSize * Math.cos(angle - Math.PI
            / 2.0f)));
        float startY = (float) (firstStartY - (offset * gridCellSize * Math.sin(angle - Math.PI
            / 2.0f)));
        boardIndexToBoundsMap.put(board.getStartMinBoardIndex(playerNumber) + offset,
            new Rectangle(startX, startY, gridCellSize, gridCellSize));
        boardIndexToAngleMap.put(board.getStartMinBoardIndex(playerNumber) + offset, angle);
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
