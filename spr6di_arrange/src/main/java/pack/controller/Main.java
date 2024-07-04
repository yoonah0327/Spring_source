package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("classpath:arrange.xml");
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:arrange.xml");
		
		System.out.println("Singleton 확인(클래스로받음)------------------------");
		MessageImpl impl1= (MessageImpl)context.getBean("mImpl");
		impl1.sayHi();
		MessageImpl impl2= (MessageImpl)context.getBean("mImpl");
		impl2.sayHi();
		
		System.out.println("객체 주소: "+impl1 + " "+ impl2);
		//객체 주소: pack.controller.MessageImpl@26b3fd41 pack.controller.MessageImpl@26b3fd41
		//객체의 주소가 같다. 싱글톤이기에. 객체를 1개만 생성.
		//arrange.xml에서 프로토타입으로 변경시, 주소가 서로 달라진다. 2개가 인스턴스된것. 
		//객체 주소: pack.controller.MessageImpl@291caca8 pack.controller.MessageImpl@385e9564

		System.out.println("\n다형성 처리(인터페이스로 받음. 캐스팅o)---------------------------");
		MessageInter inter = (MessageInter)context.getBean("mImpl");
		inter.sayHi();
		
		System.out.println("\n다형성 처리2(인터페이스로 받음.캐스팅X)---------------------------");
		MessageInter inter2 = context.getBean("mImpl", MessageInter.class);
		inter2.sayHi();
		
		context.close();// 업그레이드된버젼인 generic~에서는 닫아줄수 있다. 
		
	}

}
