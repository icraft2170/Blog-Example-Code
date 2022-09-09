package method2.thread_safe_03;

public class Main {
  public static void main(String[] args) {
    DoubleCheckedLockingSingletonObject tso1 = DoubleCheckedLockingSingletonObject.getInstance();
    DoubleCheckedLockingSingletonObject tso2 = DoubleCheckedLockingSingletonObject.getInstance();
    if (tso1.equals(tso2)) {
      System.out.println("tso1 and tso2 are Singleton Object");
    }
  }
}
