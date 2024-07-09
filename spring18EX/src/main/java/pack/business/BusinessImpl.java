package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonDto;
import pack.model.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter {
	// model class 호출
	
	@Autowired
	private JikwonInter spi;
	
	@Override
	public void dataPrint() {
		List<JikwonDto> list1 = spi.selectJikwonAll();
		List<JikwonDto> list2 = spi.selectBuserCount();
		List<JikwonDto> list3 = spi.selectMaxPay();
		
		System.out.println("- 직원 자료\n사번\t이름\t부서명\t입사년");
		for (JikwonDto j : list1) {
			System.out.println(j.getJikwon_no() + "\t" + j.getJikwon_name() + "\t" + j.getBuser_name() + "\t" + j.getJikwon_ibsail());
		}
		
		System.out.println("\n- 부서별 인원수");
		for (JikwonDto j : list2) {
			System.out.println(j.getBuser_name() + "\t" + j.getJikwon_count());
		}
		
		System.out.println("\n- 부서별 최대 급여자");
		for (JikwonDto j : list3) {
			System.out.println(j.getBuser_name() + "\t" + j.getJikwon_name() + "\t" + j.getJikwon_pay());
		}

	}

}
