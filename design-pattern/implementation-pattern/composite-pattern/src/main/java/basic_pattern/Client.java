package basic_pattern;

import java.util.Arrays;
import java.util.List;

public class Client {

  public static void main(String[] args) {
    List<Component> components = Arrays.asList(new FirstLeaf(), new SecondLeaf());
    Composite composite = new Composite(components);
    composite.operation();
  }
}
