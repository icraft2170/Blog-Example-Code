package channel;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class SCConection {
  public static final int PORT = 8081;

  public static void main(String[] args) throws Exception {
    InetSocketAddress isa = new InetSocketAddress(PORT);

    SocketChannel sc = SocketChannel.open();
    sc.configureBlocking(false);
    System.out.println("IS ConnectionPending 1 : " + sc.isConnectionPending());
    sc.connect(isa);
    System.out.println("IS ConnectionPending 2 : " + sc.isConnectionPending());
    sc.finishConnect();
    System.out.println("IS ConnectionPending 3 : " + sc.isConnectionPending());
    System.out.println("Is Connected : "  + sc.isConnected());
    System.out.println("Is Blocking Mode : "  + sc.isBlocking());
  }

}
