package pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pack.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {
	
	// 사원번호 기준, 오름차순으로 정렬된 목록 반환 메소드
	public List<Emp> findAllByOrderByEmpnoAsc();
	
	
	// findAllByOrderByEmpnoAsc() 0 -> JPQL
	/* JPQL */
	@Query("SELECT e FROM Emp AS e ORDER BY e.empno ASC")
	public List<Emp> getListAll();
	
	// 인자 전달
	// 입력 salary 초과 사료 오름차순 정렬
	@Query("SELECT e FROM Emp AS e WHERE e.sal > :salary ORDER BY e.sal ASC")
	List<Emp> getList(@Param("salary")double salary);
	
	@Query("SELECT e FROM Emp AS e WHERE e.sal > :sal AND e.sal < :sal2 ORDER BY e.sal ASC")
	List<Emp> getListBetween(@Param("sal")int sal);
	
	@Query("SELECT e FROM Emp AS e WHERE e.sal > ?1 AND e.sal < ?2 ORDER BY e.sal ASC")
	List<Emp> getListBetween2(@Param("sal")int sal);
}
