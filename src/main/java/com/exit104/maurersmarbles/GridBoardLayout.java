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
public class GridBoardLayout implements BoardLayout {

  /**
   * The board for the layout.
   */
  protected final transient Board board;
  /**
   * The card scale factor relative to the size of a grid cell.
   */
  protected static final float CARD_SCALE_FACTOR = 0.8f;
  /**
   * The inner size of the board where the spaces are drawn (this creates a buffer around the
   * outside of the board.
   */
  protected static final float INNER_SIZE = 0.92f;
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
    gridSizes.put(4, 16.0f);
    gridSizes.put(6, 19.0f);
    gridSizes.put(8, 22.0f);
    gridSizes.put(10, 25.0f);
    gridSizes.put(12, 28.0f);
    GRID_SIZES = Collections.unmodifiableMap(gridSizes);

  }

  /**
   * Creates a new GridBoardLayout for the given board.
   *
   * @param board the board
   * @throws NullPointerException if the given board is null
   */
  public GridBoardLayout(Board board) {

    Preconditions.checkNotNull(board, "Null board");

    this.board = board;

    float gridSize = INNER_SIZE / GRID_SIZES.get(board.getNumberOfPlayers());
    float radius = INNER_SIZE / 2.0f;

    for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {

      float vertex = (float) playerNumber / (float) board.getNumberOfPlayers();

      // use and outer ring for the start spaces and an inner ring for the remaining spaces
      for (int ring = 0; ring <= 1; ring++) {

        // calculate the center x and y of this vertex
        float gridCellCenterX = (radius - gridSize * ring)
            * (float) Math.cos(2.0 * Math.PI * vertex + Math.PI / 2.0) + 0.5f;
        float gridCellCenterY = (radius - gridSize * ring)
            * (float) Math.sin(2.0 * Math.PI * vertex + Math.PI / 2.0) + 0.5f;

        // calculate the angle for this vertex (perpindicular to the player's home spaces)
        float componentX = (float) Math.cos(2.0 * Math.PI * vertex + Math.PI);
        float componentY = (float) Math.sin(2.0 * Math.PI * vertex + Math.PI);

        if (ring == 0) {

          // start spaces
          for (int i = 0; i < 4; i++) {
            boardIndexToBoundsMap.put(board.getStartMinBoardIndex(playerNumber) + i,
                new Rectangle(
                    gridCellCenterX - ((i - 1.5f) * gridSize) * componentX - (gridSize / 2.0f),
                    gridCellCenterY - ((i - 1.5f) * gridSize) * componentY - (gridSize / 2.0f),
                    gridSize, gridSize));
          }

        } else {

          for (int i = -2; i <= 2; i++) {

            float spaceX = gridCellCenterX - (i * gridSize) * componentX;
            float spaceY = gridCellCenterY - (i * gridSize) * componentY;
            Rectangle rectangle = new Rectangle(spaceX - (gridSize / 2.0f),
                spaceY - (gridSize / 2.0f), gridSize, gridSize);

            if (i == -2) {
              // safe space
              boardIndexToBoundsMap.put(board.getSafeBoardIndex(playerNumber), rectangle);
            } else {
              // home entry
              boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(playerNumber) - i,
                  rectangle);
            }

            if (i == 2 || i == 0 || i == -2) {

              float componentX2 = (float) Math.cos(2.0 * Math.PI * vertex + Math.PI / 2.0);
              float componentY2 = (float) Math.sin(2.0 * Math.PI * vertex + Math.PI / 2.0);

              for (int j = 1; j <= (i == 2 ? 5 : 4); j++) {

                rectangle = new Rectangle(
                    (spaceX - (j * gridSize) * componentX2) - (gridSize / 2.0f),
                    (spaceY - (j * gridSize) * componentY2) - (gridSize / 2.0f), gridSize,
                    gridSize);

                if (i == -2) {
                  // left side
                  boardIndexToBoundsMap.put(board.getSafeBoardIndex(playerNumber) + j,
                      rectangle);
                } else if (i == 0) {
                  // home spaces
                  boardIndexToBoundsMap.put(board.getHomeMinBoardIndex(playerNumber) + j - 1,
                      rectangle);
                } else {
                  // right side
                  boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(playerNumber) - 2 - j,
                      rectangle);
                }

              }

            }

          }

        }

      }

    }

    // calculate the size of a card on the board based using the size of the marbles
    float cardWidth = Card.WIDTH * gridSize * CARD_SCALE_FACTOR;
    float cardHeight = Card.HEIGHT * gridSize * CARD_SCALE_FACTOR;
    discardPileRectangle = new Rectangle(0.5f - (cardWidth / 2.0f), 0.5f - (cardHeight / 2.0f),
        cardWidth, cardHeight);

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
