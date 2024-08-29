package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	//로그인에 필요한 요청정보를 로그아웃상태에서 요청하면, redirect 되는 요청 경로 
	@GetMapping("/user/required_loginform")
	public String required_loginform() {
		return "user/required_loginform";
	}
	
	//자발적으로 로그인링크를 눌러서 로그인 하는경우
	@GetMapping("/user/loginform")
	public String loginform() {
		return "user/loginform";
	}
	
	//로그인 성공시 forward되는 요청 경로
	@PostMapping("/user/login_success")
	public String login_success() {
		return "user/login_success";
	}
	
	//로그인폼 제출한 경우
	@PostMapping("/user/login_fail")
	public String login_fail() {
		return "user/login_fail";
	}
	
	//권한부족시
	@PostMapping("/user/denied")
	public String denied() {
		return "user/denied";
	}
	
	//role_staff, role_admin만 요청가능
	@PostMapping("/staff/user/list")
	public String userlist() {
		return "user/list";
	}
	
	//role_admin만 요청가능
	@PostMapping("/admin/user/manage")
	public String userManage() {
		return "user/manage";
	}	
	
	//세션허용개수 초과시
	@GetMapping("/user/expired")
	public String userexpired() {
		return "user/expired";
	}
}
