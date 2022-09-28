public class SecondConcreteCommand implements Command{

  private Receiver receiver;

  public SecondConcreteCommand(Receiver receiver) {
    this.receiver = receiver;
  }

  @Override
  public void execute() {
    System.out.println("두번째 구체 명령 - receiver : " + receiver.getName());
  }
}
