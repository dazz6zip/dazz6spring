package anno02_resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main02 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("anno02.xml");
		AbcProcess process = context.getBean("abcProcess", AbcProcess.class);
		process.showData();
	}

}
