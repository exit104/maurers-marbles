/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.event;

import com.google.common.base.Preconditions;

/**
 * The Event class represents an event that can be fired.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class Event {

  /**
   * The source for the event.
   */
  protected transient Object source;

  /**
   * Creates a new Event.
   *
   * @param source the source of the event
   * @throws NullPointerException if the given source is null
   */
  public Event(Object source) {
    Preconditions.checkNotNull(source, "Null source");
    this.source = source;
  }

  /**
   * Returns the source for the event.
   *
   * @return the source for the event
   */
  public Object getSource() {
    return source;
  }

}
