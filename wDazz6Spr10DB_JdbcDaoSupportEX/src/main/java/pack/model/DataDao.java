package pack.model;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao extends JdbcDaoSupport {

	@Autowired
	public DataDao(DataSource ds) {
		super.setDataSource(ds);
	}

	public List<DataDto> searchJikwon(String jik) {
		String sql = "SELECT * FROM jikwon WHERE jikwon_jik = ?";
		List<DataDto> list = getJdbcTemplate().query(sql, (ResultSet rs, int rowNum) -> {
			DataDto dto = new DataDto();
			dto.setNo(rs.getString("jikwon_no"));
			dto.setName(rs.getString("jikwon_name"));
			dto.setGen(rs.getString("jikwon_gen"));
			dto.setPay(rs.getString("jikwon_pay"));
			return dto;
		}, jik);

		return list;
	}
}
