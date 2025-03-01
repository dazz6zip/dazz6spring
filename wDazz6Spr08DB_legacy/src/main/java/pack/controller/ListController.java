package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDao;
import pack.model.DataDto;

@Controller
public class ListController {
	
	@Autowired
	private DataDao dao;
	
	@GetMapping("testdb")
	public String listProcess(Model model) {
		ArrayList<DataDto> list = dao.selectAll();
		model.addAttribute("datas", list);
		return "list";
	}
}
