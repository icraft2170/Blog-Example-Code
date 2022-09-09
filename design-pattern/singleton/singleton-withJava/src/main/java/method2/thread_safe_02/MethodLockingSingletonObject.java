package method2.thread_safe_02;

public class MethodLockingSingletonObject {
  private static MethodLockingSingletonObject instance;

  private MethodLockingSingletonObject() {
  }

  public static synchronized MethodLockingSingletonObject getInstance() {
    if (instance == null) {
      instance = new MethodLockingSingletonObject();
    }
    return instance;
  }

}
