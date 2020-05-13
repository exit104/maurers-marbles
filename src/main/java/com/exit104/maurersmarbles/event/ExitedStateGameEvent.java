/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.event;

import com.exit104.maurersmarbles.Game;
import com.exit104.maurersmarbles.Game.State;

/**
 * The ExitedStateGameEvent class represents an event when a state in the game is exited.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class ExitedStateGameEvent extends GameEvent {

  /**
   * The game state exited.
   */
  protected transient State state;

  /**
   * Creates a new ExitedStateGameEvent.
   *
   * @param game the game for the event
   * @param state the game state exited
   */
  public ExitedStateGameEvent(Game game, State state) {
    super(game);
    this.state = state;
  }

  /**
   * Returns the game state exited.
   *
   * @return the game state exited
   */
  public State getState() {
    return state;
  }

  @Override
  public String toString() {
    return new StringBuilder("Exited state ").append(state).toString();
  }

}
