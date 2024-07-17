package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataController {
	
	@GetMapping("/")
	public String start() {
		return "start";
	}
}
