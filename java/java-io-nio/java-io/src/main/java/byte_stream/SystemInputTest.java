package byte_stream;

import java.io.IOException;

/**
 * System.in (InputStream) 을 통해 콘솔을 통한 데이터 입력을 받고
 * System.out (OutputStream) 을 통해 콘솔로 데이터를 쓴다.
 */
public class SystemInputTest {

  public static void main(String[] args) {
    int i = 0;

    try {
      while ((i = System.in.read()) != -1) {
        System.out.write(i);
      }
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
