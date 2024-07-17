package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.MemberDao;

@Controller
public class DeleteController {

	@Autowired
	private MemberDao dao;
	
	@GetMapping("delete")
	public String deleteInfo(@RequestParam("id") String id) {
		dao.delData(id);
		return "redirect:/list";
	}
}
