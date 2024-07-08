package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //비즈니스 로직 클래스
public class LogicImpl implements LogicInter{
	@Autowired
	private ArticleInter articleInter;
	
	public LogicImpl() {
		
	}
// @autowired로 생성자 자동선언. 불요. 주석처리. 
//	public LogicImpl(ArticleInter articleInter) {
//		this.articleInter = articleInter;
//	}
	@Override
	public void selectDataProcess1() {
		System.out.println("selectDataProcess1 수행"); //BL
		articleInter.selectAll(); //모델 클래스 수행 결과
		
	}
	@Override
	public void selectDataProcess2() {
		System.out.println("------------------------------");
		System.out.println("selectDataProcess2 처리"); //BL
		articleInter.selectAll(); //모델 클래스 수행 결과
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("3초 delay");
		
	}

}
