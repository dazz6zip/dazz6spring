package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DataMapperInterface {
	List<DataDto> search(DataBean bean);
	List<DataDto> searchAll(String buserName);
	String maxPay(String buserName);
}
