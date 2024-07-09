package pack.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pack.model.SqlMapperInter;

public class SqlMapConfig {
	public static SqlSessionFactory ssf; // DB의 SQL명령을 실행시킬 때 필요한 메소드를 갖고 있다.

	static {
		String resource = "pack/mybatis/Configuration.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			ssf = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			
			// MyBatis Annotation 사용시 추가
			Class[] mps = { SqlMapperInter.class };
			for(Class cl : mps) {
				ssf.getConfiguration().addMapper(cl);
			}
		} catch (Exception e) {
			System.out.println("SqlMapConfig 오류 : " + e);
		}
	}	

	public static SqlSessionFactory getSqlSession() {
		return ssf;
	}
}
