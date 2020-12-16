/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.view;

import com.exit104.maurersmarbles.Rectangle;

/**
 * The BoardView interface provides the methods to represent a view of the game board.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public interface BoardView {

  /**
   * Returns the angle (in radians) of the given board index on the board.
   *
   * @param boardIndex the board index
   * @return the angle (in radians) of the given board index on the board
   * @throws IllegalArgumentException if the given board index is invalid
   */
  float getAngleForBoardIndex(int boardIndex);

  /**
   * Returns the bounds of the given board index.
   *
   * @param boardIndex the board index
   * @return the bounds of the given board index
   * @throws IllegalArgumentException if the given board index is invalid
   */
  Rectangle getBoundsForBoardIndex(int boardIndex);

  /**
   * Returns the bounds of a marble in the given board index.
   *
   * @param boardIndex the board index
   * @return the bounds of a marble in the given board index
   * @throws IllegalArgumentException if the given board index is invalid
   */
  Rectangle getBoundsForMarble(int boardIndex);

  /**
   * Returns the bounds of a space at the given board index.
   *
   * @param boardIndex the board index
   * @return the bounds of a space at the given board index
   * @throws IllegalArgumentException if the given board index is invalid
   */
  Rectangle getBoundsForSpace(int boardIndex);

  /**
   * Updates the width and height of the board.
   *
   * @param width the width of the board (in pixels)
   * @param height the height of the board (in pixels)
   */
  void update(float width, float height);

}
