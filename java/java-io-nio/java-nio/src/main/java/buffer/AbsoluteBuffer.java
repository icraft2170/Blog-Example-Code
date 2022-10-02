package buffer;

import java.nio.ByteBuffer;

public class AbsoluteBuffer {
  public static void main(String[] args) {
    ByteBuffer buffer = ByteBuffer.allocate(10);
    System.out.println("buffer.position() = " + buffer.position());
    System.out.println("buffer.limit() = " + buffer.limit());
    System.out.println("buffer.capacity() = " + buffer.capacity());

    buffer.put(3, (byte) 3) // 3번 Index(절대 위치)에 주입
    .put(4, (byte) 4) // 4번 Index(절대 위치)에 주입
    .put(5, (byte) 5); // 5번 Index(절대 위치)에 주입

    System.out.println("Position : " + buffer.position()); // Position - 0 ( 절대 위치 기준으로 주입했기 때문 )

    System.out.println("Value : " + buffer.get(3)  + ", Position : " + buffer.position()); // 버퍼에서 3번 인덱스(절대위치) 의 값을 가져온다
    System.out.println("Value : " + buffer.get(4)  + ", Position : " + buffer.position()); // 버퍼에서 4번 인덱스(절대위치) 의 값을 가져온다
    System.out.println("Value : " + buffer.get(5)  + ", Position : " + buffer.position()); // 버퍼에서 5번 인덱스(절대위치) 의 값을 가져온다
    System.out.println("Value : " + buffer.get(9)  + ", Position : " + buffer.position()); // 버퍼에서 9번 인덱스(절대위치) 의 값을 가져온다
  }
}
