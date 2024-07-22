package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pack.model.BoardDao;

@Controller
public class SearchController {
	
	@Autowired
	private BoardDao dao;
	
	@RequestMapping("search")
	public String search(BoardBean bean, Model model) {
		model.addAttribute("list", dao.search(bean));
		return "list";
	}
}
