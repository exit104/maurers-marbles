/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import com.google.common.base.Preconditions;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * The RandomPlaySelector class implements the PlaySelector interface to select a random play from
 * the set of valid plays.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class RandomPlaySelector implements PlaySelector {

  /**
   * The random object used to select a random play.
   */
  protected transient Random random = new Random();

  /**
   * Creates a new RandomPlaySelector.
   */
  public RandomPlaySelector() {
    // do nothing
  }

  @Override
  public Play select(Game game, Set<Play> plays) {

    Preconditions.checkNotNull(game, "Null game");
    Preconditions.checkNotNull(plays, "Null plays");
    Preconditions.checkArgument(!plays.isEmpty(), "Empty plays");

    int randomIndex = random.nextInt(plays.size());
    Iterator<Play> iterator = plays.iterator();
    for (int i = 0; i < randomIndex; i++) {
      iterator.next();
    }
    return iterator.next();

  }

}
