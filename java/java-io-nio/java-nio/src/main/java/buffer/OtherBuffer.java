package buffer;

import java.nio.ByteBuffer;

public class OtherBuffer {
  public static void main(String[] args) {
    ByteBuffer buffer = ByteBuffer.allocate(10);
    print(buffer); //position = 0, limit = 10, capacity = 10
    buffer.putInt(100);
    print(buffer);
    //position = 4, limit = 10, capacity = 10
    // int 가 4byte 이기 때문에 position 도 4byte 증가
    System.out.println("Result = " + buffer.getInt(0)); // 100
  }

  private static void print(ByteBuffer buffer) {
    System.out.println(
        "position = " + buffer.position() +
        ", limit = " + buffer.limit() +
        ", capacity = " + buffer.capacity()
    );
  }
}
