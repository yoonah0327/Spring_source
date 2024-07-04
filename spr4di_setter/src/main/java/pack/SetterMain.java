package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterMain {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
		
		MyProcess my= (MyProcess)context.getBean("myProcess");//bean id명
		my.displayData();
	}
}
