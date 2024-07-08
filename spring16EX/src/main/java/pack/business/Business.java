package pack.business;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import pack.model.JikwonDto;
import pack.model.JikwonInter;

@Service
public class Business implements BusinessInter {
	
	@Autowired
	private JikwonInter jki;

	@Override
	public void contactJikwon() {
		Scanner sc = new Scanner(System.in);
		System.out.print("고객 번호 : ");
		String no = sc.next();
		System.out.print("고객 이름 : ");
		String name = sc.next();
		sc.close();
		
		JikwonDto jdto = jki.jikwonInfo(no, name).get(0);

		if (jdto != null) {
			System.out.println(jdto.getJikwon_name() + " " + jdto.getJikwon_jik() + " " + jdto.getJikwon_gen()); 
		} else {
			System.out.println("없음");
		}
	}
}
