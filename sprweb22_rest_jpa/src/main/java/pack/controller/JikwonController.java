package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pack.dto.JikwonDto;
import pack.repository.JikwonRepository;

@CrossOrigin("*")
@RestController
//@RequestMapping("/jikwons")
public class JikwonController {
	@Autowired
	private JikwonRepository jikwonRepository;

	@GetMapping("/{jik}")
	public List<JikwonDto> getList(@PathVariable("jik") String jik) {
		// entity to dto
		List<JikwonDto> jlist = jikwonRepository.findByJik(jik).stream().map(JikwonDto::toDto).toList();

		return jlist;

	}

}
