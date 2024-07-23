package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.DataBean;
import pack.model.DataDao;

@Controller
public class TestController {

	@Autowired
	private DataDao dao;
	
	@PostMapping("search")
	public String search(DataBean bean, Model model) {
//		model.addAttribute("buser", bean.getBuserName());
		model.addAttribute("list", dao.search(bean));
		return "result";
	}
	
}
