package pack;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BusinessImpl implements BusinessInter {
	//모델클래스를 사용
	@Autowired//상품인터에 파생클라스 1개이기에 ok. 여러개라면 @qualifier로 구체적으로 지정요. 
	//@Qualifier("sangpumImpl")
	private SangpumInter inter;
	
	
	@Override
	public void selectProcess() {
		ArrayList<SangpumDto> myList = inter.selectAll();
		
		for(SangpumDto s:myList) {
			System.out.println(s.getCode() + " "+s.getSang() + " "+
					s.getSu() + " "+s.getDan());
		}

	}
}
