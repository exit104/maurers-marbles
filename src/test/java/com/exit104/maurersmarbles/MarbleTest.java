/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The MarbleTest class contains the unit tests for the Marble class.
 *
 * @author Daniel Uppenkamp
 */
public class MarbleTest {

  public MarbleTest() {
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
   * Test of constructor method, of class Marble.
   */
  @Test
  public void testMarble_int_int_int() {

    System.out.println("constructor");

    int playerNumber = 0;
    int marbleNumber = 0;
    int boardIndex = 0;
    Marble marble = new Marble(playerNumber, marbleNumber, boardIndex);
    assertEquals(playerNumber, marble.getPlayerNumber());
    assertEquals(marbleNumber, marble.getMarbleNumber());
    assertEquals(boardIndex, marble.getBoardIndex());
    assertEquals(Marble.NO_PREVIOUS_BOARD_INDEX, marble.getPreviousBoardIndex());

  }

  /**
   * Test of constructor method, of class Marble.
   */
  @Test
  public void testMarble_int_int_int_int() {

    System.out.println("constructor");

    int playerNumber = 0;
    int marbleNumber = 0;
    int boardIndex = 0;
    int previousBoardIndex = Marble.NO_PREVIOUS_BOARD_INDEX;
    Marble marble = new Marble(playerNumber, marbleNumber, boardIndex, previousBoardIndex);
    assertEquals(playerNumber, marble.getPlayerNumber());
    assertEquals(marbleNumber, marble.getMarbleNumber());
    assertEquals(boardIndex, marble.getBoardIndex());
    assertEquals(previousBoardIndex, marble.getPreviousBoardIndex());

  }

  /**
   * Test of copy constructor method, of class Marble.
   */
  @Test
  public void testMarble_Marble() {

    System.out.println("copy constructor");

    // test with null marble
    Marble marble = null;
    try {
      new Marble(marble);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with marble
    marble = new Marble(1, 2, 3);
    Marble instance = new Marble(marble);
    assertEquals(marble, instance);

  }

  /**
   * Test of getBoardIndex method, of class Marble.
   */
  @Test
  public void testGetBoardIndex() {

    System.out.println("getBoardIndex");

    Marble instance = new Marble(0, 1, 2, 3);
    int expResult = 2;
    int result = instance.getBoardIndex();
    assertEquals(expResult, result);

  }

  /**
   * Test of setBoardIndex method, of class Marble.
   */
  @Test
  public void testSetBoardIndex() {

    System.out.println("setBoardIndex");

    int boardIndex = 0;
    Marble instance = new Marble(0, 1, 2, 3);
    instance.setBoardIndex(boardIndex);
    assertEquals(boardIndex, instance.getBoardIndex());

  }

  /**
   * Test of getMarbleNumber method, of class Marble.
   */
  @Test
  public void testGetMarbleNumber() {

    System.out.println("getMarbleNumber");

    Marble instance = new Marble(0, 1, 2, 3);
    int expResult = 1;
    int result = instance.getMarbleNumber();
    assertEquals(expResult, result);

  }

  /**
   * Test of getPreviousBoardIndex method, of class Marble.
   */
  @Test
  public void testGetPreviousBoardIndex() {

    System.out.println("getPreviousBoardIndex");

    Marble instance = new Marble(0, 1, 2, 3);
    int expResult = 3;
    int result = instance.getPreviousBoardIndex();
    assertEquals(expResult, result);

  }

  /**
   * Test of setPreviousBoardIndex method, of class Marble.
   */
  @Test
  public void testSetPreviousBoardIndex() {

    System.out.println("setPreviousBoardIndex");

    // test with no prevous board index
    Marble instance = new Marble(0, 1, 2, 3);
    int previousBoardIndex = Marble.NO_PREVIOUS_BOARD_INDEX;
    instance.setPreviousBoardIndex(previousBoardIndex);
    assertEquals(previousBoardIndex, instance.getPreviousBoardIndex());

    // test with prevous board index on the board
    instance = new Marble(0, 1, 2, 3);
    previousBoardIndex = 0;
    instance.setPreviousBoardIndex(previousBoardIndex);
    assertEquals(previousBoardIndex, instance.getPreviousBoardIndex());

  }

  /**
   * Test of getPlayerNumber method, of class Marble.
   */
  @Test
  public void testGetPlayerNumber() {

    System.out.println("getPlayerNumber");

    Marble instance = new Marble(0, 1, 2, 3);
    int expResult = 0;
    int result = instance.getPlayerNumber();
    assertEquals(expResult, result);

  }

  /**
   * Test of equals method, of class Marble.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testEquals() {

    System.out.println("equals");

    // test same object
    Object obj = new Marble(0, 1, 2, 3);
    Marble instance = (Marble) obj;
    boolean expResult = true;
    boolean result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with null
    obj = null;
    instance = new Marble(0, 1, 2, 3);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with different class
    obj = new Object();
    instance = new Marble(0, 1, 2, 3);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test equal objects
    obj = new Marble(0, 1, 2, 3);
    instance = new Marble(0, 1, 2, 3);
    expResult = true;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test different player number
    obj = new Marble(0, 1, 2, 3);
    instance = new Marble(1, 1, 2, 3);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test different marble number
    obj = new Marble(0, 1, 2, 3);
    instance = new Marble(0, 2, 2, 3);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test different board index
    obj = new Marble(0, 1, 2, 3);
    instance = new Marble(0, 1, 3, 3);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test different previous board index
    obj = new Marble(0, 1, 2, 3);
    instance = new Marble(0, 1, 2, 4);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

  }

  /**
   * Test of hashCode method, of class Marble.
   */
  @Test
  public void testHashCode() {

    System.out.println("hashCode");

    Marble instance1 = new Marble(0, 1, 2, 3);
    Marble instance2 = new Marble(0, 1, 2, 3);
    assertEquals(instance1.hashCode(), instance2.hashCode());

  }

}
