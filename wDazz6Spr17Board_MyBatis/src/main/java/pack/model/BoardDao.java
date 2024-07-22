package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.BoardBean;

@Repository
public class BoardDao {
	private Logger lg = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataMapperInterface mpif;
	
	/* 전체 자료 읽기 */
	public List<Board> list() {
		List<Board> list = null;
		
		try {
			list = mpif.selectList();
		} catch (Exception e) {
			lg.info("list() ERROR : " + e.getMessage());
		}
		
		return list;
	}
	
	/* 새 글 등록 */
	public boolean insertData(BoardBean bean) {
		return mpif.insert(bean) > 0 ? true : false;
	}
	
	/* 검색 */
	public List<Board> search(BoardBean bean) {
		return mpif.selectSearch(bean);
	}
	
	/* 글 상세보기 */
	public Board detail(String num) {
		// 조회수 증가 작업
		mpif.updateReadcnt(num);
		
		return mpif.selectOne(num);
	}
	
	/* 글 수정하기 */
	public boolean updateData(BoardBean bean) {
		return mpif.update(bean) > 0 ? true : false;
	}
	
	/* 글 삭제하기 */
	public boolean deleteData(BoardBean bean) {
		return mpif.delete(Integer.toString(bean.getNum())) > 0 ? true : false;
	}
}
