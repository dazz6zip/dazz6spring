package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("arrange.xml");
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("arrange.xml");
		
		System.out.println("----- SingleTon 확인 -----");
		MessageImpl mi1 = (MessageImpl)context.getBean("mi");
		mi1.sayHi();
		MessageImpl mi2 = (MessageImpl)context.getBean("mi");
		mi2.sayHi();
		
		System.out.println("객체 주소 : " + mi1 + " / " + mi2);
		// Spring은 기본적으로 singleton 패턴
		// 객체 주소가 같음
		
		System.out.println("----- 다형성 처리 1 -----");
		MessageInter mit1 = (MessageInter)context.getBean("mi");
		mit1.sayHi();

		System.out.println("----- 다형성 처리 2 -----");
		MessageInter mit2 = context.getBean("mi", MessageInter.class);
		mit2.sayHi();
		
		context.close();
	}
}
