/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.exit104.maurersmarbles.Card.Rank;
import com.exit104.maurersmarbles.Card.Suit;
import com.exit104.maurersmarbles.event.CannotPlayGameEvent;
import com.exit104.maurersmarbles.event.DealtCardGameEvent;
import com.exit104.maurersmarbles.event.EnteringStateGameEvent;
import com.exit104.maurersmarbles.event.Event;
import com.exit104.maurersmarbles.event.ExecutedPlayGameEvent;
import com.exit104.maurersmarbles.event.ShuffledCardDeckGameEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The GameStatsTest class contains the unit tests for the GameStats class.
 *
 * @author Daniel Uppenkamp
 */
public class GameStatsTest {

  public GameStatsTest() {
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
   * Test of constructor method, of class GameStats.
   */
  @Test
  public void testGameStats() {

    System.out.println("constructor");

    // test with null game
    Game game = null;
    try {
      new GameStats(game);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    game = new Game(4);
    new GameStats(game);

  }

  /**
   * Test of getCardDecksShuffled method, of class GameStats.
   */
  @Test
  public void testGetCardDecksShuffled() {

    System.out.println("getCardDecksShuffled");

    // test with invalid player number
    Game game = new Game(4);
    GameStats instance = new GameStats(game);
    int playerNumber = -1;
    try {
      instance.getCardDecksShuffled(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid player number
    game = new Game(4);
    instance = new GameStats(game);
    playerNumber = 4;
    try {
      instance.getCardDecksShuffled(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with new game
    game = new Game(4);
    instance = new GameStats(game);
    playerNumber = 0;
    int expResult = 0;
    int result = instance.getCardDecksShuffled(playerNumber);
    assertEquals(expResult, result);

    // test after event
    game = new Game(4);
    instance = new GameStats(game);
    playerNumber = 1;
    instance.handleEvent(new ShuffledCardDeckGameEvent(game, 1));
    expResult = 1;
    result = instance.getCardDecksShuffled(playerNumber);
    assertEquals(expResult, result);

  }

  /**
   * Test of getCardsDealt method, of class GameStats.
   */
  @Test
  public void testGetCardsDealt() {

    System.out.println("getCardsDealt");

    // test with invalid player number
    Game game = new Game(4);
    GameStats instance = new GameStats(game);
    int playerNumber = -1;
    try {
      instance.getCardsDealt(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid player number
    game = new Game(4);
    instance = new GameStats(game);
    playerNumber = 4;
    try {
      instance.getCardsDealt(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with new game
    game = new Game(4);
    instance = new GameStats(game);
    playerNumber = 0;
    int expResult = 0;
    int result = instance.getCardsDealt(playerNumber);
    assertEquals(expResult, result);

    // test after event
    game = new Game(4);
    instance = new GameStats(game);
    playerNumber = 1;
    instance.handleEvent(new DealtCardGameEvent(game, 1, new Card(Rank.ACE, Suit.CLUBS), 2));
    expResult = 1;
    result = instance.getCardsDealt(playerNumber);
    assertEquals(expResult, result);

  }

  /**
   * Test of getCardsPlayed method, of class GameStats.
   */
  @Test
  public void testGetCardsPlayed() {

    System.out.println("getCardsPlayed");

    // test with null rank
    Game game = new Game(4);
    GameStats instance = new GameStats(game);
    Rank rank = null;
    try {
      instance.getCardsPlayed(rank);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with new game
    game = new Game(4);
    instance = new GameStats(game);
    rank = Rank.ACE;
    int expResult = 0;
    int result = instance.getCardsPlayed(rank);
    assertEquals(expResult, result);

    // test after event
    game = new Game(4);
    instance = new GameStats(game);
    rank = Rank.ACE;
    instance.handleEvent(new ExecutedPlayGameEvent(game, 1, new Play(new Card(Rank.ACE, Suit.CLUBS),
        new Move(0, 0, game.getBoard().getStartMinBoardIndex(1)))));
    expResult = 1;
    result = instance.getCardsPlayed(rank);
    assertEquals(expResult, result);

  }

  /**
   * Test of getMarblesKnocked method, of class GameStats.
   */
  @Test
  public void testGetMarblesKnocked() {

    System.out.println("getMarblesKnocked");

    // test with invalid player number
    Game game = new Game(4);
    GameStats instance = new GameStats(game);
    int playerNumber = -1;
    try {
      instance.getMarblesKnocked(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid player number
    game = new Game(4);
    instance = new GameStats(game);
    playerNumber = 4;
    try {
      instance.getMarblesKnocked(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with new game
    game = new Game(4);
    instance = new GameStats(game);
    playerNumber = 0;
    int expResult = 0;
    int result = instance.getMarblesKnocked(playerNumber);
    assertEquals(expResult, result);

    // test after event
    game = new Game(4);
    instance = new GameStats(game);
    playerNumber = 1;
    instance.handleEvent(new ExecutedPlayGameEvent(game, 1, new Play(new Card(Rank.ACE, Suit.CLUBS),
        new Move(0, 0, game.getBoard().getStartMinBoardIndex(1)))));
    expResult = 1;
    result = instance.getMarblesKnocked(playerNumber);
    assertEquals(expResult, result);

  }

  /**
   * Test of getMarblesMoved method, of class GameStats.
   */
  @Test
  public void testGetMarblesMoved() {

    System.out.println("getMarblesMoved");

    // test with invalid player number
    Game game = new Game(4);
    GameStats instance = new GameStats(game);
    int playerNumber = -1;
    try {
      instance.getMarblesMoved(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid player number
    game = new Game(4);
    instance = new GameStats(game);
    playerNumber = 4;
    try {
      instance.getMarblesMoved(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with new game
    game = new Game(4);
    instance = new GameStats(game);
    playerNumber = 0;
    int expResult = 0;
    int result = instance.getMarblesMoved(playerNumber);
    assertEquals(expResult, result);

    // test after event
    game = new Game(4);
    instance = new GameStats(game);
    playerNumber = 1;
    instance.handleEvent(new ExecutedPlayGameEvent(game, 1, new Play(new Card(Rank.ACE, Suit.CLUBS),
        new Move(0, 0, game.getBoard().getStartMinBoardIndex(1)))));
    expResult = 1;
    result = instance.getMarblesMoved(playerNumber);
    assertEquals(expResult, result);

  }

  /**
   * Test of getPlayerCannotPlay method, of class GameStats.
   */
  @Test
  public void testGetPlayerCannotPlay() {

    System.out.println("getPlayerCannotPlay");

    // test with invalid player number
    Game game = new Game(4);
    GameStats instance = new GameStats(game);
    int playerNumber = -1;
    try {
      instance.getPlayerCannotPlay(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid player number
    game = new Game(4);
    instance = new GameStats(game);
    playerNumber = 4;
    try {
      instance.getPlayerCannotPlay(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with new game
    game = new Game(4);
    instance = new GameStats(game);
    playerNumber = 0;
    int expResult = 0;
    int result = instance.getPlayerCannotPlay(playerNumber);
    assertEquals(expResult, result);

    // test after event
    game = new Game(4);
    instance = new GameStats(game);
    playerNumber = 1;
    instance.handleEvent(new CannotPlayGameEvent(game, 1));
    expResult = 1;
    result = instance.getPlayerCannotPlay(playerNumber);
    assertEquals(expResult, result);

  }

  /**
   * Test of getPlaysExecuted method, of class GameStats.
   */
  @Test
  public void testGetPlaysExecuted() {

    System.out.println("getPlaysExecuted");

    // test with invalid player number
    Game game = new Game(4);
    GameStats instance = new GameStats(game);
    int playerNumber = -1;
    try {
      instance.getPlaysExecuted(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid player number
    game = new Game(4);
    instance = new GameStats(game);
    playerNumber = 4;
    try {
      instance.getPlaysExecuted(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with new game
    game = new Game(4);
    instance = new GameStats(game);
    playerNumber = 0;
    int expResult = 0;
    int result = instance.getPlaysExecuted(playerNumber);
    assertEquals(expResult, result);

    // test after event
    game = new Game(4);
    instance = new GameStats(game);
    playerNumber = 1;
    instance.handleEvent(new ExecutedPlayGameEvent(game, 1, new Play(new Card(Rank.ACE, Suit.CLUBS),
        new Move(0, 0, game.getBoard().getStartMinBoardIndex(1)))));
    expResult = 1;
    result = instance.getPlaysExecuted(playerNumber);
    assertEquals(expResult, result);

  }

  /**
   * Test of getTotalCardDecksShuffled method, of class GameStats.
   */
  @Test
  public void testGetTotalCardDecksShuffled() {

    System.out.println("getTotalCardDecksShuffled");

    // test with new game
    Game game = new Game(4);
    GameStats instance = new GameStats(game);
    int expResult = 0;
    int result = instance.getTotalCardDecksShuffled();
    assertEquals(expResult, result);

    // test after event
    game = new Game(4);
    instance = new GameStats(game);
    instance.handleEvent(new ShuffledCardDeckGameEvent(game, 0));
    instance.handleEvent(new ShuffledCardDeckGameEvent(game, 1));
    instance.handleEvent(new ShuffledCardDeckGameEvent(game, 2));
    instance.handleEvent(new ShuffledCardDeckGameEvent(game, 3));
    expResult = 4;
    result = instance.getTotalCardDecksShuffled();
    assertEquals(expResult, result);

  }

  /**
   * Test of getTotalCardsDealt method, of class GameStats.
   */
  @Test
  public void testGetTotalCardsDealt() {

    System.out.println("getTotalCardsDealt");

    // test with new game
    Game game = new Game(4);
    GameStats instance = new GameStats(game);
    int expResult = 0;
    int result = instance.getTotalCardsDealt();
    assertEquals(expResult, result);

    // test after event
    game = new Game(4);
    instance = new GameStats(game);
    instance.handleEvent(new DealtCardGameEvent(game, 0, new Card(Rank.ACE, Suit.CLUBS), 2));
    instance.handleEvent(new DealtCardGameEvent(game, 1, new Card(Rank.ACE, Suit.CLUBS), 2));
    instance.handleEvent(new DealtCardGameEvent(game, 2, new Card(Rank.ACE, Suit.CLUBS), 2));
    instance.handleEvent(new DealtCardGameEvent(game, 3, new Card(Rank.ACE, Suit.CLUBS), 2));
    expResult = 4;
    result = instance.getTotalCardsDealt();
    assertEquals(expResult, result);

  }

  /**
   * Test of getTotalCardsPlayed method, of class GameStats.
   */
  @Test
  public void testGetTotalCardsPlayed() {

    System.out.println("getTotalCardsPlayed");

    // test with new game
    Game game = new Game(4);
    GameStats instance = new GameStats(game);
    int expResult = 0;
    int result = instance.getTotalCardsPlayed();
    assertEquals(expResult, result);

    // test after event
    game = new Game(4);
    instance = new GameStats(game);
    instance.handleEvent(new ExecutedPlayGameEvent(game, 0, new Play(new Card(Rank.ACE, Suit.CLUBS),
        new Move(0, 0, game.getBoard().getStartMinBoardIndex(1)))));
    instance.handleEvent(new ExecutedPlayGameEvent(game, 1, new Play(new Card(Rank.ACE, Suit.CLUBS),
        new Move(0, 0, game.getBoard().getStartMinBoardIndex(1)))));
    instance.handleEvent(new ExecutedPlayGameEvent(game, 2, new Play(new Card(Rank.ACE, Suit.CLUBS),
        new Move(0, 0, game.getBoard().getStartMinBoardIndex(1)))));
    instance.handleEvent(new ExecutedPlayGameEvent(game, 3, new Play(new Card(Rank.ACE, Suit.CLUBS),
        new Move(0, 0, game.getBoard().getStartMinBoardIndex(1)))));
    expResult = 4;
    result = instance.getTotalCardsPlayed();
    assertEquals(expResult, result);

  }

  /**
   * Test of getTotalMarblesKnocked method, of class GameStats.
   */
  @Test
  public void testGetTotalMarblesKnocked() {

    System.out.println("getTotalMarblesKnocked");

    // test with new game
    Game game = new Game(4);
    GameStats instance = new GameStats(game);
    int expResult = 0;
    int result = instance.getTotalMarblesKnocked();
    assertEquals(expResult, result);

    // test after event
    game = new Game(4);
    instance = new GameStats(game);
    instance.handleEvent(new ExecutedPlayGameEvent(game, 0, new Play(new Card(Rank.ACE, Suit.CLUBS),
        new Move(0, 0, game.getBoard().getStartMinBoardIndex(1)))));
    instance.handleEvent(new ExecutedPlayGameEvent(game, 1, new Play(new Card(Rank.ACE, Suit.CLUBS),
        new Move(0, 0, game.getBoard().getStartMinBoardIndex(1)))));
    instance.handleEvent(new ExecutedPlayGameEvent(game, 2, new Play(new Card(Rank.ACE, Suit.CLUBS),
        new Move(0, 0, game.getBoard().getStartMinBoardIndex(1)))));
    instance.handleEvent(new ExecutedPlayGameEvent(game, 3, new Play(new Card(Rank.ACE, Suit.CLUBS),
        new Move(0, 0, game.getBoard().getStartMinBoardIndex(1)))));
    expResult = 4;
    result = instance.getTotalMarblesKnocked();
    assertEquals(expResult, result);

  }

  /**
   * Test of getTotalMarblesMoved method, of class GameStats.
   */
  @Test
  public void testGetTotalMarblesMoved() {

    System.out.println("getTotalMarblesMoved");

    // test with new game
    Game game = new Game(4);
    GameStats instance = new GameStats(game);
    int expResult = 0;
    int result = instance.getTotalMarblesMoved();
    assertEquals(expResult, result);

    // test after event
    game = new Game(4);
    instance = new GameStats(game);
    instance.handleEvent(new ExecutedPlayGameEvent(game, 0, new Play(new Card(Rank.ACE, Suit.CLUBS),
        new Move(0, 0, game.getBoard().getStartMinBoardIndex(1)))));
    instance.handleEvent(new ExecutedPlayGameEvent(game, 1, new Play(new Card(Rank.ACE, Suit.CLUBS),
        new Move(0, 0, game.getBoard().getStartMinBoardIndex(1)))));
    instance.handleEvent(new ExecutedPlayGameEvent(game, 2, new Play(new Card(Rank.ACE, Suit.CLUBS),
        new Move(0, 0, game.getBoard().getStartMinBoardIndex(1)))));
    instance.handleEvent(new ExecutedPlayGameEvent(game, 3, new Play(new Card(Rank.ACE, Suit.CLUBS),
        new Move(0, 0, game.getBoard().getStartMinBoardIndex(1)))));
    expResult = 4;
    result = instance.getTotalMarblesMoved();
    assertEquals(expResult, result);

  }

  /**
   * Test of getTotalPlayerCannotPlay method, of class GameStats.
   */
  @Test
  public void testGetTotalPlayerCannotPlay() {

    System.out.println("getTotalPlayerCannotPlay");

    // test with new game
    Game game = new Game(4);
    GameStats instance = new GameStats(game);
    int expResult = 0;
    int result = instance.getTotalPlayerCannotPlay();
    assertEquals(expResult, result);

    // test after event
    game = new Game(4);
    instance = new GameStats(game);
    instance.handleEvent(new CannotPlayGameEvent(game, 0));
    instance.handleEvent(new CannotPlayGameEvent(game, 1));
    instance.handleEvent(new CannotPlayGameEvent(game, 2));
    instance.handleEvent(new CannotPlayGameEvent(game, 3));
    expResult = 4;
    result = instance.getTotalPlayerCannotPlay();
    assertEquals(expResult, result);

  }

  /**
   * Test of getTotalPlaysExecuted method, of class GameStats.
   */
  @Test
  public void testGetTotalPlaysExecuted() {

    System.out.println("getTotalPlaysExecuted");

    // test with new game
    Game game = new Game(4);
    GameStats instance = new GameStats(game);
    int expResult = 0;
    int result = instance.getTotalPlaysExecuted();
    assertEquals(expResult, result);

    // test after event
    game = new Game(4);
    instance = new GameStats(game);
    instance.handleEvent(new ExecutedPlayGameEvent(game, 0, new Play(new Card(Rank.ACE, Suit.CLUBS),
        new Move(0, 0, game.getBoard().getStartMinBoardIndex(1)))));
    instance.handleEvent(new ExecutedPlayGameEvent(game, 1, new Play(new Card(Rank.ACE, Suit.CLUBS),
        new Move(0, 0, game.getBoard().getStartMinBoardIndex(1)))));
    instance.handleEvent(new ExecutedPlayGameEvent(game, 2, new Play(new Card(Rank.ACE, Suit.CLUBS),
        new Move(0, 0, game.getBoard().getStartMinBoardIndex(1)))));
    instance.handleEvent(new ExecutedPlayGameEvent(game, 3, new Play(new Card(Rank.ACE, Suit.CLUBS),
        new Move(0, 0, game.getBoard().getStartMinBoardIndex(1)))));
    expResult = 4;
    result = instance.getTotalPlaysExecuted();
    assertEquals(expResult, result);

  }

  /**
   * Test of handleEvent method, of class GameStats.
   */
  @Test
  public void testHandleEvent() {

    System.out.println("handleEvent");

    // handle an event that we don't care about
    Game game = new Game(4);
    Event event = new EnteringStateGameEvent(game, Game.State.DEAL_CARDS);
    GameStats instance = new GameStats(game);
    instance.handleEvent(event);

  }

  /**
   * Test of toString method, of class GameStats.
   */
  @Test
  public void testToString() {

    System.out.println("toString");

    Game game = new Game(4);
    GameStats instance = new GameStats(game);
    String result = instance.toString();
    assertTrue(result != null && !result.isEmpty());

  }

}
