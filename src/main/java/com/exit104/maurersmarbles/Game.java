/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import com.google.common.base.Preconditions;

import com.exit104.maurersmarbles.event.CannotPlayGameEvent;
import com.exit104.maurersmarbles.event.DealtCardGameEvent;
import com.exit104.maurersmarbles.event.DeterminedDealerGameEvent;
import com.exit104.maurersmarbles.event.EnteringStateGameEvent;
import com.exit104.maurersmarbles.event.Event;
import com.exit104.maurersmarbles.event.EventListener;
import com.exit104.maurersmarbles.event.ExecutedPlayGameEvent;
import com.exit104.maurersmarbles.event.ExitedStateGameEvent;
import com.exit104.maurersmarbles.event.MovedMarbleGameEvent;
import com.exit104.maurersmarbles.event.PlayedCardGameEvent;
import com.exit104.maurersmarbles.event.ShuffledCardDeckGameEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * The Game class is used to play a game of Maurer's Marbles.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class Game {

  /**
   * The minimum number of cards that are dealt to each player.
   */
  protected static final int MIN_NUMBER_OF_CARDS_TO_DEAL = 4;
  /**
   * The number of marbles each player has.
   */
  public static final int NUMBER_OF_MARBLES_PER_PLAYER = 4;
  /**
   * The board for the game.
   */
  protected final transient Board board;
  /**
   * The card deck for the game.
   */
  protected final transient CardDeck cardDeck;
  /**
   * The player number that is currently the dealer.
   */
  protected transient int currentDealer;
  /**
   * The player number for the current player's turn.
   */
  protected transient int currentPlayer;
  /**
   * The number of players in the game.
   */
  protected final transient int numberOfPlayers;
  /**
   * The list of event listeners.
   */
  protected final transient List<EventListener> eventListeners = new ArrayList<>();
  /**
   * The list of players in the game.
   */
  protected final transient List<Player> players = new ArrayList<>();
  /**
   * The set that contains the valid number of players in a game.
   */
  public static final Set<Integer> VALID_NUMBER_OF_PLAYERS;
  /**
   * The state the game will execute next.
   */
  protected transient State nextState = State.DETERMINE_DEALER;

  static {

    Set<Integer> validNumberOfPlayers = new TreeSet<>();
    for (int numberOfPlayers = 4; numberOfPlayers <= 12; numberOfPlayers += 2) {
      validNumberOfPlayers.add(numberOfPlayers);
    }
    VALID_NUMBER_OF_PLAYERS = Collections.unmodifiableSet(validNumberOfPlayers);

  }

  /**
   * Creates a new Game with the given number of players.
   *
   * @param numberOfPlayers the number of players in the game (4, 6, 8, 10, or 12)
   * @throws IllegalArgumentException if the given number of players is invalid
   */
  public Game(int numberOfPlayers) {

    Preconditions.checkArgument(VALID_NUMBER_OF_PLAYERS.contains(numberOfPlayers),
        "Invalid number of players");

    this.numberOfPlayers = numberOfPlayers;

    // create the game board
    board = new Board(numberOfPlayers);

    // create the card deck
    cardDeck = new CardDeck();

    // create the players
    for (int playerNumber = 0; playerNumber < numberOfPlayers; playerNumber++) {

      Player player = new Player(playerNumber, new FirstPlaySelector());

      // initialize the player's marbles
      List<Marble> marbles = new ArrayList<>();
      for (int marbleNumber = 0; marbleNumber < NUMBER_OF_MARBLES_PER_PLAYER; marbleNumber++) {
        marbles.add(new Marble(playerNumber, marbleNumber,
            board.getStartMinBoardIndex(playerNumber) + marbleNumber));
      }
      player.getMarbles().addAll(marbles);

      players.add(player);

    }

  }

  /**
   * Creates a new Game using the given game. Note the list of event listeners is not copied.
   *
   * @param game the game to copy
   * @throws NullPointerException if the given game is null
   */
  protected Game(Game game) {

    Preconditions.checkNotNull(game, "Null game");

    this.board = game.board;
    this.cardDeck = new CardDeck(game.cardDeck);
    this.currentDealer = game.currentDealer;
    this.currentPlayer = game.currentPlayer;
    this.numberOfPlayers = game.numberOfPlayers;

    for (Player player : game.players) {
      this.players.add(new Player(player));
    }

    // do not copy the event listeners list
  }

  /**
   * Adds the given event listener to the list of event listeners.
   *
   * @param eventListener the event listener to add
   * @throws NullPointerException if the given event listener is null
   */
  public void addEventListener(EventListener eventListener) {
    Preconditions.checkNotNull(eventListener, "Null event listener");
    eventListeners.add(eventListener);
  }

  /**
   * Advances the game by executing the next game state.
   *
   * @return the next game state after advancing the game
   */
  public State advance() {

    State currentState = nextState;

    fireEvent(new EnteringStateGameEvent(this, currentState));

    switch (currentState) {
      case DETERMINE_DEALER:
        nextState = determineDealer();
        break;
      case DEAL_CARDS:
        nextState = dealCards();
        break;
      case PLAYER_TURN:
        nextState = playerTurn();
        break;
      default:
        // do nothing
        break;
    }

    fireEvent(new ExitedStateGameEvent(this, currentState));

    return nextState;

  }

  /**
   * Advances the current dealer and deals cards to each player using the card deck. If the card
   * deck is empty, it will automatically be reset and shuffled.
   *
   * @return State.PLAYER_TURN
   */
  protected State dealCards() {

    // advance the dealer
    currentDealer = getNextPlayerNumber(currentDealer);

    // check to see if we need to reset and shuffle the deck
    if (cardDeck.getUndealtCards().size() < numberOfPlayers * MIN_NUMBER_OF_CARDS_TO_DEAL) {
      cardDeck.reset();
      cardDeck.shuffle();
      fireEvent(new ShuffledCardDeckGameEvent(this, currentDealer));
    }

    // deal the cards to each player
    int numberOfCardsToDeal = getNumberOfCardsToDeal();
    for (int i = 0; i < numberOfCardsToDeal; i++) {
      int playerNumber = currentDealer;
      for (int j = 0; j < numberOfPlayers; j++) {
        playerNumber = getNextPlayerNumber(playerNumber);
        Card card = cardDeck.dealCard();
        players.get(playerNumber).getCards().add(card);
        fireEvent(new DealtCardGameEvent(this, currentDealer, card, playerNumber));
      }
    }

    // set the current player
    currentPlayer = getNextPlayerNumber(currentDealer);

    return State.PLAYER_TURN;

  }

  /**
   * Determines the first dealer for the game by dealing cards to each player until an Ace is dealt.
   * The player with the first Ace is the first dealer.
   *
   * @return State.DEAL_CARDS
   */
  protected State determineDealer() {

    // player 0 will deal the cards to determine who the first dealer is
    currentDealer = 0;

    // collect all of the cards and shuffle the deck
    cardDeck.reset();
    cardDeck.shuffle();
    fireEvent(new ShuffledCardDeckGameEvent(this, currentDealer));

    // deal cards face up until an Ace is dealt
    while (!cardDeck.getUndealtCards().isEmpty()) {
      Card card = cardDeck.dealCard();
      fireEvent(new DealtCardGameEvent(this, 0, card, currentDealer));
      if (card.getRank().equals(Card.Rank.ACE)) {
        // player with the first Ace is the first dealer
        break;
      }
      currentDealer = getNextPlayerNumber(currentDealer);
    }
    fireEvent(new DeterminedDealerGameEvent(this, currentDealer));

    /*
     * In the next game state, we automatically advance the dealer to the next player. We will set
     * the dealer to the previous player here so it gets set to the correct dealer in the next
     * state.
     */
    currentDealer = getPreviousPlayerNumber(currentDealer);

    // reset the card deck
    cardDeck.reset();
    cardDeck.shuffle();

    return State.DEAL_CARDS;

  }

  /**
   * Notifies the list of event listeners that the given event has occurred.
   *
   * @param event the event to dispatch
   * @throws NullPointerException if the given event is null
   */
  protected void fireEvent(Event event) {
    Preconditions.checkNotNull(event, "Null event");
    for (EventListener eventListener : eventListeners) {
      eventListener.handleEvent(event);
    }
  }

  /**
   * Executes the given move.
   *
   * @param move the move to execute
   * @throws NullPointerException if the given move is null
   */
  protected void executeMove(Move move) {

    Preconditions.checkNotNull(move, "Null move");

    Marble marble = players.get(move.getPlayerNumber()).getMarbles().get(move.getMarbleNumber());
    marble.setPreviousBoardIndex(marble.getBoardIndex());
    marble.setBoardIndex(move.getNewMarbleBoardIndex());

    fireEvent(new MovedMarbleGameEvent(this, move.getPlayerNumber(), move.getMarbleNumber(),
        marble.getPreviousBoardIndex(), move.getNewMarbleBoardIndex()));

  }

  /**
   * Executes the given play for the given player number.
   *
   * @param playerNumber the player number executing the play
   * @param play the play to execute
   * @throws IllegalArgumentException if the given player number is invalid
   * @throws NullPointerException if the given play is null
   */
  protected void executePlay(int playerNumber, Play play) {

    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < numberOfPlayers,
        "Invalid player number");
    Preconditions.checkNotNull(play, "Null play");

    // remove the card from the player's hand
    players.get(playerNumber).getCards().remove(play.getCard());
    fireEvent(new PlayedCardGameEvent(this, playerNumber, play.getCard()));

    // execute each move for the play
    for (Move move : play.getMoves()) {
      executeMove(move);
    }

    fireEvent(new ExecutedPlayGameEvent(this, playerNumber, play));

  }

  /**
   * Returns the board for the game.
   *
   * @return the board for the game
   */
  public Board getBoard() {
    return board;
  }

  /**
   * Returns the card deck for the game.
   *
   * @return the card deck for the game
   */
  public CardDeck getCardDeck() {
    return cardDeck;
  }

  /**
   * Returns a card for the given split value.
   *
   * @param splitValue the split value to get a card for
   * @return a card for the given split value
   * @throws IllegalArgumentException if the given split value is invalid
   */
  protected static SplitCard getCardForSplitValue(int splitValue) {

    switch (splitValue) {
      case 1:
        return SplitCard.SPLIT_CARD_ACE;
      case 2:
        return SplitCard.SPLIT_CARD_TWO;
      case 3:
        return SplitCard.SPLIT_CARD_THREE;
      case 4:
        return SplitCard.SPLIT_CARD_FOUR;
      case 5:
        return SplitCard.SPLIT_CARD_FIVE;
      case 6:
        return SplitCard.SPLIT_CARD_SIX;
      default:
        throw new IllegalArgumentException("Invalid split value");
    }

  }

  /**
   * Returns the player number that is currently the dealer.
   *
   * @return the player number that is currently the dealer
   */
  public int getCurrentDealer() {
    return currentDealer;
  }

  /**
   * Returns the player number for the current player's turn.
   *
   * @return the player number for the current player's turn
   */
  public int getCurrentPlayer() {
    return currentPlayer;
  }

  /**
   * Returns the board index of an empty start space for the given player number, or -1 if there are
   * no empty spaces.
   *
   * @param playerNumber the player number
   * @return the board index of an empty start space for the given player number, or -1 if there are
   * no empty spaces
   * @throws IllegalArgumentException if the given player number is invalid
   */
  protected int getEmptyStartSpace(int playerNumber) {

    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < numberOfPlayers,
        "Invalid player number");

    for (int boardIndex = board.getStartMinBoardIndex(playerNumber);
        boardIndex <= board.getStartMaxBoardIndex(playerNumber); boardIndex++) {

      boolean spaceIsEmpty = true;

      for (Marble marble : players.get(playerNumber).getMarbles()) {
        if (marble.getBoardIndex() == boardIndex) {
          spaceIsEmpty = false;
          break;
        }
      }

      if (spaceIsEmpty) {
        return boardIndex;
      }

    }

    return -1;

  }

  /**
   * Returns the marble in the given space, or null if no marble is in the space.
   *
   * @param boardIndex the board index to get the marble for
   * @return the marble in the given space, or null if no marble is in the space
   * @throws IllegalArgumentException if the given board index is invalid
   */
  protected Marble getMarbleInSpace(int boardIndex) {

    Preconditions.checkArgument(boardIndex >= 0
        && boardIndex < board.getNumberOfPlayableSpaces(), "Invalid board index");

    for (Player player : players) {
      for (Marble marble : player.getMarbles()) {
        if (marble.getBoardIndex() == boardIndex) {
          return marble;
        }
      }
    }

    return null;

  }

  /**
   * Returns the next player number.
   *
   * @param playerNumber the current player number
   * @return the next player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public int getNextPlayerNumber(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < numberOfPlayers,
        "Invalid player number");
    return (playerNumber + 1) % numberOfPlayers;
  }

  /**
   * Returns the state the game will execute next.
   *
   * @return the state the game will execute next
   */
  public State getNextState() {
    return nextState;
  }

  /**
   * Returns the number of cards to deal to each player.
   *
   * @return the number of cards to deal to each player
   */
  protected int getNumberOfCardsToDeal() {
    switch (numberOfPlayers) {
      case 4:
        return MIN_NUMBER_OF_CARDS_TO_DEAL + (cardDeck.getDealtCards().isEmpty() ? 1 : 0);
      case 8:
        return MIN_NUMBER_OF_CARDS_TO_DEAL + 1;
      case 10:
        return MIN_NUMBER_OF_CARDS_TO_DEAL + 1;
      default:
        return MIN_NUMBER_OF_CARDS_TO_DEAL;
    }
  }

  /**
   * Returns the number of marbles the given player number has in the home spaces.
   *
   * @param playerNumber the player number
   * @return the number of marbles the given player number has in the home spaces
   * @throws IllegalArgumentException if the given player number is invalid
   */
  protected int getNumberOfMarblesInHomeSpace(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < numberOfPlayers,
        "Invalid player number");
    int count = 0;
    for (Marble marble : players.get(playerNumber).getMarbles()) {
      if (isMarbleInHomeSpace(marble)) {
        count++;
      }
    }
    return count;
  }

  /**
   * Returns the number of players in the game.
   *
   * @return the number of players in the game
   */
  public int getNumberOfPlayers() {
    return numberOfPlayers;
  }

  /**
   * Returns the number of spaces to move for the given card (any card except Jack or King).
   *
   * @param card the card (any card except Jack or King)
   * @return the number of spaces to move for the given card (any card except Jack or King)
   * @throws IllegalArgumentException if given an invalid card
   * @throws NullPointerException if the given card is null
   */
  protected static int getNumberOfSpacesForCard(Card card) {

    Preconditions.checkNotNull(card, "Null card");

    switch (card.getRank()) {
      case ACE:
        return 1;
      case TWO:
        return 2;
      case THREE:
        return 3;
      case FOUR:
        return card instanceof SplitCard ? 4 : -4;
      case FIVE:
        return 5;
      case SIX:
        return 6;
      case SEVEN:
        return 7;
      case EIGHT:
        return 8;
      case NINE:
        return 9;
      case TEN:
        return 10;
      case QUEEN:
        return 12;
      case JACK:
      // falls through
      case KING:
      // falls through
      default:
        throw new IllegalArgumentException("Invalid card");
    }

  }

  /**
   * Returns the number of teams in the game.
   *
   * @return the number of teams in the game
   */
  public int getNumberOfTeams() {
    return numberOfPlayers / 2;
  }

  /**
   * Returns the player number for the given player number's partner.
   *
   * @param playerNumber the player number to get the partner for
   * @return the player number for the given player number's partner
   * @throws IllegalArgumentException if the given player number is invalid
   */
  protected int getPartnerPlayerNumber(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < numberOfPlayers,
        "Invalid player number");
    return (playerNumber + (numberOfPlayers / 2)) % numberOfPlayers;
  }

  /**
   * Returns the play for the given player number, card (any card except Jack or King), and marble.
   *
   * @param playerNumber the player number
   * @param card the card (any card except Jack or King)
   * @param marble the marble
   * @return the play for the given player number, card (any card except Jack or King), and marble
   * @throws IllegalArgumentException if the given player number or card is invalid
   * @throws InvalidPlayException if there is no valid play
   * @throws NullPointerException if the given card or marble is null
   */
  protected Play getPlayForCardAndMarble(int playerNumber, Card card, Marble marble)
      throws InvalidPlayException {

    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < numberOfPlayers,
        "Invalid player number");
    Preconditions.checkNotNull(card, "Null card");
    Preconditions.checkArgument(card.getRank().equals(Card.Rank.ACE)
        || card.getRank().equals(Card.Rank.TWO) || card.getRank().equals(Card.Rank.THREE)
        || card.getRank().equals(Card.Rank.FOUR) || card.getRank().equals(Card.Rank.FIVE)
        || card.getRank().equals(Card.Rank.SIX) || card.getRank().equals(Card.Rank.SEVEN)
        || card.getRank().equals(Card.Rank.EIGHT) || card.getRank().equals(Card.Rank.NINE)
        || card.getRank().equals(Card.Rank.TEN) || card.getRank().equals(Card.Rank.QUEEN),
        "Invalid card");
    Preconditions.checkNotNull(marble, "Null marble");

    // check to make sure the given marble is the player's or the player's partner
    if (marble.getPlayerNumber() != playerNumber
        && marble.getPlayerNumber() != getPartnerPlayerNumber(playerNumber)) {
      throw InvalidPlayException.CANNOT_PLAY_OPPONENT_MARBLE;
    }

    // check to see if the marble is in a start space
    if (isMarbleInStartSpace(marble)) {
      throw InvalidPlayException.CANNOT_PLAY_MARBLE_IN_START_SPACE;
    }

    // compute the new board index for the marble if the card was applied
    int newMarbleBoardIndex = marble.getBoardIndex() + getNumberOfSpacesForCard(card);

    // check to see if the marble is in a home space
    if (isMarbleInHomeSpace(marble)) {

      // cannot play a four, which goes backwards
      if (card.getRank().equals(Card.Rank.FOUR)) {
        throw InvalidPlayException.CANNOT_GO_BACKWARDS_IN_HOME_SPACE;
      }

      // cannot go beyond the home spaces
      if (newMarbleBoardIndex > board.getHomeMaxBoardIndex(marble.getPlayerNumber())) {
        throw InvalidPlayException.CANNOT_GO_BEYOND_HOME_SPACES;
      }

      // cannot land on or pass another marble in a home space
      for (int boardIndex = marble.getBoardIndex() + 1; boardIndex <= newMarbleBoardIndex;
          boardIndex++) {
        if (hasMarbleInSpace(marble.getPlayerNumber(), boardIndex)) {
          throw InvalidPlayException.CANNOT_LAND_ON_OR_PASS_MARBLE_IN_HOME_SPACE;
        }
      }

      // the marble can be moved with the card
      return new Play(card, new Move(marble.getPlayerNumber(), marble.getMarbleNumber(),
          newMarbleBoardIndex));

    }

    // check to see if we passed the marble's home entry space
    if (marble.getBoardIndex() <= board.getHomeEntryBoardIndex(marble.getPlayerNumber())
        && newMarbleBoardIndex > board.getHomeEntryBoardIndex(marble.getPlayerNumber())) {

      int numberOfSpacesBeyondHomeEntry = newMarbleBoardIndex - board.getHomeEntryBoardIndex(
          marble.getPlayerNumber());

      // cannot go beyond the home spaces
      if (numberOfSpacesBeyondHomeEntry > board.getNumberOfHomeSpacesPerPlayer()) {
        throw InvalidPlayException.CANNOT_GO_BEYOND_HOME_SPACES;
      }

      // cannot land on or pass another marble in a home space
      for (int offset = 0; offset < numberOfSpacesBeyondHomeEntry; offset++) {
        if (hasMarbleInSpace(marble.getPlayerNumber(),
            board.getHomeMinBoardIndex(marble.getPlayerNumber()) + offset)) {
          throw InvalidPlayException.CANNOT_LAND_ON_OR_PASS_MARBLE_IN_HOME_SPACE;
        }
      }

      // the marble can be moved with the card
      return new Play(card, new Move(marble.getPlayerNumber(), marble.getMarbleNumber(),
          board.getHomeMinBoardIndex(marble.getPlayerNumber())
          + numberOfSpacesBeyondHomeEntry - 1));

    }

    // check if we wrapped around the board, the board index starts with 0 at player 0's safe spot
    boolean wrappedBoardIndex = false;
    if (newMarbleBoardIndex >= board.getNumberOfPerimeterSpaces()) {
      wrappedBoardIndex = true;
      newMarbleBoardIndex -= board.getNumberOfPerimeterSpaces();
    } else if (newMarbleBoardIndex < 0) {
      wrappedBoardIndex = true;
      newMarbleBoardIndex += board.getNumberOfPerimeterSpaces();
    }

    // check to see if we landed on player's marble or player's partner's marble
    if (hasMarbleInSpace(playerNumber, newMarbleBoardIndex)) {
      throw InvalidPlayException.CANNOT_LAND_ON_OWN_MARBLE;
    } else if (hasMarbleInSpace(getPartnerPlayerNumber(playerNumber), newMarbleBoardIndex)) {
      throw InvalidPlayException.CANNOT_LAND_ON_PARTNER_MARBLE;
    }

    // check to see if we landed on a safe marble
    for (int i = 0; i < numberOfPlayers; i++) {
      if (newMarbleBoardIndex == board.getSafeBoardIndex(i)
          && isMarbleInSafeSpaceSafe(i)) {
        throw InvalidPlayException.CANNOT_LAND_ON_SAFE_MARBLE;
      }
    }

    // check to see if we passed a safe marble (ignoring this marble if it is a safe space)
    if (marble.getBoardIndex() != board.getSafeBoardIndex(marble.getPlayerNumber())) {

      for (int i = 0; i < numberOfPlayers; i++) {

        if (isMarbleInSafeSpaceSafe(i)) {

          /*
           * Player i has a safe marble in their safe space. Check to see if the marble cross the
           * player's safe space. The board indexes start with 0 at player 0's safe space so we need
           * to do an additional check to handle the board index wrapping around.
           */
          if (i > 0) {
            if (marble.getBoardIndex() < board.getSafeBoardIndex(i)
                && newMarbleBoardIndex > board.getSafeBoardIndex(i)
                && !wrappedBoardIndex
                || marble.getBoardIndex() > board.getSafeBoardIndex(i)
                && newMarbleBoardIndex < board.getSafeBoardIndex(i)
                && !wrappedBoardIndex) {
              throw InvalidPlayException.CANNOT_PASS_SAFE_MARBLE;
            }
          } else if (wrappedBoardIndex) {
            throw InvalidPlayException.CANNOT_PASS_SAFE_MARBLE;
          }

        }

      }

    }

    // create the moves for this play
    Set<Move> moves = new LinkedHashSet<>();
    moves.add(new Move(marble.getPlayerNumber(), marble.getMarbleNumber(), newMarbleBoardIndex));
    Marble previousMarble = getMarbleInSpace(newMarbleBoardIndex);
    if (previousMarble != null) {
      moves.add(new Move(previousMarble.getPlayerNumber(), previousMarble.getMarbleNumber(),
          getEmptyStartSpace(previousMarble.getPlayerNumber())));
    }

    return new Play(card, moves);

  }

  /**
   * Returns the play for the given player number, card (a Jack), marble 1, and marble 2.
   *
   * @param playerNumber the player number
   * @param card the card (a Jack)
   * @param marble1 the first marble to swap
   * @param marble2 the second marble to swap
   * @return the play for the given player number, card (a Jack), marble 1, and marble 2
   * @throws IllegalArgumentException if the given player number, or card is invalid
   * @throws InvalidPlayException if there is no valid play
   * @throws NullPointerException if the given card, marble 1, or marble 2 is null
   */
  protected Play getPlayForCardJackAndMarbles(int playerNumber, Card card, Marble marble1,
      Marble marble2) throws InvalidPlayException {

    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < numberOfPlayers,
        "Invalid player number");
    Preconditions.checkNotNull(card, "Null card");
    Preconditions.checkArgument(card.getRank().equals(Card.Rank.JACK), "Invalid card");
    Preconditions.checkNotNull(marble1, "Null marble1");
    Preconditions.checkNotNull(marble2, "Null marble2");

    // check to make sure two different marbles were given
    if (marble1.equals(marble2)) {
      throw InvalidPlayException.CANNOT_SWAP_SAME_MARBLE;
    }

    // check to make sure marbles belong to two different players
    if (marble1.getPlayerNumber() == marble2.getPlayerNumber()) {
      throw InvalidPlayException.CANNOT_SWAP_SAME_PLAYER_MARBLE;
    }

    // check to make sure one of the given marbles are the player's or the player's partner's
    if (marble1.getPlayerNumber() != playerNumber
        && marble1.getPlayerNumber() != getPartnerPlayerNumber(playerNumber)
        && marble2.getPlayerNumber() != playerNumber
        && marble2.getPlayerNumber() != getPartnerPlayerNumber(playerNumber)) {
      throw InvalidPlayException.CANNOT_SWAP_TWO_OPPONENT_MARBLES;
    }

    // check to make sure marble 1 is not in a start space
    if (isMarbleInStartSpace(marble1)) {
      throw InvalidPlayException.CANNOT_SWAP_MARBLE_IN_START_SPACE;
    }

    // check to make sure marble 1 is not in a home space
    if (isMarbleInHomeSpace(marble1)) {
      throw InvalidPlayException.CANNOT_SWAP_MARBLE_IN_HOME_SPACE;
    }

    // check to see if marble 1 is opponent's marble and safe in a safe space
    if (marble1.getPlayerNumber() != playerNumber
        && marble1.getPlayerNumber() != getPartnerPlayerNumber(playerNumber)
        && marble1.getBoardIndex() == board.getSafeBoardIndex(marble1.getPlayerNumber())
        && isMarbleInSafeSpaceSafe(marble1.getPlayerNumber())) {
      throw InvalidPlayException.CANNOT_SWAP_OPPONENT_SAFE_MARBLE;
    }

    // check to make sure marble 2 is not in a start space
    if (isMarbleInStartSpace(marble2)) {
      throw InvalidPlayException.CANNOT_SWAP_MARBLE_IN_START_SPACE;
    }

    // check to make sure marble 2 is not in a home space
    if (isMarbleInHomeSpace(marble2)) {
      throw InvalidPlayException.CANNOT_SWAP_MARBLE_IN_HOME_SPACE;
    }

    // check to see if marble 2 is opponent's marble and safe in a safe space
    if (marble2.getPlayerNumber() != playerNumber
        && marble2.getPlayerNumber() != getPartnerPlayerNumber(playerNumber)
        && marble2.getBoardIndex() == board.getSafeBoardIndex(marble2.getPlayerNumber())
        && isMarbleInSafeSpaceSafe(marble2.getPlayerNumber())) {
      throw InvalidPlayException.CANNOT_SWAP_OPPONENT_SAFE_MARBLE;
    }

    // create the moves for this play
    Set<Move> moves = new LinkedHashSet<>();
    moves.add(new Move(marble1.getPlayerNumber(), marble1.getMarbleNumber(),
        marble2.getBoardIndex()));
    moves.add(new Move(marble2.getPlayerNumber(), marble2.getMarbleNumber(),
        marble1.getBoardIndex()));

    return new Play(card, moves);

  }

  /**
   * Returns the play for the given player number, card (a King or Ace), and marble.
   *
   * @param playerNumber the player number
   * @param card the card (a King or Ace)
   * @param marble the marble
   * @return the play for the given player number, card (a King or Ace), and marble
   * @throws IllegalArgumentException if the given player number or card is invalid
   * @throws InvalidPlayException if there is no valid play
   * @throws NullPointerException if the given card or marble is null
   */
  protected Play getPlayForCardKingAndMarble(int playerNumber, Card card, Marble marble)
      throws InvalidPlayException {

    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < numberOfPlayers,
        "Invalid player number");
    Preconditions.checkNotNull(card, "Null card");
    Preconditions.checkArgument(card.getRank().equals(Card.Rank.KING)
        || card.getRank().equals(Card.Rank.ACE), "Invalid card");
    Preconditions.checkNotNull(marble, "Null marble");

    // check to make sure the given marble is the player's or the player's partner
    if (marble.getPlayerNumber() != playerNumber
        && marble.getPlayerNumber() != getPartnerPlayerNumber(playerNumber)) {
      throw InvalidPlayException.CANNOT_PLAY_OPPONENT_MARBLE;
    }

    // check to make sure marble is in a start space
    if (!isMarbleInStartSpace(marble)) {
      throw InvalidPlayException.CANNOT_PLAY_MARBLE_NOT_IN_START_SPACE;
    }

    // check to make sure marble's player does not have one of their own marbles in their safe space
    if (hasMarbleInSafeSpace(marble.getPlayerNumber())) {
      throw InvalidPlayException.CANNOT_LAND_ON_OWN_MARBLE;
    }

    // check to make sure marble's player's partner does not have a marble in the marble's player's
    // safe space
    if (hasMarbleInSpace(getPartnerPlayerNumber(marble.getPlayerNumber()),
        board.getSafeBoardIndex(marble.getPlayerNumber()))) {
      throw InvalidPlayException.CANNOT_LAND_ON_PARTNER_MARBLE;
    }

    // create the moves for this play
    Set<Move> moves = new LinkedHashSet<>();
    moves.add(new Move(marble.getPlayerNumber(), marble.getMarbleNumber(),
        board.getSafeBoardIndex(marble.getPlayerNumber())));
    Marble previousMarble = getMarbleInSpace(board.getSafeBoardIndex(marble.getPlayerNumber()));
    if (previousMarble != null) {
      moves.add(new Move(previousMarble.getPlayerNumber(), previousMarble.getMarbleNumber(),
          getEmptyStartSpace(previousMarble.getPlayerNumber())));
    }

    return new Play(card, moves);

  }

  /**
   * Returns the play for the given player number, card (a Seven), marble 1, marble 2, and split
   * value 1.
   *
   * @param playerNumber the player number
   * @param card the card (a Seven)
   * @param marble1 the first marble to move
   * @param marble2 the second marble to move
   * @param splitValue1 the split value to move the first marble, the second marble will be moved by
   * 7 - splitValue1
   * @return the play for the given player number, card (a Seven), marble 1, marble 2, and split
   * value 1
   * @throws IllegalArgumentException if the given player number, card, or split value 1 is invalid
   * @throws InvalidPlayException if there is no valid play
   * @throws NullPointerException if the given card, marble 1, or marble 2 is null
   */
  protected Play getPlayForCardSevenAndMarbles(int playerNumber, Card card, Marble marble1,
      Marble marble2, int splitValue1) throws InvalidPlayException {

    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < numberOfPlayers,
        "Invalid player number");
    Preconditions.checkNotNull(card, "Null card");
    Preconditions.checkArgument(card.getRank().equals(Card.Rank.SEVEN), "Invalid card");
    Preconditions.checkNotNull(marble1, "Null marble1");
    Preconditions.checkNotNull(marble2, "Null marble2");
    Preconditions.checkArgument(splitValue1 >= 1 && splitValue1 < 7, "Invalid split value 1");

    // check to make sure two different marbles were given
    if (marble1.equals(marble2)) {
      throw InvalidPlayException.CANNOT_SPLIT_SAME_MARBLE;
    }

    // check to make sure the given marbles are the player's or the player's partner's
    if (marble1.getPlayerNumber() != playerNumber
        && marble1.getPlayerNumber() != getPartnerPlayerNumber(playerNumber)
        || marble2.getPlayerNumber() != playerNumber
        && marble2.getPlayerNumber() != getPartnerPlayerNumber(playerNumber)) {
      throw InvalidPlayException.CANNOT_SPLIT_TWO_OPPONENT_MARBLES;
    }

    // create temporary cards for the split play
    Card card1 = getCardForSplitValue(splitValue1);
    Card card2 = getCardForSplitValue(7 - splitValue1);

    // get the first play for moving marble 1
    Play play1 = getPlayForCardAndMarble(playerNumber, card1, marble1);

    /*
     * In order to determine what plays are valid for the second move of the split, the first move
     * needs to be executed. To do this, we will create a new Game with the same state, execute play
     * 1, and then get the valid plays for play 2.
     */
    Game game = new Game(this);
    game.executePlay(playerNumber, play1);

    // get the second play for moving marble 2
    Play play2 = game.getPlayForCardAndMarble(playerNumber, card2, marble2);

    // create the moves for this play
    Set<Move> moves = new LinkedHashSet<>();
    moves.addAll(play1.getMoves());
    moves.addAll(play2.getMoves());

    return new Play(card, moves);

  }

  /**
   * Returns the list of players in the game.
   *
   * @return the list of players in the game
   */
  public List<Player> getPlayers() {
    return players;
  }

  /**
   * Returns the set of plays for the given player number.
   *
   * @param playerNumber the player number
   * @return the set of plays for the given player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  protected Set<Play> getPlays(int playerNumber) {

    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < numberOfPlayers,
        "Invalid player number");

    Set<Play> plays = new LinkedHashSet<>();

    // loop through the list of player cards
    for (Card card : players.get(playerNumber).getCards()) {

      // get plays for the given player number and their partner
      for (int i = 0, currentPlayerNumber = playerNumber; i < 2;
          i++, currentPlayerNumber = getPartnerPlayerNumber(playerNumber)) {

        switch (card.getRank()) {
          case ACE:
            plays.addAll(getPlaysForCardAce(currentPlayerNumber, card));
            break;
          case SEVEN:
            plays.addAll(getPlaysForCardSeven(currentPlayerNumber, card));
            break;
          case JACK:
            plays.addAll(getPlaysForCardJack(currentPlayerNumber, card));
            break;
          case KING:
            plays.addAll(getPlaysForCardKing(currentPlayerNumber, card));
            break;
          default:
            plays.addAll(getPlaysForCard(currentPlayerNumber, card));
            break;
        }

      }

    }

    return plays;

  }

  /**
   * Returns the plays for the given player number and the given card (any card except Jack or
   * King).
   *
   * @param playerNumber the player number
   * @param card the card (any card except Jack or King)
   * @return the plays for the given player number and the given card (any card except Jack or King)
   * @throws IllegalArgumentException if the given player number or card is invalid
   * @throws NullPointerException if the given card is null
   */
  protected Set<Play> getPlaysForCard(int playerNumber, Card card) {

    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < numberOfPlayers,
        "Invalid player number");
    Preconditions.checkNotNull(card, "Null card");
    Preconditions.checkArgument(card.getRank().equals(Card.Rank.ACE)
        || card.getRank().equals(Card.Rank.TWO) || card.getRank().equals(Card.Rank.THREE)
        || card.getRank().equals(Card.Rank.FOUR) || card.getRank().equals(Card.Rank.FIVE)
        || card.getRank().equals(Card.Rank.SIX) || card.getRank().equals(Card.Rank.SEVEN)
        || card.getRank().equals(Card.Rank.EIGHT) || card.getRank().equals(Card.Rank.NINE)
        || card.getRank().equals(Card.Rank.TEN) || card.getRank().equals(Card.Rank.QUEEN),
        "Invalid card");

    // add the plays for each player marble
    Set<Play> plays = new LinkedHashSet<>();
    for (Marble marble : players.get(playerNumber).getMarbles()) {
      try {
        plays.add(getPlayForCardAndMarble(playerNumber, card, marble));
      } catch (InvalidPlayException ex) {
        // do nothing
      }
    }

    return plays;

  }

  /**
   * Returns the plays for the given player number and the given card (an Ace).
   *
   * @param playerNumber the player number
   * @param card the card (an Ace)
   * @return the plays for the given player number and the given card (an Ace)
   * @throws IllegalArgumentException if the given player number or card is invalid
   * @throws NullPointerException if the given card is null
   */
  protected Set<Play> getPlaysForCardAce(int playerNumber, Card card) {

    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < numberOfPlayers,
        "Invalid player number");
    Preconditions.checkNotNull(card, "Null card");
    Preconditions.checkArgument(card.getRank().equals(Card.Rank.ACE), "Invalid card");

    Set<Play> plays = new LinkedHashSet<>();
    plays.addAll(getPlaysForCardKing(playerNumber, card));
    plays.addAll(getPlaysForCard(playerNumber, card));
    return plays;

  }

  /**
   * Returns the plays for the given player number and the given card (a Jack).
   *
   * @param playerNumber the player number
   * @param card the card (a Jack)
   * @return the plays for the given player number and the given card (a Jack)
   * @throws IllegalArgumentException if the given player number or card is invalid
   * @throws NullPointerException if the given card is null
   */
  protected Set<Play> getPlaysForCardJack(int playerNumber, Card card) {

    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < numberOfPlayers,
        "Invalid player number");
    Preconditions.checkNotNull(card, "Null card");
    Preconditions.checkArgument(card.getRank().equals(Card.Rank.JACK), "Invalid card");

    Set<Play> plays = new LinkedHashSet<>();

    for (int otherPlayerNumber = 0; otherPlayerNumber < numberOfPlayers;
        otherPlayerNumber++) {

      if (otherPlayerNumber == playerNumber) {
        // cannot swap player's marbles with their own marbles
        continue;
      }

      // check if we can swap any of the player's marbles
      for (int marbleNumber = 0; marbleNumber < NUMBER_OF_MARBLES_PER_PLAYER; marbleNumber++) {

        // try swapping with the other player's marbles
        for (int theirMarbleNumber = 0; theirMarbleNumber < NUMBER_OF_MARBLES_PER_PLAYER;
            theirMarbleNumber++) {

          try {
            plays.add(getPlayForCardJackAndMarbles(playerNumber, card,
                players.get(playerNumber).getMarbles().get(marbleNumber),
                players.get(otherPlayerNumber).getMarbles().get(theirMarbleNumber)));
          } catch (InvalidPlayException ex) {
            // do nothing
          }

        }

      }

    }

    return plays;

  }

  /**
   * Returns the plays for the given player number and the given card (a King or Ace).
   *
   * @param playerNumber the player number
   * @param card the card (a King or Ace)
   * @return the plays for the given player number and the given card (a King or Ace)
   * @throws IllegalArgumentException if the given player number or card is invalid
   * @throws NullPointerException if the given card is null
   */
  protected Set<Play> getPlaysForCardKing(int playerNumber, Card card) {

    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < numberOfPlayers,
        "Invalid player number");
    Preconditions.checkNotNull(card, "Null card");
    Preconditions.checkArgument(card.getRank().equals(Card.Rank.KING)
        || card.getRank().equals(Card.Rank.ACE), "Invalid card");

    // add the plays for each player marble
    Set<Play> plays = new LinkedHashSet<>();
    for (Marble marble : players.get(playerNumber).getMarbles()) {
      try {
        plays.add(getPlayForCardKingAndMarble(playerNumber, card, marble));
      } catch (InvalidPlayException ex) {
        // do nothing
      }
    }

    return plays;

  }

  /**
   * Returns the plays for the given player number and the given card (a seven).
   *
   * @param playerNumber the player number
   * @param card the card (a seven)
   * @return the plays for the given player number and the given card (a seven)
   * @throws IllegalArgumentException if the given player number or card is invalid
   * @throws NullPointerException if the given card is null
   */
  protected Set<Play> getPlaysForCardSeven(int playerNumber, Card card) {

    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < numberOfPlayers,
        "Invalid player number");
    Preconditions.checkNotNull(card, "Null card");
    Preconditions.checkArgument(card.getRank().equals(Card.Rank.SEVEN), "Invalid card");

    Set<Play> plays = new LinkedHashSet<>();

    // add the plays for moving one marble seven spaces
    plays.addAll(getPlaysForCard(playerNumber, card));

    // add the plays for splitting the seven and moving two marbles
    for (int splitValue1 = 1; splitValue1 < 7; splitValue1++) {

      // for the first marble, try using each of the player's marbles
      for (int marbleNumber1 = 0; marbleNumber1 < NUMBER_OF_MARBLES_PER_PLAYER; marbleNumber1++) {

        // for the second marble, try using the player's marbles and player's partner's marbles
        for (int i = 0, splitPlayerNumber = playerNumber; i < 2;
            i++, splitPlayerNumber = getPartnerPlayerNumber(playerNumber)) {

          // try the marbles for the split player number
          for (int marbleNumber2 = 0; marbleNumber2 < NUMBER_OF_MARBLES_PER_PLAYER;
              marbleNumber2++) {

            try {
              plays.add(getPlayForCardSevenAndMarbles(playerNumber, card,
                  players.get(playerNumber).getMarbles().get(marbleNumber1),
                  players.get(splitPlayerNumber).getMarbles().get(marbleNumber2), splitValue1));
            } catch (InvalidPlayException ex) {
              // do nothing
            }

          }

        }

      }

    }

    return plays;

  }

  /**
   * Returns the previous player number.
   *
   * @param playerNumber the current player number
   * @return the previous player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public int getPreviousPlayerNumber(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < numberOfPlayers,
        "Invalid player number");
    return (playerNumber - 1) >= 0 ? playerNumber - 1 : numberOfPlayers - 1;
  }

  /**
   * Returns the winning player number (either 0 or 1), or -1 if there is no winner.
   *
   * @return the winning player number (either 0 or 1), or -1 if there is no winner
   */
  public int getWinningPlayerNumber() {
    for (int i = 0; i < numberOfPlayers / 2; i++) {
      if (getNumberOfMarblesInHomeSpace(i) == Game.NUMBER_OF_MARBLES_PER_PLAYER
          && getNumberOfMarblesInHomeSpace(
              getPartnerPlayerNumber(i)) == Game.NUMBER_OF_MARBLES_PER_PLAYER) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Returns whether or not the given player number has a marble in the safe space.
   *
   * @param playerNumber the player number
   * @return whether or not the given player number has a marble in the safe space
   * @throws IllegalArgumentException if the given player number is invalid
   */
  protected boolean hasMarbleInSafeSpace(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < numberOfPlayers,
        "Invalid player number");
    return hasMarbleInSpace(playerNumber, board.getSafeBoardIndex(playerNumber));
  }

  /**
   * Returns whether or not the given player number has a marble in the given space.
   *
   * @param playerNumber the player number
   * @param boardIndex the board index to check
   * @return whether or not the given player number has a marble in the given space
   * @throws IllegalArgumentException if the given player number or board index is invalid
   */
  protected boolean hasMarbleInSpace(int playerNumber, int boardIndex) {

    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < numberOfPlayers,
        "Invalid player number");
    Preconditions.checkArgument(boardIndex >= 0
        && boardIndex < board.getNumberOfPlayableSpaces(), "Invalid board index");

    for (Marble marble : players.get(playerNumber).getMarbles()) {
      if (marble.getBoardIndex() == boardIndex) {
        return true;
      }
    }

    return false;

  }

  /**
   * Returns whether or not all players are out of cards.
   *
   * @return whether or not all players are out of cards
   */
  protected boolean isEveryPlayerOutOfCards() {

    for (Player player : players) {
      if (!player.getCards().isEmpty()) {
        // player still has at least one card
        return false;
      }
    }

    // all players are out of cards
    return true;

  }

  /**
   * Returns whether or not the game is over (one of the teams won).
   *
   * @return whether or not the game is over
   */
  public boolean isGameOver() {
    return getWinningPlayerNumber() != -1;
  }

  /**
   * Returns whether or not the given marble is in a home space on the board.
   *
   * @param marble the marble
   * @return whether or not the given marble is in a home space on the board
   * @throws NullPointerException if the given marble is null
   */
  protected boolean isMarbleInHomeSpace(Marble marble) {
    Preconditions.checkNotNull(marble, "Null marble");
    return marble.getBoardIndex() >= board.getHomeMinBoardIndex(marble.getPlayerNumber())
        && marble.getBoardIndex() <= board.getHomeMaxBoardIndex(marble.getPlayerNumber());
  }

  /**
   * Returns whether or not the marble in the player's safe space is safe.
   *
   * @param playerNumber the player number
   * @return whether or not the marble in the player's safe space is safe
   * @throws IllegalArgumentException if the given player number is invalid
   */
  protected boolean isMarbleInSafeSpaceSafe(int playerNumber) {

    // check if the player has one of their own marbles in their safe space
    if (!hasMarbleInSafeSpace(playerNumber)) {
      return false;
    }

    // check if the marble came from a start space and if so, it is safe
    Marble marble = getMarbleInSpace(board.getSafeBoardIndex(playerNumber));
    if (marble.getPreviousBoardIndex() >= board.getStartMinBoardIndex(playerNumber)
        && marble.getPreviousBoardIndex() <= board.getStartMaxBoardIndex(playerNumber)) {
      return true;
    }

    return false;

  }

  /**
   * Returns whether or not the given marble is in a start space on the board.
   *
   * @param marble the marble
   * @return whether or not the given marble is in a start space on the board
   * @throws NullPointerException if the given marble is null
   */
  protected boolean isMarbleInStartSpace(Marble marble) {
    Preconditions.checkNotNull(marble, "Null marble");
    return marble.getBoardIndex() >= board.getStartMinBoardIndex(marble.getPlayerNumber())
        && marble.getBoardIndex() <= board.getStartMaxBoardIndex(marble.getPlayerNumber());
  }

  /**
   * Plays the game by repeatedly advancing the game state until the game is over.
   */
  public void play() {
    while (nextState != State.GAME_OVER) {
      advance();
    }
  }

  /**
   * Executes the current players turn.
   *
   * @return State.GAME_OVER, State.DEAL_CARDS, or State.PLAYER_TURN
   * @throws IllegalStateException if the player's play selector returns an invalid play
   */
  protected State playerTurn() {

    // check to see if the game is over
    if (isGameOver()) {
      return State.GAME_OVER;
    }

    // check to see if we need to deal new cards
    if (isEveryPlayerOutOfCards()) {
      return State.DEAL_CARDS;
    }

    // get the list of valid plays for the current player
    Set<Play> plays = getPlays(currentPlayer);
    if (plays.isEmpty()) {

      // fire event before clearing cards
      fireEvent(new CannotPlayGameEvent(this, currentPlayer));

      // throw in the player's cards
      players.get(currentPlayer).getCards().clear();

    } else {

      /**
       * Check to see if a play has been selected. This happens when the playerTurn method is called
       * and the play selector does not select a play automatically (checked in the logic below). In
       * this case, the playerTurn method returns to stay in the same state. Once the play selector
       * is updated externally to set the selected play, the playerTurn method is called again and
       * the selected play will be found in this first check.
       */
      PlaySelector playSelector = players.get(currentPlayer).getPlaySelector();
      Play play = playSelector.getSelectedPlay();
      if (play == null) {

        // set the avaiable plays in the play selector
        playSelector.setAvailablePlays(Collections.unmodifiableSet(plays));

        // check to see if a play was selected automatically
        play = playSelector.getSelectedPlay();
        if (play == null) {
          // no play selected, return to stay in the same state so the play can be set externally
          return State.PLAYER_TURN;
        }

      }

      // clear the selected play in the play selector (resetting for next iteration)
      playSelector.setSelectedPlay(null);

      if (!plays.contains(play)) {
        throw new IllegalStateException("Player " + currentPlayer
            + " play selector returned invalid play");
      }

      executePlay(currentPlayer, play);

    }

    // move to the next player
    currentPlayer = getNextPlayerNumber(currentPlayer);

    return State.PLAYER_TURN;

  }

  /**
   * Removes the given event listener from the list of event listeners.
   *
   * @param eventListener the event listener to remove
   * @throws NullPointerException if the given event listener is null
   */
  public void removeEventListener(EventListener eventListener) {
    Preconditions.checkNotNull(eventListener, "Null event listener");
    eventListeners.remove(eventListener);
  }

  /**
   * Validates the given user play using the current game state. If the given user play is valid, a
   * Play representing the given user play is returned. If the given user play is invalid, an
   * InvalidPlayException will be thrown.
   *
   * @param userPlay the user play to validate
   * @return a play representing the given user play
   * @throws IllegalArgumentException if a required user play field is invalid
   * @throws InvalidPlayException if the given user play is invalid
   * @throws NullPointerException if the given user play or required user play fields are null
   */
  public Play validate(UserPlay userPlay) throws InvalidPlayException {

    Preconditions.checkNotNull(userPlay, "Null user play");
    Preconditions.checkNotNull(userPlay.getCard(), "Null card");

    switch (userPlay.getCard().getRank()) {
      case ACE:
        if (isMarbleInStartSpace(userPlay.getMarble1())) {
          return getPlayForCardKingAndMarble(userPlay.getPlayerNumber(), userPlay.getCard(),
              userPlay.getMarble1());
        } else {
          return getPlayForCardAndMarble(userPlay.getPlayerNumber(), userPlay.getCard(),
              userPlay.getMarble1());
        }
      case SEVEN:
        if (userPlay.getMarble2() == UserPlay.NO_MARBLE
            && userPlay.getSplitValue1() == UserPlay.NO_SPLIT_VALUE) {
          return getPlayForCardAndMarble(userPlay.getPlayerNumber(), userPlay.getCard(),
              userPlay.getMarble1());
        } else {
          return getPlayForCardSevenAndMarbles(userPlay.getPlayerNumber(), userPlay.getCard(),
              userPlay.getMarble1(), userPlay.getMarble2(), userPlay.getSplitValue1());
        }
      case JACK:
        return getPlayForCardJackAndMarbles(userPlay.getPlayerNumber(), userPlay.getCard(),
            userPlay.getMarble1(), userPlay.getMarble2());
      case KING:
        return getPlayForCardKingAndMarble(userPlay.getPlayerNumber(), userPlay.getCard(),
            userPlay.getMarble1());
      default:
        return getPlayForCardAndMarble(userPlay.getPlayerNumber(), userPlay.getCard(),
            userPlay.getMarble1());
    }

  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Game other = (Game) obj;
    if (this.currentDealer != other.currentDealer) {
      return false;
    }
    if (this.currentPlayer != other.currentPlayer) {
      return false;
    }
    if (this.numberOfPlayers != other.numberOfPlayers) {
      return false;
    }
    /*
     * No need to test for different boards. Given the board and number of players are final fields
     * assigned in the constructor, it is not possible for the board to differ if the number of
     * players is the same (which is checked above).
     */
    if (!Objects.equals(this.cardDeck, other.cardDeck)) {
      return false;
    }
    if (!Objects.equals(this.players, other.players)) {
      return false;
    }
    // do not include the event listeners list
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 71 * hash + Objects.hashCode(this.board);
    hash = 71 * hash + Objects.hashCode(this.cardDeck);
    hash = 71 * hash + this.currentDealer;
    hash = 71 * hash + this.currentPlayer;
    hash = 71 * hash + this.numberOfPlayers;
    hash = 71 * hash + Objects.hashCode(this.players);
    // do not include the event listeners list
    return hash;
  }

  /**
   * The SplitCard class extends the Card class to represent a seven card that has been split. The
   * class doesn't add any additional logic to the Card class but it is used to apply different
   * logic for split cards (in particular, moving a four card forward 4 spaces instead of backwards
   * 4 spaces).
   */
  protected static class SplitCard extends Card {

    /**
     * The split card for 1.
     */
    public static final SplitCard SPLIT_CARD_ACE = new SplitCard(Rank.ACE);
    /**
     * The split card for 2.
     */
    public static final SplitCard SPLIT_CARD_TWO = new SplitCard(Rank.TWO);
    /**
     * The split card for 3.
     */
    public static final SplitCard SPLIT_CARD_THREE = new SplitCard(Rank.THREE);
    /**
     * The split card for 4.
     */
    public static final SplitCard SPLIT_CARD_FOUR = new SplitCard(Rank.FOUR);
    /**
     * The split card for 5.
     */
    public static final SplitCard SPLIT_CARD_FIVE = new SplitCard(Rank.FIVE);
    /**
     * The split card for 6.
     */
    public static final SplitCard SPLIT_CARD_SIX = new SplitCard(Rank.SIX);

    /**
     * Creates a new SplitCard.
     *
     * @param rank the card rank
     * @throws NullPointerException if the given rank or suit is null
     */
    public SplitCard(Rank rank) {
      super(rank, Suit.CLUBS);
    }

    /**
     * Creates a new SplitCard using the given card.
     *
     * @param card the card to copy
     * @throws NullPointerException if the given card is null
     */
    public SplitCard(Card card) {
      super(card);
    }

  }

  /**
   * The game states.
   */
  public enum State {
    DEAL_CARDS,
    DETERMINE_DEALER,
    PLAYER_TURN,
    GAME_OVER
  }

}
