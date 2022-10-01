package char_stream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StreamReaderTest {

  public static void main(String[] args) {
    InputStreamReader reader = new InputStreamReader(System.in);
    OutputStreamWriter writer = new OutputStreamWriter(System.out);
    try {
      char[] chars = new char[10];
      int read = reader.read(chars);
      writer.write(chars);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
