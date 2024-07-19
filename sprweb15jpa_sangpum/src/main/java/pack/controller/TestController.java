package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDao;
import pack.model.Sangpum;

@Controller
public class TestController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("testjpa")
	public String list(Model model) {
		ArrayList<Sangpum> slist = (ArrayList<Sangpum>)dataDao.getDataAll();
		model.addAttribute("datas", slist);
		return "list";
	}
	
	
	@GetMapping("search")
	public String searchList(FormBean bean, Model model) {//파라미터로 받을수도, 폼빈으로 받을수도있다.
		ArrayList<Sangpum> slist = (ArrayList<Sangpum>)dataDao.getDataSearch(bean.getSearchValue());
		model.addAttribute("datas", slist);
		return "list";
	}
}
