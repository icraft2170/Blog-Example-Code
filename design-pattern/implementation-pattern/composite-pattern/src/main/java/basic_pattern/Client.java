package basic_pattern;

import java.util.Arrays;
import java.util.List;

public class Client {

  static Component composite;
  public static void main(String[] args) {
    List<Component> components = Arrays.asList(new FirstLeaf(), new SecondLeaf());
    composite = new Composite(components);
    composite.operation();
  }
}
