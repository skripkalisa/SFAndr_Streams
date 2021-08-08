package Mod13.Examples.Unit6;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ZooManagerConcurrent {
  private Map<String, Object> foodData = new ConcurrentHashMap<>();

  public void put(String key, String value) {
    foodData.put(key, value);
  }

  public Object get(String key) {
    return foodData.get(key);
  }

  public static void main(String[] args) throws InterruptedException {
    ZooManagerConcurrent zooManager = new ZooManagerConcurrent();
    zooManager.feed();
  }

  private void feed() throws InterruptedException {
    Thread t1 = new Thread() {
      public void run() {
        for (int i = 0; i < 1000; i++) {
          String s = String.valueOf(i);
          put(s, "food" + s);
        }
      }
    };
    Thread t2 = new Thread() {
      public void run() {
        for (int i = 0; i < 1000; i++) {
          String s = String.valueOf(i);
          put(s, "food" + s);
        }
      }
    };
    t1.start();
    t2.start();

    t1.join();
    t2.join();

    System.out.println("FoodData is: " + foodData);
  }

}
