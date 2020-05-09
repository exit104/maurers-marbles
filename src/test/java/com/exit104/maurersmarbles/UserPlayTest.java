/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import static org.junit.Assert.assertEquals;

import com.exit104.maurersmarbles.Card.Rank;
import com.exit104.maurersmarbles.Card.Suit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The UserPlayTest class contains the unit tests for the UserPlay class.
 *
 * @author Daniel Uppenkamp
 */
public class UserPlayTest {

  public UserPlayTest() {
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
   * Test of getCard method, of class UserPlay.
   */
  @Test
  public void testGetCard() {

    System.out.println("getCard");

    UserPlay instance = UserPlay.builder(0, new Card(Rank.ACE, Suit.CLUBS), new Marble(0, 0, 0))
        .build();
    Card expResult = new Card(Rank.ACE, Suit.CLUBS);
    Card result = instance.getCard();
    assertEquals(expResult, result);

  }

  /**
   * Test of getPlayerNumber method, of class UserPlay.
   */
  @Test
  public void testGetPlayerNumber() {

    System.out.println("getPlayerNumber");

    UserPlay instance = UserPlay.builder(1, new Card(Rank.ACE, Suit.CLUBS), new Marble(0, 0, 0))
        .build();
    int expResult = 1;
    int result = instance.getPlayerNumber();
    assertEquals(expResult, result);

  }

  /**
   * Test of getSplitValue1 method, of class UserPlay.
   */
  @Test
  public void testGetSplitValue1() {

    System.out.println("getSplitValue1");

    UserPlay instance = UserPlay.builder(0, new Card(Rank.ACE, Suit.CLUBS), new Marble(0, 0, 0))
        .build();
    int expResult = UserPlay.NO_SPLIT_VALUE;
    int result = instance.getSplitValue1();
    assertEquals(expResult, result);

    instance = UserPlay.builder(0, new Card(Rank.ACE, Suit.CLUBS), new Marble(0, 0, 0))
        .setSplitValue1(1)
        .build();
    expResult = 1;
    result = instance.getSplitValue1();
    assertEquals(expResult, result);

  }

  /**
   * Test of getMarble1 method, of class UserPlay.
   */
  @Test
  public void testGetMarble1() {

    System.out.println("getMarble1");

    UserPlay instance = UserPlay.builder(0, new Card(Rank.ACE, Suit.CLUBS), new Marble(0, 0, 0))
        .build();
    Marble expResult = new Marble(0, 0, 0);
    Marble result = instance.getMarble1();
    assertEquals(expResult, result);

  }

  /**
   * Test of getMarble2 method, of class UserPlay.
   */
  @Test
  public void testGetMarble2() {

    System.out.println("getMarble2");

    UserPlay instance = UserPlay.builder(0, new Card(Rank.ACE, Suit.CLUBS), new Marble(0, 0, 0))
        .build();
    Marble expResult = UserPlay.NO_MARBLE;
    Marble result = instance.getMarble2();
    assertEquals(expResult, result);

    instance = UserPlay.builder(0, new Card(Rank.ACE, Suit.CLUBS), new Marble(0, 0, 0))
        .setMarble2(new Marble(1, 1, 1))
        .build();
    expResult = new Marble(1, 1, 1);
    result = instance.getMarble2();
    assertEquals(expResult, result);

  }

}
