package reactor;

import java.io.IOException;

public class Main {

  /**
   * 풀어서 풀어서 설명하기
   * Selector - SelectionKey - Channel
   * Selector - Channel 사이에 등록할 수 있는 이벤트는 4가지 ( 수락, 연결, 쓰기, 읽기 )
   * - ? 수락과 연결의 차이는
   * 채널에 각 이벤트가 발생하면 셀렉트는 감시하다가 그가 원하는 핸들러로 디스패치 해줌.
   * 각 이벤트는 미리 등록가능 해당 채널에 Connect 되면 A 핸들러 , Accept 되면 B 핸들러, Read 는 C 핸들러, Write 는 D 핸들러
   * 그리고 Selector 는 해당 내용을 특정(selector.select()) 지점에서 블로킹하면서 감시하고 있다가 어떤 이벤트건 발생하면
   * 해당 블로킹을 넘어가고 (selector.selectedKeys()) 해당 메서드로 이벤트가 발생한 채널의 정보를 같이 담고있는 SelectionKey를 반환해줌
   * 해당 SelectionKey에 해당 이벤트에 대해 등록되어 있던 핸들러를 (selectionKey.attachment()) 메서드로 반환받아 일을 처리함.
   */
  public static void main(String[] args) throws IOException {
    Reactor reactor = new Reactor(8888);
    reactor.run();
  }

}
