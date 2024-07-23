package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.Jikwon;
import pack.model.JikwonDao;

@Controller
public class TestController {

	@Autowired
	private JikwonDao jikwonDao;
	
	@GetMapping("test")
	public String test(Model model,
						@RequestParam("buserNum") int buserNum,
						@RequestParam("rating") String rating) {
		List<Jikwon> jikwonList = jikwonDao.list(buserNum, rating);
		model.addAttribute("list", jikwonList);
		
		// 연봉 평균 구하기
		double avgPay = 0;
		for(Jikwon j : jikwonList) {
			avgPay += j.getPay();
		}
		avgPay = Math.round((avgPay / jikwonList.size())*100) / 100.0; // 소수점 이하 세번째에서 반올림
		model.addAttribute("avg", avgPay);
		
		return "list";
	}
	
}
