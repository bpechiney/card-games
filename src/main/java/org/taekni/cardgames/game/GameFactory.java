package org.taekni.cardgames.game;

public class GameFactory {

  public static Game createGame(GameType gameType) {
    return switch (gameType) {
      case FIVE_CARD_DRAW -> new FiveCardDraw().createGame();
      case TEXAS_HOLDEM -> new TexasHoldem().createGame();
      case UNKNOWN -> throw new IllegalArgumentException("unknown game type");
    };
  }
}
