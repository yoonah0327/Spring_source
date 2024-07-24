package pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pack.entity.Dept;

public interface DeptRepository extends JpaRepository<Dept, Integer>{ //초기치 int <- 0. Integer <- Null
	
	
}
