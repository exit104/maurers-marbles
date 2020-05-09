/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.event;

import com.exit104.maurersmarbles.Game;

/**
 * The ShuffledCardDeckGameEvent class represents an event when a player shuffles the card deck.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class ShuffledCardDeckGameEvent extends GameEvent {

  /**
   * The player number that shuffled the card deck.
   */
  protected transient int playerNumber;

  /**
   * Creates a new ShuffledCardDeckGameEvent.
   *
   * @param game the game for the event
   * @param playerNumber the player number that shuffled the card deck
   */
  public ShuffledCardDeckGameEvent(Game game, int playerNumber) {
    super(game);
    this.playerNumber = playerNumber;
  }

  /**
   * Returns the player number that shuffled the card deck.
   *
   * @return the player number that shuffled the card deck
   */
  public int getPlayerNumber() {
    return playerNumber;
  }

  @Override
  public String toString() {
    return String.format("Player %d shuffled the card deck", playerNumber);
  }

}
