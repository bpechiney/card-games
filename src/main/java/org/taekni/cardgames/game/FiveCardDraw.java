package org.taekni.cardgames.game;

public class FiveCardDraw extends BaseGame implements Game {

  @Override
  public void play() {
    // TODO: implement
    System.out.println("playing Five Card Draw");
  }

  @Override
  Game createGame() {
    return new FiveCardDraw();
  }
}
