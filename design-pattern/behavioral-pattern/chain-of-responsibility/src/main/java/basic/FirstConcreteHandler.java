package basic;

public class FirstConcreteHandler extends Handler{
  public FirstConcreteHandler(Handler nextHandler) {
    super(nextHandler);
  }

  @Override
  public void handleRequest(Request request) {
    System.out.println(request.getMessage());
    request.setMessage(request.getMessage() + " ~~ ? !");
    super.handleRequest(request);
  }
}
