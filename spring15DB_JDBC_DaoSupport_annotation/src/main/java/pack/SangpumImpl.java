package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class SangpumImpl extends JdbcDaoSupport implements SangpumInter {
	
	@Autowired // DataSource가 component 여야 함
	public SangpumImpl(DataSource dsc) {
		setDataSource(dsc);
		// DataSource가 DB 처리 중 최우선되어야 하기 때문에 constructor injection로 의존성 주입
	}
	
	@Override
	public ArrayList<SangpumDto> selectAll() {
		RowMapper rm = new SangpumRowMapper();
		return (ArrayList)getJdbcTemplate().query("SELECT * FROM sangdata", rm);
	}
	
	// 내부 클래스
	class SangpumRowMapper implements RowMapper {
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// 내부적인 PreparedStatement 처리에 의해 SELECT의 실행 결과가 mapRow로 전달
			// rs.next() 사용할 필요 없음
			
//			System.out.println("rowNum : " + rowNum);
			
			SangpumDto dto = new SangpumDto();
			dto.setCode(rs.getString("code"));
			dto.setSang(rs.getString("sang"));
			dto.setSu(rs.getString("su"));
			dto.setDan(rs.getString("dan"));
			return dto;
			
			// rowMapper에 의해 dto가 List 컬렉션에 저장 (레코드 자료가 소진될 때까지)
		}
	}
}
