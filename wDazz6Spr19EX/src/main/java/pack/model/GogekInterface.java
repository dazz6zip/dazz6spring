package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pack.entity.Gogek;

public interface GogekInterface extends JpaRepository<Gogek, String> {
	
	public List<Gogek> findByJikwonNo(String no);
}
