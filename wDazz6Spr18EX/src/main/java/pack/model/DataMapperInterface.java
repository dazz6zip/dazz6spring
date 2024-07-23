package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DataMapperInterface extends JpaRepository<DataDto, String> {
	
	@Query("SELECT d FROM DataDto AS d WHERE d.num = ?1 AND d.rating = ?2")
	List<DataDto> search(String buser_num, String jikwon_rating);
	 
	@Query("SELECT d FROM DataDto AS d WHERE d.num = ?1")
	List<DataDto> searchAll(String buserName);

}
