/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.view;

import com.google.common.base.Preconditions;

import com.exit104.maurersmarbles.Board;
import com.exit104.maurersmarbles.Rectangle;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * The GridBoardView class implements the BoardView interface to provide the classic grid layout of
 * the game board.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class GridBoardView implements BoardView {

  /**
   * The board for the view.
   */
  protected final transient Board board;
  /**
   * The inner size of the board where the spaces are drawn (this creates a buffer around the
   * outside of the board.
   */
  protected static final float BOARD_SCALE_FACTOR = 0.98f;
  /**
   * The marble scale factor relative to the size of a grid cell.
   */
  protected static final float MARBLE_SCALE_FACTOR = 0.90f;
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
   * and the value is the bounds. The bounds are referenced from the upper left corner starting at
   * 0,0.
   */
  protected final transient Map<Integer, Rectangle> boardIndexToBoundsMap = new TreeMap<>();

  static {
    Map<Integer, Float> gridSizes = new TreeMap<>();
    gridSizes.put(4, 15.0f);
    //gridSizes.put(6, 18.0f);
    //gridSizes.put(8, 21.5f);
    //gridSizes.put(10, 24.5f);
    //gridSizes.put(12, 27.75f);
    GRID_SIZES = Collections.unmodifiableMap(gridSizes);
  }

  /**
   * Creates a new GridBoardView for the given board.
   *
   * @param board the board to create the view for
   * @throws NullPointerException if the given board is null
   */
  public GridBoardView(Board board) {
    Preconditions.checkNotNull(board, "Null board");
    this.board = board;
    if (!GRID_SIZES.containsKey(board.getNumberOfPlayers())) {
      throw new UnsupportedOperationException(board.getNumberOfPlayers()
          + " players not supported yet");
    }
    update(1.0f, 1.0f);
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

  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  @Override
  public final void update(float width, float height) {

    boardIndexToAngleMap.clear();
    boardIndexToBoundsMap.clear();

    float boardSize = Math.min(width, height) * BOARD_SCALE_FACTOR;
    float gridCellSize = boardSize / GRID_SIZES.get(board.getNumberOfPlayers());
    float radius = (boardSize / 2.0f) - (gridCellSize / 2.0f);

    for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {

      float playerAngle = (float) ((3.0 * Math.PI / 2.0)
          - (2.0 * Math.PI * (double) playerNumber / (double) board.getNumberOfPlayers()));

      // calculate the center x and y of this vertex
      float gridCellCenterX = (width / 2.0f) + radius * (float) Math.cos(playerAngle);
      float gridCellCenterY = (height / 2.0f) - radius * (float) Math.sin(playerAngle);

      // calculate the angle for this vertex (perpindicular to the player's home spaces)
      float componentX = (float) Math.cos(playerAngle - Math.PI / 2.0);
      float componentY = (float) Math.sin(playerAngle - Math.PI / 2.0);

      for (int i = 2; i >= -2; i--) {

        float spaceX = gridCellCenterX + (i * gridCellSize) * componentX;
        float spaceY = gridCellCenterY - (i * gridCellSize) * componentY;
        Rectangle rectangle = new Rectangle(spaceX - (gridCellSize / 2.0f),
            spaceY - (gridCellSize / 2.0f), gridCellSize, gridCellSize);

        if (i == 2) {
          // safe space
          boardIndexToAngleMap.put(board.getSafeBoardIndex(playerNumber),
              playerAngle - (float) Math.PI);
          boardIndexToBoundsMap.put(board.getSafeBoardIndex(playerNumber), rectangle);
        } else {
          // home entry spaces
          boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(playerNumber) + i,
              playerAngle - (float) Math.PI);
          boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(playerNumber) + i, rectangle);
        }

        if (i == 2 || i == 0 || i == -2) {

          float componentX2 = (float) Math.cos(playerAngle - Math.PI);
          float componentY2 = (float) Math.sin(playerAngle - Math.PI);

          for (int j = 1; j <= (i == 2 || i == -2 ? 5 : 4); j++) {

            rectangle = new Rectangle(
                (spaceX + (j * gridCellSize) * componentX2) - (gridCellSize / 2.0f),
                (spaceY - (j * gridCellSize) * componentY2) - (gridCellSize / 2.0f),
                gridCellSize, gridCellSize);

            if (i == 2) {
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
                float transitionAngle = (float) ((3.0 * Math.PI / 2.0) - (2.0 * Math.PI
                    * (double) (playerNumber - 0.5) / (double) board.getNumberOfPlayers())
                    - Math.PI);
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

      // start spaces
      int boardIndexOffset = 0;
      for (int i = 3; i >= 1; i -= 2) {
        Rectangle rectangle = boardIndexToBoundsMap.get(board.getSafeBoardIndex(playerNumber) + i);
        boardIndexToAngleMap.put(board.getStartMinBoardIndex(playerNumber) + boardIndexOffset,
            playerAngle - (float) Math.PI);
        boardIndexToBoundsMap.put(board.getStartMinBoardIndex(playerNumber) + boardIndexOffset,
            new Rectangle(
                rectangle.getX() + (4.0f * gridCellSize) * componentX,
                rectangle.getY() - (4.0f * gridCellSize) * componentY,
                gridCellSize, gridCellSize));
        boardIndexOffset++;
        boardIndexToAngleMap.put(board.getStartMinBoardIndex(playerNumber) + boardIndexOffset,
            playerAngle - (float) Math.PI);
        boardIndexToBoundsMap.put(board.getStartMinBoardIndex(playerNumber) + boardIndexOffset,
            new Rectangle(
                rectangle.getX() + (2.0f * gridCellSize) * componentX,
                rectangle.getY() - (2.0f * gridCellSize) * componentY,
                gridCellSize, gridCellSize));
        boardIndexOffset++;
      }

    }

  }

}

///////////////////////////////////////////////////////////////////////////////////////////////////
// 4 player board
///////////////////////////////////////////////////////////////////////////////////////////////////
//
//    | 00 01 02 03 04 05 06 07 08 09 10 11 12 13 14
// ---|---------------------------------------------
// 00 |                24 25 26 27 28
// 01 |       78 76    23    64    29    83 82
// 02 |                22    65    30
// 03 |       79 77    21    66    31    81 80
// 04 |                20    67    32
// 05 | 14 15 16 17 18 19          33 34 35 36 37 38
// 06 | 13                                        39
// 07 | 12 60 61 62 63                71 70 69 68 40
// 08 | 11                                        41
// 09 | 10 09 08 07 06 05          47 46 45 44 43 42
// 10 |                04    59    48
// 11 |       72 73    03    58    49    85 87
// 12 |                02    57    50
// 13 |       74 75    01    56    51    84 86
// 14 |                00 55 54 53 52
