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
   * @param playerNumber the player number selecting plays for
   * @param random a value between 0.0 and 1.0 defining how often a play is chosen at random
   * @throws IllegalArgumentException if the given random is invalid
   */
  public VariableScoreBasedPlaySelector(int playerNumber, float random) {
    super(playerNumber);
    Preconditions.checkArgument(random >= 0.0 && random <= 1.0, "Invalid random");
    this.random = random;
  }

  @Override
  public Play select(Game game, Set<Play> plays) {
    if (Math.random() < random) {
      return RANDOM_PLAY_SELECTOR.select(game, plays);
    }
    return super.select(game, plays);
  }

}
