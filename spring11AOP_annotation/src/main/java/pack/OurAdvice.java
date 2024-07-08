package pack;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component // Aspect는 istance가 안 되기 때문에 Component도 걸어 줌
public class OurAdvice { // Aspect 클래스 : Advice용
	@Around("execution(* *..*LogicInter*.*(..)) || execution(public void selectAll())")
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
