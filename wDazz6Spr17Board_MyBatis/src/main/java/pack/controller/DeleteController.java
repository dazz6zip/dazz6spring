package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.model.BoardDao;

@Controller
public class DeleteController {

	@Autowired
	private BoardDao dao;
	
	@GetMapping("delete")
	public String delete(BoardBean bean) {
		return dao.deleteData(bean) ? "redirect:/list" : "error";
	}

}
