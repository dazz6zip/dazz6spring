package anno01_auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration // 환경을 여기서 설정하겠다고 선언 (xml 필요없음)
@ComponentScan(basePackages = "anno01_auto") // 스캔할 때 instance // 여러 개 스캔 가능
public class Main01 {
	public static void main(String[] args) {
		// @Autowired 에 대한 메인
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main01.class);
		// xml 대신 Main01.class 파일을 가지고 환경을 잡겠다는 뜻
		
/*		ApplicationContext context = new ClassPathXmlApplicationContext("anno01.xml");
		// 위 같은 기존 방법을 사용해도 됨
		// 이 경우에는 @Configuration, @ComponentScan 어노테이션이 필요하지 않고
		// AnnotationConfigApplicationContext 을 사용하지 않아도 됨 */
		
		SenderProcess process = context.getBean("senderProcess", SenderProcess.class);
		// casting 대신 argument 두 개 사용
		process.displayData();
	}

}
