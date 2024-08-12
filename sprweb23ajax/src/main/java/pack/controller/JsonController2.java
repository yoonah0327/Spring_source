package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController2 {
	@GetMapping("list2")
	@ResponseBody //json형태로 반환
	public Map<String, Object> getJsons(){
		List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", "홍길동");
		data.put("age", "33");
		dataList.add(data);
		
		data = new HashMap<String, String>();
		data.put("name", "고길동");
		data.put("age", "22");
		dataList.add(data);
		
		data = new HashMap<String, String>();
		data.put("name", "황길동");
		data.put("age", "44");
		dataList.add(data);
		
		//return data;
		System.out.println("data: "+ data);
		
		Map<String, Object> data2 = new HashMap<String, Object>();
		data2.put("datas", dataList);
		System.out.println("dataList: "+dataList);
		// 콘솔창에는 dataList: [{name=홍길동, age=33}, {name=고길동, age=22}, {name=황길동, age=44}]
		// @responsebody에 의해 웹상에서는 json형태로 아래처럼 출력
		//{"datas":[{"name":"홍길동","age":"33"},{"name":"고길동","age":"22"},{"name":"황길동","age":"44"}]}
		return data2;
		
		
		
	}
}
