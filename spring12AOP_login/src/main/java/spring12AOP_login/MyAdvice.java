package spring12AOP_login;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
	
	@Around("execution(public void startProcess())") // joinpoint 대상 메소드
	public Object abc(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("AOP 시작, 핵심 로직 수행 전 ID 검증");
		
		System.out.print("input ID : ");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		sc.close();
		
		if(!id.equals("ok")) {
			System.out.println("ID 불일치\n작업을 종료합니다.");
			return null; // 아래 Object obj = jp.proceed(); 구문을 실행하지 않고 return
		}
		
		Object obj = jp.proceed(); // 이 구문이 startProcess() 를 수행하는 것
		return obj;
	}
}
