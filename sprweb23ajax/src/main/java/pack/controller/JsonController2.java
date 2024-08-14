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
		//데이터 리스트 생성:
		List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		//List<Map<String, String>> 형태의 리스트를 생성합니다. 각 Map은 하나의 데이터 항목을 나타냅니다 (예: 이름과 나이).

		//데이터 항목 추가:
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
		//각각의 Map 객체를 생성하고, "name"과 "age" 값을 추가한 후 dataList에 추가합니다.
		//이 작업을 반복하여 여러 개의 데이터 항목을 리스트에 추가합니다.
		
		//return data;
		//System.out.println("data: "+ data);//data: {name=황길동, age=44}
		
		//데이터 래핑 및 반환:
		Map<String, Object> data2 = new HashMap<String, Object>();
		data2.put("datas", dataList);
		System.out.println("dataList: "+dataList);
		//dataList: [{name=홍길동, age=33}, {name=고길동, age=22}, {name=황길동, age=44}]
		// @responsebody에 의해 웹상에서는 json형태로 아래처럼 출력
		//{"datas":[{"name":"홍길동","age":"33"},{"name":"고길동","age":"22"},{"name":"황길동","age":"44"}]}
		return data2;
		//data2라는 Map을 생성하고, 키 "datas"에 dataList를 추가합니다.
		//이 data2를 반환하면, 전체 데이터 리스트가 "datas"라는 키 아래 포함된 JSON 형식으로 클라이언트에게 전달됩니다.
		//결국, data2를 사용하여 dataList 전체를 포함하는 방식으로 데이터를 구조화하고 반환하는 것이 필요합니다. 이 구조화된 데이터가 JSON 형식으로 클라이언트에게 전달됩니다.
	}
}
