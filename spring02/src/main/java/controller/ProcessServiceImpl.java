package controller;

import model.DataDao;

public class ProcessServiceImpl implements ProcessService {
	private DataDao dDao;
	// 클래스의 포함 관계
	// (참고) spring은 상속을 지양함

	public ProcessServiceImpl() {
		// 스프링에서는 argument 없는 생성자도 명시하는 것을 권장함
	}

	public ProcessServiceImpl(DataDao dDao) {
		this.dDao = dDao;
	}

	@Override
	public void selectProcess() {
		System.out.println("selectProcess 처리 시작");
		dDao.selectData(); // model 영역의 클래스 수행
		System.out.println("selectProcess 처리 종료");
	}
}