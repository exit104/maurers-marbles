/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.exit104.maurersmarbles.Game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The GameEventTest class contains the unit tests for the GameEvent class.
 *
 * @author Daniel Uppenkamp
 */
public class GameEventTest {

  public GameEventTest() {
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
   * Test of constructor method, of class GameEvent.
   */
  @Test
  public void testGameEvent_Game() {

    System.out.println("constructor");

    // test with null
    Game game = null;
    try {
      new GameEvent(game);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with game
    game = new Game(4);
    new GameEvent(game);

  }

  /**
   * Test of getSource method, of class GameEvent.
   */
  @Test
  public void testGetSource() {

    System.out.println("getSource");

    GameEvent instance = new GameEvent(new Game(4));
    Game expResult = new Game(4);
    Game result = instance.getSource();
    assertEquals(expResult, result);

  }

}
