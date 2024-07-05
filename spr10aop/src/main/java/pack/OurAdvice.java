package pack;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class OurAdvice { // Aspect 클래스. Advice 용.
	public Object kbs(ProceedingJoinPoint joinPoint) throws Throwable{
		//수행시간 체크
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		System.out.println("핵심 메소드 수행 전 aspect 실행");
		
		Object object = joinPoint.proceed(); //선택된 핵심 메소드 수행
		
		System.out.println("핵심 메소드 수행 후 뭔가 실행");
		
		stopWatch.stop();
		System.out.println("처리 시간: "+ stopWatch.getTotalTimeSeconds());
		return object;
	}
	// sbs, mbc 클래스 등등 잇을것

}
