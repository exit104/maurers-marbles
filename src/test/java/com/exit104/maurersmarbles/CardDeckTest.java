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

import java.util.List;

/**
 * The CardDeckTest class contains the unit tests for the CardDeck class.
 *
 * @author Daniel Uppenkamp
 */
public class CardDeckTest {

  public CardDeckTest() {
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
   * Test of constructor method, of class CardDeck.
   */
  @Test
  public void testCardDeck() {

    System.out.println("constructor");

    CardDeck instance = new CardDeck();
    assertEquals(0, instance.getDealtCards().size());
    assertEquals(CardDeck.NUMBER_OF_CARDS_IN_FULL_DECK, instance.getUndealtCards().size());
    assertEquals(new Card(Card.Rank.ACE, Card.Suit.HEARTS), instance.getUndealtCards().get(0));
    assertEquals(new Card(Card.Rank.ACE, Card.Suit.CLUBS), instance.getUndealtCards().get(13));
    assertEquals(new Card(Card.Rank.ACE, Card.Suit.DIAMONDS), instance.getUndealtCards().get(38));
    assertEquals(new Card(Card.Rank.ACE, Card.Suit.SPADES), instance.getUndealtCards().get(51));

  }

  /**
   * Test of copy constructor method, of class CardDeck.
   */
  @Test
  public void testCardDeck_CardDeck() {

    System.out.println("copy constructor");

    // test with null
    CardDeck cardDeck = null;
    try {
      new CardDeck(cardDeck);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with new card deck
    cardDeck = new CardDeck();
    CardDeck instance = new CardDeck(cardDeck);
    assertEquals(cardDeck, instance);

    // test with dealt card deck
    cardDeck = new CardDeck();
    cardDeck.shuffle();
    for (int i = 0; i < CardDeck.NUMBER_OF_CARDS_IN_FULL_DECK; i++) {
      cardDeck.dealCard();
    }
    instance = new CardDeck(cardDeck);
    assertEquals(cardDeck, instance);

  }

  /**
   * Test of constructor method, of class CardDeck.
   */
  @Test
  public void testCardDeck_boolean() {

    System.out.println("constructor");

    // test without shuffle
    boolean shuffle = false;
    CardDeck instance = new CardDeck(shuffle);
    assertEquals(0, instance.getDealtCards().size());
    assertEquals(CardDeck.NUMBER_OF_CARDS_IN_FULL_DECK, instance.getUndealtCards().size());
    assertEquals(new Card(Card.Rank.ACE, Card.Suit.HEARTS), instance.getUndealtCards().get(0));
    assertEquals(new Card(Card.Rank.ACE, Card.Suit.CLUBS), instance.getUndealtCards().get(13));
    assertEquals(new Card(Card.Rank.ACE, Card.Suit.DIAMONDS), instance.getUndealtCards().get(38));
    assertEquals(new Card(Card.Rank.ACE, Card.Suit.SPADES), instance.getUndealtCards().get(51));

    /**
     * While unlikely, it is possible for Collections.shuffle to return the list in the same order.
     * It is even more unlikely for the method to return the list in the same order multiple times.
     * So we will check for a different order 10 different times and if the order is the same all 10
     * times, we will fail.
     */
    shuffle = true;
    List<Card> newDeckOrder = new CardDeck().getUndealtCards();
    boolean sameOrder = true;
    for (int i = 0; i < 10; i++) {
      instance = new CardDeck(shuffle);
      assertEquals(0, instance.getDealtCards().size());
      assertEquals(CardDeck.NUMBER_OF_CARDS_IN_FULL_DECK, instance.getUndealtCards().size());
      if (!instance.getUndealtCards().equals(newDeckOrder)) {
        sameOrder = false;
        break;
      }
    }
    if (sameOrder) {
      fail("Card deck is not shuffled\n");
    }

  }

  /**
   * Test of getDealtCards method, of class CardDeck.
   */
  @Test
  public void testGetDealtCards() {

    System.out.println("getDealtCards");

    // test getting cards
    CardDeck instance = new CardDeck();
    assertEquals(0, instance.getDealtCards().size());

    // try modifing the list
    try {
      instance.getDealtCards().clear();
      fail("Unsupported operation exception not thrown");
    } catch (UnsupportedOperationException ex) {
      // do nothing
    }

  }

  /**
   * Test of getUndealtCards method, of class CardDeck.
   */
  @Test
  public void testGetUndealtCards() {

    System.out.println("getUndealtCards");

    // test getting cards
    CardDeck instance = new CardDeck();
    assertEquals(CardDeck.NUMBER_OF_CARDS_IN_FULL_DECK, instance.getUndealtCards().size());

    // try modifing the list
    try {
      instance.getUndealtCards().clear();
      fail("Unsupported operation exception not thrown");
    } catch (UnsupportedOperationException ex) {
      // do nothing
    }

  }

  /**
   * Test of dealCard method, of class CardDeck.
   */
  @Test
  public void testDealCard() {

    System.out.println("dealCard");

    // test dealing a card
    CardDeck instance = new CardDeck();
    Card card = instance.dealCard();
    assertEquals(new Card(Card.Rank.ACE, Card.Suit.HEARTS), card);
    assertEquals(1, instance.getDealtCards().size());
    assertEquals(CardDeck.NUMBER_OF_CARDS_IN_FULL_DECK - 1, instance.getUndealtCards().size());

    // test dealing all card
    instance = new CardDeck();
    for (int i = 0; i < CardDeck.NUMBER_OF_CARDS_IN_FULL_DECK; i++) {
      card = instance.dealCard();
    }
    assertEquals(new Card(Card.Rank.ACE, Card.Suit.SPADES), card);
    assertEquals(CardDeck.NUMBER_OF_CARDS_IN_FULL_DECK, instance.getDealtCards().size());
    assertEquals(0, instance.getUndealtCards().size());

    // test dealing card with no undealt cards left
    instance = new CardDeck();
    for (int i = 0; i < CardDeck.NUMBER_OF_CARDS_IN_FULL_DECK; i++) {
      instance.dealCard();
    }
    card = instance.dealCard();
    assertEquals(null, card);
    assertEquals(CardDeck.NUMBER_OF_CARDS_IN_FULL_DECK, instance.getDealtCards().size());
    assertEquals(0, instance.getUndealtCards().size());

  }

  /**
   * Test of reset method, of class CardDeck.
   */
  @Test
  public void testReset() {

    System.out.println("reset");

    // test with new card deck
    CardDeck instance = new CardDeck();
    instance.reset();
    assertEquals(new CardDeck(), instance);
    assertEquals(0, instance.getDealtCards().size());
    assertEquals(CardDeck.NUMBER_OF_CARDS_IN_FULL_DECK, instance.getUndealtCards().size());

    // test with dealt card deck
    instance = new CardDeck();
    instance.dealCard();
    instance.reset();
    assertEquals(0, instance.getDealtCards().size());
    assertEquals(CardDeck.NUMBER_OF_CARDS_IN_FULL_DECK, instance.getUndealtCards().size());

    // test with no undealt cards left
    instance = new CardDeck();
    for (int i = 0; i < CardDeck.NUMBER_OF_CARDS_IN_FULL_DECK; i++) {
      instance.dealCard();
    }
    instance.reset();
    assertEquals(new CardDeck(), instance);
    assertEquals(0, instance.getDealtCards().size());
    assertEquals(CardDeck.NUMBER_OF_CARDS_IN_FULL_DECK, instance.getUndealtCards().size());

  }

  /**
   * Test of shuffle method, of class CardDeck.
   */
  @Test
  public void testShuffle() {

    System.out.println("shuffle");

    /**
     * While unlikely, it is possible for Collections.shuffle to return the list in the same order.
     * It is even more unlikely for the method to return the list in the same order multiple times.
     * So we will check for a different order 10 different times and if the order is the same all 10
     * times, we will fail.
     */
    List<Card> newDeckOrder = new CardDeck().getUndealtCards();
    CardDeck instance = new CardDeck();
    boolean sameOrder = true;
    for (int i = 0; i < 10; i++) {
      instance.shuffle();
      assertEquals(0, instance.getDealtCards().size());
      assertEquals(CardDeck.NUMBER_OF_CARDS_IN_FULL_DECK, instance.getUndealtCards().size());
      if (!instance.getUndealtCards().equals(newDeckOrder)) {
        sameOrder = false;
        break;
      }
    }
    if (sameOrder) {
      fail("Card deck is not shuffled\n");
    }

  }

  /**
   * Test of equals method, of class CardDeck.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testEquals() {

    System.out.println("equals");

    // test same object
    Object obj = new CardDeck();
    CardDeck instance = (CardDeck) obj;
    boolean expResult = true;
    boolean result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with null
    obj = null;
    instance = new CardDeck();
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with different class
    obj = new Object();
    instance = new CardDeck();
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test equal objects
    obj = new CardDeck();
    instance = new CardDeck();
    expResult = true;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test different card decks
    obj = new CardDeck();
    instance = new CardDeck();
    instance.dealCard();
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with a different order
    obj = new CardDeck();
    instance = new CardDeck();
    instance.dealCard();
    instance.reset();
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

  }

  /**
   * Test of hashCode method, of class CardDeck.
   */
  @Test
  public void testHashCode() {

    System.out.println("hashCode");

    CardDeck instance1 = new CardDeck();
    CardDeck instance2 = new CardDeck();
    assertEquals(instance1.hashCode(), instance2.hashCode());

  }

  /**
   * Test of toString method, of class CardDeck.
   */
  @Test
  public void testToString() {

    System.out.println("toString");

    // test with new card deck
    CardDeck instance = new CardDeck();
    String expResult = "52 undealt cards [AH,2H,3H,4H,5H,6H,7H,8H,9H,10H,JH,QH,KH,AC,2C,3C,4C,5C,"
        + "6C,7C,8C,9C,10C,JC,QC,KC,KD,QD,JD,10D,9D,8D,7D,6D,5D,4D,3D,2D,AD,KS,QS,JS,10S,9S,8S,"
        + "7S,6S,5S,4S,3S,2S,AS], 0 dealt cards []";
    String result = instance.toString();
    assertEquals(expResult, result);

    // test with fully dealt card deck
    instance = new CardDeck();
    for (int i = 0; i < CardDeck.NUMBER_OF_CARDS_IN_FULL_DECK; i++) {
      instance.dealCard();
    }
    expResult = "0 undealt cards [], 52 dealt cards [AH,2H,3H,4H,5H,6H,7H,8H,9H,10H,JH,QH,KH,AC,"
        + "2C,3C,4C,5C,6C,7C,8C,9C,10C,JC,QC,KC,KD,QD,JD,10D,9D,8D,7D,6D,5D,4D,3D,2D,AD,KS,QS,"
        + "JS,10S,9S,8S,7S,6S,5S,4S,3S,2S,AS]";
    result = instance.toString();
    assertEquals(expResult, result);

  }

}
