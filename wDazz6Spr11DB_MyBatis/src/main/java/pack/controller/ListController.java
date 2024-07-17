package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDao;

@Controller
public class ListController {
	
	@Autowired
	private DataDao dao;
	
	@GetMapping("mybatis")
	public String listProcess(Model model) {
		model.addAttribute("datas", dao.getDataAll());
		return "list";
	}
	
	@GetMapping("search")
	public String searchProcess(Model model, FormBean bean) {
		model.addAttribute("datas", dao.getDataSearch(bean));
		return "list";
	}
}
