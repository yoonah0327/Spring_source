package pack.model;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import jakarta.persistence.Table;

public interface ProductCrudRepository extends JpaRepository<ProductVo, Integer>{
	//CrudRepository > PagingAndSortingRepository > JpaRepository
	
	//메소드이름으로 쿼리생성
	// 메소드 이름을 💟find + (엔티티 이름) + By + 변수명💟 형태로 설정하면 "자동으로 쿼리 생성"됨. 엔티티의 이름은 생략 가능
	ProductVo findByCode(Integer code); 
	
	//JPQL
	@Query(value="select p from ProductVo as p")
	/*
	 * @Table(name="provo")
	 * public class ProductVo {
	 * 여기서 ProductVo를 써야한다. 
	 */
	List<ProductVo> findAllData();

	// where 조건
	@Query(value = "select p from ProductVo as p where p.code=:code")
	ProductVo findByCodeMy(@Param("code") int code); //이름으로 연결
	
	@Query(value = "select p from ProductVo as p where p.code=?1")
	ProductVo findByCodeMy2(int code); //순서로 연결
	
	@Query(value = "select p from ProductVo as p where p.code=?1 or p.sang=?2")
	List<ProductVo> findByData(int code, String sang); //순서로 연결
	
}
