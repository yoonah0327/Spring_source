package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.MemBean;

@Repository
public class DataProcess {
	private Logger logger = LoggerFactory.getLogger(this.getClass());//?
	
	@Autowired
	private DataMapperInterface dataMapperInterface; //hikari pool이 자동지원
	
	//전체자료읽기
	public List<MemDto> getDataAll(){
		List<MemDto> list = dataMapperInterface.selectAll();
		logger.info("전체자료 크기: "+ list.size());//syso대신
		return list;
	}
	
	//부분자료읽기
	public MemDto getData(String num) {
		MemDto dto = dataMapperInterface.selectPart(num);
		return dto;
	}
	
	//추가하기 추가시 0아니면1
	public boolean insert(MemBean bean) {
		//번호중복방지, 번호자동증가 는 추가작업.
		int re = dataMapperInterface.insertData(bean);
		if(re >0)//즉 =1이면 성공. 아니면 false
			return true;
		else 
			return false;	
	}
	
	//수정하기 
	public boolean update(MemBean bean) {
		//번호중복방지, 번호자동증가 는 추가작업.
		int re = dataMapperInterface.updateData(bean);
		if(re >0)//즉 =1이면 성공. 아니면 false. 
			return true;
		else 
			return false;	
	}
		
	//삭제하기
	public boolean delete(String num) {
		//번호중복방지, 번호자동증가 는 추가작업.
		int re = dataMapperInterface.deleteData(num);
		if(re >0)//즉 =1이면 성공. 아니면 false
			return true;
		else 
			return false;	
	}
	
}
