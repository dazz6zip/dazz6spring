package pack.gogek;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GogekMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bankInit.xml");
		
		Gogek daniel = (Gogek)context.getBean("gogek");
		daniel.selectBank("sinhan");
		daniel.playInputMoney(500);
		daniel.playOutputMoney(200);
		System.out.print("daniel - ");
		daniel.showMoney();
		
		Gogek john = (Gogek)context.getBean("gogek");
		john.selectBank("sinhan");
		john.playInputMoney(500);
		john.playOutputMoney(200);
		System.out.print("john - ");
		john.showMoney();
		
		Gogek oscar = (Gogek)context.getBean("gogek");
		oscar.selectBank("hana");
		oscar.playInputMoney(500);
		oscar.playOutputMoney(100);
		System.out.print("oscar - ");
		oscar.showMoney();
		
		System.out.println("daniel 객체 주소 : " + daniel);
		System.out.println("john 객체 주소 : " + john);
		System.out.println("oscar 객체 주소 : " + oscar);
		// singleton 으로 하나의 인스턴스를 참고하기 때문에 객체 주소가 모두 같음
		// SinhanBank 와 HanaBank, Gogek 에 @Scope("prototype") 를 추가하면 주소가 달라짐
		// 해당 작업에서는 prototype 이 적합한 것
	}
}
