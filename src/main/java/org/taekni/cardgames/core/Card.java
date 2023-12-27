package org.taekni.cardgames.core;

public record Card(Card.Suit suit, Card.Rank rank) {

  public enum Suit {
    CLUBS("♣️"),
    DIAMONDS("♦️"),
    HEARTS("❤️"),
    SPADES("♠️");

    private final String symbol;

    Suit(String symbol) {
      this.symbol = symbol;
    }

    @Override
    public String toString() {
      return this.symbol;
    }
  }

  public enum Rank {
    TWO(1, "2"),
    THREE(2, "3"),
    FOUR(3, "4"),
    FIVE(4, "5"),
    SIX(5, "6"),
    SEVEN(6, "7"),
    EIGHT(7, "8"),
    NINE(8, "9"),
    TEN(9, "10"),
    JACK(10, "J"),
    QUEEN(11, "Q"),
    KING(12, "K"),
    ACE(13, "A");

    private final int value;
    private final String symbol;

    Rank(int value, String symbol) {
      this.value = value;
      this.symbol = symbol;
    }

    public int getValue() {
      return value;
    }

    public String getSymbol() {
      return symbol;
    }

    @Override
    public String toString() {
      return this.symbol;
    }
  }
}
