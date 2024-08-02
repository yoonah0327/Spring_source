package pack.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.dto.MemberDto;

@Repository
public class MemberDao {
	
	@Autowired
	private SqlSession session;
	
	//회원자료 전체읽기
	public List<MemberDto> getList(){
		return session.selectList("member.getList");
	}
	
	//회원자료 추가하기
	public void insert(MemberDto dto) {
		session.insert("member.insert", dto);
	}
	//--------여기서부턴 리액트에서 수행--------------
	//회원자료 1개 읽어오기
	public MemberDto getData(int num) {
		return session.selectOne("member.getData", num);
	}
	
	//회원자료 수정하기
	public void update(MemberDto dto) {
		session.insert("member.update", dto);
	}
	// 회원자료 삭제하기
	public void delete(int num) {
		session.insert("member.delete", num);
	}
	
}
