/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.view;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.exit104.maurersmarbles.Board;
import com.exit104.maurersmarbles.Game;
import com.exit104.maurersmarbles.Rectangle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The GridBoardViewTest class contains the unit tests for the GridBoardView class.
 *
 * @author Daniel Uppenkamp
 */
public class GridBoardViewTest {

  protected static final List<Integer> SUPPORTED_NUMBER_OF_PLAYERS;

  static {
    List<Integer> supportedNumberOfPlayers = new ArrayList<>();
    supportedNumberOfPlayers.add(4);
    SUPPORTED_NUMBER_OF_PLAYERS = Collections.unmodifiableList(supportedNumberOfPlayers);
  }

  public GridBoardViewTest() {
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
   * Test of constructor method, of class GridBoardView.
   */
  @Test
  public void testGridBoardView() {

    System.out.println("constructor");

    // test with null board
    Board board = null;
    try {
      new GridBoardView(board);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with all valid number of players
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      board = new Board(numberOfPlayers);
      if (SUPPORTED_NUMBER_OF_PLAYERS.contains(numberOfPlayers)) {
        new GridBoardView(board);
      } else {
        try {
          new GridBoardView(board);
          fail("Unsupported operation exception not thrown");
        } catch (UnsupportedOperationException ex) {
          // do nothing
        }
      }
    }

  }

  /**
   * Test of getAngleForBoardIndex method, of class GridBoardView.
   */
  @Test
  public void testGetAngleForBoardIndex() {

    System.out.println("getAngleForBoardIndex");

    // test with invalid board index
    Board board = new Board(4);
    GridBoardView instance = new GridBoardView(board);
    int boardIndex = -1;
    try {
      instance.getAngleForBoardIndex(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid board index
    board = new Board(4);
    instance = new GridBoardView(board);
    boardIndex = board.getNumberOfPlayableSpaces();
    try {
      instance.getAngleForBoardIndex(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with all valid number of players
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      if (SUPPORTED_NUMBER_OF_PLAYERS.contains(numberOfPlayers)) {
        board = new Board(numberOfPlayers);
        instance = new GridBoardView(board);
        for (boardIndex = 0; boardIndex < board.getNumberOfPlayableSpaces(); boardIndex++) {
          instance.getAngleForBoardIndex(boardIndex);
        }
      }
    }

  }

  /**
   * Test of getBoundsForMarble method, of class GridBoardView.
   */
  @Test
  public void testGetBoundsForMarble() {

    System.out.println("getBoundsForMarble");

    // test with invalid board index
    Board board = new Board(4);
    GridBoardView instance = new GridBoardView(board);
    int boardIndex = -1;
    try {
      instance.getBoundsForMarble(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid board index
    board = new Board(4);
    instance = new GridBoardView(board);
    boardIndex = board.getNumberOfPlayableSpaces();
    try {
      instance.getBoundsForMarble(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      if (SUPPORTED_NUMBER_OF_PLAYERS.contains(numberOfPlayers)) {
        board = new Board(numberOfPlayers);
        instance = new GridBoardView(board);
        for (boardIndex = 0; boardIndex < board.getNumberOfPlayableSpaces(); boardIndex++) {
          Rectangle rectangle = instance.getBoundsForMarble(boardIndex);
          assertTrue(rectangle != null);
        }
      }
    }

  }

  /**
   * Test of getBoundsForSpace method, of class GridBoardView.
   */
  @Test
  public void testGetBoundsForSpace() {

    System.out.println("getBoundsForSpace");

    // test with invalid board index
    Board board = new Board(4);
    GridBoardView instance = new GridBoardView(board);
    int boardIndex = -1;
    try {
      instance.getBoundsForSpace(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid board index
    board = new Board(4);
    instance = new GridBoardView(board);
    boardIndex = board.getNumberOfPlayableSpaces();
    try {
      instance.getBoundsForSpace(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with all valid number of players
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      if (SUPPORTED_NUMBER_OF_PLAYERS.contains(numberOfPlayers)) {
        board = new Board(numberOfPlayers);
        instance = new GridBoardView(board);
        for (boardIndex = 0; boardIndex < board.getNumberOfPlayableSpaces(); boardIndex++) {
          Rectangle rectangle = instance.getBoundsForSpace(boardIndex);
          assertTrue(rectangle != null);
        }
      }
    }

  }

}
