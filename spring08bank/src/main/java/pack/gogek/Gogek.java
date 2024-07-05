package pack.gogek;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pack.bank.Bank;
import pack.bank.HanaBank;
import pack.bank.SinhanBank;

@Service
@ComponentScan("pack.bank")
@Scope("prototype")
public class Gogek {
	private Bank bank;
	
	@Autowired(required = true) // type 으로 연결 
	private SinhanBank shb;
	// required -> false : 있으면 사용, 없으면 매핑 안 함 / true : 있으면 사용, 없으면 에러
	
	@Resource(name="hnb") // name 으로 연결
	private HanaBank hnb;
	
	public void selectBank(String sel) {
		if (sel.equals("sinhan")) {
			bank = shb;
		} else if (sel.equals("hana")) {
			bank = hnb;
		}
	}
	
	public void playInputMoney(int money) {
		bank.inputMoney(money);
	}
	
	public void playOutputMoney(int money) {
		bank.outputMoney(money);
	}
	
	private String msg;
	
	@PostConstruct // 생성자 처리 후 자동 호출 : 초기화 작업 가능
	public void abc() {
		msg = "잔액 : ";
	}
	
	@PreDestroy // 웹 서비스 종료 직전 자동 호출 : 마무리 작업 가능
	public void def() {
		if (shb != null) {
			shb = null;
		}
		if (hnb != null) {
			hnb = null;
		}
	}
	
	public void showMoney() {
//		System.out.println("잔액 : " + bank.getMoney() + "원");
		System.out.println(msg + bank.getMoney() + "원");
	}
	
}
