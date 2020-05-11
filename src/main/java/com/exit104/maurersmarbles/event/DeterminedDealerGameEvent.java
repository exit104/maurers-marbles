/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.event;

import com.exit104.maurersmarbles.Game;

/**
 * The DeterminedDealerGameEvent class represents an event when the dealer is determined in the
 * game.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class DeterminedDealerGameEvent extends GameEvent {

  /**
   * The player number that is the dealer.
   */
  protected transient int playerNumber;

  /**
   * Creates a new DeterminedDealerGameEvent.
   *
   * @param game the game for the event
   * @param playerNumber the player number that is the dealer
   */
  public DeterminedDealerGameEvent(Game game, int playerNumber) {
    super(game);
    this.playerNumber = playerNumber;
  }

  /**
   * Returns the player number that is the dealer.
   *
   * @return the player number that is the dealer
   */
  public int getPlayerNumber() {
    return playerNumber;
  }

  @Override
  public String toString() {
    return new StringBuilder("Player ").append(playerNumber).append(" is the first dealer")
        .toString();
  }

}
