/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.event;

import com.exit104.maurersmarbles.Game;

/**
 * The CannotPlayGameEvent class represents an event when a player in the game cannot play.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class CannotPlayGameEvent extends GameEvent {

  /**
   * The player number that cannot play.
   */
  protected transient int playerNumber;

  /**
   * Creates a new CannotPlayGameEvent.
   *
   * @param game the game for the event
   * @param playerNumber the player number that cannot play
   */
  public CannotPlayGameEvent(Game game, int playerNumber) {
    super(game);
    this.playerNumber = playerNumber;
  }

  /**
   * Returns the player number that cannot play.
   *
   * @return the player number that cannot play
   */
  public int getPlayerNumber() {
    return playerNumber;
  }

  @Override
  public String toString() {
    return new StringBuilder().append("Player ").append(playerNumber).append(" cannot play")
        .toString();
  }

}
