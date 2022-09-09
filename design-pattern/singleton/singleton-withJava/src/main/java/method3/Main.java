package method3;


public class Main {
  public static void main(String[] args) {
    StaticInnerClassSingleton tso1 = StaticInnerClassSingleton.getInstance();
    StaticInnerClassSingleton tso2 = StaticInnerClassSingleton.getInstance();
    if (tso1.equals(tso2)) {
      System.out.println("tso1 and tso2 are Singleton Object");
    }
  }
}
