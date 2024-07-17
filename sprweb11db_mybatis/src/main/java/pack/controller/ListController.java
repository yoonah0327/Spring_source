package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDao;
import pack.model.SangpumDto;

@Controller
public class ListController {
	@Autowired
	private DataDao dataDao; //모델영역과 통신
	
	@GetMapping("mybatis")
	public String listProcess(Model model) {
		ArrayList<SangpumDto> list = (ArrayList<SangpumDto>)dataDao.getDataAll();
		model.addAttribute("datas", list);
		return "list";
	}
	
	@GetMapping("search")
	public String searchProcess(FormBean bean, Model model) {
		ArrayList<SangpumDto> list = (ArrayList<SangpumDto>)dataDao.getDataSearch(bean);
		model.addAttribute("datas", list);
		return "list";
	}
}
