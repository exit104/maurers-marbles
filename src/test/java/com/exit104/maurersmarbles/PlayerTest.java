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

import java.util.ArrayList;
import java.util.List;

/**
 * The PlayerTest class contains the unit tests for the Player class.
 *
 * @author Daniel Uppenkamp
 */
public class PlayerTest {

  public PlayerTest() {
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
   * Test of constructor method, of class Player.
   */
  @Test
  public void testPlayer_int_PlaySelector() {

    System.out.println("constructor");

    // test with null play selector
    int playerNumber = 0;
    PlaySelector playSelector = null;
    try {
      new Player(playerNumber, playSelector);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with play selector
    playerNumber = 1;
    playSelector = new PlaySelector();
    Player player = new Player(playerNumber, playSelector);
    assertEquals(1, player.getPlayerNumber());
    assertEquals(playSelector, player.getPlaySelector());

  }

  /**
   * Test of copy constructor method, of class Player.
   */
  @Test
  public void testPlayer_Player() {

    System.out.println("copy constructor");

    // test with null player
    Player player = null;
    try {
      new Player(player);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with player
    player = new Player(1, new PlaySelector());
    player.getCards().add(new Card(Rank.ACE, Suit.CLUBS));
    player.getMarbles().add(new Marble(1, 0, 0));
    Player instance = new Player(player);
    assertEquals(player, instance);

  }

  /**
   * Test of getPlayerNumber method, of class Player.
   */
  @Test
  public void testGetPlayerNumber() {

    System.out.println("getPlayerNumber");

    Player instance = new Player(1, new PlaySelector());
    int expResult = 1;
    int result = instance.getPlayerNumber();
    assertEquals(expResult, result);

  }

  /**
   * Test of setPlayerNumber method, of class Player.
   */
  @Test
  public void testSetPlayerNumber() {

    System.out.println("setPlayerNumber");

    int playerNumber = 3;
    Player instance = new Player(0, new PlaySelector());
    instance.setPlayerNumber(playerNumber);
    int expResult = 3;
    int result = instance.getPlayerNumber();
    assertEquals(expResult, result);
  }

  /**
   * Test of getCards method, of class Player.
   */
  @Test
  public void testGetCards() {

    System.out.println("getCards");

    Player instance = new Player(0, new PlaySelector());
    List<Card> expResult = new ArrayList<>();
    List<Card> result = instance.getCards();
    assertEquals(expResult, result);

  }

  /**
   * Test of getMarbles method, of class Player.
   */
  @Test
  public void testGetMarbles() {

    System.out.println("getMarbles");

    Player instance = new Player(0, new PlaySelector());
    List<Marble> expResult = new ArrayList<>();
    List<Marble> result = instance.getMarbles();
    assertEquals(expResult, result);

  }

  /**
   * Test of getPlaySelector method, of class Player.
   */
  @Test
  public void testGetPlaySelector() {

    System.out.println("getPlaySelector");

    int playerNumber = 0;
    PlaySelector playSelector = new PlaySelector();
    Player instance = new Player(playerNumber, playSelector);
    PlaySelector expResult = playSelector;
    PlaySelector result = instance.getPlaySelector();
    assertEquals(expResult, result);

  }

  /**
   * Test of setPlaySelector method, of class Player.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testSetPlaySelector() {

    System.out.println("setPlaySelector");

    // test with null
    Player instance = new Player(0, new PlaySelector());
    PlaySelector playSelector = null;
    try {
      instance.setPlaySelector(playSelector);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with play selector
    instance = new Player(0, new PlaySelector());
    playSelector = new PlaySelector();
    instance.setPlaySelector(playSelector);
    PlaySelector expResult = playSelector;
    PlaySelector result = instance.getPlaySelector();
    assertEquals(expResult, result);

  }

  /**
   * Test of equals method, of class Player.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testEquals() {

    System.out.println("equals");

    // test same object
    Object obj = new Player(1, new PlaySelector());
    Player instance = (Player) obj;
    boolean expResult = true;
    boolean result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with null
    obj = null;
    instance = new Player(1, new PlaySelector());
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with different class
    obj = new Object();
    instance = new Player(1, new PlaySelector());
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test equal objects
    PlaySelector playSelector = new PlaySelector();
    obj = new Player(1, playSelector);
    instance = new Player(1, playSelector);
    expResult = true;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test different player numbers
    obj = new Player(0, new PlaySelector());
    instance = new Player(1, new PlaySelector());
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test different cards
    obj = new Player(0, new PlaySelector());
    instance = new Player(0, new PlaySelector());
    instance.getCards().add(new Card(Rank.ACE, Suit.CLUBS));
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test different marbles
    obj = new Player(0, new PlaySelector());
    instance = new Player(0, new PlaySelector());
    instance.getMarbles().add(new Marble(0, 0, 0));
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test different play selectors
    obj = new Player(0, new PlaySelector());
    instance = new Player(0, new PlaySelector());
    expResult = true;
    result = instance.equals(obj);
    assertEquals(expResult, result);

  }

  /**
   * Test of hashCode method, of class Player.
   */
  @Test
  public void testHashCode() {

    System.out.println("hashCode");

    PlaySelector playSelector = new PlaySelector();
    Player instance1 = new Player(0, playSelector);
    Player instance2 = new Player(0, playSelector);
    assertEquals(instance1.hashCode(), instance2.hashCode());

  }

}
