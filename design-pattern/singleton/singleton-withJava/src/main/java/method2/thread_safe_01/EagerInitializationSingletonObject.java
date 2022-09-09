package method2.thread_safe_01;

public class EagerInitializationSingletonObject {
  private static EagerInitializationSingletonObject instance = new EagerInitializationSingletonObject();

  private EagerInitializationSingletonObject() {
  }

  public static EagerInitializationSingletonObject getInstance() {
    return instance;
  }

}
