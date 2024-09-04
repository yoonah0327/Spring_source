package pack;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
	//Spring WebSocket 애플리케이션에서 클라이언트가 특정 목적지로 전송하는 메시지를 처리하는 메서드를 정의하는 데 사용
	@MessageMapping("/message") // /app/message로 수신된 메세지를 처리. 라우팅할 때 /app은 기입x
	//처리된 메세지는 "/topic/messages"로 브로드캐스팅된다.
	@SendTo("/topic/messages")
	public String sendMessage(String message) {
		return message; //받은 메세지 그대로 반환. 자동으로 /topic/message 경로를 구독(subscribe)하고 있는 모든 클라이언트에 전송
		
	}
	
	
}
