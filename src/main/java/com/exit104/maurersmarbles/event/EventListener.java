/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.event;

/**
 * The EventListener interface is used to register for and be notified of events being fired.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public interface EventListener {

  /**
   * Handles the given event. This method is called when an event is fired.
   *
   * @param event the event to handle
   */
  void handleEvent(Event event);

}
