package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemRepository extends JpaRepository<Mem, Integer>{
	
	//num 자동증가용 추상메소드
	@Query(value = "select max(m.num) from Mem as m") //jpql문
	//@Query(value = "select max(num) from mem", nativeQuery = true)
	int findByMaxNum();
}
