/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The RectangleBoardLayoutTest class contains the unit tests for the RectangleBoardLayout class.
 *
 * @author Daniel Uppenkamp
 */
public class RectangleBoardLayoutTest {

  public RectangleBoardLayoutTest() {
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
   * Test of constructor method, of class RectangleBoardLayout.
   */
  @Test
  public void testRectangleBoardLayout() {

    System.out.println("constructor");

    // test with null board
    Board board = null;
    try {
      new RectangleBoardLayout(board);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with all valid number of players
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      board = new Board(numberOfPlayers);
      new RectangleBoardLayout(board);
    }

  }

  /**
   * Test of update method, of class RectangleBoardLayout.
   */
  @Test
  public void testUpdate() {

    System.out.println("update");

    // test with all valid number of players with both screen orientations
    Board board;
    RectangleBoardLayout instance;
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {

      // test with valid board in landscape orientation
      board = new Board(numberOfPlayers);
      instance = new RectangleBoardLayout(board);
      instance.update(200.0f, 1.0f);

      // test with valid board in portrait orientation
      board = new Board(numberOfPlayers);
      instance = new RectangleBoardLayout(board);
      instance.update(1.0f, 200.0f);

    }

  }

  /**
   * Test of getAngleForBoardIndex method, of class RectangleBoardLayout.
   */
  @Test
  public void testGetAngleForBoardIndex() {

    System.out.println("getAngleForBoardIndex");

    // test with invalid board index
    Board board = new Board(4);
    RectangleBoardLayout instance = new RectangleBoardLayout(board);
    int boardIndex = -1;
    try {
      instance.getAngleForBoardIndex(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid board index
    board = new Board(4);
    instance = new RectangleBoardLayout(board);
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
      instance = new RectangleBoardLayout(board);
      for (boardIndex = 0; boardIndex < board.getNumberOfPlayableSpaces(); boardIndex++) {
        instance.getAngleForBoardIndex(boardIndex);
      }
    }

  }

  /**
   * Test of getBoundsForCardDeck method, of class RectangleBoardLayout.
   */
  @Test
  public void testGetBoundsForCardDeck() {

    System.out.println("getBoundsForCardDeck");

    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      Board board = new Board(numberOfPlayers);
      RectangleBoardLayout instance = new RectangleBoardLayout(board);
      Rectangle rectangle = instance.getBoundsForCardDeck();
      assertTrue(rectangle != null);
    }

  }

  /**
   * Test of getBoundsForDiscardPile method, of class RectangleBoardLayout.
   */
  @Test
  public void testGetBoundsForDiscardPile() {

    System.out.println("getBoundsForDiscardPile");

    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      Board board = new Board(numberOfPlayers);
      RectangleBoardLayout instance = new RectangleBoardLayout(board);
      Rectangle rectangle = instance.getBoundsForDiscardPile();
      assertTrue(rectangle != null);
    }

  }

  /**
   * Test of getBoundsForMarble method, of class RectangleBoardLayout.
   */
  @Test
  public void testGetBoundsForMarble() {

    System.out.println("getBoundsForMarble");

    // test with invalid board index
    Board board = new Board(4);
    RectangleBoardLayout instance = new RectangleBoardLayout(board);
    int boardIndex = -1;
    try {
      instance.getBoundsForMarble(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid board index
    board = new Board(4);
    instance = new RectangleBoardLayout(board);
    boardIndex = board.getNumberOfPlayableSpaces();
    try {
      instance.getBoundsForMarble(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      board = new Board(numberOfPlayers);
      instance = new RectangleBoardLayout(board);
      for (boardIndex = 0; boardIndex < board.getNumberOfPlayableSpaces(); boardIndex++) {
        Rectangle rectangle = instance.getBoundsForMarble(boardIndex);
        assertTrue(rectangle != null);
      }
    }

  }

  /**
   * Test of getBoundsForSpace method, of class RectangleBoardLayout.
   */
  @Test
  public void testGetBoundsForSpace() {

    System.out.println("getBoundsForSpace");

    // test with invalid board index
    Board board = new Board(4);
    RectangleBoardLayout instance = new RectangleBoardLayout(board);
    int boardIndex = -1;
    try {
      instance.getBoundsForSpace(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid board index
    board = new Board(4);
    instance = new RectangleBoardLayout(board);
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
      instance = new RectangleBoardLayout(board);
      for (boardIndex = 0; boardIndex < board.getNumberOfPlayableSpaces(); boardIndex++) {
        Rectangle rectangle = instance.getBoundsForSpace(boardIndex);
        assertTrue(rectangle != null);
      }
    }

  }

}
