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
 * The DealtCardGameEventTest class contains the unit tests for the DealtCardGameEvent class.
 *
 * @author Daniel Uppenkamp
 */
public class DealtCardGameEventTest {

  public DealtCardGameEventTest() {
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
   * Test of getCard method, of class DealtCardGameEvent.
   */
  @Test
  public void testGetCard() {

    System.out.println("getCard");

    Game game = new Game(4);
    DealtCardGameEvent instance = new DealtCardGameEvent(game, 0, new Card(Rank.ACE, Suit.CLUBS),
        1);
    Card expResult = new Card(Rank.ACE, Suit.CLUBS);
    Card result = instance.getCard();
    assertEquals(expResult, result);

  }

  /**
   * Test of getDealerPlayerNumber method, of class DealtCardGameEvent.
   */
  @Test
  public void testGetDealerPlayerNumber() {

    System.out.println("getDealerPlayerNumber");

    Game game = new Game(4);
    DealtCardGameEvent instance = new DealtCardGameEvent(game, 0, new Card(Rank.ACE, Suit.CLUBS),
        1);
    int expResult = 0;
    int result = instance.getDealerPlayerNumber();
    assertEquals(expResult, result);

  }

  /**
   * Test of getRecipientPlayerNumber method, of class DealtCardGameEvent.
   */
  @Test
  public void testGetRecipientPlayerNumber() {

    System.out.println("getRecipientPlayerNumber");

    Game game = new Game(4);
    DealtCardGameEvent instance = new DealtCardGameEvent(game, 0, new Card(Rank.ACE, Suit.CLUBS),
        1);
    int expResult = 1;
    int result = instance.getRecipientPlayerNumber();
    assertEquals(expResult, result);

  }

  /**
   * Test of toString method, of class DealtCardGameEvent.
   */
  @Test
  public void testToString() {

    System.out.println("toString");

    Game game = new Game(4);
    DealtCardGameEvent instance = new DealtCardGameEvent(game, 0, new Card(Rank.ACE, Suit.CLUBS),
        1);
    String expResult = "Player 0 dealt card AC to player 1";
    String result = instance.toString();
    assertEquals(expResult, result);

  }

}
