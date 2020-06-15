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
 * The CurvedBoardLayoutTest class contains the unit tests for the CurvedBoardLayout class.
 *
 * @author Daniel Uppenkamp
 */
public class CurvedBoardLayoutTest {

  public CurvedBoardLayoutTest() {
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
   * Test of constructor method, of class CurvedBoardLayout.
   */
  @Test
  public void testCurvedBoardLayout() {

    System.out.println("constructor");

    // test with null board
    Board board = null;
    try {
      new CurvedBoardLayout(board);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with all valid number of players
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      board = new Board(numberOfPlayers);
      new CurvedBoardLayout(board);
    }

  }

  /**
   * Test of update method, of class CurvedBoardLayout.
   */
  @Test
  public void testUpdate() {

    System.out.println("update");

    // test with all valid number of players
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      Board board = new Board(numberOfPlayers);
      CurvedBoardLayout instance = new CurvedBoardLayout(board);
      instance.update(2.0f, 1.0f);
    }

  }

  /**
   * Test of updateEightPlayers method, of class CurvedBoardLayout.
   */
  @Test
  public void testUpdateEightPlayers() {

    System.out.println("updateEightPlayers");

    Board board = new Board(8);
    CurvedBoardLayout instance = new CurvedBoardLayout(board);
    instance.updateEightPlayers(2.0f, 1.0f);

  }

  /**
   * Test of updateFourPlayers method, of class CurvedBoardLayout.
   */
  @Test
  public void testUpdateFourPlayers() {

    System.out.println("updateFourPlayers");

    Board board = new Board(4);
    CurvedBoardLayout instance = new CurvedBoardLayout(board);
    instance.updateFourPlayers(2.0f, 1.0f);

  }

  /**
   * Test of updateSixPlayers method, of class CurvedBoardLayout.
   */
  @Test
  public void testUpdateSixPlayers() {

    System.out.println("updateSixPlayers");

    Board board = new Board(6);
    CurvedBoardLayout instance = new CurvedBoardLayout(board);
    instance.updateSixPlayers(2.0f, 1.0f);

  }

  /**
   * Test of getAngleForBoardIndex method, of class CurvedBoardLayout.
   */
  @Test
  public void testGetAngleForBoardIndex() {

    System.out.println("getAngleForBoardIndex");

    // test with invalid board index
    Board board = new Board(4);
    CurvedBoardLayout instance = new CurvedBoardLayout(board);
    int boardIndex = -1;
    try {
      instance.getAngleForBoardIndex(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid board index
    board = new Board(4);
    instance = new CurvedBoardLayout(board);
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
      instance = new CurvedBoardLayout(board);
      for (boardIndex = 0; boardIndex < board.getNumberOfPlayableSpaces(); boardIndex++) {
        instance.getAngleForBoardIndex(boardIndex);
      }
    }

  }

  /**
   * Test of getBoundsForCardDeck method, of class CurvedBoardLayout.
   */
  @Test
  public void testGetBoundsForCardDeck() {

    System.out.println("getBoundsForCardDeck");

    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      Board board = new Board(numberOfPlayers);
      CurvedBoardLayout instance = new CurvedBoardLayout(board);
      Rectangle rectangle = instance.getBoundsForCardDeck();
      assertTrue(rectangle != null);
    }

  }

  /**
   * Test of getBoundsForDiscardPile method, of class CurvedBoardLayout.
   */
  @Test
  public void testGetBoundsForDiscardPile() {

    System.out.println("getBoundsForDiscardPile");

    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      Board board = new Board(numberOfPlayers);
      CurvedBoardLayout instance = new CurvedBoardLayout(board);
      Rectangle rectangle = instance.getBoundsForDiscardPile();
      assertTrue(rectangle != null);
    }

  }

  /**
   * Test of getBoundsForMarble method, of class CurvedBoardLayout.
   */
  @Test
  public void testGetBoundsForMarble() {

    System.out.println("getBoundsForMarble");

    // test with invalid board index
    Board board = new Board(4);
    CurvedBoardLayout instance = new CurvedBoardLayout(board);
    int boardIndex = -1;
    try {
      instance.getBoundsForMarble(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid board index
    board = new Board(4);
    instance = new CurvedBoardLayout(board);
    boardIndex = board.getNumberOfPlayableSpaces();
    try {
      instance.getBoundsForMarble(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      board = new Board(numberOfPlayers);
      instance = new CurvedBoardLayout(board);
      for (boardIndex = 0; boardIndex < board.getNumberOfPlayableSpaces(); boardIndex++) {
        Rectangle rectangle = instance.getBoundsForMarble(boardIndex);
        assertTrue(rectangle != null);
      }
    }

  }

  /**
   * Test of getBoundsForSpace method, of class CurvedBoardLayout.
   */
  @Test
  public void testGetBoundsForSpace() {

    System.out.println("getBoundsForSpace");

    // test with invalid board index
    Board board = new Board(4);
    CurvedBoardLayout instance = new CurvedBoardLayout(board);
    int boardIndex = -1;
    try {
      instance.getBoundsForSpace(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid board index
    board = new Board(4);
    instance = new CurvedBoardLayout(board);
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
      instance = new CurvedBoardLayout(board);
      for (boardIndex = 0; boardIndex < board.getNumberOfPlayableSpaces(); boardIndex++) {
        Rectangle rectangle = instance.getBoundsForSpace(boardIndex);
        assertTrue(rectangle != null);
      }
    }

  }

}
