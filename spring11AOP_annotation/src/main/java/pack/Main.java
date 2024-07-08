package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("aopInit.xml");
		LogicInter inter = (LogicInter)cxt.getBean("logicImpl");
		
		inter.selectDataProcess01();
		inter.selectDataProcess02();
	}
}
