package org.taekni.poker;

import io.quarkus.runtime.QuarkusApplication;

public class Poker implements QuarkusApplication {
  @Override
  public int run(String... args) throws Exception {
    System.out.println("Hello " + args[0]);
    return 0;
  }
}
