package org.taekni.cardgames.core;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeckTests {

  @Test
  void standard_CreatesStandardDeck() {
    final Deck deck = Deck.standard();

    Assertions.assertAll(
        () -> {
          Assertions.assertEquals(Deck.DEFAULT_SIZE, deck.size());

          final Map<Card.Suit, List<Card>> suitCardMap =
              deck.getCards().stream().collect(Collectors.groupingBy(Card::suit));
          int suits = suitCardMap.keySet().size();

          Assertions.assertEquals(4, suits);

          for (Card.Suit suit : suitCardMap.keySet()) {
            int ranks = suitCardMap.get(suit).size();
            Assertions.assertEquals(
                13, ranks, String.format("deck should have 13 %s's", suit.name()));
          }
        });
  }

  @Test
  void draw_GivenDeckHasCards_RemovesCard() {
    final Deck deck = Deck.standard();

    final Card card = deck.draw();

    Assertions.assertAll(
        () -> {
          Assertions.assertNotNull(card);
          Assertions.assertFalse(deck.getCards().contains(card));
        });
  }

  @Test
  void draw_GivenEmptyDeck_ThrowsIllegalStateException() {
    Assertions.assertThrows(IllegalStateException.class, Deck.empty()::draw);
  }

  @Test
  void insert_GivenCardNotInDeck_AddsCardToDeck() {
    final Deck deck = Deck.empty();
    final Card card = Instancio.create(Card.class);

    deck.insert(card);

    Assertions.assertTrue(deck.getCards().contains(card));
  }

  @Test
  void insert_GivenCardInDeck_ThrowsIllegalStateException() {
    final Deck deck = Deck.standard();
    Assertions.assertThrows(
        IllegalStateException.class, () -> deck.insert(Instancio.create(Card.class)));
  }

  @Test
  void equals_GivenSameObject_ReturnsTrue() {
    final Deck deck = Deck.standard();
    //noinspection EqualsWithItself
    Assertions.assertEquals(deck, deck);
  }
}
