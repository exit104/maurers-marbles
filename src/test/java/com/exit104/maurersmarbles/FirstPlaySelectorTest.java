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
 * The FirstPlaySelectorTest class contains the unit tests for the FirstPlaySelector class.
 *
 * @author Daniel Uppenkamp
 */
public class FirstPlaySelectorTest {

  public FirstPlaySelectorTest() {
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
   * Test of constructor method, of class FirstPlaySelector.
   */
  @Test
  public void testFirstPlaySelector() {

    System.out.println("constructor");

    new FirstPlaySelector();

  }

  /**
   * Test of select method, of class FirstPlaySelector.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testSelect() {

    System.out.println("select");

    // test with null game
    FirstPlaySelector instance = new FirstPlaySelector();
    Game game = null;
    Set<Play> plays = null;
    try {
      instance.select(game, plays);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with null plays
    instance = new FirstPlaySelector();
    game = new Game(4);
    plays = null;
    try {
      instance.select(game, plays);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with empty plays
    instance = new FirstPlaySelector();
    game = new Game(4);
    plays = new LinkedHashSet<>();
    try {
      instance.select(game, plays);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with game and plays
    instance = new FirstPlaySelector();
    game = new Game(4);
    plays = new LinkedHashSet<>();
    plays.add(new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 1, 2)));
    plays.add(new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(1, 2, 3)));
    Play expResult = new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 1, 2));
    Play result = instance.select(game, plays);
    assertEquals(expResult, result);

  }

}
