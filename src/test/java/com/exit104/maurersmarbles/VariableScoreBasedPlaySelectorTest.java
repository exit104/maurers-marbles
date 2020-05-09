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

    // test with invalid random
    int playerNumber = 0;
    float random = -1.0f;
    try {
      new VariableScoreBasedPlaySelector(playerNumber, random);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid random
    playerNumber = 0;
    random = 2.0f;
    try {
      new VariableScoreBasedPlaySelector(playerNumber, random);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    playerNumber = 0;
    random = 1.0f;
    new VariableScoreBasedPlaySelector(playerNumber, random);

  }

  /**
   * Test of select method, of class VariableScoreBasedPlaySelector.
   */
  @Test
  public void testSelect() {

    System.out.println("select");

    // test with two plays to select from, always select based on score
    int playerNumber = 0;
    float random = 0.0f;
    Game game = new Game(4);
    game.getPlayers().get(0).getMarbles().get(0).setBoardIndex(0);
    VariableScoreBasedPlaySelector instance = new VariableScoreBasedPlaySelector(playerNumber,
        random);
    Set<Play> plays = new LinkedHashSet<>();
    plays.add(new Play(new Card(Rank.TWO, Suit.CLUBS), new Move(0, 0, 2)));
    plays.add(new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 0, 1)));
    Play expResult = plays.iterator().next();
    Play result = instance.select(game, plays);
    assertEquals(expResult, result);

    // test with two plays to select from, always select randomly
    playerNumber = 0;
    random = 1.0f;
    instance = new VariableScoreBasedPlaySelector(playerNumber, random);
    game = new Game(4);
    game.getPlayers().get(0).getMarbles().get(0).setBoardIndex(0);
    plays = new LinkedHashSet<>();
    plays.add(new Play(new Card(Rank.TWO, Suit.CLUBS), new Move(0, 0, 2)));
    plays.add(new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 0, 1)));
    result = instance.select(game, plays);
    assertTrue(plays.contains(result));

  }

}
