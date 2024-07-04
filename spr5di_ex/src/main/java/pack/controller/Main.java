package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
		
		MyInter myInter = (MyInter)context.getBean("myImpl");
		myInter.inputData();
		myInter.showData();
	}

}
