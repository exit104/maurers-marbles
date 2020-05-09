/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.event;

import com.exit104.maurersmarbles.Game;

/**
 * The GameEvent class represents an event in the Game class.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class GameEvent extends Event {

  /**
   * Creates a new GameEvent.
   *
   * @param game the game for the event
   */
  public GameEvent(Game game) {
    super(game);
  }

  @Override
  public Game getSource() {
    return (Game) super.getSource();
  }

}
