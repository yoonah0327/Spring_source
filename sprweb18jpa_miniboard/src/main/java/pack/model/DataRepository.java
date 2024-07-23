package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface DataRepository extends JpaRepository<Board, Integer>{
	
	//JPQL
	//검색용
	@Query("select b from Board as b where b.author like %?1%") //포함된. 이름별검색
	List<Board> searchLike(String searchValue);
	
	@Query("select b from Board b where b.title like %:searchValue%") //제목별검색
	List<Board> searchLike2(@Param("searchValue") String searchValue);
	/*
	 * @RequestParam: HTTP 요청 파라미터를 컨트롤러 메소드의 파라미터로 매핑
		@Param: Spring Data JPA에서 사용 - 메소드의 파라미터에 사용하여 동적 쿼리의 매개 변수로 사용
	 */
		
	//추가할때 가장 큰 번호 얻기
	@Query("select max(b.num) from Board b")
	int maxNum();
	
	//상세보기 할때 조회수 증가
	//내부적으로 JPA는 벌크연산을 함(update,delete,insert). 영속성 컨텍스트에 있는 Board자료와 db에 있는 Board 값이 다를 수 있다. 
	//벌크 연산 수행 후 영속성 컨텍스트에 있는 쿼리를 refresh(clear)해야한다.
	@Modifying(clearAutomatically = true) //이게 refresh역할. 1차캐시를 비워주는 설정. 영속성 컨텍스트에 있는 쿼리를 초기화함.
	@Query(value = "update Board as bo set bo.readcnt=bo.readcnt+1 where bo.num=?1")
	void updateReadcnt(int num);
	
	
	
}
