package pack.model;

import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface SqlMapperInter {
	@Select("SELECT jikwon_no, jikwon_name, buser_name, DATE_FORMAT(jikwon_ibsail, '%Y') AS jikwon_ibsail FROM jikwon AS j INNER JOIN buser AS b ON j.buser_num = b.buser_no")
	public List<JikwonDto> selectJikwonAll();
	
	@Select("SELECT buser_name, COUNT(jikwon_no) AS jikwon_count FROM jikwon AS j INNER JOIN buser AS b ON j.buser_num = b.buser_no GROUP BY buser_name")
	public List<JikwonDto> selectBuserCount();
	
	@Select("SELECT buser_name, jikwon_name, jikwon_pay FROM jikwon AS j INNER JOIN buser AS b ON j.buser_num = b.buser_no WHERE jikwon_pay IN (SELECT MAX(jikwon_pay) FROM jikwon WHERE j.buser_num = b.buser_no GROUP BY buser_num) ORDER BY buser_name")
	public List<JikwonDto> selectMaxPay();
	
	/*
	 실행 순서
	1. from jikwon inner join buser on buser_num = buser_no
	2. where jikwon_pay = (select max(jikwon_pay) from jikwon where buser_num = buser_no group by buser_num)
	1번에서 buser 테이블의 buser_no를 참고하는 것
	 */
}