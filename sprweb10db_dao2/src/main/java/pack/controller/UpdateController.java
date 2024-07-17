package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.MemberDao;
import pack.model.MemberDto;

@Controller
public class UpdateController {
	@Autowired
	private MemberDao memberDao;
	
	@ModelAttribute("command")
    public MemberBean formBack() {
        return new MemberBean();
    }
    // 위에는 메서드가 반환하는 객체를 Model에 command라는 이름으로 추가함.	
	@GetMapping("update")
	public String upform(@RequestParam("id") String id, Model model) {
		MemberDto dto= memberDao.getMember(id);
		model.addAttribute("member", dto);
		
		return "upform"; //포워딩한것. 
	}
	
	@PostMapping("update")
	public String updateProcess(@ModelAttribute("member") MemberBean bean, Model model) {
		memberDao.upData(bean);
		
		return "redirect:/list"; //리다이렉팅한것. // 수정 후 목록보기로 이동

	}

}
