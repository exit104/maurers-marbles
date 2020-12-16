/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Board class provides the methods for a game board.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class Board {

  /**
   * The number of home spaces on the board for each player.
   */
  protected static final int NUMBER_OF_HOME_SPACES_PER_PLAYER = 4;
  /**
   * The number of perimeter spaces on the board for each player.
   */
  protected static final int NUMBER_OF_PERIMETER_SPACES_PER_PLAYER = 14;
  /**
   * The number of start spaces on the board for each player.
   */
  protected static final int NUMBER_OF_START_SPACES_PER_PLAYER = 4;
  /**
   * The number of perimeter spaces on the board.
   */
  protected final transient int numberOfPerimeterSpaces;
  /**
   * The number of playable spaces on the board.
   */
  protected final transient int numberOfPlayableSpaces;
  /**
   * The number of players.
   */
  protected final transient int numberOfPlayers;
  /**
   * The list of home board indexes. The index in the list is the player number the the value is the
   * list of board indexes for that player.
   */
  protected final transient List<List<Integer>> homeBoardIndexes;
  /**
   * The list of home entry board indexes. The index in the list is the player number the the value
   * is the board index for that player.
   */
  protected final transient List<Integer> homeEntryBoardIndexes;
  /**
   * The list of perimeter board indexes.
   */
  protected final transient List<Integer> perimeterBoardIndexes;
  /**
   * The list of safe board indexes. The index in the list is the player number the the value is the
   * board index for that player.
   */
  protected final transient List<Integer> safeBoardIndexes;
  /**
   * The list of start board indexes. The index in the list is the player number the the value is
   * the list of board indexes for that player.
   */
  protected final transient List<List<Integer>> startBoardIndexes;

  /**
   * Creates a new Board using the given number of players.
   *
   * @param numberOfPlayers the number of players (4, 6, 8, 10, or 12)
   * @throws IllegalArgumentException if the given number of players is invalid
   */
  @SuppressWarnings("PMD.UselessParentheses")
  public Board(int numberOfPlayers) {

    Preconditions.checkArgument(Game.VALID_NUMBER_OF_PLAYERS.contains(numberOfPlayers),
        "Invalid number of players");

    this.numberOfPlayers = numberOfPlayers;

    // calculate the number of perimeter spaces
    numberOfPerimeterSpaces = NUMBER_OF_PERIMETER_SPACES_PER_PLAYER * numberOfPlayers;

    // generate the list of perimeter board indexes
    List<Integer> boardIndexes = new ArrayList<>();
    for (int i = 0; i < numberOfPerimeterSpaces; i++) {
      boardIndexes.add(i);
    }
    perimeterBoardIndexes = Collections.unmodifiableList(boardIndexes);

    // calculate the number of playable spaces
    numberOfPlayableSpaces = numberOfPerimeterSpaces
        + (NUMBER_OF_START_SPACES_PER_PLAYER * numberOfPlayers)
        + (NUMBER_OF_HOME_SPACES_PER_PLAYER * numberOfPlayers);

    // calculate the home entry board indexes
    boardIndexes = new ArrayList<>();
    boardIndexes.add(numberOfPerimeterSpaces - 2);
    for (int i = 1; i < numberOfPlayers; i++) {
      boardIndexes.add((NUMBER_OF_PERIMETER_SPACES_PER_PLAYER * i) - 2);
    }
    homeEntryBoardIndexes = Collections.unmodifiableList(boardIndexes);

    // calculate the home board indexes
    List<List<Integer>> playerBoardIndexes = new ArrayList<>();
    for (int playerNumber = 0; playerNumber < numberOfPlayers; playerNumber++) {
      boardIndexes = new ArrayList<>();
      for (int i = 0; i < NUMBER_OF_HOME_SPACES_PER_PLAYER; i++) {
        boardIndexes.add(numberOfPerimeterSpaces
            + (NUMBER_OF_HOME_SPACES_PER_PLAYER * playerNumber) + i);
      }
      playerBoardIndexes.add(Collections.unmodifiableList(boardIndexes));
    }
    homeBoardIndexes = Collections.unmodifiableList(playerBoardIndexes);

    // calculate the start board indexes
    playerBoardIndexes = new ArrayList<>();
    for (int playerNumber = 0; playerNumber < numberOfPlayers; playerNumber++) {
      boardIndexes = new ArrayList<>();
      for (int i = 0; i < NUMBER_OF_START_SPACES_PER_PLAYER; i++) {
        boardIndexes.add(numberOfPerimeterSpaces
            + (NUMBER_OF_HOME_SPACES_PER_PLAYER * numberOfPlayers)
            + (NUMBER_OF_START_SPACES_PER_PLAYER * playerNumber) + i);
      }
      playerBoardIndexes.add(Collections.unmodifiableList(boardIndexes));
    }
    startBoardIndexes = Collections.unmodifiableList(playerBoardIndexes);

    // calculate the safe board indexes
    boardIndexes = new ArrayList<>();
    for (int i = 0; i < numberOfPlayers; i++) {
      boardIndexes.add(NUMBER_OF_PERIMETER_SPACES_PER_PLAYER * i);
    }
    safeBoardIndexes = Collections.unmodifiableList(boardIndexes);

  }

  /**
   * Returns the list of home board indexes for the given player number.
   *
   * @param playerNumber the player number
   * @return the list of home board indexes for the given player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public List<Integer> getHomeBoardIndexes(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < homeBoardIndexes.size(),
        "Invalid player number");
    return homeBoardIndexes.get(playerNumber);
  }

  /**
   * Returns the home entry board index for the given player number.
   *
   * @param playerNumber the player number
   * @return the home entry board index for the given player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public int getHomeEntryBoardIndex(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < homeEntryBoardIndexes.size(),
        "Invalid player number");
    return homeEntryBoardIndexes.get(playerNumber);
  }

  /**
   * Returns the home max board index for the given player number.
   *
   * @param playerNumber the player number
   * @return the home max board index for the given player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public int getHomeMaxBoardIndex(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < homeBoardIndexes.size(),
        "Invalid player number");
    return homeBoardIndexes.get(playerNumber).get(NUMBER_OF_HOME_SPACES_PER_PLAYER - 1);
  }

  /**
   * Returns the home min board index for the given player number.
   *
   * @param playerNumber the player number
   * @return the home min board index for the given player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public int getHomeMinBoardIndex(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < homeBoardIndexes.size(),
        "Invalid player number");
    return homeBoardIndexes.get(playerNumber).get(0);
  }

  /**
   * Returns the number of home spaces for each player.
   *
   * @return the number of home spaces for each player
   */
  public int getNumberOfHomeSpacesPerPlayer() {
    return NUMBER_OF_HOME_SPACES_PER_PLAYER;
  }

  /**
   * Returns the number of perimeter spaces on the board.
   *
   * @return the number of perimeter spaces on the board
   */
  public int getNumberOfPerimeterSpaces() {
    return numberOfPerimeterSpaces;
  }

  /**
   * Returns the number of playable spaces on the board.
   *
   * @return the number of playable spaces on the board
   */
  public int getNumberOfPlayableSpaces() {
    return numberOfPlayableSpaces;
  }

  /**
   * Returns the number of players.
   *
   * @return the number of players
   */
  public int getNumberOfPlayers() {
    return numberOfPlayers;
  }

  /**
   * Returns the list of perimeter board indexes.
   *
   * @return the list of perimeter board indexes
   */
  public List<Integer> getPerimeterBoardIndexes() {
    return perimeterBoardIndexes;
  }

  /**
   * Returns the safe board index for the given player number.
   *
   * @param playerNumber the player number
   * @return the safe board index for the given player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public int getSafeBoardIndex(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < safeBoardIndexes.size(),
        "Invalid player number");
    return safeBoardIndexes.get(playerNumber);
  }

  /**
   * Returns the list of start board indexes for the given player number.
   *
   * @param playerNumber the player number
   * @return the list of start board indexes for the given player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public List<Integer> getStartBoardIndexes(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < startBoardIndexes.size(),
        "Invalid player number");
    return startBoardIndexes.get(playerNumber);
  }

  /**
   * Returns the start max board index for the given player number.
   *
   * @param playerNumber the player number
   * @return the start max board index for the given player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public int getStartMaxBoardIndex(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < startBoardIndexes.size(),
        "Invalid player number");
    return startBoardIndexes.get(playerNumber).get(NUMBER_OF_START_SPACES_PER_PLAYER - 1);
  }

  /**
   * Returns the start min board index for the given player number.
   *
   * @param playerNumber the player number
   * @return the start min board index for the given player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public int getStartMinBoardIndex(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < startBoardIndexes.size(),
        "Invalid player number");
    return startBoardIndexes.get(playerNumber).get(0);
  }

  /**
   * Returns the number of start spaces for each player.
   *
   * @return the number of start spaces for each player
   */
  public int getNumberOfStartSpacesPerPlayer() {
    return NUMBER_OF_START_SPACES_PER_PLAYER;
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
    final Board other = (Board) obj;
    if (this.numberOfPlayers != other.numberOfPlayers) {
      return false;
    }
    /*
     * No need to test other variables. The number of players and other variables are final fields
     * assigned in the constructor, so it is not possible for the values to differ if the number of
     * players is the same (which is checked above).
     */
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 11 * hash + this.numberOfPlayers;
    return hash;
  }

}
