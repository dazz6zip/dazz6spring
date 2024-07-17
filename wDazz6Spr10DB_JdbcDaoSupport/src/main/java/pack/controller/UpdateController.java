package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.MemberDao;

@Controller
public class UpdateController {

	@Autowired
	private MemberDao dao;
	
	@GetMapping("update")
	public String updateInfo1(@RequestParam("id") String id, Model model) {
		model.addAttribute("member", dao.getMember(id));
		return "detailUpdate";
	}
	
	@PostMapping("update")
	public String updateInfo2(MemberBean bean) {
		dao.upData(bean);
		return "redirect:/list";
	}
}
