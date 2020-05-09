/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.event;

import com.exit104.maurersmarbles.Card;
import com.exit104.maurersmarbles.Game;

/**
 * The PlayedCardGameEvent class represents an event for a card being played in the game.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class PlayedCardGameEvent extends GameEvent {

  /**
   * The card that was played.
   */
  protected transient Card card;
  /**
   * The player number that played the card.
   */
  protected transient int playerNumber;

  /**
   * Creates a new PlayedCardGameEvent.
   *
   * @param game the game for the event
   * @param playerNumber the player number that played the card
   * @param card the card that was played
   */
  public PlayedCardGameEvent(Game game, int playerNumber, Card card) {
    super(game);
    this.playerNumber = playerNumber;
    this.card = card;
  }

  /**
   * Returns the card that was played.
   *
   * @return the card that was played
   */
  public Card getCard() {
    return card;
  }

  /**
   * Returns the player number that played the card.
   *
   * @return the player number that played the card
   */
  public int getPlayerNumber() {
    return playerNumber;
  }

  @Override
  public String toString() {
    return String.format("Player %d played card %s", playerNumber, card);
  }

}
