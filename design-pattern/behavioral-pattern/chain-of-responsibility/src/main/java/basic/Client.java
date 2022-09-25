package basic;

public class Client {

  private Handler handler;

  public Client(Handler handler) {
    this.handler = handler;
  }

  public void run() {
    Request request = new Request("Hero 입니다");
    handler.handleRequest(request);
  }

  public static void main(String[] args) {
    Handler chain = new FirstConcreteHandler(new SecondConcreteHandler(null));
    Client client = new Client(chain);
    client.run();
  }
}
