package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pack.controller.MemberBean;

@Repository
public class MemberDao extends JdbcDaoSupport {
	
	@Autowired
	public MemberDao(DataSource ds) {
		super.setDataSource(ds);
	}
	
	/* 전체 자료 읽기 */
	public List<MemberDto> getMemberList() {
		String sql = "SELECT * FROM memberteb";
		
//		List<MemberDto> list = getJdbcTemplate().query(sql, new RowMapper() {
//			@Override
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				MemberDto dto = new MemberDto();
//				dto.setId(rs.getString("id"));
//				dto.setName(rs.getString("name"));
//				dto.setPasswd(rs.getString("passwd"));
//				dto.setReg_date(rs.getString("reg_date"));
//				return dto;
//			}
//		});
		
		// mapRow는 추상 메소드가 하나기 때문에 람다 표현식 사용 가능
		List<MemberDto> list = getJdbcTemplate().query(sql, (ResultSet rs, int rowNum) -> {
			MemberDto dto = new MemberDto();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setPasswd(rs.getString("passwd"));
			dto.setReg_date(rs.getString("reg_date"));
			return dto;
		});
		
		return list;
	}
	
	/* 자료 추가하기 */
	public void insertMember(MemberBean bean) {
		String sql = "INSERT INTO memberteb VALUES (?, ?, ?, now())";
		Object[] params = {bean.getId(), bean.getName(), bean.getPasswd()};
		// 배열값으로 치환
		getJdbcTemplate().update(sql, params);

	}
	
	/* 특정 레코드 읽기 */
	public MemberDto getMember(String id) {
		String sql = "SELECT * FROM memberteb WHERE id = ?";
		MemberDto dto = (MemberDto)getJdbcTemplate().queryForObject(sql, new Object[] {id}, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDto dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setReg_date(rs.getString("reg_date"));
				return dto;
			}
		});
		return dto;
	}
	
	/* 자료 수정하기 */
	public void upData(MemberBean bean) {
		String sql = "UPDATE memberteb SET name = ?, passwd = ? WHERE id = ? ";
		getJdbcTemplate().update(sql, new Object[] {bean.getName(), bean.getPasswd(), bean.getId()});
	}
	
	/* 자료 삭제하기 */
	public void delData(String id) {
		String sql = "DELETE FROM memberteb WHERE id = ?";
		getJdbcTemplate().update(sql, new Object[] {id});
	}
}
