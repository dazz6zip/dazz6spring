package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("aopInit.xml");
		
		/* AOP 적용 전 */
//		MessageInter mint = (MessageInter)cxt.getBean("msip");
//		mint.sayHi();
		
		/* AOP 적용 후 */
		MessageInter mint = (MessageInter)cxt.getBean("proxy");
		mint.sayHi();
	}
}
