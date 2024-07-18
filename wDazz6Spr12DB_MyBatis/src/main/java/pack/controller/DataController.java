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
	private DataProcess dp;
	
	@GetMapping("/")
	public String start() {
		return "start";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("datas", dp.getDataAll());
		return "list";
	}
	
	@GetMapping("insert")
	public String insert1() {
		return "insert";
	}
	
	@PostMapping("insert")
	public String insert2(DataBean bean) {
		return dp.insert(bean) ? "redirect:/list" : "redirect:/error";
	}
	
	@GetMapping("error")
	public String error() {
		return "error";
	}
	
	@GetMapping("update")
	public String update1(@RequestParam("num") String num, Model model) {
		model.addAttribute("data", dp.getData(num));
		return "update";
	}
	
	@PostMapping("update")
	public String update2(DataBean bean) {
		return dp.update(bean) ? "redirect:/list" : "redirect:/error";
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam("num") String num) {
		return dp.delete(num) ? "redirect:/list" : "redirect:/error";
	}
	
	
}
