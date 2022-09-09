package method2.thread_safe_01;

public class Main {
  public static void main(String[] args) {
    EagerInitializationSingletonObject tso1 = EagerInitializationSingletonObject.getInstance();
    EagerInitializationSingletonObject tso2 = EagerInitializationSingletonObject.getInstance();
    if (tso1.equals(tso2)) {
      System.out.println("tso1 and tso2 are Singleton Object");
    }
  }
}
