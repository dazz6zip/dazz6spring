package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.DataDao;
import model.DataDaoImpl;

public class ServiceMain {

	public static void main(String[] args) {
		/* 전통적 방법 */
		// DB 처리 객체 생성
		DataDaoImpl ddi = new DataDaoImpl();
		DataDao dd = ddi; // 자식의 주소를 부모에게 부여한 것
		
		// Business Logic 관련 객체 생성
		ProcessServiceImpl psi = new ProcessServiceImpl(dd);
		ProcessService ps = psi; // 자식의 주소를 부모에게 부여한 것
		ps.selectProcess();
		
		System.out.println("----------");
		
		/* Spring 방법 */
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		ProcessService ps2 = (ProcessService)context.getBean("psi");
		ps2.selectProcess();
	}
}
