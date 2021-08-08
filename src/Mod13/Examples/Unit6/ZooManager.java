package Mod13.Examples.Unit6;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ZooManager {

  private Map<String, Object> foodDataRaw = new HashMap<>();
  Map<String, Object> foodData = new ConcurrentHashMap<>();

  // public void put(String key, String value) {
  // foodData.put(key, value);
  // }

  // public Object get(String key) {
  // return foodData.get(key);
  // }

  public void feedRaw() {

    foodDataRaw.put("penguin", 1);
    foodDataRaw.put("flamingo", 2);
    for (String key : foodDataRaw.keySet()) {
      foodDataRaw.remove(key);
    }
  }

  public void feed() {
    foodData.put("penguin", 1);
    foodData.put("flamingo", 2);
    for (String key : foodData.keySet()) {
      foodData.remove(key);
    }
  }

  public static void main(String[] args) {
    ZooManager zooManager = new ZooManager();
    // zooManager.feedRaw();
    zooManager.feed();
  }
}