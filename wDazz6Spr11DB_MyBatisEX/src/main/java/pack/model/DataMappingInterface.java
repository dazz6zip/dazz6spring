package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMappingInterface {

	@Select("SELECT jikwon_no AS no, jikwon_name AS name, jikwon_gen AS gen, jikwon_pay AS pay FROM jikwon WHERE jikwon_jik = #{jik}")
	List<DataDto> searchJikwon(String jik);

}