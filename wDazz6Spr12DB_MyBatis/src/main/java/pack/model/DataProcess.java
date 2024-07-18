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
	private DataMapperInterface dmi; // spring - hikaripool 자동 지원
	
	/* 전체 자료 읽기 */
	public List<DataDto> getDataAll() {
		return dmi.selectAll();
	}
	
	/* 부분 자료 읽기 */
	public DataDto getData(String num) {
		return dmi.selectPart(num);
	}
	
	/* 자료 추가하기 */
	public boolean insert(DataBean bean) {
		// 번호 중복 방지, 번호 자동 증가 등 작업 필요
		return dmi.insertData(bean) > 0 ? true : false;
	}
	
	/* 자료 수정하기 */
	public boolean update(DataBean bean) {
		return dmi.updateData(bean) > 0 ? true : false;
	}
	
	/* 자료 삭제하기 */
	public boolean delete(String num) {
		return dmi.deleteData(num) > 0 ? true : false;
	}
}
