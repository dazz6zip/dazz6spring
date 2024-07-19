package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {

	@Autowired
	private SangpumRepository srt;
	
	/* 전체 자료 읽기 */
	public List<Sangpum> getDataAll() {
		return srt.findAll(); // 기본적으로 JPA가 지원하는 메소드
	}
	
	/* 검색하기 */
	public List<Sangpum> getDataSearch(String searchValue) {
//		return srt.findBySangContaining(searchValue);
		return srt.searchLike(searchValue);
	}
}
