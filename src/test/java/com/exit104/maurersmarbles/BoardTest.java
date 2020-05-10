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

import java.util.ArrayList;
import java.util.List;

/**
 * The BoardTest class contains the unit tests for the Board class.
 *
 * @author Daniel Uppenkamp
 */
public class BoardTest {

  public BoardTest() {
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
   * Test of constructor method, of class Board.
   */
  @Test
  public void testBoard() {

    System.out.println("constructor");

    // test with invalid number of players
    try {
      new Board(-1);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid number of players
    try {
      new Board(100);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with valid number of players
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      new Board(numberOfPlayers);
    }

  }

  /**
   * Test of getHomeBoardIndexes method, of class Board.
   */
  @Test
  public void testGetHomeBoardIndexes() {

    System.out.println("getHomeBoardIndexes");

    // test with invalid player number
    Board instance;
    int playerNumber;
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {

      instance = new Board(numberOfPlayers);
      playerNumber = -1;
      try {
        instance.getHomeBoardIndexes(playerNumber);
        fail("Illegal argument exception not thrown");
      } catch (IllegalArgumentException ex) {
        // do nothing
      }

      instance = new Board(numberOfPlayers);
      playerNumber = numberOfPlayers;
      try {
        instance.getHomeBoardIndexes(playerNumber);
        fail("Illegal argument exception not thrown");
      } catch (IllegalArgumentException ex) {
        // do nothing
      }

    }

    // test player 0, 4 players
    instance = new Board(4);
    playerNumber = 0;
    List<Integer> expResult = new ArrayList<>();
    expResult.add(56);
    expResult.add(57);
    expResult.add(58);
    expResult.add(59);
    List<Integer> result = instance.getHomeBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 4 players
    instance = new Board(4);
    playerNumber = 1;
    expResult = new ArrayList<>();
    expResult.add(60);
    expResult.add(61);
    expResult.add(62);
    expResult.add(63);
    result = instance.getHomeBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 4 players
    instance = new Board(4);
    playerNumber = 2;
    expResult = new ArrayList<>();
    expResult.add(64);
    expResult.add(65);
    expResult.add(66);
    expResult.add(67);
    result = instance.getHomeBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 4 players
    instance = new Board(4);
    playerNumber = 3;
    expResult = new ArrayList<>();
    expResult.add(68);
    expResult.add(69);
    expResult.add(70);
    expResult.add(71);
    result = instance.getHomeBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 0, 6 players
    instance = new Board(6);
    playerNumber = 0;
    expResult = new ArrayList<>();
    expResult.add(84);
    expResult.add(85);
    expResult.add(86);
    expResult.add(87);
    result = instance.getHomeBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 6 players
    instance = new Board(6);
    playerNumber = 1;
    expResult = new ArrayList<>();
    expResult.add(88);
    expResult.add(89);
    expResult.add(90);
    expResult.add(91);
    result = instance.getHomeBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 6 players
    instance = new Board(6);
    playerNumber = 2;
    expResult = new ArrayList<>();
    expResult.add(92);
    expResult.add(93);
    expResult.add(94);
    expResult.add(95);
    result = instance.getHomeBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 6 players
    instance = new Board(6);
    playerNumber = 3;
    expResult = new ArrayList<>();
    expResult.add(96);
    expResult.add(97);
    expResult.add(98);
    expResult.add(99);
    result = instance.getHomeBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 4, 6 players
    instance = new Board(6);
    playerNumber = 4;
    expResult = new ArrayList<>();
    expResult.add(100);
    expResult.add(101);
    expResult.add(102);
    expResult.add(103);
    result = instance.getHomeBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 5, 6 players
    instance = new Board(6);
    playerNumber = 5;
    expResult = new ArrayList<>();
    expResult.add(104);
    expResult.add(105);
    expResult.add(106);
    expResult.add(107);
    result = instance.getHomeBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 0, 8 players
    instance = new Board(8);
    playerNumber = 0;
    expResult = new ArrayList<>();
    expResult.add(112);
    expResult.add(113);
    expResult.add(114);
    expResult.add(115);
    result = instance.getHomeBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 8 players
    instance = new Board(8);
    playerNumber = 1;
    expResult = new ArrayList<>();
    expResult.add(116);
    expResult.add(117);
    expResult.add(118);
    expResult.add(119);
    result = instance.getHomeBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 8 players
    instance = new Board(8);
    playerNumber = 2;
    expResult = new ArrayList<>();
    expResult.add(120);
    expResult.add(121);
    expResult.add(122);
    expResult.add(123);
    result = instance.getHomeBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 8 players
    instance = new Board(8);
    playerNumber = 3;
    expResult = new ArrayList<>();
    expResult.add(124);
    expResult.add(125);
    expResult.add(126);
    expResult.add(127);
    result = instance.getHomeBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 4, 8 players
    instance = new Board(8);
    playerNumber = 4;
    expResult = new ArrayList<>();
    expResult.add(128);
    expResult.add(129);
    expResult.add(130);
    expResult.add(131);
    result = instance.getHomeBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 5, 8 players
    instance = new Board(8);
    playerNumber = 5;
    expResult = new ArrayList<>();
    expResult.add(132);
    expResult.add(133);
    expResult.add(134);
    expResult.add(135);
    result = instance.getHomeBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 6, 8 players
    instance = new Board(8);
    playerNumber = 6;
    expResult = new ArrayList<>();
    expResult.add(136);
    expResult.add(137);
    expResult.add(138);
    expResult.add(139);
    result = instance.getHomeBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 7, 8 players
    instance = new Board(8);
    playerNumber = 7;
    expResult = new ArrayList<>();
    expResult.add(140);
    expResult.add(141);
    expResult.add(142);
    expResult.add(143);
    result = instance.getHomeBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // TODO add tests for 10 players
    // TODO add tests for 12 players
  }

  /**
   * Test of getHomeEntryBoardIndex method, of class Board.
   */
  @Test
  public void testGetHomeEntryBoardIndex() {

    System.out.println("getHomeEntryBoardIndex");

    // test with invalid player number
    Board instance;
    int playerNumber;
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {

      instance = new Board(numberOfPlayers);
      playerNumber = -1;
      try {
        instance.getHomeEntryBoardIndex(playerNumber);
        fail("Illegal argument exception not thrown");
      } catch (IllegalArgumentException ex) {
        // do nothing
      }

      instance = new Board(numberOfPlayers);
      playerNumber = numberOfPlayers;
      try {
        instance.getHomeEntryBoardIndex(playerNumber);
        fail("Illegal argument exception not thrown");
      } catch (IllegalArgumentException ex) {
        // do nothing
      }

    }

    // test player 0, 4 players
    instance = new Board(4);
    playerNumber = 0;
    int expResult = 54;
    int result = instance.getHomeEntryBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 4 players
    instance = new Board(4);
    playerNumber = 1;
    expResult = 12;
    result = instance.getHomeEntryBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 4 players
    instance = new Board(4);
    playerNumber = 2;
    expResult = 26;
    result = instance.getHomeEntryBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 4 players
    instance = new Board(4);
    playerNumber = 3;
    expResult = 40;
    result = instance.getHomeEntryBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 0, 6 players
    instance = new Board(6);
    playerNumber = 0;
    expResult = 82;
    result = instance.getHomeEntryBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 6 players
    instance = new Board(6);
    playerNumber = 1;
    expResult = 12;
    result = instance.getHomeEntryBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 6 players
    instance = new Board(6);
    playerNumber = 2;
    expResult = 26;
    result = instance.getHomeEntryBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 6 players
    instance = new Board(6);
    playerNumber = 3;
    expResult = 40;
    result = instance.getHomeEntryBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 4, 6 players
    instance = new Board(6);
    playerNumber = 4;
    expResult = 54;
    result = instance.getHomeEntryBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 5, 6 players
    instance = new Board(6);
    playerNumber = 5;
    expResult = 68;
    result = instance.getHomeEntryBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 0, 8 players
    instance = new Board(8);
    playerNumber = 0;
    expResult = 110;
    result = instance.getHomeEntryBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 8 players
    instance = new Board(8);
    playerNumber = 1;
    expResult = 12;
    result = instance.getHomeEntryBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 8 players
    instance = new Board(8);
    playerNumber = 2;
    expResult = 26;
    result = instance.getHomeEntryBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 8 players
    instance = new Board(8);
    playerNumber = 3;
    expResult = 40;
    result = instance.getHomeEntryBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 4, 8 players
    instance = new Board(8);
    playerNumber = 4;
    expResult = 54;
    result = instance.getHomeEntryBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 5, 8 players
    instance = new Board(8);
    playerNumber = 5;
    expResult = 68;
    result = instance.getHomeEntryBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 6, 8 players
    instance = new Board(8);
    playerNumber = 6;
    expResult = 82;
    result = instance.getHomeEntryBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 7, 8 players
    instance = new Board(8);
    playerNumber = 7;
    expResult = 96;
    result = instance.getHomeEntryBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // TODO add tests for 10 players
    // TODO add tests for 12 players
  }

  /**
   * Test of getHomeMaxBoardIndex method, of class Board.
   */
  @Test
  public void testGetHomeMaxBoardIndex() {

    System.out.println("getHomeMaxBoardIndex");

    // test with invalid player number
    Board instance;
    int playerNumber;
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {

      instance = new Board(numberOfPlayers);
      playerNumber = -1;
      try {
        instance.getHomeMaxBoardIndex(playerNumber);
        fail("Illegal argument exception not thrown");
      } catch (IllegalArgumentException ex) {
        // do nothing
      }

      instance = new Board(numberOfPlayers);
      playerNumber = numberOfPlayers;
      try {
        instance.getHomeMaxBoardIndex(playerNumber);
        fail("Illegal argument exception not thrown");
      } catch (IllegalArgumentException ex) {
        // do nothing
      }

    }

    // test player 0, 4 players
    instance = new Board(4);
    playerNumber = 0;
    int expResult = 59;
    int result = instance.getHomeMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 4 players
    instance = new Board(4);
    playerNumber = 1;
    expResult = 63;
    result = instance.getHomeMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 4 players
    instance = new Board(4);
    playerNumber = 2;
    expResult = 67;
    result = instance.getHomeMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 4 players
    instance = new Board(4);
    playerNumber = 3;
    expResult = 71;
    result = instance.getHomeMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 0, 6 players
    instance = new Board(6);
    playerNumber = 0;
    expResult = 87;
    result = instance.getHomeMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 6 players
    instance = new Board(6);
    playerNumber = 1;
    expResult = 91;
    result = instance.getHomeMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 6 players
    instance = new Board(6);
    playerNumber = 2;
    expResult = 95;
    result = instance.getHomeMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 6 players
    instance = new Board(6);
    playerNumber = 3;
    expResult = 99;
    result = instance.getHomeMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 4, 6 players
    instance = new Board(6);
    playerNumber = 4;
    expResult = 103;
    result = instance.getHomeMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 5, 6 players
    instance = new Board(6);
    playerNumber = 5;
    expResult = 107;
    result = instance.getHomeMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 0, 8 players
    instance = new Board(8);
    playerNumber = 0;
    expResult = 115;
    result = instance.getHomeMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 8 players
    instance = new Board(8);
    playerNumber = 1;
    expResult = 119;
    result = instance.getHomeMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 8 players
    instance = new Board(8);
    playerNumber = 2;
    expResult = 123;
    result = instance.getHomeMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 8 players
    instance = new Board(8);
    playerNumber = 3;
    expResult = 127;
    result = instance.getHomeMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 4, 8 players
    instance = new Board(8);
    playerNumber = 4;
    expResult = 131;
    result = instance.getHomeMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 5, 8 players
    instance = new Board(8);
    playerNumber = 5;
    expResult = 135;
    result = instance.getHomeMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 6, 8 players
    instance = new Board(8);
    playerNumber = 6;
    expResult = 139;
    result = instance.getHomeMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 7, 8 players
    instance = new Board(8);
    playerNumber = 7;
    expResult = 143;
    result = instance.getHomeMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // TODO add tests for 10 players
    // TODO add tests for 12 players
  }

  /**
   * Test of getHomeMinBoardIndex method, of class Board.
   */
  @Test
  public void testGetHomeMinBoardIndex() {

    System.out.println("getHomeMinBoardIndex");

    // test with invalid player number
    Board instance;
    int playerNumber;
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {

      instance = new Board(numberOfPlayers);
      playerNumber = -1;
      try {
        instance.getHomeMinBoardIndex(playerNumber);
        fail("Illegal argument exception not thrown");
      } catch (IllegalArgumentException ex) {
        // do nothing
      }

      instance = new Board(numberOfPlayers);
      playerNumber = numberOfPlayers;
      try {
        instance.getHomeMinBoardIndex(playerNumber);
        fail("Illegal argument exception not thrown");
      } catch (IllegalArgumentException ex) {
        // do nothing
      }

    }

    // test player 0, 4 players
    instance = new Board(4);
    playerNumber = 0;
    int expResult = 56;
    int result = instance.getHomeMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 4 players
    instance = new Board(4);
    playerNumber = 1;
    expResult = 60;
    result = instance.getHomeMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 4 players
    instance = new Board(4);
    playerNumber = 2;
    expResult = 64;
    result = instance.getHomeMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 4 players
    instance = new Board(4);
    playerNumber = 3;
    expResult = 68;
    result = instance.getHomeMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 0, 6 players
    instance = new Board(6);
    playerNumber = 0;
    expResult = 84;
    result = instance.getHomeMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 6 players
    instance = new Board(6);
    playerNumber = 1;
    expResult = 88;
    result = instance.getHomeMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 6 players
    instance = new Board(6);
    playerNumber = 2;
    expResult = 92;
    result = instance.getHomeMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 6 players
    instance = new Board(6);
    playerNumber = 3;
    expResult = 96;
    result = instance.getHomeMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 4, 6 players
    instance = new Board(6);
    playerNumber = 4;
    expResult = 100;
    result = instance.getHomeMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 5, 6 players
    instance = new Board(6);
    playerNumber = 5;
    expResult = 104;
    result = instance.getHomeMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 0, 8 players
    instance = new Board(8);
    playerNumber = 0;
    expResult = 112;
    result = instance.getHomeMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 8 players
    instance = new Board(8);
    playerNumber = 1;
    expResult = 116;
    result = instance.getHomeMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 8 players
    instance = new Board(8);
    playerNumber = 2;
    expResult = 120;
    result = instance.getHomeMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 8 players
    instance = new Board(8);
    playerNumber = 3;
    expResult = 124;
    result = instance.getHomeMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 4, 8 players
    instance = new Board(8);
    playerNumber = 4;
    expResult = 128;
    result = instance.getHomeMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 5, 8 players
    instance = new Board(8);
    playerNumber = 5;
    expResult = 132;
    result = instance.getHomeMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 6, 8 players
    instance = new Board(8);
    playerNumber = 6;
    expResult = 136;
    result = instance.getHomeMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 7, 8 players
    instance = new Board(8);
    playerNumber = 7;
    expResult = 140;
    result = instance.getHomeMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // TODO add tests for 10 players
    // TODO add tests for 12 players
  }

  /**
   * Test of getNumberOfHomeSpacesPerPlayer method, of class Board.
   */
  @Test
  public void testGetNumberOfHomeSpacesPerPlayer() {

    System.out.println("getNumberOfHomeSpacesPerPlayer");

    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      Board instance = new Board(numberOfPlayers);
      int expResult = 4;
      int result = instance.getNumberOfHomeSpacesPerPlayer();
      assertEquals(expResult, result);
    }

  }

  /**
   * Test of getNumberOfPerimeterSpaces method, of class Board.
   */
  @Test
  public void testGetNumberOfPerimeterSpaces() {

    System.out.println("getNumberOfPerimeterSpaces");

    // test with 4 players
    Board instance = new Board(4);
    int expResult = 56;
    int result = instance.getNumberOfPerimeterSpaces();
    assertEquals(expResult, result);

    // test with 6 players
    instance = new Board(6);
    expResult = 84;
    result = instance.getNumberOfPerimeterSpaces();
    assertEquals(expResult, result);

    // test with 8 players
    instance = new Board(8);
    expResult = 112;
    result = instance.getNumberOfPerimeterSpaces();
    assertEquals(expResult, result);

    // test with 10 players
    instance = new Board(10);
    expResult = 140;
    result = instance.getNumberOfPerimeterSpaces();
    assertEquals(expResult, result);

    // test with 12 players
    instance = new Board(12);
    expResult = 168;
    result = instance.getNumberOfPerimeterSpaces();
    assertEquals(expResult, result);

  }

  /**
   * Test of getNumberOfPlayableSpaces method, of class Board.
   */
  @Test
  public void testGetNumberOfPlayableSpaces() {

    System.out.println("getNumberOfPlayableSpaces");

    // test with 4 players
    Board instance = new Board(4);
    int expResult = 88;
    int result = instance.getNumberOfPlayableSpaces();
    assertEquals(expResult, result);

    // test with 6 players
    instance = new Board(6);
    expResult = 132;
    result = instance.getNumberOfPlayableSpaces();
    assertEquals(expResult, result);

    // test with 8 players
    instance = new Board(8);
    expResult = 176;
    result = instance.getNumberOfPlayableSpaces();
    assertEquals(expResult, result);

    // test with 10 players
    instance = new Board(10);
    expResult = 220;
    result = instance.getNumberOfPlayableSpaces();
    assertEquals(expResult, result);

    // test with 12 players
    instance = new Board(12);
    expResult = 264;
    result = instance.getNumberOfPlayableSpaces();
    assertEquals(expResult, result);

  }

  /**
   * Test of getNumberOfPlayers method, of class Board.
   */
  @Test
  public void testGetNumberOfPlayers() {

    System.out.println("getNumberOfPlayers");

    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      Board instance = new Board(numberOfPlayers);
      assertEquals(numberOfPlayers, instance.getNumberOfPlayers());
    }

  }

  /**
   * Test of getPerimeterBoardIndexes method, of class Board.
   */
  @Test
  public void testGetPerimeterBoardIndexes() {

    System.out.println("getPerimeterBoardIndexes");

    // test with 4 players
    Board instance = new Board(4);
    List<Integer> expResult = new ArrayList<>();
    for (int i = 0; i < 56; i++) {
      expResult.add(i);
    }
    List<Integer> result = instance.getPerimeterBoardIndexes();
    assertEquals(expResult, result);

    // test with 6 players
    instance = new Board(6);
    expResult = new ArrayList<>();
    for (int i = 0; i < 84; i++) {
      expResult.add(i);
    }
    result = instance.getPerimeterBoardIndexes();
    assertEquals(expResult, result);

    // test with 8 players
    instance = new Board(8);
    expResult = new ArrayList<>();
    for (int i = 0; i < 112; i++) {
      expResult.add(i);
    }
    result = instance.getPerimeterBoardIndexes();
    assertEquals(expResult, result);

    // TODO add tests for 10 players
    // TODO add tests for 12 players
  }

  /**
   * Test of getSafeBoardIndex method, of class Board.
   */
  @Test
  public void testGetSafeBoardIndex() {

    System.out.println("getSafeBoardIndex");

    // test with invalid player number
    Board instance;
    int playerNumber;
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {

      instance = new Board(numberOfPlayers);
      playerNumber = -1;
      try {
        instance.getSafeBoardIndex(playerNumber);
        fail("Illegal argument exception not thrown");
      } catch (IllegalArgumentException ex) {
        // do nothing
      }

      instance = new Board(numberOfPlayers);
      playerNumber = numberOfPlayers;
      try {
        instance.getSafeBoardIndex(playerNumber);
        fail("Illegal argument exception not thrown");
      } catch (IllegalArgumentException ex) {
        // do nothing
      }

    }

    // test player 0, 4 players
    instance = new Board(4);
    playerNumber = 0;
    int expResult = 0;
    int result = instance.getSafeBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 4 players
    instance = new Board(4);
    playerNumber = 1;
    expResult = 14;
    result = instance.getSafeBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 4 players
    instance = new Board(4);
    playerNumber = 2;
    expResult = 28;
    result = instance.getSafeBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 4 players
    instance = new Board(4);
    playerNumber = 3;
    expResult = 42;
    result = instance.getSafeBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 0, 6 players
    instance = new Board(6);
    playerNumber = 0;
    expResult = 0;
    result = instance.getSafeBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 6 players
    instance = new Board(6);
    playerNumber = 1;
    expResult = 14;
    result = instance.getSafeBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 6 players
    instance = new Board(6);
    playerNumber = 2;
    expResult = 28;
    result = instance.getSafeBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 6 players
    instance = new Board(6);
    playerNumber = 3;
    expResult = 42;
    result = instance.getSafeBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 4, 6 players
    instance = new Board(6);
    playerNumber = 4;
    expResult = 56;
    result = instance.getSafeBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 5, 6 players
    instance = new Board(6);
    playerNumber = 5;
    expResult = 70;
    result = instance.getSafeBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 0, 8 players
    instance = new Board(8);
    playerNumber = 0;
    expResult = 0;
    result = instance.getSafeBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 8 players
    instance = new Board(8);
    playerNumber = 1;
    expResult = 14;
    result = instance.getSafeBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 8 players
    instance = new Board(8);
    playerNumber = 2;
    expResult = 28;
    result = instance.getSafeBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 8 players
    instance = new Board(8);
    playerNumber = 3;
    expResult = 42;
    result = instance.getSafeBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 4, 8 players
    instance = new Board(8);
    playerNumber = 4;
    expResult = 56;
    result = instance.getSafeBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 5, 8 players
    instance = new Board(8);
    playerNumber = 5;
    expResult = 70;
    result = instance.getSafeBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 6, 8 players
    instance = new Board(8);
    playerNumber = 6;
    expResult = 84;
    result = instance.getSafeBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 7, 8 players
    instance = new Board(8);
    playerNumber = 7;
    expResult = 98;
    result = instance.getSafeBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // TODO add tests for 10 players
    // TODO add tests for 12 players
  }

  /**
   * Test of getStartBoardIndexes method, of class Board.
   */
  @Test
  public void testGetStartBoardIndexes() {

    System.out.println("getStartBoardIndexes");

    // test with invalid player number
    Board instance;
    int playerNumber;
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {

      instance = new Board(numberOfPlayers);
      playerNumber = -1;
      try {
        instance.getStartBoardIndexes(playerNumber);
        fail("Illegal argument exception not thrown");
      } catch (IllegalArgumentException ex) {
        // do nothing
      }

      instance = new Board(numberOfPlayers);
      playerNumber = numberOfPlayers;
      try {
        instance.getStartBoardIndexes(playerNumber);
        fail("Illegal argument exception not thrown");
      } catch (IllegalArgumentException ex) {
        // do nothing
      }

    }

    // test player 0, 4 players
    instance = new Board(4);
    playerNumber = 0;
    List<Integer> expResult = new ArrayList<>();
    expResult.add(72);
    expResult.add(73);
    expResult.add(74);
    expResult.add(75);
    List<Integer> result = instance.getStartBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 4 players
    instance = new Board(4);
    playerNumber = 1;
    expResult = new ArrayList<>();
    expResult.add(76);
    expResult.add(77);
    expResult.add(78);
    expResult.add(79);
    result = instance.getStartBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 4 players
    instance = new Board(4);
    playerNumber = 2;
    expResult = new ArrayList<>();
    expResult.add(80);
    expResult.add(81);
    expResult.add(82);
    expResult.add(83);
    result = instance.getStartBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 4 players
    instance = new Board(4);
    playerNumber = 3;
    expResult = new ArrayList<>();
    expResult.add(84);
    expResult.add(85);
    expResult.add(86);
    expResult.add(87);
    result = instance.getStartBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 0, 6 players
    instance = new Board(6);
    playerNumber = 0;
    expResult = new ArrayList<>();
    expResult.add(108);
    expResult.add(109);
    expResult.add(110);
    expResult.add(111);
    result = instance.getStartBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 6 players
    instance = new Board(6);
    playerNumber = 1;
    expResult = new ArrayList<>();
    expResult.add(112);
    expResult.add(113);
    expResult.add(114);
    expResult.add(115);
    result = instance.getStartBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 6 players
    instance = new Board(6);
    playerNumber = 2;
    expResult = new ArrayList<>();
    expResult.add(116);
    expResult.add(117);
    expResult.add(118);
    expResult.add(119);
    result = instance.getStartBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 6 players
    instance = new Board(6);
    playerNumber = 3;
    expResult = new ArrayList<>();
    expResult.add(120);
    expResult.add(121);
    expResult.add(122);
    expResult.add(123);
    result = instance.getStartBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 4, 6 players
    instance = new Board(6);
    playerNumber = 4;
    expResult = new ArrayList<>();
    expResult.add(124);
    expResult.add(125);
    expResult.add(126);
    expResult.add(127);
    result = instance.getStartBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 5, 6 players
    instance = new Board(6);
    playerNumber = 5;
    expResult = new ArrayList<>();
    expResult.add(128);
    expResult.add(129);
    expResult.add(130);
    expResult.add(131);
    result = instance.getStartBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 0, 8 players
    instance = new Board(8);
    playerNumber = 0;
    expResult = new ArrayList<>();
    expResult.add(144);
    expResult.add(145);
    expResult.add(146);
    expResult.add(147);
    result = instance.getStartBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 8 players
    instance = new Board(8);
    playerNumber = 1;
    expResult = new ArrayList<>();
    expResult.add(148);
    expResult.add(149);
    expResult.add(150);
    expResult.add(151);
    result = instance.getStartBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 8 players
    instance = new Board(8);
    playerNumber = 2;
    expResult = new ArrayList<>();
    expResult.add(152);
    expResult.add(153);
    expResult.add(154);
    expResult.add(155);
    result = instance.getStartBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 8 players
    instance = new Board(8);
    playerNumber = 3;
    expResult = new ArrayList<>();
    expResult.add(156);
    expResult.add(157);
    expResult.add(158);
    expResult.add(159);
    result = instance.getStartBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 4, 8 players
    instance = new Board(8);
    playerNumber = 4;
    expResult = new ArrayList<>();
    expResult.add(160);
    expResult.add(161);
    expResult.add(162);
    expResult.add(163);
    result = instance.getStartBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 5, 8 players
    instance = new Board(8);
    playerNumber = 5;
    expResult = new ArrayList<>();
    expResult.add(164);
    expResult.add(165);
    expResult.add(166);
    expResult.add(167);
    result = instance.getStartBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 6, 8 players
    instance = new Board(8);
    playerNumber = 6;
    expResult = new ArrayList<>();
    expResult.add(168);
    expResult.add(169);
    expResult.add(170);
    expResult.add(171);
    result = instance.getStartBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // test player 7, 8 players
    instance = new Board(8);
    playerNumber = 7;
    expResult = new ArrayList<>();
    expResult.add(172);
    expResult.add(173);
    expResult.add(174);
    expResult.add(175);
    result = instance.getStartBoardIndexes(playerNumber);
    assertEquals(expResult, result);

    // TODO add tests for 10 players
    // TODO add tests for 12 players
  }

  /**
   * Test of getStartMaxBoardIndex method, of class Board.
   */
  @Test
  public void testGetStartMaxBoardIndex() {

    System.out.println("getStartMaxBoardIndex");

    // test with invalid player number
    Board instance;
    int playerNumber;
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {

      instance = new Board(numberOfPlayers);
      playerNumber = -1;
      try {
        instance.getStartMaxBoardIndex(playerNumber);
        fail("Illegal argument exception not thrown");
      } catch (IllegalArgumentException ex) {
        // do nothing
      }

      instance = new Board(numberOfPlayers);
      playerNumber = numberOfPlayers;
      try {
        instance.getStartMaxBoardIndex(playerNumber);
        fail("Illegal argument exception not thrown");
      } catch (IllegalArgumentException ex) {
        // do nothing
      }

    }

    // test player 0, 4 players
    instance = new Board(4);
    playerNumber = 0;
    int expResult = 75;
    int result = instance.getStartMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 4 players
    instance = new Board(4);
    playerNumber = 1;
    expResult = 79;
    result = instance.getStartMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 4 players
    instance = new Board(4);
    playerNumber = 2;
    expResult = 83;
    result = instance.getStartMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 4 players
    instance = new Board(4);
    playerNumber = 3;
    expResult = 87;
    result = instance.getStartMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 0, 6 players
    instance = new Board(6);
    playerNumber = 0;
    expResult = 111;
    result = instance.getStartMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 6 players
    instance = new Board(6);
    playerNumber = 1;
    expResult = 115;
    result = instance.getStartMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 6 players
    instance = new Board(6);
    playerNumber = 2;
    expResult = 119;
    result = instance.getStartMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 6 players
    instance = new Board(6);
    playerNumber = 3;
    expResult = 123;
    result = instance.getStartMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 4, 6 players
    instance = new Board(6);
    playerNumber = 4;
    expResult = 127;
    result = instance.getStartMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 5, 6 players
    instance = new Board(6);
    playerNumber = 5;
    expResult = 131;
    result = instance.getStartMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 0, 8 players
    instance = new Board(8);
    playerNumber = 0;
    expResult = 147;
    result = instance.getStartMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 8 players
    instance = new Board(8);
    playerNumber = 1;
    expResult = 151;
    result = instance.getStartMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 8 players
    instance = new Board(8);
    playerNumber = 2;
    expResult = 155;
    result = instance.getStartMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 8 players
    instance = new Board(8);
    playerNumber = 3;
    expResult = 159;
    result = instance.getStartMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 4, 8 players
    instance = new Board(8);
    playerNumber = 4;
    expResult = 163;
    result = instance.getStartMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 5, 8 players
    instance = new Board(8);
    playerNumber = 5;
    expResult = 167;
    result = instance.getStartMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 6, 8 players
    instance = new Board(8);
    playerNumber = 6;
    expResult = 171;
    result = instance.getStartMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 7, 8 players
    instance = new Board(8);
    playerNumber = 7;
    expResult = 175;
    result = instance.getStartMaxBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // TODO add tests for 10 players
    // TODO add tests for 12 players
  }

  /**
   * Test of getStartMinBoardIndex method, of class Board.
   */
  @Test
  public void testGetStartMinBoardIndex() {

    System.out.println("getStartMinBoardIndex");

    // test with invalid player number
    Board instance;
    int playerNumber;
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {

      instance = new Board(numberOfPlayers);
      playerNumber = -1;
      try {
        instance.getStartMinBoardIndex(playerNumber);
        fail("Illegal argument exception not thrown");
      } catch (IllegalArgumentException ex) {
        // do nothing
      }

      instance = new Board(numberOfPlayers);
      playerNumber = numberOfPlayers;
      try {
        instance.getStartMinBoardIndex(playerNumber);
        fail("Illegal argument exception not thrown");
      } catch (IllegalArgumentException ex) {
        // do nothing
      }

    }

    // test player 0, 4 players
    instance = new Board(4);
    playerNumber = 0;
    int expResult = 72;
    int result = instance.getStartMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 4 players
    instance = new Board(4);
    playerNumber = 1;
    expResult = 76;
    result = instance.getStartMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 4 players
    instance = new Board(4);
    playerNumber = 2;
    expResult = 80;
    result = instance.getStartMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 4 players
    instance = new Board(4);
    playerNumber = 3;
    expResult = 84;
    result = instance.getStartMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 0, 6 players
    instance = new Board(6);
    playerNumber = 0;
    expResult = 108;
    result = instance.getStartMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 6 players
    instance = new Board(6);
    playerNumber = 1;
    expResult = 112;
    result = instance.getStartMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 6 players
    instance = new Board(6);
    playerNumber = 2;
    expResult = 116;
    result = instance.getStartMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 6 players
    instance = new Board(6);
    playerNumber = 3;
    expResult = 120;
    result = instance.getStartMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 4, 6 players
    instance = new Board(6);
    playerNumber = 4;
    expResult = 124;
    result = instance.getStartMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 5, 6 players
    instance = new Board(6);
    playerNumber = 5;
    expResult = 128;
    result = instance.getStartMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 0, 8 players
    instance = new Board(8);
    playerNumber = 0;
    expResult = 144;
    result = instance.getStartMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 8 players
    instance = new Board(8);
    playerNumber = 1;
    expResult = 148;
    result = instance.getStartMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 8 players
    instance = new Board(8);
    playerNumber = 2;
    expResult = 152;
    result = instance.getStartMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 8 players
    instance = new Board(8);
    playerNumber = 3;
    expResult = 156;
    result = instance.getStartMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 4, 8 players
    instance = new Board(8);
    playerNumber = 4;
    expResult = 160;
    result = instance.getStartMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 5, 8 players
    instance = new Board(8);
    playerNumber = 5;
    expResult = 164;
    result = instance.getStartMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 6, 8 players
    instance = new Board(8);
    playerNumber = 6;
    expResult = 168;
    result = instance.getStartMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // test player 7, 8 players
    instance = new Board(8);
    playerNumber = 7;
    expResult = 172;
    result = instance.getStartMinBoardIndex(playerNumber);
    assertEquals(expResult, result);

    // TODO add tests for 10 players
    // TODO add tests for 12 players
  }

  /**
   * Test of getNumberOfStartSpacesPerPlayer method, of class Board.
   */
  @Test
  public void testGetNumberOfStartSpacesPerPlayer() {

    System.out.println("getNumberOfStartSpacesPerPlayer");

    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      Board instance = new Board(numberOfPlayers);
      int expResult = 4;
      int result = instance.getNumberOfStartSpacesPerPlayer();
      assertEquals(expResult, result);
    }

  }

  /**
   * Test of equals method, of class Board.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testEquals() {

    System.out.println("equals");

    // test same object
    Object obj = new Board(4);
    Board instance = (Board) obj;
    boolean expResult = true;
    boolean result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with null
    obj = null;
    instance = new Board(4);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with different class
    obj = new Object();
    instance = new Board(4);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with different boards
    obj = new Board(4);
    instance = new Board(6);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test equal objects
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      obj = new Board(numberOfPlayers);
      instance = new Board(numberOfPlayers);
      expResult = true;
      result = instance.equals(obj);
      assertEquals(expResult, result);
    }

  }

  /**
   * Test of hashCode method, of class Board.
   */
  @Test
  public void testHashCode() {

    System.out.println("hashCode");

    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      Board instance1 = new Board(numberOfPlayers);
      Board instance2 = new Board(numberOfPlayers);
      assertEquals(instance1.hashCode(), instance2.hashCode());
    }

  }

}
