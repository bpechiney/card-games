package org.taekni.cardgames.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;

public final class Deck {

  static final int DEFAULT_SIZE = 52;
  private static final Random random = new Random();

  private final List<Card> cards;

  private Deck() {
    this.cards = new ArrayList<>(Deck.DEFAULT_SIZE);
  }

  private Deck(List<Card> cards) {
    this.cards = cards;
  }

  public static Deck standard() {
    final List<Card> cards = new ArrayList<>(DEFAULT_SIZE);
    for (Card.Suit suit : Card.Suit.values()) {
      for (Card.Rank rank : Card.Rank.values()) {
        cards.add(new Card(suit, rank));
      }
    }
    Collections.shuffle(cards, Deck.random);

    return new Deck(cards);
  }

  static Deck empty() {
    return new Deck();
  }

  public Card draw() {
    Validate.validState(!this.cards.isEmpty(), "cannot draw from empty deck");

    int index = Deck.random.nextInt(0, this.cards.size());
    return this.cards.remove(index);
  }

  public void insert(Card card) {
    Validate.validState(!this.cards.contains(card), "%s is already in deck", card);
    this.cards.add(card);
  }

  int size() {
    return this.cards.size();
  }

  List<Card> getCards() {
    return cards;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("cards", cards).toString();
  }
}
