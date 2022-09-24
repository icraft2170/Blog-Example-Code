package basic;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
  private Map<String, Flyweight> cache = new HashMap<>();

  public Flyweight getCache(String name) {
    if (cache.containsKey(name)) {
      return cache.get(name);
    } else {
      Flyweight cachedObject = new Flyweight(name);
      cache.put(name, cachedObject);
      return cachedObject;
    }
  }
}
