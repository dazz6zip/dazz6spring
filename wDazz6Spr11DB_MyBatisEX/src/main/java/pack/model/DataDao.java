package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	
	@Autowired
	private DataMappingInterface dmi;

	public List<DataDto> searchJikwon(String jik) {
		return dmi.searchJikwon(jik);
	}
}