package anno01_auto;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "anno01_auto")
public class Main01 {
	public static void main(String[] args) {
		// @Autowired 에 대한 메인
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main01.class);
		SenderProcess process = context.getBean("senderProcess", SenderProcess.class);
		process.displayData();
	}

}
