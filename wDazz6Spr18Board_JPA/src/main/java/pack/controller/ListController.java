package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.BoardDao;

@Controller
public class ListController {

	@Autowired
	private BoardDao dao;
	
	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("list", dao.list());
		return "list";
	}
	
	@PostMapping("search")
	public String search(BoardBean bean, Model model) {
		model.addAttribute("list", dao.search(bean));
		return "list";
	}
}
