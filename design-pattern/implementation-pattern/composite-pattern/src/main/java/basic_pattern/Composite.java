package basic_pattern;

import java.util.List;

public class Composite implements Component{
  List<Component> components;

  public Composite(List<Component> components) {
    this.components = components;
  }

  @Override
  public void operation() {
    components.forEach(Component::operation);
  }
}
