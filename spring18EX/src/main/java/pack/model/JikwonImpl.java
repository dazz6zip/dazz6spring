package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class JikwonImpl implements JikwonInter {
	private SqlSessionFactory ssf = SqlMapConfig.getSqlSession();
	
	@Override
	public List<JikwonDto> selectJikwonAll() {
		SqlSession ss = ssf.openSession();
		List<JikwonDto> list = null;
		
		try {
			SqlMapperInter smpi = (SqlMapperInter)ss.getMapper(SqlMapperInter.class);
			list = smpi.selectJikwonAll();
		} catch (Exception e) {
			System.out.println("selectJikwonAll() ERROR : " + e.getMessage());
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return list;
	}
	
	@Override
	public List<JikwonDto> selectBuserCount() {
		SqlSession ss = ssf.openSession();
		List<JikwonDto> list = null;
		
		try {
			SqlMapperInter smpi = (SqlMapperInter)ss.getMapper(SqlMapperInter.class);
			list = smpi.selectBuserCount();
		} catch (Exception e) {
			System.out.println("selectBuserCount() ERROR : " + e.getMessage());
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return list;
	}
	
	@Override
	public List<JikwonDto> selectMaxPay() {
		SqlSession ss = ssf.openSession();
		List<JikwonDto> list = null;
		
		try {
			SqlMapperInter smpi = (SqlMapperInter)ss.getMapper(SqlMapperInter.class);
			list = smpi.selectMaxPay();
		} catch (Exception e) {
			System.out.println("selectMaxPay() ERROR : " + e.getMessage());
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return list;
	}

}
