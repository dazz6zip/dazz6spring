package pack.aspect;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAdvice {
	@Around("execution(public void jikwonList())") // pointcut 대상 : jikwonList()
	public Object haha(ProceedingJoinPoint jp) throws Throwable {
		System.out.print("로그인 아이디 입력 : ");
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		
		if (!id.equalsIgnoreCase("kor")) {
			System.out.println("아이디 불일치\n로그인에 실패했습니다.");
			return null;
		}
		
		Object obj = jp.proceed(); // jikwonList() 실행
		sc.close();
		return obj;
	}
}
