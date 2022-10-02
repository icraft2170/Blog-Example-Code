package buffer;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class ViewBuffer {

  public static void main(String[] args) {
    ByteBuffer buffer = ByteBuffer.allocate(10);
    IntBuffer intBuffer = buffer.asIntBuffer();
    System.out.println("position = " + intBuffer.position() +
        ", limit = " + intBuffer.limit() + ", capacity = " + intBuffer.capacity());

    intBuffer.put(1024).put(2048);
    System.out.println("index[0] = " + intBuffer.get(0)
        + ", index[1] = " + intBuffer.get(1));

    while (buffer.hasRemaining()) {
      System.out.print(buffer.get() + " "); // 0 ~ 10까지
    }
  }

}
