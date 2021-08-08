package Mod13.Examples.Quiz.Proc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Processor implements Runnable {

  private int elem;

  public Processor(int elem) {
    this.elem = elem;
  }

  @Override
  public void run() {
    Main.set.put("Key" + elem, 12);
  }
}

class AnotherProcessor implements Runnable {

  private int elem;

  public AnotherProcessor(int elem) {
    this.elem = elem;
  }

  @Override
  public void run() {
    Main.set.remove("Key" + elem);
  }
}
