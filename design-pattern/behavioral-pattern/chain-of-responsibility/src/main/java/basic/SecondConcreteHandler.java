package basic;

public class SecondConcreteHandler extends Handler{
  public SecondConcreteHandler(Handler nextHandler) {
    super(nextHandler);
  }
  @Override
  public void handleRequest(Request request) {
    System.out.println("request : " + request.getMessage());
    super.handleRequest(request);
  }
}
