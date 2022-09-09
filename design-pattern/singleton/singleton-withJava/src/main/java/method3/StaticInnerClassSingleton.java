package method3;

public class StaticInnerClassSingleton {
  private StaticInnerClassSingleton() {}
  private static class Holder {
    private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
  }

  public static StaticInnerClassSingleton getInstance() {
    return Holder.INSTANCE;
  }
}
