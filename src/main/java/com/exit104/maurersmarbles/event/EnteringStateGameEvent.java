/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.event;

import com.exit104.maurersmarbles.Game;
import com.exit104.maurersmarbles.Game.State;

/**
 * The EnteringStateGameEvent class represents an event when a state in the game is being entered.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class EnteringStateGameEvent extends GameEvent {

  /**
   * The game state being entered.
   */
  protected transient State state;

  /**
   * Creates a new EnteringStateGameEvent.
   *
   * @param game the game for the event
   * @param state the game state being entered
   */
  public EnteringStateGameEvent(Game game, State state) {
    super(game);
    this.state = state;
  }

  /**
   * Returns the game state being entered.
   *
   * @return the game state being entered
   */
  public State getState() {
    return state;
  }

  @Override
  public String toString() {
    return new StringBuilder("Entering state ").append(state).toString();
  }

}
