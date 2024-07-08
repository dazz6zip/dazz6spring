package spring12AOP_login;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("init.xml");
		BusinessLogicInter bli = (BusinessLogicInter)cxt.getBean("bImpl");
		
		bli.startProcess();
	}
}