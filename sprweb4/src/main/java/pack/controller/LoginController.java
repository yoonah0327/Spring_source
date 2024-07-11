package pack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	//로그 정보 출력용 클래스 
	private final Logger logger = LoggerFactory.getLogger(this.getClass()); //현재클래스
	
	@GetMapping("login") 
	public String submitCall() {
		//return "login.html"; //forward : 기본값
		return "redirect:login.html"; //redirect 명시적 적어줌
		//redirect:http://localhost/login.html 이게 풀네임
		
	}
	//클라이언트가 전달한 값 수신방법1: 전통적 
	/*
	@PostMapping("login")
	public String submit(HttpServletRequest request, Model model) { 
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id + " " + pwd);
		logger.info(id + " "+ pwd);//로그레벨 trace > debug> info > warn> error> fatal 
		
		
		String data = "";
		if(id.equals("sea") && pwd.equals("111"))
			data = "로그인 성공";
		else
			data = "로그인 실패";
		model.addAttribute("data", data);
		return "result"; //views폴더에있는 result 파일을 부르는것. 포워드.
	}
	*/
	//클라이언트가 전달한 값 수신방법2: Spring 어노테이션 사용
	@PostMapping("login")
	public String submit(@RequestParam(value="id")String id, 
			//@RequestParam(value="pwd")String pwd, 
			//@RequestParam(value="pwd")int pwd, 
			@RequestParam(value="pwd", defaultValue="111")int pwd, //초기치주기. 값입력안하면 초기치로 값이 자동전달된다.
			Model model) { 
		
		String data = "";
		if(id.equals("sea") && pwd == 111)
			// pwd == 111. 앞에 폼에서도 텍스트타입에 number라고 했더라도 기본적으로 String으로 넘어온다.
			//@리퀘스트파람에서 int 라고 적어주면 자동형변환이 되어서 해결된다. 
			data = "로그인 성공";
		else
			data = "로그인 실패";
		model.addAttribute("data", data);
		return "result"; 
	}
}
