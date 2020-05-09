/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import java.util.Set;

/**
 * The PlaySelector interface defines the methods to select a play from a set of available plays.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public interface PlaySelector {

  /**
   * Selects the play to execute in the game based on the given game state and the set of valid
   * plays.
   *
   * @param game the game
   * @param plays the set of plays
   * @return the play to execute
   */
  Play select(Game game, Set<Play> plays);

}
