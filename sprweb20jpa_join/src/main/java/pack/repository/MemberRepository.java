package pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pack.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

	public List<Member> findAllByOrderByNumDesc();
}
