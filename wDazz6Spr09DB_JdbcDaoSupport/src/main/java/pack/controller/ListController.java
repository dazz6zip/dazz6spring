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
	
	@GetMapping("testdao")
	public String listProcess(Model model) {
		ArrayList<DataDto> list = (ArrayList<DataDto>)dao.getDataAll();
		model.addAttribute("datas", list);
		return "list";
	}
}
