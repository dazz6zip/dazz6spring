package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SangpumRepository extends JpaRepository<Sangpum, Integer> {
	
	/* 검색 */
	// 메소드 네이밍 룰
	// find + (엔티티이름) + By + 변수이름 (변수타입 변수이름)
	// readBy, getBy...
	// findBy변수명And변수명, findBy변수명Or변수명, findBy변수명GreaterThanEqual변수명...
	
	public List<Sangpum> findBySangContaining(String searchValue);
	// Containing : 검색어가 포함된 (SQL의 LIKE '%검색어%')
	
	public List<Sangpum> findBySangStartingWith(String searchValue);
	// StartingWith : 검색어로 시작하는 (SQL의 LIKE '검색어%')

	public List<Sangpum> findBySangEndingWith(String searchValue);
	// EndingWith : 검색어로 끝나는 (SQL의 LIKE '%검색어')
	
	
	/* JPQL */
	@Query("SELECT s FROM Sangpum AS s WHERE s.sang LIKE %:searchValue%")
	public List<Sangpum> searchLike(@Param("searchValue") String searchValue);
	
}
