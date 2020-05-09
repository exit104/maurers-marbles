/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.event;

import com.exit104.maurersmarbles.Card;
import com.exit104.maurersmarbles.Game;

/**
 * The DealtCardGameEvent class represents an event when a card is dealt in the game.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class DealtCardGameEvent extends GameEvent {

  /**
   * The card that was dealt.
   */
  protected transient Card card;
  /**
   * The player number that dealt the card.
   */
  protected transient int dealerPlayerNumber;
  /**
   * The player number the card was dealt to.
   */
  protected transient int recipientPlayerNumber;

  /**
   * Creates a new DealtCardGameEvent.
   *
   * @param game the game for the event
   * @param dealerPlayerNumber the player number that dealt the card
   * @param card the card that was dealt
   * @param recipientPlayerNumber the player number the card was dealt to
   */
  public DealtCardGameEvent(Game game, int dealerPlayerNumber, Card card,
      int recipientPlayerNumber) {
    super(game);
    this.dealerPlayerNumber = dealerPlayerNumber;
    this.card = card;
    this.recipientPlayerNumber = recipientPlayerNumber;
  }

  /**
   * Returns the card that was dealt.
   *
   * @return the card that was dealt
   */
  public Card getCard() {
    return card;
  }

  /**
   * Returns the player number that dealt the card.
   *
   * @return the player number that dealt the card
   */
  public int getDealerPlayerNumber() {
    return dealerPlayerNumber;
  }

  /**
   * Returns the player number the card was dealt to
   *
   * @return the player number the card was dealt to
   */
  public int getRecipientPlayerNumber() {
    return recipientPlayerNumber;
  }

  @Override
  public String toString() {
    return String.format("Player %d dealt card %s to player %d", dealerPlayerNumber, card,
        recipientPlayerNumber);
  }

}
