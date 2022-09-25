package basic;

public abstract class Handler {
  private Handler nextHandler;
  public Handler(Handler nextHandler) {
    this.nextHandler = nextHandler;
  }

  public void handleRequest(Request request) {
    if (nextHandler != null) {
      nextHandler.handleRequest(request);
    }
  }
}
