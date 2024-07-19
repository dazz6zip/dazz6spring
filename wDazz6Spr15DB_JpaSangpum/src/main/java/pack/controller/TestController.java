package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDao;

@Controller
public class TestController {
	
	@Autowired
	private DataDao dao;
	
	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("testjpa")
	public String testjpaGet(Model model) {
		model.addAttribute("datas", dao.getDataAll());
		return "list";
	}
	
	@GetMapping("search")
	public String searchGet(FormBean bean, Model model) {
		model.addAttribute("datas", dao.getDataSearch(bean.getSearchValue()));
		return "list";
	}
}
