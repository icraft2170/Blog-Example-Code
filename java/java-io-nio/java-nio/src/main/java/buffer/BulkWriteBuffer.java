package buffer;

import java.nio.ByteBuffer;

public class BulkWriteBuffer {
  public static void main(String[] args) {
    ByteBuffer buffer = ByteBuffer.allocate(10);
    buffer.position(5); // 5번 포지션으로 이동
    buffer.mark(); // 5번 포지션에 마킹

    System.out.println("Position : " + buffer.position() + " , Limit : " + buffer.limit());

    byte[] bytes = new byte[15];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = (byte) i;
    } // 바이트 배열에 1 ~ 15까지 숫자를 초기화 해준다.

    int size = buffer.remaining();
    if (bytes.length < size) {
      size = bytes.length;
    }
    // 사용할 수 있는 공간의 수를 계산해 Size 에 넣어준다.

    buffer.put(bytes, 0, size);
    System.out.println("Position : " + buffer.position() + " , Limit : " + buffer.limit());

    buffer.reset();
    doSomeThing(buffer, size);
  }

  private static void doSomeThing(ByteBuffer buffer, int size) {
    for (int i = 0; i < size; i++) {
      System.out.println("byte = " + buffer.get());
    }
  }
}
