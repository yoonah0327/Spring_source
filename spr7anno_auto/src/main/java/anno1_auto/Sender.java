package anno1_auto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component//싱글톤 패턴으로 Sender 객체 생성. 즉 xml 작업 불요. 객체변수명 자동으로 sender.
//@Component("sen") // Sender클래스 객체변수명 sender 기본값. 다르게 하고싶을때 적어준다 
//@Scope("singleton") //기본이 싱글톤. 다르게 하고싶을때 적어준다.
public class Sender implements SenderInter{
	public void show() {
		System.out.println("Sender클래스의 show메소드 수행");
	}
}
