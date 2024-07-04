package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterMain {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
		
		OurProcess ourP= (OurProcess)context.getBean("our");//bean id명
		System.out.println(ourP);
		//System.out.println(ourP.toString()); //상동
	}
}
