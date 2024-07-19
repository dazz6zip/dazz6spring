package pack.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DataRepository extends JpaRepository<MemData, String> {
	
	// num 자동 증가용
	@Query("SELECT MAX(m.num) FROM MemData AS m")
	String findByMaxNum(); 
}
