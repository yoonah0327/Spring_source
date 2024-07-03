package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		// 처리1: 전통적 방법
		Message1 m1 = new Message1(); //개발자가 객체 생성해서 작업
		m1.sayHello("홍길동");
		
		Message1 m2= new Message1();
		m2.sayHello("오로라");
		
		System.out.println();
		MessageInter inter;
		inter = m1;
		inter.sayHello("파이리");
		inter= m2;
		inter.sayHello("꼬부기");
		
		// 처리2: Spring 사용
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		//ApplicationContext context = new ClassPathXmlApplicationContext("classpath:pack/init.xml");
		//이게 오리지날. 앞부분의 classpath는 생략해도 무방.		
		//ApplicationContext context = new ClassPathXmlApplicationContext("classpath:init.xml");
		//init.xml이 resources가 아닌 다른곳에 있으면 이렇게 경로를 찍어줘야한다. 
		MessageInter inter2 = (MessageInter)context.getBean("mes1");
		inter2.sayHello("영조");
		MessageInter inter3 = (MessageInter)context.getBean("mes2");
		inter3.sayHello("정조");
		
	}

}
