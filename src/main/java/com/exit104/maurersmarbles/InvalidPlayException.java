/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

/**
 * The InvalidPlayException class extends the Exception class to represent an exception for an
 * invalid play.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class InvalidPlayException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * The exception thrown when a four card is played on a marble in a home space.
   */
  public static final InvalidPlayException CANNOT_GO_BACKWARDS_IN_HOME_SPACE
      = new InvalidPlayException("Cannot goes backwards in home space");
  /**
   * The exception thrown when a card is played that takes the marble beyond the home spaces.
   */
  public static final InvalidPlayException CANNOT_GO_BEYOND_HOME_SPACES
      = new InvalidPlayException("Cannot play marble beyond home spaces");
  /**
   * The exception thrown when a marble lands on an opponent's safe marble.
   */
  public static final InvalidPlayException CANNOT_LAND_ON_OPPONENT_SAFE_MARBLE
      = new InvalidPlayException("Cannot land on opponent safe marble");
  /**
   * The exception thrown when a marble lands on or passes a marble in a home space.
   */
  public static final InvalidPlayException CANNOT_LAND_ON_OR_PASS_MARBLE_IN_HOME_SPACE
      = new InvalidPlayException("Cannot land on or pass marble in home space");
  /**
   * The exception thrown when a marble lands on the player's own marble.
   */
  public static final InvalidPlayException CANNOT_LAND_ON_OWN_MARBLE
      = new InvalidPlayException("Cannot land on own marble");
  /**
   * The exception thrown when a marble lands on the player's partner's marble.
   */
  public static final InvalidPlayException CANNOT_LAND_ON_PARTNER_MARBLE
      = new InvalidPlayException("Cannot land on partner's marble");
  /**
   * The exception thrown when a marble lands on a safe marble.
   */
  public static final InvalidPlayException CANNOT_LAND_ON_SAFE_MARBLE
      = new InvalidPlayException("Cannot land on safe marble");
  /**
   * The exception thrown when a marble passes a safe marble.
   */
  public static final InvalidPlayException CANNOT_PASS_SAFE_MARBLE
      = new InvalidPlayException("Cannot pass safe marble");
  /**
   * The exception thrown when a marble in a home space cannot be played.
   */
  public static final InvalidPlayException CANNOT_PLAY_MARBLE_IN_HOME_SPACE
      = new InvalidPlayException("Cannot play marble in home space");
  /**
   * The exception thrown when a marble in a start space cannot be played.
   */
  public static final InvalidPlayException CANNOT_PLAY_MARBLE_IN_START_SPACE
      = new InvalidPlayException("Cannot play marble in start space");
  /**
   * The exception thrown when a marble not in a start space cannot be played.
   */
  public static final InvalidPlayException CANNOT_PLAY_MARBLE_NOT_IN_START_SPACE
      = new InvalidPlayException("Cannot play marble not in start space");
  /**
   * The exception thrown when an opponent's marble cannot be played.
   */
  public static final InvalidPlayException CANNOT_PLAY_OPPONENT_MARBLE
      = new InvalidPlayException("Cannot play opponent's marble");
  /**
   * The exception thrown when trying to split the same marble.
   */
  public static final InvalidPlayException CANNOT_SPLIT_SAME_MARBLE
      = new InvalidPlayException("Cannot split same marble");
  /**
   * The exception thrown when trying to split two opponent marbles.
   */
  public static final InvalidPlayException CANNOT_SPLIT_TWO_OPPONENT_MARBLES
      = new InvalidPlayException("Cannot split two opponent marbles");
  /**
   * The exception thrown when trying to swap a marble in a home space.
   */
  public static final InvalidPlayException CANNOT_SWAP_MARBLE_IN_HOME_SPACE
      = new InvalidPlayException("Cannot swap marble in home space");
  /**
   * The exception thrown when trying to swap a marble in a start space.
   */
  public static final InvalidPlayException CANNOT_SWAP_MARBLE_IN_START_SPACE
      = new InvalidPlayException("Cannot swap marble in start space");
  /**
   * The exception thrown when trying to swap an opponent's safe marble.
   */
  public static final InvalidPlayException CANNOT_SWAP_OPPONENT_SAFE_MARBLE
      = new InvalidPlayException("Cannot swap opponent's safe marble");
  /**
   * The exception thrown when trying swap a marble with itself.
   */
  public static final InvalidPlayException CANNOT_SWAP_SAME_MARBLE
      = new InvalidPlayException("Cannot swap same marble");
  /**
   * The exception thrown when trying to swap two marble's for the same player.
   */
  public static final InvalidPlayException CANNOT_SWAP_SAME_PLAYER_MARBLE
      = new InvalidPlayException("Cannot swap same player's marble");
  /**
   * The exception thrown when trying to swap two opponent marbles.
   */
  public static final InvalidPlayException CANNOT_SWAP_TWO_OPPONENT_MARBLES
      = new InvalidPlayException("Cannot swap two opponent marbles");

  /**
   * Creates a new InvalidPlayException.
   */
  public InvalidPlayException() {
    super();
  }

  /**
   * Creates a new InvalidPlayException with the given message.
   *
   * @param message the descriptive error message
   */
  public InvalidPlayException(String message) {
    super(message);
  }

}
