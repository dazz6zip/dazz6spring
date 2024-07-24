package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.dto.MemberDto;
import pack.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService msv;

	@GetMapping("/member/mlist")
	public String memberMlistGet(Model model) {
		
		msv.getList(model);
		// getList에서 model을 return해 주지 않아도 됨
		
		return "member/mlist";
	}
	
	@GetMapping("/member/insertform")
	public String memberInsertformGet() {
		return "member/insertform";
	}
	
	@PostMapping("/member/insert")
	public String memberInsertformPost(MemberDto dto) {
		msv.insert(dto);
		return "member/insert";
	}
	
	@GetMapping("/member/updateform")
	public String memberUpdateformGet(@RequestParam("num") Long num, Model model) {
		msv.getData(num, model);
		return "member/updateform";
	}
	
	@PostMapping("/member/update")
	public String memberUpdatePost(MemberDto dto) {
		msv.update1(dto);
		return "member/update";
	}
	
	@GetMapping("/member/delete")
	public String memberDeleteGet(@RequestParam("num") Long num) {
		msv.delete(num);
		return "redirect:/member/mlist";
	}
}
