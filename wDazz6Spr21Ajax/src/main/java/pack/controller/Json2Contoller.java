package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Json2Contoller {

	@GetMapping("list2")
	@ResponseBody
	public Map<String, Object> getJsons() {
		// 복수일 때는 Map 사용
		List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", "이름1");
		data.put("age", "23");
		dataList.add(data);

		data = new HashMap<String, String>();
		data.put("name", "이름2");
		data.put("age", "26");
		dataList.add(data);
		
		data = new HashMap<String, String>();
		data.put("name", "이름3");
		data.put("age", "25");
		dataList.add(data);
		
//		return data;
		System.out.println("data : " + data);
//		data : {name=이름3, age=25}

		Map<String, Object> data2 = new HashMap<String, Object>();
		data2.put("datas", dataList);
		System.out.println("dataList : " + dataList);
//		dataList : [{name=이름1, age=23}, {name=이름2, age=26}, {name=이름3, age=25}]
		
		
		return data2;
	}
}
