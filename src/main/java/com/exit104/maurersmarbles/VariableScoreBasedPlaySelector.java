/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import com.google.common.base.Preconditions;

import java.util.Set;

/**
 * The VariableScoreBasedPlaySelector class extends the ScoreBasedPlaySelector class to provide a
 * variable on how often a play is chosen based on the score vs. a play chosen randomly.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class VariableScoreBasedPlaySelector extends ScoreBasedPlaySelector {

  /**
   * The play selector used to select plays randomly.
   */
  protected static final RandomPlaySelector RANDOM_PLAY_SELECTOR = new RandomPlaySelector();
  /**
   * A value between 0.0 and 1.0 defining how often a play is chosen at random.
   */
  protected final transient float random;

  /**
   * Creates a new VariableScoreBasedPlaySelector.
   *
   * A random value of 0.0 means a play is always selected based on the score. A random value of 1.0
   * means a play is always randomly selected.
   *
   * @param game the game for the play selector
   * @param playerNumber the player number selecting plays for
   * @param random a value between 0.0 and 1.0 defining how often a play is chosen at random
   * @throws IllegalArgumentException if the given player number or random is invalid
   * @throws NullPointerException if the given game is null
   */
  public VariableScoreBasedPlaySelector(Game game, int playerNumber, float random) {
    super(game, playerNumber);
    Preconditions.checkArgument(random >= 0.0 && random <= 1.0, "Invalid random");
    this.random = random;
  }

  @Override
  public void setAvailablePlays(Set<Play> plays) {
    if (Math.random() < random) {
      RANDOM_PLAY_SELECTOR.setAvailablePlays(plays);
      setSelectedPlay(RANDOM_PLAY_SELECTOR.getSelectedPlay());
    } else {
      super.setAvailablePlays(plays);
    }
  }

}
