package break_singleton.break_singleton01;

public class SingletonObject {
  private SingletonObject() {}
  private static class Holder {
    private static final SingletonObject INSTANCE = new SingletonObject();
  }

  public static SingletonObject getInstance() {
    return Holder.INSTANCE;
  }
}
