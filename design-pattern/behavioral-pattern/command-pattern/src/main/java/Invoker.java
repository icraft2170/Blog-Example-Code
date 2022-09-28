public class Invoker {

  private Command command;

  public Invoker(Command command) {
    this.command = command;
  }

  public void invoke() {
    command.execute();
  }

  public static void main(String[] args) {
    Receiver hero = new Receiver("Hero");
    Receiver chad = new Receiver("Chad");

    Invoker heroInvoker = new Invoker(new FirstConcreteCommand(hero));
    Invoker chadInvoker = new Invoker(new SecondConcreteCommand(chad));

    heroInvoker.invoke();
    chadInvoker.invoke();
  }

}
