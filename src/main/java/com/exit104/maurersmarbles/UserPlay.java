/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

/**
 * The UserPlay class contains the fields and methods to represent a play from a user.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class UserPlay {

  /**
   * The split value to indicate no split value.
   */
  public static final int NO_SPLIT_VALUE = -1;
  /**
   * The marble value to indicate no marble.
   */
  public static final Marble NO_MARBLE = null;
  /**
   * The card for the play.
   */
  private final transient Card card;
  /**
   * The player number executing the play.
   */
  private final transient int playerNumber;
  /**
   * The first split value for the play (may be set to NO_SPLIT_VALUE).
   */
  private final transient int splitValue1;
  /**
   * The first (and possibly only) marble for the play.
   */
  private final transient Marble marble1;
  /**
   * The second marble for the play (may be set to NO_MARBLE).
   */
  private final transient Marble marble2;

  /**
   * Creates a new UserPlay using the given builder.
   *
   * @param builder the builder to create the user play for
   */
  private UserPlay(Builder builder) {
    this.playerNumber = builder.playerNumber;
    this.card = builder.card;
    this.marble1 = builder.marble1;
    this.marble2 = builder.marble2;
    this.splitValue1 = builder.splitValue1;
  }

  /**
   * Returns the card for the play.
   *
   * @return the card for the play
   */
  public Card getCard() {
    return card;
  }

  /**
   * Returns the player number executing the play.
   *
   * @return the player number executing the play
   */
  public int getPlayerNumber() {
    return playerNumber;
  }

  /**
   * Returns the first split value for the play (may be set to NO_SPLIT_VALUE).
   *
   * @return the first split value for the play (may be set to NO_SPLIT_VALUE)
   */
  public int getSplitValue1() {
    return splitValue1;
  }

  /**
   * Returns the first (and possibly only) marble for the play.
   *
   * @return the first (and possibly only) marble for the play
   */
  public Marble getMarble1() {
    return marble1;
  }

  /**
   * Returns the second marble for the play (may be set to NO_MARBLE).
   *
   * @return the second marble for the play (may be set to NO_MARBLE)
   */
  public Marble getMarble2() {
    return marble2;
  }

  /**
   * Returns a builder to create a new UserPlay.
   *
   * @param playerNumber the player number executing the play
   * @param card the card for the play
   * @param marble1 the first (and possibly only) marble for the play
   * @return a builder to create a new UserPlay
   */
  public static Builder builder(int playerNumber, Card card, Marble marble1) {
    return new Builder(playerNumber, card, marble1);
  }

  /**
   * The builder class is used to build a new UserPlay.
   */
  public static final class Builder {

    /**
     * The player number executing the play.
     */
    private final transient int playerNumber;
    /**
     * The card for the play.
     */
    private final transient Card card;
    /**
     * The first marble for the play.
     */
    private final transient Marble marble1;
    /**
     * The second marble for the play.
     */
    private transient Marble marble2 = NO_MARBLE;
    /**
     * The first split value for the play.
     */
    private transient int splitValue1 = NO_SPLIT_VALUE;

    /**
     * Creates a new Builder using the given player number, card, and marble1.
     *
     * @param playerNumber the player number executing the play
     * @param card the card for the play
     * @param marble1 the first marble number
     */
    private Builder(int playerNumber, Card card, Marble marble1) {
      this.playerNumber = playerNumber;
      this.card = card;
      this.marble1 = marble1;
    }

    /**
     * Sets the second marble for the play (may be set to NO_MARBLE).
     *
     * @param marble2 the second marble for the play (may be set to NO_MARBLE)
     * @return this builder, to allow method chaining
     */
    @SuppressWarnings("PMD.LinguisticNaming")
    public Builder setMarble2(Marble marble2) {
      this.marble2 = marble2;
      return this;
    }

    /**
     * Sets the first split value for the play (may be set to NO_SPLIT_VALUE).
     *
     * @param splitValue1 the first split value for the play (may be set to NO_SPLIT_VALUE)
     * @return this builder, to allow method chaining
     */
    @SuppressWarnings("PMD.LinguisticNaming")
    public Builder setSplitValue1(int splitValue1) {
      this.splitValue1 = splitValue1;
      return this;
    }

    /**
     * Creates a new UserPlay using the values in this builder.
     *
     * @return a new UserPlay using the values in this builder
     */
    public UserPlay build() {
      return new UserPlay(this);
    }

  }

}
