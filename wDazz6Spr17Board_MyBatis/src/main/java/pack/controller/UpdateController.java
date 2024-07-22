package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.model.BoardDao;

@Controller
public class UpdateController {

	@Autowired
	private BoardDao dao;
	
	@PostMapping("update")
	public String update(BoardBean bean) {
		return dao.insertData(bean) ? "redirect:/list" : "error";
	}

}
