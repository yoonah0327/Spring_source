package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pack.controller.BoardBean;

@Mapper
public interface DataMapInterface {
	//추상메소드명은 mapper.xml의 id명과 일치시킬것
	List<Board> selectList();
	List<Board> selectSearch(BoardBean bean);
	Board selectOne(String num);
	
	int insert(BoardBean bean);
	void updateReadcnt(String num);
	int update(BoardBean bean);
	int delete(String num);
}
