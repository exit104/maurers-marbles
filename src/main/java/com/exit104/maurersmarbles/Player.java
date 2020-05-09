/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The Player class contains the fields and methods to represent a player in the game.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class Player {

  /**
   * The player number.
   */
  protected int playerNumber;
  /**
   * The list of cards for the player.
   */
  protected final List<Card> cards = new ArrayList<>();
  /**
   * The list of marbles for the player.
   */
  protected final List<Marble> marbles = new ArrayList<>();
  /**
   * The play selector for the player.
   */
  protected PlaySelector playSelector;

  /**
   * Creates a new player with the given player number.
   *
   * @param playerNumber the player number
   * @param playSelector the play selector for the player
   * @throws NullPointerException if the given play selector is null
   */
  public Player(int playerNumber, PlaySelector playSelector) {
    Preconditions.checkNotNull(playSelector, "Null play selector");
    this.playerNumber = playerNumber;
    this.playSelector = playSelector;
  }

  /**
   * Creates a new player using the given player.
   *
   * @param player the player to copy
   * @throws NullPointerException if the given player is null
   */
  public Player(Player player) {

    Preconditions.checkNotNull(player, "Null player");

    this.playerNumber = player.playerNumber;

    for (Card card : player.getCards()) {
      this.cards.add(new Card(card));
    }

    for (Marble marble : player.marbles) {
      this.marbles.add(new Marble(marble));
    }

    // TODO Do we need a copy of this?
    this.playSelector = player.playSelector;

  }

  /**
   * Returns the player number.
   *
   * @return the player number
   */
  public int getPlayerNumber() {
    return playerNumber;
  }

  /**
   * Sets the player number.
   *
   * @param playerNumber the player number
   */
  public void setPlayerNumber(int playerNumber) {
    this.playerNumber = playerNumber;
  }

  /**
   * Returns the list of cards for the player.
   *
   * @return the list of cards for the player
   */
  public List<Card> getCards() {
    return cards;
  }

  /**
   * Returns the list of marbles for the player.
   *
   * @return the list of marbles for the player
   */
  public List<Marble> getMarbles() {
    return marbles;
  }

  /**
   * Returns the play selector for the player.
   *
   * @return the play selector for the player
   */
  public PlaySelector getPlaySelector() {
    return playSelector;
  }

  /**
   * Sets the play selector for the player.
   *
   * @param playSelector the play selector for the player
   * @throws NullPointerException if the given play selector is null
   */
  public void setPlaySelector(PlaySelector playSelector) {
    Preconditions.checkNotNull(playSelector, "Null play selector");
    this.playSelector = playSelector;
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
    final Player other = (Player) obj;
    if (this.playerNumber != other.playerNumber) {
      return false;
    }
    if (!Objects.equals(this.cards, other.cards)) {
      return false;
    }
    if (!Objects.equals(this.marbles, other.marbles)) {
      return false;
    }
    // do not include play selector
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 11 * hash + this.playerNumber;
    hash = 11 * hash + Objects.hashCode(this.cards);
    hash = 11 * hash + Objects.hashCode(this.marbles);
    // do not include play selector
    return hash;
  }

}
