package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class SangpumImpl implements SangpumInter {
	private SqlSessionFactory ssf = SqlMapConfig.getSqlSession();
	
	@Override
	public List<SangpumDto> selectDataAll() {
		SqlSession ss = ssf.openSession();
		List<SangpumDto> list = null;
		
		try {
			list = ss.selectList("selectDataAll");
		} catch (Exception e) {
			System.out.println("selectDataAll() ERROR : " + e.getMessage());
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		
		return list;
	}

}
