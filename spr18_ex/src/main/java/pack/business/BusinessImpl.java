package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonDto;
import pack.model.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter {
	// model 클래스를 호출

	@Autowired
	private JikwonInter inter;

	@Override
	public void dataPrint1() {
		System.out.println("---직원자료---");
		System.out.println("사번 이름 부서명 입사년");
		List<JikwonDto> list = inter.selectDataAll();

		// console로 출력
		for (JikwonDto a : list) {
			System.out.println(a.getJikwon_no() + " " + a.getJikwon_name() + " " + 
					a.getBuser_name() + " " + a.getJikwon_ibsail());
			// sql문에 별명을 붙이면, 별명대로 불러줘야한다. 
		}

	}

	@Override
	public void dataPrint2() {
		System.out.println("\n---부서별 인원수---");
		List<JikwonDto> list = inter.selectDataBuser();

		// console로 출력
		for (JikwonDto b : list) {
			System.out.println(b.getBuser_name() + " "+ b.getCc()); //count 부분 어떻게 ? A: 별명을 붙여 별명으로 
		}

	}

	@Override
	public void dataPrint3() {
		System.out.println("\n---부서별 최대 급여자---");
		List<JikwonDto> list = inter.selectDataBuserMax();

		// console로 출력
		for (JikwonDto c : list) {
			System.out.println(c.getBuser_name() + ": " + c.getJikwon_name()+ "("+ c.getJikwon_pay()+")"); 
		}

	}

}
