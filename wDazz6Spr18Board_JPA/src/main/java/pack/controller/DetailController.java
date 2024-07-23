package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.BoardDao;

@Controller
public class DetailController {

	@Autowired
	private BoardDao dao;
	
	@GetMapping("detail")
	public String detail(@RequestParam("num") int num, Model model) {
		model.addAttribute("board", dao.detail(num));
		return "detail";
	}
	
	
}
