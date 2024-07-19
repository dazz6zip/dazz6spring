package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;

@Controller
public class TestController {
	
	@Autowired
	private DataDao dao;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("test1")
	public String test1(Model model, @RequestParam("jik") String jik) {
		model.addAttribute("list", dao.getJikwonByJik(jik));
		return "show";
	}
}
