package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.SangpumDto;
import pack.model.SangpumInter;

@Service
public class BusinessImpl implements BusinessInter {
	// model class 호출
	
	@Autowired
	private SangpumInter spi;
	
	@Override
	public void dataPrint() {
		List<SangpumDto> list = spi.selectDataAll();
		System.out.println("코드\t상품명     \t수량\t단가");
		// console 출력
		for (SangpumDto s : list) {
			System.out.println(s.getCode() + "\t" + s.getSang() + "     \t" + s.getSu() + "\t" + s.getDan());
		}
	}

}
