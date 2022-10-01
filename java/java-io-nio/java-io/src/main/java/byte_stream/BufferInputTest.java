package byte_stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class BufferInputTest {

  public static void main(String[] args) {

    try (
        BufferedInputStream inputStream = new BufferedInputStream(System.in);
        BufferedOutputStream outputStream = new BufferedOutputStream(System.out)
    ) {
      byte[] buf = new byte[5];
      int read = inputStream.read(buf);
      outputStream.write(buf);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

}
