package reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

public class Reactor implements Runnable{

  final Selector selector;
  final ServerSocketChannel serverSocketChannel;

  public Reactor(int port) throws IOException {
    selector = Selector.open();

    serverSocketChannel = ServerSocketChannel.open();
    serverSocketChannel.socket().bind(new InetSocketAddress(port));
    serverSocketChannel.configureBlocking(false);

    // Accept Event 등록
    SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

    // ServerSocketChannel 이 이벤트를 발행할 때 연결할 핸들러를 연결
    selectionKey.attach(new AcceptHandler(selector, serverSocketChannel));
  }

  @Override
  public void run() {
    try {
      while (true) {
        selector.select(); // Blocking - 이벤트 발생 시 까지
        // 이벤트가 발생한 Server Socket Channel 과 Selector 간의 관계를 정의하는 SelectionKey 추출
        Set<SelectionKey> selected = selector.selectedKeys();
        for (SelectionKey selectionKey : selected) {
          // 이벤트가 발생한 serverSocket or socket 과 selector 사이의 selectionKey에 Dispatch 호출
          dispatch(selectionKey);
        }
        selected.clear();
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  private void dispatch(SelectionKey selectionKey) {
    Handler handler = (Handler) selectionKey.attachment();
    handler.handle();
  }
}
