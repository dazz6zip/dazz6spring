package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {
	
	@Autowired
	private MyModel mm;
	
	@GetMapping("list")
	@ResponseBody
	public MyModel getJson(@RequestParam("name") String name) {
		mm.setName(name);
		mm.setSkills(new String[] {"JAVA", "DB"});
		return mm;
	}
	
	
	
}
