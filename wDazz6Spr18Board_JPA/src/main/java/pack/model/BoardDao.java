package pack.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import pack.controller.BoardBean;

@Repository
public class BoardDao {
	private Logger lg = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DataRepository rps;
	
	/* 전체 자료 읽기 */
	public List<Board> list() {
		List<Board> list = rps.findAll();
		lg.info("list size : " + list.size());
		return list;
	}
	
	/* 검색하기 */
	public List<Board> search(BoardBean bean) {
		List<Board> list = null;
		list = bean.getSearchName().equals("author") ? rps.searchLike1(bean.getSearchValue()) : rps.searchLike2(bean.getSearchValue());		
		return list;
	}
	
	/* 자료 추가하기 */
	@Transactional 
	public String insertData(BoardBean bean) {
		// proxy 객체는 해당 메소드가 처리될 때 Commit 이나 Rollback 수행
		// CheckedException 또는 예외가 없는 경우 Commit
		// UncheckedException 의 경우 Rollback
		try {
			Board dto = new Board();
			// 새 글 번호 부여를 위한 최대값 + 1 작업
			dto.setNum(rps.maxNum() + 1);
			dto.setAuthor(bean.getAuthor());
			dto.setTitle(bean.getTitle());
			dto.setContent(bean.getContent());
			dto.setBwrite(Timestamp.valueOf(LocalDateTime.now()));
			dto.setReadcnt(0);
			rps.save(dto);
			return "success";
		} catch (Exception e2) {
			System.out.println("insert 오류 : " + e2.getMessage());
			return "insert 오류" + e2.getMessage();
		}
	}
	
	/* 상세보기 */
	@Transactional
	public Board detail(int num) {
		// 조회수 증가
		rps.updateReadcnt(num);
		
		// findById()의 반환값은 Optional 타입
		Optional<Board> board = rps.findById(num);
		lg.info("board : {}", board.get());
		return board.isPresent() ? board.get() : new Board();
	}
	
	/* 자료 수정하기 */
	@Transactional
	public String updateData(BoardBean bean) {
		try {
			
			Board board = rps.findById(bean.getNum()).get();
			
//			Board dto = new Board();
//			dto.setNum(bean.getNum());
//			dto.setAuthor(bean.getAuthor());
//			dto.setTitle(bean.getTitle());
//			dto.setContent(bean.getContent());
//			dto.setBwrite(imsi.getBwrite());
//			dto.setReadcnt(imsi.getReadcnt());
//			rps.save(dto);
			
			// 수정할 항목만 setter 사용
			board.setAuthor(bean.getAuthor());
			board.setTitle(bean.getTitle());
			board.setContent(bean.getContent());
			
			return "success";
		} catch (Exception e2) {
			System.out.println("update 오류 : " + e2.getMessage());
			return "update 오류" + e2.getMessage();
		}
	}
	
	/* 자료 삭제하기 */ 
	@Transactional
	public String deleteData(int num) {
		try {
			rps.deleteById(num);
			return "success";
		} catch (Exception e) {
			System.out.println("delete 오류 : " + e.getMessage());
			return "delete 오류" + e.getMessage();
		}
	}
	
}
