package decoretor;

public class Decorator implements Component{
  private Component component;

  public Decorator(Component component) {
    this.component = component;
  }
  @Override
  public String operator() {
    return component.operator() + "~~!!";
  }
}
