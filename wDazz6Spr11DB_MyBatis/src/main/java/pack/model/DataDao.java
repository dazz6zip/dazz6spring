package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import pack.controller.FormBean;

@Repository
@Slf4j // lombok이 지원하는 log 출력
public class DataDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DataMappingInterface dmi;
	
	public List<SangpumDto> getDataAll() {
//		System.out.println("list.size : " + dmi.selectAll().size());
		logger.info("list.size : " + dmi.selectAll().size());
		return dmi.selectAll();
	}
	
	public List<SangpumDto> getDataSearch(FormBean bean) {
		return dmi.selectSearch(bean);
	}
}
