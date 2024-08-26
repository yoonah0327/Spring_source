package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pack.JwtService;

@Controller
@RequestMapping("/auth")
public class Mycontroller {
	@Autowired
	private JwtService jwtService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam(name = "userid") String userid, 
//			, HttpSession session  // 세션 사용 시, 활성화
						@RequestParam(name = "password") String password,
							HttpServletResponse response) {
		String validId = "ok";
		String validPassword = "123";

		if (userid.equals(validId) && password.equals(validPassword)) {
//			session.setAttribute("user", userid);

			String token = jwtService.createToken(userid);
			Cookie cookie = new Cookie("jwt", token); //JWT 토큰을 클라이언트에 저장
			cookie.setHttpOnly(true); //클라이언트에서 쿠키 수정 불가
			cookie.setPath("/"); //쿠키경로
			response.addCookie(cookie);
			
			return "redirect:/auth/success";
		} else {
			return "redirect:/auth/login?error";
		}
	}

	@GetMapping("/success")
	public String success(HttpServletRequest request, Model model) {
		String userid = getUserFromToken(request);

		if (userid == null) {
			return "redirect:/auth/login";
		} 
		
		model.addAttribute("myuser", userid);
		return "success";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletResponse response) {
		Cookie cookie = new Cookie("jwt", null); //JWT 토큰을 무효화
		cookie.setMaxAge(0);
		cookie.setPath("/"); //쿠키경로
		response.addCookie(cookie);
		
		return "redirect:/auth/login";
	}

	@GetMapping("/gugu")
	public String gugu(HttpServletRequest request) {
		String userid = getUserFromToken(request);

		if (userid == null) {
			return "redirect:/auth/login";
		} 
		
		return "gugu";
	}
	
	@PostMapping("/gugu")
	public String gugu(@RequestParam(name="num") int num, HttpServletRequest request, Model model) {
		String userid = getUserFromToken(request);
		
		if (userid == null) {
			return "redirect:/auth/login";
		} 
		model.addAttribute("num", num);
		return "guguresult";
	}
	
	//요청에서 JWT 토큰을 추출하고 사용자 id 반환하기
	private String getUserFromToken(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("jwt")) { //쿠키 키가 "jwt"인 녀석 찾기
					String token = cookie.getValue();
					return jwtService.getUserFromToken(token);
				}
			}
		}
		return null;
	}
}
