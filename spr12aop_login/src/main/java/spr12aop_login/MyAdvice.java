package spr12aop_login;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
	@Around("execution(public void startProcess())")
	
	public Object abc(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("AOP시작: 핵심로직수행 전 id검사");
		
		System.out.println("input id: ");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		sc.close();
		
		if(!id.equals("ok")) {
			System.out.println("아이디불일치! 작업종료한다!!!!");
			return null; //ok아니면, return null로 빠져나오고, 하단의 오브젝코드를 만나지 않는다. 
			//ok면, 하단의 오브젝코드를 만나고, return object을 갖고 간다.
		}
		
		Object object = joinPoint.proceed(); //? 이 코드랑 @around 코드 확인 얘가 수행하는 메소드가 "execution(public void startProcess())")임.
		
		return object; 
	}

}
