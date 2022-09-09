package method2.thread_safe_03;

public class DoubleCheckedLockingSingletonObject {
  private volatile static DoubleCheckedLockingSingletonObject instance;

  private DoubleCheckedLockingSingletonObject() {
  }
  public static synchronized DoubleCheckedLockingSingletonObject getInstance() {
    if (instance == null) {
      synchronized (instance) {
        if (instance == null) {
          instance = new DoubleCheckedLockingSingletonObject();
        }
      }
    }
    return instance;
  }

}
