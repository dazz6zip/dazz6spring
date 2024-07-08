package pack;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BusinessImpl implements BusinessInter {
	// DB 처리 모델 클래스 사용
	
	@Autowired
	@Qualifier("sangpumImpl") // SanpumInter에서 여러 메소드를 오버라이딩했을 경우 Qualifier 로 지정해 줘야 함 (type 에 의한 매핑이기 때문)
	private SangpumInter spi;
	
	@Override
	public void selectProcess() {
		ArrayList<SangpumDto> myList = spi.selectAll();
		
		for (SangpumDto s : myList) {
			System.out.println(s.getCode() + " | " + s.getSang() + " | " + s.getSu() + " | " + s.getDan());
		}
	}
}
