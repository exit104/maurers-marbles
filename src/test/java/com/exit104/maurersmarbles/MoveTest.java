/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The MoveTest class contains the unit tests for the Move class.
 *
 * @author Daniel Uppenkamp
 */
public class MoveTest {

  public MoveTest() {
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
   * Test of constructor method, of class Move.
   */
  @Test
  public void testMove_int_int_int() {

    System.out.println("constructor");

    int playerNumber = 0;
    int marbleNumber = 0;
    int newMarbleBoardIndex = 0;
    Move move = new Move(playerNumber, marbleNumber, newMarbleBoardIndex);
    assertEquals(playerNumber, move.playerNumber);
    assertEquals(marbleNumber, move.marbleNumber);
    assertEquals(newMarbleBoardIndex, move.newMarbleBoardIndex);

  }

  /**
   * Test of getMarbleNumber method, of class Move.
   */
  @Test
  public void testGetMarbleNumber() {

    System.out.println("getMarbleNumber");

    Move move = new Move(0, 1, 2);
    assertEquals(1, move.getMarbleNumber());

  }

  /**
   * Test of getNewMarbleBoardIndex method, of class Move.
   */
  @Test
  public void testGetNewMarbleBoardIndex() {

    System.out.println("getNewMarbleBoardIndex");

    Move move = new Move(0, 1, 2);
    assertEquals(2, move.getNewMarbleBoardIndex());

  }

  /**
   * Test of getPlayerNumber method, of class Move.
   */
  @Test
  public void testGetPlayerNumber() {

    System.out.println("getPlayerNumber");

    Move move = new Move(0, 1, 2);
    assertEquals(0, move.getPlayerNumber());

  }

  /**
   * Test of equals method, of class Move.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testEquals() {

    System.out.println("equals");

    // test same object
    Object obj = new Move(1, 2, 3);
    Move instance = (Move) obj;
    boolean expResult = true;
    boolean result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with null
    obj = null;
    instance = new Move(1, 2, 3);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with different class
    obj = new Object();
    instance = new Move(1, 2, 3);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test equal objects
    obj = new Move(1, 2, 3);
    instance = new Move(1, 2, 3);
    expResult = true;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test different player number
    obj = new Move(1, 2, 3);
    instance = new Move(0, 2, 3);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test different marble number
    obj = new Move(1, 2, 3);
    instance = new Move(1, 0, 3);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test different new marble board index
    obj = new Move(1, 2, 3);
    instance = new Move(1, 2, 0);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

  }

  /**
   * Test of hashCode method, of class Move.
   */
  @Test
  public void testHashCode() {

    System.out.println("hashCode");

    Move instance1 = new Move(1, 2, 3);
    Move instance2 = new Move(1, 2, 3);
    assertEquals(instance1.hashCode(), instance2.hashCode());

  }

}
