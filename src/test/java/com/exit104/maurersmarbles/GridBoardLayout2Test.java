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
 * The GridBoardLayout2Test class contains the unit tests for the GridBoardLayout2 class.
 *
 * @author Daniel Uppenkamp
 */
public class GridBoardLayout2Test {

  public GridBoardLayout2Test() {
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
   * Test of constructor method, of class GridBoardLayout2.
   */
  @Test
  public void testGridBoardLayout2() {

    System.out.println("constructor");

    // test with null board
    Board board = null;
    try {
      new GridBoardLayout2(board);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with all valid number of players
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      board = new Board(numberOfPlayers);
      new GridBoardLayout2(board);
    }

  }

  /**
   * Test of getAngleForBoardIndex method, of class GridBoardLayout2.
   */
  @Test
  @SuppressWarnings("PMD.UseUnderscoresInNumericLiterals")
  public void testGetAngleForBoardIndex() {

    System.out.println("getAngleForBoardIndex");

    // test with invalid board index
    Board board = new Board(4);
    GridBoardLayout2 instance = new GridBoardLayout2(board);
    int boardIndex = -1;
    try {
      instance.getAngleForBoardIndex(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid board index
    board = new Board(4);
    instance = new GridBoardLayout2(board);
    boardIndex = board.getNumberOfPlayableSpaces();
    try {
      instance.getAngleForBoardIndex(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with all valid number of players
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      board = new Board(numberOfPlayers);
      instance = new GridBoardLayout2(board);
      for (boardIndex = 0; boardIndex < board.getNumberOfPlayableSpaces(); boardIndex++) {
        instance.getAngleForBoardIndex(boardIndex);
      }
    }

  }

  /**
   * Test of getBoundsForDiscardPile method, of class GridBoardLayout2.
   */
  @Test
  @SuppressWarnings("PMD.UseUnderscoresInNumericLiterals")
  public void testGetBoundsForDiscardPile() {

    System.out.println("getBoundsForDiscardPile");

    Board board = new Board(4);
    GridBoardLayout2 instance = new GridBoardLayout2(board);
    instance.getBoundsForDiscardPile();

  }

  /**
   * Test of getBoundsForMarble method, of class GridBoardLayout2.
   */
  @Test
  public void testGetBoundsForMarble() {

    System.out.println("getBoundsForMarble");

    // test with invalid board index
    Board board = new Board(4);
    GridBoardLayout2 instance = new GridBoardLayout2(board);
    int boardIndex = -1;
    try {
      instance.getBoundsForMarble(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid board index
    board = new Board(4);
    instance = new GridBoardLayout2(board);
    boardIndex = board.getNumberOfPlayableSpaces();
    try {
      instance.getBoundsForMarble(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    board = new Board(4);
    instance = new GridBoardLayout2(board);
    boardIndex = 0;
    instance.getBoundsForMarble(boardIndex);

  }

  /**
   * Test of getBoundsForSpace method, of class GridBoardLayout2.
   */
  @Test
  public void testGetBoundsForSpace() {

    System.out.println("getBoundsForSpace");

    // test with invalid board index
    Board board = new Board(4);
    GridBoardLayout2 instance = new GridBoardLayout2(board);
    int boardIndex = -1;
    try {
      instance.getBoundsForSpace(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid board index
    board = new Board(4);
    instance = new GridBoardLayout2(board);
    boardIndex = board.getNumberOfPlayableSpaces();
    try {
      instance.getBoundsForSpace(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with all valid number of players
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      board = new Board(numberOfPlayers);
      instance = new GridBoardLayout2(board);
      for (boardIndex = 0; boardIndex < board.getNumberOfPlayableSpaces(); boardIndex++) {
        instance.getBoundsForSpace(boardIndex);
      }
    }

  }

}
