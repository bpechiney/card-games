package org.taekni.cardgames.game;

public enum GameType {
  FIVE_CARD_DRAW("Five Card Draw"),
  TEXAS_HOLDEM("Texas Holdem"),

  UNKNOWN("unknown");

  private final String value;

  GameType(String value) {
    this.value = value;
  }

  public static GameType fromString(String value) {
    for (GameType type : GameType.values()) {
      if (type.value.equals(value)) {
        return type;
      }
    }

    return GameType.UNKNOWN;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return this.value;
  }
}
