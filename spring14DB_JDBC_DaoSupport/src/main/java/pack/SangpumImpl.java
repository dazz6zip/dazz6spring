package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class SangpumImpl extends JdbcDaoSupport implements SangpumInter {
	// JdbcDaoSupport
	// 추상 클래스
	// DB와 상호작용하는 Dao 개발시 편리한 기능 제공
	// JdbcTemplate을 사용하여 DB 작업 처리
	// 템플릿 메소드 패턴을 활용하여 데이터 액세스 작업 구현
	
	// JdbcDaoSupport의 멤버 메소드 중 getJdbcTemplate(), setDataSource() 충족해야 함
	
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
			
			System.out.println("rowNum : " + rowNum);
			
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
