package pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pack.entity.Jikwon;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{
	
	//query method
	List<Jikwon> findByJik(String jik);
}
