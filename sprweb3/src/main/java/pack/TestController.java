package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

// PLEASE understand and CONFIRM the annotations.   

/*
@RestController
//controller+responsebody
public class TestController {
	@RequestMapping("test1")
	public String abc() { //test1 요청이 들어오면 abc를 수행해. 디스패처 서블릿이 핸들러매핑에게 시킴.
		return " 요청에 대한 반응 보이기 ";
	}
}
*/
@Controller
//사용자의 요청을 받아 처리한 후  지정된 뷰(템플릿 엔진:jsp..)에 모델객체를 넘겨주는 역할
public class TestController {
	@RequestMapping("test1") // get, post 모두 처리.
	public ModelAndView abc() { // test1 요청이 들어오면 abc를 수행해. 디스패처 서블릿이 핸들러매핑에게 시킴.
		//디스패처 서블릿으로부터 위임받은 핸들러 매핑이 @RequestMapping을 찾아감.
		
//		System.out.println("abc 처리");
//		return null;
		// return new ModelAndView("list", "msg", "hihi jsp");
		// 모델엔뷰를 반환. "list" : 뷰파일명.
		// 결과는 ${msg} > 여기서 그부분을 지칭
		// "hihi jsp": msg에 넣을 내용.

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list");
		modelAndView.addObject("msg", "gogogo jsp");
		// request.setAttribute("msg", "gogogo jsp");와 동일.
		// HttpSErvletRequest를 사용해 키, 값으로 jsp에 전송하는방식이라고 이해하면됨.
		return modelAndView;
	}
	
	@RequestMapping(value = "test2", method = RequestMethod.GET) // get만 처리. 
	public ModelAndView abc2() {
		return new ModelAndView("list", "msg", "success2");
	}
	
	@GetMapping("test3") // get 요청 처리
	public ModelAndView abc3() { 
		return new ModelAndView("list", "msg", "success3");
	}
	
	@GetMapping("test4") // get 요청 처리
	public String abc4(Model model) { 
		model.addAttribute("msg", "success4");
		return "list";
	}
	// 3번과 동일. "list"는 문자열 list를 반환하는게아니라, 뷰파일 "list.jsp"를 반환하는것. 
	
	@RequestMapping(value = "test5", method = RequestMethod.POST) // post만 처리. 
	public ModelAndView abc5() {
		return new ModelAndView("list", "msg", "success5");
	}
	
	@PostMapping("test6") // post 요청 처리
	public ModelAndView abc6(Model model) { 
		return new ModelAndView("list", "msg", "success6");
	}
	
	@PostMapping("test7") // post 요청 처리
	public String abc7(Model model) { 
		model.addAttribute("msg", "success7");
		return "list";
	}
	// 6번과 동일
	
	@GetMapping("test8")
	@ResponseBody
	public String abc8() { 
		String value = "일반데이터-String, Map, JSON 등을 전달가능";
		return value; // @ResponseBody: 문자열그대로 반환.
	}
	
	@GetMapping("test8_1")
	@ResponseBody
	public DataDto abc8_1() { 
		DataDto dto = new DataDto();
		dto.setCode(10);
		dto.setName("미스터톰");
		return dto; //@ResponseBody역할: JSON 형태로 반환(jackson라이브러리가 지원)
	}

	
	
}
