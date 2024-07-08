package pack;

public class BusinessImpl implements BusinessInter {
	// DB 처리를 위한 모델 클래스를 포함관계로 호출
	private SangpumInter spi;
	
	public void setSpi(SangpumInter spi) {
		this.spi = spi;
	}
	
	@Override
	public void selectProcess() {
		for(SangpumDto s : spi.selectAll()) {
			System.out.println(s.getCode() + " | " + s.getSang() + " | " + s.getSu() + " | " + s.getDan());
		}
	}
}
