package method1;

public class Main {

  public static void main(String[] args) {
    SingletonObject o1 = SingletonObject.getInstance();
    SingletonObject o2 = SingletonObject.getInstance();
    if (o1.equals(o2)) {
      System.out.println("o1 and o2 are Singleton Object");
    }
  }
}
