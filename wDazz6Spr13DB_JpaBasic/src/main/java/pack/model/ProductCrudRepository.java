package pack.model;

import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<ProductVo, Integer> {
	// save(), findById(), count(), ... 지원
}
