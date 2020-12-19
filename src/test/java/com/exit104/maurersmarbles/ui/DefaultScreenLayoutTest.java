/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.ui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import com.exit104.maurersmarbles.Game;
import com.exit104.maurersmarbles.Rectangle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The DefaultScreenLayoutTest class contains the unit tests for the DefaultScreenLayout class.
 *
 * @author Daniel Uppenkamp
 */
public class DefaultScreenLayoutTest {

  public DefaultScreenLayoutTest() {
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
   * Test of constructor method, of class DefaultScreenLayout.
   */
  @Test
  public void testDefaultScreenLayout() {

    System.out.println("constructor");

    // test with valid number of players
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      ScreenLayout screenLayout = new DefaultScreenLayout(numberOfPlayers);
      assertNotNull(screenLayout);
    }

    // test with invalid number of players
    try {
      new DefaultScreenLayout(0);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

  }

  /**
   * Test of getBoundsForBoard method, of class DefaultScreenLayout.
   */
  @Test
  public void testGetBoundsForBoard() {

    System.out.println("getBoundsForBoard");

    // test with landscape
    DefaultScreenLayout instance = new DefaultScreenLayout(4);
    instance.update(2.0f, 1.0f);
    Rectangle expResult = new Rectangle(0.0f, 0.0f, 1.0f, 1.0f);
    Rectangle result = instance.getBoundsForBoard();
    assertEquals(expResult, result);

    // test with portrait
    instance = new DefaultScreenLayout(4);
    instance.update(1.0f, 2.0f);
    expResult = new Rectangle(0.0f, 0.5f, 1.0f, 1.0f);
    result = instance.getBoundsForBoard();
    assertEquals(expResult, result);

    // test with square
    instance = new DefaultScreenLayout(4);
    instance.update(1.0f, 1.0f);
    expResult = new Rectangle(0.0f, 0.0f, 1.0f, 1.0f);
    result = instance.getBoundsForBoard();
    assertEquals(expResult, result);

  }

  /**
   * Test of getBoundsForPlayer method, of class DefaultScreenLayout.
   */
  @Test
  public void testGetBoundsForPlayer() {

    System.out.println("getBoundsForPlayer");

    // test with invalid player number
    int playerNumber = -1;
    DefaultScreenLayout instance = new DefaultScreenLayout(4);
    try {
      instance.getBoundsForPlayer(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid player number
    playerNumber = 4;
    instance = new DefaultScreenLayout(4);
    try {
      instance.getBoundsForPlayer(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with 4 players, landscape
    playerNumber = 0;
    instance = new DefaultScreenLayout(4);
    instance.update(2.0f, 1.0f);
    Rectangle expResult = new Rectangle(1.0f, 1.0f / 3.0f, 1.0f, 1.0f / 3.0f);
    Rectangle result = instance.getBoundsForPlayer(playerNumber);
    assertEquals(expResult, result);
    for (playerNumber = 1; playerNumber < 4; playerNumber++) {
      expResult = new Rectangle(1.0f + (1.0f / 3.0f * (playerNumber - 1)), 0.0f, 1.0f / 3.0f,
          1.0f / 3.0f);
      result = instance.getBoundsForPlayer(playerNumber);
      assertEquals(expResult, result);
    }

    // test with 4 players, portrait
    playerNumber = 0;
    instance = new DefaultScreenLayout(4);
    instance.update(1.0f, 2.0f);
    expResult = new Rectangle(0.0f, 1.5f, 1.0f, 0.5f);
    result = instance.getBoundsForPlayer(playerNumber);
    assertEquals(expResult, result);
    for (playerNumber = 1; playerNumber < 4; playerNumber++) {
      expResult = new Rectangle(1.0f / 3.0f * (playerNumber - 1), 0.0f, 1.0f / 3.0f, 0.5f);
      result = instance.getBoundsForPlayer(playerNumber);
      assertEquals(expResult, result);
    }

  }

}
