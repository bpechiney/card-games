package org.taekni.cardgames;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.taekni.cardgames.game.Game;
import org.taekni.cardgames.game.GameFactory;
import org.taekni.cardgames.game.GameType;

@QuarkusMain
public class Main {
  public static void main(String... args) {
    Quarkus.run(Main.Run.class, args);
  }

  /** Run */
  public static class Run implements QuarkusApplication {

    @Override
    public int run(String... args) {
      final Arguments arguments = parseArgs(args);
      GameType gameType;
      try {
        gameType = GameType.fromString(arguments.typeString());
      } catch (IllegalArgumentException e) {
        System.out.println("invalid game type");
        return 1;
      }

      final Game game = GameFactory.createGame(gameType);
      try {
        game.play();
      } catch (Exception e) {
        System.out.println("something went wrong");
        return 1;
      }

      return 0;
    }
  }

  static Arguments parseArgs(String... args) {
    return new Arguments(args[0]);
  }
}
