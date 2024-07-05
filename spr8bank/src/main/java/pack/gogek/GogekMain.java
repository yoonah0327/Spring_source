package pack.gogek;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GogekMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bankinit.xml");
		
		Gogek daniel = (Gogek)context.getBean("gogek");
		daniel.selectBank("sinhan");
		daniel.playInputMoney(500);
		daniel.playOutputMoney(200);
		System.out.println("daniel- ");
		daniel.showMoney();
		
		Gogek john = (Gogek)context.getBean("gogek");
		john.selectBank("sinhan");
		john.playInputMoney(500);
		john.playOutputMoney(200);
		System.out.println("john- ");
		john.showMoney();
		
		Gogek oscar = (Gogek)context.getBean("gogek");
		oscar.selectBank("hana");
		oscar.playInputMoney(500);
		oscar.playOutputMoney(100);
		System.out.println("oscar- ");
		oscar.showMoney();
		
		System.out.println("객체주소: "+daniel);
		System.out.println("객체주소: "+john);
		System.out.println("객체주소: "+oscar);
		// 모두 같은 결과출력. 싱글톤. 인스턴스1개.//객체주소: pack.gogek.Gogek@446a1e84
		//신한, 하나, 고객에 스코프프로토타입@걸어주니 모두 주소가 다르게 즉 3개의 객체가 생성됨을 확인할수있다.
		

	}

}
