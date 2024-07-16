package pack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;
import pack.model.DataDto;

@Controller
public class ListController {
	
	
	@Autowired
	private DataDao dao;
	
	@PostMapping("test1")
	public String listProcess(@RequestParam("jik") String jik, Model model) {
		List<DataDto> list = dao.searchJikwon(jik);
		model.addAttribute("list", list); 
		return "show";
	}
}
