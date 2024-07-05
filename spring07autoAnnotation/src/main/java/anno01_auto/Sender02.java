package anno01_auto;

import org.springframework.stereotype.Component;

@Component
public class Sender02 implements SenderInter {
	@Override
	public void show() {
		System.out.println("show method from Sender02");
	}
}
