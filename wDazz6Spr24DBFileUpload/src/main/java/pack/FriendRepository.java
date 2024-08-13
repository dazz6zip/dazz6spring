package pack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FriendRepository extends JpaRepository<Friend, Integer> {

	@Query("SELECT MAX(f.bunho) FROM Friend AS f")
	public Integer findLastBunho();
	
	
	
}
