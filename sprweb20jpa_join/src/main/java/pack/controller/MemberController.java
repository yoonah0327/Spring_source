package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.dto.MemberDto;
import pack.service.MemberServiceInter;

@Controller
public class MemberController {
	@Autowired
	private MemberServiceInter mservice;
	
	@GetMapping("/member/mlist")
	public String memlist(Model model) {
		mservice.getList(model); //getlist()는 void인데 이렇게 받을수있나? 
		//model.addattribute(키, 키벨류); 이거없이도 mlist에 담겨 넘어간다.
		//getlist 내부에서 model.addattribute를 통해 데이터를 모델에 추가하고잇기 때문
		return "member/mlist";
	}
	
	//추가
	@GetMapping("/member/insertform")
	public String insertform() {
		return "member/insertform";
	}	
	
	@PostMapping("/member/insert")
	public String insert(MemberDto fbean) { //리퀘스트파람으로 넘어가서 
		mservice.insert(fbean);
		
		return "member/insert";
	}
	
	//수정
	@GetMapping("/member/updateform")
	public String updateform(@RequestParam("num") Long num, Model model) {
		mservice.getData(num, model);

		return "member/updateform";
	}
	@PostMapping("/member/update")
	public String update(MemberDto fbean) { //리퀘스트파람으로 넘어가서 
		//mservice.update(fbean); //단순수정
		mservice.update2(fbean); //1차캐시재활용
		return "member/update";
	}
	
	//삭제
	@GetMapping("/member/delete")
	public String delete(@RequestParam("num") Long num) {
		mservice.delete(num);

		return "redirect:/member/mlist";
	}
	
}
