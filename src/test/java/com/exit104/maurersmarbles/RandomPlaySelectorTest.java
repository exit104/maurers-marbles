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

import java.util.Collections;
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
  public void testRandomPlaySelector() {

    System.out.println("constructor");

    new RandomPlaySelector();

  }

  /**
   * Test of setAvailablePlays method, of class RandomPlaySelector.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testSetAvailablePlays() {

    System.out.println("setAvailablePlays");

    // test with null
    RandomPlaySelector instance = new RandomPlaySelector();
    Set<Play> plays = null;
    try {
      instance.setAvailablePlays(plays);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with empty set
    instance = new RandomPlaySelector();
    plays = Collections.emptySet();
    try {
      instance.setAvailablePlays(plays);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with populated set, test multiple times to increase likelyhood of executing iterator
    for (int i = 0; i < 10; i++) {
      instance = new RandomPlaySelector();
      plays = new LinkedHashSet<>();
      plays.add(new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 0, 0)));
      plays.add(new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(1, 0, 0)));
      plays.add(new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(2, 0, 0)));
      plays.add(new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(3, 0, 0)));
      instance.setAvailablePlays(plays);
      assertTrue(plays.contains(instance.selectedPlay));
    }

  }

}
