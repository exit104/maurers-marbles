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

import java.util.Collections;
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
   * Test of setAvailablePlays method, of class FirstPlaySelector.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testSetAvailablePlays() {

    System.out.println("setAvailablePlays");

    // test with null
    FirstPlaySelector instance = new FirstPlaySelector();
    Set<Play> plays = null;
    try {
      instance.setAvailablePlays(plays);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with empty set
    instance = new FirstPlaySelector();
    plays = Collections.emptySet();
    try {
      instance.setAvailablePlays(plays);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with populated set
    instance = new FirstPlaySelector();
    plays = Collections.singleton(new Play(
        new Card(Rank.ACE, Suit.CLUBS), new Move(0, 0, 0)));
    instance.setAvailablePlays(plays);
    assertEquals(plays.iterator().next(), instance.selectedPlay);

  }

}
