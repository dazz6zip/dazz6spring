package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.TestDao;


@Controller
public class TestController {
	
	@Autowired
	private TestDao trps;

	@GetMapping("/")
	public String start(Model model) {
		model.addAttribute("list", trps.getAll());
		
		return "index";
	}
	
	@GetMapping("result")
	public String result(@RequestParam("no") String no, Model model) {
		model.addAttribute("result", trps.getGogekData(no));
		return "result";
	}
	
	
}
