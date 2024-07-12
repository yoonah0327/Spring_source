package pack.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TestController {
	@GetMapping("thymeleaf")
	public String sijak(Model model) {
		model.addAttribute("msg", "타임리프 만세🤩");
		model.addAttribute("msg2", "영국이냐 스페인이냐🐥");
		
		// DTO 자료 출력용
		Sangpum sangpum = new Sangpum();
		sangpum.setCode("10");
		sangpum.setSang("삼다수3L");
		sangpum.setPrice("3500");
		model.addAttribute("sangpum", sangpum); //객체-------
		
		ArrayList<Sangpum> list = new ArrayList<Sangpum>();
		list.add(sangpum);
		
		sangpum = new Sangpum();
		sangpum.setCode("20");
		sangpum.setSang("고구마빵");
		sangpum.setPrice("2000");
		list.add(sangpum);
		
		model.addAttribute("list", list); // 컬렉션----------
		
		return "list1"; //포워딩. templates 로 감. 확장자 html. 
	}
}
