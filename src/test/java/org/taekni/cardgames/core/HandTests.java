package org.taekni.cardgames.core;

import java.util.Set;
import java.util.stream.Collectors;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HandTests {

  @Test
  void add_GivenCardNotInHand_AddsCard() {
    final Hand hand = new Hand();
    final Card card = Instancio.create(Card.class);

    hand.add(card);

    Assertions.assertTrue(hand.show().contains(card));
  }

  @Test
  void add_GivenCardInHand_ThrowsIllegalStateException() {
    final Hand hand = new Hand();
    final Card card = Instancio.create(Card.class);
    hand.add(card);

    Assertions.assertThrows(IllegalStateException.class, () -> hand.add(card));
  }

  @Test
  void show_GivenCardsInHand_ReturnsCards() {
    final Hand hand = new Hand();
    Set<Card> expected = Instancio.createSet(Card.class);
    expected.forEach(hand::add);

    final Set<Card> cards = hand.show();

    Assertions.assertEquals(expected, cards);
  }

  @Test
  void show_GivenNoCardsInHand_ThrowsIllegalStateException() {
    final Hand hand = new Hand();
    Assertions.assertThrows(IllegalStateException.class, hand::show);
  }

  @Test
  void discard_GivenCardInHand_RemovesCard() {
    final Hand hand = new Hand();
    final Set<Card> cards =
        Instancio.createSet(Card.class).stream().peek(hand::add).collect(Collectors.toSet());
    final Card card = cards.iterator().next();

    hand.discard(card);

    Assertions.assertFalse(hand.show().contains(card));
  }

  @Test
  void discard_GivenCardNotInHand_ThrowsIllegalStateException() {
    final Hand hand = new Hand();
    Assertions.assertThrows(
        IllegalStateException.class, () -> hand.discard(Instancio.create(Card.class)));
  }
}
