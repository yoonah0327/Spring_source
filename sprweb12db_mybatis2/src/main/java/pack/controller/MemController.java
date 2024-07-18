package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataProcess;
import pack.model.MemDto;

@Controller
public class MemController {
	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("/") //요청명이 포트번호까지만 들어왔을때 출발페이지보여줌. 즉 시작페이지를 출발로 해두는것.
	public String chulbal() {
		return "chulbal";
	}
	
	@GetMapping("list") //리스트보여달라는 요청에 따라, 전체데이터를 보여준다
	public String list(Model model) {//모델이 전에배운 httprequest요청을 수행하는역할을 함. 
		ArrayList<MemDto> list = (ArrayList<MemDto>)dataProcess.getDataAll();//
		model.addAttribute("datas", list);//읽어온 데이터를 모델에 넣어준다 
		return "list";
	}
	
	@GetMapping("insert")
	public String insert() {
		return "insert";
	}
	
	@PostMapping("insert")
	public String insertProcess(MemBean bean) {
		boolean b = dataProcess.insert(bean);
		if(b)
			return "redirect:/list";
		else 
			return "redirect:/error";
	}
	
	@GetMapping("error")
	public String error() {
		return "error";
	}
	
	@GetMapping("update")
	public String update(@RequestParam("num") String num, Model model) {
		MemDto dto = dataProcess.getData(num);
		model.addAttribute("data", dto); //=request.setAttribute
		return "update";
	}
	
	@PostMapping("update")
	public String updateProcess(MemBean bean) {
		boolean b = dataProcess.update(bean);
		if(b)
			return "redirect:/list";
		else 
			return "redirect:/error";
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam("num") String num) {
		boolean b = dataProcess.delete(num);
		if(b)
			return "redirect:/list";
		else 
			return "redirect:/error";
	}
	
}
