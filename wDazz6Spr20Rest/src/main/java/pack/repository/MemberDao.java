package pack.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.dto.MemberDto;

@Repository
public class MemberDao {

	@Autowired
	private SqlSession ss;

	/* 회원자료 전체 읽기 */
	public List<MemberDto> getList() {
		return ss.selectList("member.getList");
	}

	/* 회원자료 추가하기 */
	public void insert(MemberDto dto) {
		ss.insert("member.insert", dto);
	}

	/* 회원자료 하나 읽기 */
	public MemberDto getData(int num) {
		return ss.selectOne("member.getData", num);
	}

	/* 회원자료 수정하기 */
	public void update(MemberDto dto) {
		ss.update("member.update", dto);
	}	

	/* 회원자료 삭제하기 */
	public void delete(int num) {
		ss.delete("member.delete", num);
	}
}
