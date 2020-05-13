/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import com.google.common.base.Preconditions;

import java.util.Set;

/**
 * The PlaySelector class provides the methods to select a play from a set of available plays.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class PlaySelector {

  /**
   * The selected play, or null to indicate no play has been selected.
   */
  protected transient Play selectedPlay = null;

  /**
   * Creates a new PlaySelector.
   */
  public PlaySelector() {
    // do nothing
  }

  /**
   * Sets the set of available plays to select from.
   *
   * @param plays the set of available plays to select from
   * @throws IllegalArgumentException if the given available plays is empty
   * @throws NullPointerException if the given available plays is null
   */
  public void setAvailablePlays(Set<Play> plays) {
    Preconditions.checkNotNull(plays, "Null plays");
    Preconditions.checkArgument(!plays.isEmpty(), "Empty plays");
  }

  /**
   * Returns the selected play, or null if a play has not been selected.
   *
   * @return the selected play, or null if a play has not been selected
   */
  public Play getSelectedPlay() {
    return selectedPlay;
  }

  /**
   * Sets the selected play.
   *
   * @param selectedPlay the selected play, or null to indicate no play has been selected
   */
  public void setSelectedPlay(Play selectedPlay) {
    this.selectedPlay = selectedPlay;
  }

}
