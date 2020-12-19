/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.ui;

import com.exit104.maurersmarbles.Rectangle;

/**
 * The CardHandView interface provides the methods to represent a view of a player's hand of cards.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public interface CardHandView {

  /**
   * Returns the angle (in radians) of the given card number.
   *
   * @param cardNumber the card number to get the angle for (with 0 being the first card)
   * @param currentNumberOfCards the current number of cards being displayed in the view
   * @param maxNumberOfCards the maximum number of cards that could be displayed in the view
   * @return the angle (in radians) of the given card number
   */
  float getAngleForCard(int cardNumber, int currentNumberOfCards, int maxNumberOfCards);

  /**
   * Returns the bounds for the given card number.
   *
   * @param cardNumber the card number to get the bounds for (with 0 being the first card)
   * @param currentNumberOfCards the current number of cards being displayed in the view
   * @param maxNumberOfCards the maximum number of cards that could be displayed in the view
   * @return the bounds for the given card number
   */
  Rectangle getBoundsForCard(int cardNumber, int currentNumberOfCards, int maxNumberOfCards);

  /**
   * Updates the width and height of the view.
   *
   * @param width the width of the view (in pixels)
   * @param height the height of the view (in pixels
   */
  void update(float width, float height);

}
