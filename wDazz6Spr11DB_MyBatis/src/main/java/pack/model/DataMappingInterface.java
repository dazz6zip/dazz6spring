package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import pack.controller.FormBean;

@Mapper
public interface DataMappingInterface {
	
	@Select("SELECT * FROM sangdata")
	List<SangpumDto> selectAll();
	
	@Select("SELECT code, sang, su, dan FROM sangdata WHERE sang LIKE CONCAT('%', #{searchValue}, '%')")
	List<SangpumDto> selectSearch(FormBean bean);
}