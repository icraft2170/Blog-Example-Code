package break_singleton.break_singleton02;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
  public static void main(String[] args) {
    SingletonObject beforeInstance = SingletonObject.getInstance();
    SingletonObject afterInstance = null;

    try(
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("object.txt"));
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("object.txt"));
    ) {
      out.writeObject(beforeInstance);
      afterInstance = (SingletonObject) in.readObject();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    System.out.println("beforeInstance = " + beforeInstance);
    System.out.println("afterInstance = " + afterInstance);
    System.out.println("before equal after : " + (beforeInstance == afterInstance));

  }
}
