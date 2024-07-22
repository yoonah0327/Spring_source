package pack.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
	
	@GetMapping("form")
	public String formprocess(@RequestParam("name") String name, @RequestParam("age") String age, Model model) {
		model.addAttribute("name", "name");
		int dae = (Integer.parseInt(age)) /10 *10;
		model.addAttribute("dae", dae);
		return "result";
	}

}
