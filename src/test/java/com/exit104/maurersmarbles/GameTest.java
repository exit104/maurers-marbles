/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.exit104.maurersmarbles.Card.Rank;
import com.exit104.maurersmarbles.Card.Suit;
import com.exit104.maurersmarbles.Game.SplitCard;
import com.exit104.maurersmarbles.Game.State;
import com.exit104.maurersmarbles.event.CannotPlayGameEvent;
import com.exit104.maurersmarbles.event.Event;
import com.exit104.maurersmarbles.event.EventListener;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * The GameTest class contains the unit tests for the Game class.
 *
 * @author Daniel Uppenkamp
 */
public class GameTest {

  public GameTest() {
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
   * Test of constructor method, of class Game.
   */
  @Test
  public void testGame_int() {

    System.out.println("constructor");

    // test with invalid number of players
    try {
      new Game(1);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test new game state
    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {

      // make sure the players and player's marbles were properly initialized
      Game instance = new Game(numberOfPlayers);
      assertEquals(instance.getNumberOfPlayers(), instance.players.size());
      for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
        assertEquals(i, instance.players.get(i).getPlayerNumber());
        assertEquals(Game.NUMBER_OF_MARBLES_PER_PLAYER,
            instance.players.get(i).getMarbles().size());
        for (int j = 0; j < Game.NUMBER_OF_MARBLES_PER_PLAYER; j++) {
          assertEquals(i, instance.players.get(i).getMarbles().get(j).getPlayerNumber());
          assertEquals(j, instance.players.get(i).getMarbles().get(j).getMarbleNumber());
          assertEquals(instance.getBoard().getStartMinBoardIndex(i) + j,
              instance.players.get(i).getMarbles().get(j).getBoardIndex());
          assertEquals(Marble.NO_PREVIOUS_BOARD_INDEX,
              instance.players.get(i).getMarbles().get(j).getPreviousBoardIndex());
        }
      }

    }

  }

  /**
   * Test of copy constructor method, of class Game.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testGame_Game() {

    System.out.println("copy constructor");

    // test with null game
    Game game = null;
    try {
      new Game(game);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with game
    game = new Game(4);
    game.players.get(0).getCards().add(game.cardDeck.dealCard());
    game.currentDealer = 3;
    game.currentPlayer = 2;
    game.players.get(0).getMarbles().get(0).setBoardIndex(4);
    game.addEventListener((Event event) -> {
      // do nothing
    });
    Game instance = new Game(game);
    assertEquals(game, instance);
    assertEquals(0, instance.eventListeners.size());

  }

  /**
   * Test of addEventListener method, of class Game.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testAddEventListener() {

    System.out.println("addEventListener");

    // test with null
    Game instance = new Game(4);
    EventListener eventListener = null;
    try {
      instance.addEventListener(eventListener);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test adding
    instance = new Game(4);
    assertEquals(0, instance.eventListeners.size());
    eventListener = (Event event) -> {
      // do nothing
    };
    instance.addEventListener(eventListener);
    assertEquals(1, instance.eventListeners.size());

  }

  /**
   * Test of advance method, of class Game.
   */
  @Test
  public void testAdvance() {

    System.out.println("advance");

    // test with determine dealer state
    Game game = new Game(4);
    game.nextState = State.DETERMINE_DEALER;
    State expResult = State.DEAL_CARDS;
    State result = game.advance();
    assertEquals(expResult, result);

    // test with deal cards state
    game = new Game(4);
    game.nextState = State.DEAL_CARDS;
    expResult = State.PLAYER_TURN;
    result = game.advance();
    assertEquals(expResult, result);

    // test with player turn state with no player cards
    game = new Game(4);
    game.nextState = State.PLAYER_TURN;
    expResult = State.DEAL_CARDS;
    result = game.advance();
    assertEquals(expResult, result);

    // test with player turn state when a player can play
    game = new Game(4);
    game.getPlayers().get(0).getCards().add(new Card(Rank.ACE, Suit.CLUBS));
    game.nextState = State.PLAYER_TURN;
    expResult = State.PLAYER_TURN;
    result = game.advance();
    assertEquals(expResult, result);

    // test with game over state
    game = new Game(4);
    game.nextState = State.GAME_OVER;
    expResult = State.GAME_OVER;
    result = game.advance();
    assertEquals(expResult, result);

  }

  /**
   * Test of dealCards method, of class Game.
   */
  @Test
  public void testDealCards() {

    System.out.println("dealCards");

    // test the returned state and the state of the dealer and card deck
    Game instance = new Game(4);
    State expResult = State.PLAYER_TURN;
    State result = instance.dealCards();
    assertEquals(expResult, result);
    assertEquals(1, instance.currentDealer);
    assertEquals(2, instance.currentPlayer);
    assertEquals(32, instance.cardDeck.getUndealtCards().size());
    assertEquals(20, instance.cardDeck.getDealtCards().size());
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      assertEquals(5, instance.players.get(i).getCards().size());
    }

    // check the state of the dealer and card deck
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      instance.players.get(i).getCards().clear();
    }
    instance.dealCards();
    assertEquals(2, instance.currentDealer);
    assertEquals(3, instance.currentPlayer);
    assertEquals(16, instance.cardDeck.getUndealtCards().size());
    assertEquals(36, instance.cardDeck.getDealtCards().size());
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      assertEquals(4, instance.players.get(i).getCards().size());
    }

    // check the state of the dealer and card deck
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      instance.players.get(i).getCards().clear();
    }
    instance.dealCards();
    assertEquals(3, instance.currentDealer);
    assertEquals(0, instance.currentPlayer);
    assertEquals(0, instance.cardDeck.getUndealtCards().size());
    assertEquals(52, instance.cardDeck.getDealtCards().size());
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      assertEquals(4, instance.players.get(i).getCards().size());
    }

    // check the state of the dealer and card deck, should have reset, shuffled, and dealt
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      instance.players.get(i).getCards().clear();
    }
    instance.dealCards();
    assertEquals(0, instance.currentDealer);
    assertEquals(1, instance.currentPlayer);
    assertEquals(32, instance.cardDeck.getUndealtCards().size());
    assertEquals(20, instance.cardDeck.getDealtCards().size());
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      assertEquals(5, instance.players.get(i).getCards().size());
    }

  }

  /**
   * Test of determineDealer method, of class Game.
   */
  @Test
  public void testDetermineDealer() {

    System.out.println("determineDealer");

    // test the returned state
    Game game = new Game(4);
    State expResult = State.DEAL_CARDS;
    State result = game.determineDealer();
    assertEquals(expResult, result);
    assertTrue(game.currentDealer >= -1 && game.currentDealer <= 3);
    assertEquals(CardDeck.NUMBER_OF_CARDS_IN_FULL_DECK, game.cardDeck.getUndealtCards().size());
    assertEquals(0, game.cardDeck.getDealtCards().size());

    // test with a corrupt card deck
    game = new Game(4);
    game.cardDeck.dealtCards.clear();
    game.cardDeck.undealtCards.clear();
    expResult = State.DEAL_CARDS;
    result = game.determineDealer();
    assertEquals(expResult, result);
    assertTrue(game.currentDealer == 3);

  }

  /**
   * Test of executeMove method, of class Game.
   */
  @Test
  public void testExecuteMove() {

    System.out.println("executeMove");

    // test with null move
    Game instance = new Game(4);
    Move move = null;
    try {
      instance.executeMove(move);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with move
    instance = new Game(4);
    move = new Move(0, 1, 2);
    instance.executeMove(move);
    assertEquals(2, instance.players.get(0).getMarbles().get(1).getBoardIndex());

  }

  /**
   * Test of executePlay method, of class Game.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testExecutePlay() {

    System.out.println("executePlay");

    // test with invalid player number
    Game instance = new Game(4);
    int playerNumber = -1;
    Play play = null;
    try {
      instance.executePlay(playerNumber, play);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with invalid player number
    instance = new Game(4);
    playerNumber = 4;
    play = null;
    try {
      instance.executePlay(playerNumber, play);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with null play
    instance = new Game(4);
    playerNumber = 0;
    play = null;
    try {
      instance.executePlay(playerNumber, play);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with play with a single move
    instance = new Game(4);
    instance.players.get(0).getCards().add(new Card(Rank.ACE, Suit.CLUBS));
    playerNumber = 0;
    play = new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 1, 2));
    instance.executePlay(playerNumber, play);
    assertEquals(0, instance.players.get(0).getCards().size());
    assertEquals(2, instance.players.get(0).getMarbles().get(1).getBoardIndex());

    // test with play with multiple move
    instance = new Game(4);
    instance.players.get(0).getCards().add(new Card(Rank.ACE, Suit.CLUBS));
    playerNumber = 0;
    Set<Move> moves = new LinkedHashSet<>();
    moves.add(new Move(0, 1, 2));
    moves.add(new Move(2, 3, 4));
    play = new Play(new Card(Rank.ACE, Suit.CLUBS), moves);
    instance.executePlay(playerNumber, play);
    assertEquals(0, instance.players.get(0).getCards().size());
    assertEquals(2, instance.players.get(0).getMarbles().get(1).getBoardIndex());
    assertEquals(4, instance.players.get(2).getMarbles().get(3).getBoardIndex());

  }

  /**
   * Test of fireEvent method, of class Game.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testFireEvent() {

    System.out.println("fireEvent");

    // test with null
    Game instance = new Game(4);
    Event event = null;
    try {
      instance.fireEvent(event);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test firing event
    instance = new Game(4);
    event = new Event(instance);
    final boolean[] eventFired = new boolean[1];
    eventFired[0] = false;
    instance.addEventListener((Event event1) -> {
      eventFired[0] = true;
    });
    instance.fireEvent(event);
    assertEquals(true, eventFired[0]);

  }

  /**
   * Test of getCardDeck method, of class Game.
   */
  @Test
  public void testGetCardDeck() {

    System.out.println("getCardDeck");

    Game instance = new Game(4);
    assertEquals(new CardDeck(), instance.getCardDeck());

  }

  /**
   * Test of getCardForSplitValue method, of class Game.
   */
  @Test
  public void testGetCardForSplitValue() {

    System.out.println("getCardForSplitValue");

    // test with invalid split value
    int splitValue = 0;
    try {
      Game.getCardForSplitValue(splitValue);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with one
    splitValue = 1;
    SplitCard expResult = SplitCard.SPLIT_CARD_ACE;
    SplitCard result = Game.getCardForSplitValue(splitValue);
    assertEquals(expResult, result);

    // test with two
    splitValue = 2;
    expResult = SplitCard.SPLIT_CARD_TWO;
    result = Game.getCardForSplitValue(splitValue);
    assertEquals(expResult, result);

    // test with three
    splitValue = 3;
    expResult = SplitCard.SPLIT_CARD_THREE;
    result = Game.getCardForSplitValue(splitValue);
    assertEquals(expResult, result);

    // test with four
    splitValue = 4;
    expResult = SplitCard.SPLIT_CARD_FOUR;
    result = Game.getCardForSplitValue(splitValue);
    assertEquals(expResult, result);

    // test with five
    splitValue = 5;
    expResult = SplitCard.SPLIT_CARD_FIVE;
    result = Game.getCardForSplitValue(splitValue);
    assertEquals(expResult, result);

    // test with six
    splitValue = 6;
    expResult = SplitCard.SPLIT_CARD_SIX;
    result = Game.getCardForSplitValue(splitValue);
    assertEquals(expResult, result);

  }

  /**
   * Test of getCurrentDealer method, of class Game.
   */
  @Test
  public void testGetCurrentDealer() {

    System.out.println("getCurrentDealer");

    Game instance = new Game(4);
    assertEquals(0, instance.getCurrentDealer());

  }

  /**
   * Test of getCurrentPlayer method, of class Game.
   */
  @Test
  public void testGetCurrentPlayer() {

    System.out.println("getCurrentPlayer");

    Game instance = new Game(4);
    assertEquals(0, instance.getCurrentPlayer());

  }

  /**
   * Test of getEmptyStartSpace method, of class Game.
   */
  @Test
  public void testGetEmptyStartSpace() {

    System.out.println("getEmptyStartSpace");

    // test invalid player number
    Game instance = new Game(4);
    int playerNumber = -1;
    try {
      instance.getEmptyStartSpace(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test invalid player number
    instance = new Game(4);
    playerNumber = 4;
    try {
      instance.getEmptyStartSpace(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with no empty start spaces
    instance = new Game(4);
    playerNumber = 0;
    int expResult = -1;
    int result = instance.getEmptyStartSpace(playerNumber);
    assertEquals(expResult, result);

    // test with each start space being empty
    for (int i = 0; i < Game.NUMBER_OF_MARBLES_PER_PLAYER; i++) {
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(i).setBoardIndex(0);
      playerNumber = 0;
      expResult = instance.getBoard().getStartMinBoardIndex(0) + i;
      result = instance.getEmptyStartSpace(playerNumber);
      assertEquals(expResult, result);
    }

  }

  /**
   * Test of getMarbleInSpace method, of class Game.
   */
  @Test
  public void testGetMarbleInSpace() {

    System.out.println("getMarbleInSpace");

    // test invalid board index
    Game instance = new Game(4);
    int boardIndex = -1;
    try {
      instance.getMarbleInSpace(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test invalid board index
    instance = new Game(4);
    boardIndex = 89;
    try {
      instance.getMarbleInSpace(boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with no marble in space
    instance = new Game(4);
    boardIndex = 0;
    Marble expResult = null;
    Marble result = instance.getMarbleInSpace(boardIndex);
    assertEquals(expResult, result);

    // test with marble in space
    instance = new Game(4);
    boardIndex = instance.getBoard().getStartMinBoardIndex(1) + 2;
    instance.players.get(1).getMarbles().get(2).setBoardIndex(boardIndex);
    expResult = instance.players.get(1).getMarbles().get(2);
    result = instance.getMarbleInSpace(boardIndex);
    assertEquals(expResult, result);

  }

  /**
   * Test of getNextPlayerNumber method, of class Game.
   */
  @Test
  public void testGetNextPlayerNumber() {

    System.out.println("getNextPlayerNumber");

    // test invalid player number
    Game instance = new Game(4);
    int playerNumber = -1;
    try {
      instance.getNextPlayerNumber(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test invalid player number, 4 players
    instance = new Game(4);
    playerNumber = 4;
    try {
      instance.getNextPlayerNumber(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with player 0, 4 players
    instance = new Game(4);
    playerNumber = 0;
    int expResult = 1;
    int result = instance.getNextPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 1, 4 players
    instance = new Game(4);
    playerNumber = 1;
    expResult = 2;
    result = instance.getNextPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 2, 4 players
    instance = new Game(4);
    playerNumber = 2;
    expResult = 3;
    result = instance.getNextPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 3, 4 players
    instance = new Game(4);
    playerNumber = 3;
    expResult = 0;
    result = instance.getNextPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test invalid player number, 6 players
    instance = new Game(4);
    playerNumber = 6;
    try {
      instance.getNextPlayerNumber(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with player 0, 6 players
    instance = new Game(6);
    playerNumber = 0;
    expResult = 1;
    result = instance.getNextPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 1, 6 players
    instance = new Game(6);
    playerNumber = 1;
    expResult = 2;
    result = instance.getNextPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 2, 6 players
    instance = new Game(6);
    playerNumber = 2;
    expResult = 3;
    result = instance.getNextPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 3, 6 players
    instance = new Game(6);
    playerNumber = 3;
    expResult = 4;
    result = instance.getNextPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 4, 6 players
    instance = new Game(6);
    playerNumber = 4;
    expResult = 5;
    result = instance.getNextPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 5, 6 players
    instance = new Game(6);
    playerNumber = 5;
    expResult = 0;
    result = instance.getNextPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test invalid player number, 8 players
    instance = new Game(6);
    playerNumber = 8;
    try {
      instance.getNextPlayerNumber(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with player 0, 8 players
    instance = new Game(8);
    playerNumber = 0;
    expResult = 1;
    result = instance.getNextPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 1, 8 players
    instance = new Game(8);
    playerNumber = 1;
    expResult = 2;
    result = instance.getNextPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 2, 8 players
    instance = new Game(8);
    playerNumber = 2;
    expResult = 3;
    result = instance.getNextPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 3, 8 players
    instance = new Game(8);
    playerNumber = 3;
    expResult = 4;
    result = instance.getNextPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 4, 8 players
    instance = new Game(8);
    playerNumber = 4;
    expResult = 5;
    result = instance.getNextPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 5, 8 players
    instance = new Game(8);
    playerNumber = 5;
    expResult = 6;
    result = instance.getNextPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 6, 8 players
    instance = new Game(8);
    playerNumber = 6;
    expResult = 7;
    result = instance.getNextPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 7, 8 players
    instance = new Game(8);
    playerNumber = 7;
    expResult = 0;
    result = instance.getNextPlayerNumber(playerNumber);
    assertEquals(expResult, result);

  }

  /**
   * Test of getNextState method, of class Game.
   */
  @Test
  public void testGetNextState() {

    System.out.println("getNextState");

    Game game = new Game(4);
    State expResult = State.DETERMINE_DEALER;
    State result = game.getNextState();
    assertEquals(expResult, result);

  }

  /**
   * Test of getNumberOfCardsToDeal method, of class Game.
   */
  @Test
  public void testGetNumberOfCardsToDeal() {

    System.out.println("getNumberOfCardsToDeal");

    // test with full card deck, 4 players
    Game instance = new Game(4);
    instance.cardDeck.reset();
    int expResult = 5;
    int result = instance.getNumberOfCardsToDeal();
    assertEquals(expResult, result);

    // test with not full card deck, 4 players
    instance = new Game(4);
    instance.cardDeck.reset();
    instance.cardDeck.dealCard();
    expResult = 4;
    result = instance.getNumberOfCardsToDeal();
    assertEquals(expResult, result);

    // test with full card deck, 6 players
    instance = new Game(6);
    instance.cardDeck.reset();
    expResult = 4;
    result = instance.getNumberOfCardsToDeal();
    assertEquals(expResult, result);

    // test with full card deck, 8 players
    instance = new Game(8);
    instance.cardDeck.reset();
    expResult = 5;
    result = instance.getNumberOfCardsToDeal();
    assertEquals(expResult, result);

    // test with full card deck, 10 players
    instance = new Game(10);
    instance.cardDeck.reset();
    expResult = 5;
    result = instance.getNumberOfCardsToDeal();
    assertEquals(expResult, result);

    // test with full card deck, 12 players
    instance = new Game(12);
    instance.cardDeck.reset();
    expResult = 4;
    result = instance.getNumberOfCardsToDeal();
    assertEquals(expResult, result);

  }

  /**
   * Test of getNumberOfMarblesInHomeSpace method, of class Game.
   */
  @Test
  public void testGetNumberOfMarblesInHomeSpace() {

    System.out.println("getNumberOfMarblesInHomeSpace");

    // test invalid player number
    Game instance = new Game(4);
    int playerNumber = -1;
    try {
      instance.getNumberOfMarblesInHomeSpace(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test invalid player number
    instance = new Game(4);
    playerNumber = 4;
    try {
      instance.getNumberOfMarblesInHomeSpace(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with new game
    instance = new Game(4);
    int expResult = 0;
    int result;
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      result = instance.getNumberOfMarblesInHomeSpace(i);
      assertEquals(expResult, result);
    }

    // test moving marbles into the home spaces one at a time
    instance = new Game(4);
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      for (int j = 0; j < Game.NUMBER_OF_MARBLES_PER_PLAYER; j++) {
        instance.players.get(i).getMarbles().get(j).setBoardIndex(
            instance.getBoard().getHomeMinBoardIndex(i) + j);
        expResult = j + 1;
        result = instance.getNumberOfMarblesInHomeSpace(i);
        assertEquals(expResult, result);
      }
    }

  }

  /**
   * Test of getNumberOfPlayers method, of class Game.
   */
  @Test
  public void testGetNumberOfPlayers() {

    System.out.println("getNumberOfPlayers");

    // test with 4 players
    Game instance = new Game(4);
    int expResult = 4;
    int result = instance.getNumberOfPlayers();
    assertEquals(expResult, result);

    // test with 6 players
    instance = new Game(6);
    expResult = 6;
    result = instance.getNumberOfPlayers();
    assertEquals(expResult, result);

    // test with 8 players
    instance = new Game(8);
    expResult = 8;
    result = instance.getNumberOfPlayers();
    assertEquals(expResult, result);

    // test with 10 players
    instance = new Game(10);
    expResult = 10;
    result = instance.getNumberOfPlayers();
    assertEquals(expResult, result);

    // test with 12 players
    instance = new Game(12);
    expResult = 12;
    result = instance.getNumberOfPlayers();
    assertEquals(expResult, result);

  }

  /**
   * Test of getNumberOfSpacesForCard method, of class Game.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testGetNumberOfSpacesForCard() {

    System.out.println("getNumberOfSpacesForCard");

    // test with null card
    Card card = null;
    try {
      Game.getNumberOfSpacesForCard(card);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with Ace card
    card = new Card(Rank.ACE, Suit.CLUBS);
    int expResult = 1;
    int result = Game.getNumberOfSpacesForCard(card);
    assertEquals(expResult, result);

    // test with two card
    card = new Card(Rank.TWO, Suit.CLUBS);
    expResult = 2;
    result = Game.getNumberOfSpacesForCard(card);
    assertEquals(expResult, result);

    // test with three card
    card = new Card(Rank.THREE, Suit.CLUBS);
    expResult = 3;
    result = Game.getNumberOfSpacesForCard(card);
    assertEquals(expResult, result);

    // test with four card
    card = new Card(Rank.FOUR, Suit.CLUBS);
    expResult = -4;
    result = Game.getNumberOfSpacesForCard(card);
    assertEquals(expResult, result);

    // test with four card, as SplitCard
    card = new SplitCard(Rank.FOUR);
    expResult = 4;
    result = Game.getNumberOfSpacesForCard(card);
    assertEquals(expResult, result);

    // test with five card
    card = new Card(Rank.FIVE, Suit.CLUBS);
    expResult = 5;
    result = Game.getNumberOfSpacesForCard(card);
    assertEquals(expResult, result);

    // test with six card
    card = new Card(Rank.SIX, Suit.CLUBS);
    expResult = 6;
    result = Game.getNumberOfSpacesForCard(card);
    assertEquals(expResult, result);

    // test with seven card
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    expResult = 7;
    result = Game.getNumberOfSpacesForCard(card);
    assertEquals(expResult, result);

    // test with eight card
    card = new Card(Rank.EIGHT, Suit.CLUBS);
    expResult = 8;
    result = Game.getNumberOfSpacesForCard(card);
    assertEquals(expResult, result);

    // test with nine card
    card = new Card(Rank.NINE, Suit.CLUBS);
    expResult = 9;
    result = Game.getNumberOfSpacesForCard(card);
    assertEquals(expResult, result);

    // test with ten card
    card = new Card(Rank.TEN, Suit.CLUBS);
    expResult = 10;
    result = Game.getNumberOfSpacesForCard(card);
    assertEquals(expResult, result);

    // test with Jack card
    card = new Card(Rank.JACK, Suit.CLUBS);
    try {
      Game.getNumberOfSpacesForCard(card);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with Queen card
    card = new Card(Rank.QUEEN, Suit.CLUBS);
    expResult = 12;
    result = Game.getNumberOfSpacesForCard(card);
    assertEquals(expResult, result);

    // test with King card
    card = new Card(Rank.KING, Suit.CLUBS);
    try {
      Game.getNumberOfSpacesForCard(card);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

  }

  /**
   * Test of getNumberOfTeams method, of class Game.
   */
  @Test
  public void testGetNumberOfTeams() {

    System.out.println("getNumberOfTeams");

    // test with 4 players
    Game instance = new Game(4);
    int expResult = 2;
    int result = instance.getNumberOfTeams();
    assertEquals(expResult, result);

    // test with 6 players
    instance = new Game(6);
    expResult = 3;
    result = instance.getNumberOfTeams();
    assertEquals(expResult, result);

    // test with 8 players
    instance = new Game(8);
    expResult = 4;
    result = instance.getNumberOfTeams();
    assertEquals(expResult, result);

    // test with 10 players
    instance = new Game(10);
    expResult = 5;
    result = instance.getNumberOfTeams();
    assertEquals(expResult, result);

    // test with 12 players
    instance = new Game(12);
    expResult = 6;
    result = instance.getNumberOfTeams();
    assertEquals(expResult, result);

  }

  /**
   * Test of getPartnerPlayerNumber method, of class Game.
   */
  @Test
  public void testGetPartnerPlayerNumber() {

    System.out.println("getPartnerPlayerNumber");

    // test invalid player number, 4 players
    Game instance = new Game(4);
    int playerNumber = -1;
    try {
      instance.getPartnerPlayerNumber(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test invalid player number, 4 players
    instance = new Game(4);
    playerNumber = 4;
    try {
      instance.getPartnerPlayerNumber(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test player 0, 4 players
    instance = new Game(4);
    playerNumber = 0;
    int expResult = 2;
    int result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 4 players
    instance = new Game(4);
    playerNumber = 1;
    expResult = 3;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 4 players
    instance = new Game(4);
    playerNumber = 2;
    expResult = 0;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 4 players
    instance = new Game(4);
    playerNumber = 3;
    expResult = 1;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test invalid player number, 6 players
    instance = new Game(6);
    playerNumber = 6;
    try {
      instance.getPartnerPlayerNumber(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test player 0, 6 players
    instance = new Game(6);
    playerNumber = 0;
    expResult = 3;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 6 players
    instance = new Game(6);
    playerNumber = 1;
    expResult = 4;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 6 players
    instance = new Game(6);
    playerNumber = 2;
    expResult = 5;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 6 players
    instance = new Game(6);
    playerNumber = 3;
    expResult = 0;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 4, 6 players
    instance = new Game(6);
    playerNumber = 4;
    expResult = 1;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 5, 6 players
    instance = new Game(6);
    playerNumber = 5;
    expResult = 2;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test invalid player number, 8 players
    instance = new Game(8);
    playerNumber = 8;
    try {
      instance.getPartnerPlayerNumber(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test player 0, 8 players
    instance = new Game(8);
    playerNumber = 0;
    expResult = 4;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 8 players
    instance = new Game(8);
    playerNumber = 1;
    expResult = 5;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 8 players
    instance = new Game(8);
    playerNumber = 2;
    expResult = 6;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 8 players
    instance = new Game(8);
    playerNumber = 3;
    expResult = 7;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 4, 8 players
    instance = new Game(8);
    playerNumber = 4;
    expResult = 0;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 5, 8 players
    instance = new Game(8);
    playerNumber = 5;
    expResult = 1;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 6, 8 players
    instance = new Game(8);
    playerNumber = 6;
    expResult = 2;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 7, 8 players
    instance = new Game(8);
    playerNumber = 7;
    expResult = 3;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test invalid player number, 10 players
    instance = new Game(10);
    playerNumber = 10;
    try {
      instance.getPartnerPlayerNumber(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test player 0, 10 players
    instance = new Game(10);
    playerNumber = 0;
    expResult = 5;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 10 players
    instance = new Game(10);
    playerNumber = 1;
    expResult = 6;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 10 players
    instance = new Game(10);
    playerNumber = 2;
    expResult = 7;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 10 players
    instance = new Game(10);
    playerNumber = 3;
    expResult = 8;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 4, 10 players
    instance = new Game(10);
    playerNumber = 4;
    expResult = 9;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 5, 10 players
    instance = new Game(10);
    playerNumber = 5;
    expResult = 0;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 6, 10 players
    instance = new Game(10);
    playerNumber = 6;
    expResult = 1;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 7, 10 players
    instance = new Game(10);
    playerNumber = 7;
    expResult = 2;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 8, 10 players
    instance = new Game(10);
    playerNumber = 8;
    expResult = 3;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 9, 10 players
    instance = new Game(10);
    playerNumber = 9;
    expResult = 4;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test invalid player number, 10 players
    instance = new Game(10);
    playerNumber = 10;
    try {
      instance.getPartnerPlayerNumber(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test player 0, 12 players
    instance = new Game(12);
    playerNumber = 0;
    expResult = 6;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 1, 12 players
    instance = new Game(12);
    playerNumber = 1;
    expResult = 7;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 2, 12 players
    instance = new Game(12);
    playerNumber = 2;
    expResult = 8;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 3, 12 players
    instance = new Game(12);
    playerNumber = 3;
    expResult = 9;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 4, 12 players
    instance = new Game(12);
    playerNumber = 4;
    expResult = 10;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 5, 12 players
    instance = new Game(12);
    playerNumber = 5;
    expResult = 11;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 6, 12 players
    instance = new Game(12);
    playerNumber = 6;
    expResult = 0;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 7, 12 players
    instance = new Game(12);
    playerNumber = 7;
    expResult = 1;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 8, 12 players
    instance = new Game(12);
    playerNumber = 8;
    expResult = 2;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 9, 12 players
    instance = new Game(12);
    playerNumber = 9;
    expResult = 3;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 10, 12 players
    instance = new Game(12);
    playerNumber = 10;
    expResult = 4;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test player 11, 12 players
    instance = new Game(12);
    playerNumber = 11;
    expResult = 5;
    result = instance.getPartnerPlayerNumber(playerNumber);
    assertEquals(expResult, result);

  }

  /**
   * Test of getPlayForCardAndMarble method, of class Game.
   *
   * @throws Exception if an error occurred
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testGetPlayForCardAndMarble() throws Exception {

    System.out.println("getPlayForCardAndMarble");

    // test with invalid player number
    Game instance = new Game(4);
    int playerNumber = -1;
    Card card = null;
    Marble marble = null;
    try {
      instance.getPlayForCardAndMarble(playerNumber, card, marble);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    } catch (InvalidPlayException ex) {
      fail("Illegal argument exception not thrown");
    }

    // test invalid player number
    instance = new Game(4);
    playerNumber = 4;
    card = null;
    marble = null;
    try {
      instance.getPlayForCardAndMarble(playerNumber, card, marble);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    } catch (InvalidPlayException ex) {
      fail("Illegal argument exception not thrown");
    }

    // test null card
    instance = new Game(4);
    playerNumber = 0;
    card = null;
    marble = null;
    try {
      instance.getPlayForCardAndMarble(playerNumber, card, marble);
      fail("Null pointer exception not thrown");
    } catch (InvalidPlayException ex) {
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with invalid card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble = null;
    try {
      instance.getPlayForCardAndMarble(playerNumber, card, marble);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    } catch (InvalidPlayException ex) {
      fail("Illegal argument exception not thrown");
    }

    // test with invalid card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.KING, Suit.CLUBS);
    marble = null;
    try {
      instance.getPlayForCardAndMarble(playerNumber, card, marble);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    } catch (InvalidPlayException ex) {
      fail("Illegal argument exception not thrown");
    }

    // test null marble
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.ACE, Suit.CLUBS);
    marble = null;
    try {
      instance.getPlayForCardAndMarble(playerNumber, card, marble);
      fail("Null pointer exception not thrown");
    } catch (InvalidPlayException ex) {
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    for (playerNumber = 0; playerNumber <= 2; playerNumber += 2) {

      // test with opponents marble
      instance = new Game(4);
      card = new Card(Rank.ACE, Suit.CLUBS);
      marble = instance.players.get(playerNumber + 1).getMarbles().get(0);
      try {
        instance.getPlayForCardAndMarble(playerNumber, card, marble);
        fail("Invalid play exception not thrown");
      } catch (InvalidPlayException ex) {
        // do nothing
      }

      // test with marble in a start space
      instance = new Game(4);
      card = new Card(Rank.ACE, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);

      try {
        instance.getPlayForCardAndMarble(playerNumber, card, marble);
        fail("Invalid play exception not thrown");
      } catch (InvalidPlayException ex) {
        // do nothing
      }

      // test with marble in a home space, with a four
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(0));
      card = new Card(Rank.FOUR, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      try {
        instance.getPlayForCardAndMarble(playerNumber, card, marble);
        fail("Invalid play exception not thrown");
      } catch (InvalidPlayException ex) {
        // do nothing
      }

      // test with marble in a home space, going beyond home spaces
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(0));
      card = new Card(Rank.QUEEN, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      try {
        instance.getPlayForCardAndMarble(playerNumber, card, marble);
        fail("Invalid play exception not thrown");
      } catch (InvalidPlayException ex) {
        // do nothing
      }

      // test with marble in a home space, passing another marble in home space
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(0));
      instance.players.get(0).getMarbles().get(1).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(0) + 1);
      card = new Card(Rank.TWO, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      try {
        instance.getPlayForCardAndMarble(playerNumber, card, marble);
        fail("Invalid play exception not thrown");
      } catch (InvalidPlayException ex) {
        // do nothing
      }

      // test with marble in a home space, landing on another marble in home space
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(0));
      instance.players.get(0).getMarbles().get(1).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(0) + 3);
      card = new Card(Rank.THREE, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      try {
        instance.getPlayForCardAndMarble(playerNumber, card, marble);
        fail("Invalid play exception not thrown");
      } catch (InvalidPlayException ex) {
        // do nothing
      }

      // test with marble in a home space, with valid play
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(0));
      instance.players.get(0).getMarbles().get(1).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(0) + 3);
      card = new Card(Rank.TWO, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      Play expResult = new Play(card,
          new Move(0, 0, instance.getBoard().getHomeMinBoardIndex(0) + 2));
      Play result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
      assertEquals(expResult, result);

      // test with marble crossing home entry, going beyond home spaces
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(
          instance.getBoard().getHomeEntryBoardIndex(0));
      card = new Card(Rank.FIVE, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      try {
        instance.getPlayForCardAndMarble(playerNumber, card, marble);
        fail("Invalid play exception not thrown");
      } catch (InvalidPlayException ex) {
        // do nothing
      }

      // test with marble crossing home entry, passing another marble in home space
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(
          instance.getBoard().getHomeEntryBoardIndex(0));
      instance.players.get(0).getMarbles().get(1).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(0) + 1);
      card = new Card(Rank.THREE, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      try {
        instance.getPlayForCardAndMarble(playerNumber, card, marble);
        fail("Invalid play exception not thrown");
      } catch (InvalidPlayException ex) {
        // do nothing
      }

      // test with marble crossing home entry, with valid play
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(
          instance.getBoard().getHomeEntryBoardIndex(0));
      instance.players.get(0).getMarbles().get(1).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(0) + 1);
      card = new Card(Rank.ACE, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      expResult = new Play(card, new Move(0, 0, instance.getBoard().getHomeMinBoardIndex(0)));
      result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
      assertEquals(expResult, result);

      // test wrapping board index
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(
          instance.getBoard().getHomeEntryBoardIndex(0) + 1);
      card = new Card(Rank.TWO, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      expResult = new Play(card, new Move(0, 0, 1));
      result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
      assertEquals(expResult, result);

      // test wrapping board index backwards
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(2);
      card = new Card(Rank.FOUR, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      expResult = new Play(card, new Move(0, 0, instance.getBoard().getHomeEntryBoardIndex(0)));
      result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
      assertEquals(expResult, result);

      // test landing on player's marble
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(
          instance.getBoard().getHomeEntryBoardIndex(0) + 1);
      instance.players.get(0).getMarbles().get(1).setBoardIndex(1);
      card = new Card(Rank.TWO, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      try {
        instance.getPlayForCardAndMarble(playerNumber, card, marble);
        fail("Invalid play exception not thrown");
      } catch (InvalidPlayException ex) {
        // do nothing
      }

      // test landing on player's partner's marble
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(
          instance.getBoard().getHomeEntryBoardIndex(0) + 1);
      instance.players.get(2).getMarbles().get(1).setBoardIndex(1);
      card = new Card(Rank.TWO, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      try {
        instance.getPlayForCardAndMarble(playerNumber, card, marble);
        fail("Invalid play exception not thrown");
      } catch (InvalidPlayException ex) {
        // do nothing
      }

      // test landing on safe marble
      for (int i = 0; i < 4; i++) {
        instance = new Game(4);
        instance.players.get(0).getMarbles().get(0).setBoardIndex(
            instance.getBoard().getSafeBoardIndex(i) + 4);
        instance.players.get(i).getMarbles().get(1).setBoardIndex(
            instance.getBoard().getSafeBoardIndex(i));
        instance.players.get(i).getMarbles().get(1).setPreviousBoardIndex(
            instance.getBoard().getStartMinBoardIndex(i));
        card = new Card(Rank.FOUR, Suit.CLUBS);
        marble = instance.players.get(0).getMarbles().get(0);
        try {
          instance.getPlayForCardAndMarble(playerNumber, card, marble);
          fail("Invalid play exception not thrown");
        } catch (InvalidPlayException ex) {
          // do nothing
        }
      }

      // test landing on marble in safe space that is not safe
      for (int i = 0; i < 4; i++) {
        instance = new Game(4);
        instance.players.get(0).getMarbles().get(0).setBoardIndex(
            instance.getBoard().getSafeBoardIndex(i) + 4);
        instance.players.get(i).getMarbles().get(1).setBoardIndex(
            instance.getBoard().getSafeBoardIndex(i));
        card = new Card(Rank.FOUR, Suit.CLUBS);
        marble = instance.players.get(0).getMarbles().get(0);
        Set<Move> moves = new LinkedHashSet<>();
        moves.add(new Move(0, 0, instance.getBoard().getSafeBoardIndex(i)));
        moves.add(new Move(i, 1, instance.getBoard().getStartMinBoardIndex(i) + 1));
        expResult = new Play(card, moves);
        try {
          result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
          if (i == 0 || i == 2) {
            fail("Invalid play exception not thrown");
          }
          assertEquals(expResult, result);
        } catch (InvalidPlayException ex) {
          if (i == 1 || i == 3) {
            throw ex;
          }
        }
      }

      // test passing a safe marble forward
      for (int i = 0; i < 4; i++) {
        instance = new Game(4);
        instance.players.get(0).getMarbles().get(0).setBoardIndex(
            i == 0 ? 55 : instance.getBoard().getSafeBoardIndex(i) - 1);
        instance.players.get(i).getMarbles().get(1).setBoardIndex(
            instance.getBoard().getSafeBoardIndex(i));
        instance.players.get(i).getMarbles().get(1).setPreviousBoardIndex(
            instance.getBoard().getStartMinBoardIndex(i));
        card = new Card(Rank.FIVE, Suit.CLUBS);
        marble = instance.players.get(0).getMarbles().get(0);
        try {
          instance.getPlayForCardAndMarble(playerNumber, card, marble);
          fail("Invalid play exception not thrown");
        } catch (InvalidPlayException ex) {
          // do nothing
        }
      }

      // test passing a safe marble backward
      for (int i = 0; i < 4; i++) {
        instance = new Game(4);
        instance.players.get(0).getMarbles().get(0).setBoardIndex(
            instance.getBoard().getSafeBoardIndex(i) + 1);
        instance.players.get(i).getMarbles().get(1).setBoardIndex(
            instance.getBoard().getSafeBoardIndex(i));
        instance.players.get(i).getMarbles().get(1).setPreviousBoardIndex(
            instance.getBoard().getStartMinBoardIndex(i));
        card = new Card(Rank.FOUR, Suit.CLUBS);
        marble = instance.players.get(0).getMarbles().get(0);
        try {
          instance.getPlayForCardAndMarble(playerNumber, card, marble);
          fail("Invalid play exception not thrown");
        } catch (InvalidPlayException ex) {
          // do nothing
        }
      }

      // test moving marble from safe space forward
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
      card = new Card(Rank.FIVE, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      expResult = new Play(card, new Move(0, 0, 5));
      result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
      assertEquals(expResult, result);

      // test with marble in a safe space but move doesn't cross it
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(1);
      instance.players.get(1).getMarbles().get(1).setBoardIndex(
          instance.getBoard().getSafeBoardIndex(1));
      instance.players.get(1).getMarbles().get(1).setPreviousBoardIndex(
          instance.getBoard().getStartMinBoardIndex(1));
      card = new Card(Rank.FIVE, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      expResult = new Play(card, new Move(0, 0, 6));
      result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
      assertEquals(expResult, result);

      // test with marble in a safe space but move doesn't cross it
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(15);
      instance.players.get(1).getMarbles().get(1).setBoardIndex(
          instance.getBoard().getSafeBoardIndex(1));
      instance.players.get(1).getMarbles().get(1).setPreviousBoardIndex(
          instance.getBoard().getStartMinBoardIndex(1));
      card = new Card(Rank.FIVE, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      expResult = new Play(card, new Move(0, 0, 20));
      result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
      assertEquals(expResult, result);

      // test with player 0 marble in a safe space but move doesn't cross it
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(1);
      instance.players.get(0).getMarbles().get(1).setBoardIndex(
          instance.getBoard().getSafeBoardIndex(0));
      instance.players.get(0).getMarbles().get(1).setPreviousBoardIndex(
          instance.getBoard().getStartMinBoardIndex(0));
      card = new Card(Rank.FIVE, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      expResult = new Play(card, new Move(0, 0, 6));
      result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
      assertEquals(expResult, result);

      // test with Ace card
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
      card = new Card(Rank.ACE, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      expResult = new Play(card, new Move(0, 0, 1));
      result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
      assertEquals(expResult, result);

      // test with two card
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
      card = new Card(Rank.TWO, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      expResult = new Play(card, new Move(0, 0, 2));
      result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
      assertEquals(expResult, result);

      // test with three card
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
      card = new Card(Rank.THREE, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      expResult = new Play(card, new Move(0, 0, 3));
      result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
      assertEquals(expResult, result);

      // test with four card
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
      card = new Card(Rank.FOUR, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      expResult = new Play(card, new Move(0, 0, 52));
      result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
      assertEquals(expResult, result);

      // test with five card
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
      card = new Card(Rank.FIVE, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      expResult = new Play(card, new Move(0, 0, 5));
      result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
      assertEquals(expResult, result);

      // test with six card
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
      card = new Card(Rank.SIX, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      expResult = new Play(card, new Move(0, 0, 6));
      result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
      assertEquals(expResult, result);

      // test with seven card
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
      card = new Card(Rank.SEVEN, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      expResult = new Play(card, new Move(0, 0, 7));
      result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
      assertEquals(expResult, result);

      // test with eight card
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
      card = new Card(Rank.EIGHT, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      expResult = new Play(card, new Move(0, 0, 8));
      result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
      assertEquals(expResult, result);

      // test with nine card
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
      card = new Card(Rank.NINE, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      expResult = new Play(card, new Move(0, 0, 9));
      result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
      assertEquals(expResult, result);

      // test with ten card
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
      card = new Card(Rank.TEN, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      expResult = new Play(card, new Move(0, 0, 10));
      result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
      assertEquals(expResult, result);

      // test with Queen card
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
      card = new Card(Rank.QUEEN, Suit.CLUBS);
      marble = instance.players.get(0).getMarbles().get(0);
      expResult = new Play(card, new Move(0, 0, 12));
      result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
      assertEquals(expResult, result);

      // test with Queen card wrapping the board index with safe marble for player 1 (bug)
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(55);
      instance.players.get(1).getMarbles().get(1).setBoardIndex(14);
      instance.players.get(1).getMarbles().get(1).setPreviousBoardIndex(76);
      card = new Card(Rank.QUEEN, Suit.HEARTS);
      marble = instance.players.get(0).getMarbles().get(0);
      expResult = new Play(card, new Move(0, 0, 11));
      result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
      assertEquals(expResult, result);

      // test passing a safe marble for player 1 forwards (test after bug fix)
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(15);
      instance.players.get(1).getMarbles().get(1).setBoardIndex(14);
      instance.players.get(1).getMarbles().get(1).setPreviousBoardIndex(76);
      card = new Card(Rank.FOUR, Suit.HEARTS);
      marble = instance.players.get(0).getMarbles().get(0);
      try {
        instance.getPlayForCardAndMarble(playerNumber, card, marble);
        fail("Invalid play exception not thrown");
      } catch (InvalidPlayException ex) {
        // do nothing
      }

      // test passing a safe marble for player 1 backwards (test after bug fix)
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(13);
      instance.players.get(1).getMarbles().get(1).setBoardIndex(14);
      instance.players.get(1).getMarbles().get(1).setPreviousBoardIndex(76);
      card = new Card(Rank.THREE, Suit.HEARTS);
      marble = instance.players.get(0).getMarbles().get(0);
      try {
        instance.getPlayForCardAndMarble(playerNumber, card, marble);
        fail("Invalid play exception not thrown");
      } catch (InvalidPlayException ex) {
        // do nothing
      }

      // test with Four card wrapping the board index with safe marble for player 1 (bug)
      instance = new Game(4);
      instance.players.get(0).getMarbles().get(0).setBoardIndex(2);
      instance.players.get(1).getMarbles().get(1).setBoardIndex(14);
      instance.players.get(1).getMarbles().get(1).setPreviousBoardIndex(76);
      card = new Card(Rank.FOUR, Suit.HEARTS);
      marble = instance.players.get(0).getMarbles().get(0);
      expResult = new Play(card, new Move(0, 0, 54));
      result = instance.getPlayForCardAndMarble(playerNumber, card, marble);
      assertEquals(expResult, result);

    }

  }

  /**
   * Test of getPlayForCardJackAndMarbles method, of class Game.
   *
   * @throws Exception if an error occurred
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testGetPlayForCardJackAndMarbles() throws Exception {

    System.out.println("getPlayForCardJackAndMarbles");

    // test with invalid player number
    Game instance = new Game(4);
    int playerNumber = -1;
    Card card = null;
    Marble marble1 = null;
    Marble marble2 = null;
    try {
      instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    } catch (InvalidPlayException ex) {
      fail("Illegal argument exception not thrown");
    }

    // test invalid player number
    instance = new Game(4);
    playerNumber = 4;
    card = null;
    marble1 = null;
    marble2 = null;
    try {
      instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    } catch (InvalidPlayException ex) {
      fail("Illegal argument exception not thrown");
    }

    // test null card
    instance = new Game(4);
    playerNumber = 0;
    card = null;
    marble1 = null;
    marble2 = null;
    try {
      instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
      fail("Null pointer exception not thrown");
    } catch (InvalidPlayException ex) {
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with invalid card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.EIGHT, Suit.CLUBS);
    marble1 = null;
    marble2 = null;
    try {
      instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    } catch (InvalidPlayException ex) {
      fail("Illegal argument exception not thrown");
    }

    // test null marble 1
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = null;
    marble2 = null;
    try {
      instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
      fail("Null pointer exception not thrown");
    } catch (InvalidPlayException ex) {
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test null marble 2
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = new Marble(0, 0, 0);
    marble2 = null;
    try {
      instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
      fail("Null pointer exception not thrown");
    } catch (InvalidPlayException ex) {
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test swapping the same marble
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = instance.players.get(0).getMarbles().get(0);
    marble2 = instance.players.get(0).getMarbles().get(0);
    try {
      instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test swapping different marbles for the same player
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(0).getMarbles().get(1).setBoardIndex(1);
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = instance.players.get(0).getMarbles().get(0);
    marble2 = instance.players.get(0).getMarbles().get(1);
    try {
      instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test swapping opponent's marble and opponent's marble
    instance = new Game(4);
    instance.players.get(1).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(3).getMarbles().get(0).setBoardIndex(15);
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = instance.players.get(1).getMarbles().get(0);
    marble2 = instance.players.get(3).getMarbles().get(0);
    try {
      instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test swapping player's marble and opponent's marble
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(1).getMarbles().get(0).setBoardIndex(15);
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = instance.players.get(0).getMarbles().get(0);
    marble2 = instance.players.get(1).getMarbles().get(0);
    Set<Move> moves = new LinkedHashSet<>();
    moves.add(new Move(0, 0, 15));
    moves.add(new Move(1, 0, 0));
    Play expResult = new Play(card, moves);
    Play result = instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
    assertEquals(expResult, result);

    // test swapping player's partner's marble and opponent's marble
    instance = new Game(4);
    instance.players.get(2).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(1).getMarbles().get(0).setBoardIndex(15);
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = instance.players.get(2).getMarbles().get(0);
    marble2 = instance.players.get(1).getMarbles().get(0);
    moves = new LinkedHashSet<>();
    moves.add(new Move(2, 0, 15));
    moves.add(new Move(1, 0, 0));
    expResult = new Play(card, moves);
    result = instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
    assertEquals(expResult, result);

    // test swapping opponent's marble and player's marble
    instance = new Game(4);
    instance.players.get(1).getMarbles().get(0).setBoardIndex(15);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = instance.players.get(1).getMarbles().get(0);
    marble2 = instance.players.get(0).getMarbles().get(0);
    moves = new LinkedHashSet<>();
    moves.add(new Move(1, 0, 0));
    moves.add(new Move(0, 0, 15));
    expResult = new Play(card, moves);
    result = instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
    assertEquals(expResult, result);

    // test swapping opponent's marble and player's partner's marble
    instance = new Game(4);
    instance.players.get(1).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(2).getMarbles().get(0).setBoardIndex(15);
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = instance.players.get(1).getMarbles().get(0);
    marble2 = instance.players.get(2).getMarbles().get(0);
    moves = new LinkedHashSet<>();
    moves.add(new Move(1, 0, 15));
    moves.add(new Move(2, 0, 0));
    expResult = new Play(card, moves);
    result = instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
    assertEquals(expResult, result);

    // test swapping player's marble and player's partner's marble
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(2).getMarbles().get(0).setBoardIndex(15);
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = instance.players.get(0).getMarbles().get(0);
    marble2 = instance.players.get(2).getMarbles().get(0);
    moves = new LinkedHashSet<>();
    moves.add(new Move(0, 0, 15));
    moves.add(new Move(2, 0, 0));
    expResult = new Play(card, moves);
    result = instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
    assertEquals(expResult, result);

    // test swapping player's partner's marble and player's marble
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(2).getMarbles().get(0).setBoardIndex(15);
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = instance.players.get(2).getMarbles().get(0);
    marble2 = instance.players.get(0).getMarbles().get(0);
    moves = new LinkedHashSet<>();
    moves.add(new Move(2, 0, 0));
    moves.add(new Move(0, 0, 15));
    expResult = new Play(card, moves);
    result = instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
    assertEquals(expResult, result);

    // test with marble 1 in a start space
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = instance.players.get(0).getMarbles().get(0);
    marble2 = instance.players.get(1).getMarbles().get(0);
    try {
      instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test with marble 1 in a home space
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getHomeMinBoardIndex(0));
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = instance.players.get(0).getMarbles().get(0);
    marble2 = instance.players.get(1).getMarbles().get(0);
    try {
      instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test with marble 2 in a start space
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = instance.players.get(0).getMarbles().get(0);
    marble2 = instance.players.get(1).getMarbles().get(0);
    try {
      instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test with marble 2 in a home space
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(1).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getHomeMinBoardIndex(1));
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = instance.players.get(0).getMarbles().get(0);
    marble2 = instance.players.get(1).getMarbles().get(0);
    try {
      instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test swapping player's marble that is safe with marble 1
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getSafeBoardIndex(0));
    instance.players.get(0).getMarbles().get(0).setPreviousBoardIndex(
        instance.getBoard().getStartMinBoardIndex(0));
    instance.players.get(1).getMarbles().get(0).setBoardIndex(10);
    assertTrue(instance.isMarbleInSafeSpaceSafe(0));
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = instance.players.get(0).getMarbles().get(0);
    marble2 = instance.players.get(1).getMarbles().get(0);
    moves = new LinkedHashSet<>();
    moves.add(new Move(0, 0, 10));
    moves.add(new Move(1, 0, 0));
    expResult = new Play(card, moves);
    result = instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
    assertEquals(expResult, result);

    // test swapping player's marble that is safe with marble 2
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getSafeBoardIndex(0));
    instance.players.get(0).getMarbles().get(0).setPreviousBoardIndex(
        instance.getBoard().getStartMinBoardIndex(0));
    instance.players.get(1).getMarbles().get(0).setBoardIndex(10);
    assertTrue(instance.isMarbleInSafeSpaceSafe(0));
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = instance.players.get(1).getMarbles().get(0);
    marble2 = instance.players.get(0).getMarbles().get(0);
    moves = new LinkedHashSet<>();
    moves.add(new Move(1, 0, 0));
    moves.add(new Move(0, 0, 10));
    expResult = new Play(card, moves);
    result = instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
    assertEquals(expResult, result);

    // test swapping player's partner's marble that is safe with marble 1
    instance = new Game(4);
    instance.players.get(2).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getSafeBoardIndex(2));
    instance.players.get(2).getMarbles().get(0).setPreviousBoardIndex(
        instance.getBoard().getStartMinBoardIndex(2));
    instance.players.get(1).getMarbles().get(0).setBoardIndex(10);
    assertTrue(instance.isMarbleInSafeSpaceSafe(2));
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = instance.players.get(2).getMarbles().get(0);
    marble2 = instance.players.get(1).getMarbles().get(0);
    moves = new LinkedHashSet<>();
    moves.add(new Move(2, 0, 10));
    moves.add(new Move(1, 0, instance.getBoard().getSafeBoardIndex(2)));
    expResult = new Play(card, moves);
    result = instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
    assertEquals(expResult, result);

    // test swapping player's partner's marble that is safe with marble 2
    instance = new Game(4);
    instance.players.get(2).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getSafeBoardIndex(2));
    instance.players.get(2).getMarbles().get(0).setPreviousBoardIndex(
        instance.getBoard().getStartMinBoardIndex(2));
    instance.players.get(1).getMarbles().get(0).setBoardIndex(10);
    assertTrue(instance.isMarbleInSafeSpaceSafe(2));
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = instance.players.get(1).getMarbles().get(0);
    marble2 = instance.players.get(2).getMarbles().get(0);
    moves = new LinkedHashSet<>();
    moves.add(new Move(1, 0, instance.getBoard().getSafeBoardIndex(2)));
    moves.add(new Move(2, 0, 10));
    expResult = new Play(card, moves);
    result = instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
    assertEquals(expResult, result);

    // test swapping opponents marble that is safe with marble 1
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(1).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getSafeBoardIndex(1));
    instance.players.get(1).getMarbles().get(0).setPreviousBoardIndex(
        instance.getBoard().getStartMinBoardIndex(1));
    assertTrue(instance.isMarbleInSafeSpaceSafe(1));
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = instance.players.get(0).getMarbles().get(0);
    marble2 = instance.players.get(1).getMarbles().get(0);
    try {
      instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test swapping opponents marble in safe space but not safe with marble 1
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(1).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getSafeBoardIndex(1));
    assertFalse(instance.isMarbleInSafeSpaceSafe(1));
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = instance.players.get(0).getMarbles().get(0);
    marble2 = instance.players.get(1).getMarbles().get(0);
    moves = new LinkedHashSet<>();
    moves.add(new Move(0, 0, instance.getBoard().getSafeBoardIndex(1)));
    moves.add(new Move(1, 0, 0));
    expResult = new Play(card, moves);
    result = instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
    assertEquals(expResult, result);

    // test swapping opponents marble that is safe with marble 2
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(1).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getSafeBoardIndex(1));
    instance.players.get(1).getMarbles().get(0).setPreviousBoardIndex(
        instance.getBoard().getStartMinBoardIndex(1));
    assertTrue(instance.isMarbleInSafeSpaceSafe(1));
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = instance.players.get(1).getMarbles().get(0);
    marble2 = instance.players.get(0).getMarbles().get(0);
    try {
      instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test swapping opponents marble in safe space but not safe with marble 2
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(1).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getSafeBoardIndex(1));
    assertFalse(instance.isMarbleInSafeSpaceSafe(1));
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    marble1 = instance.players.get(1).getMarbles().get(0);
    marble2 = instance.players.get(0).getMarbles().get(0);
    moves = new LinkedHashSet<>();
    moves.add(new Move(1, 0, 0));
    moves.add(new Move(0, 0, instance.getBoard().getSafeBoardIndex(1)));
    expResult = new Play(card, moves);
    result = instance.getPlayForCardJackAndMarbles(playerNumber, card, marble1, marble2);
    assertEquals(expResult, result);

  }

  /**
   * Test of getPlayForCardKingAndMarble method, of class Game.
   *
   * @throws Exception if an error occurred
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testGetPlayForCardKingAndMarble() throws Exception {

    System.out.println("getPlayForCardKingAndMarble");

    // test with invalid player number
    Game instance = new Game(4);
    int playerNumber = -1;
    Card card = null;
    Marble marble = null;
    try {
      instance.getPlayForCardKingAndMarble(playerNumber, card, marble);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    } catch (InvalidPlayException ex) {
      fail("Illegal argument exception not thrown");
    }

    // test invalid player number
    instance = new Game(4);
    playerNumber = 4;
    card = null;
    marble = null;
    try {
      instance.getPlayForCardKingAndMarble(playerNumber, card, marble);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    } catch (InvalidPlayException ex) {
      fail("Illegal argument exception not thrown");
    }

    // test null card
    instance = new Game(4);
    playerNumber = 0;
    card = null;
    marble = null;
    try {
      instance.getPlayForCardKingAndMarble(playerNumber, card, marble);
      fail("Null pointer exception not thrown");
    } catch (InvalidPlayException ex) {
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with invalid card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.EIGHT, Suit.CLUBS);
    marble = null;
    try {
      instance.getPlayForCardKingAndMarble(playerNumber, card, marble);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    } catch (InvalidPlayException ex) {
      fail("Illegal argument exception not thrown");
    }

    // test null marble
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.KING, Suit.CLUBS);
    marble = null;
    try {
      instance.getPlayForCardKingAndMarble(playerNumber, card, marble);
      fail("Null pointer exception not thrown");
    } catch (InvalidPlayException ex) {
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with opponents marble
    instance = new Game(4);
    instance.players.get(1).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getStartMinBoardIndex(1));
    playerNumber = 0;
    card = new Card(Rank.KING, Suit.CLUBS);
    marble = instance.players.get(1).getMarbles().get(0);
    try {
      instance.getPlayForCardKingAndMarble(playerNumber, card, marble);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test with marble not in a start space
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    playerNumber = 0;
    card = new Card(Rank.KING, Suit.CLUBS);
    marble = instance.players.get(0).getMarbles().get(0);
    try {
      instance.getPlayForCardKingAndMarble(playerNumber, card, marble);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test with player's marble, and player has one of their own marbles in the safe spot
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getStartMinBoardIndex(0));
    instance.players.get(0).getMarbles().get(1).setBoardIndex(
        instance.getBoard().getSafeBoardIndex(0));
    playerNumber = 0;
    card = new Card(Rank.KING, Suit.CLUBS);
    marble = instance.players.get(0).getMarbles().get(0);
    try {
      instance.getPlayForCardKingAndMarble(playerNumber, card, marble);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test with player's marble, and partner has one of their marbles in the player's safe spot
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getStartMinBoardIndex(0));
    instance.players.get(2).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getSafeBoardIndex(0));
    playerNumber = 0;
    card = new Card(Rank.KING, Suit.CLUBS);
    marble = instance.players.get(0).getMarbles().get(0);
    try {
      instance.getPlayForCardKingAndMarble(playerNumber, card, marble);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test with partner's marble, and partner has one of their own marbles in their safe spot
    instance = new Game(4);
    instance.players.get(2).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getStartMinBoardIndex(2));
    instance.players.get(2).getMarbles().get(1).setBoardIndex(
        instance.getBoard().getSafeBoardIndex(2));
    playerNumber = 0;
    card = new Card(Rank.KING, Suit.CLUBS);
    marble = instance.players.get(2).getMarbles().get(0);
    try {
      instance.getPlayForCardKingAndMarble(playerNumber, card, marble);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test with partner's marble, and player has one of their marbles in their partner's safe spot
    instance = new Game(4);
    instance.players.get(2).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getStartMinBoardIndex(2));
    instance.players.get(0).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getSafeBoardIndex(2));
    playerNumber = 0;
    card = new Card(Rank.KING, Suit.CLUBS);
    marble = instance.players.get(2).getMarbles().get(0);
    try {
      instance.getPlayForCardKingAndMarble(playerNumber, card, marble);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test with player's marble
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getStartMinBoardIndex(0));
    playerNumber = 0;
    card = new Card(Rank.KING, Suit.CLUBS);
    marble = instance.players.get(0).getMarbles().get(0);
    Play expResult = new Play(card, new Move(0, 0, instance.getBoard().getSafeBoardIndex(0)));
    Play result = instance.getPlayForCardKingAndMarble(playerNumber, card, marble);
    assertEquals(expResult, result);

    // test with partner's marble
    instance = new Game(4);
    instance.players.get(2).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getStartMinBoardIndex(2));
    playerNumber = 0;
    card = new Card(Rank.KING, Suit.CLUBS);
    marble = instance.players.get(2).getMarbles().get(0);
    expResult = new Play(card, new Move(2, 0, instance.getBoard().getSafeBoardIndex(2)));
    result = instance.getPlayForCardKingAndMarble(playerNumber, card, marble);
    assertEquals(expResult, result);

    // test with player's marble, with opponents marble in player's safe spot
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getStartMinBoardIndex(0));
    instance.players.get(1).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getSafeBoardIndex(0));
    playerNumber = 0;
    card = new Card(Rank.KING, Suit.CLUBS);
    marble = instance.players.get(0).getMarbles().get(0);
    Set<Move> moves = new LinkedHashSet<>();
    moves.add(new Move(0, 0, instance.getBoard().getSafeBoardIndex(0)));
    moves.add(new Move(1, 0, instance.getBoard().getStartMinBoardIndex(1)));
    expResult = new Play(card, moves);
    result = instance.getPlayForCardKingAndMarble(playerNumber, card, marble);
    assertEquals(expResult, result);

    // test with player's marble, and Ace card
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getStartMinBoardIndex(0));
    playerNumber = 0;
    card = new Card(Rank.ACE, Suit.CLUBS);
    marble = instance.players.get(0).getMarbles().get(0);
    expResult = new Play(card, new Move(0, 0, instance.getBoard().getSafeBoardIndex(0)));
    result = instance.getPlayForCardKingAndMarble(playerNumber, card, marble);
    assertEquals(expResult, result);

  }

  /**
   * Test of getPlayForCardSevenAndMarbles method, of class Game.
   *
   * @throws Exception if an error occurred
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testGetPlayForCardSevenAndMarbles() throws Exception {

    System.out.println("getPlayForCardSevenAndMarbles");

    // test with invalid player number
    Game instance = new Game(4);
    int playerNumber = -1;
    Card card = null;
    Marble marble1 = null;
    Marble marble2 = null;
    int splitValue1 = 0;
    try {
      instance.getPlayForCardSevenAndMarbles(playerNumber, card, marble1, marble2, splitValue1);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    } catch (InvalidPlayException ex) {
      fail("Illegal argument exception not thrown");
    }

    // test invalid player number
    instance = new Game(4);
    playerNumber = 4;
    card = null;
    marble1 = null;
    marble2 = null;
    splitValue1 = 0;
    try {
      instance.getPlayForCardSevenAndMarbles(playerNumber, card, marble1, marble2, splitValue1);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    } catch (InvalidPlayException ex) {
      fail("Illegal argument exception not thrown");
    }

    // test null card
    instance = new Game(4);
    playerNumber = 0;
    card = null;
    marble1 = null;
    marble2 = null;
    splitValue1 = 0;
    try {
      instance.getPlayForCardSevenAndMarbles(playerNumber, card, marble1, marble2, splitValue1);
      fail("Null pointer exception not thrown");
    } catch (InvalidPlayException ex) {
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with invalid card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.EIGHT, Suit.CLUBS);
    marble1 = null;
    marble2 = null;
    splitValue1 = 0;
    try {
      instance.getPlayForCardSevenAndMarbles(playerNumber, card, marble1, marble2, splitValue1);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    } catch (InvalidPlayException ex) {
      fail("Illegal argument exception not thrown");
    }

    // test null marble 1
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    marble1 = null;
    marble2 = null;
    splitValue1 = 0;
    try {
      instance.getPlayForCardSevenAndMarbles(playerNumber, card, marble1, marble2, splitValue1);
      fail("Null pointer exception not thrown");
    } catch (InvalidPlayException ex) {
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test null marble 2
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    marble1 = new Marble(0, 0, 0);
    marble2 = null;
    splitValue1 = 0;
    try {
      instance.getPlayForCardSevenAndMarbles(playerNumber, card, marble1, marble2, splitValue1);
      fail("Null pointer exception not thrown");
    } catch (InvalidPlayException ex) {
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with invalid split value 1
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    marble1 = new Marble(0, 0, 0);
    marble2 = new Marble(0, 0, 0);
    splitValue1 = 0;
    try {
      instance.getPlayForCardSevenAndMarbles(playerNumber, card, marble1, marble2, splitValue1);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    } catch (InvalidPlayException ex) {
      fail("Illegal argument exception not thrown");
    }

    // test with invalid split value 1
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    marble1 = new Marble(0, 0, 0);
    marble2 = new Marble(0, 0, 0);
    splitValue1 = 7;
    try {
      instance.getPlayForCardSevenAndMarbles(playerNumber, card, marble1, marble2, splitValue1);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    } catch (InvalidPlayException ex) {
      fail("Illegal argument exception not thrown");
    }

    // test moving the same marble for both moves
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    playerNumber = 0;
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    marble1 = instance.players.get(0).getMarbles().get(0);
    marble2 = instance.players.get(0).getMarbles().get(0);
    splitValue1 = 1;
    try {
      instance.getPlayForCardSevenAndMarbles(playerNumber, card, marble1, marble2, splitValue1);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test moving player's marble and opponents marble
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(1).getMarbles().get(0).setBoardIndex(15);
    playerNumber = 0;
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    marble1 = instance.players.get(0).getMarbles().get(0);
    marble2 = instance.players.get(1).getMarbles().get(0);
    splitValue1 = 1;
    try {
      instance.getPlayForCardSevenAndMarbles(playerNumber, card, marble1, marble2, splitValue1);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test moving player's partner's marble and opponents marble
    instance = new Game(4);
    instance.players.get(2).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(1).getMarbles().get(0).setBoardIndex(15);
    playerNumber = 0;
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    marble1 = instance.players.get(2).getMarbles().get(0);
    marble2 = instance.players.get(1).getMarbles().get(0);
    splitValue1 = 1;
    try {
      instance.getPlayForCardSevenAndMarbles(playerNumber, card, marble1, marble2, splitValue1);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test moving opponents marble and player's marble
    instance = new Game(4);
    instance.players.get(1).getMarbles().get(0).setBoardIndex(15);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    playerNumber = 0;
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    marble1 = instance.players.get(1).getMarbles().get(0);
    marble2 = instance.players.get(0).getMarbles().get(0);
    splitValue1 = 1;
    try {
      instance.getPlayForCardSevenAndMarbles(playerNumber, card, marble1, marble2, splitValue1);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test moving opponents marble and player's partner's marble
    instance = new Game(4);
    instance.players.get(1).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(2).getMarbles().get(0).setBoardIndex(15);
    playerNumber = 0;
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    marble1 = instance.players.get(1).getMarbles().get(0);
    marble2 = instance.players.get(2).getMarbles().get(0);
    splitValue1 = 1;
    try {
      instance.getPlayForCardSevenAndMarbles(playerNumber, card, marble1, marble2, splitValue1);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test moving opponents marble and opponents marble
    instance = new Game(4);
    instance.players.get(1).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(3).getMarbles().get(0).setBoardIndex(15);
    playerNumber = 0;
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    marble1 = instance.players.get(1).getMarbles().get(0);
    marble2 = instance.players.get(3).getMarbles().get(0);
    splitValue1 = 1;
    try {
      instance.getPlayForCardSevenAndMarbles(playerNumber, card, marble1, marble2, splitValue1);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test moving two of the player's marbles
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(0).getMarbles().get(1).setBoardIndex(1);
    playerNumber = 0;
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    marble1 = instance.players.get(0).getMarbles().get(0);
    marble2 = instance.players.get(0).getMarbles().get(1);
    splitValue1 = 1;
    try {
      instance.getPlayForCardSevenAndMarbles(playerNumber, card, marble1, marble2, splitValue1);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test moving two of the player's marbles
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(0).getMarbles().get(1).setBoardIndex(1);
    playerNumber = 0;
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    marble1 = instance.players.get(0).getMarbles().get(1);
    marble2 = instance.players.get(0).getMarbles().get(0);
    splitValue1 = 1;
    Set<Move> moves = new LinkedHashSet<>();
    moves.add(new Move(0, 1, 2));
    moves.add(new Move(0, 0, 6));
    Play expResult = new Play(card, moves);
    Play result = instance.getPlayForCardSevenAndMarbles(playerNumber, card, marble1, marble2,
        splitValue1);
    assertEquals(expResult, result);

    // test moving two of the player's partner's marbles
    instance = new Game(4);
    instance.players.get(2).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(2).getMarbles().get(1).setBoardIndex(1);
    playerNumber = 0;
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    marble1 = instance.players.get(2).getMarbles().get(0);
    marble2 = instance.players.get(2).getMarbles().get(1);
    splitValue1 = 1;
    try {
      instance.getPlayForCardSevenAndMarbles(playerNumber, card, marble1, marble2, splitValue1);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test moving two of the player's partner's marbles
    instance = new Game(4);
    instance.players.get(2).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(2).getMarbles().get(1).setBoardIndex(1);
    playerNumber = 0;
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    marble1 = instance.players.get(2).getMarbles().get(1);
    marble2 = instance.players.get(2).getMarbles().get(0);
    splitValue1 = 1;
    moves = new LinkedHashSet<>();
    moves.add(new Move(2, 1, 2));
    moves.add(new Move(2, 0, 6));
    expResult = new Play(card, moves);
    result = instance.getPlayForCardSevenAndMarbles(playerNumber, card, marble1, marble2,
        splitValue1);
    assertEquals(expResult, result);

    // test when there is no move
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(0).getMarbles().get(1).setBoardIndex(
        instance.getBoard().getStartMinBoardIndex(0));
    playerNumber = 0;
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    marble1 = instance.players.get(0).getMarbles().get(0);
    marble2 = instance.players.get(0).getMarbles().get(1);
    splitValue1 = 1;
    try {
      instance.getPlayForCardSevenAndMarbles(playerNumber, card, marble1, marble2, splitValue1);
      fail("Invalid play exception not thrown");
    } catch (InvalidPlayException ex) {
      // do nothing
    }

    // test moving two of the player's marbles with a split value of 4
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(0).getMarbles().get(1).setBoardIndex(24);
    playerNumber = 0;
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    marble1 = instance.players.get(0).getMarbles().get(0);
    marble2 = instance.players.get(0).getMarbles().get(1);
    splitValue1 = 4;
    moves = new LinkedHashSet<>();
    moves.add(new Move(0, 0, 4));
    moves.add(new Move(0, 1, 27));
    expResult = new Play(card, moves);
    result = instance.getPlayForCardSevenAndMarbles(playerNumber, card, marble1, marble2,
        splitValue1);
    assertEquals(expResult, result);

  }

  /**
   * Test of getPlayers method, of class Game.
   */
  @Test
  public void testGetPlayers() {

    System.out.println("getPlayers");

    Game instance = new Game(4);
    assertEquals(instance.getNumberOfPlayers(), instance.getPlayers().size());

  }

  /**
   * Test of getPlays method, of class Game.
   */
  @Test
  public void testGetPlays() {

    System.out.println("getPlays");

    // test invalid player number
    Game instance = new Game(4);
    int playerNumber = -1;
    try {
      instance.getPlays(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test invalid player number
    instance = new Game(4);
    playerNumber = 4;
    try {
      instance.getPlays(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with Ace card
    instance = new Game(4);
    Card card = new Card(Rank.ACE, Suit.CLUBS);
    instance.players.get(0).getCards().add(card);
    playerNumber = 0;
    Set<Play> expResult = new LinkedHashSet<>();
    expResult.add(new Play(card, new Move(0, 0, instance.getBoard().getSafeBoardIndex(0))));
    expResult.add(new Play(card, new Move(0, 1, instance.getBoard().getSafeBoardIndex(0))));
    expResult.add(new Play(card, new Move(0, 2, instance.getBoard().getSafeBoardIndex(0))));
    expResult.add(new Play(card, new Move(0, 3, instance.getBoard().getSafeBoardIndex(0))));
    expResult.add(new Play(card, new Move(2, 0, instance.getBoard().getSafeBoardIndex(2))));
    expResult.add(new Play(card, new Move(2, 1, instance.getBoard().getSafeBoardIndex(2))));
    expResult.add(new Play(card, new Move(2, 2, instance.getBoard().getSafeBoardIndex(2))));
    expResult.add(new Play(card, new Move(2, 3, instance.getBoard().getSafeBoardIndex(2))));
    Set<Play> result = instance.getPlays(playerNumber);
    assertEquals(expResult, result);

    // test with 2 card
    instance = new Game(4);
    card = new Card(Rank.TWO, Suit.CLUBS);
    instance.players.get(0).getCards().add(card);
    playerNumber = 0;
    expResult = new LinkedHashSet<>();
    result = instance.getPlays(playerNumber);
    assertEquals(expResult, result);

    // test with 2 card
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      for (int j = 0; j < Game.NUMBER_OF_MARBLES_PER_PLAYER; j++) {
        instance = new Game(4);
        instance.players.get(i).getMarbles().get(j).setBoardIndex(0);
        instance.players.get(instance.getNextPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(13);
        instance.players.get(instance.getPartnerPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(27);
        card = new Card(Rank.TWO, Suit.CLUBS);
        instance.players.get(i).getCards().add(card);
        playerNumber = i;
        expResult = new LinkedHashSet<>();
        expResult.add(new Play(card, new Move(i, j, 2)));
        expResult.add(new Play(card, new Move(instance.getPartnerPlayerNumber(i), j, 29)));
        result = instance.getPlays(playerNumber);
        assertEquals(expResult, result);
      }
    }

    // test with 3 card
    instance = new Game(4);
    card = new Card(Rank.THREE, Suit.CLUBS);
    instance.players.get(0).getCards().add(card);
    playerNumber = 0;
    expResult = new LinkedHashSet<>();
    result = instance.getPlays(playerNumber);
    assertEquals(expResult, result);

    // test with 3 card
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      for (int j = 0; j < Game.NUMBER_OF_MARBLES_PER_PLAYER; j++) {
        instance = new Game(4);
        instance.players.get(i).getMarbles().get(j).setBoardIndex(0);
        instance.players.get(instance.getNextPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(13);
        instance.players.get(instance.getPartnerPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(27);
        card = new Card(Rank.THREE, Suit.CLUBS);
        instance.players.get(i).getCards().add(card);
        playerNumber = i;
        expResult = new LinkedHashSet<>();
        expResult.add(new Play(card, new Move(i, j, 3)));
        expResult.add(new Play(card, new Move(instance.getPartnerPlayerNumber(i), j, 30)));
        result = instance.getPlays(playerNumber);
        assertEquals(expResult, result);
      }
    }

    // test with 4 card
    instance = new Game(4);
    card = new Card(Rank.FOUR, Suit.CLUBS);
    instance.players.get(0).getCards().add(card);
    playerNumber = 0;
    expResult = new LinkedHashSet<>();
    result = instance.getPlays(playerNumber);
    assertEquals(expResult, result);

    // test with 4 card
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      for (int j = 0; j < Game.NUMBER_OF_MARBLES_PER_PLAYER; j++) {
        instance = new Game(4);
        instance.players.get(i).getMarbles().get(j).setBoardIndex(4);
        instance.players.get(instance.getNextPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(13);
        instance.players.get(instance.getPartnerPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(33);
        card = new Card(Rank.FOUR, Suit.CLUBS);
        instance.players.get(i).getCards().add(card);
        playerNumber = i;
        expResult = new LinkedHashSet<>();
        expResult.add(new Play(card, new Move(i, j, 0)));
        expResult.add(new Play(card, new Move(instance.getPartnerPlayerNumber(i), j, 29)));
        result = instance.getPlays(playerNumber);
        assertEquals(expResult, result);
      }
    }

    // test with 5 card
    instance = new Game(4);
    card = new Card(Rank.FIVE, Suit.CLUBS);
    instance.players.get(0).getCards().add(card);
    playerNumber = 0;
    expResult = new LinkedHashSet<>();
    result = instance.getPlays(playerNumber);
    assertEquals(expResult, result);

    // test with 5 card
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      for (int j = 0; j < Game.NUMBER_OF_MARBLES_PER_PLAYER; j++) {
        instance = new Game(4);
        instance.players.get(i).getMarbles().get(j).setBoardIndex(0);
        instance.players.get(instance.getNextPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(13);
        instance.players.get(instance.getPartnerPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(27);
        card = new Card(Rank.FIVE, Suit.CLUBS);
        instance.players.get(i).getCards().add(card);
        playerNumber = i;
        expResult = new LinkedHashSet<>();
        expResult.add(new Play(card, new Move(i, j, 5)));
        expResult.add(new Play(card, new Move(instance.getPartnerPlayerNumber(i), j, 32)));
        result = instance.getPlays(playerNumber);
        assertEquals(expResult, result);
      }
    }

    // test with 6 card
    instance = new Game(4);
    card = new Card(Rank.SIX, Suit.CLUBS);
    instance.players.get(0).getCards().add(card);
    playerNumber = 0;
    expResult = new LinkedHashSet<>();
    result = instance.getPlays(playerNumber);
    assertEquals(expResult, result);

    // test with 6 card
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      for (int j = 0; j < Game.NUMBER_OF_MARBLES_PER_PLAYER; j++) {
        instance = new Game(4);
        instance.players.get(i).getMarbles().get(j).setBoardIndex(0);
        instance.players.get(instance.getNextPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(13);
        instance.players.get(instance.getPartnerPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(27);
        card = new Card(Rank.SIX, Suit.CLUBS);
        instance.players.get(i).getCards().add(card);
        playerNumber = i;
        expResult = new LinkedHashSet<>();
        expResult.add(new Play(card, new Move(i, j, 6)));
        expResult.add(new Play(card, new Move(instance.getPartnerPlayerNumber(i), j, 33)));
        result = instance.getPlays(playerNumber);
        assertEquals(expResult, result);
      }
    }

    // test with 7 card
    instance = new Game(4);
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    instance.players.get(0).getCards().add(card);
    playerNumber = 0;
    expResult = new LinkedHashSet<>();
    result = instance.getPlays(playerNumber);
    assertEquals(expResult, result);

    // test with 7 card
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      for (int j = 0; j < Game.NUMBER_OF_MARBLES_PER_PLAYER; j++) {

        instance = new Game(4);
        instance.players.get(i).getMarbles().get(j).setBoardIndex(0);
        instance.players.get(instance.getNextPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(13);
        instance.players.get(instance.getPartnerPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(27);
        card = new Card(Rank.SEVEN, Suit.CLUBS);
        instance.players.get(i).getCards().add(card);
        playerNumber = i;

        expResult = new LinkedHashSet<>();
        expResult.add(new Play(card, new Move(i, j, 7)));

        Set<Move> moves = new LinkedHashSet<>();
        moves.add(new Move(i, j, 1));
        moves.add(new Move(instance.getPartnerPlayerNumber(i), j, 33));
        expResult.add(new Play(card, moves));

        moves = new LinkedHashSet<>();
        moves.add(new Move(i, j, 2));
        moves.add(new Move(instance.getPartnerPlayerNumber(i), j, 32));
        expResult.add(new Play(card, moves));

        moves = new LinkedHashSet<>();
        moves.add(new Move(i, j, 3));
        moves.add(new Move(instance.getPartnerPlayerNumber(i), j, 31));
        expResult.add(new Play(card, moves));

        moves = new LinkedHashSet<>();
        moves.add(new Move(i, j, 4));
        moves.add(new Move(instance.getPartnerPlayerNumber(i), j, 30));
        expResult.add(new Play(card, moves));

        moves = new LinkedHashSet<>();
        moves.add(new Move(i, j, 5));
        moves.add(new Move(instance.getPartnerPlayerNumber(i), j, 29));
        expResult.add(new Play(card, moves));

        moves = new LinkedHashSet<>();
        moves.add(new Move(i, j, 6));
        moves.add(new Move(instance.getPartnerPlayerNumber(i), j, 28));
        expResult.add(new Play(card, moves));

        expResult.add(new Play(card, new Move(instance.getPartnerPlayerNumber(i), j, 34)));

        result = instance.getPlays(playerNumber);
        assertEquals(expResult, result);

      }
    }

    // test with 8 card
    instance = new Game(4);
    card = new Card(Rank.EIGHT, Suit.CLUBS);
    instance.players.get(0).getCards().add(card);
    playerNumber = 0;
    expResult = new LinkedHashSet<>();
    result = instance.getPlays(playerNumber);
    assertEquals(expResult, result);

    // test with 8 card
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      for (int j = 0; j < Game.NUMBER_OF_MARBLES_PER_PLAYER; j++) {
        instance = new Game(4);
        instance.players.get(i).getMarbles().get(j).setBoardIndex(0);
        instance.players.get(instance.getNextPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(13);
        instance.players.get(instance.getPartnerPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(27);
        card = new Card(Rank.EIGHT, Suit.CLUBS);
        instance.players.get(i).getCards().add(card);
        playerNumber = i;
        expResult = new LinkedHashSet<>();
        expResult.add(new Play(card, new Move(i, j, 8)));
        expResult.add(new Play(card, new Move(instance.getPartnerPlayerNumber(i), j, 35)));
        result = instance.getPlays(playerNumber);
        assertEquals(expResult, result);
      }
    }

    // test with 9 card
    instance = new Game(4);
    card = new Card(Rank.NINE, Suit.CLUBS);
    instance.players.get(0).getCards().add(card);
    playerNumber = 0;
    expResult = new LinkedHashSet<>();
    result = instance.getPlays(playerNumber);
    assertEquals(expResult, result);

    // test with 8 card
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      for (int j = 0; j < Game.NUMBER_OF_MARBLES_PER_PLAYER; j++) {
        instance = new Game(4);
        instance.players.get(i).getMarbles().get(j).setBoardIndex(0);
        instance.players.get(instance.getNextPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(13);
        instance.players.get(instance.getPartnerPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(27);
        card = new Card(Rank.NINE, Suit.CLUBS);
        instance.players.get(i).getCards().add(card);
        playerNumber = i;
        expResult = new LinkedHashSet<>();
        expResult.add(new Play(card, new Move(i, j, 9)));
        expResult.add(new Play(card, new Move(instance.getPartnerPlayerNumber(i), j, 36)));
        result = instance.getPlays(playerNumber);
        assertEquals(expResult, result);
      }
    }

    // test with 10 card
    instance = new Game(4);
    card = new Card(Rank.TEN, Suit.CLUBS);
    instance.players.get(0).getCards().add(card);
    playerNumber = 0;
    expResult = new LinkedHashSet<>();
    result = instance.getPlays(playerNumber);
    assertEquals(expResult, result);

    // test with 10 card
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      for (int j = 0; j < Game.NUMBER_OF_MARBLES_PER_PLAYER; j++) {
        instance = new Game(4);
        instance.players.get(i).getMarbles().get(j).setBoardIndex(0);
        instance.players.get(instance.getNextPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(13);
        instance.players.get(instance.getPartnerPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(27);
        card = new Card(Rank.TEN, Suit.CLUBS);
        instance.players.get(i).getCards().add(card);
        playerNumber = i;
        expResult = new LinkedHashSet<>();
        expResult.add(new Play(card, new Move(i, j, 10)));
        expResult.add(new Play(card, new Move(instance.getPartnerPlayerNumber(i), j, 37)));
        result = instance.getPlays(playerNumber);
        assertEquals(expResult, result);
      }
    }

    // test with Jack card
    instance = new Game(4);
    card = new Card(Rank.JACK, Suit.CLUBS);
    instance.players.get(0).getCards().add(card);
    playerNumber = 0;
    expResult = new LinkedHashSet<>();
    result = instance.getPlays(playerNumber);
    assertEquals(expResult, result);

    // test with Jack card
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      for (int j = 0; j < Game.NUMBER_OF_MARBLES_PER_PLAYER; j++) {
        instance = new Game(4);
        instance.players.get(i).getMarbles().get(j).setBoardIndex(0);
        instance.players.get(instance.getNextPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(13);
        instance.players.get(instance.getPartnerPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(27);
        card = new Card(Rank.JACK, Suit.CLUBS);
        instance.players.get(i).getCards().add(card);
        playerNumber = i;
        expResult = new LinkedHashSet<>();
        Set<Move> moves = new LinkedHashSet<>();
        moves.add(new Move(i, j, 13));
        moves.add(new Move(instance.getNextPlayerNumber(i), j, 0));
        expResult.add(new Play(card, moves));
        moves = new LinkedHashSet<>();
        moves.add(new Move(i, j, 27));
        moves.add(new Move(instance.getPartnerPlayerNumber(i), j, 0));
        expResult.add(new Play(card, moves));
        moves = new LinkedHashSet<>();
        moves.add(new Move(instance.getNextPlayerNumber(i), j, 27));
        moves.add(new Move(instance.getPartnerPlayerNumber(i), j, 13));
        expResult.add(new Play(card, moves));
        result = instance.getPlays(playerNumber);
        assertEquals(expResult, result);
      }
    }

    // test with Queen card
    instance = new Game(4);
    card = new Card(Rank.QUEEN, Suit.CLUBS);
    instance.players.get(0).getCards().add(card);
    playerNumber = 0;
    expResult = new LinkedHashSet<>();
    result = instance.getPlays(playerNumber);
    assertEquals(expResult, result);

    // test with Queen card
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      for (int j = 0; j < Game.NUMBER_OF_MARBLES_PER_PLAYER; j++) {
        instance = new Game(4);
        instance.players.get(i).getMarbles().get(j).setBoardIndex(0);
        instance.players.get(instance.getNextPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(13);
        instance.players.get(instance.getPartnerPlayerNumber(i)).getMarbles().get(j)
            .setBoardIndex(27);
        card = new Card(Rank.QUEEN, Suit.CLUBS);
        instance.players.get(i).getCards().add(card);
        playerNumber = i;
        expResult = new LinkedHashSet<>();
        expResult.add(new Play(card, new Move(i, j, 12)));
        expResult.add(new Play(card, new Move(instance.getPartnerPlayerNumber(i), j, 39)));
        result = instance.getPlays(playerNumber);
        assertEquals(expResult, result);
      }
    }

    // test with King card
    instance = new Game(4);
    card = new Card(Rank.KING, Suit.CLUBS);
    instance.players.get(0).getCards().add(card);
    playerNumber = 0;
    expResult = new LinkedHashSet<>();
    expResult.add(new Play(card, new Move(0, 0, instance.getBoard().getSafeBoardIndex(0))));
    expResult.add(new Play(card, new Move(0, 1, instance.getBoard().getSafeBoardIndex(0))));
    expResult.add(new Play(card, new Move(0, 2, instance.getBoard().getSafeBoardIndex(0))));
    expResult.add(new Play(card, new Move(0, 3, instance.getBoard().getSafeBoardIndex(0))));
    expResult.add(new Play(card, new Move(2, 0, instance.getBoard().getSafeBoardIndex(2))));
    expResult.add(new Play(card, new Move(2, 1, instance.getBoard().getSafeBoardIndex(2))));
    expResult.add(new Play(card, new Move(2, 2, instance.getBoard().getSafeBoardIndex(2))));
    expResult.add(new Play(card, new Move(2, 3, instance.getBoard().getSafeBoardIndex(2))));
    result = instance.getPlays(playerNumber);
    assertEquals(expResult, result);

  }

  /**
   * Test of getPlaysForCard method, of class Game.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testGetPlaysForCard() {

    System.out.println("getPlaysForCard");

    // test with invalid player number
    Game instance = new Game(4);
    int playerNumber = -1;
    Card card = null;
    try {
      instance.getPlaysForCard(playerNumber, card);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test invalid player number
    instance = new Game(4);
    playerNumber = 4;
    card = null;
    try {
      instance.getPlaysForCard(playerNumber, card);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test null card
    instance = new Game(4);
    playerNumber = 0;
    card = null;
    try {
      instance.getPlaysForCard(playerNumber, card);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with invalid card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    try {
      instance.getPlaysForCard(playerNumber, card);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with Ace card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.ACE, Suit.CLUBS);
    Set<Play> expResult = new LinkedHashSet<>();
    Set<Play> result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

    // test with Ace card
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    playerNumber = 0;
    card = new Card(Rank.ACE, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    expResult.add(new Play(card, new Move(0, 0, 1)));
    result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

    // test with 2 card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.TWO, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

    // test with 2 card
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    playerNumber = 0;
    card = new Card(Rank.TWO, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    expResult.add(new Play(card, new Move(0, 0, 2)));
    result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

    // test with 3 card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.THREE, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

    // test with 3 card
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    playerNumber = 0;
    card = new Card(Rank.THREE, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    expResult.add(new Play(card, new Move(0, 0, 3)));
    result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

    // test with 4 card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.FOUR, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

    // test with 4 card
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    playerNumber = 0;
    card = new Card(Rank.FOUR, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    expResult.add(new Play(card, new Move(0, 0, 52)));
    result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

    // test with 5 card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.FIVE, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

    // test with 5 card
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    playerNumber = 0;
    card = new Card(Rank.FIVE, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    expResult.add(new Play(card, new Move(0, 0, 5)));
    result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

    // test with 6 card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.SIX, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

    // test with 6 card
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    playerNumber = 0;
    card = new Card(Rank.SIX, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    expResult.add(new Play(card, new Move(0, 0, 6)));
    result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

    // test with 7 card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

    // test with 7 card
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    playerNumber = 0;
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    expResult.add(new Play(card, new Move(0, 0, 7)));
    result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

    // test with 8 card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.EIGHT, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

    // test with 8 card
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    playerNumber = 0;
    card = new Card(Rank.EIGHT, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    expResult.add(new Play(card, new Move(0, 0, 8)));
    result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

    // test with 9 card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.NINE, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

    // test with 9 card
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    playerNumber = 0;
    card = new Card(Rank.NINE, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    expResult.add(new Play(card, new Move(0, 0, 9)));
    result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

    // test with 10 card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.TEN, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

    // test with 10 card
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    playerNumber = 0;
    card = new Card(Rank.TEN, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    expResult.add(new Play(card, new Move(0, 0, 10)));
    result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

    // test with Queen card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.QUEEN, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

    // test with Queen card
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    playerNumber = 0;
    card = new Card(Rank.QUEEN, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    expResult.add(new Play(card, new Move(0, 0, 12)));
    result = instance.getPlaysForCard(playerNumber, card);
    assertEquals(expResult, result);

  }

  /**
   * Test of getPlaysForCardAce method, of class Game.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testGetPlaysForCardAce() {

    System.out.println("getPlaysForCardAce");

    // test with invalid player number
    Game instance = new Game(4);
    int playerNumber = -1;
    Card card = null;
    try {
      instance.getPlaysForCardAce(playerNumber, card);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test invalid player number
    instance = new Game(4);
    playerNumber = 4;
    card = null;
    try {
      instance.getPlaysForCardAce(playerNumber, card);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test null card
    instance = new Game(4);
    playerNumber = 0;
    card = null;
    try {
      instance.getPlaysForCardAce(playerNumber, card);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with invalid card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.EIGHT, Suit.CLUBS);
    try {
      instance.getPlaysForCardAce(playerNumber, card);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with all marbles in the start spaces
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.ACE, Suit.CLUBS);
    Set<Play> expResult = new LinkedHashSet<>();
    expResult.add(new Play(card, new Move(0, 0, instance.getBoard().getSafeBoardIndex(0))));
    expResult.add(new Play(card, new Move(0, 1, instance.getBoard().getSafeBoardIndex(0))));
    expResult.add(new Play(card, new Move(0, 2, instance.getBoard().getSafeBoardIndex(0))));
    expResult.add(new Play(card, new Move(0, 3, instance.getBoard().getSafeBoardIndex(0))));
    Set<Play> result = instance.getPlaysForCardAce(playerNumber, card);
    assertEquals(expResult, result);

    // test with all player marbles out of the start spaces
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(0).getMarbles().get(1).setBoardIndex(2);
    instance.players.get(0).getMarbles().get(2).setBoardIndex(4);
    instance.players.get(0).getMarbles().get(3).setBoardIndex(6);
    playerNumber = 0;
    card = new Card(Rank.ACE, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    expResult.add(new Play(card, new Move(0, 0, 1)));
    expResult.add(new Play(card, new Move(0, 1, 3)));
    expResult.add(new Play(card, new Move(0, 2, 5)));
    expResult.add(new Play(card, new Move(0, 3, 7)));
    result = instance.getPlaysForCardAce(playerNumber, card);
    assertEquals(expResult, result);

  }

  /**
   * Test of getPlaysForCardJack method, of class Game.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testGetPlaysForCardJack() {

    System.out.println("getPlaysForCardJack");

    // test with invalid player number
    Game instance = new Game(4);
    int playerNumber = -1;
    Card card = null;
    try {
      instance.getPlaysForCardJack(playerNumber, card);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test invalid player number
    instance = new Game(4);
    playerNumber = 4;
    card = null;
    try {
      instance.getPlaysForCardJack(playerNumber, card);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test null card
    instance = new Game(4);
    playerNumber = 0;
    card = null;
    try {
      instance.getPlaysForCardJack(playerNumber, card);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with invalid card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.EIGHT, Suit.CLUBS);
    try {
      instance.getPlaysForCardJack(playerNumber, card);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with all marbles in the start spaces
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.JACK, Suit.CLUBS);
    Set<Play> expResult = new LinkedHashSet<>();
    Set<Play> result = instance.getPlaysForCardJack(playerNumber, card);
    assertEquals(expResult, result);

    // test with marbles that can be swapped
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(instance.getNextPlayerNumber(0)).getMarbles().get(0).setBoardIndex(13);
    instance.players.get(instance.getPartnerPlayerNumber(0)).getMarbles().get(0).setBoardIndex(27);
    card = new Card(Rank.JACK, Suit.CLUBS);
    instance.players.get(0).getCards().add(card);
    playerNumber = 0;
    expResult = new LinkedHashSet<>();
    Set<Move> moves = new LinkedHashSet<>();
    moves.add(new Move(0, 0, 13));
    moves.add(new Move(instance.getNextPlayerNumber(0), 0, 0));
    expResult.add(new Play(card, moves));
    moves = new LinkedHashSet<>();
    moves.add(new Move(0, 0, 27));
    moves.add(new Move(instance.getPartnerPlayerNumber(0), 0, 0));
    expResult.add(new Play(card, moves));
    moves = new LinkedHashSet<>();
    moves.add(new Move(instance.getNextPlayerNumber(0), 0, 27));
    moves.add(new Move(instance.getPartnerPlayerNumber(0), 0, 13));
    expResult.add(new Play(card, moves));
    result = instance.getPlays(playerNumber);
    assertEquals(expResult, result);

  }

  /**
   * Test of getPlaysForCardKing method, of class Game.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testGetPlaysForCardKing() {

    System.out.println("getPlaysForCardKing");

    // test with invalid player number
    Game instance = new Game(4);
    int playerNumber = -1;
    Card card = null;
    try {
      instance.getPlaysForCardKing(playerNumber, card);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test invalid player number
    instance = new Game(4);
    playerNumber = 4;
    card = null;
    try {
      instance.getPlaysForCardKing(playerNumber, card);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test null card
    instance = new Game(4);
    playerNumber = 0;
    card = null;
    try {
      instance.getPlaysForCardKing(playerNumber, card);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with invalid card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.EIGHT, Suit.CLUBS);
    try {
      instance.getPlaysForCardKing(playerNumber, card);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with all player marbles out of the start spaces
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(1).getMarbles().get(0).setBoardIndex(1);
    instance.players.get(2).getMarbles().get(0).setBoardIndex(2);
    instance.players.get(3).getMarbles().get(0).setBoardIndex(3);
    playerNumber = 0;
    card = new Card(Rank.KING, Suit.CLUBS);
    Set<Play> expResult = new LinkedHashSet<>();
    Set<Play> result = instance.getPlaysForCardKing(playerNumber, card);
    assertEquals(expResult, result);

    // test with valid player number and King card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.KING, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    expResult.add(new Play(card, new Move(0, 0, instance.getBoard().getSafeBoardIndex(0))));
    expResult.add(new Play(card, new Move(0, 1, instance.getBoard().getSafeBoardIndex(0))));
    expResult.add(new Play(card, new Move(0, 2, instance.getBoard().getSafeBoardIndex(0))));
    expResult.add(new Play(card, new Move(0, 3, instance.getBoard().getSafeBoardIndex(0))));
    result = instance.getPlaysForCardKing(playerNumber, card);
    assertEquals(expResult, result);

    // test with valid player number and Ace card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.ACE, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    expResult.add(new Play(card, new Move(0, 0, instance.getBoard().getSafeBoardIndex(0))));
    expResult.add(new Play(card, new Move(0, 1, instance.getBoard().getSafeBoardIndex(0))));
    expResult.add(new Play(card, new Move(0, 2, instance.getBoard().getSafeBoardIndex(0))));
    expResult.add(new Play(card, new Move(0, 3, instance.getBoard().getSafeBoardIndex(0))));
    result = instance.getPlaysForCardKing(playerNumber, card);
    assertEquals(expResult, result);

  }

  /**
   * Test of getPlaysForCardSeven method, of class Game.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testGetPlaysForCardSeven() {

    System.out.println("getPlaysForCardSeven");

    // test with invalid player number
    Game instance = new Game(4);
    int playerNumber = -1;
    Card card = null;
    try {
      instance.getPlaysForCardSeven(playerNumber, card);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test invalid player number
    instance = new Game(4);
    playerNumber = 4;
    card = null;
    try {
      instance.getPlaysForCardSeven(playerNumber, card);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test null card
    instance = new Game(4);
    playerNumber = 0;
    card = null;
    try {
      instance.getPlaysForCardSeven(playerNumber, card);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with invalid card
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.EIGHT, Suit.CLUBS);
    try {
      instance.getPlaysForCardSeven(playerNumber, card);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with all marbles in the start spaces
    instance = new Game(4);
    playerNumber = 0;
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    Set<Play> expResult = new LinkedHashSet<>();
    Set<Play> result = instance.getPlaysForCardSeven(playerNumber, card);
    assertEquals(expResult, result);

    // test with marble on the board
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    playerNumber = 0;
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    expResult = new LinkedHashSet<>();
    expResult.add(new Play(card, new Move(0, 0, 7)));
    result = instance.getPlaysForCardSeven(playerNumber, card);
    assertEquals(expResult, result);

    // test with a split
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    instance.players.get(1).getMarbles().get(0).setBoardIndex(13);
    instance.players.get(2).getMarbles().get(0).setBoardIndex(27);
    card = new Card(Rank.SEVEN, Suit.CLUBS);
    instance.players.get(0).getCards().add(card);
    playerNumber = 0;
    expResult = new LinkedHashSet<>();
    expResult.add(new Play(card, new Move(0, 0, 7)));
    Set<Move> moves = new LinkedHashSet<>();
    moves.add(new Move(0, 0, 1));
    moves.add(new Move(2, 0, 33));
    expResult.add(new Play(card, moves));
    moves = new LinkedHashSet<>();
    moves.add(new Move(0, 0, 2));
    moves.add(new Move(2, 0, 32));
    expResult.add(new Play(card, moves));
    moves = new LinkedHashSet<>();
    moves.add(new Move(0, 0, 3));
    moves.add(new Move(2, 0, 31));
    expResult.add(new Play(card, moves));
    moves = new LinkedHashSet<>();
    moves.add(new Move(0, 0, 4));
    moves.add(new Move(2, 0, 30));
    expResult.add(new Play(card, moves));
    moves = new LinkedHashSet<>();
    moves.add(new Move(0, 0, 5));
    moves.add(new Move(2, 0, 29));
    expResult.add(new Play(card, moves));
    moves = new LinkedHashSet<>();
    moves.add(new Move(0, 0, 6));
    moves.add(new Move(2, 0, 28));
    expResult.add(new Play(card, moves));
    result = instance.getPlaysForCardSeven(playerNumber, card);
    assertEquals(expResult, result);

  }

  /**
   * Test of getPreviousPlayerNumber method, of class Game.
   */
  @Test
  public void testGetPreviousPlayerNumber() {

    System.out.println("getPreviousPlayerNumber");

    // test invalid player number, 4 players
    Game instance = new Game(4);
    int playerNumber = -1;
    try {
      instance.getPreviousPlayerNumber(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test invalid player number, 4 players
    instance = new Game(4);
    playerNumber = 4;
    try {
      instance.getPreviousPlayerNumber(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with player 0, 4 players
    instance = new Game(4);
    playerNumber = 0;
    int expResult = 3;
    int result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 1, 4 players
    instance = new Game(4);
    playerNumber = 1;
    expResult = 0;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 2, 4 players
    instance = new Game(4);
    playerNumber = 2;
    expResult = 1;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 3, 4 players
    instance = new Game(4);
    playerNumber = 3;
    expResult = 2;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test invalid player number, 6 players
    instance = new Game(6);
    playerNumber = 6;
    try {
      instance.getPreviousPlayerNumber(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with player 0, 6 players
    instance = new Game(6);
    playerNumber = 0;
    expResult = 5;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 1, 6 players
    instance = new Game(6);
    playerNumber = 1;
    expResult = 0;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 2, 6 players
    instance = new Game(6);
    playerNumber = 2;
    expResult = 1;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 3, 6 players
    instance = new Game(6);
    playerNumber = 3;
    expResult = 2;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 4, 6 players
    instance = new Game(6);
    playerNumber = 4;
    expResult = 3;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 5, 6 players
    instance = new Game(6);
    playerNumber = 5;
    expResult = 4;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test invalid player number, 8 players
    instance = new Game(8);
    playerNumber = 8;
    try {
      instance.getPreviousPlayerNumber(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with player 0, 8 players
    instance = new Game(8);
    playerNumber = 0;
    expResult = 7;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 1, 8 players
    instance = new Game(8);
    playerNumber = 1;
    expResult = 0;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 2, 8 players
    instance = new Game(8);
    playerNumber = 2;
    expResult = 1;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 3, 8 players
    instance = new Game(8);
    playerNumber = 3;
    expResult = 2;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 4, 8 players
    instance = new Game(8);
    playerNumber = 4;
    expResult = 3;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 5, 8 players
    instance = new Game(8);
    playerNumber = 5;
    expResult = 4;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 6, 8 players
    instance = new Game(8);
    playerNumber = 6;
    expResult = 5;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 7, 8 players
    instance = new Game(8);
    playerNumber = 7;
    expResult = 6;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test invalid player number, 10 players
    instance = new Game(10);
    playerNumber = 10;
    try {
      instance.getPreviousPlayerNumber(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with player 0, 10 players
    instance = new Game(10);
    playerNumber = 0;
    expResult = 9;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 1, 10 players
    instance = new Game(10);
    playerNumber = 1;
    expResult = 0;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 2, 10 players
    instance = new Game(10);
    playerNumber = 2;
    expResult = 1;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 3, 10 players
    instance = new Game(10);
    playerNumber = 3;
    expResult = 2;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 4, 10 players
    instance = new Game(10);
    playerNumber = 4;
    expResult = 3;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 5, 10 players
    instance = new Game(10);
    playerNumber = 5;
    expResult = 4;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 6, 10 players
    instance = new Game(10);
    playerNumber = 6;
    expResult = 5;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 7, 10 players
    instance = new Game(10);
    playerNumber = 7;
    expResult = 6;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 8, 10 players
    instance = new Game(10);
    playerNumber = 8;
    expResult = 7;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 9, 10 players
    instance = new Game(10);
    playerNumber = 9;
    expResult = 8;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test invalid player number, 12 players
    instance = new Game(12);
    playerNumber = 12;
    try {
      instance.getPreviousPlayerNumber(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with player 0, 12 players
    instance = new Game(12);
    playerNumber = 0;
    expResult = 11;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 1, 12 players
    instance = new Game(12);
    playerNumber = 1;
    expResult = 0;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 2, 12 players
    instance = new Game(12);
    playerNumber = 2;
    expResult = 1;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 3, 12 players
    instance = new Game(12);
    playerNumber = 3;
    expResult = 2;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 4, 12 players
    instance = new Game(12);
    playerNumber = 4;
    expResult = 3;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 5, 12 players
    instance = new Game(12);
    playerNumber = 5;
    expResult = 4;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 6, 12 players
    instance = new Game(12);
    playerNumber = 6;
    expResult = 5;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 7, 12 players
    instance = new Game(12);
    playerNumber = 7;
    expResult = 6;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 8, 12 players
    instance = new Game(12);
    playerNumber = 8;
    expResult = 7;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 9, 12 players
    instance = new Game(12);
    playerNumber = 9;
    expResult = 8;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 10, 12 players
    instance = new Game(12);
    playerNumber = 10;
    expResult = 9;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);

    // test with player 11, 12 players
    instance = new Game(12);
    playerNumber = 11;
    expResult = 10;
    result = instance.getPreviousPlayerNumber(playerNumber);
    assertEquals(expResult, result);
  }

  /**
   * Test of getWinningPlayerNumber method, of class Game.
   */
  @Test
  public void testGetWinningPlayerNumber() {

    System.out.println("getWinningPlayerNumber");

    // test new game
    Game instance = new Game(4);
    int expResult = -1;
    int result = instance.getWinningPlayerNumber();
    assertEquals(expResult, result);

    // test with player 0 done, but not player 2
    instance = new Game(4);
    for (int i = 0; i < Game.NUMBER_OF_MARBLES_PER_PLAYER; i++) {
      instance.players.get(0).getMarbles().get(i).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(0) + i);
    }
    expResult = -1;
    result = instance.getWinningPlayerNumber();
    assertEquals(expResult, result);

    // test with player 2 done, but not player 0
    instance = new Game(4);
    for (int i = 0; i < Game.NUMBER_OF_MARBLES_PER_PLAYER; i++) {
      instance.players.get(2).getMarbles().get(i).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(2) + i);
    }
    expResult = -1;
    result = instance.getWinningPlayerNumber();
    assertEquals(expResult, result);

    // test with player 0 and 2 winning
    instance = new Game(4);
    for (int i = 0; i < Game.NUMBER_OF_MARBLES_PER_PLAYER; i++) {
      instance.players.get(0).getMarbles().get(i).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(0) + i);
      instance.players.get(2).getMarbles().get(i).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(2) + i);
    }
    expResult = 0;
    result = instance.getWinningPlayerNumber();
    assertEquals(expResult, result);

    // test with player 1 done, but not player 3
    instance = new Game(4);
    for (int i = 0; i < Game.NUMBER_OF_MARBLES_PER_PLAYER; i++) {
      instance.players.get(1).getMarbles().get(i).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(1) + i);
    }
    expResult = -1;
    result = instance.getWinningPlayerNumber();
    assertEquals(expResult, result);

    // test with player 3 done, but not player 1
    instance = new Game(4);
    for (int i = 0; i < Game.NUMBER_OF_MARBLES_PER_PLAYER; i++) {
      instance.players.get(3).getMarbles().get(i).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(3) + i);
    }
    expResult = -1;
    result = instance.getWinningPlayerNumber();
    assertEquals(expResult, result);

    // test with player 1 and 3 winning
    instance = new Game(4);
    for (int i = 0; i < Game.NUMBER_OF_MARBLES_PER_PLAYER; i++) {
      instance.players.get(1).getMarbles().get(i).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(1) + i);
      instance.players.get(3).getMarbles().get(i).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(3) + i);
    }
    expResult = 1;
    result = instance.getWinningPlayerNumber();
    assertEquals(expResult, result);

    // test with all marbles in home spaces
    instance = new Game(4);
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      for (int j = 0; j < Game.NUMBER_OF_MARBLES_PER_PLAYER; j++) {
        instance.players.get(i).getMarbles().get(j).setBoardIndex(
            instance.getBoard().getHomeMinBoardIndex(i) + j);
      }
    }
    expResult = 0;
    result = instance.getWinningPlayerNumber();
    assertEquals(expResult, result);

  }

  /**
   * Test of hasMarbleInSafeSpace method, of class Game.
   */
  @Test
  public void testHasMarbleInSafeSpace() {

    System.out.println("hasMarbleInSafeSpace");

    // test invalid player number
    Game instance = new Game(4);
    int playerNumber = -1;
    try {
      instance.hasMarbleInSafeSpace(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test invalid player number
    instance = new Game(4);
    playerNumber = 4;
    try {
      instance.hasMarbleInSafeSpace(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with no marble in safe space
    instance = new Game(4);
    playerNumber = 0;
    boolean expResult = false;
    boolean result = instance.hasMarbleInSafeSpace(playerNumber);
    assertEquals(expResult, result);

    // test with marble in safe space
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getSafeBoardIndex(0));
    playerNumber = 0;
    expResult = true;
    result = instance.hasMarbleInSafeSpace(playerNumber);
    assertEquals(expResult, result);

  }

  /**
   * Test of hasMarbleInSpace method, of class Game.
   */
  @Test
  public void testHasMarbleInSpace() {

    System.out.println("hasMarbleInSpace");

    // test invalid player number
    Game instance = new Game(4);
    int playerNumber = -1;
    int boardIndex = 0;
    try {
      instance.hasMarbleInSpace(playerNumber, boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test invalid player number
    instance = new Game(4);
    playerNumber = 4;
    boardIndex = 0;
    try {
      instance.hasMarbleInSpace(playerNumber, boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test invalid board index
    instance = new Game(4);
    playerNumber = 0;
    boardIndex = -1;
    try {
      instance.hasMarbleInSpace(playerNumber, boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test invalid board index
    instance = new Game(4);
    playerNumber = 0;
    boardIndex = 89;
    try {
      instance.hasMarbleInSpace(playerNumber, boardIndex);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with no marble in space
    instance = new Game(4);
    playerNumber = 0;
    boardIndex = 0;
    boolean expResult = false;
    boolean result = instance.hasMarbleInSpace(playerNumber, boardIndex);
    assertEquals(expResult, result);

    // test with marble in space
    instance = new Game(4);
    playerNumber = 0;
    boardIndex = instance.getBoard().getStartMinBoardIndex(playerNumber);
    expResult = true;
    result = instance.hasMarbleInSpace(playerNumber, boardIndex);
    assertEquals(expResult, result);

  }

  /**
   * Test of isEveryPlayerOutOfCards method, of class Game.
   */
  @Test
  public void testIsEveryPlayerOutOfCards() {

    System.out.println("isEveryPlayerOutOfCards");

    // test new game
    Game instance = new Game(4);
    boolean expResult = true;
    boolean result = instance.isEveryPlayerOutOfCards();
    assertEquals(expResult, result);

    // test with each player have one card
    for (int i = 0; i < instance.getNumberOfPlayers(); i++) {
      instance = new Game(4);
      instance.players.get(i).getCards().add(new Card(Rank.ACE, Suit.CLUBS));
      expResult = false;
      result = instance.isEveryPlayerOutOfCards();
      assertEquals(expResult, result);
    }

  }

  /**
   * Test of isGameOver method, of class Game.
   */
  @Test
  public void testIsGameOver() {

    System.out.println("isGameOver");

    // test a new game
    Game instance = new Game(4);
    boolean expResult = false;
    boolean result = instance.isGameOver();
    assertEquals(expResult, result);

    // test with a game that is over
    instance = new Game(4);
    for (int i = 0; i < Game.NUMBER_OF_MARBLES_PER_PLAYER; i++) {
      instance.players.get(0).getMarbles().get(i).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(0) + i);
      instance.players.get(2).getMarbles().get(i).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(2) + i);
    }
    expResult = true;
    result = instance.isGameOver();
    assertEquals(expResult, result);

  }

  /**
   * Test of isMarbleInHomeSpace method, of class Game.
   */
  @Test
  public void testIsMarbleInHomeSpace() {

    System.out.println("isMarbleInHomeSpace");

    // test with null marble
    Game instance = new Game(4);
    try {
      Marble marble = null;
      instance.isMarbleInHomeSpace(marble);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with marble not in home space
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    boolean expResult = false;
    boolean result = instance.isMarbleInHomeSpace(instance.players.get(0).getMarbles().get(0));
    assertEquals(expResult, result);

    // test with marble not in home space
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(78);
    expResult = false;
    result = instance.isMarbleInHomeSpace(instance.players.get(0).getMarbles().get(0));
    assertEquals(expResult, result);

    // test with all marbles in the home spaces
    instance = new Game(4);
    for (Player player : instance.players) {
      for (Marble marble : player.getMarbles()) {
        marble.setBoardIndex(instance.getBoard().getHomeMinBoardIndex(player.getPlayerNumber())
            + marble.getMarbleNumber());
        expResult = true;
        result = instance.isMarbleInHomeSpace(marble);
        assertEquals(expResult, result);
      }
    }

  }

  /**
   * Test of isMarbleInSafeSpaceSafe method, of class Game.
   */
  @Test
  public void testIsMarbleInSafeSpaceSafe() {

    System.out.println("isMarbleInSafeSpaceSafe");

    // test invalid player number
    Game instance = new Game(4);
    int playerNumber = -1;
    try {
      instance.isMarbleInSafeSpaceSafe(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test invalid player number
    instance = new Game(4);
    playerNumber = 4;
    try {
      instance.isMarbleInSafeSpaceSafe(playerNumber);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with no marble in safe space
    instance = new Game(4);
    playerNumber = 0;
    boolean expResult = false;
    boolean result = instance.isMarbleInSafeSpaceSafe(playerNumber);
    assertEquals(expResult, result);

    // test with marble in safe space that did come from a start space
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getSafeBoardIndex(0));
    playerNumber = 0;
    expResult = false;
    result = instance.isMarbleInSafeSpaceSafe(playerNumber);
    assertEquals(expResult, result);

    // test with marble in safe space that came from a start space
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getSafeBoardIndex(0));
    instance.players.get(0).getMarbles().get(0).setPreviousBoardIndex(
        instance.getBoard().getStartMinBoardIndex(0));
    playerNumber = 0;
    expResult = true;
    result = instance.isMarbleInSafeSpaceSafe(playerNumber);
    assertEquals(expResult, result);

    // test with marble in safe space that came from another player's start space (invalid)
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(
        instance.getBoard().getSafeBoardIndex(0));
    instance.players.get(0).getMarbles().get(0).setPreviousBoardIndex(
        instance.getBoard().getStartMinBoardIndex(2));
    playerNumber = 0;
    expResult = false;
    result = instance.isMarbleInSafeSpaceSafe(playerNumber);
    assertEquals(expResult, result);

  }

  /**
   * Test of isMarbleInStartSpace method, of class Game.
   */
  @Test
  public void testIsMarbleInStartSpace() {

    System.out.println("isMarbleInStartSpace");

    // test with null marble
    Game instance = new Game(4);
    try {
      Marble marble = null;
      instance.isMarbleInStartSpace(marble);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with marble not in start space
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(0);
    boolean expResult = false;
    boolean result = instance.isMarbleInStartSpace(instance.players.get(0).getMarbles().get(0));
    assertEquals(expResult, result);

    // test with marble not in start space
    instance = new Game(4);
    instance.players.get(0).getMarbles().get(0).setBoardIndex(78);
    expResult = false;
    result = instance.isMarbleInStartSpace(instance.players.get(0).getMarbles().get(0));
    assertEquals(expResult, result);

    // test with initial game state
    instance = new Game(4);
    for (Player player : instance.players) {
      for (Marble marble : player.getMarbles()) {
        expResult = true;
        result = instance.isMarbleInStartSpace(marble);
        assertEquals(expResult, result);
      }
    }

  }

  /**
   * Test of play method, of class Game.
   */
  @Test
  public void testPlay() {

    System.out.println("play");

    for (int numberOfPlayers : Game.VALID_NUMBER_OF_PLAYERS) {
      Game game = new Game(numberOfPlayers);
      game.play();
      assertEquals(true, game.isGameOver());
    }

  }

  /**
   * Test of playerTurn method, of class Game.
   */
  @Test
  public void testPlayerTurn() {

    System.out.println("playerTurn");

    // test returned state when the game is over
    Game instance = new Game(4);
    for (int i = 0; i < Game.NUMBER_OF_MARBLES_PER_PLAYER; i++) {
      instance.players.get(0).getMarbles().get(i).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(0) + i);
      instance.players.get(2).getMarbles().get(i).setBoardIndex(
          instance.getBoard().getHomeMinBoardIndex(2) + i);
    }
    State expResult = State.GAME_OVER;
    State result = instance.playerTurn();
    assertEquals(expResult, result);

    // test returned state when all players are out of cards
    instance = new Game(4);
    expResult = State.DEAL_CARDS;
    result = instance.playerTurn();
    assertEquals(expResult, result);

    // test when there are no plays
    instance = new Game(4);
    instance.currentPlayer = 0;
    instance.players.get(0).getCards().add(new Card(Rank.TWO, Suit.CLUBS));
    expResult = State.PLAYER_TURN;
    result = instance.playerTurn();
    assertEquals(expResult, result);
    assertEquals(1, instance.currentPlayer);

    // test when there is a valid play, play selector did not automatically select play
    instance = new Game(4);
    instance.currentPlayer = 0;
    instance.players.get(0).getCards().add(new Card(Rank.KING, Suit.CLUBS));
    instance.players.get(0).setPlaySelector(new PlaySelector());
    expResult = State.PLAYER_TURN;
    result = instance.playerTurn();
    assertEquals(expResult, result);
    assertEquals(0, instance.currentPlayer);

    // test when there is a valid play, play selector automatically selected play
    instance = new Game(4);
    instance.currentPlayer = 0;
    instance.players.get(0).getCards().add(new Card(Rank.KING, Suit.CLUBS));
    expResult = State.PLAYER_TURN;
    result = instance.playerTurn();
    assertEquals(expResult, result);
    assertEquals(0, instance.players.get(0).getCards().size());
    assertEquals(0, instance.players.get(0).getMarbles().get(0).getBoardIndex());
    assertEquals(1, instance.currentPlayer);

    // test when there is a valid play, play selector selected play externally
    instance = new Game(4);
    instance.currentPlayer = 0;
    instance.players.get(0).getCards().add(new Card(Rank.KING, Suit.CLUBS));
    instance.players.get(0).setPlaySelector(new PlaySelector());
    instance.players.get(0).getPlaySelector().setSelectedPlay(
        new Play(instance.players.get(0).getCards().get(0), new Move(0, 0, 0)));
    expResult = State.PLAYER_TURN;
    result = instance.playerTurn();
    assertEquals(expResult, result);
    assertEquals(0, instance.players.get(0).getCards().size());
    assertEquals(0, instance.players.get(0).getMarbles().get(0).getBoardIndex());
    assertEquals(1, instance.currentPlayer);

    // test when play selector returns a play that was not in the set of available plays
    instance = new Game(4);
    instance.currentPlayer = 0;
    instance.players.get(0).getCards().add(new Card(Rank.KING, Suit.CLUBS));
    instance.players.get(0).setPlaySelector(new PlaySelector());
    instance.players.get(0).getPlaySelector().setSelectedPlay(
        new Play(new Card(Rank.ACE, Suit.CLUBS), new Move(0, 0, 0)));
    try {
      result = instance.playerTurn();
      fail("Illegal state exception not thrown");
    } catch (IllegalStateException ex) {
      // do nothing
    }

    // test cannot play event to make sure cards are cleared after event
    instance = new Game(4);
    instance.currentPlayer = 0;
    instance.getPlayers().get(0).getCards().add(new Card(Rank.EIGHT, Suit.CLUBS));
    instance.addEventListener((Event event) -> {
      CannotPlayGameEvent cannotPlayGameEvent = (CannotPlayGameEvent) event;
      assertFalse(cannotPlayGameEvent.getSource().getPlayers().get(
          cannotPlayGameEvent.getPlayerNumber()).getCards().isEmpty());
    });
    instance.playerTurn();

  }

  /**
   * Test of removeEventListener method, of class Game.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testRemoveEventListener() {

    System.out.println("removeEventListener");

    // test with null
    Game instance = new Game(4);
    EventListener eventListener = null;
    try {
      instance.removeEventListener(eventListener);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test adding then removing
    instance = new Game(4);
    assertEquals(0, instance.eventListeners.size());
    eventListener = (Event event) -> {
      // do nothing
    };
    instance.addEventListener(eventListener);
    assertEquals(1, instance.eventListeners.size());
    instance.removeEventListener(eventListener);
    assertEquals(0, instance.eventListeners.size());

  }

  /**
   * Test of validate method, of class Game.
   *
   * @throws Exception if an error occurred
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testValidate() throws Exception {

    System.out.println("validate");

    // test with null
    Game instance = new Game(4);
    UserPlay userPlay = null;
    try {
      instance.validate(userPlay);
      fail("Null pointer exception not thrown");
    } catch (InvalidPlayException ex) {
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with null card
    instance = new Game(4);
    userPlay = UserPlay.builder(0, null, null).build();
    try {
      instance.validate(userPlay);
      fail("Null pointer exception not thrown");
    } catch (InvalidPlayException ex) {
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with Ace card, marble in start space
    instance = new Game(4);
    userPlay = UserPlay.builder(0, new Card(Rank.ACE, Suit.CLUBS),
        instance.getPlayers().get(0).getMarbles().get(0)).build();
    instance.validate(userPlay);

    // test with Ace card, marble not in start space
    instance = new Game(4);
    instance.getPlayers().get(0).getMarbles().get(0).setBoardIndex(0);
    userPlay = UserPlay.builder(0, new Card(Rank.ACE, Suit.CLUBS),
        instance.getPlayers().get(0).getMarbles().get(0)).build();
    instance.validate(userPlay);

    // test with seven card, no split
    instance = new Game(4);
    instance.getPlayers().get(0).getMarbles().get(0).setBoardIndex(0);
    userPlay = UserPlay.builder(0, new Card(Rank.SEVEN, Suit.CLUBS),
        instance.getPlayers().get(0).getMarbles().get(0)).build();
    instance.validate(userPlay);

    // test with seven card, with split, missing split value
    instance = new Game(4);
    instance.getPlayers().get(0).getMarbles().get(0).setBoardIndex(0);
    instance.getPlayers().get(0).getMarbles().get(1).setBoardIndex(10);
    userPlay = UserPlay.builder(0, new Card(Rank.SEVEN, Suit.CLUBS),
        instance.getPlayers().get(0).getMarbles().get(0))
        .setMarble2(instance.getPlayers().get(0).getMarbles().get(1))
        .build();
    try {
      instance.validate(userPlay);
      fail("Illegal argument exception not thrown");
    } catch (IllegalArgumentException ex) {
      // do nothing
    }

    // test with seven card, with split, missing marble2
    instance = new Game(4);
    instance.getPlayers().get(0).getMarbles().get(0).setBoardIndex(0);
    instance.getPlayers().get(0).getMarbles().get(1).setBoardIndex(10);
    userPlay = UserPlay.builder(0, new Card(Rank.SEVEN, Suit.CLUBS),
        instance.getPlayers().get(0).getMarbles().get(0))
        .setSplitValue1(1)
        .build();
    try {
      instance.validate(userPlay);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with seven card, with split
    instance = new Game(4);
    instance.getPlayers().get(0).getMarbles().get(0).setBoardIndex(0);
    instance.getPlayers().get(0).getMarbles().get(1).setBoardIndex(10);
    userPlay = UserPlay.builder(0, new Card(Rank.SEVEN, Suit.CLUBS),
        instance.getPlayers().get(0).getMarbles().get(0))
        .setMarble2(instance.getPlayers().get(0).getMarbles().get(1))
        .setSplitValue1(1)
        .build();
    instance.validate(userPlay);

    // test with Jack card
    instance = new Game(4);
    instance.getPlayers().get(0).getMarbles().get(0).setBoardIndex(0);
    instance.getPlayers().get(1).getMarbles().get(0).setBoardIndex(10);
    userPlay = UserPlay.builder(0, new Card(Rank.JACK, Suit.CLUBS),
        instance.getPlayers().get(0).getMarbles().get(0))
        .setMarble2(instance.getPlayers().get(1).getMarbles().get(0))
        .build();
    instance.validate(userPlay);

    // test with King card
    instance = new Game(4);
    userPlay = UserPlay.builder(0, new Card(Rank.KING, Suit.CLUBS),
        instance.getPlayers().get(0).getMarbles().get(0))
        .build();
    instance.validate(userPlay);

    // test with numeric card
    instance = new Game(4);
    instance.getPlayers().get(0).getMarbles().get(0).setBoardIndex(0);
    userPlay = UserPlay.builder(0, new Card(Rank.TWO, Suit.CLUBS),
        instance.getPlayers().get(0).getMarbles().get(0))
        .build();
    instance.validate(userPlay);

  }

  /**
   * Test of equals method, of class Game.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testEquals() {

    System.out.println("equals");

    // test same object
    Object obj = new Game(4);
    Game instance = (Game) obj;
    boolean expResult = true;
    boolean result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with null
    obj = null;
    instance = new Game(4);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with different class
    obj = new Object();
    instance = new Game(4);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test equal objects
    obj = new Game(4);
    instance = new Game(4);
    expResult = true;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with different current dealer
    obj = new Game(4);
    instance = new Game(4);
    instance.currentDealer = 1;
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with different current player
    obj = new Game(4);
    instance = new Game(4);
    instance.currentPlayer = 1;
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with different number of players
    obj = new Game(4);
    instance = new Game(6);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with different card deck
    obj = new Game(4);
    instance = new Game(4);
    instance.cardDeck.dealCard();
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with different players
    obj = new Game(4);
    instance = new Game(4);
    instance.players.clear();
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with event listener
    obj = new Game(4);
    instance = new Game(4);
    instance.addEventListener((Event event) -> {
      // do nothing
    });
    expResult = true;
    result = instance.equals(obj);
    assertEquals(expResult, result);

  }

  /**
   * Test of hashCode method, of class Game.
   */
  @Test
  public void testHashCode() {

    System.out.println("hashCode");

    Game instance1 = new Game(4);
    Game instance2 = new Game(4);
    assertEquals(instance1.hashCode(), instance2.hashCode());

    // test with event listener
    instance1 = new Game(4);
    instance2 = new Game(4);
    instance2.addEventListener((Event event) -> {
      // do nothing
    });
    assertEquals(instance1.hashCode(), instance2.hashCode());

  }

  /**
   * Test of constructor method, of class Game.SplitCard.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testSplitCard() {

    System.out.println("split card constructor");

    // test with null rank
    Card.Rank rank = null;
    try {
      new SplitCard(rank);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

  }

  /**
   * Test of copy constructor method, of class Game.SplitCard.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testSplitCard_Card() {

    System.out.println("split card copy constructor");

    // test with null card
    Card card = null;
    try {
      new SplitCard(card);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with card
    card = new SplitCard(Card.Rank.TEN);
    SplitCard instance = new SplitCard(card);
    assertEquals(card, instance);

  }

}
