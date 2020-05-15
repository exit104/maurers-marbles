/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import com.google.common.base.Preconditions;

import java.util.Objects;

/**
 * The Card class contains the fields for a playing card.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class Card {

  /**
   * A standard playing card is 3.5" tall.
   */
  public static final float HEIGHT = 3.5f;
  /**
   * A standard playing card is 2.5" wide.
   */
  public static final float WIDTH = 2.5f;
  /**
   * The card rank.
   */
  protected final Rank rank;
  /**
   * The card suit.
   */
  protected final Suit suit;

  /**
   * Creates a new Card.
   *
   * @param rank the card rank
   * @param suit the card suit
   * @throws NullPointerException if the given rank or suit is null
   */
  public Card(Rank rank, Suit suit) {
    Preconditions.checkNotNull(rank, "Null rank");
    Preconditions.checkNotNull(suit, "Null suit");
    this.rank = rank;
    this.suit = suit;
  }

  /**
   * Creates a new Card using the given card.
   *
   * @param card the card to copy
   * @throws NullPointerException if the given card is null
   */
  public Card(Card card) {
    Preconditions.checkNotNull(card, "Null card");
    this.rank = card.rank;
    this.suit = card.suit;
  }

  /**
   * Returns the rank for the card.
   *
   * @return the rank for the card
   */
  public Rank getRank() {
    return rank;
  }

  /**
   * Returns the suit for the card.
   *
   * @return the suit for the card
   */
  public Suit getSuit() {
    return suit;
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
    final Card other = (Card) obj;
    if (this.rank != other.rank) {
      return false;
    }
    if (this.suit != other.suit) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 53 * hash + Objects.hashCode(this.rank);
    hash = 53 * hash + Objects.hashCode(this.suit);
    return hash;
  }

  @Override
  public String toString() {
    return rank.toString() + suit.toString();
  }

  /**
   * The ranks for the cards.
   */
  public enum Rank {

    ACE("A"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"),
    NINE("9"), TEN("10"), JACK("J"), QUEEN("Q"), KING("K");

    private final String value;

    Rank(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }

  }

  /**
   * The suits for the cards.
   */
  public enum Suit {

    CLUBS("C"), DIAMONDS("D"), HEARTS("H"), SPADES("S");

    private final String value;

    Suit(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }

  }

}
