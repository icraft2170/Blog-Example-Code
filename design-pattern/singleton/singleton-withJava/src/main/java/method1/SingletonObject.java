package method1;

/**
 * 1. private Constructor 를 제공하여 Singleton Object를 외부에서 생성할 수 없게한다.
 * 2. Singleton Class 내에서 Instance(Object)를 생성하고 외부에 제공한다.
 * 3. 내부에 Instance 는 외부에서 사용 가능하도록 static(정적) 해야한다.
 */
public class SingletonObject {
  private static SingletonObject instance;
  private SingletonObject() {}

  public static SingletonObject getInstance() {
    if (instance == null) {
      instance = new SingletonObject();
    }
    return instance;
  }
}
