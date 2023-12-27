package org.taekni.cardgames.core;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public final class Hand {

  private final Set<Card> cards;

  public Hand() {
    this.cards = new HashSet<>();
  }

  public void add(Card card) {
    Validate.validState(!cards.contains(card), "%s is already in the hand", card);
    this.cards.add(card);
  }

  public Set<Card> show() {
    Validate.validState(!cards.isEmpty(), "no cards in hand");
    return this.cards;
  }

  public void discard(Card card) {
    Validate.validState(cards.contains(card), "%s is not in the hand", card);
    this.cards.remove(card);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof Hand hand)) {
      return false;
    }

    return Objects.equals(this.cards, hand.cards);
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(5, 7).append(cards).toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("cards", cards).toString();
  }
}
