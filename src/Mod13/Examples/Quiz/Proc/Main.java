package Mod13.Examples.Quiz.Proc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

  static Map<String, Integer> set = new ConcurrentHashMap<>();

  public static void main(String[] args) throws InterruptedException {

    for (int i = 0; i < 10; i++) {
      new Thread(new Processor(i)).start();
      new Thread(new AnotherProcessor(i)).start();
    }

    Thread.sleep(1000); // хватит для готового результата

    System.out.println(set);
  }

}