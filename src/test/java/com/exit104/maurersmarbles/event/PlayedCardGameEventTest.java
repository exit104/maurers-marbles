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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The PlayedCardGameEventTest class contains the unit tests for the PlayedCardGameEvent class.
 *
 * @author Daniel Uppenkamp
 */
public class PlayedCardGameEventTest {

  public PlayedCardGameEventTest() {
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
   * Test of getCard method, of class PlayedCardGameEvent.
   */
  @Test
  public void testGetCard() {

    System.out.println("getCard");

    Game game = new Game(4);
    PlayedCardGameEvent instance = new PlayedCardGameEvent(game, 1, new Card(Rank.ACE, Suit.CLUBS));
    Card expResult = new Card(Rank.ACE, Suit.CLUBS);
    Card result = instance.getCard();
    assertEquals(expResult, result);

  }

  /**
   * Test of getPlayerNumber method, of class PlayedCardGameEvent.
   */
  @Test
  public void testGetPlayerNumber() {

    System.out.println("getPlayerNumber");

    Game game = new Game(4);
    PlayedCardGameEvent instance = new PlayedCardGameEvent(game, 1, new Card(Rank.ACE, Suit.CLUBS));
    int expResult = 1;
    int result = instance.getPlayerNumber();
    assertEquals(expResult, result);

  }

  /**
   * Test of toString method, of class PlayedCardGameEvent.
   */
  @Test
  public void testToString() {

    System.out.println("toString");

    Game game = new Game(4);
    PlayedCardGameEvent instance = new PlayedCardGameEvent(game, 1, new Card(Rank.ACE, Suit.CLUBS));
    String expResult = "Player 1 played card AC";
    String result = instance.toString();
    assertEquals(expResult, result);

  }

}
