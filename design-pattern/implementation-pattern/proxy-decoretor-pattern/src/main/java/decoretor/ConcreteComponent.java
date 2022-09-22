package decoretor;

public class ConcreteComponent implements Component{

  @Override
  public String operator() {
    return "My name is Hero";
  }
}
