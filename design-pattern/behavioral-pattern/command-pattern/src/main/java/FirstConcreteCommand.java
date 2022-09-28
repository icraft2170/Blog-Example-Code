public class FirstConcreteCommand implements Command{

  private Receiver receiver;

  public FirstConcreteCommand(Receiver receiver) {
    this.receiver = receiver;
  }

  @Override
  public void execute() {
    System.out.println("첫번째 구체 명령 - receiver : " + receiver.getName());
  }
}
