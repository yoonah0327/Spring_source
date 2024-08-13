package pack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FriendRepository extends JpaRepository<Friend, Integer>{
	//최대 bunho값 구하기
	@Query("select max(f.bunho) from Friend f") //엔티티명과 맞춰줘야한다. 그래서 
	Integer findLastBunho();
}
