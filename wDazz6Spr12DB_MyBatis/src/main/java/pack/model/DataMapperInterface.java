package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pack.controller.DataBean;

@Mapper
public interface DataMapperInterface {

	@Select("SELECT * FROM mem")
	List<DataDto> selectAll();
	
	@Select("SELECT * FROM mem WHERE num = #{num}")
	DataDto selectPart(String num);
	
	@Insert("INSERT INTO mem VALUES (#{num}, #{name}, #{addr})")
	int insertData(DataBean bean);
	
	@Update("UPDATE mem SET name = #{name}, addr = #{addr} WHERE num = #{num}")
	int updateData(DataBean bean);
	
	@Delete("DELETE FROM mem WHERE num = #{num}")
	int deleteData(String num);
	
}
