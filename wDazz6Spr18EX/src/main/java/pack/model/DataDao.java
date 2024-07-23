package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {

	@Autowired
	private DataMapperInterface mpif;
	
	public List<DataDto> search(DataBean bean) {
		System.out.println(bean.getBuserName() + " " + bean.getSelectRating());
		return bean.getSelectRating().equals("all") ? mpif.searchAll(bean.getBuserName()) : mpif.search(bean.getBuserName(), bean.getSelectRating());
	}
}
