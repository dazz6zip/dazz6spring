package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessImpl implements BusinessInter {
	// DB 처리를 위한 모델 클래스를 포함관계로 호출

	@Autowired
	private SangpumInter spi;

//	@Override
//	public void selectProcess() {
//		for(SangpumDto s : spi.selectAll()) {
//			System.out.println(s.getCode() + " | " + s.getSang() + " | " + s.getSu() + " | " + s.getDan());
//		}
//	}
	
	@Override
	public void selectProcess() {
		// 람다 표현식 사용
		spi.selectAll().forEach((s) -> {
			System.out.println(s.getCode() + " | " + s.getSang() + " | " + s.getSu() + " | " + s.getDan());
		});
	}
	
}
