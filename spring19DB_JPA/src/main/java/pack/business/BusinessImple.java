package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.DataInterface;
import pack.model.MemDto;

@Service
public class BusinessImple implements BusinessInter {

	@Autowired
	private DataInterface dif;
	
	@Override
	public void dataPrint() {
		List<MemDto> mlist = dif.selectDataAll();
		
		System.out.println("dataPrint() 출력");
		for(MemDto m : mlist) {
			System.out.println(m.getNum() + "\t" + m.getName() + "\t" + m.getAddr());
		}
	}

}
