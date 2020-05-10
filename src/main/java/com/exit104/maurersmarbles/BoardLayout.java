/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

/**
 * The BoardLayout interface provides the methods to define a layout of a game board. The bounds of
 * the board are defined as a unit square (0.0 to 1.0 in both the x and y dimensions).
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public interface BoardLayout {

  /**
   * Returns the bounds of the given board index.
   *
   * @param boardIndex the board index
   * @return the bounds of the given board index
   * @throws IllegalArgumentException if the given board index is invalid
   */
  Rectangle getBoundsForBoardIndex(int boardIndex);

  /**
   * Returns the bounds of the discard pile on the board.
   *
   * @return the bounds of the discard pile on the board
   */
  Rectangle getBoundsForDiscardPile();

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

}
