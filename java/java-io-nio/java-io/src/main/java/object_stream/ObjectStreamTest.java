package object_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {

  public static void main(String[] args) {
    try(
        FileOutputStream fout = new FileOutputStream("book.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        )
    {
      Book book = new Book("리팩터링2판", "1245-2412-3123","마틴 파울러");
      oos.writeObject(book);
      oos.reset();
      System.out.println("저장 완료");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try (
        FileInputStream fis = new FileInputStream("book.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
    ) {
      Book book =(Book)ois.readObject();
      System.out.println(book);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

  }

}
