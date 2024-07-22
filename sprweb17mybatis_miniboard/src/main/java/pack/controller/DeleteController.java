package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.model.BoardDao;

@Controller
public class DeleteController {
	@Autowired
	private BoardDao dao;
	
	@RequestMapping(value="delete", method = RequestMethod.GET) 
	public String deletesubmit(BoardBean bean) {
		boolean b = dao.deleteData(bean);
		System.out.println();
		if(b) {
			return "redirect:/list";
		}else {
			return "err";
		}
		
	}
}
