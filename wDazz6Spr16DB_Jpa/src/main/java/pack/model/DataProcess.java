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
	
	/* 부분 자료 읽기 2 */
	public MemData getData2(String num) {
		return drt.findByNum(num);
	}
	
	/* 자료 추가하기 */
	public String insert(DataBean bean) {
		// num 자동 증가
//		md.setNum(drt.findByMaxNum());
		
		// num 중복 확인
		try {
			MemData md = drt.findById(bean.getNum()).get();
			System.out.println("md : " + md);
			return "이미 등록된 번호입니다.";
		} catch (Exception e) {
			try {
				MemData md = new MemData();
				md.setNum(bean.getNum());
				md.setName(bean.getName());
				md.setAddr(bean.getAddr());
				md = drt.save(md);
				System.out.println("md : " + md);
				return "success";
			} catch (Exception e2) {
				System.out.println("insert 오류 : " + e2.getMessage());
				return "insert 오류" + e2.getMessage();
			}
		}
	}
	
	/* 자료 수정하기 */
	public String update(DataBean bean) {
		try {
			MemData md = new MemData();
			md.setNum(bean.getNum());
			md.setName(bean.getName());
			md.setAddr(bean.getAddr());
			drt.save(md);
			return "success";
		} catch (Exception e) {
			System.out.println("update 오류 : " + e.getMessage());
			return "오류 : " + e.getMessage();
		}
	}

	/* 자료 삭제하기 */
	public String delete(String num) {
		try {
			drt.deleteById(num);
			return "success";
		} catch (Exception e) {
			System.out.println("delete 오류 : " + e.getMessage());
			return "오류 : " + e.getMessage();
		}
	}
}
