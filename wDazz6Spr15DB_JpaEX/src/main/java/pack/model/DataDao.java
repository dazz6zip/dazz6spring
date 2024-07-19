package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	
	@Autowired
	private JikwonRepository jrt;
	
	public List<Jikwon> getJikwonByJik(String jik) {
		return jrt.findByJik(jik);
	}
}
