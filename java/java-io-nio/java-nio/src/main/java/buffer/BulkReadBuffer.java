package buffer;

import java.nio.ByteBuffer;

public class BulkReadBuffer {

  public static void main(String[] args) {
    ByteBuffer buffer = ByteBuffer.allocate(10);
    buffer.put((byte) 0) // 0번 Position 에 주입
        .put((byte) 1) // 1번 Position 에 주입
        .put((byte) 2) // 2번 Position 에 주입
        .put((byte) 3) // 3번 Position 에 주입
        .put((byte) 4); // 4번 Position 에 주입

    buffer.mark(); // 5번 Position 에 Marking

    buffer.put((byte) 5) // 0번 Position 에 주입
        .put((byte) 6) // 1번 Position 에 주입
        .put((byte) 7) // 2번 Position 에 주입
        .put((byte) 8) // 3번 Position 에 주입
        .put((byte) 9); // 4번 Position 에 주입
    buffer.reset(); // 5번 Position 으로 Reset

    byte[] bytes = new byte[15]; // Size 가 15 인 Byte Array 준비
    int size = buffer.remaining(); // 현재 Position 을 기준으로 얼마나 자리가 남아있는지 확인해주는 메소드
    if (bytes.length < size) {
      size = bytes.length; // 버퍼에 남은 자리가 바이트 배열보다 크면 Size 를 바이트 배열 길이로 변경
      // 충분한 공간이 남아있다면 바이트 배열만큼 넣어주기 위함으로 보임.
    }

    buffer.get(bytes, 0, size); // 바이트에 남은 리밋 - 포지션의 개수 만큼 버퍼에서 데이터를 긁어 온다.
    System.out.println("Position : " + buffer.position() + ", Limit : " + buffer.limit());
    doSomeThing(bytes, size); // 바이트 내에 내용물을 전부 출력

  }

  private static void doSomeThing(byte[] bytes, int size) {
    for (int i = 0; i < size; i++) {
      System.out.println("byte = " + bytes[i]);
    }
  }

}
