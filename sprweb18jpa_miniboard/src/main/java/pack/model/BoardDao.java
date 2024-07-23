package pack.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pack.controller.BoardBean;

@Repository
public class BoardDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DataRepository dataRepository;

	public List<Board> list(){ //전체자료읽기
		List<Board> list = dataRepository.findAll();
		logger.info("list.size: "+list.size());
		
		return list;
	}
	public List<Board> search(BoardBean bean){ //검색자료읽기
		List<Board> slist = null;

		if(bean.getSearchName().equals("author")) {// 작성자 검색 
			slist= dataRepository.searchLike(bean.getSearchValue());
		}else { //아니면 작성제목검색
			slist= dataRepository.searchLike2(bean.getSearchValue());  
		}
		
		return slist;
	}
	
	@Transactional  //프록시 객체는 해당메소드가 처리될때 commit or rollback 수행
	// CheckdException 또는 예외가 없는 경우 commit 수행
	// UncheckedException가 발생하면 Rollback
	public String insertData(BoardBean bean) {
		try {
			//새글 입력시 가장 큰번호 얻어 +1
			int max = dataRepository.maxNum();
			
			Board dto = new Board();
			dto.setNum(max+1);
			dto.setAuthor(bean.getAuthor());
			dto.setTitle(bean.getTitle());
			dto.setContent(bean.getContent());
			dto.setBwrite(Timestamp.valueOf(LocalDateTime.now()));
			dto.setReadcnt(0);
			
			dataRepository.save(dto);
			
			return "success";
		} catch (Exception e) {
			return "입력 오류: " + e.getMessage();
		}
	
	}
	@Transactional
	public Board detail(int num) {
		//조회수 증가
		dataRepository.updateReadcnt(num);
		
		// Optional<T> 클래스를 사용해 NPE를 방지할 수 있도록 도와준다.
		//Repository에서 findById()의 반환값은 Optional 타입
		Optional<Board> board = dataRepository.findById(num); //null일수도있을것. 
		logger.info("board :: {}", board.get());
		
		if(board.isPresent()) {
			return board.get();// board이면 안됨. optional해놧기 때문(?)에 board.get()으로 값을 뽑아야한다.
		} else {
			return new Board();
		}
		
	}
	
	@Transactional
	public String updateData(BoardBean bean) {
		try {
			//조회수조작을 원한다면...ㅋ
			Optional<Board> board = dataRepository.findById(bean.getNum()); 
			Board imsi = board.get();
			/*
			Board dto = new Board();
			dto.setNum(bean.getNum()); //이미 등록된 num이므로 수정
			dto.setAuthor(bean.getAuthor());
			dto.setTitle(bean.getTitle());
			dto.setContent(bean.getContent());
			dto.setBwrite(Timestamp.valueOf(LocalDateTime.now()));
			dto.setReadcnt(imsi.getReadcnt());
			
			dataRepository.save(dto);
			*/
			//save 안 쓰는 방법.
			imsi.setAuthor(bean.getAuthor());
			imsi.setTitle(bean.getTitle());
			imsi.setContent(bean.getContent());
			
			// 
			//imsi.setBwrite(Timestamp.valueOf(LocalDateTime.now())); 이걸 쓰면 수정시간으로 리셋됨.
			
			return "success";
		} catch (Exception e) {
			return "수정 오류: " + e.getMessage();
		}
	}
	
	@Transactional
	public String deleteData(int num) {
		try {
			dataRepository.deleteById(num);
			
			return "success";
		} catch (Exception e) {
			return "삭제 오류: " + e.getMessage();
		}
	}
	
	
	
}
