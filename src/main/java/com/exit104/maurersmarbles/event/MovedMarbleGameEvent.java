/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.event;

import com.exit104.maurersmarbles.Game;

/**
 * The MovedMarbleGameEvent class represents an event when a marble is moved in the game.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class MovedMarbleGameEvent extends GameEvent {

  /**
   * The marble number that was moved.
   */
  protected transient int marbleNumber;
  /**
   * The new board index for the marble that was moved.
   */
  protected transient int newBoardIndex;
  /**
   * The old board index for the marble that was moved.
   */
  protected transient int oldBoardIndex;
  /**
   * The player number for the marble that was moved.
   */
  protected transient int playerNumber;

  /**
   * Creates a new MovedMarbleGameEvent.
   *
   * @param game the game for the event
   * @param playerNumber the player number for the marble that was moved
   * @param marbleNumber the marble number that was moved
   * @param oldBoardIndex the old board index for the marble that was moved
   * @param newBoardIndex the new board index for the marble that was moved
   */
  public MovedMarbleGameEvent(Game game, int playerNumber, int marbleNumber, int oldBoardIndex,
      int newBoardIndex) {
    super(game);
    this.playerNumber = playerNumber;
    this.marbleNumber = marbleNumber;
    this.oldBoardIndex = oldBoardIndex;
    this.newBoardIndex = newBoardIndex;
  }

  /**
   * Returns the marble number that was moved.
   *
   * @return the marble number that was moved
   */
  public int getMarbleNumber() {
    return marbleNumber;
  }

  /**
   * Returns the new board index for the marble that was moved.
   *
   * @return the new board index for the marble that was moved
   */
  public int getNewBoardIndex() {
    return newBoardIndex;
  }

  /**
   * Returns the old board index for the marble that was moved.
   *
   * @return the old board index for the marble that was moved
   */
  public int getOldBoardIndex() {
    return oldBoardIndex;
  }

  /**
   * Returns the player number for the marble that was moved.
   *
   * @return the player number for the marble that was moved
   */
  public int getPlayerNumber() {
    return playerNumber;
  }

  @Override
  public String toString() {
    return new StringBuilder("Moved player ").append(playerNumber).append(" marble ")
        .append(marbleNumber).append(" from board index ").append(oldBoardIndex)
        .append(" to board index ").append(newBoardIndex).toString();
  }

}
