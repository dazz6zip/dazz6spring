package pack;

public class LogicImpl implements LogicInter {
	private ArticleInter atci;
	
	public LogicImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public LogicImpl(ArticleInter atci) {
		this.atci = atci;
	}
	
	@Override
	public void selectDataProcess01() {
		System.out.println("selectDataProcess01 complete");
		atci.selectAll(); // 모델 클래스 수행 결과 출력
	}
	
	@Override
	public void selectDataProcess02() {
		System.out.println("----------------------------");
		System.out.println("selectDataProcess02 complete");
		atci.selectAll(); // 모델 클래스 수행 결과 출력
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("selectDataProcess02() ERROR " + e.getMessage());
		}
		System.out.println("3초 지연 처리");
	}
}
