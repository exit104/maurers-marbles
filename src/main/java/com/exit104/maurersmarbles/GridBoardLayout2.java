/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import com.google.common.base.Preconditions;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * The GridBoardLayout class implements the BoardLayout interface to provide a layout with the board
 * spaces in a grid.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class GridBoardLayout2 implements BoardLayout {

  /**
   * The board for the layout.
   */
  protected final transient Board board;
  /**
   * The card scale factor relative to the size of a grid cell.
   */
  protected static final float CARD_SCALE_FACTOR = 0.8f;
  /**
   * The marble scale factor relative to the size of a grid cell.
   */
  protected static final float MARBLE_SCALE_FACTOR = 0.85f;
  /**
   * The space scale factor relative to the size of a grid cell.
   */
  protected static final float SPACE_SCALE_FACTOR = 0.65f;
  /**
   * The map that contains the grid sizes for each board configuration. The key into the map is the
   * number of players and the value is the grid size.
   */
  protected static final Map<Integer, Float> GRID_SIZES;
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
  protected final transient Rectangle discardPileRectangle;

  static {

    // populate the grid sizes for each board configuration
    Map<Integer, Float> gridSizes = new TreeMap<>();
    gridSizes.put(4, 14.0f);
    gridSizes.put(6, 17.0f);
    gridSizes.put(8, 20.0f);
    gridSizes.put(10, 23.0f);
    gridSizes.put(12, 26.0f);
    GRID_SIZES = Collections.unmodifiableMap(gridSizes);

  }

  /**
   * Creates a new GridBoardLayout for the given board.
   *
   * @param board the board
   * @throws NullPointerException if the given board is null
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public GridBoardLayout2(Board board) {

    Preconditions.checkNotNull(board, "Null board");

    this.board = board;

    float innerSize;
    switch (board.getNumberOfPlayers()) {
      case 4:
        innerSize = 0.93f;
        break;
      case 6:
        innerSize = 0.94f;
        break;
      case 8:
        innerSize = 0.94f;
        break;
      case 10:
        innerSize = 0.94f;
        break;
      case 12:
      // falls through
      default:
        innerSize = 0.95f;
        break;
    }
    float gridSize = innerSize / GRID_SIZES.get(board.getNumberOfPlayers());
    float radius = innerSize / 2.0f;

    for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {

      float playerAngle = (float) (2.0 * Math.PI
          * ((double) playerNumber / (double) board.getNumberOfPlayers()) + Math.PI / 2.0);

      // calculate the center x and y of this vertex
      float gridCellCenterX = radius * (float) Math.cos(playerAngle) + 0.5f;
      float gridCellCenterY = radius * (float) Math.sin(playerAngle) + 0.5f;

      for (int i = -2; i <= 2; i++) {

        float spaceX = gridCellCenterX - (i * gridSize)
            * (float) Math.cos(playerAngle + Math.PI / 2.0);
        float spaceY = gridCellCenterY - (i * gridSize)
            * (float) Math.sin(playerAngle + Math.PI / 2.0);
        Rectangle rectangle = new Rectangle(spaceX - (gridSize / 2.0f),
            spaceY - (gridSize / 2.0f), gridSize, gridSize);

        if (i == -2) {
          // safe space
          boardIndexToAngleMap.put(board.getSafeBoardIndex(playerNumber),
              playerAngle - (float) Math.PI);
          boardIndexToBoundsMap.put(board.getSafeBoardIndex(playerNumber), rectangle);
        } else {
          // home entry
          boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(playerNumber) - i,
              playerAngle - (float) Math.PI);
          boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(playerNumber) - i,
              rectangle);
        }

        if (i == 2 || i == 0 || i == -2) {

          for (int j = 1; j <= (i == -2 || i == 2 ? 5 : 4); j++) {

            rectangle = new Rectangle(
                (spaceX - (j * gridSize) * (float) Math.cos(playerAngle)) - (gridSize / 2.0f),
                (spaceY - (j * gridSize) * (float) Math.sin(playerAngle)) - (gridSize / 2.0f),
                gridSize, gridSize);

            if (i == -2) {
              // left side
              if (j != 5) {
                boardIndexToAngleMap.put(board.getSafeBoardIndex(playerNumber) + j,
                    playerAngle - (float) Math.PI);
              }
              Rectangle rectangleBefore = boardIndexToBoundsMap.get(
                  board.getSafeBoardIndex(playerNumber) + j);
              if (rectangleBefore != null) {
                // for the transition spaces, average the location to make it look smoother
                rectangle = new Rectangle((rectangle.getX() + rectangleBefore.getX()) / 2.0f,
                    (rectangle.getY() + rectangleBefore.getY()) / 2.0f, rectangle.getWidth(),
                    rectangle.getHeight());
              }
              boardIndexToBoundsMap.put(board.getSafeBoardIndex(playerNumber) + j,
                  rectangle);
            } else if (i == 0) {
              // home spaces
              boardIndexToAngleMap.put(board.getHomeMinBoardIndex(playerNumber) + j - 1,
                  playerAngle - (float) Math.PI);
              boardIndexToBoundsMap.put(board.getHomeMinBoardIndex(playerNumber) + j - 1,
                  rectangle);
            } else {
              // right side
              if (j == 5) {
                float transitionAngle = (float) (2.0 * Math.PI
                    * ((double) (playerNumber - 0.5) / (double) board.getNumberOfPlayers())
                    - Math.PI / 2.0);
                boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(playerNumber) - 2 - j,
                    transitionAngle);
              } else {
                boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(playerNumber) - 2 - j,
                    playerAngle - (float) Math.PI);
              }
              Rectangle rectangleBefore = boardIndexToBoundsMap.get(
                  board.getHomeEntryBoardIndex(playerNumber) - 2 - j);
              if (rectangleBefore != null) {
                // for the transition spaces, average the location to make it look smoother
                rectangle = new Rectangle((rectangle.getX() + rectangleBefore.getX()) / 2.0f,
                    (rectangle.getY() + rectangleBefore.getY()) / 2.0f, rectangle.getWidth(),
                    rectangle.getHeight());
              }
              boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(playerNumber) - 2 - j,
                  rectangle);
            }

          }

        }

      }

    }

    // start spaces
    float startSpaceScaleFactor;
    float startSpaceOffset;
    switch (board.getNumberOfPlayers()) {
      case 4:
        startSpaceScaleFactor = 1.0f;
        startSpaceOffset = 5.5f;
        break;
      case 6:
        startSpaceScaleFactor = 0.87f;
        startSpaceOffset = 5.2f;
        break;
      case 8:
        startSpaceScaleFactor = 0.9f;
        startSpaceOffset = 5.8f;
        break;
      case 10:
        startSpaceScaleFactor = 0.85f;
        startSpaceOffset = 5.8f;
        break;
      case 12:
      // falls through
      default:
        startSpaceScaleFactor = 0.85f;
        startSpaceOffset = 6.2f;
        break;
    }
    for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {
      float playerAngle = (float) (2.0 * Math.PI * ((double) (playerNumber)
          / (double) board.getNumberOfPlayers()) + Math.PI / 2.0);
      float nextPlayerAngle = (float) (2.0 * Math.PI * ((double) (playerNumber + 1)
          / (double) board.getNumberOfPlayers()) + Math.PI / 2.0);
      float angle = (playerAngle + nextPlayerAngle) / 2.0f;
      Rectangle rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(playerNumber) + 5);
      for (int i = 0; i < Game.NUMBER_OF_MARBLES_PER_PLAYER; i++) {
        float spaceX = rectangle.getX() - ((i - startSpaceOffset) * gridSize
            * startSpaceScaleFactor) * (float) Math.cos(angle);
        float spaceY = rectangle.getY() - ((i - startSpaceOffset) * gridSize
            * startSpaceScaleFactor) * (float) Math.sin(angle);
        boardIndexToBoundsMap.put(board.getStartMinBoardIndex(playerNumber) + i,
            new Rectangle(spaceX, spaceY, rectangle.getWidth(), rectangle.getHeight()));
        boardIndexToAngleMap.put(board.getStartMinBoardIndex(playerNumber) + i,
            angle - (float) Math.PI);
      }
    }

    // calculate the size of a card on the board based using the size of the marbles
    float cardWidth = Card.WIDTH * gridSize * CARD_SCALE_FACTOR;
    float cardHeight = Card.HEIGHT * gridSize * CARD_SCALE_FACTOR;
    discardPileRectangle = new Rectangle(0.5f - (cardWidth / 2.0f), 0.5f - (cardHeight / 2.0f),
        cardWidth, cardHeight);

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
