/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

/**
 * The Move class contains the fields and methods to move a players marble to a new board index.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class Move {

  /**
   * The marble number for the move.
   */
  protected transient int marbleNumber;
  /**
   * The new board index for the marble being moved.
   */
  protected transient int newMarbleBoardIndex;
  /**
   * The player number for the move.
   */
  protected transient int playerNumber;

  /**
   * Creates a new Move.
   *
   * @param playerNumber the player number
   * @param marbleNumber the marble number
   * @param newMarbleBoardIndex the new board index for the marble to move
   */
  public Move(int playerNumber, int marbleNumber, int newMarbleBoardIndex) {
    this.playerNumber = playerNumber;
    this.marbleNumber = marbleNumber;
    this.newMarbleBoardIndex = newMarbleBoardIndex;
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
   * Returns the new marble board index.
   *
   * @return the new marble board index
   */
  public int getNewMarbleBoardIndex() {
    return newMarbleBoardIndex;
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
    final Move other = (Move) obj;
    if (this.marbleNumber != other.marbleNumber) {
      return false;
    }
    if (this.newMarbleBoardIndex != other.newMarbleBoardIndex) {
      return false;
    }
    if (this.playerNumber != other.playerNumber) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 89 * hash + this.marbleNumber;
    hash = 89 * hash + this.newMarbleBoardIndex;
    hash = 89 * hash + this.playerNumber;
    return hash;
  }

}
