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

  }

  /**
   * Test of getAngleForBoardIndex method, of class GridBoardLayout.
   */
  @Test
  @SuppressWarnings("PMD.UseUnderscoresInNumericLiterals")
  public void testGetAngleForBoardIndex() {

    System.out.println("getAngleForBoardIndex");

    // test with invalid board index
    Board board = new Board(4);
    GridBoardLayout instance = new GridBoardLayout(board);
    int boardIndex = -1;
    try {
      instance.getAngleForBoardIndex(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid board index
    board = new Board(4);
    instance = new GridBoardLayout(board);
    boardIndex = board.getNumberOfPlayableSpaces();
    try {
      instance.getAngleForBoardIndex(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // code to generate expected values
    /*for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      System.out.printf("// test with %d players\n", numberOfPlayers);
      System.out.printf("board = new Board(%d);\n", numberOfPlayers);
      System.out.printf("instance = new GridBoardLayout(board);\n");
      GridBoardLayout gridBoardLayout = new GridBoardLayout(new Board(numberOfPlayers));
      for (int i = 0; i < gridBoardLayout.board.getNumberOfPlayableSpaces(); i++) {
        float angle = gridBoardLayout.getAngleForBoardIndex(i);
        System.out.printf("assertEquals(%d, Float.floatToIntBits("
            + "instance.getAngleForBoardIndex(%d)));\n", Float.floatToIntBits(angle), i);
      }
    }*/
    // test with 4 players
    board = new Board(4);
    instance = new GridBoardLayout(board);
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(0)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(1)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(2)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(3)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(4)));
    assertEquals(-1085730853, Float.floatToIntBits(instance.getAngleForBoardIndex(5)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(6)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(7)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(8)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(9)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(10)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(11)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(12)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(13)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(14)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(15)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(16)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(17)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(18)));
    assertEquals(1061752795, Float.floatToIntBits(instance.getAngleForBoardIndex(19)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(20)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(21)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(22)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(23)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(24)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(25)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(26)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(27)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(28)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(29)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(30)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(31)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(32)));
    assertEquals(1075235812, Float.floatToIntBits(instance.getAngleForBoardIndex(33)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(34)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(35)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(36)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(37)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(38)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(39)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(40)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(41)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(42)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(43)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(44)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(45)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(46)));
    assertEquals(-1072247836, Float.floatToIntBits(instance.getAngleForBoardIndex(47)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(48)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(49)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(50)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(51)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(52)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(53)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(54)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(55)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(56)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(57)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(58)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(59)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(60)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(61)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(62)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(63)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(64)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(65)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(66)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(67)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(68)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(69)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(70)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(71)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(72)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(73)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(74)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(75)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(76)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(77)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(78)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(79)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(80)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(81)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(82)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(83)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(84)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(85)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(86)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(87)));

    // test with 6 players
    board = new Board(6);
    instance = new GridBoardLayout(board);
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(0)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(1)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(2)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(3)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(4)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(5)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(6)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(7)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(8)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(9)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(10)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(11)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(12)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(13)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(14)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(15)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(16)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(17)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(18)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(19)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(20)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(21)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(22)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(23)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(24)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(25)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(26)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(27)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(28)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(29)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(30)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(31)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(32)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(33)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(34)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(35)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(36)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(37)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(38)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(39)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(40)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(41)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(42)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(43)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(44)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(45)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(46)));
    assertEquals(1074137746, Float.floatToIntBits(instance.getAngleForBoardIndex(47)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(48)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(49)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(50)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(51)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(52)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(53)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(54)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(55)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(56)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(57)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(58)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(59)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(60)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(61)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(62)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(63)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(64)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(65)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(66)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(67)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(68)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(69)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(70)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(71)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(72)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(73)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(74)));
    assertEquals(-1073345902, Float.floatToIntBits(instance.getAngleForBoardIndex(75)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(76)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(77)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(78)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(79)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(80)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(81)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(82)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(83)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(84)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(85)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(86)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(87)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(88)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(89)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(90)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(91)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(92)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(93)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(94)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(95)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(96)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(97)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(98)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(99)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(100)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(101)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(102)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(103)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(104)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(105)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(106)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(107)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(108)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(109)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(110)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(111)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(112)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(113)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(114)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(115)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(116)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(117)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(118)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(119)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(120)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(121)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(122)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(123)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(124)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(125)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(126)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(127)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(128)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(129)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(130)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(131)));

    // test with 8 players
    board = new Board(8);
    instance = new GridBoardLayout(board);
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(0)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(1)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(2)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(3)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(4)));
    assertEquals(-1080636444, Float.floatToIntBits(instance.getAngleForBoardIndex(5)));
    assertEquals(-1085730852, Float.floatToIntBits(instance.getAngleForBoardIndex(6)));
    assertEquals(-1085730852, Float.floatToIntBits(instance.getAngleForBoardIndex(7)));
    assertEquals(-1085730852, Float.floatToIntBits(instance.getAngleForBoardIndex(8)));
    assertEquals(-1085730852, Float.floatToIntBits(instance.getAngleForBoardIndex(9)));
    assertEquals(-1085730852, Float.floatToIntBits(instance.getAngleForBoardIndex(10)));
    assertEquals(-1085730852, Float.floatToIntBits(instance.getAngleForBoardIndex(11)));
    assertEquals(-1085730852, Float.floatToIntBits(instance.getAngleForBoardIndex(12)));
    assertEquals(-1085730852, Float.floatToIntBits(instance.getAngleForBoardIndex(13)));
    assertEquals(-1085730852, Float.floatToIntBits(instance.getAngleForBoardIndex(14)));
    assertEquals(-1085730852, Float.floatToIntBits(instance.getAngleForBoardIndex(15)));
    assertEquals(-1085730852, Float.floatToIntBits(instance.getAngleForBoardIndex(16)));
    assertEquals(-1085730852, Float.floatToIntBits(instance.getAngleForBoardIndex(17)));
    assertEquals(-1085730852, Float.floatToIntBits(instance.getAngleForBoardIndex(18)));
    assertEquals(-1094119461, Float.floatToIntBits(instance.getAngleForBoardIndex(19)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(20)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(21)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(22)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(23)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(24)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(25)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(26)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(27)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(28)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(29)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(30)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(31)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(32)));
    assertEquals(1053364187, Float.floatToIntBits(instance.getAngleForBoardIndex(33)));
    assertEquals(1061752792, Float.floatToIntBits(instance.getAngleForBoardIndex(34)));
    assertEquals(1061752792, Float.floatToIntBits(instance.getAngleForBoardIndex(35)));
    assertEquals(1061752792, Float.floatToIntBits(instance.getAngleForBoardIndex(36)));
    assertEquals(1061752792, Float.floatToIntBits(instance.getAngleForBoardIndex(37)));
    assertEquals(1061752792, Float.floatToIntBits(instance.getAngleForBoardIndex(38)));
    assertEquals(1061752792, Float.floatToIntBits(instance.getAngleForBoardIndex(39)));
    assertEquals(1061752792, Float.floatToIntBits(instance.getAngleForBoardIndex(40)));
    assertEquals(1061752792, Float.floatToIntBits(instance.getAngleForBoardIndex(41)));
    assertEquals(1061752792, Float.floatToIntBits(instance.getAngleForBoardIndex(42)));
    assertEquals(1061752792, Float.floatToIntBits(instance.getAngleForBoardIndex(43)));
    assertEquals(1061752792, Float.floatToIntBits(instance.getAngleForBoardIndex(44)));
    assertEquals(1061752792, Float.floatToIntBits(instance.getAngleForBoardIndex(45)));
    assertEquals(1061752792, Float.floatToIntBits(instance.getAngleForBoardIndex(46)));
    assertEquals(1066847204, Float.floatToIntBits(instance.getAngleForBoardIndex(47)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(48)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(49)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(50)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(51)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(52)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(53)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(54)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(55)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(56)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(57)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(58)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(59)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(60)));
    assertEquals(1073435601, Float.floatToIntBits(instance.getAngleForBoardIndex(61)));
    assertEquals(1075235811, Float.floatToIntBits(instance.getAngleForBoardIndex(62)));
    assertEquals(1075235811, Float.floatToIntBits(instance.getAngleForBoardIndex(63)));
    assertEquals(1075235811, Float.floatToIntBits(instance.getAngleForBoardIndex(64)));
    assertEquals(1075235811, Float.floatToIntBits(instance.getAngleForBoardIndex(65)));
    assertEquals(1075235811, Float.floatToIntBits(instance.getAngleForBoardIndex(66)));
    assertEquals(1075235811, Float.floatToIntBits(instance.getAngleForBoardIndex(67)));
    assertEquals(1075235811, Float.floatToIntBits(instance.getAngleForBoardIndex(68)));
    assertEquals(1075235811, Float.floatToIntBits(instance.getAngleForBoardIndex(69)));
    assertEquals(1075235811, Float.floatToIntBits(instance.getAngleForBoardIndex(70)));
    assertEquals(1075235811, Float.floatToIntBits(instance.getAngleForBoardIndex(71)));
    assertEquals(1075235811, Float.floatToIntBits(instance.getAngleForBoardIndex(72)));
    assertEquals(1075235811, Float.floatToIntBits(instance.getAngleForBoardIndex(73)));
    assertEquals(1075235811, Float.floatToIntBits(instance.getAngleForBoardIndex(74)));
    assertEquals(1076882911, Float.floatToIntBits(instance.getAngleForBoardIndex(75)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(76)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(77)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(78)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(79)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(80)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(81)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(82)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(83)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(84)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(85)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(86)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(87)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(88)));
    assertEquals(1080177110, Float.floatToIntBits(instance.getAngleForBoardIndex(89)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(90)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(91)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(92)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(93)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(94)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(95)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(96)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(97)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(98)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(99)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(100)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(101)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(102)));
    assertEquals(-1074048047, Float.floatToIntBits(instance.getAngleForBoardIndex(103)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(104)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(105)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(106)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(107)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(108)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(109)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(110)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(111)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(112)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(113)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(114)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(115)));
    assertEquals(-1085730852, Float.floatToIntBits(instance.getAngleForBoardIndex(116)));
    assertEquals(-1085730852, Float.floatToIntBits(instance.getAngleForBoardIndex(117)));
    assertEquals(-1085730852, Float.floatToIntBits(instance.getAngleForBoardIndex(118)));
    assertEquals(-1085730852, Float.floatToIntBits(instance.getAngleForBoardIndex(119)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(120)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(121)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(122)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(123)));
    assertEquals(1061752792, Float.floatToIntBits(instance.getAngleForBoardIndex(124)));
    assertEquals(1061752792, Float.floatToIntBits(instance.getAngleForBoardIndex(125)));
    assertEquals(1061752792, Float.floatToIntBits(instance.getAngleForBoardIndex(126)));
    assertEquals(1061752792, Float.floatToIntBits(instance.getAngleForBoardIndex(127)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(128)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(129)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(130)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(131)));
    assertEquals(1075235811, Float.floatToIntBits(instance.getAngleForBoardIndex(132)));
    assertEquals(1075235811, Float.floatToIntBits(instance.getAngleForBoardIndex(133)));
    assertEquals(1075235811, Float.floatToIntBits(instance.getAngleForBoardIndex(134)));
    assertEquals(1075235811, Float.floatToIntBits(instance.getAngleForBoardIndex(135)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(136)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(137)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(138)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(139)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(140)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(141)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(142)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(143)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(144)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(145)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(146)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(147)));
    assertEquals(-1085730852, Float.floatToIntBits(instance.getAngleForBoardIndex(148)));
    assertEquals(-1085730852, Float.floatToIntBits(instance.getAngleForBoardIndex(149)));
    assertEquals(-1085730852, Float.floatToIntBits(instance.getAngleForBoardIndex(150)));
    assertEquals(-1085730852, Float.floatToIntBits(instance.getAngleForBoardIndex(151)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(152)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(153)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(154)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(155)));
    assertEquals(1061752792, Float.floatToIntBits(instance.getAngleForBoardIndex(156)));
    assertEquals(1061752792, Float.floatToIntBits(instance.getAngleForBoardIndex(157)));
    assertEquals(1061752792, Float.floatToIntBits(instance.getAngleForBoardIndex(158)));
    assertEquals(1061752792, Float.floatToIntBits(instance.getAngleForBoardIndex(159)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(160)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(161)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(162)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(163)));
    assertEquals(1075235811, Float.floatToIntBits(instance.getAngleForBoardIndex(164)));
    assertEquals(1075235811, Float.floatToIntBits(instance.getAngleForBoardIndex(165)));
    assertEquals(1075235811, Float.floatToIntBits(instance.getAngleForBoardIndex(166)));
    assertEquals(1075235811, Float.floatToIntBits(instance.getAngleForBoardIndex(167)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(168)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(169)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(170)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(171)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(172)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(173)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(174)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(175)));

    // test with 10 players
    board = new Board(10);
    instance = new GridBoardLayout(board);
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(0)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(1)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(2)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(3)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(4)));
    assertEquals(-1079977604, Float.floatToIntBits(instance.getAngleForBoardIndex(5)));
    assertEquals(-1083095492, Float.floatToIntBits(instance.getAngleForBoardIndex(6)));
    assertEquals(-1083095492, Float.floatToIntBits(instance.getAngleForBoardIndex(7)));
    assertEquals(-1083095492, Float.floatToIntBits(instance.getAngleForBoardIndex(8)));
    assertEquals(-1083095492, Float.floatToIntBits(instance.getAngleForBoardIndex(9)));
    assertEquals(-1083095492, Float.floatToIntBits(instance.getAngleForBoardIndex(10)));
    assertEquals(-1083095492, Float.floatToIntBits(instance.getAngleForBoardIndex(11)));
    assertEquals(-1083095492, Float.floatToIntBits(instance.getAngleForBoardIndex(12)));
    assertEquals(-1083095492, Float.floatToIntBits(instance.getAngleForBoardIndex(13)));
    assertEquals(-1083095492, Float.floatToIntBits(instance.getAngleForBoardIndex(14)));
    assertEquals(-1083095492, Float.floatToIntBits(instance.getAngleForBoardIndex(15)));
    assertEquals(-1083095492, Float.floatToIntBits(instance.getAngleForBoardIndex(16)));
    assertEquals(-1083095492, Float.floatToIntBits(instance.getAngleForBoardIndex(17)));
    assertEquals(-1083095492, Float.floatToIntBits(instance.getAngleForBoardIndex(18)));
    assertEquals(-1088366212, Float.floatToIntBits(instance.getAngleForBoardIndex(19)));
    assertEquals(-1096754816, Float.floatToIntBits(instance.getAngleForBoardIndex(20)));
    assertEquals(-1096754816, Float.floatToIntBits(instance.getAngleForBoardIndex(21)));
    assertEquals(-1096754816, Float.floatToIntBits(instance.getAngleForBoardIndex(22)));
    assertEquals(-1096754816, Float.floatToIntBits(instance.getAngleForBoardIndex(23)));
    assertEquals(-1096754816, Float.floatToIntBits(instance.getAngleForBoardIndex(24)));
    assertEquals(-1096754816, Float.floatToIntBits(instance.getAngleForBoardIndex(25)));
    assertEquals(-1096754816, Float.floatToIntBits(instance.getAngleForBoardIndex(26)));
    assertEquals(-1096754816, Float.floatToIntBits(instance.getAngleForBoardIndex(27)));
    assertEquals(-1096754816, Float.floatToIntBits(instance.getAngleForBoardIndex(28)));
    assertEquals(-1096754816, Float.floatToIntBits(instance.getAngleForBoardIndex(29)));
    assertEquals(-1096754816, Float.floatToIntBits(instance.getAngleForBoardIndex(30)));
    assertEquals(-1096754816, Float.floatToIntBits(instance.getAngleForBoardIndex(31)));
    assertEquals(-1096754816, Float.floatToIntBits(instance.getAngleForBoardIndex(32)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(33)));
    assertEquals(1050728824, Float.floatToIntBits(instance.getAngleForBoardIndex(34)));
    assertEquals(1050728824, Float.floatToIntBits(instance.getAngleForBoardIndex(35)));
    assertEquals(1050728824, Float.floatToIntBits(instance.getAngleForBoardIndex(36)));
    assertEquals(1050728824, Float.floatToIntBits(instance.getAngleForBoardIndex(37)));
    assertEquals(1050728824, Float.floatToIntBits(instance.getAngleForBoardIndex(38)));
    assertEquals(1050728824, Float.floatToIntBits(instance.getAngleForBoardIndex(39)));
    assertEquals(1050728824, Float.floatToIntBits(instance.getAngleForBoardIndex(40)));
    assertEquals(1050728824, Float.floatToIntBits(instance.getAngleForBoardIndex(41)));
    assertEquals(1050728824, Float.floatToIntBits(instance.getAngleForBoardIndex(42)));
    assertEquals(1050728824, Float.floatToIntBits(instance.getAngleForBoardIndex(43)));
    assertEquals(1050728824, Float.floatToIntBits(instance.getAngleForBoardIndex(44)));
    assertEquals(1050728824, Float.floatToIntBits(instance.getAngleForBoardIndex(45)));
    assertEquals(1050728824, Float.floatToIntBits(instance.getAngleForBoardIndex(46)));
    assertEquals(1059117436, Float.floatToIntBits(instance.getAngleForBoardIndex(47)));
    assertEquals(1064388156, Float.floatToIntBits(instance.getAngleForBoardIndex(48)));
    assertEquals(1064388156, Float.floatToIntBits(instance.getAngleForBoardIndex(49)));
    assertEquals(1064388156, Float.floatToIntBits(instance.getAngleForBoardIndex(50)));
    assertEquals(1064388156, Float.floatToIntBits(instance.getAngleForBoardIndex(51)));
    assertEquals(1064388156, Float.floatToIntBits(instance.getAngleForBoardIndex(52)));
    assertEquals(1064388156, Float.floatToIntBits(instance.getAngleForBoardIndex(53)));
    assertEquals(1064388156, Float.floatToIntBits(instance.getAngleForBoardIndex(54)));
    assertEquals(1064388156, Float.floatToIntBits(instance.getAngleForBoardIndex(55)));
    assertEquals(1064388156, Float.floatToIntBits(instance.getAngleForBoardIndex(56)));
    assertEquals(1064388156, Float.floatToIntBits(instance.getAngleForBoardIndex(57)));
    assertEquals(1064388156, Float.floatToIntBits(instance.getAngleForBoardIndex(58)));
    assertEquals(1064388156, Float.floatToIntBits(instance.getAngleForBoardIndex(59)));
    assertEquals(1064388156, Float.floatToIntBits(instance.getAngleForBoardIndex(60)));
    assertEquals(1067506044, Float.floatToIntBits(instance.getAngleForBoardIndex(61)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(62)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(63)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(64)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(65)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(66)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(67)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(68)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(69)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(70)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(71)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(72)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(73)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(74)));
    assertEquals(1072776762, Float.floatToIntBits(instance.getAngleForBoardIndex(75)));
    assertEquals(1074576971, Float.floatToIntBits(instance.getAngleForBoardIndex(76)));
    assertEquals(1074576971, Float.floatToIntBits(instance.getAngleForBoardIndex(77)));
    assertEquals(1074576971, Float.floatToIntBits(instance.getAngleForBoardIndex(78)));
    assertEquals(1074576971, Float.floatToIntBits(instance.getAngleForBoardIndex(79)));
    assertEquals(1074576971, Float.floatToIntBits(instance.getAngleForBoardIndex(80)));
    assertEquals(1074576971, Float.floatToIntBits(instance.getAngleForBoardIndex(81)));
    assertEquals(1074576971, Float.floatToIntBits(instance.getAngleForBoardIndex(82)));
    assertEquals(1074576971, Float.floatToIntBits(instance.getAngleForBoardIndex(83)));
    assertEquals(1074576971, Float.floatToIntBits(instance.getAngleForBoardIndex(84)));
    assertEquals(1074576971, Float.floatToIntBits(instance.getAngleForBoardIndex(85)));
    assertEquals(1074576971, Float.floatToIntBits(instance.getAngleForBoardIndex(86)));
    assertEquals(1074576971, Float.floatToIntBits(instance.getAngleForBoardIndex(87)));
    assertEquals(1074576971, Float.floatToIntBits(instance.getAngleForBoardIndex(88)));
    assertEquals(1075894652, Float.floatToIntBits(instance.getAngleForBoardIndex(89)));
    assertEquals(1077212331, Float.floatToIntBits(instance.getAngleForBoardIndex(90)));
    assertEquals(1077212331, Float.floatToIntBits(instance.getAngleForBoardIndex(91)));
    assertEquals(1077212331, Float.floatToIntBits(instance.getAngleForBoardIndex(92)));
    assertEquals(1077212331, Float.floatToIntBits(instance.getAngleForBoardIndex(93)));
    assertEquals(1077212331, Float.floatToIntBits(instance.getAngleForBoardIndex(94)));
    assertEquals(1077212331, Float.floatToIntBits(instance.getAngleForBoardIndex(95)));
    assertEquals(1077212331, Float.floatToIntBits(instance.getAngleForBoardIndex(96)));
    assertEquals(1077212331, Float.floatToIntBits(instance.getAngleForBoardIndex(97)));
    assertEquals(1077212331, Float.floatToIntBits(instance.getAngleForBoardIndex(98)));
    assertEquals(1077212331, Float.floatToIntBits(instance.getAngleForBoardIndex(99)));
    assertEquals(1077212331, Float.floatToIntBits(instance.getAngleForBoardIndex(100)));
    assertEquals(1077212331, Float.floatToIntBits(instance.getAngleForBoardIndex(101)));
    assertEquals(1077212331, Float.floatToIntBits(instance.getAngleForBoardIndex(102)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(103)));
    assertEquals(1079847689, Float.floatToIntBits(instance.getAngleForBoardIndex(104)));
    assertEquals(1079847689, Float.floatToIntBits(instance.getAngleForBoardIndex(105)));
    assertEquals(1079847689, Float.floatToIntBits(instance.getAngleForBoardIndex(106)));
    assertEquals(1079847689, Float.floatToIntBits(instance.getAngleForBoardIndex(107)));
    assertEquals(1079847689, Float.floatToIntBits(instance.getAngleForBoardIndex(108)));
    assertEquals(1079847689, Float.floatToIntBits(instance.getAngleForBoardIndex(109)));
    assertEquals(1079847689, Float.floatToIntBits(instance.getAngleForBoardIndex(110)));
    assertEquals(1079847689, Float.floatToIntBits(instance.getAngleForBoardIndex(111)));
    assertEquals(1079847689, Float.floatToIntBits(instance.getAngleForBoardIndex(112)));
    assertEquals(1079847689, Float.floatToIntBits(instance.getAngleForBoardIndex(113)));
    assertEquals(1079847689, Float.floatToIntBits(instance.getAngleForBoardIndex(114)));
    assertEquals(1079847689, Float.floatToIntBits(instance.getAngleForBoardIndex(115)));
    assertEquals(1079847689, Float.floatToIntBits(instance.getAngleForBoardIndex(116)));
    assertEquals(1081165370, Float.floatToIntBits(instance.getAngleForBoardIndex(117)));
    assertEquals(1082306740, Float.floatToIntBits(instance.getAngleForBoardIndex(118)));
    assertEquals(1082306740, Float.floatToIntBits(instance.getAngleForBoardIndex(119)));
    assertEquals(1082306740, Float.floatToIntBits(instance.getAngleForBoardIndex(120)));
    assertEquals(1082306740, Float.floatToIntBits(instance.getAngleForBoardIndex(121)));
    assertEquals(1082306740, Float.floatToIntBits(instance.getAngleForBoardIndex(122)));
    assertEquals(1082306740, Float.floatToIntBits(instance.getAngleForBoardIndex(123)));
    assertEquals(1082306740, Float.floatToIntBits(instance.getAngleForBoardIndex(124)));
    assertEquals(1082306740, Float.floatToIntBits(instance.getAngleForBoardIndex(125)));
    assertEquals(1082306740, Float.floatToIntBits(instance.getAngleForBoardIndex(126)));
    assertEquals(1082306740, Float.floatToIntBits(instance.getAngleForBoardIndex(127)));
    assertEquals(1082306740, Float.floatToIntBits(instance.getAngleForBoardIndex(128)));
    assertEquals(1082306740, Float.floatToIntBits(instance.getAngleForBoardIndex(129)));
    assertEquals(1082306740, Float.floatToIntBits(instance.getAngleForBoardIndex(130)));
    assertEquals(-1074706886, Float.floatToIntBits(instance.getAngleForBoardIndex(131)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(132)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(133)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(134)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(135)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(136)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(137)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(138)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(139)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(140)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(141)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(142)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(143)));
    assertEquals(-1083095492, Float.floatToIntBits(instance.getAngleForBoardIndex(144)));
    assertEquals(-1083095492, Float.floatToIntBits(instance.getAngleForBoardIndex(145)));
    assertEquals(-1083095492, Float.floatToIntBits(instance.getAngleForBoardIndex(146)));
    assertEquals(-1083095492, Float.floatToIntBits(instance.getAngleForBoardIndex(147)));
    assertEquals(-1096754816, Float.floatToIntBits(instance.getAngleForBoardIndex(148)));
    assertEquals(-1096754816, Float.floatToIntBits(instance.getAngleForBoardIndex(149)));
    assertEquals(-1096754816, Float.floatToIntBits(instance.getAngleForBoardIndex(150)));
    assertEquals(-1096754816, Float.floatToIntBits(instance.getAngleForBoardIndex(151)));
    assertEquals(1050728824, Float.floatToIntBits(instance.getAngleForBoardIndex(152)));
    assertEquals(1050728824, Float.floatToIntBits(instance.getAngleForBoardIndex(153)));
    assertEquals(1050728824, Float.floatToIntBits(instance.getAngleForBoardIndex(154)));
    assertEquals(1050728824, Float.floatToIntBits(instance.getAngleForBoardIndex(155)));
    assertEquals(1064388156, Float.floatToIntBits(instance.getAngleForBoardIndex(156)));
    assertEquals(1064388156, Float.floatToIntBits(instance.getAngleForBoardIndex(157)));
    assertEquals(1064388156, Float.floatToIntBits(instance.getAngleForBoardIndex(158)));
    assertEquals(1064388156, Float.floatToIntBits(instance.getAngleForBoardIndex(159)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(160)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(161)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(162)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(163)));
    assertEquals(1074576971, Float.floatToIntBits(instance.getAngleForBoardIndex(164)));
    assertEquals(1074576971, Float.floatToIntBits(instance.getAngleForBoardIndex(165)));
    assertEquals(1074576971, Float.floatToIntBits(instance.getAngleForBoardIndex(166)));
    assertEquals(1074576971, Float.floatToIntBits(instance.getAngleForBoardIndex(167)));
    assertEquals(1077212331, Float.floatToIntBits(instance.getAngleForBoardIndex(168)));
    assertEquals(1077212331, Float.floatToIntBits(instance.getAngleForBoardIndex(169)));
    assertEquals(1077212331, Float.floatToIntBits(instance.getAngleForBoardIndex(170)));
    assertEquals(1077212331, Float.floatToIntBits(instance.getAngleForBoardIndex(171)));
    assertEquals(1079847689, Float.floatToIntBits(instance.getAngleForBoardIndex(172)));
    assertEquals(1079847689, Float.floatToIntBits(instance.getAngleForBoardIndex(173)));
    assertEquals(1079847689, Float.floatToIntBits(instance.getAngleForBoardIndex(174)));
    assertEquals(1079847689, Float.floatToIntBits(instance.getAngleForBoardIndex(175)));
    assertEquals(1082306740, Float.floatToIntBits(instance.getAngleForBoardIndex(176)));
    assertEquals(1082306740, Float.floatToIntBits(instance.getAngleForBoardIndex(177)));
    assertEquals(1082306740, Float.floatToIntBits(instance.getAngleForBoardIndex(178)));
    assertEquals(1082306740, Float.floatToIntBits(instance.getAngleForBoardIndex(179)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(180)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(181)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(182)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(183)));
    assertEquals(-1083095492, Float.floatToIntBits(instance.getAngleForBoardIndex(184)));
    assertEquals(-1083095492, Float.floatToIntBits(instance.getAngleForBoardIndex(185)));
    assertEquals(-1083095492, Float.floatToIntBits(instance.getAngleForBoardIndex(186)));
    assertEquals(-1083095492, Float.floatToIntBits(instance.getAngleForBoardIndex(187)));
    assertEquals(-1096754816, Float.floatToIntBits(instance.getAngleForBoardIndex(188)));
    assertEquals(-1096754816, Float.floatToIntBits(instance.getAngleForBoardIndex(189)));
    assertEquals(-1096754816, Float.floatToIntBits(instance.getAngleForBoardIndex(190)));
    assertEquals(-1096754816, Float.floatToIntBits(instance.getAngleForBoardIndex(191)));
    assertEquals(1050728824, Float.floatToIntBits(instance.getAngleForBoardIndex(192)));
    assertEquals(1050728824, Float.floatToIntBits(instance.getAngleForBoardIndex(193)));
    assertEquals(1050728824, Float.floatToIntBits(instance.getAngleForBoardIndex(194)));
    assertEquals(1050728824, Float.floatToIntBits(instance.getAngleForBoardIndex(195)));
    assertEquals(1064388156, Float.floatToIntBits(instance.getAngleForBoardIndex(196)));
    assertEquals(1064388156, Float.floatToIntBits(instance.getAngleForBoardIndex(197)));
    assertEquals(1064388156, Float.floatToIntBits(instance.getAngleForBoardIndex(198)));
    assertEquals(1064388156, Float.floatToIntBits(instance.getAngleForBoardIndex(199)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(200)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(201)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(202)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(203)));
    assertEquals(1074576971, Float.floatToIntBits(instance.getAngleForBoardIndex(204)));
    assertEquals(1074576971, Float.floatToIntBits(instance.getAngleForBoardIndex(205)));
    assertEquals(1074576971, Float.floatToIntBits(instance.getAngleForBoardIndex(206)));
    assertEquals(1074576971, Float.floatToIntBits(instance.getAngleForBoardIndex(207)));
    assertEquals(1077212331, Float.floatToIntBits(instance.getAngleForBoardIndex(208)));
    assertEquals(1077212331, Float.floatToIntBits(instance.getAngleForBoardIndex(209)));
    assertEquals(1077212331, Float.floatToIntBits(instance.getAngleForBoardIndex(210)));
    assertEquals(1077212331, Float.floatToIntBits(instance.getAngleForBoardIndex(211)));
    assertEquals(1079847689, Float.floatToIntBits(instance.getAngleForBoardIndex(212)));
    assertEquals(1079847689, Float.floatToIntBits(instance.getAngleForBoardIndex(213)));
    assertEquals(1079847689, Float.floatToIntBits(instance.getAngleForBoardIndex(214)));
    assertEquals(1079847689, Float.floatToIntBits(instance.getAngleForBoardIndex(215)));
    assertEquals(1082306740, Float.floatToIntBits(instance.getAngleForBoardIndex(216)));
    assertEquals(1082306740, Float.floatToIntBits(instance.getAngleForBoardIndex(217)));
    assertEquals(1082306740, Float.floatToIntBits(instance.getAngleForBoardIndex(218)));
    assertEquals(1082306740, Float.floatToIntBits(instance.getAngleForBoardIndex(219)));

    // test with 12 players
    board = new Board(12);
    instance = new GridBoardLayout(board);
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(0)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(1)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(2)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(3)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(4)));
    assertEquals(-1079538378, Float.floatToIntBits(instance.getAngleForBoardIndex(5)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(6)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(7)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(8)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(9)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(10)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(11)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(12)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(13)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(14)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(15)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(16)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(17)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(18)));
    assertEquals(-1085730853, Float.floatToIntBits(instance.getAngleForBoardIndex(19)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(20)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(21)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(22)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(23)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(24)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(25)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(26)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(27)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(28)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(29)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(30)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(31)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(32)));
    assertEquals(-1098511726, Float.floatToIntBits(instance.getAngleForBoardIndex(33)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(34)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(35)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(36)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(37)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(38)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(39)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(40)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(41)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(42)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(43)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(44)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(45)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(46)));
    assertEquals(1048971922, Float.floatToIntBits(instance.getAngleForBoardIndex(47)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(48)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(49)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(50)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(51)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(52)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(53)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(54)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(55)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(56)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(57)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(58)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(59)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(60)));
    assertEquals(1061752795, Float.floatToIntBits(instance.getAngleForBoardIndex(61)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(62)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(63)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(64)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(65)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(66)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(67)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(68)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(69)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(70)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(71)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(72)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(73)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(74)));
    assertEquals(1067945270, Float.floatToIntBits(instance.getAngleForBoardIndex(75)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(76)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(77)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(78)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(79)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(80)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(81)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(82)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(83)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(84)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(85)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(86)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(87)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(88)));
    assertEquals(1072337535, Float.floatToIntBits(instance.getAngleForBoardIndex(89)));
    assertEquals(1074137745, Float.floatToIntBits(instance.getAngleForBoardIndex(90)));
    assertEquals(1074137745, Float.floatToIntBits(instance.getAngleForBoardIndex(91)));
    assertEquals(1074137745, Float.floatToIntBits(instance.getAngleForBoardIndex(92)));
    assertEquals(1074137745, Float.floatToIntBits(instance.getAngleForBoardIndex(93)));
    assertEquals(1074137745, Float.floatToIntBits(instance.getAngleForBoardIndex(94)));
    assertEquals(1074137745, Float.floatToIntBits(instance.getAngleForBoardIndex(95)));
    assertEquals(1074137745, Float.floatToIntBits(instance.getAngleForBoardIndex(96)));
    assertEquals(1074137745, Float.floatToIntBits(instance.getAngleForBoardIndex(97)));
    assertEquals(1074137745, Float.floatToIntBits(instance.getAngleForBoardIndex(98)));
    assertEquals(1074137745, Float.floatToIntBits(instance.getAngleForBoardIndex(99)));
    assertEquals(1074137745, Float.floatToIntBits(instance.getAngleForBoardIndex(100)));
    assertEquals(1074137745, Float.floatToIntBits(instance.getAngleForBoardIndex(101)));
    assertEquals(1074137745, Float.floatToIntBits(instance.getAngleForBoardIndex(102)));
    assertEquals(1075235812, Float.floatToIntBits(instance.getAngleForBoardIndex(103)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(104)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(105)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(106)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(107)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(108)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(109)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(110)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(111)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(112)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(113)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(114)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(115)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(116)));
    assertEquals(1077431944, Float.floatToIntBits(instance.getAngleForBoardIndex(117)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(118)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(119)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(120)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(121)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(122)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(123)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(124)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(125)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(126)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(127)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(128)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(129)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(130)));
    assertEquals(1079628077, Float.floatToIntBits(instance.getAngleForBoardIndex(131)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(132)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(133)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(134)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(135)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(136)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(137)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(138)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(139)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(140)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(141)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(142)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(143)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(144)));
    assertEquals(1081824209, Float.floatToIntBits(instance.getAngleForBoardIndex(145)));
    assertEquals(1082526354, Float.floatToIntBits(instance.getAngleForBoardIndex(146)));
    assertEquals(1082526354, Float.floatToIntBits(instance.getAngleForBoardIndex(147)));
    assertEquals(1082526354, Float.floatToIntBits(instance.getAngleForBoardIndex(148)));
    assertEquals(1082526354, Float.floatToIntBits(instance.getAngleForBoardIndex(149)));
    assertEquals(1082526354, Float.floatToIntBits(instance.getAngleForBoardIndex(150)));
    assertEquals(1082526354, Float.floatToIntBits(instance.getAngleForBoardIndex(151)));
    assertEquals(1082526354, Float.floatToIntBits(instance.getAngleForBoardIndex(152)));
    assertEquals(1082526354, Float.floatToIntBits(instance.getAngleForBoardIndex(153)));
    assertEquals(1082526354, Float.floatToIntBits(instance.getAngleForBoardIndex(154)));
    assertEquals(1082526354, Float.floatToIntBits(instance.getAngleForBoardIndex(155)));
    assertEquals(1082526354, Float.floatToIntBits(instance.getAngleForBoardIndex(156)));
    assertEquals(1082526354, Float.floatToIntBits(instance.getAngleForBoardIndex(157)));
    assertEquals(1082526354, Float.floatToIntBits(instance.getAngleForBoardIndex(158)));
    assertEquals(-1075146113, Float.floatToIntBits(instance.getAngleForBoardIndex(159)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(160)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(161)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(162)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(163)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(164)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(165)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(166)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(167)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(168)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(169)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(170)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(171)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(172)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(173)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(174)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(175)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(176)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(177)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(178)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(179)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(180)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(181)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(182)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(183)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(184)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(185)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(186)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(187)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(188)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(189)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(190)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(191)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(192)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(193)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(194)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(195)));
    assertEquals(1074137745, Float.floatToIntBits(instance.getAngleForBoardIndex(196)));
    assertEquals(1074137745, Float.floatToIntBits(instance.getAngleForBoardIndex(197)));
    assertEquals(1074137745, Float.floatToIntBits(instance.getAngleForBoardIndex(198)));
    assertEquals(1074137745, Float.floatToIntBits(instance.getAngleForBoardIndex(199)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(200)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(201)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(202)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(203)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(204)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(205)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(206)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(207)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(208)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(209)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(210)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(211)));
    assertEquals(1082526354, Float.floatToIntBits(instance.getAngleForBoardIndex(212)));
    assertEquals(1082526354, Float.floatToIntBits(instance.getAngleForBoardIndex(213)));
    assertEquals(1082526354, Float.floatToIntBits(instance.getAngleForBoardIndex(214)));
    assertEquals(1082526354, Float.floatToIntBits(instance.getAngleForBoardIndex(215)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(216)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(217)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(218)));
    assertEquals(-1077342245, Float.floatToIntBits(instance.getAngleForBoardIndex(219)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(220)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(221)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(222)));
    assertEquals(-1081734510, Float.floatToIntBits(instance.getAngleForBoardIndex(223)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(224)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(225)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(226)));
    assertEquals(-1090123116, Float.floatToIntBits(instance.getAngleForBoardIndex(227)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(228)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(229)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(230)));
    assertEquals(0, Float.floatToIntBits(instance.getAngleForBoardIndex(231)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(232)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(233)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(234)));
    assertEquals(1057360528, Float.floatToIntBits(instance.getAngleForBoardIndex(235)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(236)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(237)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(238)));
    assertEquals(1065749138, Float.floatToIntBits(instance.getAngleForBoardIndex(239)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(240)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(241)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(242)));
    assertEquals(1070141402, Float.floatToIntBits(instance.getAngleForBoardIndex(243)));
    assertEquals(1074137745, Float.floatToIntBits(instance.getAngleForBoardIndex(244)));
    assertEquals(1074137745, Float.floatToIntBits(instance.getAngleForBoardIndex(245)));
    assertEquals(1074137745, Float.floatToIntBits(instance.getAngleForBoardIndex(246)));
    assertEquals(1074137745, Float.floatToIntBits(instance.getAngleForBoardIndex(247)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(248)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(249)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(250)));
    assertEquals(1076333877, Float.floatToIntBits(instance.getAngleForBoardIndex(251)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(252)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(253)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(254)));
    assertEquals(1078530011, Float.floatToIntBits(instance.getAngleForBoardIndex(255)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(256)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(257)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(258)));
    assertEquals(1080726143, Float.floatToIntBits(instance.getAngleForBoardIndex(259)));
    assertEquals(1082526354, Float.floatToIntBits(instance.getAngleForBoardIndex(260)));
    assertEquals(1082526354, Float.floatToIntBits(instance.getAngleForBoardIndex(261)));
    assertEquals(1082526354, Float.floatToIntBits(instance.getAngleForBoardIndex(262)));
    assertEquals(1082526354, Float.floatToIntBits(instance.getAngleForBoardIndex(263)));

  }

  /**
   * Test of getBoundsForBoardIndex method, of class GridBoardLayout.
   */
  @Test
  @SuppressWarnings("PMD.UseUnderscoresInNumericLiterals")
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

    // code to generate expected values
    /*for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      System.out.printf("// test with %d players\n", numberOfPlayers);
      System.out.printf("board = new Board(%d);\n", numberOfPlayers);
      System.out.printf("instance = new GridBoardLayout(board);\n");
      GridBoardLayout gridBoardLayout = new GridBoardLayout(new Board(numberOfPlayers));
      for (int i = 0; i < gridBoardLayout.board.getNumberOfPlayableSpaces(); i++) {
        Rectangle rectangle = gridBoardLayout.getBoundsForBoardIndex(i);
        System.out.printf("assertEquals(new Rectangle(Float.intBitsToFloat(%d), "
            + "Float.intBitsToFloat(%d),\nFloat.intBitsToFloat(%d), Float.intBitsToFloat(%d)),\n"
            + "instance.boardIndexToBoundsMap.get(%d));\n",
            Float.floatToIntBits(rectangle.getX()), Float.floatToIntBits(rectangle.getY()),
            Float.floatToIntBits(rectangle.getWidth()), Float.floatToIntBits(rectangle.getHeight()),
            i);
      }
    }*/
    // test with 4 players
    board = new Board(4);
    instance = new GridBoardLayout(board);
    assertEquals(new Rectangle(Float.intBitsToFloat(1051983871), Float.intBitsToFloat(1063439564),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(0));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051983871), Float.intBitsToFloat(1062443417),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(1));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051983871), Float.intBitsToFloat(1061447270),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(2));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051983871), Float.intBitsToFloat(1060451122),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(3));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051983871), Float.intBitsToFloat(1059454975),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(4));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051983872), Float.intBitsToFloat(1058458828),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(5));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049991577), Float.intBitsToFloat(1058458828),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(6));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047422566), Float.intBitsToFloat(1058458828),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(7));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043437977), Float.intBitsToFloat(1058458828),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(8));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038719383), Float.intBitsToFloat(1058458828),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(9));
    assertEquals(new Rectangle(Float.intBitsToFloat(1029701628), Float.intBitsToFloat(1058458828),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(10));
    assertEquals(new Rectangle(Float.intBitsToFloat(1029701628), Float.intBitsToFloat(1057462681),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(11));
    assertEquals(new Rectangle(Float.intBitsToFloat(1029701630), Float.intBitsToFloat(1055968460),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(12));
    assertEquals(new Rectangle(Float.intBitsToFloat(1029701632), Float.intBitsToFloat(1053976166),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(13));
    assertEquals(new Rectangle(Float.intBitsToFloat(1029701632), Float.intBitsToFloat(1051983871),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(14));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038719385), Float.intBitsToFloat(1051983871),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(15));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043437978), Float.intBitsToFloat(1051983871),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(16));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047422566), Float.intBitsToFloat(1051983872),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(17));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049991578), Float.intBitsToFloat(1051983872),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(18));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051983872), Float.intBitsToFloat(1051983872),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(19));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051983872), Float.intBitsToFloat(1049991577),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(20));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051983872), Float.intBitsToFloat(1047422566),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(21));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051983872), Float.intBitsToFloat(1043437978),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(22));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051983872), Float.intBitsToFloat(1038719385),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(23));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051983872), Float.intBitsToFloat(1029701630),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(24));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053976167), Float.intBitsToFloat(1029701630),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(25));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055968461), Float.intBitsToFloat(1029701630),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(26));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057462681), Float.intBitsToFloat(1029701630),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(27));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058458828), Float.intBitsToFloat(1029701630),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(28));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058458828), Float.intBitsToFloat(1038719385),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(29));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058458828), Float.intBitsToFloat(1043437978),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(30));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058458828), Float.intBitsToFloat(1047422566),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(31));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058458828), Float.intBitsToFloat(1049991577),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(32));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058458828), Float.intBitsToFloat(1051983872),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(33));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059454975), Float.intBitsToFloat(1051983873),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(34));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060451122), Float.intBitsToFloat(1051983873),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(35));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061447270), Float.intBitsToFloat(1051983873),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(36));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062443417), Float.intBitsToFloat(1051983874),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(37));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063439564), Float.intBitsToFloat(1051983874),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(38));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063439564), Float.intBitsToFloat(1053976169),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(39));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063439564), Float.intBitsToFloat(1055968463),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(40));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063439564), Float.intBitsToFloat(1057462682),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(41));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063439564), Float.intBitsToFloat(1058458829),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(42));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062443417), Float.intBitsToFloat(1058458829),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(43));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061447270), Float.intBitsToFloat(1058458829),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(44));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060451122), Float.intBitsToFloat(1058458828),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(45));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059454975), Float.intBitsToFloat(1058458828),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(46));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058458828), Float.intBitsToFloat(1058458828),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(47));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058458828), Float.intBitsToFloat(1059454975),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(48));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058458828), Float.intBitsToFloat(1060451122),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(49));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058458828), Float.intBitsToFloat(1061447270),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(50));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058458828), Float.intBitsToFloat(1062443417),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(51));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058458828), Float.intBitsToFloat(1063439564),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(52));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057462681), Float.intBitsToFloat(1063439564),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(53));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055968460), Float.intBitsToFloat(1063439564),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(54));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053976166), Float.intBitsToFloat(1063439564),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(55));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055968460), Float.intBitsToFloat(1062443417),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(56));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055968460), Float.intBitsToFloat(1061447270),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(57));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055968460), Float.intBitsToFloat(1060451122),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(58));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055968460), Float.intBitsToFloat(1059454975),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(59));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038719385), Float.intBitsToFloat(1055968460),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(60));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043437978), Float.intBitsToFloat(1055968460),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(61));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047422566), Float.intBitsToFloat(1055968461),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(62));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049991577), Float.intBitsToFloat(1055968461),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(63));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055968461), Float.intBitsToFloat(1038719385),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(64));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055968461), Float.intBitsToFloat(1043437978),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(65));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055968461), Float.intBitsToFloat(1047422566),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(66));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055968461), Float.intBitsToFloat(1049991577),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(67));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062443417), Float.intBitsToFloat(1055968463),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(68));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061447270), Float.intBitsToFloat(1055968463),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(69));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060451122), Float.intBitsToFloat(1055968461),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(70));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059454975), Float.intBitsToFloat(1055968461),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(71));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052980019), Float.intBitsToFloat(1064435712),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(72));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054972313), Float.intBitsToFloat(1064435712),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(73));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964607), Float.intBitsToFloat(1064435712),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(74));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057960754), Float.intBitsToFloat(1064435712),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(75));
    assertEquals(new Rectangle(Float.intBitsToFloat(-1147561604), Float.intBitsToFloat(1052980019),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(76));
    assertEquals(new Rectangle(Float.intBitsToFloat(-1147561592), Float.intBitsToFloat(1054972313),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(77));
    assertEquals(new Rectangle(Float.intBitsToFloat(-1147561584), Float.intBitsToFloat(1056964607),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(78));
    assertEquals(new Rectangle(Float.intBitsToFloat(-1147561572), Float.intBitsToFloat(1057960754),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(79));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057960755), Float.intBitsToFloat(-1147561592),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(80));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964608), Float.intBitsToFloat(-1147561588),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(81));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054972314), Float.intBitsToFloat(-1147561588),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(82));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052980019), Float.intBitsToFloat(-1147561584),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(83));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064435712), Float.intBitsToFloat(1057960756),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(84));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064435712), Float.intBitsToFloat(1056964609),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(85));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064435712), Float.intBitsToFloat(1054972316),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(86));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064435712), Float.intBitsToFloat(1052980021),
        Float.intBitsToFloat(1030959923), Float.intBitsToFloat(1030959923)),
        instance.boardIndexToBoundsMap.get(87));

    // test with 6 players
    board = new Board(6);
    instance = new GridBoardLayout(board);
    assertEquals(new Rectangle(Float.intBitsToFloat(1052770303), Float.intBitsToFloat(1063675494),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(0));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052770303), Float.intBitsToFloat(1062836633),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(1));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052770303), Float.intBitsToFloat(1061997772),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(2));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052770303), Float.intBitsToFloat(1061158912),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(3));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052770303), Float.intBitsToFloat(1060320051),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(4));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052744225), Float.intBitsToFloat(1059473662),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(5));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051265197), Float.intBitsToFloat(1059885564),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(6));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049812247), Float.intBitsToFloat(1060304995),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(7));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048142596), Float.intBitsToFloat(1060724425),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(8));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045236697), Float.intBitsToFloat(1061143856),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(9));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042330798), Float.intBitsToFloat(1061563286),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(10));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040653076), Float.intBitsToFloat(1060836812),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(11));
    assertEquals(new Rectangle(Float.intBitsToFloat(1037763317), Float.intBitsToFloat(1060110337),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(12));
    assertEquals(new Rectangle(Float.intBitsToFloat(1034407873), Float.intBitsToFloat(1059383862),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(13));
    assertEquals(new Rectangle(Float.intBitsToFloat(1030306074), Float.intBitsToFloat(1058657388),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(14));
    assertEquals(new Rectangle(Float.intBitsToFloat(1036864227), Float.intBitsToFloat(1058237958),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(15));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041431708), Float.intBitsToFloat(1057818527),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(16));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044337607), Float.intBitsToFloat(1057399097),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(17));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047243506), Float.intBitsToFloat(1056979666),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(18));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049362703), Float.intBitsToFloat(1056125748),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(19));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047243506), Float.intBitsToFloat(1055256773),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(20));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044337608), Float.intBitsToFloat(1054417912),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(21));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041431709), Float.intBitsToFloat(1053579051),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(22));
    assertEquals(new Rectangle(Float.intBitsToFloat(1036864229), Float.intBitsToFloat(1052740191),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(23));
    assertEquals(new Rectangle(Float.intBitsToFloat(1030306078), Float.intBitsToFloat(1051901330),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(24));
    assertEquals(new Rectangle(Float.intBitsToFloat(1034407874), Float.intBitsToFloat(1050448381),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(25));
    assertEquals(new Rectangle(Float.intBitsToFloat(1037763317), Float.intBitsToFloat(1048995431),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(26));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040653076), Float.intBitsToFloat(1046508963),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(27));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042330797), Float.intBitsToFloat(1043603064),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(28));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045236696), Float.intBitsToFloat(1045280786),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(29));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048142594), Float.intBitsToFloat(1046958506),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(30));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049812247), Float.intBitsToFloat(1048606114),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(31));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051265197), Float.intBitsToFloat(1049444975),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(32));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052744225), Float.intBitsToFloat(1050268779),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(33));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052770304), Float.intBitsToFloat(1048576001),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(34));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052770304), Float.intBitsToFloat(1045220558),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(35));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052770304), Float.intBitsToFloat(1041865114),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(36));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052770304), Float.intBitsToFloat(1036831951),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(37));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052770304), Float.intBitsToFloat(1028443346),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(38));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054448025), Float.intBitsToFloat(1028443346),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(39));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056125747), Float.intBitsToFloat(1028443346),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(40));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057384039), Float.intBitsToFloat(1028443346),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(41));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058222900), Float.intBitsToFloat(1028443346),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(42));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058222900), Float.intBitsToFloat(1036831951),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(43));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058222900), Float.intBitsToFloat(1041865114),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(44));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058222900), Float.intBitsToFloat(1045220558),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(45));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058222900), Float.intBitsToFloat(1048576001),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(46));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058235939), Float.intBitsToFloat(1050268778),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(47));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058975452), Float.intBitsToFloat(1049444973),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(48));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059701927), Float.intBitsToFloat(1048606113),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(49));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060428402), Float.intBitsToFloat(1046958502),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(50));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061154876), Float.intBitsToFloat(1045280780),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(51));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061881351), Float.intBitsToFloat(1043603058),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(52));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062300781), Float.intBitsToFloat(1046508957),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(53));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062720212), Float.intBitsToFloat(1048995428),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(54));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063139643), Float.intBitsToFloat(1050448377),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(55));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063559073), Float.intBitsToFloat(1051901327),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(56));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062832598), Float.intBitsToFloat(1052740188),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(57));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062106124), Float.intBitsToFloat(1053579049),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(58));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061379649), Float.intBitsToFloat(1054417911),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(59));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060653174), Float.intBitsToFloat(1055256771),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(60));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059926700), Float.intBitsToFloat(1056125748),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(61));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060653175), Float.intBitsToFloat(1056979666),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(62));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061379650), Float.intBitsToFloat(1057399097),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(63));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062106124), Float.intBitsToFloat(1057818527),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(64));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062832599), Float.intBitsToFloat(1058237958),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(65));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063559074), Float.intBitsToFloat(1058657388),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(66));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063139643), Float.intBitsToFloat(1059383862),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(67));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062720213), Float.intBitsToFloat(1060110337),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(68));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062300783), Float.intBitsToFloat(1060836812),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(69));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061881352), Float.intBitsToFloat(1061563286),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(70));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061154877), Float.intBitsToFloat(1061143856),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(71));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060428402), Float.intBitsToFloat(1060724425),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(72));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059701928), Float.intBitsToFloat(1060304995),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(73));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058975453), Float.intBitsToFloat(1059885564),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(74));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058235938), Float.intBitsToFloat(1059473662),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(75));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058222899), Float.intBitsToFloat(1060320051),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(76));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058222899), Float.intBitsToFloat(1061158912),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(77));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058222899), Float.intBitsToFloat(1061997772),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(78));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058222899), Float.intBitsToFloat(1062836633),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(79));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058222899), Float.intBitsToFloat(1063675494),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(80));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057384038), Float.intBitsToFloat(1063675494),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(81));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056125746), Float.intBitsToFloat(1063675494),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(82));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054448024), Float.intBitsToFloat(1063675494),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(83));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056125746), Float.intBitsToFloat(1062836633),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(84));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056125746), Float.intBitsToFloat(1061997772),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(85));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056125746), Float.intBitsToFloat(1061158912),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(86));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056125746), Float.intBitsToFloat(1060320051),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(87));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041881253), Float.intBitsToFloat(1059690907),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(88));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044787152), Float.intBitsToFloat(1059271476),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(89));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047693050), Float.intBitsToFloat(1058852046),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(90));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049587475), Float.intBitsToFloat(1058432615),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(91));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041881253), Float.intBitsToFloat(1049834292),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(92));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044787152), Float.intBitsToFloat(1050673153),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(93));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047693050), Float.intBitsToFloat(1051512013),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(94));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049587475), Float.intBitsToFloat(1052350874),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(95));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056125747), Float.intBitsToFloat(1036831951),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(96));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056125747), Float.intBitsToFloat(1041865114),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(97));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056125747), Float.intBitsToFloat(1045220558),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(98));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056125747), Float.intBitsToFloat(1048576001),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(99));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061993737), Float.intBitsToFloat(1049834289),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(100));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061267263), Float.intBitsToFloat(1050673150),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(101));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060540788), Float.intBitsToFloat(1051512011),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(102));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059814313), Float.intBitsToFloat(1052350873),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(103));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061993738), Float.intBitsToFloat(1059690907),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(104));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061267264), Float.intBitsToFloat(1059271476),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(105));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060540789), Float.intBitsToFloat(1058852046),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(106));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059814314), Float.intBitsToFloat(1058432615),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(107));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053609163), Float.intBitsToFloat(1064514356),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(108));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055286885), Float.intBitsToFloat(1064514356),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(109));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964607), Float.intBitsToFloat(1064514356),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(110));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057803469), Float.intBitsToFloat(1064514356),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(111));
    assertEquals(new Rectangle(Float.intBitsToFloat(1020665661), Float.intBitsToFloat(1059440055),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(112));
    assertEquals(new Rectangle(Float.intBitsToFloat(1028748806), Float.intBitsToFloat(1060166530),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(113));
    assertEquals(new Rectangle(Float.intBitsToFloat(1033629239), Float.intBitsToFloat(1060893004),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(114));
    assertEquals(new Rectangle(Float.intBitsToFloat(1036984683), Float.intBitsToFloat(1061619479),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(115));
    assertEquals(new Rectangle(Float.intBitsToFloat(1036984681), Float.intBitsToFloat(1043378292),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(116));
    assertEquals(new Rectangle(Float.intBitsToFloat(1033629239), Float.intBitsToFloat(1046284190),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(117));
    assertEquals(new Rectangle(Float.intBitsToFloat(1028748806), Float.intBitsToFloat(1048883045),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(118));
    assertEquals(new Rectangle(Float.intBitsToFloat(1020665665), Float.intBitsToFloat(1050335994),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(119));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057803469), Float.intBitsToFloat(834666496),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(120));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964607), Float.intBitsToFloat(834666496),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(121));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055286886), Float.intBitsToFloat(834666496),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(122));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053609165), Float.intBitsToFloat(834666496),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(123));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064075834), Float.intBitsToFloat(1050335991),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(124));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063656403), Float.intBitsToFloat(1048883042),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(125));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063236973), Float.intBitsToFloat(1046284185),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(126));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062817542), Float.intBitsToFloat(1043378286),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(127));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062817542), Float.intBitsToFloat(1061619479),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(128));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063236973), Float.intBitsToFloat(1060893004),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(129));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063656403), Float.intBitsToFloat(1060166530),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(130));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064075834), Float.intBitsToFloat(1059440055),
        Float.intBitsToFloat(1028443341), Float.intBitsToFloat(1028443341)),
        instance.boardIndexToBoundsMap.get(131));

    // test with 8 players
    board = new Board(8);
    instance = new GridBoardLayout(board);
    assertEquals(new Rectangle(Float.intBitsToFloat(1053342253), Float.intBitsToFloat(1063847080),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(0));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053342253), Float.intBitsToFloat(1063122609),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(1));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053342253), Float.intBitsToFloat(1062398139),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(2));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053342253), Float.intBitsToFloat(1061673668),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(3));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053342253), Float.intBitsToFloat(1060949197),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(4));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053254361), Float.intBitsToFloat(1060206524),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(5));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141912), Float.intBitsToFloat(1060700599),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(6));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051117356), Float.intBitsToFloat(1061212877),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(7));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050092799), Float.intBitsToFloat(1061725155),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(8));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049068243), Float.intBitsToFloat(1062237433),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(9));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047511375), Float.intBitsToFloat(1062749711),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(10));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045462261), Float.intBitsToFloat(1062237433),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(11));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043413149), Float.intBitsToFloat(1061725155),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(12));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041364037), Float.intBitsToFloat(1061212877),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(13));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038442455), Float.intBitsToFloat(1060700599),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(14));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041364037), Float.intBitsToFloat(1060188321),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(15));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043413149), Float.intBitsToFloat(1059676043),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(16));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045462261), Float.intBitsToFloat(1059163765),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(17));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047511375), Float.intBitsToFloat(1058651487),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(18));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049031836), Float.intBitsToFloat(1058095261),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(19));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046516977), Float.intBitsToFloat(1058051314),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(20));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043619095), Float.intBitsToFloat(1058051314),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(21));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040721212), Float.intBitsToFloat(1058051314),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(22));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035459265), Float.intBitsToFloat(1058051314),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(23));
    assertEquals(new Rectangle(Float.intBitsToFloat(1027528216), Float.intBitsToFloat(1058051314),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(24));
    assertEquals(new Rectangle(Float.intBitsToFloat(1027528216), Float.intBitsToFloat(1057326843),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(25));
    assertEquals(new Rectangle(Float.intBitsToFloat(1027528218), Float.intBitsToFloat(1056240136),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(26));
    assertEquals(new Rectangle(Float.intBitsToFloat(1027528220), Float.intBitsToFloat(1054791195),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(27));
    assertEquals(new Rectangle(Float.intBitsToFloat(1027528220), Float.intBitsToFloat(1053342253),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(28));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035459267), Float.intBitsToFloat(1053342253),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(29));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040721213), Float.intBitsToFloat(1053342253),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(30));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043619095), Float.intBitsToFloat(1053342253),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(31));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046516979), Float.intBitsToFloat(1053342254),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(32));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049031836), Float.intBitsToFloat(1053254362),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(33));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047511373), Float.intBitsToFloat(1052141913),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(34));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045462260), Float.intBitsToFloat(1051117357),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(35));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043413147), Float.intBitsToFloat(1050092800),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(36));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041364035), Float.intBitsToFloat(1049068244),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(37));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038442451), Float.intBitsToFloat(1047511377),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(38));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041364035), Float.intBitsToFloat(1045462264),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(39));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043413147), Float.intBitsToFloat(1043413151),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(40));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045462259), Float.intBitsToFloat(1041364038),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(41));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047511371), Float.intBitsToFloat(1038442459),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(42));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049068241), Float.intBitsToFloat(1041364038),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(43));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050092798), Float.intBitsToFloat(1043413151),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(44));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051117354), Float.intBitsToFloat(1045462263),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(45));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141910), Float.intBitsToFloat(1047511375),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(46));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053254360), Float.intBitsToFloat(1049031836),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(47));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053342254), Float.intBitsToFloat(1046516978),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(48));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053342254), Float.intBitsToFloat(1043619095),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(49));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053342254), Float.intBitsToFloat(1040721213),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(50));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053342254), Float.intBitsToFloat(1035459267),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(51));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053342254), Float.intBitsToFloat(1027528218),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(52));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054791196), Float.intBitsToFloat(1027528218),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(53));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056240137), Float.intBitsToFloat(1027528218),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(54));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057326844), Float.intBitsToFloat(1027528218),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(55));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058051314), Float.intBitsToFloat(1027528218),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(56));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058051314), Float.intBitsToFloat(1035459267),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(57));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058051314), Float.intBitsToFloat(1040721213),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(58));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058051314), Float.intBitsToFloat(1043619095),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(59));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058051314), Float.intBitsToFloat(1046516978),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(60));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058095260), Float.intBitsToFloat(1049031836),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(61));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058651485), Float.intBitsToFloat(1047511375),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(62));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059163763), Float.intBitsToFloat(1045462261),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(63));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059676041), Float.intBitsToFloat(1043413149),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(64));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060188319), Float.intBitsToFloat(1041364036),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(65));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060700597), Float.intBitsToFloat(1038442453),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(66));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061212875), Float.intBitsToFloat(1041364035),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(67));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061725153), Float.intBitsToFloat(1043413147),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(68));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062237431), Float.intBitsToFloat(1045462259),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(69));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062749709), Float.intBitsToFloat(1047511371),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(70));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062237431), Float.intBitsToFloat(1049068241),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(71));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061725153), Float.intBitsToFloat(1050092798),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(72));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061212875), Float.intBitsToFloat(1051117354),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(73));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060700597), Float.intBitsToFloat(1052141911),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(74));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060206523), Float.intBitsToFloat(1053254361),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(75));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060949197), Float.intBitsToFloat(1053342255),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(76));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061673668), Float.intBitsToFloat(1053342255),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(77));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062398139), Float.intBitsToFloat(1053342255),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(78));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063122609), Float.intBitsToFloat(1053342256),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(79));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063847080), Float.intBitsToFloat(1053342256),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(80));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063847080), Float.intBitsToFloat(1054791198),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(81));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063847080), Float.intBitsToFloat(1056240139),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(82));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063847080), Float.intBitsToFloat(1057326845),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(83));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063847080), Float.intBitsToFloat(1058051315),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(84));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063122609), Float.intBitsToFloat(1058051315),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(85));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062398139), Float.intBitsToFloat(1058051315),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(86));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061673668), Float.intBitsToFloat(1058051315),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(87));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060949197), Float.intBitsToFloat(1058051314),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(88));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060206524), Float.intBitsToFloat(1058095261),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(89));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060700599), Float.intBitsToFloat(1058651487),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(90));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061212877), Float.intBitsToFloat(1059163765),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(91));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061725155), Float.intBitsToFloat(1059676043),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(92));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062237433), Float.intBitsToFloat(1060188321),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(93));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062749711), Float.intBitsToFloat(1060700599),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(94));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062237433), Float.intBitsToFloat(1061212877),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(95));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061725155), Float.intBitsToFloat(1061725155),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(96));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061212877), Float.intBitsToFloat(1062237433),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(97));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060700599), Float.intBitsToFloat(1062749711),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(98));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060188321), Float.intBitsToFloat(1062237433),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(99));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059676043), Float.intBitsToFloat(1061725155),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(100));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059163765), Float.intBitsToFloat(1061212877),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(101));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058651487), Float.intBitsToFloat(1060700599),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(102));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058095261), Float.intBitsToFloat(1060206524),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(103));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058051314), Float.intBitsToFloat(1060949197),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(104));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058051314), Float.intBitsToFloat(1061673668),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(105));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058051314), Float.intBitsToFloat(1062398139),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(106));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058051314), Float.intBitsToFloat(1063122609),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(107));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058051314), Float.intBitsToFloat(1063847080),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(108));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057326843), Float.intBitsToFloat(1063847080),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(109));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056240136), Float.intBitsToFloat(1063847080),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(110));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054791195), Float.intBitsToFloat(1063847080),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(111));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056240136), Float.intBitsToFloat(1063122609),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(112));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056240136), Float.intBitsToFloat(1062398139),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(113));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056240136), Float.intBitsToFloat(1061673668),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(114));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056240136), Float.intBitsToFloat(1060949197),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(115));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045462261), Float.intBitsToFloat(1061212877),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(116));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047511375), Float.intBitsToFloat(1060700599),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(117));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049068243), Float.intBitsToFloat(1060188321),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(118));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050092799), Float.intBitsToFloat(1059676043),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(119));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035459267), Float.intBitsToFloat(1056240136),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(120));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040721213), Float.intBitsToFloat(1056240136),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(121));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043619095), Float.intBitsToFloat(1056240136),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(122));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046516978), Float.intBitsToFloat(1056240137),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(123));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045462260), Float.intBitsToFloat(1045462263),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(124));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047511373), Float.intBitsToFloat(1047511375),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(125));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049068242), Float.intBitsToFloat(1049068243),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(126));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050092798), Float.intBitsToFloat(1050092800),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(127));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056240137), Float.intBitsToFloat(1035459267),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(128));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056240137), Float.intBitsToFloat(1040721213),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(129));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056240137), Float.intBitsToFloat(1043619095),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(130));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056240137), Float.intBitsToFloat(1046516978),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(131));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061212875), Float.intBitsToFloat(1045462260),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(132));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060700597), Float.intBitsToFloat(1047511373),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(133));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060188319), Float.intBitsToFloat(1049068242),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(134));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059676041), Float.intBitsToFloat(1050092799),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(135));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063122609), Float.intBitsToFloat(1056240139),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(136));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062398139), Float.intBitsToFloat(1056240139),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(137));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061673668), Float.intBitsToFloat(1056240139),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(138));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060949197), Float.intBitsToFloat(1056240137),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(139));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061212877), Float.intBitsToFloat(1061212877),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(140));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060700599), Float.intBitsToFloat(1060700599),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(141));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060188321), Float.intBitsToFloat(1060188321),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(142));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059676043), Float.intBitsToFloat(1059676043),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(143));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054066724), Float.intBitsToFloat(1064571551),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(144));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055515665), Float.intBitsToFloat(1064571551),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(145));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964607), Float.intBitsToFloat(1064571551),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(146));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057689079), Float.intBitsToFloat(1064571551),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(147));
    assertEquals(new Rectangle(Float.intBitsToFloat(1036393343), Float.intBitsToFloat(1061469016),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(148));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040339481), Float.intBitsToFloat(1061981294),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(149));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042388593), Float.intBitsToFloat(1062493572),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(150));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044437706), Float.intBitsToFloat(1063005850),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(151));
    assertEquals(new Rectangle(Float.intBitsToFloat(996109120), Float.intBitsToFloat(1054066724),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(152));
    assertEquals(new Rectangle(Float.intBitsToFloat(996109104), Float.intBitsToFloat(1055515665),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(153));
    assertEquals(new Rectangle(Float.intBitsToFloat(996109088), Float.intBitsToFloat(1056964607),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(154));
    assertEquals(new Rectangle(Float.intBitsToFloat(996109072), Float.intBitsToFloat(1057689079),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(155));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044437703), Float.intBitsToFloat(1036393347),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(156));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042388591), Float.intBitsToFloat(1040339483),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(157));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040339479), Float.intBitsToFloat(1042388595),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(158));
    assertEquals(new Rectangle(Float.intBitsToFloat(1036393340), Float.intBitsToFloat(1044437708),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(159));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057689079), Float.intBitsToFloat(996109096),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(160));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964607), Float.intBitsToFloat(996109096),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(161));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055515666), Float.intBitsToFloat(996109096),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(162));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054066725), Float.intBitsToFloat(996109096),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(163));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063005848), Float.intBitsToFloat(1044437701),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(164));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062493570), Float.intBitsToFloat(1042388589),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(165));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061981292), Float.intBitsToFloat(1040339477),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(166));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061469014), Float.intBitsToFloat(1036393337),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(167));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064571551), Float.intBitsToFloat(1057689080),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(168));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064571551), Float.intBitsToFloat(1056964609),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(169));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064571551), Float.intBitsToFloat(1055515668),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(170));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064571551), Float.intBitsToFloat(1054066727),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(171));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061469016), Float.intBitsToFloat(1063005850),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(172));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061981294), Float.intBitsToFloat(1062493572),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(173));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062493572), Float.intBitsToFloat(1061981294),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(174));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063005850), Float.intBitsToFloat(1061469016),
        Float.intBitsToFloat(1026613099), Float.intBitsToFloat(1026613099)),
        instance.boardIndexToBoundsMap.get(175));

    // test with 10 players
    board = new Board(10);
    instance = new GridBoardLayout(board);
    assertEquals(new Rectangle(Float.intBitsToFloat(1053776936), Float.intBitsToFloat(1063977485),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(0));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053776936), Float.intBitsToFloat(1063339951),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(1));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053776936), Float.intBitsToFloat(1062702417),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(2));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053776936), Float.intBitsToFloat(1062064883),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(3));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053776936), Float.intBitsToFloat(1061427348),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(4));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053647791), Float.intBitsToFloat(1060768832),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(5));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052769180), Float.intBitsToFloat(1061263627),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(6));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052019714), Float.intBitsToFloat(1061779403),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(7));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051270248), Float.intBitsToFloat(1062295179),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(8));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050520781), Float.intBitsToFloat(1062810955),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(9));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049771315), Float.intBitsToFloat(1063326731),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(10));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048739763), Float.intBitsToFloat(1062951998),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(11));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046840422), Float.intBitsToFloat(1062577265),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(12));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044777318), Float.intBitsToFloat(1062202532),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(13));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042714214), Float.intBitsToFloat(1061827799),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(14));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044213147), Float.intBitsToFloat(1061312023),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(15));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045712079), Float.intBitsToFloat(1060796247),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(16));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047211012), Float.intBitsToFloat(1060280471),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(17));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048642972), Float.intBitsToFloat(1059764695),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(18));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049312622), Float.intBitsToFloat(1059193990),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(19));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047464288), Float.intBitsToFloat(1059336070),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(20));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045038964), Float.intBitsToFloat(1059533079),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(21));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042613640), Float.intBitsToFloat(1059730088),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(22));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040188316), Float.intBitsToFloat(1059927097),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(23));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035338590), Float.intBitsToFloat(1060124106),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(24));
    assertEquals(new Rectangle(Float.intBitsToFloat(1033762518), Float.intBitsToFloat(1059517775),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(25));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032186447), Float.intBitsToFloat(1058911444),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(26));
    assertEquals(new Rectangle(Float.intBitsToFloat(1029421968), Float.intBitsToFloat(1058305113),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(27));
    assertEquals(new Rectangle(Float.intBitsToFloat(1026269824), Float.intBitsToFloat(1057698782),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(28));
    assertEquals(new Rectangle(Float.intBitsToFloat(1033884952), Float.intBitsToFloat(1057501773),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(29));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038735599), Float.intBitsToFloat(1057304764),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(30));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041886820), Float.intBitsToFloat(1057107755),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(31));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044312144), Float.intBitsToFloat(1056856884),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(32));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046737469), Float.intBitsToFloat(1056327074),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(33));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044312144), Float.intBitsToFloat(1055797265),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(34));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041886820), Float.intBitsToFloat(1055403247),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(35));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038735599), Float.intBitsToFloat(1055009230),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(36));
    assertEquals(new Rectangle(Float.intBitsToFloat(1033884949), Float.intBitsToFloat(1054615212),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(37));
    assertEquals(new Rectangle(Float.intBitsToFloat(1026269818), Float.intBitsToFloat(1054221194),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(38));
    assertEquals(new Rectangle(Float.intBitsToFloat(1029421960), Float.intBitsToFloat(1053008532),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(39));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032186443), Float.intBitsToFloat(1051795870),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(40));
    assertEquals(new Rectangle(Float.intBitsToFloat(1033762514), Float.intBitsToFloat(1050583208),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(41));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035338585), Float.intBitsToFloat(1049370546),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(42));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040188313), Float.intBitsToFloat(1049764564),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(43));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042613638), Float.intBitsToFloat(1050158582),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(44));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045038962), Float.intBitsToFloat(1050552599),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(45));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047464286), Float.intBitsToFloat(1050946617),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(46));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049312622), Float.intBitsToFloat(1051230776),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(47));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048642974), Float.intBitsToFloat(1050089364),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(48));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047211014), Float.intBitsToFloat(1049057812),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(49));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045712082), Float.intBitsToFloat(1047476520),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(50));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044213150), Float.intBitsToFloat(1045413416),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(51));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042714218), Float.intBitsToFloat(1043350312),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(52));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044777322), Float.intBitsToFloat(1041851380),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(53));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046840426), Float.intBitsToFloat(1040352448),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(54));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048739765), Float.intBitsToFloat(1037519639),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(55));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049771317), Float.intBitsToFloat(1034521774),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(56));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050520783), Float.intBitsToFloat(1038647983),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(57));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051270249), Float.intBitsToFloat(1041480792),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(58));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052019715), Float.intBitsToFloat(1043543896),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(59));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052769182), Float.intBitsToFloat(1045607000),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(60));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053647792), Float.intBitsToFloat(1047586182),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(61));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053776937), Float.intBitsToFloat(1044952121),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(62));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053776937), Float.intBitsToFloat(1042401984),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(63));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053776937), Float.intBitsToFloat(1039516303),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(64));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053776937), Float.intBitsToFloat(1034416029),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(65));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053776937), Float.intBitsToFloat(1026832726),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(66));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055052006), Float.intBitsToFloat(1026832726),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(67));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056327074), Float.intBitsToFloat(1026832726),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(68));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057283375), Float.intBitsToFloat(1026832726),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(69));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057920909), Float.intBitsToFloat(1026832726),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(70));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057920909), Float.intBitsToFloat(1034416029),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(71));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057920909), Float.intBitsToFloat(1039516303),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(72));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057920909), Float.intBitsToFloat(1042401984),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(73));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057920909), Float.intBitsToFloat(1044952121),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(74));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057985482), Float.intBitsToFloat(1047586182),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(75));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058424787), Float.intBitsToFloat(1045607000),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(76));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058799520), Float.intBitsToFloat(1043543896),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(77));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059174253), Float.intBitsToFloat(1041480792),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(78));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059548986), Float.intBitsToFloat(1038647983),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(79));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059923719), Float.intBitsToFloat(1034521774),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(80));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060439495), Float.intBitsToFloat(1037519639),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(81));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060955271), Float.intBitsToFloat(1040352448),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(82));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061471047), Float.intBitsToFloat(1041851380),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(83));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061986823), Float.intBitsToFloat(1043350312),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(84));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061612090), Float.intBitsToFloat(1045413416),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(85));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061237357), Float.intBitsToFloat(1047476520),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(86));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060862624), Float.intBitsToFloat(1049057812),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(87));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060487891), Float.intBitsToFloat(1050089364),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(88));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060153067), Float.intBitsToFloat(1051230776),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(89));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060799307), Float.intBitsToFloat(1050946617),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(90));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061405638), Float.intBitsToFloat(1050552599),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(91));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062011969), Float.intBitsToFloat(1050158581),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(92));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062618300), Float.intBitsToFloat(1049764564),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(93));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063224631), Float.intBitsToFloat(1049370546),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(94));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063421640), Float.intBitsToFloat(1050583208),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(95));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063618649), Float.intBitsToFloat(1051795870),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(96));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063815658), Float.intBitsToFloat(1053008532),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(97));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064012667), Float.intBitsToFloat(1054221194),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(98));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063406336), Float.intBitsToFloat(1054615212),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(99));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062800005), Float.intBitsToFloat(1055009229),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(100));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062193674), Float.intBitsToFloat(1055403247),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(101));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061587343), Float.intBitsToFloat(1055797265),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(102));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060981012), Float.intBitsToFloat(1056327074),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(103));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061587343), Float.intBitsToFloat(1056856882),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(104));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062193674), Float.intBitsToFloat(1057107754),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(105));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062800005), Float.intBitsToFloat(1057304762),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(106));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063406336), Float.intBitsToFloat(1057501771),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(107));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064012667), Float.intBitsToFloat(1057698780),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(108));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063815658), Float.intBitsToFloat(1058305111),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(109));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063618649), Float.intBitsToFloat(1058911442),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(110));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063421640), Float.intBitsToFloat(1059517773),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(111));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063224631), Float.intBitsToFloat(1060124104),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(112));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062618300), Float.intBitsToFloat(1059927095),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(113));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062011969), Float.intBitsToFloat(1059730086),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(114));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061405638), Float.intBitsToFloat(1059533078),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(115));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060799307), Float.intBitsToFloat(1059336069),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(116));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060153067), Float.intBitsToFloat(1059193990),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(117));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060487892), Float.intBitsToFloat(1059764695),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(118));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060862626), Float.intBitsToFloat(1060280471),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(119));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061237359), Float.intBitsToFloat(1060796247),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(120));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061612092), Float.intBitsToFloat(1061312023),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(121));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061986825), Float.intBitsToFloat(1061827799),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(122));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061471049), Float.intBitsToFloat(1062202532),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(123));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060955273), Float.intBitsToFloat(1062577265),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(124));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060439497), Float.intBitsToFloat(1062951998),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(125));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059923721), Float.intBitsToFloat(1063326731),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(126));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059548988), Float.intBitsToFloat(1062810955),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(127));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059174255), Float.intBitsToFloat(1062295179),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(128));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058799522), Float.intBitsToFloat(1061779403),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(129));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058424788), Float.intBitsToFloat(1061263627),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(130));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057985482), Float.intBitsToFloat(1060768832),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(131));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057920909), Float.intBitsToFloat(1061427348),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(132));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057920909), Float.intBitsToFloat(1062064883),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(133));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057920909), Float.intBitsToFloat(1062702417),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(134));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057920909), Float.intBitsToFloat(1063339951),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(135));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057920909), Float.intBitsToFloat(1063977485),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(136));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057283375), Float.intBitsToFloat(1063977485),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(137));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056327073), Float.intBitsToFloat(1063977485),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(138));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055052005), Float.intBitsToFloat(1063977485),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(139));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056327073), Float.intBitsToFloat(1063339951),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(140));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056327073), Float.intBitsToFloat(1062702417),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(141));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056327073), Float.intBitsToFloat(1062064883),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(142));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056327073), Float.intBitsToFloat(1061427348),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(143));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048339354), Float.intBitsToFloat(1062061489),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(144));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049207144), Float.intBitsToFloat(1061545713),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(145));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049956610), Float.intBitsToFloat(1061029937),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(146));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050706076), Float.intBitsToFloat(1060514161),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(147));
    assertEquals(new Rectangle(Float.intBitsToFloat(1037037095), Float.intBitsToFloat(1058714435),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(148));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041037568), Float.intBitsToFloat(1058517426),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(149));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043462892), Float.intBitsToFloat(1058320417),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(150));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045888216), Float.intBitsToFloat(1058123408),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(151));
    assertEquals(new Rectangle(Float.intBitsToFloat(1037037091), Float.intBitsToFloat(1052189888),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(152));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041037566), Float.intBitsToFloat(1052583906),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(153));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043462890), Float.intBitsToFloat(1052977923),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(154));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045888215), Float.intBitsToFloat(1053371941),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(155));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048339358), Float.intBitsToFloat(1042415552),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(156));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049207145), Float.intBitsToFloat(1044478656),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(157));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049956611), Float.intBitsToFloat(1046541760),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(158));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050706078), Float.intBitsToFloat(1048590432),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(159));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056327074), Float.intBitsToFloat(1034416029),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(160));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056327074), Float.intBitsToFloat(1039516303),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(161));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056327074), Float.intBitsToFloat(1042401984),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(162));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056327074), Float.intBitsToFloat(1044952121),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(163));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060580538), Float.intBitsToFloat(1042415552),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(164));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060205805), Float.intBitsToFloat(1044478656),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(165));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059831072), Float.intBitsToFloat(1046541760),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(166));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059456339), Float.intBitsToFloat(1048590432),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(167));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063012318), Float.intBitsToFloat(1052189888),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(168));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062405987), Float.intBitsToFloat(1052583905),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(169));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061799656), Float.intBitsToFloat(1052977923),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(170));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061193325), Float.intBitsToFloat(1053371941),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(171));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063012318), Float.intBitsToFloat(1058714433),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(172));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062405987), Float.intBitsToFloat(1058517424),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(173));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061799656), Float.intBitsToFloat(1058320416),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(174));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061193325), Float.intBitsToFloat(1058123407),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(175));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060580540), Float.intBitsToFloat(1062061489),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(176));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060205807), Float.intBitsToFloat(1061545713),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(177));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059831074), Float.intBitsToFloat(1061029937),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(178));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059456340), Float.intBitsToFloat(1060514161),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(179));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054414470), Float.intBitsToFloat(1064615019),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(180));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055689539), Float.intBitsToFloat(1064615019),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(181));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964608), Float.intBitsToFloat(1064615019),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(182));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057602142), Float.intBitsToFloat(1064615019),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(183));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042246834), Float.intBitsToFloat(1062530941),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(184));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044309938), Float.intBitsToFloat(1062905674),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(185));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046373042), Float.intBitsToFloat(1063280408),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(186));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048436146), Float.intBitsToFloat(1063655141),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(187));
    assertEquals(new Rectangle(Float.intBitsToFloat(1010736482), Float.intBitsToFloat(1058198957),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(188));
    assertEquals(new Rectangle(Float.intBitsToFloat(1019183311), Float.intBitsToFloat(1058805287),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(189));
    assertEquals(new Rectangle(Float.intBitsToFloat(1024448886), Float.intBitsToFloat(1059411619),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(190));
    assertEquals(new Rectangle(Float.intBitsToFloat(1027601028), Float.intBitsToFloat(1060017949),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(191));
    assertEquals(new Rectangle(Float.intBitsToFloat(1027601018), Float.intBitsToFloat(1049582859),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(192));
    assertEquals(new Rectangle(Float.intBitsToFloat(1024448878), Float.intBitsToFloat(1050795521),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(193));
    assertEquals(new Rectangle(Float.intBitsToFloat(1019183295), Float.intBitsToFloat(1052008183),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(194));
    assertEquals(new Rectangle(Float.intBitsToFloat(1010736454), Float.intBitsToFloat(1053220845),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(195));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048436150), Float.intBitsToFloat(1031894499),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(196));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046373046), Float.intBitsToFloat(1034892363),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(197));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044309942), Float.intBitsToFloat(1037890227),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(198));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042246838), Float.intBitsToFloat(1040537742),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(199));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057602142), Float.intBitsToFloat(1002740660),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(200));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964608), Float.intBitsToFloat(1002740660),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(201));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055689540), Float.intBitsToFloat(1002740660),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(202));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054414472), Float.intBitsToFloat(1002740660),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(203));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062103669), Float.intBitsToFloat(1040537742),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(204));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061587893), Float.intBitsToFloat(1037890227),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(205));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061072117), Float.intBitsToFloat(1034892363),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(206));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060556341), Float.intBitsToFloat(1031894499),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(207));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064520492), Float.intBitsToFloat(1053220845),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(208));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064323483), Float.intBitsToFloat(1052008183),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(209));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064126475), Float.intBitsToFloat(1050795521),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(210));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063929466), Float.intBitsToFloat(1049582859),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(211));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063929467), Float.intBitsToFloat(1060017948),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(212));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064126476), Float.intBitsToFloat(1059411617),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(213));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064323484), Float.intBitsToFloat(1058805285),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(214));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064520493), Float.intBitsToFloat(1058198954),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(215));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060556341), Float.intBitsToFloat(1063655141),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(216));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061072117), Float.intBitsToFloat(1063280408),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(217));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061587893), Float.intBitsToFloat(1062905674),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(218));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062103669), Float.intBitsToFloat(1062530941),
        Float.intBitsToFloat(1025222115), Float.intBitsToFloat(1025222115)),
        instance.boardIndexToBoundsMap.get(219));

    // test with 12 players
    board = new Board(12);
    instance = new GridBoardLayout(board);
    assertEquals(new Rectangle(Float.intBitsToFloat(1054118472), Float.intBitsToFloat(1064079945),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(0));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054118472), Float.intBitsToFloat(1063510718),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(1));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054118472), Float.intBitsToFloat(1062941491),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(2));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054118472), Float.intBitsToFloat(1062372264),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(3));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054118472), Float.intBitsToFloat(1061803037),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(4));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053965948), Float.intBitsToFloat(1061213376),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(5));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053244197), Float.intBitsToFloat(1061685907),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(6));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052674970), Float.intBitsToFloat(1062178872),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(7));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052105743), Float.intBitsToFloat(1062671837),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(8));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051536516), Float.intBitsToFloat(1063164802),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(9));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050967289), Float.intBitsToFloat(1063657767),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(10));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049981359), Float.intBitsToFloat(1063373153),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(11));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048995429), Float.intBitsToFloat(1063088540),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(12));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047442998), Float.intBitsToFloat(1062803927),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(13));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045471138), Float.intBitsToFloat(1062519313),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(14));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046609592), Float.intBitsToFloat(1062026348),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(15));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047748046), Float.intBitsToFloat(1061533383),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(16));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048731250), Float.intBitsToFloat(1061040418),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(17));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049300477), Float.intBitsToFloat(1060547453),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(18));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049758050), Float.intBitsToFloat(1059998660),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(19));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048660465), Float.intBitsToFloat(1060227447),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(20));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046773070), Float.intBitsToFloat(1060512061),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(21));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044801210), Float.intBitsToFloat(1060796674),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(22));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042829350), Float.intBitsToFloat(1061081287),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(23));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040857490), Float.intBitsToFloat(1061365901),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(24));
    assertEquals(new Rectangle(Float.intBitsToFloat(1039250680), Float.intBitsToFloat(1060872936),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(25));
    assertEquals(new Rectangle(Float.intBitsToFloat(1036973772), Float.intBitsToFloat(1060379971),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(26));
    assertEquals(new Rectangle(Float.intBitsToFloat(1034696864), Float.intBitsToFloat(1059887006),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(27));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032419956), Float.intBitsToFloat(1059394041),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(28));
    assertEquals(new Rectangle(Float.intBitsToFloat(1036363676), Float.intBitsToFloat(1059109427),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(29));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040247394), Float.intBitsToFloat(1058824814),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(30));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042219254), Float.intBitsToFloat(1058540201),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(31));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044191114), Float.intBitsToFloat(1058255587),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(32));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046081236), Float.intBitsToFloat(1057894710),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(33));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043722590), Float.intBitsToFloat(1057818448),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(34));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041445682), Float.intBitsToFloat(1057818448),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(35));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038150158), Float.intBitsToFloat(1057818448),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(36));
    assertEquals(new Rectangle(Float.intBitsToFloat(1033596342), Float.intBitsToFloat(1057818448),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(37));
    assertEquals(new Rectangle(Float.intBitsToFloat(1026286270), Float.intBitsToFloat(1057818448),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(38));
    assertEquals(new Rectangle(Float.intBitsToFloat(1026286272), Float.intBitsToFloat(1057249221),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(39));
    assertEquals(new Rectangle(Float.intBitsToFloat(1026286272), Float.intBitsToFloat(1056395380),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(40));
    assertEquals(new Rectangle(Float.intBitsToFloat(1026286274), Float.intBitsToFloat(1055256926),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(41));
    assertEquals(new Rectangle(Float.intBitsToFloat(1026286274), Float.intBitsToFloat(1054118472),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(42));
    assertEquals(new Rectangle(Float.intBitsToFloat(1033596344), Float.intBitsToFloat(1054118472),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(43));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038150160), Float.intBitsToFloat(1054118472),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(44));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041445684), Float.intBitsToFloat(1054118472),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(45));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043722592), Float.intBitsToFloat(1054118472),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(46));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046081237), Float.intBitsToFloat(1053965948),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(47));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044191114), Float.intBitsToFloat(1053244199),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(48));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042219254), Float.intBitsToFloat(1052674972),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(49));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040247394), Float.intBitsToFloat(1052105745),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(50));
    assertEquals(new Rectangle(Float.intBitsToFloat(1036363677), Float.intBitsToFloat(1051536518),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(51));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032419957), Float.intBitsToFloat(1050967291),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(52));
    assertEquals(new Rectangle(Float.intBitsToFloat(1034696864), Float.intBitsToFloat(1049981361),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(53));
    assertEquals(new Rectangle(Float.intBitsToFloat(1036973772), Float.intBitsToFloat(1048995431),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(54));
    assertEquals(new Rectangle(Float.intBitsToFloat(1039250680), Float.intBitsToFloat(1047443002),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(55));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040857490), Float.intBitsToFloat(1045471142),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(56));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042829350), Float.intBitsToFloat(1046609596),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(57));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044801210), Float.intBitsToFloat(1047748050),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(58));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046773070), Float.intBitsToFloat(1048731252),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(59));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048660465), Float.intBitsToFloat(1049300479),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(60));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049758050), Float.intBitsToFloat(1049758049),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(61));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049300479), Float.intBitsToFloat(1048660463),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(62));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048731253), Float.intBitsToFloat(1046773067),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(63));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047748052), Float.intBitsToFloat(1044801207),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(64));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046609598), Float.intBitsToFloat(1042829347),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(65));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045471144), Float.intBitsToFloat(1040857487),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(66));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047443004), Float.intBitsToFloat(1039250676),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(67));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048995432), Float.intBitsToFloat(1036973768),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(68));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049981362), Float.intBitsToFloat(1034696861),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(69));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050967292), Float.intBitsToFloat(1032419954),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(70));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051536519), Float.intBitsToFloat(1036363674),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(71));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052105746), Float.intBitsToFloat(1040247393),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(72));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052674973), Float.intBitsToFloat(1042219253),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(73));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053244199), Float.intBitsToFloat(1044191113),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(74));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053965950), Float.intBitsToFloat(1046081236),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(75));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054118473), Float.intBitsToFloat(1043722591),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(76));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054118473), Float.intBitsToFloat(1041445683),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(77));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054118473), Float.intBitsToFloat(1038150160),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(78));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054118473), Float.intBitsToFloat(1033596344),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(79));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054118473), Float.intBitsToFloat(1026286272),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(80));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055256927), Float.intBitsToFloat(1026286272),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(81));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056395381), Float.intBitsToFloat(1026286272),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(82));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057249222), Float.intBitsToFloat(1026286272),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(83));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057818449), Float.intBitsToFloat(1026286272),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(84));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057818449), Float.intBitsToFloat(1033596344),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(85));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057818449), Float.intBitsToFloat(1038150160),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(86));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057818449), Float.intBitsToFloat(1041445683),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(87));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057818449), Float.intBitsToFloat(1043722591),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(88));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057894710), Float.intBitsToFloat(1046081236),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(89));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058255585), Float.intBitsToFloat(1044191113),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(90));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058540199), Float.intBitsToFloat(1042219253),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(91));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058824812), Float.intBitsToFloat(1040247393),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(92));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059109426), Float.intBitsToFloat(1036363674),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(93));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059394039), Float.intBitsToFloat(1032419954),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(94));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059887004), Float.intBitsToFloat(1034696861),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(95));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060379969), Float.intBitsToFloat(1036973768),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(96));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060872934), Float.intBitsToFloat(1039250676),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(97));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061365899), Float.intBitsToFloat(1040857487),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(98));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061081286), Float.intBitsToFloat(1042829347),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(99));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060796672), Float.intBitsToFloat(1044801207),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(100));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060512059), Float.intBitsToFloat(1046773067),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(101));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060227445), Float.intBitsToFloat(1048660463),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(102));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059998660), Float.intBitsToFloat(1049758048),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(103));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060547452), Float.intBitsToFloat(1049300477),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(104));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061040417), Float.intBitsToFloat(1048731249),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(105));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061533382), Float.intBitsToFloat(1047748044),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(106));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062026347), Float.intBitsToFloat(1046609590),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(107));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062519312), Float.intBitsToFloat(1045471136),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(108));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062803925), Float.intBitsToFloat(1047442996),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(109));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063088539), Float.intBitsToFloat(1048995428),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(110));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063373153), Float.intBitsToFloat(1049981358),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(111));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063657766), Float.intBitsToFloat(1050967288),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(112));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063164801), Float.intBitsToFloat(1051536515),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(113));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062671836), Float.intBitsToFloat(1052105742),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(114));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062178871), Float.intBitsToFloat(1052674969),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(115));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061685906), Float.intBitsToFloat(1053244197),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(116));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061213376), Float.intBitsToFloat(1053965949),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(117));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061803037), Float.intBitsToFloat(1054118474),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(118));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062372264), Float.intBitsToFloat(1054118474),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(119));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062941491), Float.intBitsToFloat(1054118475),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(120));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063510718), Float.intBitsToFloat(1054118475),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(121));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064079945), Float.intBitsToFloat(1054118475),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(122));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064079945), Float.intBitsToFloat(1055256929),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(123));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064079945), Float.intBitsToFloat(1056395383),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(124));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064079945), Float.intBitsToFloat(1057249223),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(125));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064079945), Float.intBitsToFloat(1057818450),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(126));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063510718), Float.intBitsToFloat(1057818450),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(127));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062941491), Float.intBitsToFloat(1057818450),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(128));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062372264), Float.intBitsToFloat(1057818450),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(129));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061803037), Float.intBitsToFloat(1057818450),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(130));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061213376), Float.intBitsToFloat(1057894712),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(131));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061685907), Float.intBitsToFloat(1058255587),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(132));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062178872), Float.intBitsToFloat(1058540201),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(133));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062671837), Float.intBitsToFloat(1058824814),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(134));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063164802), Float.intBitsToFloat(1059109427),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(135));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063657767), Float.intBitsToFloat(1059394041),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(136));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063373153), Float.intBitsToFloat(1059887006),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(137));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063088540), Float.intBitsToFloat(1060379971),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(138));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062803927), Float.intBitsToFloat(1060872936),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(139));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062519313), Float.intBitsToFloat(1061365901),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(140));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062026348), Float.intBitsToFloat(1061081287),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(141));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061533383), Float.intBitsToFloat(1060796674),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(142));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061040418), Float.intBitsToFloat(1060512061),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(143));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060547453), Float.intBitsToFloat(1060227447),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(144));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059998660), Float.intBitsToFloat(1059998660),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(145));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060227447), Float.intBitsToFloat(1060547453),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(146));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060512061), Float.intBitsToFloat(1061040418),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(147));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060796674), Float.intBitsToFloat(1061533383),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(148));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061081287), Float.intBitsToFloat(1062026348),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(149));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061365901), Float.intBitsToFloat(1062519313),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(150));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060872936), Float.intBitsToFloat(1062803927),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(151));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060379971), Float.intBitsToFloat(1063088540),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(152));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059887006), Float.intBitsToFloat(1063373153),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(153));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059394041), Float.intBitsToFloat(1063657767),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(154));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059109427), Float.intBitsToFloat(1063164802),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(155));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058824814), Float.intBitsToFloat(1062671837),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(156));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058540201), Float.intBitsToFloat(1062178872),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(157));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058255587), Float.intBitsToFloat(1061685907),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(158));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057894710), Float.intBitsToFloat(1061213376),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(159));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057818448), Float.intBitsToFloat(1061803037),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(160));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057818448), Float.intBitsToFloat(1062372264),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(161));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057818448), Float.intBitsToFloat(1062941491),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(162));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057818448), Float.intBitsToFloat(1063510718),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(163));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057818448), Float.intBitsToFloat(1064079945),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(164));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057249221), Float.intBitsToFloat(1064079945),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(165));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056395380), Float.intBitsToFloat(1064079945),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(166));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055256926), Float.intBitsToFloat(1064079945),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(167));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056395380), Float.intBitsToFloat(1063510718),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(168));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056395380), Float.intBitsToFloat(1062941491),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(169));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056395380), Float.intBitsToFloat(1062372264),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(170));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056395380), Float.intBitsToFloat(1061803037),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(171));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049564656), Float.intBitsToFloat(1062595575),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(172));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050133883), Float.intBitsToFloat(1062102610),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(173));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050703110), Float.intBitsToFloat(1061609645),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(174));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051272337), Float.intBitsToFloat(1061116680),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(175));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040552442), Float.intBitsToFloat(1060095357),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(176));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042524302), Float.intBitsToFloat(1059810744),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(177));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044496162), Float.intBitsToFloat(1059526131),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(178));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046468022), Float.intBitsToFloat(1059241517),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(179));
    assertEquals(new Rectangle(Float.intBitsToFloat(1033596344), Float.intBitsToFloat(1056395380),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(180));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038150160), Float.intBitsToFloat(1056395380),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(181));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041445683), Float.intBitsToFloat(1056395380),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(182));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043722591), Float.intBitsToFloat(1056395380),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(183));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040552442), Float.intBitsToFloat(1049564658),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(184));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042524302), Float.intBitsToFloat(1050133885),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(185));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044496162), Float.intBitsToFloat(1050703112),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(186));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046468022), Float.intBitsToFloat(1051272339),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(187));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049564659), Float.intBitsToFloat(1040552440),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(188));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050133886), Float.intBitsToFloat(1042524300),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(189));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050703113), Float.intBitsToFloat(1044496160),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(190));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051272339), Float.intBitsToFloat(1046468020),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(191));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056395381), Float.intBitsToFloat(1033596344),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(192));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056395381), Float.intBitsToFloat(1038150160),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(193));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056395381), Float.intBitsToFloat(1041445683),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(194));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056395381), Float.intBitsToFloat(1043722591),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(195));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060095356), Float.intBitsToFloat(1040552440),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(196));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059810742), Float.intBitsToFloat(1042524300),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(197));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059526129), Float.intBitsToFloat(1044496160),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(198));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059241515), Float.intBitsToFloat(1046468020),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(199));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062595574), Float.intBitsToFloat(1049564655),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(200));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062102609), Float.intBitsToFloat(1050133882),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(201));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061609644), Float.intBitsToFloat(1050703109),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(202));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061116679), Float.intBitsToFloat(1051272337),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(203));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063510718), Float.intBitsToFloat(1056395383),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(204));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062941491), Float.intBitsToFloat(1056395383),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(205));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062372264), Float.intBitsToFloat(1056395383),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(206));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061803037), Float.intBitsToFloat(1056395383),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(207));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062595575), Float.intBitsToFloat(1060095357),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(208));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062102610), Float.intBitsToFloat(1059810744),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(209));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061609645), Float.intBitsToFloat(1059526131),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(210));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061116680), Float.intBitsToFloat(1059241517),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(211));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060095357), Float.intBitsToFloat(1062595575),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(212));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059810744), Float.intBitsToFloat(1062102610),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(213));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059526131), Float.intBitsToFloat(1061609645),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(214));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059241517), Float.intBitsToFloat(1061116680),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(215));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054687699), Float.intBitsToFloat(1064649173),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(216));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055826153), Float.intBitsToFloat(1064649173),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(217));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964607), Float.intBitsToFloat(1064649173),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(218));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057533835), Float.intBitsToFloat(1064649173),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(219));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045318616), Float.intBitsToFloat(1063154585),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(220));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047290476), Float.intBitsToFloat(1063439198),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(221));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048919168), Float.intBitsToFloat(1063723812),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(222));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049905098), Float.intBitsToFloat(1064008425),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(223));
    assertEquals(new Rectangle(Float.intBitsToFloat(1027430596), Float.intBitsToFloat(1059925137),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(224));
    assertEquals(new Rectangle(Float.intBitsToFloat(1031891598), Float.intBitsToFloat(1060418102),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(225));
    assertEquals(new Rectangle(Float.intBitsToFloat(1034168506), Float.intBitsToFloat(1060911066),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(226));
    assertEquals(new Rectangle(Float.intBitsToFloat(1036445414), Float.intBitsToFloat(1061404031),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(227));
    assertEquals(new Rectangle(Float.intBitsToFloat(1006872646), Float.intBitsToFloat(1054687699),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(228));
    assertEquals(new Rectangle(Float.intBitsToFloat(1006872644), Float.intBitsToFloat(1055826153),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(229));
    assertEquals(new Rectangle(Float.intBitsToFloat(1006872640), Float.intBitsToFloat(1056964607),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(230));
    assertEquals(new Rectangle(Float.intBitsToFloat(1006872638), Float.intBitsToFloat(1057533835),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(231));
    assertEquals(new Rectangle(Float.intBitsToFloat(1036445413), Float.intBitsToFloat(1045318618),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(232));
    assertEquals(new Rectangle(Float.intBitsToFloat(1034168506), Float.intBitsToFloat(1047290478),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(233));
    assertEquals(new Rectangle(Float.intBitsToFloat(1031891598), Float.intBitsToFloat(1048919169),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(234));
    assertEquals(new Rectangle(Float.intBitsToFloat(1027430598), Float.intBitsToFloat(1049905099),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(235));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049905100), Float.intBitsToFloat(1027430590),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(236));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048919170), Float.intBitsToFloat(1031891594),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(237));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047290480), Float.intBitsToFloat(1034168502),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(238));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045318620), Float.intBitsToFloat(1036445409),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(239));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057533835), Float.intBitsToFloat(1006872642),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(240));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964607), Float.intBitsToFloat(1006872642),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(241));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055826154), Float.intBitsToFloat(1006872642),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(242));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054687700), Float.intBitsToFloat(1006872642),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(243));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061404031), Float.intBitsToFloat(1036445409),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(244));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060911065), Float.intBitsToFloat(1034168502),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(245));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060418101), Float.intBitsToFloat(1031891594),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(246));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059925135), Float.intBitsToFloat(1027430590),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(247));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064008425), Float.intBitsToFloat(1049905096),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(248));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063723812), Float.intBitsToFloat(1048919166),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(249));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063439198), Float.intBitsToFloat(1047290472),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(250));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063154585), Float.intBitsToFloat(1045318612),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(251));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064649173), Float.intBitsToFloat(1057533836),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(252));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064649173), Float.intBitsToFloat(1056964609),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(253));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064649173), Float.intBitsToFloat(1055826156),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(254));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064649173), Float.intBitsToFloat(1054687702),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(255));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063154585), Float.intBitsToFloat(1061404031),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(256));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063439198), Float.intBitsToFloat(1060911066),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(257));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063723812), Float.intBitsToFloat(1060418102),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(258));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064008425), Float.intBitsToFloat(1059925137),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(259));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059925137), Float.intBitsToFloat(1064008425),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(260));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060418102), Float.intBitsToFloat(1063723812),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(261));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060911066), Float.intBitsToFloat(1063439198),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(262));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061404031), Float.intBitsToFloat(1063154585),
        Float.intBitsToFloat(1024129199), Float.intBitsToFloat(1024129199)),
        instance.boardIndexToBoundsMap.get(263));

  }

  /**
   * Test of getBoundsForDiscardPile method, of class GridBoardLayout.
   */
  @Test
  @SuppressWarnings("PMD.UseUnderscoresInNumericLiterals")
  public void testGetBoundsForDiscardPile() {

    System.out.println("getBoundsForDiscardPile");

    Board board = new Board(4);
    GridBoardLayout instance = new GridBoardLayout(board);
    Rectangle expResult = new Rectangle(Float.intBitsToFloat(1054972314),
        Float.intBitsToFloat(1054175396), Float.intBitsToFloat(1039348531),
        Float.intBitsToFloat(1042955633));
    Rectangle result = instance.getBoundsForDiscardPile();
    /*System.out.printf("Rectangle expResult = new Rectangle(Float.intBitsToFloat(%d),\n"
        + "Float.intBitsToFloat(%d), Float.intBitsToFloat(%d),\n"
        + "Float.intBitsToFloat(%d));", Float.floatToIntBits(result.getX()),
        Float.floatToIntBits(result.getY()), Float.floatToIntBits(result.getWidth()),
        Float.floatToIntBits(result.getHeight()));*/
    assertEquals(expResult, result);

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
