package break_singleton.break_singleton02;

import java.io.Serializable;

public class SingletonObject implements Serializable {
  private SingletonObject() {}
  private static class Holder {
    private static final SingletonObject INSTANCE = new SingletonObject();
  }

  public static SingletonObject getInstance() {
    return Holder.INSTANCE;
  }

  protected Object readResolve() {
    return getInstance();
  }

}
