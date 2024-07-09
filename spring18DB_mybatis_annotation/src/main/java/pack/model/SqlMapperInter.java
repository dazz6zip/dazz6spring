package pack.model;

import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface SqlMapperInter {
	@Select("SELECT * FROM sangdata")
	public List<SangpumDto> selectDataAll();
}