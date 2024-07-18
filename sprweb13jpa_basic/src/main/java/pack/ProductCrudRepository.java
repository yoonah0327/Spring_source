package pack;

import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<ProductVo, Integer>{
	//save(), findById(), count()등을 지원받을 수 있다.
	
}
