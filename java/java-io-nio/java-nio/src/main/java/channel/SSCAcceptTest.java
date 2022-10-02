package channel;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SSCAcceptTest {
  public static final int PORT = 8081;
  public static void main(String[] args) throws Exception {
    ServerSocketChannel ssc = ServerSocketChannel.open();
    InetAddress localHost = InetAddress.getLocalHost();
    ssc.socket().bind(new InetSocketAddress(PORT));
    ssc.configureBlocking(false);
    while (true) {
      System.out.println("커넥션 연결 대기중");

      SocketChannel sc = ssc.accept();
      if (sc == null) {
        Thread.sleep(1000);
      } else {
        System.out.println(sc.socket().getRemoteSocketAddress() + "가 연결 시도했습니다.");
      }
    }
  }

}
