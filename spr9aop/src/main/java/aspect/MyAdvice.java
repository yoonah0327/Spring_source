package aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//핵심 로직에 삽입할 관심 코드: ex) transaction, login, security, log..
public class MyAdvice implements MethodInterceptor{
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// joinpoint에 삽입될 동작할 코드 기술
		
		System.out.println("핵심로직수행 전 😶‍🌫️블라블라😶‍🌫️처리");
		//target 메소드 이름 얻기
		String tmname= invocation.getMethod().getName();
		System.out.println("적용된 메소드명: "+tmname);
		
		Object object = invocation.proceed(); //선택된 핵심로직 메소드 중 하나 - sayHi()
		
		System.out.println("핵심로직수행 후 😊마무리처리");
		
		return object;
	}
}
