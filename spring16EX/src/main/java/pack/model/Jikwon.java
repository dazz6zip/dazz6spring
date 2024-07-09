package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


@Repository
public class Jikwon extends JdbcDaoSupport implements JikwonInter {
	
	@Autowired
	private DataSource dsc;
	
	@PostConstruct
	public void pc() {
		setDataSource(dsc);
	}
	
	@Override
	public List<JikwonDto> jikwonInfo(String no, String name) throws DataAccessException {
		RowMapper rm = new JikwonMapper();
		// 내부클래스 JikwonMapper 를 인스턴스만 하는 것
		// 오버라이딩한 mapRow가 실행되는 것이 아님
		
		String sql = "SELECT jikwon_name, jikwon_jik, jikwon_gen FROM jikwon AS j INNER JOIN gogek AS g ON j.jikwon_no = g.gogek_damsano WHERE g.gogek_no = '" + no + "' AND g.gogek_name = '" + name + "'";

		return getJdbcTemplate().query(sql, rm);
		// query에서 mapRow가 실행됨
	}
	
	class JikwonMapper implements RowMapper {
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new JikwonDto() {
				{
					setJikwon_name(rs.getString("jikwon_name"));
					setJikwon_jik(rs.getString("jikwon_jik"));
					setJikwon_gen(rs.getString("jikwon_gen"));
				}
			};
		}
	}
}
