package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.DataInterface;
import pack.model.JikwonDTO;

@Service
public class BusinessImple implements BusinessInter {

	@Autowired
	private DataInterface dif;
	
	@Override
	public void dataPrint() {
		List<JikwonDTO> jlist = dif.jikwonList();
		List<Object[]> tlist = dif.teamCount();

		System.out.println("\n- 직원자료");
		for(JikwonDTO j : jlist) {
			System.out.println(j.getNo() + "\t" + j.getName() + "\t" + j.getTeam() + "\t" + j.getYear());
		}
		
		System.out.println("\n- 부서별 최대 급여자");
		for(Object[] t : tlist) {
			String buserNum = (String) t[0];
			Long count = (Long) t[1];
			System.out.println(buserNum + "\t" + count);
		}
		System.out.println("\n");
		
	}

}
