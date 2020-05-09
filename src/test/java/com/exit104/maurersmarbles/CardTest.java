/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The CardTest class contains the unit tests for the Card class.
 *
 * @author Daniel Uppenkamp
 */
public class CardTest {

  public CardTest() {
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
   * Test of constructor method, of class Card.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testCard() {

    System.out.println("constructor");

    // test with null rank
    Card.Rank rank = null;
    Card.Suit suit = null;
    try {
      new Card(rank, suit);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with null suit
    rank = Card.Rank.ACE;
    suit = null;
    try {
      new Card(rank, suit);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

  }

  /**
   * Test of copy constructor method, of class Card.
   */
  @Test
  public void testCard_Card() {

    System.out.println("copy constructor");

    // test with null card
    Card card = null;
    try {
      new Card(card);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with card
    card = new Card(Card.Rank.TEN, Card.Suit.CLUBS);
    Card instance = new Card(card);
    assertEquals(card, instance);

  }

  /**
   * Test of getRank method, of class Card.
   */
  @Test
  public void testGetRank() {

    System.out.println("getRank");

    Card instance = new Card(Card.Rank.ACE, Card.Suit.HEARTS);
    Card.Rank expResult = Card.Rank.ACE;
    Card.Rank result = instance.getRank();
    assertEquals(expResult, result);

  }

  /**
   * Test of getSuit method, of class Card.
   */
  @Test
  public void testGetSuit() {

    System.out.println("getSuit");

    Card instance = new Card(Card.Rank.ACE, Card.Suit.HEARTS);
    Card.Suit expResult = Card.Suit.HEARTS;
    Card.Suit result = instance.getSuit();
    assertEquals(expResult, result);

  }

  /**
   * Test of equals method, of class Card.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testEquals() {

    System.out.println("equals");

    // test same object
    Object obj = new Card(Card.Rank.ACE, Card.Suit.HEARTS);
    Card instance = (Card) obj;
    boolean expResult = true;
    boolean result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with null
    obj = null;
    instance = new Card(Card.Rank.ACE, Card.Suit.HEARTS);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with different class
    obj = new Object();
    instance = new Card(Card.Rank.ACE, Card.Suit.HEARTS);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test equal objects
    obj = new Card(Card.Rank.ACE, Card.Suit.HEARTS);
    instance = new Card(Card.Rank.ACE, Card.Suit.HEARTS);
    expResult = true;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test different card rank
    obj = new Card(Card.Rank.TWO, Card.Suit.HEARTS);
    instance = new Card(Card.Rank.ACE, Card.Suit.HEARTS);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test different card suit
    obj = new Card(Card.Rank.ACE, Card.Suit.CLUBS);
    instance = new Card(Card.Rank.ACE, Card.Suit.HEARTS);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

  }

  /**
   * Test of hashCode method, of class Card.
   */
  @Test
  public void testHashCode() {

    System.out.println("hashCode");

    Card instance1 = new Card(Card.Rank.ACE, Card.Suit.HEARTS);
    Card instance2 = new Card(Card.Rank.ACE, Card.Suit.HEARTS);
    assertEquals(instance1.hashCode(), instance2.hashCode());

  }

  /**
   * Test of toString method, of class Card.
   */
  @Test
  public void testToString() {

    System.out.println("toString");

    Card instance = new Card(Card.Rank.ACE, Card.Suit.HEARTS);
    String expResult = "AH";
    String result = instance.toString();
    assertEquals(expResult, result);

  }

}
