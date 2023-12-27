package org.taekni.cardgames.game;

public class TexasHoldem extends BaseGame implements Game {

  @Override
  public void play() {
    // TODO: implement
    System.out.println("playing Texas Holdem");
  }

  @Override
  Game createGame() {
    return new TexasHoldem();
  }
}
