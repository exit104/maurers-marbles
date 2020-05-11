/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.event;

import com.exit104.maurersmarbles.Game;
import com.exit104.maurersmarbles.Game.State;

/**
 * The StateChangeGameEvent class represents an event when the state in the game changes.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class StateChangeGameEvent extends GameEvent {

  /**
   * The game state.
   */
  protected transient State state;

  /**
   * Creates a new StateChangeGameEvent.
   *
   * @param game the game for the event
   * @param state the game state
   */
  public StateChangeGameEvent(Game game, State state) {
    super(game);
    this.state = state;
  }

  /**
   * Returns the game state.
   *
   * @return the game state
   */
  public State getState() {
    return state;
  }

  @Override
  public String toString() {
    return new StringBuilder("Entering state ").append(state).toString();
  }

}
