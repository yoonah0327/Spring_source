package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	@Autowired
	private SangpumRepository repository;
	
	// 전체자료읽기
	public List<Sangpum> getDataAll(){
		List<Sangpum> list = repository.findAll(); //기본메소드
		return list;
	}
	// 검색자료읽기
	public List<Sangpum> getDataSearch(String svalue){
		//List<Sangpum> list = repository.findBySangContaining(svalue);
		
		List<Sangpum> list = repository.searchLike(svalue);//jpql사용
		System.out.println("list: "+list.size());
		return list;
	}
}
