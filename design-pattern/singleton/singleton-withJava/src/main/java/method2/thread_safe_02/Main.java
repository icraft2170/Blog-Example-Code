package method2.thread_safe_02;

public class Main {
  public static void main(String[] args) {
    MethodLockingSingletonObject tso1 = MethodLockingSingletonObject.getInstance();
    MethodLockingSingletonObject tso2 = MethodLockingSingletonObject.getInstance();
    if (tso1.equals(tso2)) {
      System.out.println("tso1 and tso2 are Singleton Object");
    }
  }
}
