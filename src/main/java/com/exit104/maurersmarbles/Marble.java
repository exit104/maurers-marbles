/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import com.google.common.base.Preconditions;

/**
 * The Marble class contains the fields and methods to represent a marble on the game board.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class Marble {

  /**
   * The previous board index value when there is no previous spot the marble was in.
   */
  public static final int NO_PREVIOUS_BOARD_INDEX = -1;
  /**
   * The board index the marble is in.
   */
  protected transient int boardIndex;
  /**
   * The marble number.
   */
  protected transient int marbleNumber;
  /**
   * The last board index the marble was in, or NO_PREVIOUS_BOARD_INDEX if this is the first board
   * index.
   */
  protected transient int previousBoardIndex;
  /**
   * The player number the marble belongs to.
   */
  protected transient int playerNumber;

  /**
   * Creates a new marble with the given marble number for the given player number at the given
   * board index.
   *
   * @param playerNumber the player number
   * @param marbleNumber the marble number
   * @param boardIndex the board index the marble is in
   */
  public Marble(int playerNumber, int marbleNumber, int boardIndex) {
    this(playerNumber, marbleNumber, boardIndex, NO_PREVIOUS_BOARD_INDEX);
  }

  /**
   * Creates a new marble with the given marble number for the given player number at the given
   * board index.
   *
   * @param playerNumber the player number
   * @param marbleNumber the marble number
   * @param boardIndex the board index the marble is in
   * @param previousBoardIndex the previous board index the marble was in
   */
  public Marble(int playerNumber, int marbleNumber, int boardIndex, int previousBoardIndex) {
    this.playerNumber = playerNumber;
    this.marbleNumber = marbleNumber;
    this.boardIndex = boardIndex;
    this.previousBoardIndex = previousBoardIndex;
  }

  /**
   * Creates a new Marble using the given marble.
   *
   * @param marble the marble to copy
   * @throws NullPointerException if the given marble is null
   */
  public Marble(Marble marble) {
    Preconditions.checkNotNull(marble, "Null marble");
    this.playerNumber = marble.playerNumber;
    this.marbleNumber = marble.marbleNumber;
    this.boardIndex = marble.boardIndex;
    this.previousBoardIndex = marble.previousBoardIndex;
  }

  /**
   * Returns the board index the marble is in.
   *
   * @return the board index the marble is in
   */
  public int getBoardIndex() {
    return boardIndex;
  }

  /**
   * Sets the board index the marble is in.
   *
   * @param boardIndex the board index the marble is in
   */
  public void setBoardIndex(int boardIndex) {
    this.boardIndex = boardIndex;
  }

  /**
   * Returns the marble number.
   *
   * @return the marble number
   */
  public int getMarbleNumber() {
    return marbleNumber;
  }

  /**
   * Returns the previous board index.
   *
   * @return the previous board index
   */
  public int getPreviousBoardIndex() {
    return previousBoardIndex;
  }

  /**
   * Sets the previous board index.
   *
   * @param previousBoardIndex the previous board index
   */
  public void setPreviousBoardIndex(int previousBoardIndex) {
    this.previousBoardIndex = previousBoardIndex;
  }

  /**
   * Returns the player number.
   *
   * @return the player number
   */
  public int getPlayerNumber() {
    return playerNumber;
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
    final Marble other = (Marble) obj;
    if (this.boardIndex != other.boardIndex) {
      return false;
    }
    if (this.marbleNumber != other.marbleNumber) {
      return false;
    }
    if (this.previousBoardIndex != other.previousBoardIndex) {
      return false;
    }
    if (this.playerNumber != other.playerNumber) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 29 * hash + this.boardIndex;
    hash = 29 * hash + this.marbleNumber;
    hash = 29 * hash + this.previousBoardIndex;
    hash = 29 * hash + this.playerNumber;
    return hash;
  }

}
