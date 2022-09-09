package break_singleton.break_singleton01;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

  public static void main(String[] args)
      throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    Class<? extends SingletonObject> singletonClass = SingletonObject.getInstance().getClass();
    Constructor<? extends SingletonObject> constructor = singletonClass.getDeclaredConstructor();
    constructor.setAccessible(true);
    SingletonObject instance1 = SingletonObject.getInstance();
    SingletonObject instance2 = constructor.newInstance();
    System.out.println("instance1 = " + instance1);
    System.out.println("instance2 = " + instance2);
    System.out.println("instance1 equals instance2 : " + instance1.equals(instance2));
  }

}
