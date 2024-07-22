package pack.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pack.model.BoardDao;

@Controller
public class ListController {

	@Autowired
	private BoardDao dao;
	
	@RequestMapping("list")
	public String list(Model model) {
		model.addAttribute("list", dao.list());
		return "list";
	}
}
