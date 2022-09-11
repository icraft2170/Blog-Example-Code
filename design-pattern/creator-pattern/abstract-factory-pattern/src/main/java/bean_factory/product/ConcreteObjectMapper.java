package bean_factory.product;

public class ConcreteObjectMapper implements ObjectMapper{
  private final String name = "OBJECT-MAPPER";

  @Override
  public String getName() {
    return name;
  }
}
