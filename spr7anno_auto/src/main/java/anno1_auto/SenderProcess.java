package anno1_auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// 참고 : 계층(Layers)별 annotation.
// application layer : 클라이언트와 데이터입출력을 제어 @Controller..
//domain layer: 어플리케이션 중심이며, 업무처리를 담당 @Service
//infrastructure layer: DB에 대한 영속성(persistence) 등을 담당 @Repository
//@Component
@Service// 이 클래스의 목적에 맞춰서 씀. 
//@Service("senderProcess")
//@Scope("singleton") 이 두줄은 @Service와 상동. 
public class SenderProcess {
//@Autowired: Bean의 자동 삽입을 위해 사용하는 어노테이션. (name에 의한 매핑이 아닌, type 으로 매핑)
	
	//@Autowired //멤버필드 주입 : 간단. 테스트불편. 제일 많이사용.
	//private Sender sender; //자동으로 sender타입의 인스턴스주소를 객체변수sender에 넣어줌.
	
	@Autowired
	@Qualifier("sender")
	private SenderInter senderInter;
	
	/*
	@Autowired //setter 주입: 코드가 장황.
	public void setSender(Sender sender) {
		this.sender = sender;
	}
	
	@Autowired //constructor 주입: 불변성과 테스트가 편하지만, 생성자가 너무 많아짐.
	public SenderProcess(Sender sender) {
		this.sender = sender;
	}
	*/
	
//	public Sender getSender() {
//		return sender;
//	}
	
	public void dispData() {
		//sender.show();
		senderInter.show();
		
	}
}
