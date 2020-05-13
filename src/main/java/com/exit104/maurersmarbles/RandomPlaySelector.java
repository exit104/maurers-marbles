/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * The RandomPlaySelector class extends the PlaySelector class to select a random play from the set
 * of available plays.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class RandomPlaySelector extends PlaySelector {

  /**
   * The random used to select a random play.
   */
  protected transient Random random = new Random();

  /**
   * Creates a new RandomPlaySelector.
   */
  public RandomPlaySelector() {
    super();
  }

  @Override
  public void setAvailablePlays(Set<Play> plays) {

    super.setAvailablePlays(plays);

    int randomIndex = random.nextInt(plays.size());
    Iterator<Play> iterator = plays.iterator();
    for (int i = 0; i < randomIndex; i++) {
      iterator.next();
    }
    setSelectedPlay(iterator.next());

  }

}
