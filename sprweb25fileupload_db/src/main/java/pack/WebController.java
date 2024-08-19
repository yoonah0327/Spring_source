package pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {
	
	@GetMapping("/")
	public String showStartPage() {
		return "start";	
	}
	
	@Autowired
	private FriendService friendService;
	
	@GetMapping("/list") //그래서 자료보기가 막히고, 로그인 페이지가 뜨게 된다.
	public String showList(Model model) {
		List<Friend> friends = friendService.findAll();
		model.addAttribute("friends", friends);
		return "list";
	}
	
	@GetMapping("/login") //그래
	public String showLoginPage() {
		return "login";
	}
	
}
