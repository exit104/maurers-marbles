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
 * The PlaySelectorTest class contains the unit tests for the PlaySelector class.
 *
 * @author Daniel Uppenkamp
 */
public class PlaySelectorTest {

  public PlaySelectorTest() {
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
   * Test of constructor method, of class PlaySelector.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testPlaySelector() {

    System.out.println("constructor");

    new PlaySelector();

  }

  /**
   * Test of setAvailablePlays method, of class PlaySelector.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testSetAvailablePlays() {

    System.out.println("setAvailablePlays");

    // test with null
    PlaySelector instance = new PlaySelector();
    Set<Play> plays = null;
    try {
      instance.setAvailablePlays(plays);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with empty set
    instance = new PlaySelector();
    plays = Collections.emptySet();
    try {
      instance.setAvailablePlays(plays);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with populated set
    instance = new PlaySelector();
    plays = Collections.singleton(new Play(
        new Card(Rank.ACE, Suit.CLUBS), new Move(0, 0, 0)));
    instance.setAvailablePlays(plays);

  }

  /**
   * Test of getSelectedPlay method, of class PlaySelector.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testGetSelectedPlay() {

    System.out.println("getSelectedPlay");

    // test with null selected play
    PlaySelector instance = new PlaySelector();
    Play expResult = null;
    Play result = instance.getSelectedPlay();
    assertEquals(expResult, result);

    // test with selected play
    instance = new PlaySelector();
    instance.setSelectedPlay(new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 0, 0)));
    expResult = new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 0, 0));
    result = instance.getSelectedPlay();
    assertEquals(expResult, result);

  }

  /**
   * Test of setSelectedPlay method, of class PlaySelector.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testSetSelectedPlay() {

    System.out.println("setSelectedPlay");

    // test with null selected play
    PlaySelector instance = new PlaySelector();
    Play selectedPlay = null;
    instance.setSelectedPlay(selectedPlay);
    Play result = instance.getSelectedPlay();
    assertEquals(selectedPlay, result);

    // test with selected play
    instance = new PlaySelector();
    selectedPlay = new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 0, 0));
    instance.setSelectedPlay(selectedPlay);
    result = instance.getSelectedPlay();
    assertEquals(selectedPlay, result);

  }

}
