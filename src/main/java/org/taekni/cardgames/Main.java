package org.taekni.cardgames;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main {
  public static void main(String... args) {
    Quarkus.run(Main.Run.class, args);
  }

  /** Run */
  public static class Run implements QuarkusApplication {

    @Override
    public int run(String... args) {
      System.out.println("Hello " + args[0]);
      return 0;
    }
  }
}
