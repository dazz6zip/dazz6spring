package pack.bank;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("shb")
@Scope("prototype")
public class SinhanBank implements Bank {
	private int money = 5000;
	
	@Override
	public void inputMoney(int money) {
		this.money += money;
	}
	
	@Override
	public void outputMoney(int money) {
		this.money -= money;
	}
	
	@Override
	public int getMoney() {
		return money;
	}
}
 