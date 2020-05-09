/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import static org.junit.Assert.assertTrue;
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
 * The RandomPlaySelectorTest class contains the unit tests for the RandomPlaySelector class.
 *
 * @author Daniel Uppenkamp
 */
public class RandomPlaySelectorTest {

  public RandomPlaySelectorTest() {
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
   * Test of constructor method, of class RandomPlaySelector.
   */
  @Test
  public void testFirstPlaySelector() {

    System.out.println("constructor");

    new RandomPlaySelector();

  }

  /**
   * Test of select method, of class RandomPlaySelector.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testSelect() {

    System.out.println("select");

    // test with null game
    RandomPlaySelector instance = new RandomPlaySelector();
    Game game = null;
    Set<Play> plays = null;
    try {
      instance.select(game, plays);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with null plays
    instance = new RandomPlaySelector();
    game = new Game(4);
    plays = null;
    try {
      instance.select(game, plays);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with empty plays
    instance = new RandomPlaySelector();
    game = new Game(4);
    plays = new LinkedHashSet<>();
    try {
      instance.select(game, plays);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with game and plays
    instance = new RandomPlaySelector();
    game = new Game(4);
    plays = new LinkedHashSet<>();
    plays.add(new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 1, 2)));
    plays.add(new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(1, 2, 3)));
    Play play = instance.select(game, plays);
    assertTrue(plays.contains(play));

  }

}
