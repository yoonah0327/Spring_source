package pack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pack.dto.MemberDto;
import pack.repository.MemberDao;

//@Controller
//@ResponseBody
@RestController //@Controller + @ResponseBody //restful프로그램. 비동기처리 ajax처리.
//비동기처리에서 사용. 객체데이터를 json형태로 변환하여 반환하는 역할 
public class MemberController {
	@Autowired
	private MemberDao dao;

	/* 일반적인 get post방식으로 받아, spring이 처리
//	@GetMapping("/members")
//	public String list(Model model) {
//		List<MemberDto> list = dao.getList();
//		model.addAttribute("list", list);
//		return "list";
//	}
	
	@GetMapping("/members") // +@ResponseBody. 
	public MemberDto list(Model model) {
		//return "나이스"; //문자열그대로 클라이언트에게 리턴.  //전수업참고하자.
		
		MemberDto dto = new MemberDto();
		dto.setNum(1);
		dto.setName("주먹밥");
		dto.setAddr("강남구 역삼동");
		return dto; //{"num":1,"name":"주먹밥","addr":"강남구 역삼동"} //자바객체를 json형태로 클라이언트에게 던져준다.
	}
	
	@GetMapping("/insertform")
	public String insertfrom(Model model) {
		List<MemberDto> list = dao.getList();
		model.addAttribute("list", list);
		return "insertform";
	}
	
	@PostMapping("/insert")
	public String insert(@RequestParam("name") String name, @RequestParam("addr") String addr) {
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		dao.insert(dto);
		return "redirect:/members";
	}
	*/
	
	//REST 요청처리-----------------------------------------------------
	@GetMapping("/members") //전체자료읽기
	public List<MemberDto> getList(){
		//html파일로 반환하는게 아님! db자료를 읽어 json형태로 변환해 클라이언트(Javascript Ajax요청)
		System.out.println("❄️get요청했네❄️");
		return dao.getList();// 자료를 읽어 그대로 리턴.
	}
	
	@PostMapping("/members") //자료추가하기
	public Map<String, Object> insert(@RequestBody MemberDto dto){
		//@RequestBody: 요청본문에 담긴 값(json타입)을 자바객체로 변환
		dao.insert(dto);
		//넣는작업은 끝남. 성공실패여부 확인해보고자 하단 작업 실시.
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isSuccess", true);
		return map;
		//상단의 3줄과 return Map.of("isSuccess", true); 동일
	}
	
	@GetMapping("/members/{num}") //자료1개읽기 //http://localhost:80/members/3
	//받을 내용만 {}이렇게 중괄호로 표시해준다. 그 안의 이름은 맘대로 설정가.
	public MemberDto getData(@PathVariable("num") int num){
		
		return dao.getData(num);
	}
	
	@PutMapping("/members/{num}") //자료수정하기
	public Map<String, Object> update(@PathVariable("num") int num, @RequestBody MemberDto dto){
		dto.setNum(num);
		dao.update(dto);
		
		return Map.of("isSuccess", true);
	}
	
	@DeleteMapping("/members/{num}")
	public Map<String, Object> delete(@PathVariable("num") int num){
		dao.delete(num);
		return Map.of("isSuccess", true);

	}
	
}
