package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.BoardDao;

@Controller
public class DeleteController {

	@Autowired
	private BoardDao dao;
	
	@GetMapping("delete")
	public String delete(@RequestParam("num") int num, Model model) {
		String msg = dao.deleteData(num);
		model.addAttribute("msg", msg);
		return msg.equals("success") ? "redirect:/list" : "error";
	}
}
