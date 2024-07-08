package pack;

import org.springframework.stereotype.Repository;

@Repository //db와 연결해서 작업하는 클래스. 선언! (아직 생성은 안된 )
public class ArticleDao implements ArticleInter {
	@Override
	public void selectAll() {
		System.out.println("테이블 자료 읽기");

	}
}
