package pack.business;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.DataInterface;
import pack.model.JikDto;

@Service
public class BusinessImpl implements BusinessInter {
	@Autowired
	private DataInterface dataInterface;

	@Override
	public void dataPrint() {
		List<JikDto> jlist = dataInterface.selectDataAll();
		
		for (JikDto j : jlist) {
			// 입사일에서 년도만 출력하고싶을경우 
			String year= j.getJikwon_ibsail().substring(0, 4);
			
			System.out.println(
					j.getJikwon_no() + " " + j.getJikwon_name() + " " + j.getBuser_num() + " " + year);
		}

		List<Object[]> result = dataInterface.selectcntBuser();
		
//		for(int i=0; i<result.size(); i++) {
//			String buserNum = (String)result.get(i)[0];
//			Long cntJikwon = (Long)result.get(i)[1];
//			System.out.println(buserNum+ ": "+ cntJikwon);
//			
//		}
		
		for(Object[] obj: result) {
			String buserNum = (String)obj[0];
			Long cntJikwon = (Long)obj[1];
			System.out.println(buserNum+ ": "+ cntJikwon);
		}

	}
}
