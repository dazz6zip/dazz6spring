package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductCrudRepository extends JpaRepository<ProductVo, Integer> {
//	CrudRepository > PagingAndSortingRepository > JpaRepository
	
	@Query(value = "SELECT p FROM ProductVo AS p")
	List<ProductVo> findAllData();
	
	/* 메소드 이름으로 쿼리 생성 */
	ProductVo findByCode(Integer code);
	// find + (엔티티이름) + By + 변수이름 (변수타입 변수이름)
	
	/* WHERE 조건 */
	@Query(value = "SELECT p FROM ProductVo AS p WHERE p.code = :code")
	ProductVo findByCodePersonal1(@Param("code") int code);
	
	@Query(value = "SELECT p FROM ProductVo AS p WHERE p.code = ?1")
	ProductVo findByCodePersonal2(int code);
	
	@Query(value = "SELECT p FROM ProductVo AS p WHERE p.code = ?1 OR p.sang = ?2")
	List<ProductVo> findByCodePersonal3(int code, String sang);
	
	/* native Query문 사용 */
	@Query(value = "SELECT code, sang, su, dan from product WHERE code <= 5", nativeQuery = true)
	List<ProductVo> findAllData2();
}
