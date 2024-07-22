package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataProcess;

@Controller
public class DataController {
	
	@Autowired
	private DataProcess dao;
	
	@GetMapping("/")
	public String main() {
		return "start";
	}
	
	@GetMapping("list")
	public String testjpaGet(Model model) {
		model.addAttribute("datas", dao.getDataAll());
		return "list";
	}
	
	@GetMapping("insert")
	public String insert1() {
		return "insert";
	}
	
	@PostMapping("insert")
	public String insert2(DataBean bean, Model model) {
		
		String msg = dao.insert(bean);
		
		if (msg.equals("success")) {
			return "redirect:/list";
		} else {
			model.addAttribute("msg", msg);
			return "error";
		}
	}
	
	@GetMapping("update")
	public String update1(@RequestParam("num") String num, Model model) {
		model.addAttribute("data", dao.getData(num));
		return "update";
	}
	
	@PostMapping("update")
	public String update2(DataBean bean, Model model) {
		String msg = dao.update(bean);
		if (msg.equals("success")) {
			return "redirect:/list";
		} else {
			model.addAttribute("msg", msg);
			return "error";
		}
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam("num") String num, Model model) {
		String msg = dao.delete(num);
		if (msg.equals("success")) {
			return "redirect:/list";
		} else {
			model.addAttribute("msg", msg);
			return "error";
		}
	}
}
