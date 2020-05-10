/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The GridBoardLayoutTest class contains the unit tests for the GridBoardLayout class.
 *
 * @author Daniel Uppenkamp
 */
public class GridBoardLayoutTest {

  public GridBoardLayoutTest() {
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
   * Test of constructor method, of class GridBoardLayout.
   */
  @Test
  public void testGridBoardLayout() {

    System.out.println("constructor");

    // test with null board
    Board board = null;
    try {
      new GridBoardLayout(board);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with valid boards
    for (int numberOfPlayers = 4; numberOfPlayers <= 8; numberOfPlayers += 2) {
      board = new Board(numberOfPlayers);
      new GridBoardLayout(board);
    }

  }

  /**
   * Test of getBoundsForBoardIndex method, of class GridBoardLayout.
   */
  @Test
  public void testGetBoundsForBoardIndex() {

    System.out.println("getBoundsForBoardIndex");

    // test with invalid board index
    Board board = new Board(4);
    GridBoardLayout instance = new GridBoardLayout(board);
    int boardIndex = -1;
    try {
      instance.getBoundsForBoardIndex(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid board index
    board = new Board(4);
    instance = new GridBoardLayout(board);
    boardIndex = board.getNumberOfPlayableSpaces();
    try {
      instance.getBoundsForBoardIndex(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    board = new Board(4);
    instance = new GridBoardLayout(board);
    boardIndex = 0;
    instance.getBoundsForBoardIndex(boardIndex);

  }

  /**
   * Test of getBoundsForMarble method, of class GridBoardLayout.
   */
  @Test
  public void testGetBoundsForMarble() {

    System.out.println("getBoundsForMarble");

// test with invalid board index
    Board board = new Board(4);
    GridBoardLayout instance = new GridBoardLayout(board);
    int boardIndex = -1;
    try {
      instance.getBoundsForMarble(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid board index
    board = new Board(4);
    instance = new GridBoardLayout(board);
    boardIndex = board.getNumberOfPlayableSpaces();
    try {
      instance.getBoundsForMarble(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    board = new Board(4);
    instance = new GridBoardLayout(board);
    boardIndex = 0;
    instance.getBoundsForMarble(boardIndex);

  }

  /**
   * Test of getBoundsForSpace method, of class GridBoardLayout.
   */
  @Test
  public void testGetBoundsForSpace() {

    System.out.println("getBoundsForSpace");

// test with invalid board index
    Board board = new Board(4);
    GridBoardLayout instance = new GridBoardLayout(board);
    int boardIndex = -1;
    try {
      instance.getBoundsForSpace(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid board index
    board = new Board(4);
    instance = new GridBoardLayout(board);
    boardIndex = board.getNumberOfPlayableSpaces();
    try {
      instance.getBoundsForSpace(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    board = new Board(4);
    instance = new GridBoardLayout(board);
    boardIndex = 0;
    instance.getBoundsForSpace(boardIndex);

  }

}
