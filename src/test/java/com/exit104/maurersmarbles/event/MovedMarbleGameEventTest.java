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
 * The MovedMarbleGameEventTest class contains the unit tests for the MovedMarbleGameEvent class.
 *
 * @author Daniel Uppenkamp
 */
public class MovedMarbleGameEventTest {

  public MovedMarbleGameEventTest() {
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
   * Test of getMarbleNumber method, of class MovedMarbleGameEvent.
   */
  @Test
  public void testGetMarbleNumber() {

    System.out.println("getMarbleNumber");

    Game game = new Game(4);
    MovedMarbleGameEvent instance = new MovedMarbleGameEvent(game, 0, 1, 2, 3);
    int expResult = 1;
    int result = instance.getMarbleNumber();
    assertEquals(expResult, result);

  }

  /**
   * Test of getNewBoardIndex method, of class MovedMarbleGameEvent.
   */
  @Test
  public void testGetNewBoardIndex() {

    System.out.println("getNewBoardIndex");

    Game game = new Game(4);
    MovedMarbleGameEvent instance = new MovedMarbleGameEvent(game, 0, 1, 2, 3);
    int expResult = 3;
    int result = instance.getNewBoardIndex();
    assertEquals(expResult, result);

  }

  /**
   * Test of getOldBoardIndex method, of class MovedMarbleGameEvent.
   */
  @Test
  public void testGetOldBoardIndex() {

    System.out.println("getOldBoardIndex");

    Game game = new Game(4);
    MovedMarbleGameEvent instance = new MovedMarbleGameEvent(game, 0, 1, 2, 3);
    int expResult = 2;
    int result = instance.getOldBoardIndex();
    assertEquals(expResult, result);

  }

  /**
   * Test of getPlayerNumber method, of class MovedMarbleGameEvent.
   */
  @Test
  public void testGetPlayerNumber() {

    System.out.println("getPlayerNumber");

    Game game = new Game(4);
    MovedMarbleGameEvent instance = new MovedMarbleGameEvent(game, 0, 1, 2, 3);
    int expResult = 0;
    int result = instance.getPlayerNumber();
    assertEquals(expResult, result);

  }

  /**
   * Test of toString method, of class MovedMarbleGameEvent.
   */
  @Test
  public void testToString() {

    System.out.println("toString");

    Game game = new Game(4);
    MovedMarbleGameEvent instance = new MovedMarbleGameEvent(game, 0, 1, 2, 3);
    String expResult = "Moved player 0 marble 1 from board index 2 to board index 3";
    String result = instance.toString();
    assertEquals(expResult, result);

  }

}
