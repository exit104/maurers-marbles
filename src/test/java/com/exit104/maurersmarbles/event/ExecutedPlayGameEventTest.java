/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.event;

import static org.junit.Assert.assertEquals;

import com.exit104.maurersmarbles.Card;
import com.exit104.maurersmarbles.Card.Rank;
import com.exit104.maurersmarbles.Card.Suit;
import com.exit104.maurersmarbles.Game;
import com.exit104.maurersmarbles.Move;
import com.exit104.maurersmarbles.Play;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The ExecutedPlayGameEventTest class contains the unit tests for the ExecutedPlayGameEvent class.
 *
 * @author Daniel Uppenkamp
 */
public class ExecutedPlayGameEventTest {

  public ExecutedPlayGameEventTest() {
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
   * Test of getPlay method, of class ExecutedPlayGameEvent.
   */
  @Test
  public void testGetPlay() {

    System.out.println("getPlay");

    Game game = new Game(4);
    ExecutedPlayGameEvent instance = new ExecutedPlayGameEvent(game, 1,
        new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 0, 0)));
    Play expResult = new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 0, 0));
    Play result = instance.getPlay();
    assertEquals(expResult, result);

  }

  /**
   * Test of getPlayerNumber method, of class ExecutedPlayGameEvent.
   */
  @Test
  public void testGetPlayerNumber() {

    System.out.println("getPlayerNumber");

    Game game = new Game(4);
    ExecutedPlayGameEvent instance = new ExecutedPlayGameEvent(game, 1,
        new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 0, 0)));
    int expResult = 1;
    int result = instance.getPlayerNumber();
    assertEquals(expResult, result);

  }

  /**
   * Test of toString method, of class ExecutedPlayGameEvent.
   */
  @Test
  public void testToString() {

    System.out.println("toString");

    Game game = new Game(4);
    ExecutedPlayGameEvent instance = new ExecutedPlayGameEvent(game, 1,
        new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 0, 0)));
    String expResult = "Player 1 executed play with card AC";
    String result = instance.toString();
    assertEquals(expResult, result);

  }

}
