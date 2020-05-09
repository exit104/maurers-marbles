/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The CardDeck class contains the fields and methods for a standard card deck.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class CardDeck {

  /**
   * The number of cards in a full deck.
   */
  public static final int NUMBER_OF_CARDS_IN_FULL_DECK = 52;
  /**
   * The list of cards that have been dealt.
   */
  protected final List<Card> dealtCards = new ArrayList<>();
  /**
   * The list of cards that have not been dealt.
   */
  protected final List<Card> undealtCards = new ArrayList<>();

  /**
   * Creates a new unshuffled card deck.
   */
  public CardDeck() {
    this(false);
  }

  /**
   * Creates a new card deck. If shuffle is true, the cards will be shuffled. If shuffle is false,
   * the cards will be in new deck order.
   *
   * @param shuffle whether or not the shuffle the cards
   */
  public CardDeck(boolean shuffle) {

    // A-K hearts
    for (Card.Rank rank : Card.Rank.values()) {
      undealtCards.add(new Card(rank, Card.Suit.HEARTS));
    }
    // A-K clubs
    for (Card.Rank rank : Card.Rank.values()) {
      undealtCards.add(new Card(rank, Card.Suit.CLUBS));
    }
    // K-A diamonds
    for (Card.Rank rank : Lists.reverse(Arrays.asList(Card.Rank.values()))) {
      undealtCards.add(new Card(rank, Card.Suit.DIAMONDS));
    }
    // K-A spades
    for (Card.Rank rank : Lists.reverse(Arrays.asList(Card.Rank.values()))) {
      undealtCards.add(new Card(rank, Card.Suit.SPADES));
    }

    if (shuffle) {
      shuffle();
    }

  }

  /**
   * Creates a new CardDeck using the given card deck.
   *
   * @param cardDeck the card deck to copy
   * @throws NullPointerException if the given card deck is null
   */
  public CardDeck(CardDeck cardDeck) {

    Preconditions.checkNotNull(cardDeck, "Null card deck");

    for (Card card : cardDeck.dealtCards) {
      dealtCards.add(card);
    }
    for (Card card : cardDeck.undealtCards) {
      undealtCards.add(card);
    }

  }

  /**
   * Returns an unmodifiable list of the cards that have been dealt.
   *
   * @return an unmodifiable list of the cards that have been dealt
   */
  public List<Card> getDealtCards() {
    return Collections.unmodifiableList(dealtCards);
  }

  /**
   * Returns an unmodifiable list of the cards that have not been dealt.
   *
   * @return an unmodifiable list of the cards that have not been dealt
   */
  public List<Card> getUndealtCards() {
    return Collections.unmodifiableList(undealtCards);
  }

  /**
   * Returns the next undealt card in the deck, or null if there aren't any cards left.
   *
   * @return the next undealt card in the deck, or null if there aren't any cards left
   */
  public Card dealCard() {
    if (undealtCards.isEmpty()) {
      return null;
    }
    dealtCards.add(undealtCards.get(0));
    return undealtCards.remove(0);
  }

  /**
   * Resets the card deck by moving all cards back into the undealt list.
   */
  public void reset() {
    undealtCards.addAll(dealtCards);
    dealtCards.clear();
  }

  /**
   * Shuffles the list of cards that have not been dealt.
   */
  public final void shuffle() {
    Collections.shuffle(undealtCards);
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
    final CardDeck other = (CardDeck) obj;
    if (!Objects.equals(this.dealtCards, other.dealtCards)) {
      return false;
    }
    if (!Objects.equals(this.undealtCards, other.undealtCards)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 97 * hash + Objects.hashCode(this.dealtCards);
    hash = 97 * hash + Objects.hashCode(this.undealtCards);
    return hash;
  }

  @Override
  public String toString() {

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(undealtCards.size()).append(" undealt cards [");
    String prefix = "";
    for (Card card : undealtCards) {
      stringBuilder.append(prefix).append(card.toString());
      prefix = ",";
    }
    stringBuilder.append("], ");
    stringBuilder.append(dealtCards.size()).append(" dealt cards [");
    prefix = "";
    for (Card card : dealtCards) {
      stringBuilder.append(prefix).append(card.toString());
      prefix = ",";
    }
    stringBuilder.append("]");

    return stringBuilder.toString();

  }

}
