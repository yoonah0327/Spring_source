package pack.aspect;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAdvice { //관심사항
	@Around("execution(public void jikwonList())") //직원리스트하기전에 꼭 로그인하고싶다
	public Object haha(ProceedingJoinPoint joinPoint) throws Throwable{
	System.out.println("로그인아이디 입력:"); //  이공간에 로그인, 트랜젝션, 시큐리티 등을 거는것.
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		
		
		if(!id.equalsIgnoreCase("kor")) {
			System.out.println("id불일치. 로그인 실패");
			return null;
		}
		Object object = joinPoint.proceed(); //직원리스트가 수행되는곳
		sc.close();
		
		return object;
		
	}
}
