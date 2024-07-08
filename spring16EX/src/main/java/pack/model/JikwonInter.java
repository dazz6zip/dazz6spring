package pack.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface JikwonInter {
	List<JikwonDto> jikwonInfo(String no, String name) throws DataAccessException;
}
