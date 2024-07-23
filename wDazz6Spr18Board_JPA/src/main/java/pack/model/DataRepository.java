package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DataRepository extends JpaRepository<Board, Integer> {	
	
	/* 검색 */
	// 작성자 검색
	@Query("SELECT b FROM Board AS b WHERE b.author LIKE %?1%")
	List<Board> searchLike1(String searchValue);
	
	// 제목 검색
	@Query("SELECT b FROM Board AS b WHERE b.title LIKE %:searchValue%")
	List<Board> searchLike2(@Param("searchValue") String searchValue);
	
	/* 추가 */
	// 가장 큰 번호 얻기
	@Query("SELECT MAX(b.num) FROM Board AS b")
	int maxNum();
	
	/* 상세보기 */
	// 조회수 증가
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Board AS b SET b.readcnt = b.readcnt + 1 WHERE b.num = ?1")
	void updateReadcnt(int num);
	// @Modifying(clearAutomatically = true) : 1차 캐시를 비워 줌 (영속성 컨텍스트에 있는 Query 초기화)
	// JPA는 UPDATE, DELETE, INSERT 작업에서 내부적으로 벌크 연산을 하기 때문에
	// 영속성 컨텍스트에 있는 자료(Board)와 DB에 있는 자료(springboard) 값이 다를 수 있으므로 @Modifying annotation을 걸어 줘야 함

}
