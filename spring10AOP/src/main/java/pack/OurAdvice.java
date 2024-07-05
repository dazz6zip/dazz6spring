package pack;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class OurAdvice { // Aspect 클래스 : Advice용
	public Object kbs(ProceedingJoinPoint joinPoint) throws Throwable {
		// 수행 시간 체크
		StopWatch sw = new StopWatch();
		sw.start();
		
		System.out.println("핵심 메소드 수행 전 관심 사항 실행");
		
		Object obj = joinPoint.proceed(); // 선택된 핵심 method 수행
		
		System.out.println("핵심 메소드 수행 후 무언가 실행");
		
		sw.stop();
		System.out.println("처리 시간 : " + sw.getTotalTimeSeconds());
		return obj;
	}
}
