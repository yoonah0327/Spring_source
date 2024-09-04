package pack.model;

import lombok.Data;

//메세지 객체(데이터구조)를 정의. 메세지타입(입장, 채팅, 퇴장), 발신자, 내용등을 정의.
@Data
public class ChatMessage {
	private String sender; //채팅명 식별용
	private String content; //메세지 내용
	private MessageType type; //하나의 타입을 만듦
	
	public enum MessageType{ //열거형(상수값을 그룹화하여 코드의 안정성, 가독성향상을 목적)을 이용해 메세지 유형을 정의
		CHAT,
		JOIN,
		LEAVE
	}
}
