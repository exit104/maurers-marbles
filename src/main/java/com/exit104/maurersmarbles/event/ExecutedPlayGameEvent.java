/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.event;

import com.exit104.maurersmarbles.Game;
import com.exit104.maurersmarbles.Play;

/**
 * The ExecutedPlayGameEvent class represents an event when a player in the game executes a play.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class ExecutedPlayGameEvent extends GameEvent {

  /**
   * The play that was executed.
   */
  protected transient Play play;
  /**
   * The player number that executed the play.
   */
  protected transient int playerNumber;

  /**
   * Creates a new ExecutedPlayGameEvent.
   *
   * @param game the game for the event
   * @param playerNumber the player number that executed the play
   * @param play the play that was executed
   */
  public ExecutedPlayGameEvent(Game game, int playerNumber, Play play) {
    super(game);
    this.playerNumber = playerNumber;
    this.play = play;
  }

  /**
   * Returns the play that was executed.
   *
   * @return the play that was executed
   */
  public Play getPlay() {
    return play;
  }

  /**
   * Returns the player number that executed the play.
   *
   * @return the player number that executed the play
   */
  public int getPlayerNumber() {
    return playerNumber;
  }

  @Override
  public String toString() {
    return String.format("Player %d executed play with card %s", playerNumber, play.getCard());
  }

}
