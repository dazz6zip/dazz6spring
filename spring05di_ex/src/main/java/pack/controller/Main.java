package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		
		MyInter mi = (MyInter)context.getBean("mi");
		// new 키워드를 사용하는 것은 Spring 이 init.xml을 참고하여 대신 해 줌
		mi.inputData();
		mi.showData();
	}
}
