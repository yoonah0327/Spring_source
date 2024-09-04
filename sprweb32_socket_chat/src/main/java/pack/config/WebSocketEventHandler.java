// WebSocket 세션의 연결 및 해제 이벤트 처리 클래스
package pack.config;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import pack.model.ChatMessage;

@Component
public class WebSocketEventHandler {
   
   private final SimpMessagingTemplate messagingTemplate;
   
   public WebSocketEventHandler(SimpMessagingTemplate messagingTemplate) {
      this.messagingTemplate = messagingTemplate;
   }
   
   @EventListener
   public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
      StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
      String username = (String)headerAccessor.getSessionAttributes().get("username");
      if(username != null) { // 채팅명이 null이 아니면 퇴장 메시지 생성 후 브로드캐스트
         ChatMessage chatMessage = new ChatMessage();
         chatMessage.setType(ChatMessage.MessageType.LEAVE);
         chatMessage.setSender(username);
         messagingTemplate.convertAndSend("/topic/public", chatMessage); // 퇴장 메시지가 모두에게 전송됨
      }
   }
}
