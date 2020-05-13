/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import java.util.Set;

/**
 * The FirstPlaySelector class extends the PlaySelector class to select the first play in the set of
 * available plays.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class FirstPlaySelector extends PlaySelector {

  /**
   * Creates a new FirstPlaySelector.
   */
  public FirstPlaySelector() {
    super();
  }

  @Override
  public void setAvailablePlays(Set<Play> plays) {
    super.setAvailablePlays(plays);
    setSelectedPlay(plays.iterator().next());
  }

}
