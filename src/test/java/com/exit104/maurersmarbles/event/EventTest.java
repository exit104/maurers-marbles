/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.event;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The EventTest class contains the unit tests for the Event class.
 *
 * @author Daniel Uppenkamp
 */
public class EventTest {

  public EventTest() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  /**
   * Test of constructor method, of class Event.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testEvent_Object() {

    // test with null
    Object source = null;
    try {
      new Event(source);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with source
    source = new Object();
    new Event(source);

  }

}
