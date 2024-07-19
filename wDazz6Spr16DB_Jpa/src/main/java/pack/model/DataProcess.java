package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.DataBean;

@Repository
public class DataProcess {
	private Logger lgr = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DataRepository drt; // spring - hikaripool 자동 지원
	
	/* 전체 자료 읽기 */
	public List<MemData> getDataAll() {
		return drt.findAll();
	}
	
	/* 부분 자료 읽기 */
	public MemData getData(String num) {
		return drt.findById(num).get();
	}
	
	/* 자료 추가하기 */
	public void insert(DataBean bean) {
		MemData md = new MemData();
		// num 자동 증가
//		md.setNum(drt.findByMaxNum());
		
		// num 중복 확인
		try {
			MemData mem = drt.findById(bean.getNum()).get();
			System.out.println("이미 등록된 번호입니다. (mem : " + mem + ")");
//			return "이미 등록된 번호입니다.";
		} catch (Exception e) {
			try {
				md.setNum(bean.getNum());
				md.setName(bean.getName());
				md.setAddr(bean.getAddr());
				md = drt.save(md);
			} catch (Exception e2) {
				System.out.println("입력 오류 : " + e2.getMessage());
			}
		}
	}
	
	public void update(DataBean bean) {
		MemData md = new MemData();
		md.setNum(bean.getNum());
		md.setName(bean.getName());
		md.setAddr(bean.getAddr());
		drt.save(md);
	}

	/* 자료 삭제하기 */
	public void delete(String num) {
		drt.deleteById(num);
	}
}
