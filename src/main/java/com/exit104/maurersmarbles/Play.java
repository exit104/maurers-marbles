/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import com.google.common.base.Preconditions;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The Play class contains the fields and methods to represent playing a card and moving one or more
 * marbles on the board.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class Play {

  /**
   * The card for the play.
   */
  protected transient Card card;
  /**
   * The set of marble moves for the play.
   */
  protected transient Set<Move> moves = new LinkedHashSet<>();

  /**
   * Creates a new Play.
   *
   * @param card the card for the play
   * @param move the move for the play
   * @throws NullPointerException if the given card or move is null
   */
  public Play(Card card, Move move) {
    Preconditions.checkNotNull(card, "Null card");
    Preconditions.checkNotNull(move, "Null move");
    this.card = card;
    this.moves.add(move);
  }

  /**
   * Creates a new Play.
   *
   * @param card the card for the play
   * @param moves the set of moves for the play
   * @throws IllegalArgumentException if the given moves is empty
   * @throws NullPointerException if the given card or moves is null
   */
  public Play(Card card, Set<Move> moves) {
    Preconditions.checkNotNull(card, "Null card");
    Preconditions.checkNotNull(moves, "Null moves");
    Preconditions.checkArgument(!moves.isEmpty(), "Empty moves");
    this.card = card;
    this.moves.addAll(moves);
  }

  /**
   * Returns the card for the play
   *
   * @return the card for the play
   */
  public Card getCard() {
    return card;
  }

  /**
   * Returns an unmodifiable set of moves for the play.
   *
   * @return an unmodifiable set of moves for the play
   */
  public Set<Move> getMoves() {
    return Collections.unmodifiableSet(moves);
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
    final Play other = (Play) obj;
    if (!Objects.equals(this.card, other.card)) {
      return false;
    }
    if (!Objects.equals(this.moves, other.moves)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 89 * hash + Objects.hashCode(this.card);
    hash = 89 * hash + Objects.hashCode(this.moves);
    return hash;
  }

}
