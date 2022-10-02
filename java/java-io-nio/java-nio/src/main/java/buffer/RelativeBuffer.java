package buffer;

import java.nio.ByteBuffer;
public class RelativeBuffer {
  public static void main(String[] args) {
    ByteBuffer buffer = ByteBuffer.allocate(10);
    System.out.println("buffer.position() = " + buffer.position()); // 0
    System.out.println("buffer.limit() = " + buffer.limit()); // 10
    System.out.println("buffer.capacity() = " + buffer.capacity()); // 10

    buffer.mark(); // Position 0 에 Marking

    // Buffer 에 값을 집어 넣는다.
    buffer.put((byte) 10) // 0번 Position 에 주입
        .put((byte) 11) // 1번 Position 에 주입
        .put((byte) 12); // 2번 Position 에 주입
    buffer.reset(); // 현재 Position 3 -> 0 으로 이동(Marking 0에 되어있다.)

    System.out.println("Value : " + buffer.get()
        + ", Position : " + buffer.position()); // 10
    System.out.println("Value : " + buffer.get()
        + ", Position : " + buffer.position()); // 11
    System.out.println("Value : " + buffer.get()
        + ", Position : " + buffer.position()); // 12
    System.out.println("Value : " + buffer.get()
        + ", Position : " + buffer.position()); // 0 -> 기본 값으로 초기화 되어있다.
  }
}
