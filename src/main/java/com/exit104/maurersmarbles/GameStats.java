/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import com.google.common.base.Preconditions;

import com.exit104.maurersmarbles.event.CannotPlayGameEvent;
import com.exit104.maurersmarbles.event.DealtCardGameEvent;
import com.exit104.maurersmarbles.event.Event;
import com.exit104.maurersmarbles.event.EventListener;
import com.exit104.maurersmarbles.event.ExecutedPlayGameEvent;
import com.exit104.maurersmarbles.event.ShuffledCardDeckGameEvent;

import java.util.Map;
import java.util.TreeMap;

/**
 * The GameStats class listens for events in a Game and collects stats for the game.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class GameStats implements EventListener {

  /**
   * The game to collect stats for.
   */
  protected final transient Game game;
  /**
   * The array that contains the number of card decks shuffled in the game. The index in the array
   * is the player number.
   */
  protected final transient int[] cardDecksShuffled;
  /**
   * The array that contains the number of cards dealt in the game. The index in the array is the
   * player number.
   */
  protected final transient int[] cardsDealt;
  /**
   * The array that contains the number of marbles that have been knocked in the game. The index in
   * the array is the player number.
   */
  protected final transient int[] marblesKnocked;
  /**
   * The array that contains the number of marbles moved in the game. The index in the array is the
   * player number.
   */
  protected final transient int[] marblesMoved;
  /**
   * The array that contains the number of plays executed in the game. The index in the array is the
   * player number.
   */
  protected final transient int[] playsExecuted;
  /**
   * The array that contains the number of times a player cannot play in the game. The index in the
   * array is the player number.
   */
  protected final transient int[] playerCannotPlay;
  /**
   * The map that contains the number of cards played in the game. The key into the map is the card
   * rank and the value is the number of times that card has been played.
   */
  protected final transient Map<Card.Rank, Integer> cardsPlayed = new TreeMap<>();

  /**
   * Creates a new GameStats for the given game.
   *
   * @param game the game to collect stats for
   * @throws NullPointerException if the given game is null
   */
  public GameStats(Game game) {

    Preconditions.checkNotNull(game, "Null game");

    this.game = game;

    // initalize the arrays
    cardsDealt = new int[game.getNumberOfPlayers()];
    cardDecksShuffled = new int[game.getNumberOfPlayers()];
    marblesKnocked = new int[game.getNumberOfPlayers()];
    marblesMoved = new int[game.getNumberOfPlayers()];
    playsExecuted = new int[game.getNumberOfPlayers()];
    playerCannotPlay = new int[game.getNumberOfPlayers()];
    for (int i = 0; i < game.getNumberOfPlayers(); i++) {
      cardsDealt[i] = 0;
      cardDecksShuffled[i] = 0;
      marblesKnocked[i] = 0;
      marblesMoved[i] = 0;
      playsExecuted[i] = 0;
      playerCannotPlay[i] = 0;
    }

    // initalize the cards map
    for (Card.Rank rank : Card.Rank.values()) {
      cardsPlayed.put(rank, 0);
    }

    // register to listen for events in the game
    game.addEventListener(this);

  }

  /**
   * Returns the number of times the given player number shuffled the card deck.
   *
   * @param playerNumber the player number
   * @return the number of times the given player number shuffled the card deck
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public int getCardDecksShuffled(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < game.getNumberOfPlayers(),
        "Invalid player number");
    return cardDecksShuffled[playerNumber];
  }

  /**
   * Returns the number of cards dealt by the given player number.
   *
   * @param playerNumber the player number
   * @return the number of cards dealt by the given player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public int getCardsDealt(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < game.getNumberOfPlayers(),
        "Invalid player number");
    return cardsDealt[playerNumber];
  }

  /**
   * Returns the number of times the given card rank was played.
   *
   * @param rank the card rank
   * @return the number of times the given card rank was played
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public int getCardsPlayed(Card.Rank rank) {
    Preconditions.checkNotNull(rank, "Null rank");
    return cardsPlayed.get(rank);
  }

  /**
   * Returns the number of times the given player number knocked a marble.
   *
   * @param playerNumber the player number
   * @return the number of times the given player number knocked a marble
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public int getMarblesKnocked(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < game.getNumberOfPlayers(),
        "Invalid player number");
    return marblesKnocked[playerNumber];
  }

  /**
   * Returns the number of marbles moved by the given player number.
   *
   * @param playerNumber the player number
   * @return the number of marbles moved by the given player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public int getMarblesMoved(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < game.getNumberOfPlayers(),
        "Invalid player number");
    return marblesMoved[playerNumber];
  }

  /**
   * Returns the number of times the given player number could not play.
   *
   * @param playerNumber the player number
   * @return the number of times the given player number could not play
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public int getPlayerCannotPlay(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < game.getNumberOfPlayers(),
        "Invalid player number");
    return playerCannotPlay[playerNumber];
  }

  /**
   * Returns the number of plays executed by the given player number.
   *
   * @param playerNumber the player number
   * @return the number of plays executed by the given player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public int getPlaysExecuted(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < game.getNumberOfPlayers(),
        "Invalid player number");
    return playsExecuted[playerNumber];
  }

  /**
   * Returns the total number of times the card deck was shuffled.
   *
   * @return the total number of times the card deck was shuffled
   */
  public int getTotalCardDecksShuffled() {
    int total = 0;
    for (int i = 0; i < cardDecksShuffled.length; i++) {
      total += cardDecksShuffled[i];
    }
    return total;
  }

  /**
   * Returns the total number of cards dealt.
   *
   * @return the total number of cards dealt
   */
  public int getTotalCardsDealt() {
    int total = 0;
    for (int i = 0; i < cardsDealt.length; i++) {
      total += cardsDealt[i];
    }
    return total;
  }

  /**
   * Returns the total number of cards played.
   *
   * @return the total number of cards played
   */
  public int getTotalCardsPlayed() {
    int total = 0;
    for (Integer count : cardsPlayed.values()) {
      total += count;
    }
    return total;
  }

  /**
   * Returns the total number of marbles knocked.
   *
   * @return the total number of marbles knocked
   */
  public int getTotalMarblesKnocked() {
    int total = 0;
    for (int i = 0; i < marblesKnocked.length; i++) {
      total += marblesKnocked[i];
    }
    return total;
  }

  /**
   * Returns the total number of marbles moved.
   *
   * @return the total number of marbles moved
   */
  public int getTotalMarblesMoved() {
    int total = 0;
    for (int i = 0; i < marblesMoved.length; i++) {
      total += marblesMoved[i];
    }
    return total;
  }

  /**
   * Returns the total number of times a player cannot play.
   *
   * @return the total number of times a player cannot play
   */
  public int getTotalPlayerCannotPlay() {
    int total = 0;
    for (int i = 0; i < playerCannotPlay.length; i++) {
      total += playerCannotPlay[i];
    }
    return total;
  }

  /**
   * Returns the total number of plays executed.
   *
   * @return the total number of plays executed
   */
  public int getTotalPlaysExecuted() {
    int total = 0;
    for (int i = 0; i < playsExecuted.length; i++) {
      total += playsExecuted[i];
    }
    return total;
  }

  @Override
  public void handleEvent(Event event) {

    if (event instanceof CannotPlayGameEvent) {
      playerCannotPlay[((CannotPlayGameEvent) event).getPlayerNumber()]++;
    } else if (event instanceof DealtCardGameEvent) {
      cardsDealt[((DealtCardGameEvent) event).getDealerPlayerNumber()]++;
    } else if (event instanceof ExecutedPlayGameEvent) {

      ExecutedPlayGameEvent executedPlayGameEvent = (ExecutedPlayGameEvent) event;

      playsExecuted[executedPlayGameEvent.getPlayerNumber()]++;
      cardsPlayed.put(executedPlayGameEvent.getPlay().getCard().getRank(),
          cardsPlayed.get(executedPlayGameEvent.getPlay().getCard().getRank()) + 1);

      for (Move move : executedPlayGameEvent.getPlay().getMoves()) {
        marblesMoved[executedPlayGameEvent.getPlayerNumber()]++;
        if (game.isMarbleInStartSpace(game.getPlayers().get(move.getPlayerNumber())
            .getMarbles().get(move.getMarbleNumber()))) {
          marblesKnocked[executedPlayGameEvent.getPlayerNumber()]++;
        }
      }

    } else if (event instanceof ShuffledCardDeckGameEvent) {
      cardDecksShuffled[((ShuffledCardDeckGameEvent) event).getPlayerNumber()]++;
    }

  }

  @Override
  public String toString() {

    StringBuilder stringBuilder = new StringBuilder();
    String prefix;

    stringBuilder.append("Card decks shuffled: ").append(getTotalCardDecksShuffled())
        .append("\n  [");
    prefix = "";
    for (int i = 0; i < cardDecksShuffled.length; i++) {
      stringBuilder.append(prefix).append(i).append(":").append(cardDecksShuffled[i]);
      prefix = ", ";
    }
    stringBuilder.append("]\n");

    stringBuilder.append("Cards dealt: ").append(getTotalCardsDealt()).append("\n  [");
    prefix = "";
    for (int i = 0; i < cardsDealt.length; i++) {
      stringBuilder.append(prefix).append(i).append(":").append(cardsDealt[i]);
      prefix = ", ";
    }
    stringBuilder.append("]\n");

    stringBuilder.append("Cards played: ").append(getTotalCardsPlayed()).append("\n  [");
    prefix = "";
    for (Map.Entry<Card.Rank, Integer> entry : cardsPlayed.entrySet()) {
      stringBuilder.append(prefix).append(entry.getKey()).append(":").append(entry.getValue());
      prefix = ", ";
    }
    stringBuilder.append("]\n");

    stringBuilder.append("Plays executed: ").append(getTotalPlaysExecuted()).append("\n  [");
    prefix = "";
    for (int i = 0; i < playsExecuted.length; i++) {
      stringBuilder.append(prefix).append(i).append(":").append(playsExecuted[i]);
      prefix = ", ";
    }
    stringBuilder.append("]\n");

    stringBuilder.append("Marbles moved: ").append(getTotalMarblesMoved()).append("\n  [");
    prefix = "";
    for (int i = 0; i < marblesMoved.length; i++) {
      stringBuilder.append(prefix).append(i).append(":").append(marblesMoved[i]);
      prefix = ", ";
    }
    stringBuilder.append("]\n");

    stringBuilder.append("Marbles knocked: ").append(getTotalMarblesKnocked()).append("\n  [");
    prefix = "";
    for (int i = 0; i < marblesKnocked.length; i++) {
      stringBuilder.append(prefix).append(i).append(":").append(marblesKnocked[i]);
      prefix = ", ";
    }
    stringBuilder.append("]\n");

    stringBuilder.append("Player cannot play: ").append(getTotalPlayerCannotPlay()).append("\n  [");
    prefix = "";
    for (int i = 0; i < playerCannotPlay.length; i++) {
      stringBuilder.append(prefix).append(i).append(":").append(playerCannotPlay[i]);
      prefix = ", ";
    }
    stringBuilder.append("]\n");

    return stringBuilder.toString();

  }

}
