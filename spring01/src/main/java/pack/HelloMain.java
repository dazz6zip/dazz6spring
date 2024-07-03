package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		// 처리 01 : 전통적 방법
		Message01 m1 = new Message01();
		m1.sayHello("김이름");
		
		Message02 m2 = new Message02();
		m2.sayHello("박이름");
		
		MessageInter inter;
		inter = m1;
		inter.sayHello("최이름");
		inter = m2;
		inter.sayHello("여이름");
		
		// 처리 02
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		// resources 밖에 있을 경우 : ApplicationContext context = new ClassPathXmlApplicationContext("classpath:pack/init.xml");
		MessageInter inter2 = (MessageInter)context.getBean("mes1");
		inter2.sayHello("백이름");
		MessageInter inter3 = (MessageInter)context.getBean("mes2");
		inter3.sayHello("홍이름");
	}
}
 