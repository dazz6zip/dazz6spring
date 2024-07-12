package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WDazz6Spr05Application {

	public static void main(String[] args) {
		SpringApplication.run(WDazz6Spr05Application.class, args).getBean(WDazz6Spr05Application.class).execute();
	}
	
	@Autowired
	My my;
	
	@Autowired
	ProcessServiceImpl psi;
	
	private void execute() {
		System.out.println("execute method");
		my.aaa();
		
		psi.selectProcess();
	}

}
