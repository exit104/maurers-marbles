/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.event;

import static org.junit.Assert.assertEquals;

import com.exit104.maurersmarbles.Game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The CannotPlayGameEventTest class contains the unit tests for the CannotPlayGameEvent class.
 *
 * @author Daniel Uppenkamp
 */
public class CannotPlayGameEventTest {

  public CannotPlayGameEventTest() {
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
   * Test of getPlayerNumber method, of class CannotPlayGameEvent.
   */
  @Test
  public void testGetPlayerNumber() {

    System.out.println("getPlayerNumber");

    Game game = new Game(4);
    CannotPlayGameEvent instance = new CannotPlayGameEvent(game, 1);
    int expResult = 1;
    int result = instance.getPlayerNumber();
    assertEquals(expResult, result);

  }

  /**
   * Test of toString method, of class CannotPlayGameEvent.
   */
  @Test
  public void testToString() {

    System.out.println("toString");

    Game game = new Game(4);
    CannotPlayGameEvent instance = new CannotPlayGameEvent(game, 1);
    String expResult = "Player 1 cannot play";
    String result = instance.toString();
    assertEquals(expResult, result);

  }

}
