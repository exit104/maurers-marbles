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
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141157), Float.intBitsToFloat(1063235093),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(0));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141157), Float.intBitsToFloat(1062270403),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(1));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141157), Float.intBitsToFloat(1061305713),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(2));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141157), Float.intBitsToFloat(1060341023),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(3));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141157), Float.intBitsToFloat(1059376333),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(4));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141158), Float.intBitsToFloat(1058411642),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(5));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050211778), Float.intBitsToFloat(1058411642),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(6));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047988796), Float.intBitsToFloat(1058411642),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(7));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044130037), Float.intBitsToFloat(1058411642),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(8));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040271277), Float.intBitsToFloat(1058411642),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(9));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032637643), Float.intBitsToFloat(1058411642),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(10));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032637643), Float.intBitsToFloat(1057446952),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(11));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032637644), Float.intBitsToFloat(1055999917),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(12));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032637645), Float.intBitsToFloat(1054070537),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(13));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032637645), Float.intBitsToFloat(1052141157),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(14));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040271278), Float.intBitsToFloat(1052141157),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(15));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044130038), Float.intBitsToFloat(1052141157),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(16));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047988798), Float.intBitsToFloat(1052141158),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(17));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050211779), Float.intBitsToFloat(1052141158),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(18));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141158), Float.intBitsToFloat(1052141158),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(19));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141158), Float.intBitsToFloat(1050211778),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(20));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141158), Float.intBitsToFloat(1047988796),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(21));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141158), Float.intBitsToFloat(1044130038),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(22));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141158), Float.intBitsToFloat(1040271278),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(23));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141158), Float.intBitsToFloat(1032637644),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(24));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054070538), Float.intBitsToFloat(1032637644),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(25));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055999918), Float.intBitsToFloat(1032637644),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(26));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057446953), Float.intBitsToFloat(1032637644),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(27));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411643), Float.intBitsToFloat(1032637644),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(28));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411643), Float.intBitsToFloat(1040271278),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(29));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411643), Float.intBitsToFloat(1044130038),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(30));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411643), Float.intBitsToFloat(1047988796),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(31));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411643), Float.intBitsToFloat(1050211778),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(32));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411643), Float.intBitsToFloat(1052141158),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(33));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059376333), Float.intBitsToFloat(1052141159),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(34));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060341023), Float.intBitsToFloat(1052141159),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(35));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061305713), Float.intBitsToFloat(1052141159),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(36));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062270403), Float.intBitsToFloat(1052141160),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(37));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063235093), Float.intBitsToFloat(1052141160),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(38));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063235093), Float.intBitsToFloat(1054070540),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(39));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063235093), Float.intBitsToFloat(1055999920),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(40));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063235093), Float.intBitsToFloat(1057446954),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(41));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063235093), Float.intBitsToFloat(1058411644),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(42));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062270403), Float.intBitsToFloat(1058411644),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(43));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061305713), Float.intBitsToFloat(1058411644),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(44));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060341023), Float.intBitsToFloat(1058411643),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(45));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059376333), Float.intBitsToFloat(1058411643),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(46));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411642), Float.intBitsToFloat(1058411643),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(47));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411642), Float.intBitsToFloat(1059376333),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(48));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411642), Float.intBitsToFloat(1060341023),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(49));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411642), Float.intBitsToFloat(1061305713),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(50));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411642), Float.intBitsToFloat(1062270403),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(51));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411642), Float.intBitsToFloat(1063235093),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(52));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057446952), Float.intBitsToFloat(1063235093),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(53));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055999917), Float.intBitsToFloat(1063235093),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(54));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054070537), Float.intBitsToFloat(1063235093),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(55));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055999917), Float.intBitsToFloat(1062270403),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(56));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055999917), Float.intBitsToFloat(1061305713),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(57));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055999917), Float.intBitsToFloat(1060341023),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(58));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055999917), Float.intBitsToFloat(1059376333),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(59));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040271278), Float.intBitsToFloat(1055999917),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(60));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044130038), Float.intBitsToFloat(1055999917),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(61));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047988796), Float.intBitsToFloat(1055999918),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(62));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050211778), Float.intBitsToFloat(1055999918),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(63));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055999918), Float.intBitsToFloat(1040271278),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(64));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055999918), Float.intBitsToFloat(1044130038),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(65));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055999918), Float.intBitsToFloat(1047988796),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(66));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055999918), Float.intBitsToFloat(1050211778),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(67));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062270403), Float.intBitsToFloat(1055999920),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(68));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061305713), Float.intBitsToFloat(1055999920),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(69));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060341023), Float.intBitsToFloat(1055999918),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(70));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059376333), Float.intBitsToFloat(1055999918),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(71));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053105847), Float.intBitsToFloat(1064199783),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(72));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055035227), Float.intBitsToFloat(1064199783),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(73));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964606), Float.intBitsToFloat(1064199783),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(74));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057929297), Float.intBitsToFloat(1064199783),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(75));
    assertEquals(new Rectangle(Float.intBitsToFloat(1010323946), Float.intBitsToFloat(1053105847),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(76));
    assertEquals(new Rectangle(Float.intBitsToFloat(1010323942), Float.intBitsToFloat(1055035227),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(77));
    assertEquals(new Rectangle(Float.intBitsToFloat(1010323934), Float.intBitsToFloat(1056964606),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(78));
    assertEquals(new Rectangle(Float.intBitsToFloat(1010323930), Float.intBitsToFloat(1057929297),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(79));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057929298), Float.intBitsToFloat(1010323938),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(80));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964608), Float.intBitsToFloat(1010323938),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(81));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055035228), Float.intBitsToFloat(1010323938),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(82));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053105848), Float.intBitsToFloat(1010323938),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(83));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064199783), Float.intBitsToFloat(1057929299),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(84));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064199783), Float.intBitsToFloat(1056964609),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(85));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064199783), Float.intBitsToFloat(1055035230),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(86));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064199783), Float.intBitsToFloat(1053105850),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        instance.getBoundsForBoardIndex(87));

    // test with 6 players
    board = new Board(6);
    instance = new GridBoardLayout(board);
    assertEquals(new Rectangle(Float.intBitsToFloat(1052902754), Float.intBitsToFloat(1063463572),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(0));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052902754), Float.intBitsToFloat(1062651201),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(1));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052902754), Float.intBitsToFloat(1061838831),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(2));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052902754), Float.intBitsToFloat(1061026461),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(3));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052902754), Float.intBitsToFloat(1060214090),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(4));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052877499), Float.intBitsToFloat(1059394429),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(5));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051445178), Float.intBitsToFloat(1059793324),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(6));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050038110), Float.intBitsToFloat(1060199509),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(7));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048631044), Float.intBitsToFloat(1060605694),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(8));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045871953), Float.intBitsToFloat(1061011880),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(9));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043057819), Float.intBitsToFloat(1061418065),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(10));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041433078), Float.intBitsToFloat(1060714531),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(11));
    assertEquals(new Rectangle(Float.intBitsToFloat(1039429282), Float.intBitsToFloat(1060010998),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(12));
    assertEquals(new Rectangle(Float.intBitsToFloat(1036179800), Float.intBitsToFloat(1059307465),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(13));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032930317), Float.intBitsToFloat(1058603931),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(14));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038558586), Float.intBitsToFloat(1058197746),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(15));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042187123), Float.intBitsToFloat(1057791560),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(16));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045001257), Float.intBitsToFloat(1057385375),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(17));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047815391), Float.intBitsToFloat(1056979190),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(18));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049602762), Float.intBitsToFloat(1056152239),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(19));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047815391), Float.intBitsToFloat(1055310706),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(20));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045001257), Float.intBitsToFloat(1054498334),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(21));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042187123), Float.intBitsToFloat(1053685964),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(22));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038558586), Float.intBitsToFloat(1052873594),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(23));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032930318), Float.intBitsToFloat(1052061224),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(24));
    assertEquals(new Rectangle(Float.intBitsToFloat(1036179800), Float.intBitsToFloat(1050654156),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(25));
    assertEquals(new Rectangle(Float.intBitsToFloat(1039429282), Float.intBitsToFloat(1049247090),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(26));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041433078), Float.intBitsToFloat(1047104045),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(27));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043057819), Float.intBitsToFloat(1044289911),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(28));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045871953), Float.intBitsToFloat(1045914652),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(29));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048631044), Float.intBitsToFloat(1047539393),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(30));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050038110), Float.intBitsToFloat(1048870066),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(31));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051445178), Float.intBitsToFloat(1049682438),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(32));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052877500), Float.intBitsToFloat(1050480226),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(33));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052902756), Float.intBitsToFloat(1048840904),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(34));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052902756), Float.intBitsToFloat(1045856325),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(35));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052902756), Float.intBitsToFloat(1042606843),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(36));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052902756), Float.intBitsToFloat(1038527330),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(37));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052902756), Float.intBitsToFloat(1032028366),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(38));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054527496), Float.intBitsToFloat(1032028366),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(39));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056152238), Float.intBitsToFloat(1032028366),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(40));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057370793), Float.intBitsToFloat(1032028366),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(41));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058183164), Float.intBitsToFloat(1032028366),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(42));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058183164), Float.intBitsToFloat(1038527330),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(43));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058183164), Float.intBitsToFloat(1042606843),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(44));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058183164), Float.intBitsToFloat(1045856325),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(45));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058183164), Float.intBitsToFloat(1048840904),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(46));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058195792), Float.intBitsToFloat(1050480225),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(47));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058911952), Float.intBitsToFloat(1049682434),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(48));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059615486), Float.intBitsToFloat(1048870064),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(49));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060319019), Float.intBitsToFloat(1047539387),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(50));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061022553), Float.intBitsToFloat(1045914645),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(51));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061726086), Float.intBitsToFloat(1044289903),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(52));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062132272), Float.intBitsToFloat(1047104037),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(53));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062538457), Float.intBitsToFloat(1049247086),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(54));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062944642), Float.intBitsToFloat(1050654152),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(55));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063350828), Float.intBitsToFloat(1052061220),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(56));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062647295), Float.intBitsToFloat(1052873590),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(57));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061943761), Float.intBitsToFloat(1053685962),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(58));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061240228), Float.intBitsToFloat(1054498332),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(59));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060536694), Float.intBitsToFloat(1055310702),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(60));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059833161), Float.intBitsToFloat(1056152238),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(61));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060536694), Float.intBitsToFloat(1056979190),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(62));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061240227), Float.intBitsToFloat(1057385375),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(63));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061943761), Float.intBitsToFloat(1057791560),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(64));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062647295), Float.intBitsToFloat(1058197746),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(65));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063350828), Float.intBitsToFloat(1058603931),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(66));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062944642), Float.intBitsToFloat(1059307465),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(67));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062538457), Float.intBitsToFloat(1060010998),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(68));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062132272), Float.intBitsToFloat(1060714531),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(69));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061726086), Float.intBitsToFloat(1061418065),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(70));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061022553), Float.intBitsToFloat(1061011880),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(71));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060319019), Float.intBitsToFloat(1060605694),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(72));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059615485), Float.intBitsToFloat(1060199509),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(73));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058911952), Float.intBitsToFloat(1059793324),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(74));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058195791), Float.intBitsToFloat(1059394429),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(75));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058183163), Float.intBitsToFloat(1060214090),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(76));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058183163), Float.intBitsToFloat(1061026461),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(77));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058183163), Float.intBitsToFloat(1061838831),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(78));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058183163), Float.intBitsToFloat(1062651201),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(79));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058183163), Float.intBitsToFloat(1063463572),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(80));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057370793), Float.intBitsToFloat(1063463572),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(81));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056152236), Float.intBitsToFloat(1063463572),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(82));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054527496), Float.intBitsToFloat(1063463572),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(83));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056152236), Float.intBitsToFloat(1062651201),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(84));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056152236), Float.intBitsToFloat(1061838831),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(85));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056152236), Float.intBitsToFloat(1061026461),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(86));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056152236), Float.intBitsToFloat(1060214090),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(87));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042622471), Float.intBitsToFloat(1059604813),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(88));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045436605), Float.intBitsToFloat(1059198627),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(89));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048250739), Float.intBitsToFloat(1058792442),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(90));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049820436), Float.intBitsToFloat(1058386257),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(91));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042622471), Float.intBitsToFloat(1050059460),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(92));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045436605), Float.intBitsToFloat(1050871830),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(93));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048250739), Float.intBitsToFloat(1051684200),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(94));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049820436), Float.intBitsToFloat(1052496572),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(95));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056152238), Float.intBitsToFloat(1038527330),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(96));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056152238), Float.intBitsToFloat(1042606843),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(97));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056152238), Float.intBitsToFloat(1045856325),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(98));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056152238), Float.intBitsToFloat(1048840904),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(99));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061834924), Float.intBitsToFloat(1050059456),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(100));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061131390), Float.intBitsToFloat(1050871828),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(101));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060427857), Float.intBitsToFloat(1051684198),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(102));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059724323), Float.intBitsToFloat(1052496568),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(103));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061834923), Float.intBitsToFloat(1059604813),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(104));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061131390), Float.intBitsToFloat(1059198627),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(105));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060427857), Float.intBitsToFloat(1058792442),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(106));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059724323), Float.intBitsToFloat(1058386257),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(107));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053715126), Float.intBitsToFloat(1064275943),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(108));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055339866), Float.intBitsToFloat(1064275943),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(109));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964608), Float.intBitsToFloat(1064275943),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(110));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057776978), Float.intBitsToFloat(1064275943),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(111));
    assertEquals(new Rectangle(Float.intBitsToFloat(1026054796), Float.intBitsToFloat(1059361883),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(112));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032176273), Float.intBitsToFloat(1060065416),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(113));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035425755), Float.intBitsToFloat(1060768950),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(114));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038675238), Float.intBitsToFloat(1061472483),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(115));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038675236), Float.intBitsToFloat(1044072236),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(116));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035425755), Float.intBitsToFloat(1046886370),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(117));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032176273), Float.intBitsToFloat(1049138252),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(118));
    assertEquals(new Rectangle(Float.intBitsToFloat(1026054800), Float.intBitsToFloat(1050545320),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(119));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057776979), Float.intBitsToFloat(1015109864),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(120));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964608), Float.intBitsToFloat(1015109864),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(121));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055339868), Float.intBitsToFloat(1015109864),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(122));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053715126), Float.intBitsToFloat(1015109864),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(123));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063851269), Float.intBitsToFloat(1050545316),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(124));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063445084), Float.intBitsToFloat(1049138248),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(125));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063038898), Float.intBitsToFloat(1046886364),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(126));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062632713), Float.intBitsToFloat(1044072231),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(127));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062632713), Float.intBitsToFloat(1061472483),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(128));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063038898), Float.intBitsToFloat(1060768950),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(129));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063445084), Float.intBitsToFloat(1060065416),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(130));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063851269), Float.intBitsToFloat(1059361883),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        instance.getBoundsForBoardIndex(131));

    // test with 8 players
    board = new Board(8);
    instance = new GridBoardLayout(board);
    assertEquals(new Rectangle(Float.intBitsToFloat(1053456643), Float.intBitsToFloat(1063629739),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(0));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053456643), Float.intBitsToFloat(1062928146),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(1));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053456643), Float.intBitsToFloat(1062226554),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(2));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053456643), Float.intBitsToFloat(1061524961),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(3));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053456643), Float.intBitsToFloat(1060823368),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(4));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053371526), Float.intBitsToFloat(1060104148),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(5));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052294207), Float.intBitsToFloat(1060582620),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(6));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051302005), Float.intBitsToFloat(1061078721),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(7));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050309804), Float.intBitsToFloat(1061574822),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(8));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049317602), Float.intBitsToFloat(1062070923),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(9));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048074801), Float.intBitsToFloat(1062567024),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(10));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046090397), Float.intBitsToFloat(1062070923),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(11));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044105993), Float.intBitsToFloat(1061574822),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(12));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042121589), Float.intBitsToFloat(1061078721),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(13));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040086977), Float.intBitsToFloat(1060582620),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(14));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042121589), Float.intBitsToFloat(1060086519),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(15));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044105993), Float.intBitsToFloat(1059590418),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(16));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046090396), Float.intBitsToFloat(1059094317),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(17));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048074799), Float.intBitsToFloat(1058598216),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(18));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049282344), Float.intBitsToFloat(1058059556),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(19));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047111805), Float.intBitsToFloat(1058016997),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(20));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044305435), Float.intBitsToFloat(1058016997),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(21));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041499064), Float.intBitsToFloat(1058016997),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(22));
    assertEquals(new Rectangle(Float.intBitsToFloat(1037197993), Float.intBitsToFloat(1058016997),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(23));
    assertEquals(new Rectangle(Float.intBitsToFloat(1031371720), Float.intBitsToFloat(1058016997),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(24));
    assertEquals(new Rectangle(Float.intBitsToFloat(1031371722), Float.intBitsToFloat(1057315404),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(25));
    assertEquals(new Rectangle(Float.intBitsToFloat(1031371722), Float.intBitsToFloat(1056263014),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(26));
    assertEquals(new Rectangle(Float.intBitsToFloat(1031371722), Float.intBitsToFloat(1054859829),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(27));
    assertEquals(new Rectangle(Float.intBitsToFloat(1031371724), Float.intBitsToFloat(1053456643),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(28));
    assertEquals(new Rectangle(Float.intBitsToFloat(1037197995), Float.intBitsToFloat(1053456643),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(29));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041499065), Float.intBitsToFloat(1053456643),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(30));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044305435), Float.intBitsToFloat(1053456643),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(31));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047111807), Float.intBitsToFloat(1053456643),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(32));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049282344), Float.intBitsToFloat(1053371527),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(33));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048074799), Float.intBitsToFloat(1052294208),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(34));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046090395), Float.intBitsToFloat(1051302006),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(35));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044105992), Float.intBitsToFloat(1050309805),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(36));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042121588), Float.intBitsToFloat(1049317603),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(37));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040086975), Float.intBitsToFloat(1048074803),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(38));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042121587), Float.intBitsToFloat(1046090399),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(39));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044105991), Float.intBitsToFloat(1044105995),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(40));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046090395), Float.intBitsToFloat(1042121591),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(41));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048074799), Float.intBitsToFloat(1040086981),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(42));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049317601), Float.intBitsToFloat(1042121591),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(43));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050309803), Float.intBitsToFloat(1044105994),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(44));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051302005), Float.intBitsToFloat(1046090397),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(45));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052294207), Float.intBitsToFloat(1048074801),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(46));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053371526), Float.intBitsToFloat(1049282345),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(47));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053456644), Float.intBitsToFloat(1047111806),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(48));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053456644), Float.intBitsToFloat(1044305435),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(49));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053456644), Float.intBitsToFloat(1041499065),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(50));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053456644), Float.intBitsToFloat(1037197995),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(51));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053456644), Float.intBitsToFloat(1031371722),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(52));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054859830), Float.intBitsToFloat(1031371722),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(53));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056263015), Float.intBitsToFloat(1031371722),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(54));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057315405), Float.intBitsToFloat(1031371722),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(55));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058016997), Float.intBitsToFloat(1031371722),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(56));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058016997), Float.intBitsToFloat(1037197995),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(57));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058016997), Float.intBitsToFloat(1041499065),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(58));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058016997), Float.intBitsToFloat(1044305435),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(59));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058016997), Float.intBitsToFloat(1047111806),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(60));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058059556), Float.intBitsToFloat(1049282344),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(61));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058598215), Float.intBitsToFloat(1048074799),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(62));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059094316), Float.intBitsToFloat(1046090394),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(63));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059590416), Float.intBitsToFloat(1044105990),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(64));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060086517), Float.intBitsToFloat(1042121586),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(65));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060582618), Float.intBitsToFloat(1040086971),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(66));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061078719), Float.intBitsToFloat(1042121586),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(67));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061574820), Float.intBitsToFloat(1044105989),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(68));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062070921), Float.intBitsToFloat(1046090392),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(69));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062567022), Float.intBitsToFloat(1048074795),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(70));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062070921), Float.intBitsToFloat(1049317599),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(71));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061574820), Float.intBitsToFloat(1050309801),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(72));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061078720), Float.intBitsToFloat(1051302003),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(73));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060582619), Float.intBitsToFloat(1052294205),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(74));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060104147), Float.intBitsToFloat(1053371526),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(75));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060823368), Float.intBitsToFloat(1053456645),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(76));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061524961), Float.intBitsToFloat(1053456645),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(77));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062226554), Float.intBitsToFloat(1053456646),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(78));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062928146), Float.intBitsToFloat(1053456646),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(79));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063629739), Float.intBitsToFloat(1053456646),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(80));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063629739), Float.intBitsToFloat(1054859832),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(81));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063629739), Float.intBitsToFloat(1056263017),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(82));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063629739), Float.intBitsToFloat(1057315406),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(83));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063629739), Float.intBitsToFloat(1058016998),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(84));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062928146), Float.intBitsToFloat(1058016998),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(85));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062226554), Float.intBitsToFloat(1058016998),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(86));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061524961), Float.intBitsToFloat(1058016998),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(87));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060823368), Float.intBitsToFloat(1058016998),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(88));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060104148), Float.intBitsToFloat(1058059556),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(89));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060582620), Float.intBitsToFloat(1058598216),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(90));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061078721), Float.intBitsToFloat(1059094317),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(91));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061574822), Float.intBitsToFloat(1059590418),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(92));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062070923), Float.intBitsToFloat(1060086519),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(93));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062567024), Float.intBitsToFloat(1060582620),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(94));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062070923), Float.intBitsToFloat(1061078721),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(95));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061574822), Float.intBitsToFloat(1061574822),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(96));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061078721), Float.intBitsToFloat(1062070923),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(97));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060582620), Float.intBitsToFloat(1062567024),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(98));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060086519), Float.intBitsToFloat(1062070923),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(99));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059590418), Float.intBitsToFloat(1061574822),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(100));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059094317), Float.intBitsToFloat(1061078721),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(101));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058598216), Float.intBitsToFloat(1060582620),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(102));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058059556), Float.intBitsToFloat(1060104148),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(103));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058016997), Float.intBitsToFloat(1060823368),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(104));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058016997), Float.intBitsToFloat(1061524961),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(105));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058016997), Float.intBitsToFloat(1062226554),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(106));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058016997), Float.intBitsToFloat(1062928146),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(107));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058016997), Float.intBitsToFloat(1063629739),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(108));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057315404), Float.intBitsToFloat(1063629739),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(109));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056263014), Float.intBitsToFloat(1063629739),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(110));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054859829), Float.intBitsToFloat(1063629739),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(111));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056263014), Float.intBitsToFloat(1062928146),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(112));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056263014), Float.intBitsToFloat(1062226554),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(113));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056263014), Float.intBitsToFloat(1061524961),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(114));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056263014), Float.intBitsToFloat(1060823368),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(115));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046090397), Float.intBitsToFloat(1061078721),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(116));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048074801), Float.intBitsToFloat(1060582620),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(117));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049317601), Float.intBitsToFloat(1060086519),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(118));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050309803), Float.intBitsToFloat(1059590418),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(119));
    assertEquals(new Rectangle(Float.intBitsToFloat(1037197995), Float.intBitsToFloat(1056263014),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(120));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041499065), Float.intBitsToFloat(1056263014),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(121));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044305435), Float.intBitsToFloat(1056263014),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(122));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047111806), Float.intBitsToFloat(1056263014),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(123));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046090395), Float.intBitsToFloat(1046090399),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(124));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048074799), Float.intBitsToFloat(1048074803),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(125));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049317601), Float.intBitsToFloat(1049317602),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(126));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050309803), Float.intBitsToFloat(1050309804),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(127));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056263015), Float.intBitsToFloat(1037197995),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(128));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056263015), Float.intBitsToFloat(1041499065),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(129));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056263015), Float.intBitsToFloat(1044305435),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(130));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056263015), Float.intBitsToFloat(1047111806),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(131));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061078719), Float.intBitsToFloat(1046090393),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(132));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060582618), Float.intBitsToFloat(1048074797),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(133));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060086518), Float.intBitsToFloat(1049317600),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(134));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059590417), Float.intBitsToFloat(1050309802),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(135));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062928146), Float.intBitsToFloat(1056263017),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(136));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062226554), Float.intBitsToFloat(1056263017),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(137));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061524961), Float.intBitsToFloat(1056263017),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(138));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060823368), Float.intBitsToFloat(1056263017),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(139));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061078721), Float.intBitsToFloat(1061078721),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(140));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060582620), Float.intBitsToFloat(1060582620),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(141));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060086519), Float.intBitsToFloat(1060086519),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(142));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059590418), Float.intBitsToFloat(1059590418),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(143));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054158236), Float.intBitsToFloat(1064331332),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(144));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055561421), Float.intBitsToFloat(1064331332),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(145));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964607), Float.intBitsToFloat(1064331332),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(146));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057666200), Float.intBitsToFloat(1064331332),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(147));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038102573), Float.intBitsToFloat(1061326771),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(148));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041129387), Float.intBitsToFloat(1061822872),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(149));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043113791), Float.intBitsToFloat(1062318972),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(150));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045098195), Float.intBitsToFloat(1062815073),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(151));
    assertEquals(new Rectangle(Float.intBitsToFloat(1016882311), Float.intBitsToFloat(1054158236),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(152));
    assertEquals(new Rectangle(Float.intBitsToFloat(1016882309), Float.intBitsToFloat(1055561421),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(153));
    assertEquals(new Rectangle(Float.intBitsToFloat(1016882309), Float.intBitsToFloat(1056964607),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(154));
    assertEquals(new Rectangle(Float.intBitsToFloat(1016882307), Float.intBitsToFloat(1057666200),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(155));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045098194), Float.intBitsToFloat(1038102577),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(156));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043113791), Float.intBitsToFloat(1041129389),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(157));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041129387), Float.intBitsToFloat(1043113793),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(158));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038102575), Float.intBitsToFloat(1045098197),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(159));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057666201), Float.intBitsToFloat(1016882309),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(160));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964607), Float.intBitsToFloat(1016882309),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(161));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055561422), Float.intBitsToFloat(1016882309),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(162));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054158237), Float.intBitsToFloat(1016882309),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(163));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062815074), Float.intBitsToFloat(1045098192),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(164));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062318973), Float.intBitsToFloat(1043113789),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(165));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061822871), Float.intBitsToFloat(1041129385),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(166));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061326770), Float.intBitsToFloat(1038102571),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(167));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064331332), Float.intBitsToFloat(1057666202),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(168));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064331332), Float.intBitsToFloat(1056964609),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(169));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064331332), Float.intBitsToFloat(1055561424),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(170));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064331332), Float.intBitsToFloat(1054158239),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(171));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061326771), Float.intBitsToFloat(1062815073),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(172));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061822872), Float.intBitsToFloat(1062318972),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(173));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062318972), Float.intBitsToFloat(1061822872),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(174));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062815073), Float.intBitsToFloat(1061326771),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        instance.getBoundsForBoardIndex(175));

    // test with 10 players
    board = new Board(10);
    instance = new GridBoardLayout(board);
    assertEquals(new Rectangle(Float.intBitsToFloat(1053877599), Float.intBitsToFloat(1063756025),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(0));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053877599), Float.intBitsToFloat(1063138623),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(1));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053877599), Float.intBitsToFloat(1062521222),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(2));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053877599), Float.intBitsToFloat(1061903820),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(3));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053877599), Float.intBitsToFloat(1061286419),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(4));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053752533), Float.intBitsToFloat(1060648698),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(5));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052901668), Float.intBitsToFloat(1061127869),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(6));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052175869), Float.intBitsToFloat(1061627357),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(7));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051450070), Float.intBitsToFloat(1062126845),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(8));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050724271), Float.intBitsToFloat(1062626334),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(9));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049998472), Float.intBitsToFloat(1063125822),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(10));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048999495), Float.intBitsToFloat(1062762923),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(11));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047425037), Float.intBitsToFloat(1062400023),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(12));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045427083), Float.intBitsToFloat(1062037123),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(13));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043429130), Float.intBitsToFloat(1061674224),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(14));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044880728), Float.intBitsToFloat(1061174736),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(15));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046332326), Float.intBitsToFloat(1060675247),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(16));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047783925), Float.intBitsToFloat(1060175759),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(17));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048905760), Float.intBitsToFloat(1059676271),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(18));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049554264), Float.intBitsToFloat(1059123588),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(19));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048029201), Float.intBitsToFloat(1059261183),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(20));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045680467), Float.intBitsToFloat(1059451970),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(21));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043331732), Float.intBitsToFloat(1059642758),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(22));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040982997), Float.intBitsToFloat(1059833545),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(23));
    assertEquals(new Rectangle(Float.intBitsToFloat(1037081132), Float.intBitsToFloat(1060024333),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(24));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035554831), Float.intBitsToFloat(1059437149),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(25));
    assertEquals(new Rectangle(Float.intBitsToFloat(1034028530), Float.intBitsToFloat(1058849965),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(26));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032502229), Float.intBitsToFloat(1058262781),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(27));
    assertEquals(new Rectangle(Float.intBitsToFloat(1030153072), Float.intBitsToFloat(1057675597),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(28));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035673398), Float.intBitsToFloat(1057484809),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(29));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040279130), Float.intBitsToFloat(1057294022),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(30));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042627865), Float.intBitsToFloat(1057103234),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(31));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044976600), Float.intBitsToFloat(1056860286),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(32));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047325335), Float.intBitsToFloat(1056347206),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(33));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044976599), Float.intBitsToFloat(1055834128),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(34));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042627865), Float.intBitsToFloat(1055452552),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(35));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040279129), Float.intBitsToFloat(1055070977),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(36));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035673396), Float.intBitsToFloat(1054689402),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(37));
    assertEquals(new Rectangle(Float.intBitsToFloat(1030153066), Float.intBitsToFloat(1054307827),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(38));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032502226), Float.intBitsToFloat(1053133460),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(39));
    assertEquals(new Rectangle(Float.intBitsToFloat(1034028526), Float.intBitsToFloat(1051959092),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(40));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035554826), Float.intBitsToFloat(1050784724),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(41));
    assertEquals(new Rectangle(Float.intBitsToFloat(1037081127), Float.intBitsToFloat(1049610357),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(42));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040982995), Float.intBitsToFloat(1049991932),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(43));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043331730), Float.intBitsToFloat(1050373507),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(44));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045680465), Float.intBitsToFloat(1050755082),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(45));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048029201), Float.intBitsToFloat(1051136658),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(46));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049554264), Float.intBitsToFloat(1051411844),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(47));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048905761), Float.intBitsToFloat(1050306477),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(48));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047783925), Float.intBitsToFloat(1049307500),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(49));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046332328), Float.intBitsToFloat(1048041047),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(50));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044880731), Float.intBitsToFloat(1046043094),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(51));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043429133), Float.intBitsToFloat(1044045140),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(52));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045427087), Float.intBitsToFloat(1042593543),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(53));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047425041), Float.intBitsToFloat(1041141945),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(54));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048999497), Float.intBitsToFloat(1039193302),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(55));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049998474), Float.intBitsToFloat(1036290108),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(56));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050724273), Float.intBitsToFloat(1040236704),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(57));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051450072), Float.intBitsToFloat(1042234657),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(58));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052175870), Float.intBitsToFloat(1044232611),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(59));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052901669), Float.intBitsToFloat(1046230565),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(60));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053752534), Float.intBitsToFloat(1048147245),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(61));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053877600), Float.intBitsToFloat(1045596366),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(62));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053877600), Float.intBitsToFloat(1043126760),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(63));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053877600), Float.intBitsToFloat(1040657153),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(64));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053877600), Float.intBitsToFloat(1036187702),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(65));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053877600), Float.intBitsToFloat(1030698196),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(66));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055112403), Float.intBitsToFloat(1030698196),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(67));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056347206), Float.intBitsToFloat(1030698196),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(68));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057273309), Float.intBitsToFloat(1030698196),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(69));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057890710), Float.intBitsToFloat(1030698196),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(70));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057890710), Float.intBitsToFloat(1036187702),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(71));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057890710), Float.intBitsToFloat(1040657153),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(72));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057890710), Float.intBitsToFloat(1043126760),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(73));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057890710), Float.intBitsToFloat(1045596366),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(74));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057953243), Float.intBitsToFloat(1048147245),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(75));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058378675), Float.intBitsToFloat(1046230565),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(76));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058741575), Float.intBitsToFloat(1044232611),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(77));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059104474), Float.intBitsToFloat(1042234657),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(78));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059467374), Float.intBitsToFloat(1040236704),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(79));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059830273), Float.intBitsToFloat(1036290108),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(80));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060329762), Float.intBitsToFloat(1039193302),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(81));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060829250), Float.intBitsToFloat(1041141945),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(82));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061328738), Float.intBitsToFloat(1042593543),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(83));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061828227), Float.intBitsToFloat(1044045140),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(84));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061465328), Float.intBitsToFloat(1046043094),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(85));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061102428), Float.intBitsToFloat(1048041047),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(86));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060739529), Float.intBitsToFloat(1049307500),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(87));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060376629), Float.intBitsToFloat(1050306477),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(88));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060052378), Float.intBitsToFloat(1051411843),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(89));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060678211), Float.intBitsToFloat(1051136657),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(90));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061265395), Float.intBitsToFloat(1050755082),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(91));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061852578), Float.intBitsToFloat(1050373507),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(92));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062439762), Float.intBitsToFloat(1049991932),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(93));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063026946), Float.intBitsToFloat(1049610357),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(94));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063217733), Float.intBitsToFloat(1050784724),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(95));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063408521), Float.intBitsToFloat(1051959092),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(96));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063599309), Float.intBitsToFloat(1053133460),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(97));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063790096), Float.intBitsToFloat(1054307827),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(98));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063202912), Float.intBitsToFloat(1054689402),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(99));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062615728), Float.intBitsToFloat(1055070977),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(100));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062028545), Float.intBitsToFloat(1055452552),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(101));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061441361), Float.intBitsToFloat(1055834127),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(102));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060854177), Float.intBitsToFloat(1056347205),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(103));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061441361), Float.intBitsToFloat(1056860282),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(104));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062028545), Float.intBitsToFloat(1057103233),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(105));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062615728), Float.intBitsToFloat(1057294020),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(106));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063202912), Float.intBitsToFloat(1057484808),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(107));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063790096), Float.intBitsToFloat(1057675595),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(108));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063599308), Float.intBitsToFloat(1058262779),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(109));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063408521), Float.intBitsToFloat(1058849963),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(110));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063217734), Float.intBitsToFloat(1059437147),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(111));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063026946), Float.intBitsToFloat(1060024331),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(112));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062439762), Float.intBitsToFloat(1059833544),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(113));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061852578), Float.intBitsToFloat(1059642756),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(114));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061265395), Float.intBitsToFloat(1059451969),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(115));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060678211), Float.intBitsToFloat(1059261181),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(116));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060052379), Float.intBitsToFloat(1059123588),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(117));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060376630), Float.intBitsToFloat(1059676270),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(118));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060739529), Float.intBitsToFloat(1060175759),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(119));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061102429), Float.intBitsToFloat(1060675247),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(120));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061465329), Float.intBitsToFloat(1061174736),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(121));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061828228), Float.intBitsToFloat(1061674224),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(122));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061328739), Float.intBitsToFloat(1062037123),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(123));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060829251), Float.intBitsToFloat(1062400023),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(124));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060329763), Float.intBitsToFloat(1062762923),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(125));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059830274), Float.intBitsToFloat(1063125822),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(126));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059467375), Float.intBitsToFloat(1062626334),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(127));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059104475), Float.intBitsToFloat(1062126845),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(128));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058741575), Float.intBitsToFloat(1061627357),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(129));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058378676), Float.intBitsToFloat(1061127868),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(130));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057953244), Float.intBitsToFloat(1060648698),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(131));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057890710), Float.intBitsToFloat(1061286419),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(132));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057890710), Float.intBitsToFloat(1061903820),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(133));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057890710), Float.intBitsToFloat(1062521222),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(134));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057890710), Float.intBitsToFloat(1063138623),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(135));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057890710), Float.intBitsToFloat(1063756025),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(136));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057273308), Float.intBitsToFloat(1063756025),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(137));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056347205), Float.intBitsToFloat(1063756025),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(138));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055112402), Float.intBitsToFloat(1063756025),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(139));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056347205), Float.intBitsToFloat(1063138623),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(140));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056347205), Float.intBitsToFloat(1062521222),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(141));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056347205), Float.intBitsToFloat(1061903820),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(142));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056347205), Float.intBitsToFloat(1061286419),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(143));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048726317), Float.intBitsToFloat(1061900535),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(144));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049452116), Float.intBitsToFloat(1061401046),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(145));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050177915), Float.intBitsToFloat(1060901558),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(146));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050903714), Float.intBitsToFloat(1060402069),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(147));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038726000), Float.intBitsToFloat(1058659177),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(148));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041805431), Float.intBitsToFloat(1058468390),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(149));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044154167), Float.intBitsToFloat(1058277602),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(150));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046502901), Float.intBitsToFloat(1058086815),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(151));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038725996), Float.intBitsToFloat(1052340667),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(152));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041805429), Float.intBitsToFloat(1052722242),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(153));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044154165), Float.intBitsToFloat(1053103817),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(154));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046502900), Float.intBitsToFloat(1053485392),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(155));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048726319), Float.intBitsToFloat(1043139899),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(156));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049452118), Float.intBitsToFloat(1045137853),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(157));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050177916), Float.intBitsToFloat(1047135807),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(158));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050903715), Float.intBitsToFloat(1048854880),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(159));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056347206), Float.intBitsToFloat(1036187702),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(160));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056347206), Float.intBitsToFloat(1040657153),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(161));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056347206), Float.intBitsToFloat(1043126760),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(162));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056347206), Float.intBitsToFloat(1045596366),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(163));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060466351), Float.intBitsToFloat(1043139899),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(164));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060103451), Float.intBitsToFloat(1045137853),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(165));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059740552), Float.intBitsToFloat(1047135807),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(166));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059377652), Float.intBitsToFloat(1048854880),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(167));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062821337), Float.intBitsToFloat(1052340667),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(168));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062234153), Float.intBitsToFloat(1052722242),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(169));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061646969), Float.intBitsToFloat(1053103817),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(170));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061059786), Float.intBitsToFloat(1053485392),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(171));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062821337), Float.intBitsToFloat(1058659176),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(172));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062234153), Float.intBitsToFloat(1058468388),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(173));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061646969), Float.intBitsToFloat(1058277601),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(174));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061059786), Float.intBitsToFloat(1058086813),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(175));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060466351), Float.intBitsToFloat(1061900535),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(176));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060103452), Float.intBitsToFloat(1061401046),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(177));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059740553), Float.intBitsToFloat(1060901558),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(178));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059377653), Float.intBitsToFloat(1060402069),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(179));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054495000), Float.intBitsToFloat(1064373427),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(180));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055729803), Float.intBitsToFloat(1064373427),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(181));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964606), Float.intBitsToFloat(1064373427),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(182));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057582009), Float.intBitsToFloat(1064373427),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(183));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042976509), Float.intBitsToFloat(1062355162),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(184));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044974462), Float.intBitsToFloat(1062718061),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(185));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046972416), Float.intBitsToFloat(1063080961),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(186));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048773184), Float.intBitsToFloat(1063443860),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(187));
    assertEquals(new Rectangle(Float.intBitsToFloat(1021158683), Float.intBitsToFloat(1058159976),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(188));
    assertEquals(new Rectangle(Float.intBitsToFloat(1025337030), Float.intBitsToFloat(1058747160),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(189));
    assertEquals(new Rectangle(Float.intBitsToFloat(1028389632), Float.intBitsToFloat(1059334344),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(190));
    assertEquals(new Rectangle(Float.intBitsToFloat(1031442234), Float.intBitsToFloat(1059921528),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(191));
    assertEquals(new Rectangle(Float.intBitsToFloat(1031442226), Float.intBitsToFloat(1049815966),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(192));
    assertEquals(new Rectangle(Float.intBitsToFloat(1028389624), Float.intBitsToFloat(1050990333),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(193));
    assertEquals(new Rectangle(Float.intBitsToFloat(1025337024), Float.intBitsToFloat(1052164701),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(194));
    assertEquals(new Rectangle(Float.intBitsToFloat(1021158667), Float.intBitsToFloat(1053339068),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(195));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048773186), Float.intBitsToFloat(1033745797),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(196));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046972420), Float.intBitsToFloat(1036648992),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(197));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044974466), Float.intBitsToFloat(1039552188),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(198));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042976512), Float.intBitsToFloat(1041321387),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(199));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057582009), Float.intBitsToFloat(1018229367),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(200));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964608), Float.intBitsToFloat(1018229367),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(201));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055729804), Float.intBitsToFloat(1018229367),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(202));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054495001), Float.intBitsToFloat(1018229367),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(203));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061941382), Float.intBitsToFloat(1041321387),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(204));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061441893), Float.intBitsToFloat(1039552188),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(205));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060942405), Float.intBitsToFloat(1036648992),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(206));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060442916), Float.intBitsToFloat(1033745797),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(207));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064281886), Float.intBitsToFloat(1053339070),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(208));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064091099), Float.intBitsToFloat(1052164702),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(209));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063900311), Float.intBitsToFloat(1050990334),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(210));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063709524), Float.intBitsToFloat(1049815966),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(211));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063709524), Float.intBitsToFloat(1059921526),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(212));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063900311), Float.intBitsToFloat(1059334342),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(213));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064091099), Float.intBitsToFloat(1058747158),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(214));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064281886), Float.intBitsToFloat(1058159974),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(215));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060442918), Float.intBitsToFloat(1063443861),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(216));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060942407), Float.intBitsToFloat(1063080962),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(217));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061441895), Float.intBitsToFloat(1062718062),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(218));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061941384), Float.intBitsToFloat(1062355163),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        instance.getBoundsForBoardIndex(219));

    // test with 12 players
    board = new Board(12);
    instance = new GridBoardLayout(board);
    assertEquals(new Rectangle(Float.intBitsToFloat(1054208351), Float.intBitsToFloat(1063855250),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(0));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054208351), Float.intBitsToFloat(1063303999),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(1));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054208351), Float.intBitsToFloat(1062752747),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(2));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054208351), Float.intBitsToFloat(1062201496),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(3));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054208351), Float.intBitsToFloat(1061650244),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(4));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054060644), Float.intBitsToFloat(1061079204),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(5));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053361685), Float.intBitsToFloat(1061536812),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(6));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052810433), Float.intBitsToFloat(1062014210),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(7));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052259182), Float.intBitsToFloat(1062491608),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(8));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051707930), Float.intBitsToFloat(1062969005),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(9));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051156679), Float.intBitsToFloat(1063446403),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(10));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050201883), Float.intBitsToFloat(1063170778),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(11));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049247088), Float.intBitsToFloat(1062895152),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(12));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048008585), Float.intBitsToFloat(1062619526),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(13));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046098993), Float.intBitsToFloat(1062343901),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(14));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047201496), Float.intBitsToFloat(1061866503),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(15));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048303999), Float.intBitsToFloat(1061389106),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(16));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048991251), Float.intBitsToFloat(1060911708),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(17));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049542503), Float.intBitsToFloat(1060434310),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(18));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049985626), Float.intBitsToFloat(1059902847),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(19));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048922701), Float.intBitsToFloat(1060124408),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(20));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047359811), Float.intBitsToFloat(1060400034),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(21));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045450221), Float.intBitsToFloat(1060675660),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(22));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043540630), Float.intBitsToFloat(1060951285),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(23));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041631039), Float.intBitsToFloat(1061226911),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(24));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040528536), Float.intBitsToFloat(1060749514),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(25));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038664674), Float.intBitsToFloat(1060272116),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(26));
    assertEquals(new Rectangle(Float.intBitsToFloat(1036459668), Float.intBitsToFloat(1059794718),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(27));
    assertEquals(new Rectangle(Float.intBitsToFloat(1034254662), Float.intBitsToFloat(1059317321),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(28));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038073844), Float.intBitsToFloat(1059041695),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(29));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041040209), Float.intBitsToFloat(1058766070),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(30));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042949799), Float.intBitsToFloat(1058490444),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(31));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044859390), Float.intBitsToFloat(1058214818),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(32));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046689825), Float.intBitsToFloat(1057865338),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(33));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044405663), Float.intBitsToFloat(1057791484),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(34));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042200657), Float.intBitsToFloat(1057791484),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(35));
    assertEquals(new Rectangle(Float.intBitsToFloat(1039803910), Float.intBitsToFloat(1057791484),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(36));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035393900), Float.intBitsToFloat(1057791484),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(37));
    assertEquals(new Rectangle(Float.intBitsToFloat(1030168995), Float.intBitsToFloat(1057791484),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(38));
    assertEquals(new Rectangle(Float.intBitsToFloat(1030168997), Float.intBitsToFloat(1057240233),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(39));
    assertEquals(new Rectangle(Float.intBitsToFloat(1030168997), Float.intBitsToFloat(1056413356),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(40));
    assertEquals(new Rectangle(Float.intBitsToFloat(1030168997), Float.intBitsToFloat(1055310853),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(41));
    assertEquals(new Rectangle(Float.intBitsToFloat(1030168999), Float.intBitsToFloat(1054208351),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(42));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035393902), Float.intBitsToFloat(1054208351),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(43));
    assertEquals(new Rectangle(Float.intBitsToFloat(1039803914), Float.intBitsToFloat(1054208351),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(44));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042200658), Float.intBitsToFloat(1054208351),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(45));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044405663), Float.intBitsToFloat(1054208351),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(46));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046689826), Float.intBitsToFloat(1054060644),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(47));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044859391), Float.intBitsToFloat(1053361685),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(48));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042949800), Float.intBitsToFloat(1052810434),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(49));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041040209), Float.intBitsToFloat(1052259183),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(50));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038073846), Float.intBitsToFloat(1051707931),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(51));
    assertEquals(new Rectangle(Float.intBitsToFloat(1034254664), Float.intBitsToFloat(1051156680),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(52));
    assertEquals(new Rectangle(Float.intBitsToFloat(1036459670), Float.intBitsToFloat(1050201884),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(53));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038664674), Float.intBitsToFloat(1049247089),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(54));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040528536), Float.intBitsToFloat(1048008587),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(55));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041631038), Float.intBitsToFloat(1046098995),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(56));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043540629), Float.intBitsToFloat(1047201498),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(57));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045450219), Float.intBitsToFloat(1048304001),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(58));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047359810), Float.intBitsToFloat(1048991252),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(59));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048922701), Float.intBitsToFloat(1049542503),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(60));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049985627), Float.intBitsToFloat(1049985626),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(61));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049542505), Float.intBitsToFloat(1048922700),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(62));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048991254), Float.intBitsToFloat(1047359809),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(63));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048304005), Float.intBitsToFloat(1045450218),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(64));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047201501), Float.intBitsToFloat(1043540627),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(65));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046098999), Float.intBitsToFloat(1041631036),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(66));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048008591), Float.intBitsToFloat(1040528533),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(67));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049247091), Float.intBitsToFloat(1038664670),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(68));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050201886), Float.intBitsToFloat(1036459666),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(69));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051156682), Float.intBitsToFloat(1034254660),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(70));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051707933), Float.intBitsToFloat(1038073842),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(71));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052259185), Float.intBitsToFloat(1041040208),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(72));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052810436), Float.intBitsToFloat(1042949799),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(73));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053361687), Float.intBitsToFloat(1044859389),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(74));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054060645), Float.intBitsToFloat(1046689825),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(75));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054208351), Float.intBitsToFloat(1044405663),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(76));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054208351), Float.intBitsToFloat(1042200657),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(77));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054208351), Float.intBitsToFloat(1039803912),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(78));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054208351), Float.intBitsToFloat(1035393902),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(79));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054208351), Float.intBitsToFloat(1030168997),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(80));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055310854), Float.intBitsToFloat(1030168997),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(81));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056413357), Float.intBitsToFloat(1030168997),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(82));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057240233), Float.intBitsToFloat(1030168997),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(83));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057791485), Float.intBitsToFloat(1030168997),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(84));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057791485), Float.intBitsToFloat(1035393902),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(85));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057791485), Float.intBitsToFloat(1039803912),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(86));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057791485), Float.intBitsToFloat(1042200657),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(87));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057791485), Float.intBitsToFloat(1044405663),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(88));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057865338), Float.intBitsToFloat(1046689825),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(89));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058214818), Float.intBitsToFloat(1044859389),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(90));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058490443), Float.intBitsToFloat(1042949799),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(91));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058766069), Float.intBitsToFloat(1041040208),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(92));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059041694), Float.intBitsToFloat(1038073842),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(93));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059317320), Float.intBitsToFloat(1034254660),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(94));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059794717), Float.intBitsToFloat(1036459666),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(95));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060272115), Float.intBitsToFloat(1038664670),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(96));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060749513), Float.intBitsToFloat(1040528533),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(97));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061226910), Float.intBitsToFloat(1041631036),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(98));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060951284), Float.intBitsToFloat(1043540627),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(99));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060675659), Float.intBitsToFloat(1045450218),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(100));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060400033), Float.intBitsToFloat(1047359809),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(101));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060124408), Float.intBitsToFloat(1048922700),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(102));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059902847), Float.intBitsToFloat(1049985626),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(103));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060434309), Float.intBitsToFloat(1049542503),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(104));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060911707), Float.intBitsToFloat(1048991251),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(105));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061389105), Float.intBitsToFloat(1048303999),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(106));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061866502), Float.intBitsToFloat(1047201495),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(107));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062343900), Float.intBitsToFloat(1046098992),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(108));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062619526), Float.intBitsToFloat(1048008583),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(109));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062895152), Float.intBitsToFloat(1049247087),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(110));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063170778), Float.intBitsToFloat(1050201882),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(111));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063446404), Float.intBitsToFloat(1051156678),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(112));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062969006), Float.intBitsToFloat(1051707930),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(113));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062491609), Float.intBitsToFloat(1052259181),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(114));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062014211), Float.intBitsToFloat(1052810433),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(115));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061536813), Float.intBitsToFloat(1053361684),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(116));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061079204), Float.intBitsToFloat(1054060644),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(117));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061650244), Float.intBitsToFloat(1054208352),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(118));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062201496), Float.intBitsToFloat(1054208352),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(119));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062752747), Float.intBitsToFloat(1054208353),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(120));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063303999), Float.intBitsToFloat(1054208353),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(121));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063855250), Float.intBitsToFloat(1054208353),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(122));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063855250), Float.intBitsToFloat(1055310856),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(123));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063855250), Float.intBitsToFloat(1056413359),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(124));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063855250), Float.intBitsToFloat(1057240234),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(125));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063855250), Float.intBitsToFloat(1057791486),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(126));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063303999), Float.intBitsToFloat(1057791486),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(127));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062752747), Float.intBitsToFloat(1057791486),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(128));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062201496), Float.intBitsToFloat(1057791486),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(129));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061650244), Float.intBitsToFloat(1057791486),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(130));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061079204), Float.intBitsToFloat(1057865339),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(131));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061536812), Float.intBitsToFloat(1058214818),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(132));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062014210), Float.intBitsToFloat(1058490444),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(133));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062491608), Float.intBitsToFloat(1058766070),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(134));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062969005), Float.intBitsToFloat(1059041695),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(135));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063446403), Float.intBitsToFloat(1059317321),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(136));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063170778), Float.intBitsToFloat(1059794718),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(137));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062895152), Float.intBitsToFloat(1060272116),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(138));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062619526), Float.intBitsToFloat(1060749514),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(139));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062343901), Float.intBitsToFloat(1061226911),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(140));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061866503), Float.intBitsToFloat(1060951285),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(141));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061389106), Float.intBitsToFloat(1060675660),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(142));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060911708), Float.intBitsToFloat(1060400034),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(143));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060434310), Float.intBitsToFloat(1060124408),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(144));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059902847), Float.intBitsToFloat(1059902847),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(145));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060124408), Float.intBitsToFloat(1060434310),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(146));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060400034), Float.intBitsToFloat(1060911708),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(147));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060675660), Float.intBitsToFloat(1061389106),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(148));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060951285), Float.intBitsToFloat(1061866503),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(149));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061226911), Float.intBitsToFloat(1062343901),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(150));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060749514), Float.intBitsToFloat(1062619526),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(151));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060272116), Float.intBitsToFloat(1062895152),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(152));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059794718), Float.intBitsToFloat(1063170778),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(153));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059317321), Float.intBitsToFloat(1063446403),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(154));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059041695), Float.intBitsToFloat(1062969005),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(155));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058766070), Float.intBitsToFloat(1062491608),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(156));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058490444), Float.intBitsToFloat(1062014210),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(157));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058214818), Float.intBitsToFloat(1061536812),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(158));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057865338), Float.intBitsToFloat(1061079204),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(159));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057791484), Float.intBitsToFloat(1061650244),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(160));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057791484), Float.intBitsToFloat(1062201496),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(161));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057791484), Float.intBitsToFloat(1062752747),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(162));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057791484), Float.intBitsToFloat(1063303999),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(163));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057791484), Float.intBitsToFloat(1063855250),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(164));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057240233), Float.intBitsToFloat(1063855250),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(165));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056413356), Float.intBitsToFloat(1063855250),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(166));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055310853), Float.intBitsToFloat(1063855250),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(167));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056413356), Float.intBitsToFloat(1063303999),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(168));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056413356), Float.intBitsToFloat(1062752747),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(169));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056413356), Float.intBitsToFloat(1062201496),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(170));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056413356), Float.intBitsToFloat(1061650244),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(171));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049798339), Float.intBitsToFloat(1062417754),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(172));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050349591), Float.intBitsToFloat(1061940357),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(173));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050900842), Float.intBitsToFloat(1061462959),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(174));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051452094), Float.intBitsToFloat(1060985561),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(175));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041335624), Float.intBitsToFloat(1059996490),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(176));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043245215), Float.intBitsToFloat(1059720865),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(177));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045154805), Float.intBitsToFloat(1059445239),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(178));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047064396), Float.intBitsToFloat(1059169613),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(179));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035393902), Float.intBitsToFloat(1056413356),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(180));
    assertEquals(new Rectangle(Float.intBitsToFloat(1039803912), Float.intBitsToFloat(1056413356),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(181));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042200657), Float.intBitsToFloat(1056413356),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(182));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044405663), Float.intBitsToFloat(1056413356),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(183));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041335624), Float.intBitsToFloat(1049798340),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(184));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043245215), Float.intBitsToFloat(1050349592),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(185));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045154805), Float.intBitsToFloat(1050900843),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(186));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047064396), Float.intBitsToFloat(1051452094),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(187));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049798342), Float.intBitsToFloat(1041335622),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(188));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050349593), Float.intBitsToFloat(1043245213),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(189));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050900845), Float.intBitsToFloat(1045154803),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(190));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051452096), Float.intBitsToFloat(1047064395),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(191));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056413357), Float.intBitsToFloat(1035393902),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(192));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056413357), Float.intBitsToFloat(1039803912),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(193));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056413357), Float.intBitsToFloat(1042200657),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(194));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056413357), Float.intBitsToFloat(1044405663),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(195));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059996489), Float.intBitsToFloat(1041335622),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(196));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059720864), Float.intBitsToFloat(1043245213),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(197));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059445238), Float.intBitsToFloat(1045154803),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(198));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059169612), Float.intBitsToFloat(1047064395),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(199));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062417754), Float.intBitsToFloat(1049798339),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(200));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061940357), Float.intBitsToFloat(1050349590),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(201));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061462959), Float.intBitsToFloat(1050900842),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(202));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060985561), Float.intBitsToFloat(1051452093),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(203));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063303999), Float.intBitsToFloat(1056413359),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(204));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062752747), Float.intBitsToFloat(1056413359),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(205));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062201496), Float.intBitsToFloat(1056413359),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(206));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061650244), Float.intBitsToFloat(1056413359),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(207));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062417754), Float.intBitsToFloat(1059996490),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(208));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061940357), Float.intBitsToFloat(1059720865),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(209));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061462959), Float.intBitsToFloat(1059445239),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(210));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060985561), Float.intBitsToFloat(1059169613),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(211));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059996490), Float.intBitsToFloat(1062417754),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(212));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059720865), Float.intBitsToFloat(1061940357),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(213));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059445239), Float.intBitsToFloat(1061462959),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(214));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059169613), Float.intBitsToFloat(1060985561),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(215));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054759602), Float.intBitsToFloat(1064406502),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(216));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055862105), Float.intBitsToFloat(1064406502),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(217));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964607), Float.intBitsToFloat(1064406502),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(218));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057515859), Float.intBitsToFloat(1064406502),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(219));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045951287), Float.intBitsToFloat(1062959111),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(220));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047860877), Float.intBitsToFloat(1063234737),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(221));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049173235), Float.intBitsToFloat(1063510363),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(222));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050128030), Float.intBitsToFloat(1063785989),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(223));
    assertEquals(new Rectangle(Float.intBitsToFloat(1031277179), Float.intBitsToFloat(1059831646),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(224));
    assertEquals(new Rectangle(Float.intBitsToFloat(1033742988), Float.intBitsToFloat(1060309043),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(225));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035947994), Float.intBitsToFloat(1060786441),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(226));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038152998), Float.intBitsToFloat(1061263838),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(227));
    assertEquals(new Rectangle(Float.intBitsToFloat(1019287772), Float.intBitsToFloat(1054759602),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(228));
    assertEquals(new Rectangle(Float.intBitsToFloat(1019287770), Float.intBitsToFloat(1055862105),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(229));
    assertEquals(new Rectangle(Float.intBitsToFloat(1019287770), Float.intBitsToFloat(1056964607),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(230));
    assertEquals(new Rectangle(Float.intBitsToFloat(1019287768), Float.intBitsToFloat(1057515859),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(231));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038152998), Float.intBitsToFloat(1045951289),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(232));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035947994), Float.intBitsToFloat(1047860879),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(233));
    assertEquals(new Rectangle(Float.intBitsToFloat(1033742988), Float.intBitsToFloat(1049173236),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(234));
    assertEquals(new Rectangle(Float.intBitsToFloat(1031277181), Float.intBitsToFloat(1050128031),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(235));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050128032), Float.intBitsToFloat(1031277173),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(236));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049173237), Float.intBitsToFloat(1033742984),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(237));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047860881), Float.intBitsToFloat(1035947988),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(238));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045951291), Float.intBitsToFloat(1038152994),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(239));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057515859), Float.intBitsToFloat(1019287770),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(240));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964608), Float.intBitsToFloat(1019287770),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(241));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055862106), Float.intBitsToFloat(1019287770),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(242));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054759603), Float.intBitsToFloat(1019287770),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(243));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061263838), Float.intBitsToFloat(1038152994),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(244));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060786440), Float.intBitsToFloat(1035947988),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(245));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060309042), Float.intBitsToFloat(1033742984),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(246));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059831644), Float.intBitsToFloat(1031277173),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(247));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063785989), Float.intBitsToFloat(1050128028),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(248));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063510363), Float.intBitsToFloat(1049173233),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(249));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063234737), Float.intBitsToFloat(1047860873),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(250));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062959111), Float.intBitsToFloat(1045951283),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(251));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064406502), Float.intBitsToFloat(1057515860),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(252));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064406502), Float.intBitsToFloat(1056964609),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(253));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064406502), Float.intBitsToFloat(1055862108),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(254));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064406502), Float.intBitsToFloat(1054759605),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(255));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062959111), Float.intBitsToFloat(1061263838),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(256));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063234737), Float.intBitsToFloat(1060786441),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(257));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063510363), Float.intBitsToFloat(1060309043),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(258));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063785989), Float.intBitsToFloat(1059831646),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(259));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059831646), Float.intBitsToFloat(1063785989),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(260));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060309043), Float.intBitsToFloat(1063510363),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(261));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060786441), Float.intBitsToFloat(1063234737),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(262));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061263838), Float.intBitsToFloat(1062959111),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        instance.getBoundsForBoardIndex(263));

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
    Rectangle expResult = new Rectangle(Float.intBitsToFloat(1055035228),
        Float.intBitsToFloat(1054263476), Float.intBitsToFloat(1038845215),
        Float.intBitsToFloat(1042603311));
    Rectangle result = instance.getBoundsForDiscardPile();
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
