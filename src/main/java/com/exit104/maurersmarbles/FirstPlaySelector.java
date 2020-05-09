/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import com.google.common.base.Preconditions;

import java.util.Set;

/**
 * The FirstPlaySelector class implements the PlaySelector interface to select the first play in the
 * set of valid plays.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class FirstPlaySelector implements PlaySelector {

  /**
   * Creates a new FirstPlaySelector.
   */
  public FirstPlaySelector() {
    // do nothing
  }

  @Override
  public Play select(Game game, Set<Play> plays) {
    Preconditions.checkNotNull(game, "Null game");
    Preconditions.checkNotNull(plays, "Null plays");
    Preconditions.checkArgument(!plays.isEmpty(), "Empty plays");
    return plays.iterator().next();
  }

}
