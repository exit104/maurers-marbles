/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.exit104.maurersmarbles.Card.Rank;
import com.exit104.maurersmarbles.Card.Suit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The PlayTest class contains the unit tests for the Play class.
 *
 * @author Daniel Uppenkamp
 */
public class PlayTest {

  public PlayTest() {
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
   * Test of constructor method, of class Play.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testPlay_Card_Move() {

    System.out.println("constructor");

    // test with null card
    Card card = null;
    Move move = null;
    try {
      new Play(card, move);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with null move
    card = new Card(Rank.ACE, Suit.CLUBS);
    move = null;
    try {
      new Play(card, move);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with card and move
    card = new Card(Rank.ACE, Suit.CLUBS);
    move = new Move(0, 1, 2);
    Play play = new Play(card, move);
    assertEquals(card, play.getCard());
    assertEquals(move, play.getMoves().iterator().next());

  }

  /**
   * Test of constructor method, of class Play.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testPlay_Card_Set() {

    System.out.println("constructor");

    // test with null card
    Card card = null;
    Set<Move> moves = null;
    try {
      new Play(card, moves);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with null moves
    card = new Card(Rank.ACE, Suit.CLUBS);
    moves = null;
    try {
      new Play(card, moves);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with empty moves
    card = new Card(Rank.ACE, Suit.CLUBS);
    moves = new LinkedHashSet<>();
    try {
      new Play(card, moves);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with card and single move
    card = new Card(Rank.ACE, Suit.CLUBS);
    moves = new LinkedHashSet<>();
    moves.add(new Move(0, 1, 2));
    Play play = new Play(card, moves);
    assertEquals(card, play.getCard());
    assertEquals(moves, play.getMoves());

    // test with card and multiple moves
    card = new Card(Rank.ACE, Suit.CLUBS);
    moves = new LinkedHashSet<>();
    moves.add(new Move(0, 1, 2));
    moves.add(new Move(1, 2, 3));
    play = new Play(card, moves);
    assertEquals(moves, play.getMoves());

    // test with card and multiple moves (with repeats and different order)
    card = new Card(Rank.ACE, Suit.CLUBS);
    moves = new LinkedHashSet<>();
    moves.add(new Move(0, 1, 2));
    moves.add(new Move(0, 1, 2));
    moves.add(new Move(1, 2, 3));
    moves.add(new Move(1, 2, 3));
    play = new Play(card, moves);
    assertEquals(card, play.getCard());
    assertEquals(moves, play.getMoves());

  }

  /**
   * Test of getCard method, of class Play.
   */
  @Test
  public void testGetCard() {

    System.out.println("getCard");

    Card card = new Card(Rank.ACE, Suit.CLUBS);
    Play play = new Play(card, new Move(0, 1, 2));
    assertEquals(card, play.getCard());

  }

  /**
   * Test of getMove method, of class Play.
   */
  @Test
  public void testGetMove() {

    System.out.println("getMove");

    Move move = new Move(0, 1, 2);
    Play play = new Play(new Card(Rank.ACE, Suit.CLUBS), move);
    assertEquals(move, play.getMoves().iterator().next());

    // try modifying the moves list
    try {
      play.getMoves().clear();
      fail("Unsupported operation exception not thrown");
    } catch (UnsupportedOperationException ex) {
      // do nothing
    }

  }

  /**
   * Test of equals method, of class Play.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testEquals() {

    System.out.println("equals");

    // test with same object
    Object obj = new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 1, 2));
    Play instance = (Play) obj;
    boolean expResult = true;
    boolean result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with null
    obj = null;
    instance = new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 1, 2));
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with different class
    obj = new Object();
    instance = new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 1, 2));
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with equal objects
    obj = new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 1, 2));
    instance = new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 1, 2));
    expResult = true;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with different card
    obj = new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 1, 2));
    instance = new Play(new Card(Rank.ACE, Suit.DIAMONDS), new Move(0, 1, 2));
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with different moves
    obj = new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 1, 2));
    instance = new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(1, 2, 3));
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with different move order
    Set<Move> moves = new LinkedHashSet<>();
    moves.add(new Move(0, 1, 2));
    moves.add(new Move(1, 2, 3));
    obj = new Play(new Card(Rank.ACE, Suit.CLUBS), moves);
    moves = new LinkedHashSet<>();
    moves.add(new Move(1, 2, 3));
    moves.add(new Move(0, 1, 2));
    instance = new Play(new Card(Rank.ACE, Suit.CLUBS), moves);
    expResult = true;
    result = instance.equals(obj);
    assertEquals(expResult, result);

  }

  /**
   * Test of hashCode method, of class Play.
   */
  @Test
  public void testHashCode() {

    System.out.println("hashCode");

    Play instance1 = new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 1, 2));
    Play instance2 = new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 1, 2));
    assertEquals(instance1.hashCode(), instance2.hashCode());

  }

}
