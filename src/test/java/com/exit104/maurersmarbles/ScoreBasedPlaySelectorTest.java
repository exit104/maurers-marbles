/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.exit104.maurersmarbles.Card.Rank;
import com.exit104.maurersmarbles.Card.Suit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The ScoreBasedPlaySelectorTest class contains the unit tests for the ScoreBasedPlaySelector
 * class.
 *
 * @author Daniel Uppenkamp
 */
public class ScoreBasedPlaySelectorTest {

  public ScoreBasedPlaySelectorTest() {
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
   * Test of constructor method, of class ScoreBasedPlaySelector.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testScoreBasedPlaySelector() {

    System.out.println("constructor");

    // test with null game
    Game game = null;
    int playerNumber = 0;
    try {
      new ScoreBasedPlaySelector(game, playerNumber);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with invalid player number
    game = new Game(4);
    playerNumber = -1;
    try {
      new ScoreBasedPlaySelector(game, playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid player number
    game = new Game(4);
    playerNumber = 4;
    try {
      new ScoreBasedPlaySelector(game, playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with valid values
    game = new Game(4);
    playerNumber = 0;
    new ScoreBasedPlaySelector(game, playerNumber);

  }

  /**
   * Test of getScoreForMarble method, of class ScoreBasedPlaySelector.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testGetScoreForMarble() {

    System.out.println("getScoreForMarble");

    // test with null game
    Game game = null;
    Marble marble = null;
    try {
      ScoreBasedPlaySelector.getScoreForMarble(game, marble);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with null marble
    game = new Game(4);
    marble = null;
    try {
      ScoreBasedPlaySelector.getScoreForMarble(game, marble);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {

      int expResult;
      int result;

      // test marble in start space
      for (int i = 0; i < numberOfPlayers; i++) {
        game = new Game(numberOfPlayers);
        marble = game.getPlayers().get(i).getMarbles().get(0);
        expResult = game.getBoard().getNumberOfPerimeterSpaces() + 3;
        result = ScoreBasedPlaySelector.getScoreForMarble(game, marble);
        assertEquals(expResult, result);
      }

      // test marble in space before safe space
      for (int i = 0; i < numberOfPlayers; i++) {
        game = new Game(numberOfPlayers);
        game.getPlayers().get(i).getMarbles().get(0).setBoardIndex(
            game.getBoard().getHomeEntryBoardIndex(i) + 1);
        marble = game.getPlayers().get(i).getMarbles().get(0);
        expResult = game.getBoard().getNumberOfPerimeterSpaces() + 3;
        result = ScoreBasedPlaySelector.getScoreForMarble(game, marble);
        assertEquals(expResult, result);
      }

      // test marble in home space
      for (int i = 0; i < numberOfPlayers; i++) {
        for (int j = 0; j < game.getBoard().getNumberOfHomeSpacesPerPlayer(); j++) {
          game = new Game(numberOfPlayers);
          game.getPlayers().get(i).getMarbles().get(0).setBoardIndex(
              game.getBoard().getHomeMinBoardIndex(i) + j);
          marble = game.getPlayers().get(i).getMarbles().get(0);
          expResult = 3 - j;
          result = ScoreBasedPlaySelector.getScoreForMarble(game, marble);
          assertEquals(expResult, result);
        }
      }

      // test player marbles in safe space
      for (int i = 0; i < numberOfPlayers; i++) {
        game = new Game(numberOfPlayers);
        game.getPlayers().get(i).getMarbles().get(0).setBoardIndex(
            game.getBoard().getSafeBoardIndex(i));
        marble = game.getPlayers().get(i).getMarbles().get(0);
        expResult = game.getBoard().getNumberOfPerimeterSpaces() + 2;
        result = ScoreBasedPlaySelector.getScoreForMarble(game, marble);
        assertEquals(expResult, result);
      }

      // test player marbles just before home entry
      for (int i = 0; i < numberOfPlayers; i++) {
        game = new Game(numberOfPlayers);
        game.getPlayers().get(i).getMarbles().get(0).setBoardIndex(
            game.getBoard().getHomeEntryBoardIndex(i) - 2);
        marble = game.getPlayers().get(i).getMarbles().get(0);
        expResult = 6;
        result = ScoreBasedPlaySelector.getScoreForMarble(game, marble);
        assertEquals(expResult, result);
      }

    }

  }

  /**
   * Test of getScoreForPlay method, of class ScoreBasedPlaySelector.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testGetScoreForPlay() {

    System.out.println("getScoreForPlay");

    // test with null game
    Game game = null;
    int playerNumber = 0;
    Play play = null;
    try {
      ScoreBasedPlaySelector.getScoreForPlay(game, playerNumber, play);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with invalid player number
    game = new Game(4);
    playerNumber = -1;
    play = null;
    try {
      ScoreBasedPlaySelector.getScoreForPlay(game, playerNumber, play);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid player number
    game = new Game(4);
    playerNumber = 4;
    play = null;
    try {
      ScoreBasedPlaySelector.getScoreForPlay(game, playerNumber, play);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with null play
    game = new Game(4);
    playerNumber = 0;
    play = null;
    try {
      ScoreBasedPlaySelector.getScoreForPlay(game, playerNumber, play);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {

      int expResult;
      int result;

      for (int i = 0; i < numberOfPlayers; i++) {

        // test moving marble into player safe space
        game = new Game(numberOfPlayers);
        playerNumber = i;
        play = new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(i, 0,
            game.getBoard().getSafeBoardIndex(i)));
        expResult = 1;
        result = ScoreBasedPlaySelector.getScoreForPlay(game, playerNumber, play);
        assertEquals(expResult, result);

        // test moving marble player marble forward
        game = new Game(numberOfPlayers);
        game.getPlayers().get(i).getMarbles().get(0).setBoardIndex(
            game.getBoard().getSafeBoardIndex(i));
        playerNumber = i;
        play = new Play(new Card(Rank.TEN, Suit.CLUBS), new Move(i, 0,
            game.getBoard().getSafeBoardIndex(i) + 10));
        expResult = 10;
        result = ScoreBasedPlaySelector.getScoreForPlay(game, playerNumber, play);
        assertEquals(expResult, result);

        // test knocking opponent's marbles
        game = new Game(numberOfPlayers);
        game.getPlayers().get(i).getMarbles().get(0).setBoardIndex(
            game.getBoard().getSafeBoardIndex(i));
        game.getPlayers().get(game.getNextPlayerNumber(i)).getMarbles().get(0).setBoardIndex(
            game.getBoard().getSafeBoardIndex(i) + 2);
        playerNumber = i;
        Set<Move> moves = new LinkedHashSet<>();
        moves.add(new Move(i, 0, game.getBoard().getSafeBoardIndex(i) + 2));
        moves.add(new Move(game.getNextPlayerNumber(i), 0,
            game.getEmptyStartSpace(game.getNextPlayerNumber(i))));
        play = new Play(new Card(Rank.TWO, Suit.CLUBS), moves);
        expResult = 2 - 14 + game.getBoard().getNumberOfPerimeterSpaces() + 3;
        result = ScoreBasedPlaySelector.getScoreForPlay(game, playerNumber, play);
        assertEquals(expResult, result);

      }

    }

  }

  /**
   * Test of getScoreForPlayer method, of class ScoreBasedPlaySelector.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testGetScoreForPlayer() {

    System.out.println("getScoreForPlayer");

    // test with null game
    Game game = null;
    int playerNumber = 0;
    try {
      ScoreBasedPlaySelector.getScoreForPlayer(game, playerNumber);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with invalid player number
    game = new Game(4);
    playerNumber = -1;
    try {
      ScoreBasedPlaySelector.getScoreForPlayer(game, playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid player number
    game = new Game(4);
    playerNumber = 4;
    try {
      ScoreBasedPlaySelector.getScoreForPlayer(game, playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {

      int expResult;
      int result;

      // test marbles in start spaces
      for (int i = 0; i < numberOfPlayers; i++) {
        game = new Game(numberOfPlayers);
        playerNumber = i;
        expResult = (game.getBoard().getNumberOfPerimeterSpaces() + 3) * 4;
        result = ScoreBasedPlaySelector.getScoreForPlayer(game, playerNumber);
        assertEquals(expResult, result);
      }

    }

  }

  /**
   * Test of getScoreForTeam method, of class ScoreBasedPlaySelector.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testGetScoreForTeam() {

    System.out.println("getScoreForTeam");

    // test with null game
    Game game = null;
    int playerNumber = 0;
    try {
      ScoreBasedPlaySelector.getScoreForTeam(game, playerNumber);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with invalid player number
    game = new Game(4);
    playerNumber = -1;
    try {
      ScoreBasedPlaySelector.getScoreForTeam(game, playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid player number
    game = new Game(4);
    playerNumber = 4;
    try {
      ScoreBasedPlaySelector.getScoreForTeam(game, playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {

      int expResult;
      int result;

      // test marbles in start spaces
      for (int i = 0; i < numberOfPlayers / 2; i++) {
        game = new Game(numberOfPlayers);
        playerNumber = i;
        expResult = (game.getBoard().getNumberOfPerimeterSpaces() + 3) * 4 * 2;
        result = ScoreBasedPlaySelector.getScoreForTeam(game, playerNumber);
        assertEquals(expResult, result);
      }

    }

  }

  /**
   * Test of setAvailablePlays method, of class ScoreBasedPlaySelector.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testSetAvailablePlays() {

    System.out.println("setAvailablePlays");

    // test with null
    Game game = new Game(4);
    int playerNumber = 0;
    ScoreBasedPlaySelector instance = new ScoreBasedPlaySelector(game, playerNumber);
    Set<Play> plays = null;
    try {
      instance.setAvailablePlays(plays);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with empty set
    game = new Game(4);
    playerNumber = 0;
    instance = new ScoreBasedPlaySelector(game, playerNumber);
    plays = Collections.emptySet();
    try {
      instance.setAvailablePlays(plays);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with two plays to select from
    game = new Game(4);
    game.getPlayers().get(0).getMarbles().get(0).setBoardIndex(0);
    playerNumber = 0;
    instance = new ScoreBasedPlaySelector(game, playerNumber);
    plays = new LinkedHashSet<>();
    plays.add(new Play(new Card(Rank.TWO, Suit.CLUBS), new Move(0, 0, 2)));
    plays.add(new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 0, 1)));
    instance.setAvailablePlays(plays);
    assertEquals(plays.iterator().next(), instance.selectedPlay);

  }
}
