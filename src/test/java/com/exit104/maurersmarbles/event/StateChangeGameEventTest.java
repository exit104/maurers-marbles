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
 * The StateChangeGameEventTest class contains the unit tests for the StateChangeGameEvent class.
 *
 * @author Daniel Uppenkamp
 */
public class StateChangeGameEventTest {

  public StateChangeGameEventTest() {
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
   * Test of getState method, of class StateChangeGameEvent.
   */
  @Test
  public void testGetState() {

    System.out.println("getState");

    Game game = new Game(4);
    StateChangeGameEvent instance = new StateChangeGameEvent(game, Game.State.DEAL_CARDS);
    Game.State expResult = Game.State.DEAL_CARDS;
    Game.State result = instance.getState();
    assertEquals(expResult, result);

  }

  /**
   * Test of toString method, of class StateChangeGameEvent.
   */
  @Test
  public void testToString() {

    System.out.println("toString");

    Game game = new Game(4);
    StateChangeGameEvent instance = new StateChangeGameEvent(game, Game.State.DEAL_CARDS);
    String expResult = "Entering state " + Game.State.DEAL_CARDS.name();
    String result = instance.toString();
    assertEquals(expResult, result);

  }

}
