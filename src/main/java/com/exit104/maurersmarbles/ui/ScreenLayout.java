/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.ui;

import com.exit104.maurersmarbles.Rectangle;

/**
 * The ScreenLayout interface provides the methods to represents the layout of the game components
 * on the screen.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public interface ScreenLayout {

  /**
   * Returns the bounds of the game board on the screen.
   *
   * @return the bounds of the game board on the screen
   */
  Rectangle getBoundsForBoard();

  /**
   * Returns the bounds of the player's space on the screen.
   *
   * @param playerNumber the player number
   * @return the bounds of the player's space on the screen
   */
  Rectangle getBoundsForPlayer(int playerNumber);

  /**
   * Updates the width and height of the screen.
   *
   * @param width the width of the screen (in pixels)
   * @param height the height of the screen (in pixels)
   */
  void update(float width, float height);

}
