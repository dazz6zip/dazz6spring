package pack.business;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonDto;
import pack.model.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter {
	// model을 포함관계로 호출
	
	@Autowired
	private JikwonInter jki;
	
	@Override
	public void jikwonList() {
		System.out.print("부서 번호 입력 : ");
		Scanner sc = new Scanner(System.in);
		String buserNum = sc.next();
		sc.close();
		
		int count = 0;
		
		for ( JikwonDto j : jki.selectList(buserNum) ) {
			System.out.println(j.getJikwon_no() + "\t" + j.getJikwon_name() + "\t" + j.getBuser_name() + "\t" + j.getBuser_tel() + "\t" + j.getJikwon_jik());
			count++;
		}
		
		System.out.println("총 " + count + "명");
	}

}
