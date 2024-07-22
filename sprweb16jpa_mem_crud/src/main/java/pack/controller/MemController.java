package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import pack.model.DataProcess;
import pack.model.Mem;

@Controller
public class MemController {
	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("/")
	public String main() {
		return "chulbal";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		ArrayList<Mem> slist = (ArrayList<Mem>)dataProcess.getDataAll();
		model.addAttribute("datas", slist);
		return "list";
	}
	
	@GetMapping("insert")
	public String insert() {
		return "insert";
	}
	
	@PostMapping("insert")
	public String insertProcess(MemBean bean, Model model) {
		String msg = dataProcess.insert(bean);
		
		if(msg.equals("success"))
			return "redirect:/list"; //추가 후 목록보기
			
		else {
			model.addAttribute("msg", msg);// msg 담아옴. 중복해서실패했다는등의..
			return "error"; //중복혹은실패한경우, 에러메시지던지기.
		}
	}
	
	@GetMapping("update")
	public String update(@RequestParam("num") String num, Model model) {
		//System.out.println("num: " + num); //넘어온거확인완료
		
		Mem mem = dataProcess.getData(num);//수정할 자료 읽어오자
		model.addAttribute("data", mem); // 읽어온자료 넣어주자
		return "update";
	}
	
	@PostMapping("update")
	public String updateProcess(MemBean bean, Model model) {
		String msg = dataProcess.update(bean);
		
		if(msg.equals("success"))
			return "redirect:/list"; //추가 후 목록보기
			
		else {
			model.addAttribute("msg", msg);// msg 담아옴. 중복해서실패했다는등의..
			return "error"; //중복혹은실패한경우, 에러메시지던지기.
		}
	}
	
	@GetMapping("delete")
	public String deleteProcess(@RequestParam("num") int num, Model model) {
		String msg = dataProcess.delete(num);
		
		if(msg.equals("success"))
			return "redirect:/list"; //추가 후 목록보기
			
		else {
			model.addAttribute("msg", msg);// msg 담아옴. 중복해서실패했다는등의..
			return "error"; //중복혹은실패한경우, 에러메시지던지기.
		}
	}
	
	
}
