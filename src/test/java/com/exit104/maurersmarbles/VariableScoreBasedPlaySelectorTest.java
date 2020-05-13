/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.exit104.maurersmarbles.Card.Rank;
import com.exit104.maurersmarbles.Card.Suit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The VariableScoreBasedPlaySelectorTest class contains the unit tests for the
 * VariableScoreBasedPlaySelector class.
 *
 * @author Daniel Uppenkamp
 */
public class VariableScoreBasedPlaySelectorTest {

  public VariableScoreBasedPlaySelectorTest() {
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
   * Test of constructor method, of class VariableScoreBasedPlaySelector.
   */
  @Test
  public void testVariableScoreBasedPlaySelector() {

    System.out.println("constructor");

    // test with null game
    Game game = null;
    int playerNumber = 0;
    float random = 0.0f;
    try {
      new VariableScoreBasedPlaySelector(game, playerNumber, random);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with invalid player number
    game = new Game(4);
    playerNumber = -1;
    random = 0.0f;
    try {
      new VariableScoreBasedPlaySelector(game, playerNumber, random);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid player number
    game = new Game(4);
    playerNumber = 4;
    random = 0.0f;
    try {
      new VariableScoreBasedPlaySelector(game, playerNumber, random);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid random
    game = new Game(4);
    playerNumber = 0;
    random = -1.0f;
    try {
      new VariableScoreBasedPlaySelector(game, playerNumber, random);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid random
    game = new Game(4);
    playerNumber = 0;
    random = 2.0f;
    try {
      new VariableScoreBasedPlaySelector(game, playerNumber, random);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with valid values
    game = new Game(4);
    playerNumber = 0;
    random = 1.0f;
    new VariableScoreBasedPlaySelector(game, playerNumber, random);

  }

  /**
   * Test of setAvailablePlays method, of class VariableScoreBasedPlaySelector.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testSetAvailablePlays() {

    System.out.println("setAvailablePlays");

    // test with null
    Game game = new Game(4);
    int playerNumber = 0;
    float random = 0.0f;
    VariableScoreBasedPlaySelector instance = new VariableScoreBasedPlaySelector(game, playerNumber,
        random);
    Set<Play> plays = null;
    try {
      instance.setAvailablePlays(plays);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with empty set
    game = new Game(4);
    playerNumber = 0;
    random = 0.0f;
    instance = new VariableScoreBasedPlaySelector(game, playerNumber, random);
    plays = Collections.emptySet();
    try {
      instance.setAvailablePlays(plays);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with two plays to select from, always select based on score
    game = new Game(4);
    game.getPlayers().get(0).getMarbles().get(0).setBoardIndex(0);
    playerNumber = 0;
    random = 0.0f;
    instance = new VariableScoreBasedPlaySelector(game, playerNumber, random);
    plays = new LinkedHashSet<>();
    plays.add(new Play(new Card(Rank.TWO, Suit.CLUBS), new Move(0, 0, 2)));
    plays.add(new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 0, 1)));
    instance.setAvailablePlays(plays);
    assertEquals(plays.iterator().next(), instance.selectedPlay);

    // test with two plays to select from, always select randomly
    game = new Game(4);
    game.getPlayers().get(0).getMarbles().get(0).setBoardIndex(0);
    playerNumber = 0;
    random = 1.0f;
    instance = new VariableScoreBasedPlaySelector(game, playerNumber, random);
    plays = new LinkedHashSet<>();
    plays.add(new Play(new Card(Rank.TWO, Suit.CLUBS), new Move(0, 0, 2)));
    plays.add(new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 0, 1)));
    instance.setAvailablePlays(plays);
    assertTrue(plays.contains(instance.selectedPlay));

  }

}
