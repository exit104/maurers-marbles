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
  @SuppressWarnings("PMD.UseUnderscoresInNumericLiterals")
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

    // code to generate expected values
    /*for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      System.out.printf("// test with %d players\n", numberOfPlayers);
      System.out.printf("board = new Board(%d);\n", numberOfPlayers);
      System.out.printf("gridBoardLayout = new GridBoardLayout(board);\n");
      GridBoardLayout gridBoardLayout = new GridBoardLayout(new Board(numberOfPlayers));
      for (int i = 0; i < gridBoardLayout.board.getNumberOfPlayableSpaces(); i++) {
        Rectangle rectangle = gridBoardLayout.getBoundsForBoardIndex(i);
        System.out.printf("assertEquals(new Rectangle(Float.intBitsToFloat(%d), "
            + "Float.intBitsToFloat(%d),\nFloat.intBitsToFloat(%d), Float.intBitsToFloat(%d)),\n"
            + "gridBoardLayout.boardIndexToBoundsMap.get(%d));\n",
            Float.floatToIntBits(rectangle.getX()), Float.floatToIntBits(rectangle.getY()),
            Float.floatToIntBits(rectangle.getWidth()), Float.floatToIntBits(rectangle.getHeight()),
            i);
      }
    }*/
    // test with 4 players
    board = new Board(4);
    GridBoardLayout gridBoardLayout = new GridBoardLayout(board);
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141158), Float.intBitsToFloat(1063235093),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(0));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141158), Float.intBitsToFloat(1062270403),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(1));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141158), Float.intBitsToFloat(1061305713),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(2));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141158), Float.intBitsToFloat(1060341023),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(3));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141158), Float.intBitsToFloat(1059376333),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(4));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141158), Float.intBitsToFloat(1058411643),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(5));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050211778), Float.intBitsToFloat(1058411643),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(6));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047988796), Float.intBitsToFloat(1058411643),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(7));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044130038), Float.intBitsToFloat(1058411643),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(8));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040271278), Float.intBitsToFloat(1058411643),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(9));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032637644), Float.intBitsToFloat(1058411643),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(10));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032637644), Float.intBitsToFloat(1057446953),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(11));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032637644), Float.intBitsToFloat(1055999918),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(12));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032637644), Float.intBitsToFloat(1054070538),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(13));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032637644), Float.intBitsToFloat(1052141158),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(14));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040271278), Float.intBitsToFloat(1052141158),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(15));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044130038), Float.intBitsToFloat(1052141158),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(16));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047988796), Float.intBitsToFloat(1052141158),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(17));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050211778), Float.intBitsToFloat(1052141158),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(18));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141158), Float.intBitsToFloat(1052141158),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(19));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141158), Float.intBitsToFloat(1050211778),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(20));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141158), Float.intBitsToFloat(1047988796),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(21));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141158), Float.intBitsToFloat(1044130038),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(22));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141158), Float.intBitsToFloat(1040271278),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(23));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052141158), Float.intBitsToFloat(1032637644),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(24));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054070538), Float.intBitsToFloat(1032637644),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(25));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055999918), Float.intBitsToFloat(1032637644),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(26));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057446953), Float.intBitsToFloat(1032637644),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(27));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411643), Float.intBitsToFloat(1032637644),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(28));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411643), Float.intBitsToFloat(1040271278),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(29));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411643), Float.intBitsToFloat(1044130038),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(30));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411643), Float.intBitsToFloat(1047988796),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(31));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411643), Float.intBitsToFloat(1050211778),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(32));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411643), Float.intBitsToFloat(1052141158),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(33));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059376333), Float.intBitsToFloat(1052141158),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(34));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060341023), Float.intBitsToFloat(1052141158),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(35));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061305713), Float.intBitsToFloat(1052141158),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(36));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062270403), Float.intBitsToFloat(1052141158),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(37));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063235093), Float.intBitsToFloat(1052141158),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(38));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063235093), Float.intBitsToFloat(1054070538),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(39));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063235093), Float.intBitsToFloat(1055999918),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(40));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063235093), Float.intBitsToFloat(1057446953),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(41));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063235093), Float.intBitsToFloat(1058411643),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(42));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062270403), Float.intBitsToFloat(1058411643),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(43));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061305713), Float.intBitsToFloat(1058411643),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(44));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060341023), Float.intBitsToFloat(1058411643),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(45));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059376333), Float.intBitsToFloat(1058411643),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(46));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411643), Float.intBitsToFloat(1058411643),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(47));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411643), Float.intBitsToFloat(1059376333),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(48));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411643), Float.intBitsToFloat(1060341023),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(49));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411643), Float.intBitsToFloat(1061305713),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(50));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411643), Float.intBitsToFloat(1062270403),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(51));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058411643), Float.intBitsToFloat(1063235093),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(52));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057446953), Float.intBitsToFloat(1063235093),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(53));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055999918), Float.intBitsToFloat(1063235093),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(54));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054070538), Float.intBitsToFloat(1063235093),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(55));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055999918), Float.intBitsToFloat(1062270403),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(56));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055999918), Float.intBitsToFloat(1061305713),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(57));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055999918), Float.intBitsToFloat(1060341023),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(58));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055999918), Float.intBitsToFloat(1059376333),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(59));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040271278), Float.intBitsToFloat(1055999918),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(60));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044130038), Float.intBitsToFloat(1055999918),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(61));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047988796), Float.intBitsToFloat(1055999918),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(62));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050211778), Float.intBitsToFloat(1055999918),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(63));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055999918), Float.intBitsToFloat(1040271278),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(64));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055999918), Float.intBitsToFloat(1044130038),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(65));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055999918), Float.intBitsToFloat(1047988796),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(66));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055999918), Float.intBitsToFloat(1050211778),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(67));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062270403), Float.intBitsToFloat(1055999918),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(68));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061305713), Float.intBitsToFloat(1055999918),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(69));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060341023), Float.intBitsToFloat(1055999918),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(70));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059376333), Float.intBitsToFloat(1055999918),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(71));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053105848), Float.intBitsToFloat(1064199783),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(72));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055035228), Float.intBitsToFloat(1064199783),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(73));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964608), Float.intBitsToFloat(1064199783),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(74));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057929298), Float.intBitsToFloat(1064199783),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(75));
    assertEquals(new Rectangle(Float.intBitsToFloat(1010323938), Float.intBitsToFloat(1053105848),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(76));
    assertEquals(new Rectangle(Float.intBitsToFloat(1010323938), Float.intBitsToFloat(1055035228),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(77));
    assertEquals(new Rectangle(Float.intBitsToFloat(1010323938), Float.intBitsToFloat(1056964608),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(78));
    assertEquals(new Rectangle(Float.intBitsToFloat(1010323938), Float.intBitsToFloat(1057929298),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(79));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057929298), Float.intBitsToFloat(1010323938),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(80));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964608), Float.intBitsToFloat(1010323938),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(81));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055035228), Float.intBitsToFloat(1010323938),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(82));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053105848), Float.intBitsToFloat(1010323938),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(83));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064199783), Float.intBitsToFloat(1057929298),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(84));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064199783), Float.intBitsToFloat(1056964608),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(85));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064199783), Float.intBitsToFloat(1055035228),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(86));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064199783), Float.intBitsToFloat(1053105848),
        Float.intBitsToFloat(1030456607), Float.intBitsToFloat(1030456607)),
        gridBoardLayout.boardIndexToBoundsMap.get(87));

    // test with 6 players
    board = new Board(6);
    gridBoardLayout = new GridBoardLayout(board);
    assertEquals(new Rectangle(Float.intBitsToFloat(1052902756), Float.intBitsToFloat(1063463572),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(0));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052902756), Float.intBitsToFloat(1062651201),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(1));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052902756), Float.intBitsToFloat(1061838831),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(2));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052902756), Float.intBitsToFloat(1061026461),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(3));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052902756), Float.intBitsToFloat(1060214090),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(4));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052852244), Float.intBitsToFloat(1059387138),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(5));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051445176), Float.intBitsToFloat(1059793323),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(6));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050038110), Float.intBitsToFloat(1060199508),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(7));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048631042), Float.intBitsToFloat(1060605694),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(8));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045871951), Float.intBitsToFloat(1061011879),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(9));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043057817), Float.intBitsToFloat(1061418064),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(10));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041433076), Float.intBitsToFloat(1060714531),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(11));
    assertEquals(new Rectangle(Float.intBitsToFloat(1039429278), Float.intBitsToFloat(1060010997),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(12));
    assertEquals(new Rectangle(Float.intBitsToFloat(1036179796), Float.intBitsToFloat(1059307463),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(13));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032930314), Float.intBitsToFloat(1058603930),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(14));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038558582), Float.intBitsToFloat(1058197745),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(15));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042187121), Float.intBitsToFloat(1057791560),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(16));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045001255), Float.intBitsToFloat(1057385374),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(17));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047815389), Float.intBitsToFloat(1056979189),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(18));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049602762), Float.intBitsToFloat(1056123074),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(19));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047815391), Float.intBitsToFloat(1055310704),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(20));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045001257), Float.intBitsToFloat(1054498334),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(21));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042187123), Float.intBitsToFloat(1053685962),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(22));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038558586), Float.intBitsToFloat(1052873592),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(23));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032930317), Float.intBitsToFloat(1052061222),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(24));
    assertEquals(new Rectangle(Float.intBitsToFloat(1036179800), Float.intBitsToFloat(1050654154),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(25));
    assertEquals(new Rectangle(Float.intBitsToFloat(1039429282), Float.intBitsToFloat(1049247088),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(26));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041433078), Float.intBitsToFloat(1047104041),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(27));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043057819), Float.intBitsToFloat(1044289907),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(28));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045871953), Float.intBitsToFloat(1045914648),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(29));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048631044), Float.intBitsToFloat(1047539389),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(30));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050038110), Float.intBitsToFloat(1048870066),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(31));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051445178), Float.intBitsToFloat(1049682436),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(32));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052902756), Float.intBitsToFloat(1050465644),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(33));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052902756), Float.intBitsToFloat(1048840904),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(34));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052902756), Float.intBitsToFloat(1045856325),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(35));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052902756), Float.intBitsToFloat(1042606843),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(36));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052902756), Float.intBitsToFloat(1038527330),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(37));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052902756), Float.intBitsToFloat(1032028366),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(38));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054527496), Float.intBitsToFloat(1032028366),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(39));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056152238), Float.intBitsToFloat(1032028366),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(40));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057370793), Float.intBitsToFloat(1032028366),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(41));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058183164), Float.intBitsToFloat(1032028366),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(42));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058183164), Float.intBitsToFloat(1038527330),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(43));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058183164), Float.intBitsToFloat(1042606843),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(44));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058183164), Float.intBitsToFloat(1045856325),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(45));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058183164), Float.intBitsToFloat(1048840904),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(46));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058208420), Float.intBitsToFloat(1050494808),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(47));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058911954), Float.intBitsToFloat(1049682436),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(48));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059615487), Float.intBitsToFloat(1048870066),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(49));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060319021), Float.intBitsToFloat(1047539393),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(50));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061022555), Float.intBitsToFloat(1045914652),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(51));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061726088), Float.intBitsToFloat(1044289911),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(52));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062132273), Float.intBitsToFloat(1047104045),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(53));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062538458), Float.intBitsToFloat(1049247090),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(54));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062944643), Float.intBitsToFloat(1050654156),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(55));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063350828), Float.intBitsToFloat(1052061224),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(56));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062647295), Float.intBitsToFloat(1052873594),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(57));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061943761), Float.intBitsToFloat(1053685964),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(58));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061240227), Float.intBitsToFloat(1054498334),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(59));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060536694), Float.intBitsToFloat(1055310704),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(60));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059833160), Float.intBitsToFloat(1056181400),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(61));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060536694), Float.intBitsToFloat(1056979189),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(62));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061240227), Float.intBitsToFloat(1057385375),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(63));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061943761), Float.intBitsToFloat(1057791560),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(64));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062647295), Float.intBitsToFloat(1058197745),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(65));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063350828), Float.intBitsToFloat(1058603930),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(66));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062944643), Float.intBitsToFloat(1059307463),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(67));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062538458), Float.intBitsToFloat(1060010997),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(68));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062132273), Float.intBitsToFloat(1060714531),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(69));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061726088), Float.intBitsToFloat(1061418064),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(70));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061022555), Float.intBitsToFloat(1061011879),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(71));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060319021), Float.intBitsToFloat(1060605694),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(72));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059615487), Float.intBitsToFloat(1060199509),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(73));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058911954), Float.intBitsToFloat(1059793323),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(74));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058183164), Float.intBitsToFloat(1059401719),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(75));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058183164), Float.intBitsToFloat(1060214090),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(76));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058183164), Float.intBitsToFloat(1061026461),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(77));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058183164), Float.intBitsToFloat(1061838831),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(78));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058183164), Float.intBitsToFloat(1062651201),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(79));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058183164), Float.intBitsToFloat(1063463572),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(80));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057370793), Float.intBitsToFloat(1063463572),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(81));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056152238), Float.intBitsToFloat(1063463572),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(82));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054527496), Float.intBitsToFloat(1063463572),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(83));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056152238), Float.intBitsToFloat(1062651201),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(84));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056152238), Float.intBitsToFloat(1061838831),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(85));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056152238), Float.intBitsToFloat(1061026461),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(86));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056152238), Float.intBitsToFloat(1060214090),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(87));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042622469), Float.intBitsToFloat(1059604812),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(88));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045436603), Float.intBitsToFloat(1059198627),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(89));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048250737), Float.intBitsToFloat(1058792441),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(90));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049820436), Float.intBitsToFloat(1058386256),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(91));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042622471), Float.intBitsToFloat(1050059458),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(92));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045436605), Float.intBitsToFloat(1050871828),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(93));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048250739), Float.intBitsToFloat(1051684200),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(94));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049820436), Float.intBitsToFloat(1052496570),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(95));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056152238), Float.intBitsToFloat(1038527330),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(96));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056152238), Float.intBitsToFloat(1042606843),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(97));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056152238), Float.intBitsToFloat(1045856325),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(98));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056152238), Float.intBitsToFloat(1048840904),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(99));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061834925), Float.intBitsToFloat(1050059460),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(100));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061131391), Float.intBitsToFloat(1050871830),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(101));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060427857), Float.intBitsToFloat(1051684200),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(102));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059724324), Float.intBitsToFloat(1052496570),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(103));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061834925), Float.intBitsToFloat(1059604812),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(104));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061131391), Float.intBitsToFloat(1059198627),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(105));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060427857), Float.intBitsToFloat(1058792441),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(106));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059724324), Float.intBitsToFloat(1058386256),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(107));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053715126), Float.intBitsToFloat(1064275943),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(108));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055339868), Float.intBitsToFloat(1064275943),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(109));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964608), Float.intBitsToFloat(1064275943),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(110));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057776979), Float.intBitsToFloat(1064275943),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(111));
    assertEquals(new Rectangle(Float.intBitsToFloat(1026054792), Float.intBitsToFloat(1059361883),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(112));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032176269), Float.intBitsToFloat(1060065416),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(113));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035425751), Float.intBitsToFloat(1060768950),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(114));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038675232), Float.intBitsToFloat(1061472483),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(115));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038675238), Float.intBitsToFloat(1044072234),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(116));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035425755), Float.intBitsToFloat(1046886368),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(117));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032176273), Float.intBitsToFloat(1049138252),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(118));
    assertEquals(new Rectangle(Float.intBitsToFloat(1026054796), Float.intBitsToFloat(1050545318),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(119));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057776979), Float.intBitsToFloat(1015109864),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(120));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964608), Float.intBitsToFloat(1015109864),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(121));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055339868), Float.intBitsToFloat(1015109864),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(122));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053715126), Float.intBitsToFloat(1015109864),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(123));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063851269), Float.intBitsToFloat(1050545320),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(124));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063445084), Float.intBitsToFloat(1049138254),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(125));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063038898), Float.intBitsToFloat(1046886372),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(126));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062632713), Float.intBitsToFloat(1044072238),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(127));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062632713), Float.intBitsToFloat(1061472482),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(128));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063038898), Float.intBitsToFloat(1060768949),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(129));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063445084), Float.intBitsToFloat(1060065415),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(130));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063851269), Float.intBitsToFloat(1059361882),
        Float.intBitsToFloat(1028019496), Float.intBitsToFloat(1028019496)),
        gridBoardLayout.boardIndexToBoundsMap.get(131));

    // test with 8 players
    board = new Board(8);
    gridBoardLayout = new GridBoardLayout(board);
    assertEquals(new Rectangle(Float.intBitsToFloat(1053456644), Float.intBitsToFloat(1063629739),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(0));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053456644), Float.intBitsToFloat(1062928146),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(1));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053456644), Float.intBitsToFloat(1062226554),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(2));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053456644), Float.intBitsToFloat(1061524961),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(3));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053456644), Float.intBitsToFloat(1060823368),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(4));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053286409), Float.intBitsToFloat(1060086519),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(5));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052294207), Float.intBitsToFloat(1060582620),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(6));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051302005), Float.intBitsToFloat(1061078721),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(7));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050309804), Float.intBitsToFloat(1061574822),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(8));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049317602), Float.intBitsToFloat(1062070923),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(9));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048074801), Float.intBitsToFloat(1062567024),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(10));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046090397), Float.intBitsToFloat(1062070923),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(11));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044105993), Float.intBitsToFloat(1061574822),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(12));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042121589), Float.intBitsToFloat(1061078721),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(13));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040086977), Float.intBitsToFloat(1060582620),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(14));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042121589), Float.intBitsToFloat(1060086519),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(15));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044105993), Float.intBitsToFloat(1059590418),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(16));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046090396), Float.intBitsToFloat(1059094317),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(17));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048074799), Float.intBitsToFloat(1058598216),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(18));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049247088), Float.intBitsToFloat(1058016997),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(19));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047111806), Float.intBitsToFloat(1058016997),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(20));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044305435), Float.intBitsToFloat(1058016997),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(21));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041499065), Float.intBitsToFloat(1058016997),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(22));
    assertEquals(new Rectangle(Float.intBitsToFloat(1037197995), Float.intBitsToFloat(1058016997),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(23));
    assertEquals(new Rectangle(Float.intBitsToFloat(1031371722), Float.intBitsToFloat(1058016997),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(24));
    assertEquals(new Rectangle(Float.intBitsToFloat(1031371722), Float.intBitsToFloat(1057315405),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(25));
    assertEquals(new Rectangle(Float.intBitsToFloat(1031371722), Float.intBitsToFloat(1056263015),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(26));
    assertEquals(new Rectangle(Float.intBitsToFloat(1031371722), Float.intBitsToFloat(1054859830),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(27));
    assertEquals(new Rectangle(Float.intBitsToFloat(1031371722), Float.intBitsToFloat(1053456644),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(28));
    assertEquals(new Rectangle(Float.intBitsToFloat(1037197995), Float.intBitsToFloat(1053456644),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(29));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041499065), Float.intBitsToFloat(1053456644),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(30));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044305435), Float.intBitsToFloat(1053456644),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(31));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047111806), Float.intBitsToFloat(1053456644),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(32));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049317601), Float.intBitsToFloat(1053286409),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(33));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048074799), Float.intBitsToFloat(1052294207),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(34));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046090396), Float.intBitsToFloat(1051302005),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(35));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044105993), Float.intBitsToFloat(1050309804),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(36));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042121589), Float.intBitsToFloat(1049317602),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(37));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040086977), Float.intBitsToFloat(1048074801),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(38));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042121589), Float.intBitsToFloat(1046090397),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(39));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044105993), Float.intBitsToFloat(1044105993),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(40));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046090397), Float.intBitsToFloat(1042121589),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(41));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048074801), Float.intBitsToFloat(1040086977),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(42));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049317602), Float.intBitsToFloat(1042121589),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(43));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050309804), Float.intBitsToFloat(1044105993),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(44));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051302005), Float.intBitsToFloat(1046090396),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(45));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052294207), Float.intBitsToFloat(1048074799),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(46));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053456644), Float.intBitsToFloat(1049247088),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(47));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053456644), Float.intBitsToFloat(1047111806),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(48));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053456644), Float.intBitsToFloat(1044305435),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(49));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053456644), Float.intBitsToFloat(1041499065),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(50));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053456644), Float.intBitsToFloat(1037197995),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(51));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053456644), Float.intBitsToFloat(1031371722),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(52));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054859830), Float.intBitsToFloat(1031371722),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(53));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056263015), Float.intBitsToFloat(1031371722),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(54));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057315405), Float.intBitsToFloat(1031371722),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(55));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058016997), Float.intBitsToFloat(1031371722),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(56));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058016997), Float.intBitsToFloat(1037197995),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(57));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058016997), Float.intBitsToFloat(1041499065),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(58));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058016997), Float.intBitsToFloat(1044305435),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(59));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058016997), Float.intBitsToFloat(1047111806),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(60));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058102115), Float.intBitsToFloat(1049317601),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(61));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058598216), Float.intBitsToFloat(1048074799),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(62));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059094317), Float.intBitsToFloat(1046090396),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(63));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059590418), Float.intBitsToFloat(1044105993),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(64));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060086519), Float.intBitsToFloat(1042121589),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(65));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060582620), Float.intBitsToFloat(1040086977),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(66));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061078721), Float.intBitsToFloat(1042121589),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(67));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061574822), Float.intBitsToFloat(1044105993),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(68));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062070923), Float.intBitsToFloat(1046090397),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(69));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062567024), Float.intBitsToFloat(1048074801),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(70));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062070923), Float.intBitsToFloat(1049317602),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(71));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061574822), Float.intBitsToFloat(1050309804),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(72));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061078721), Float.intBitsToFloat(1051302005),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(73));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060582620), Float.intBitsToFloat(1052294207),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(74));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060121776), Float.intBitsToFloat(1053456644),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(75));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060823368), Float.intBitsToFloat(1053456644),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(76));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061524961), Float.intBitsToFloat(1053456644),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(77));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062226554), Float.intBitsToFloat(1053456644),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(78));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062928146), Float.intBitsToFloat(1053456644),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(79));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063629739), Float.intBitsToFloat(1053456644),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(80));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063629739), Float.intBitsToFloat(1054859830),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(81));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063629739), Float.intBitsToFloat(1056263015),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(82));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063629739), Float.intBitsToFloat(1057315405),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(83));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063629739), Float.intBitsToFloat(1058016997),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(84));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062928146), Float.intBitsToFloat(1058016997),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(85));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062226554), Float.intBitsToFloat(1058016997),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(86));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061524961), Float.intBitsToFloat(1058016997),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(87));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060823368), Float.intBitsToFloat(1058016997),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(88));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060086519), Float.intBitsToFloat(1058102115),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(89));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060582620), Float.intBitsToFloat(1058598216),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(90));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061078721), Float.intBitsToFloat(1059094317),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(91));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061574822), Float.intBitsToFloat(1059590418),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(92));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062070923), Float.intBitsToFloat(1060086519),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(93));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062567024), Float.intBitsToFloat(1060582620),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(94));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062070923), Float.intBitsToFloat(1061078721),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(95));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061574822), Float.intBitsToFloat(1061574822),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(96));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061078721), Float.intBitsToFloat(1062070923),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(97));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060582620), Float.intBitsToFloat(1062567024),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(98));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060086519), Float.intBitsToFloat(1062070923),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(99));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059590418), Float.intBitsToFloat(1061574822),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(100));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059094317), Float.intBitsToFloat(1061078721),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(101));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058598216), Float.intBitsToFloat(1060582620),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(102));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058016997), Float.intBitsToFloat(1060121776),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(103));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058016997), Float.intBitsToFloat(1060823368),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(104));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058016997), Float.intBitsToFloat(1061524961),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(105));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058016997), Float.intBitsToFloat(1062226554),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(106));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058016997), Float.intBitsToFloat(1062928146),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(107));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058016997), Float.intBitsToFloat(1063629739),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(108));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057315405), Float.intBitsToFloat(1063629739),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(109));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056263015), Float.intBitsToFloat(1063629739),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(110));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054859830), Float.intBitsToFloat(1063629739),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(111));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056263015), Float.intBitsToFloat(1062928146),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(112));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056263015), Float.intBitsToFloat(1062226554),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(113));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056263015), Float.intBitsToFloat(1061524961),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(114));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056263015), Float.intBitsToFloat(1060823368),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(115));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046090397), Float.intBitsToFloat(1061078721),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(116));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048074801), Float.intBitsToFloat(1060582620),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(117));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049317601), Float.intBitsToFloat(1060086519),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(118));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050309803), Float.intBitsToFloat(1059590418),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(119));
    assertEquals(new Rectangle(Float.intBitsToFloat(1037197995), Float.intBitsToFloat(1056263015),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(120));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041499065), Float.intBitsToFloat(1056263015),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(121));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044305435), Float.intBitsToFloat(1056263015),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(122));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047111806), Float.intBitsToFloat(1056263015),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(123));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046090397), Float.intBitsToFloat(1046090397),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(124));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048074801), Float.intBitsToFloat(1048074801),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(125));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049317601), Float.intBitsToFloat(1049317601),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(126));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050309803), Float.intBitsToFloat(1050309803),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(127));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056263015), Float.intBitsToFloat(1037197995),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(128));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056263015), Float.intBitsToFloat(1041499065),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(129));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056263015), Float.intBitsToFloat(1044305435),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(130));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056263015), Float.intBitsToFloat(1047111806),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(131));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061078721), Float.intBitsToFloat(1046090397),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(132));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060582620), Float.intBitsToFloat(1048074801),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(133));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060086519), Float.intBitsToFloat(1049317601),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(134));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059590418), Float.intBitsToFloat(1050309803),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(135));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062928146), Float.intBitsToFloat(1056263015),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(136));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062226554), Float.intBitsToFloat(1056263015),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(137));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061524961), Float.intBitsToFloat(1056263015),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(138));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060823368), Float.intBitsToFloat(1056263015),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(139));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061078721), Float.intBitsToFloat(1061078721),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(140));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060582620), Float.intBitsToFloat(1060582620),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(141));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060086519), Float.intBitsToFloat(1060086519),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(142));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059590418), Float.intBitsToFloat(1059590418),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(143));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054158237), Float.intBitsToFloat(1064331332),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(144));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055561422), Float.intBitsToFloat(1064331332),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(145));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964607), Float.intBitsToFloat(1064331332),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(146));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057666201), Float.intBitsToFloat(1064331332),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(147));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038102573), Float.intBitsToFloat(1061326771),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(148));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041129387), Float.intBitsToFloat(1061822872),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(149));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043113791), Float.intBitsToFloat(1062318972),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(150));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045098195), Float.intBitsToFloat(1062815073),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(151));
    assertEquals(new Rectangle(Float.intBitsToFloat(1016882309), Float.intBitsToFloat(1054158237),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(152));
    assertEquals(new Rectangle(Float.intBitsToFloat(1016882309), Float.intBitsToFloat(1055561422),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(153));
    assertEquals(new Rectangle(Float.intBitsToFloat(1016882309), Float.intBitsToFloat(1056964607),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(154));
    assertEquals(new Rectangle(Float.intBitsToFloat(1016882309), Float.intBitsToFloat(1057666201),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(155));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045098195), Float.intBitsToFloat(1038102573),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(156));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043113791), Float.intBitsToFloat(1041129387),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(157));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041129387), Float.intBitsToFloat(1043113791),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(158));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038102573), Float.intBitsToFloat(1045098195),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(159));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057666201), Float.intBitsToFloat(1016882309),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(160));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964607), Float.intBitsToFloat(1016882309),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(161));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055561422), Float.intBitsToFloat(1016882309),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(162));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054158237), Float.intBitsToFloat(1016882309),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(163));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062815073), Float.intBitsToFloat(1045098195),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(164));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062318972), Float.intBitsToFloat(1043113791),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(165));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061822872), Float.intBitsToFloat(1041129387),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(166));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061326771), Float.intBitsToFloat(1038102573),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(167));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064331332), Float.intBitsToFloat(1057666201),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(168));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064331332), Float.intBitsToFloat(1056964607),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(169));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064331332), Float.intBitsToFloat(1055561422),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(170));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064331332), Float.intBitsToFloat(1054158237),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(171));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061326771), Float.intBitsToFloat(1062815073),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(172));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061822872), Float.intBitsToFloat(1062318972),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(173));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062318972), Float.intBitsToFloat(1061822872),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(174));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062815073), Float.intBitsToFloat(1061326771),
        Float.intBitsToFloat(1026247051), Float.intBitsToFloat(1026247051)),
        gridBoardLayout.boardIndexToBoundsMap.get(175));

    // test with 10 players
    board = new Board(10);
    gridBoardLayout = new GridBoardLayout(board);
    assertEquals(new Rectangle(Float.intBitsToFloat(1053877600), Float.intBitsToFloat(1063756025),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(0));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053877600), Float.intBitsToFloat(1063138623),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(1));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053877600), Float.intBitsToFloat(1062521222),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(2));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053877600), Float.intBitsToFloat(1061903820),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(3));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053877600), Float.intBitsToFloat(1061286419),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(4));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053627465), Float.intBitsToFloat(1060628380),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(5));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052901666), Float.intBitsToFloat(1061127869),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(6));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052175867), Float.intBitsToFloat(1061627357),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(7));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051450068), Float.intBitsToFloat(1062126845),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(8));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050724269), Float.intBitsToFloat(1062626334),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(9));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049998470), Float.intBitsToFloat(1063125822),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(10));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048999494), Float.intBitsToFloat(1062762923),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(11));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047425035), Float.intBitsToFloat(1062400023),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(12));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045427081), Float.intBitsToFloat(1062037123),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(13));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043429128), Float.intBitsToFloat(1061674224),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(14));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044880726), Float.intBitsToFloat(1061174736),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(15));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046332324), Float.intBitsToFloat(1060675247),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(16));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047783923), Float.intBitsToFloat(1060175759),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(17));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048905760), Float.intBitsToFloat(1059676271),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(18));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049476967), Float.intBitsToFloat(1059070394),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(19));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048029201), Float.intBitsToFloat(1059261182),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(20));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045680465), Float.intBitsToFloat(1059451969),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(21));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043331730), Float.intBitsToFloat(1059642757),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(22));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040982995), Float.intBitsToFloat(1059833544),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(23));
    assertEquals(new Rectangle(Float.intBitsToFloat(1037081127), Float.intBitsToFloat(1060024332),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(24));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035554826), Float.intBitsToFloat(1059437148),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(25));
    assertEquals(new Rectangle(Float.intBitsToFloat(1034028526), Float.intBitsToFloat(1058849964),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(26));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032502226), Float.intBitsToFloat(1058262780),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(27));
    assertEquals(new Rectangle(Float.intBitsToFloat(1030153066), Float.intBitsToFloat(1057675596),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(28));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035673396), Float.intBitsToFloat(1057484808),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(29));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040279129), Float.intBitsToFloat(1057294021),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(30));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042627865), Float.intBitsToFloat(1057103233),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(31));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044976599), Float.intBitsToFloat(1056860284),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(32));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047325335), Float.intBitsToFloat(1056215702),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(33));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044976600), Float.intBitsToFloat(1055834127),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(34));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042627865), Float.intBitsToFloat(1055452552),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(35));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040279130), Float.intBitsToFloat(1055070976),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(36));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035673398), Float.intBitsToFloat(1054689401),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(37));
    assertEquals(new Rectangle(Float.intBitsToFloat(1030153072), Float.intBitsToFloat(1054307826),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(38));
    assertEquals(new Rectangle(Float.intBitsToFloat(1032502229), Float.intBitsToFloat(1053133458),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(39));
    assertEquals(new Rectangle(Float.intBitsToFloat(1034028530), Float.intBitsToFloat(1051959091),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(40));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035554831), Float.intBitsToFloat(1050784724),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(41));
    assertEquals(new Rectangle(Float.intBitsToFloat(1037081132), Float.intBitsToFloat(1049610356),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(42));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040982997), Float.intBitsToFloat(1049991931),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(43));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043331732), Float.intBitsToFloat(1050373506),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(44));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045680467), Float.intBitsToFloat(1050755082),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(45));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048029201), Float.intBitsToFloat(1051136657),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(46));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049631559), Float.intBitsToFloat(1051305456),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(47));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048905760), Float.intBitsToFloat(1050306479),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(48));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047783923), Float.intBitsToFloat(1049307502),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(49));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046332324), Float.intBitsToFloat(1048041053),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(50));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044880726), Float.intBitsToFloat(1046043099),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(51));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043429128), Float.intBitsToFloat(1044045145),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(52));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045427081), Float.intBitsToFloat(1042593547),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(53));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047425035), Float.intBitsToFloat(1041141949),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(54));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048999494), Float.intBitsToFloat(1039193310),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(55));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049998470), Float.intBitsToFloat(1036290114),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(56));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050724269), Float.intBitsToFloat(1040236707),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(57));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051450068), Float.intBitsToFloat(1042234660),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(58));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052175867), Float.intBitsToFloat(1044232613),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(59));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052901666), Float.intBitsToFloat(1046230567),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(60));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053877600), Float.intBitsToFloat(1048065973),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(61));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053877600), Float.intBitsToFloat(1045596366),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(62));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053877600), Float.intBitsToFloat(1043126760),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(63));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053877600), Float.intBitsToFloat(1040657153),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(64));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053877600), Float.intBitsToFloat(1036187702),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(65));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053877600), Float.intBitsToFloat(1030698196),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(66));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055112403), Float.intBitsToFloat(1030698196),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(67));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056347206), Float.intBitsToFloat(1030698196),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(68));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057273309), Float.intBitsToFloat(1030698196),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(69));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057890710), Float.intBitsToFloat(1030698196),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(70));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057890710), Float.intBitsToFloat(1036187702),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(71));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057890710), Float.intBitsToFloat(1040657153),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(72));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057890710), Float.intBitsToFloat(1043126760),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(73));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057890710), Float.intBitsToFloat(1045596366),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(74));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058015778), Float.intBitsToFloat(1048228521),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(75));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058378678), Float.intBitsToFloat(1046230567),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(76));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058741577), Float.intBitsToFloat(1044232613),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(77));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059104477), Float.intBitsToFloat(1042234660),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(78));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059467376), Float.intBitsToFloat(1040236707),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(79));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059830276), Float.intBitsToFloat(1036290116),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(80));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060329765), Float.intBitsToFloat(1039193314),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(81));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060829253), Float.intBitsToFloat(1041141951),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(82));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061328741), Float.intBitsToFloat(1042593549),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(83));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061828230), Float.intBitsToFloat(1044045148),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(84));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061465330), Float.intBitsToFloat(1046043101),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(85));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061102431), Float.intBitsToFloat(1048041055),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(86));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060739531), Float.intBitsToFloat(1049307503),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(87));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060376632), Float.intBitsToFloat(1050306480),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(88));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060091026), Float.intBitsToFloat(1051518232),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(89));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060678210), Float.intBitsToFloat(1051136657),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(90));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061265394), Float.intBitsToFloat(1050755082),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(91));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061852577), Float.intBitsToFloat(1050373506),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(92));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062439761), Float.intBitsToFloat(1049991931),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(93));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063026945), Float.intBitsToFloat(1049610356),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(94));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063217732), Float.intBitsToFloat(1050784724),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(95));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063408520), Float.intBitsToFloat(1051959091),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(96));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063599308), Float.intBitsToFloat(1053133458),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(97));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063790095), Float.intBitsToFloat(1054307826),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(98));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063202911), Float.intBitsToFloat(1054689401),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(99));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062615727), Float.intBitsToFloat(1055070976),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(100));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062028544), Float.intBitsToFloat(1055452552),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(101));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061441360), Float.intBitsToFloat(1055834127),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(102));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060854176), Float.intBitsToFloat(1056478710),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(103));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061441360), Float.intBitsToFloat(1056860286),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(104));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062028544), Float.intBitsToFloat(1057103234),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(105));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062615727), Float.intBitsToFloat(1057294022),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(106));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063202911), Float.intBitsToFloat(1057484809),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(107));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063790095), Float.intBitsToFloat(1057675597),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(108));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063599308), Float.intBitsToFloat(1058262781),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(109));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063408520), Float.intBitsToFloat(1058849965),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(110));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063217732), Float.intBitsToFloat(1059437149),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(111));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063026945), Float.intBitsToFloat(1060024333),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(112));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062439761), Float.intBitsToFloat(1059833545),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(113));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061852577), Float.intBitsToFloat(1059642758),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(114));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061265394), Float.intBitsToFloat(1059451970),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(115));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060678210), Float.intBitsToFloat(1059261183),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(116));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060013732), Float.intBitsToFloat(1059176783),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(117));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060376632), Float.intBitsToFloat(1059676271),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(118));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060739531), Float.intBitsToFloat(1060175759),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(119));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061102431), Float.intBitsToFloat(1060675247),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(120));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061465330), Float.intBitsToFloat(1061174736),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(121));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061828230), Float.intBitsToFloat(1061674224),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(122));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061328741), Float.intBitsToFloat(1062037123),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(123));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060829253), Float.intBitsToFloat(1062400023),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(124));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060329765), Float.intBitsToFloat(1062762923),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(125));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059830276), Float.intBitsToFloat(1063125822),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(126));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059467376), Float.intBitsToFloat(1062626334),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(127));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059104477), Float.intBitsToFloat(1062126845),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(128));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058741577), Float.intBitsToFloat(1061627357),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(129));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058378678), Float.intBitsToFloat(1061127869),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(130));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057890710), Float.intBitsToFloat(1060669017),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(131));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057890710), Float.intBitsToFloat(1061286419),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(132));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057890710), Float.intBitsToFloat(1061903820),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(133));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057890710), Float.intBitsToFloat(1062521222),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(134));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057890710), Float.intBitsToFloat(1063138623),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(135));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057890710), Float.intBitsToFloat(1063756025),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(136));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057273309), Float.intBitsToFloat(1063756025),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(137));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056347206), Float.intBitsToFloat(1063756025),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(138));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055112403), Float.intBitsToFloat(1063756025),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(139));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056347206), Float.intBitsToFloat(1063138623),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(140));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056347206), Float.intBitsToFloat(1062521222),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(141));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056347206), Float.intBitsToFloat(1061903820),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(142));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056347206), Float.intBitsToFloat(1061286419),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(143));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048726316), Float.intBitsToFloat(1061900535),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(144));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049452115), Float.intBitsToFloat(1061401046),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(145));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050177914), Float.intBitsToFloat(1060901558),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(146));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050903713), Float.intBitsToFloat(1060402069),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(147));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038725996), Float.intBitsToFloat(1058659176),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(148));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041805429), Float.intBitsToFloat(1058468389),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(149));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044154165), Float.intBitsToFloat(1058277601),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(150));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046502900), Float.intBitsToFloat(1058086814),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(151));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038726000), Float.intBitsToFloat(1052340666),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(152));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041805431), Float.intBitsToFloat(1052722241),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(153));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044154167), Float.intBitsToFloat(1053103817),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(154));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046502901), Float.intBitsToFloat(1053485392),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(155));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048726316), Float.intBitsToFloat(1043139903),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(156));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049452115), Float.intBitsToFloat(1045137856),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(157));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050177914), Float.intBitsToFloat(1047135809),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(158));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050903713), Float.intBitsToFloat(1048854881),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(159));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056347206), Float.intBitsToFloat(1036187702),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(160));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056347206), Float.intBitsToFloat(1040657153),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(161));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056347206), Float.intBitsToFloat(1043126760),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(162));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056347206), Float.intBitsToFloat(1045596366),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(163));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060466353), Float.intBitsToFloat(1043139904),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(164));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060103454), Float.intBitsToFloat(1045137857),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(165));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059740554), Float.intBitsToFloat(1047135811),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(166));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059377655), Float.intBitsToFloat(1048854881),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(167));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062821336), Float.intBitsToFloat(1052340666),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(168));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062234153), Float.intBitsToFloat(1052722241),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(169));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061646969), Float.intBitsToFloat(1053103817),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(170));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061059785), Float.intBitsToFloat(1053485392),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(171));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062821336), Float.intBitsToFloat(1058659177),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(172));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062234153), Float.intBitsToFloat(1058468390),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(173));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061646969), Float.intBitsToFloat(1058277602),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(174));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061059785), Float.intBitsToFloat(1058086815),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(175));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060466353), Float.intBitsToFloat(1061900535),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(176));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060103454), Float.intBitsToFloat(1061401046),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(177));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059740554), Float.intBitsToFloat(1060901558),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(178));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059377655), Float.intBitsToFloat(1060402070),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(179));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054495001), Float.intBitsToFloat(1064373427),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(180));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055729804), Float.intBitsToFloat(1064373427),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(181));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964608), Float.intBitsToFloat(1064373427),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(182));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057582009), Float.intBitsToFloat(1064373427),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(183));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042976507), Float.intBitsToFloat(1062355162),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(184));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044974460), Float.intBitsToFloat(1062718061),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(185));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046972414), Float.intBitsToFloat(1063080961),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(186));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048773183), Float.intBitsToFloat(1063443860),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(187));
    assertEquals(new Rectangle(Float.intBitsToFloat(1021158667), Float.intBitsToFloat(1058159975),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(188));
    assertEquals(new Rectangle(Float.intBitsToFloat(1025337024), Float.intBitsToFloat(1058747159),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(189));
    assertEquals(new Rectangle(Float.intBitsToFloat(1028389624), Float.intBitsToFloat(1059334343),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(190));
    assertEquals(new Rectangle(Float.intBitsToFloat(1031442226), Float.intBitsToFloat(1059921527),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(191));
    assertEquals(new Rectangle(Float.intBitsToFloat(1031442236), Float.intBitsToFloat(1049815965),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(192));
    assertEquals(new Rectangle(Float.intBitsToFloat(1028389632), Float.intBitsToFloat(1050990332),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(193));
    assertEquals(new Rectangle(Float.intBitsToFloat(1025337030), Float.intBitsToFloat(1052164700),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(194));
    assertEquals(new Rectangle(Float.intBitsToFloat(1021158681), Float.intBitsToFloat(1053339067),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(195));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048773183), Float.intBitsToFloat(1033745804),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(196));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046972414), Float.intBitsToFloat(1036649000),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(197));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044974460), Float.intBitsToFloat(1039552196),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(198));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042976507), Float.intBitsToFloat(1041321392),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(199));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057582009), Float.intBitsToFloat(1018229367),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(200));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964608), Float.intBitsToFloat(1018229367),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(201));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055729804), Float.intBitsToFloat(1018229367),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(202));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054495001), Float.intBitsToFloat(1018229367),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(203));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061941384), Float.intBitsToFloat(1041321397),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(204));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061441896), Float.intBitsToFloat(1039552204),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(205));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060942408), Float.intBitsToFloat(1036649008),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(206));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060442920), Float.intBitsToFloat(1033745810),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(207));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064281885), Float.intBitsToFloat(1053339067),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(208));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064091098), Float.intBitsToFloat(1052164700),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(209));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063900310), Float.intBitsToFloat(1050990332),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(210));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063709523), Float.intBitsToFloat(1049815965),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(211));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063709523), Float.intBitsToFloat(1059921528),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(212));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063900310), Float.intBitsToFloat(1059334344),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(213));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064091098), Float.intBitsToFloat(1058747160),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(214));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064281885), Float.intBitsToFloat(1058159976),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(215));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060442920), Float.intBitsToFloat(1063443860),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(216));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060942408), Float.intBitsToFloat(1063080961),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(217));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061441896), Float.intBitsToFloat(1062718061),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(218));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061941384), Float.intBitsToFloat(1062355162),
        Float.intBitsToFloat(1024899993), Float.intBitsToFloat(1024899993)),
        gridBoardLayout.boardIndexToBoundsMap.get(219));

    // test with 12 players
    board = new Board(12);
    gridBoardLayout = new GridBoardLayout(board);
    assertEquals(new Rectangle(Float.intBitsToFloat(1054208351), Float.intBitsToFloat(1063855250),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(0));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054208351), Float.intBitsToFloat(1063303999),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(1));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054208351), Float.intBitsToFloat(1062752747),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(2));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054208351), Float.intBitsToFloat(1062201496),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(3));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054208351), Float.intBitsToFloat(1061650244),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(4));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053912937), Float.intBitsToFloat(1061059414),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(5));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053361685), Float.intBitsToFloat(1061536812),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(6));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052810434), Float.intBitsToFloat(1062014210),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(7));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052259183), Float.intBitsToFloat(1062491608),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(8));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051707931), Float.intBitsToFloat(1062969005),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(9));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051156680), Float.intBitsToFloat(1063446403),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(10));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050201884), Float.intBitsToFloat(1063170778),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(11));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049247089), Float.intBitsToFloat(1062895152),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(12));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048008587), Float.intBitsToFloat(1062619526),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(13));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046098995), Float.intBitsToFloat(1062343901),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(14));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047201498), Float.intBitsToFloat(1061866503),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(15));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048304001), Float.intBitsToFloat(1061389106),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(16));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048991252), Float.intBitsToFloat(1060911708),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(17));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049542503), Float.intBitsToFloat(1060434310),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(18));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049877496), Float.intBitsToFloat(1059848783),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(19));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048922700), Float.intBitsToFloat(1060124408),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(20));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047359809), Float.intBitsToFloat(1060400034),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(21));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045450218), Float.intBitsToFloat(1060675660),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(22));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043540627), Float.intBitsToFloat(1060951285),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(23));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041631036), Float.intBitsToFloat(1061226911),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(24));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040528534), Float.intBitsToFloat(1060749514),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(25));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038664670), Float.intBitsToFloat(1060272116),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(26));
    assertEquals(new Rectangle(Float.intBitsToFloat(1036459666), Float.intBitsToFloat(1059794718),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(27));
    assertEquals(new Rectangle(Float.intBitsToFloat(1034254660), Float.intBitsToFloat(1059317321),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(28));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038073842), Float.intBitsToFloat(1059041695),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(29));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041040208), Float.intBitsToFloat(1058766070),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(30));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042949799), Float.intBitsToFloat(1058490444),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(31));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044859389), Float.intBitsToFloat(1058214818),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(32));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046610669), Float.intBitsToFloat(1057791485),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(33));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044405663), Float.intBitsToFloat(1057791485),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(34));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042200657), Float.intBitsToFloat(1057791485),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(35));
    assertEquals(new Rectangle(Float.intBitsToFloat(1039803912), Float.intBitsToFloat(1057791485),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(36));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035393902), Float.intBitsToFloat(1057791485),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(37));
    assertEquals(new Rectangle(Float.intBitsToFloat(1030168997), Float.intBitsToFloat(1057791485),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(38));
    assertEquals(new Rectangle(Float.intBitsToFloat(1030168997), Float.intBitsToFloat(1057240233),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(39));
    assertEquals(new Rectangle(Float.intBitsToFloat(1030168997), Float.intBitsToFloat(1056413357),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(40));
    assertEquals(new Rectangle(Float.intBitsToFloat(1030168997), Float.intBitsToFloat(1055310854),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(41));
    assertEquals(new Rectangle(Float.intBitsToFloat(1030168997), Float.intBitsToFloat(1054208351),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(42));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035393902), Float.intBitsToFloat(1054208351),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(43));
    assertEquals(new Rectangle(Float.intBitsToFloat(1039803912), Float.intBitsToFloat(1054208351),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(44));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042200657), Float.intBitsToFloat(1054208351),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(45));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044405663), Float.intBitsToFloat(1054208351),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(46));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046768981), Float.intBitsToFloat(1053912936),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(47));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044859390), Float.intBitsToFloat(1053361685),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(48));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042949799), Float.intBitsToFloat(1052810433),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(49));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041040209), Float.intBitsToFloat(1052259182),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(50));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038073844), Float.intBitsToFloat(1051707930),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(51));
    assertEquals(new Rectangle(Float.intBitsToFloat(1034254662), Float.intBitsToFloat(1051156679),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(52));
    assertEquals(new Rectangle(Float.intBitsToFloat(1036459668), Float.intBitsToFloat(1050201883),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(53));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038664674), Float.intBitsToFloat(1049247088),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(54));
    assertEquals(new Rectangle(Float.intBitsToFloat(1040528536), Float.intBitsToFloat(1048008585),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(55));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041631039), Float.intBitsToFloat(1046098993),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(56));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043540630), Float.intBitsToFloat(1047201496),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(57));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045450221), Float.intBitsToFloat(1048303999),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(58));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047359811), Float.intBitsToFloat(1048991251),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(59));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048922701), Float.intBitsToFloat(1049542503),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(60));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050093754), Float.intBitsToFloat(1049877497),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(61));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049542503), Float.intBitsToFloat(1048922701),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(62));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048991251), Float.intBitsToFloat(1047359811),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(63));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048303999), Float.intBitsToFloat(1045450221),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(64));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047201496), Float.intBitsToFloat(1043540630),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(65));
    assertEquals(new Rectangle(Float.intBitsToFloat(1046098993), Float.intBitsToFloat(1041631039),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(66));
    assertEquals(new Rectangle(Float.intBitsToFloat(1048008585), Float.intBitsToFloat(1040528536),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(67));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049247088), Float.intBitsToFloat(1038664674),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(68));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050201883), Float.intBitsToFloat(1036459668),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(69));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051156679), Float.intBitsToFloat(1034254662),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(70));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051707930), Float.intBitsToFloat(1038073844),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(71));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052259182), Float.intBitsToFloat(1041040209),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(72));
    assertEquals(new Rectangle(Float.intBitsToFloat(1052810433), Float.intBitsToFloat(1042949799),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(73));
    assertEquals(new Rectangle(Float.intBitsToFloat(1053361685), Float.intBitsToFloat(1044859390),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(74));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054208351), Float.intBitsToFloat(1046610669),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(75));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054208351), Float.intBitsToFloat(1044405663),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(76));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054208351), Float.intBitsToFloat(1042200657),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(77));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054208351), Float.intBitsToFloat(1039803912),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(78));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054208351), Float.intBitsToFloat(1035393902),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(79));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054208351), Float.intBitsToFloat(1030168997),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(80));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055310854), Float.intBitsToFloat(1030168997),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(81));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056413357), Float.intBitsToFloat(1030168997),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(82));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057240233), Float.intBitsToFloat(1030168997),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(83));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057791485), Float.intBitsToFloat(1030168997),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(84));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057791485), Float.intBitsToFloat(1035393902),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(85));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057791485), Float.intBitsToFloat(1039803912),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(86));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057791485), Float.intBitsToFloat(1042200657),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(87));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057791485), Float.intBitsToFloat(1044405663),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(88));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057939192), Float.intBitsToFloat(1046768981),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(89));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058214818), Float.intBitsToFloat(1044859389),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(90));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058490443), Float.intBitsToFloat(1042949799),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(91));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058766069), Float.intBitsToFloat(1041040208),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(92));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059041694), Float.intBitsToFloat(1038073842),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(93));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059317320), Float.intBitsToFloat(1034254660),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(94));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059794717), Float.intBitsToFloat(1036459666),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(95));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060272115), Float.intBitsToFloat(1038664670),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(96));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060749513), Float.intBitsToFloat(1040528533),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(97));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061226910), Float.intBitsToFloat(1041631036),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(98));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060951284), Float.intBitsToFloat(1043540627),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(99));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060675659), Float.intBitsToFloat(1045450218),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(100));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060400033), Float.intBitsToFloat(1047359809),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(101));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060124408), Float.intBitsToFloat(1048922700),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(102));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059956912), Float.intBitsToFloat(1050093756),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(103));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060434310), Float.intBitsToFloat(1049542505),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(104));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060911708), Float.intBitsToFloat(1048991254),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(105));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061389106), Float.intBitsToFloat(1048304005),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(106));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061866503), Float.intBitsToFloat(1047201501),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(107));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062343901), Float.intBitsToFloat(1046098999),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(108));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062619526), Float.intBitsToFloat(1048008591),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(109));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062895152), Float.intBitsToFloat(1049247091),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(110));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063170778), Float.intBitsToFloat(1050201886),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(111));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063446403), Float.intBitsToFloat(1051156682),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(112));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062969005), Float.intBitsToFloat(1051707933),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(113));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062491608), Float.intBitsToFloat(1052259185),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(114));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062014210), Float.intBitsToFloat(1052810436),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(115));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061536812), Float.intBitsToFloat(1053361687),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(116));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061098993), Float.intBitsToFloat(1054208351),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(117));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061650244), Float.intBitsToFloat(1054208351),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(118));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062201496), Float.intBitsToFloat(1054208351),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(119));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062752747), Float.intBitsToFloat(1054208351),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(120));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063303999), Float.intBitsToFloat(1054208351),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(121));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063855250), Float.intBitsToFloat(1054208351),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(122));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063855250), Float.intBitsToFloat(1055310854),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(123));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063855250), Float.intBitsToFloat(1056413357),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(124));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063855250), Float.intBitsToFloat(1057240233),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(125));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063855250), Float.intBitsToFloat(1057791485),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(126));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063303999), Float.intBitsToFloat(1057791485),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(127));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062752747), Float.intBitsToFloat(1057791485),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(128));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062201496), Float.intBitsToFloat(1057791485),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(129));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061650244), Float.intBitsToFloat(1057791485),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(130));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061059414), Float.intBitsToFloat(1057939192),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(131));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061536812), Float.intBitsToFloat(1058214818),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(132));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062014210), Float.intBitsToFloat(1058490443),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(133));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062491608), Float.intBitsToFloat(1058766069),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(134));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062969005), Float.intBitsToFloat(1059041694),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(135));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063446403), Float.intBitsToFloat(1059317320),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(136));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063170778), Float.intBitsToFloat(1059794717),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(137));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062895152), Float.intBitsToFloat(1060272115),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(138));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062619526), Float.intBitsToFloat(1060749513),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(139));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062343901), Float.intBitsToFloat(1061226910),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(140));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061866503), Float.intBitsToFloat(1060951284),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(141));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061389106), Float.intBitsToFloat(1060675659),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(142));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060911708), Float.intBitsToFloat(1060400033),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(143));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060434310), Float.intBitsToFloat(1060124408),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(144));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059848782), Float.intBitsToFloat(1059956912),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(145));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060124408), Float.intBitsToFloat(1060434310),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(146));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060400033), Float.intBitsToFloat(1060911708),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(147));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060675659), Float.intBitsToFloat(1061389106),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(148));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060951284), Float.intBitsToFloat(1061866503),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(149));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061226910), Float.intBitsToFloat(1062343901),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(150));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060749513), Float.intBitsToFloat(1062619526),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(151));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060272115), Float.intBitsToFloat(1062895152),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(152));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059794717), Float.intBitsToFloat(1063170778),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(153));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059317320), Float.intBitsToFloat(1063446403),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(154));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059041694), Float.intBitsToFloat(1062969005),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(155));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058766069), Float.intBitsToFloat(1062491608),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(156));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058490443), Float.intBitsToFloat(1062014210),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(157));
    assertEquals(new Rectangle(Float.intBitsToFloat(1058214818), Float.intBitsToFloat(1061536812),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(158));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057791485), Float.intBitsToFloat(1061098993),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(159));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057791485), Float.intBitsToFloat(1061650244),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(160));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057791485), Float.intBitsToFloat(1062201496),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(161));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057791485), Float.intBitsToFloat(1062752747),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(162));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057791485), Float.intBitsToFloat(1063303999),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(163));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057791485), Float.intBitsToFloat(1063855250),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(164));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057240233), Float.intBitsToFloat(1063855250),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(165));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056413357), Float.intBitsToFloat(1063855250),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(166));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055310854), Float.intBitsToFloat(1063855250),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(167));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056413357), Float.intBitsToFloat(1063303999),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(168));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056413357), Float.intBitsToFloat(1062752747),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(169));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056413357), Float.intBitsToFloat(1062201496),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(170));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056413357), Float.intBitsToFloat(1061650244),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(171));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049798340), Float.intBitsToFloat(1062417754),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(172));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050349592), Float.intBitsToFloat(1061940357),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(173));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050900843), Float.intBitsToFloat(1061462959),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(174));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051452095), Float.intBitsToFloat(1060985561),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(175));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041335622), Float.intBitsToFloat(1059996490),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(176));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043245213), Float.intBitsToFloat(1059720865),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(177));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045154803), Float.intBitsToFloat(1059445239),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(178));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047064395), Float.intBitsToFloat(1059169613),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(179));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035393902), Float.intBitsToFloat(1056413357),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(180));
    assertEquals(new Rectangle(Float.intBitsToFloat(1039803912), Float.intBitsToFloat(1056413357),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(181));
    assertEquals(new Rectangle(Float.intBitsToFloat(1042200657), Float.intBitsToFloat(1056413357),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(182));
    assertEquals(new Rectangle(Float.intBitsToFloat(1044405663), Float.intBitsToFloat(1056413357),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(183));
    assertEquals(new Rectangle(Float.intBitsToFloat(1041335624), Float.intBitsToFloat(1049798339),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(184));
    assertEquals(new Rectangle(Float.intBitsToFloat(1043245215), Float.intBitsToFloat(1050349591),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(185));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045154805), Float.intBitsToFloat(1050900842),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(186));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047064396), Float.intBitsToFloat(1051452094),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(187));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049798339), Float.intBitsToFloat(1041335624),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(188));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050349591), Float.intBitsToFloat(1043245215),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(189));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050900842), Float.intBitsToFloat(1045154805),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(190));
    assertEquals(new Rectangle(Float.intBitsToFloat(1051452094), Float.intBitsToFloat(1047064396),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(191));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056413357), Float.intBitsToFloat(1035393902),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(192));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056413357), Float.intBitsToFloat(1039803912),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(193));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056413357), Float.intBitsToFloat(1042200657),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(194));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056413357), Float.intBitsToFloat(1044405663),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(195));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059996489), Float.intBitsToFloat(1041335622),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(196));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059720864), Float.intBitsToFloat(1043245213),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(197));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059445238), Float.intBitsToFloat(1045154803),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(198));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059169612), Float.intBitsToFloat(1047064395),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(199));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062417754), Float.intBitsToFloat(1049798342),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(200));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061940357), Float.intBitsToFloat(1050349593),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(201));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061462959), Float.intBitsToFloat(1050900845),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(202));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060985561), Float.intBitsToFloat(1051452096),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(203));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063303999), Float.intBitsToFloat(1056413357),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(204));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062752747), Float.intBitsToFloat(1056413357),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(205));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062201496), Float.intBitsToFloat(1056413357),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(206));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061650244), Float.intBitsToFloat(1056413357),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(207));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062417754), Float.intBitsToFloat(1059996489),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(208));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061940357), Float.intBitsToFloat(1059720864),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(209));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061462959), Float.intBitsToFloat(1059445238),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(210));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060985561), Float.intBitsToFloat(1059169612),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(211));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059996489), Float.intBitsToFloat(1062417754),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(212));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059720864), Float.intBitsToFloat(1061940357),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(213));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059445238), Float.intBitsToFloat(1061462959),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(214));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059169612), Float.intBitsToFloat(1060985561),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(215));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054759603), Float.intBitsToFloat(1064406502),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(216));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055862106), Float.intBitsToFloat(1064406502),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(217));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964608), Float.intBitsToFloat(1064406502),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(218));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057515859), Float.intBitsToFloat(1064406502),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(219));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045951287), Float.intBitsToFloat(1062959111),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(220));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047860877), Float.intBitsToFloat(1063234737),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(221));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049173235), Float.intBitsToFloat(1063510363),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(222));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050128030), Float.intBitsToFloat(1063785989),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(223));
    assertEquals(new Rectangle(Float.intBitsToFloat(1031277173), Float.intBitsToFloat(1059831645),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(224));
    assertEquals(new Rectangle(Float.intBitsToFloat(1033742984), Float.intBitsToFloat(1060309043),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(225));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035947990), Float.intBitsToFloat(1060786441),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(226));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038152994), Float.intBitsToFloat(1061263839),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(227));
    assertEquals(new Rectangle(Float.intBitsToFloat(1019287770), Float.intBitsToFloat(1054759603),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(228));
    assertEquals(new Rectangle(Float.intBitsToFloat(1019287770), Float.intBitsToFloat(1055862106),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(229));
    assertEquals(new Rectangle(Float.intBitsToFloat(1019287770), Float.intBitsToFloat(1056964608),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(230));
    assertEquals(new Rectangle(Float.intBitsToFloat(1019287770), Float.intBitsToFloat(1057515859),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(231));
    assertEquals(new Rectangle(Float.intBitsToFloat(1038152998), Float.intBitsToFloat(1045951287),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(232));
    assertEquals(new Rectangle(Float.intBitsToFloat(1035947994), Float.intBitsToFloat(1047860877),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(233));
    assertEquals(new Rectangle(Float.intBitsToFloat(1033742988), Float.intBitsToFloat(1049173235),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(234));
    assertEquals(new Rectangle(Float.intBitsToFloat(1031277179), Float.intBitsToFloat(1050128030),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(235));
    assertEquals(new Rectangle(Float.intBitsToFloat(1050128030), Float.intBitsToFloat(1031277179),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(236));
    assertEquals(new Rectangle(Float.intBitsToFloat(1049173235), Float.intBitsToFloat(1033742988),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(237));
    assertEquals(new Rectangle(Float.intBitsToFloat(1047860877), Float.intBitsToFloat(1035947994),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(238));
    assertEquals(new Rectangle(Float.intBitsToFloat(1045951287), Float.intBitsToFloat(1038152998),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(239));
    assertEquals(new Rectangle(Float.intBitsToFloat(1057515859), Float.intBitsToFloat(1019287770),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(240));
    assertEquals(new Rectangle(Float.intBitsToFloat(1056964608), Float.intBitsToFloat(1019287770),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(241));
    assertEquals(new Rectangle(Float.intBitsToFloat(1055862106), Float.intBitsToFloat(1019287770),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(242));
    assertEquals(new Rectangle(Float.intBitsToFloat(1054759603), Float.intBitsToFloat(1019287770),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(243));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061263838), Float.intBitsToFloat(1038152994),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(244));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060786440), Float.intBitsToFloat(1035947988),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(245));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060309042), Float.intBitsToFloat(1033742984),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(246));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059831644), Float.intBitsToFloat(1031277173),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(247));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063785988), Float.intBitsToFloat(1050128032),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(248));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063510363), Float.intBitsToFloat(1049173237),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(249));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063234737), Float.intBitsToFloat(1047860881),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(250));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062959112), Float.intBitsToFloat(1045951291),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(251));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064406502), Float.intBitsToFloat(1057515859),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(252));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064406502), Float.intBitsToFloat(1056964608),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(253));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064406502), Float.intBitsToFloat(1055862106),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(254));
    assertEquals(new Rectangle(Float.intBitsToFloat(1064406502), Float.intBitsToFloat(1054759603),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(255));
    assertEquals(new Rectangle(Float.intBitsToFloat(1062959112), Float.intBitsToFloat(1061263838),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(256));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063234737), Float.intBitsToFloat(1060786440),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(257));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063510363), Float.intBitsToFloat(1060309042),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(258));
    assertEquals(new Rectangle(Float.intBitsToFloat(1063785988), Float.intBitsToFloat(1059831644),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(259));
    assertEquals(new Rectangle(Float.intBitsToFloat(1059831644), Float.intBitsToFloat(1063785988),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(260));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060309042), Float.intBitsToFloat(1063510363),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(261));
    assertEquals(new Rectangle(Float.intBitsToFloat(1060786440), Float.intBitsToFloat(1063234737),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(262));
    assertEquals(new Rectangle(Float.intBitsToFloat(1061263838), Float.intBitsToFloat(1062959112),
        Float.intBitsToFloat(1023841590), Float.intBitsToFloat(1023841590)),
        gridBoardLayout.boardIndexToBoundsMap.get(263));

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
