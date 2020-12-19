/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.ui;

import com.exit104.maurersmarbles.Card;
import com.exit104.maurersmarbles.Rectangle;

/**
 * The HorizontalCardHandView class implements the CardHandView interface to display a player's hand
 * of cards horizontally across the view.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class HorizontalCardHandView implements CardHandView {

  /**
   * The height (in pixels) of the view.
   */
  protected transient float height;
  /**
   * The padding scale factor across the bottom side of the view relative to the height of the view.
   */
  protected float paddingBottomScaleFactor = 0.0f;
  /**
   * The padding scale factor across the left side of the view relative to the width of the view.
   */
  protected float paddingLeftScaleFactor = 0.0f;
  /**
   * The padding scale factor across the right side of the view relative to the width of the view.
   */
  protected float paddingRightScaleFactor = 0.0f;
  /**
   * The padding scale factor across the top side of the view relative to the height of the view.
   */
  protected float paddingTopScaleFactor = 0.0f;
  /**
   * The scale factor of space between the cards relative to the width of the view.
   */
  protected float spaceBetweenCardsScaleFactor = 0.0f;
  /**
   * The width (in pixels) of the view.
   */
  protected transient float width;

  /**
   * Creates a new HorizontalCardHandView.
   */
  public HorizontalCardHandView() {
    update(1.0f, 1.0f);
  }

  /**
   * Returns the padding scale factor across the bottom side of the view relative to the height of
   * the view.
   *
   * @return the padding scale factor across the bottom side of the view relative to the height of
   * the view
   */
  public float getPaddingBottomScaleFactor() {
    return paddingBottomScaleFactor;
  }

  /**
   * Sets the padding scale factor across the bottom side of the view relative to the height of the
   * view.
   *
   * @param paddingBottomScaleFactor the padding scale factor across the bottom side of the view
   * relative to the height of the view
   */
  public void setPaddingBottomScaleFactor(float paddingBottomScaleFactor) {
    this.paddingBottomScaleFactor = paddingBottomScaleFactor;
  }

  /**
   * Returns the padding scale factor across the left side of the view relative to the width of the
   * view.
   *
   * @return the padding scale factor across the left side of the view relative to the width of the
   * view
   */
  public float getPaddingLeftScaleFactor() {
    return paddingLeftScaleFactor;
  }

  /**
   * Sets the padding scale factor across the left side of the view relative to the width of the
   * view.
   *
   * @param paddingLeftScaleFactor the padding scale factor across the left side of the view
   * relative to the width of the view
   */
  public void setPaddingLeftScaleFactor(float paddingLeftScaleFactor) {
    this.paddingLeftScaleFactor = paddingLeftScaleFactor;
  }

  /**
   * Returns the padding scale factor across the right side of the view relative to the width of the
   * view.
   *
   * @return the padding scale factor across the right side of the view relative to the width of the
   * view
   */
  public float getPaddingRightScaleFactor() {
    return paddingRightScaleFactor;
  }

  /**
   * Sets the padding scale factor across the right side of the view relative to the width of the
   * view.
   *
   * @param paddingRightScaleFactor the padding scale factor across the right side of the view
   * relative to the width of the view
   */
  public void setPaddingRightScaleFactor(float paddingRightScaleFactor) {
    this.paddingRightScaleFactor = paddingRightScaleFactor;
  }

  /**
   * Returns the padding scale factor across the top side of the view relative to the height of the
   * view.
   *
   * @return the padding scale factor across the top side of the view relative to the height of the
   * view
   */
  public float getPaddingTopScaleFactor() {
    return paddingTopScaleFactor;
  }

  /**
   * Sets the padding scale factor across the top side of the view relative to the height of the
   * view.
   *
   * @param paddingTopScaleFactor the padding scale factor across the top side of the view relative
   * to the height of the view
   */
  public void setPaddingTopScaleFactor(float paddingTopScaleFactor) {
    this.paddingTopScaleFactor = paddingTopScaleFactor;
  }

  /**
   * Returns the scale factor of space between the cards relative to the width of the view.
   *
   * @return the scale factor of space between the cards relative to the width of the view
   */
  public float getSpaceBetweenCardsScaleFactor() {
    return spaceBetweenCardsScaleFactor;
  }

  /**
   * Sets the scale factor of space between the cards relative to the width of the view.
   *
   * @param spaceBetweenCardsScaleFactor the scale factor of space between the cards relative to the
   * width of the view
   */
  public void setSpaceBetweenCardsScaleFactor(float spaceBetweenCardsScaleFactor) {
    this.spaceBetweenCardsScaleFactor = spaceBetweenCardsScaleFactor;
  }

  @Override
  public float getAngleForCard(int cardNumber, int currentNumberOfCards, int maxNumberOfCards) {
    return 0.0f;
  }

  @Override
  public Rectangle getBoundsForCard(int cardNumber, int currentNumberOfCards,
      int maxNumberOfCards) {

    float paddingBottom = height * paddingBottomScaleFactor;
    float paddingLeft = width * paddingLeftScaleFactor;
    float paddingRight = width * paddingRightScaleFactor;
    float paddingTop = height * paddingTopScaleFactor;
    float spaceBetweenCards = width * spaceBetweenCardsScaleFactor;

    // first try to size the cards based on the width of the view
    float cardWidth = (width - paddingLeft
        - (spaceBetweenCards * (maxNumberOfCards - 1)) - paddingRight) / (float) maxNumberOfCards;
    float cardHeight = Card.HEIGHT * cardWidth / Card.WIDTH;
    if (cardHeight > height - paddingTop - paddingBottom) {
      // cards would be too tall, size the cards based on the height of the view
      cardHeight = height - paddingTop - paddingBottom;
      cardWidth = Card.WIDTH * cardHeight / Card.HEIGHT;
    }

    float cardX = ((width - paddingLeft - (currentNumberOfCards * cardWidth)
        - ((currentNumberOfCards - 1) * spaceBetweenCards) - paddingRight) / 2.0f)
        + paddingLeft + (cardNumber * (cardWidth + spaceBetweenCards));
    float cardY = ((height - paddingTop - cardHeight - paddingBottom) / 2.0f) + paddingTop;

    return new Rectangle(cardX, cardY, cardWidth, cardHeight);

  }

  @Override
  public final void update(float width, float height) {
    this.width = width;
    this.height = height;
  }

}
