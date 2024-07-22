package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.model.BoardDao;

@Controller
public class InsertController {

	@Autowired
	private BoardDao dao;
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert() {
		return "insform";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertSubmit(BoardBean bean) {
		return dao.insertData(bean) ? "redirect:/list" : "error";
	}

}
