package me.hero.websocket;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.util.HtmlUtils;

@Slf4j
public class EchoWebSocketHandler extends TextWebSocketHandler {
  // 연결된 클라이언트를 저장해두는 Set
  private final Set<WebSocketSession> sessions = new CopyOnWriteArraySet<>();

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    sessions.add(session);
    TextMessage message = new TextMessage("메아리 서버 연결 완료 되었습니다.");
    session.sendMessage(message);
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status)
      throws IOException {
    log.info("웹 소켓 연결이 끊깁니다.");
    sessions.remove(session);
  }

  @Override
  public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    String request = message.getPayload();
    String response = String.format(" 메아리 ~~! : %s ", HtmlUtils.htmlEscape(request));
    session.sendMessage(new TextMessage(response));
  }
}
