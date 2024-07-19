package pack.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

	@GetMapping("/test")
	public String test(@RequestParam("name") String name, @RequestParam("age") int age, Model model) {
		String nai = "오십 대 이상";
		switch (age / 10 * 10) {
		case 10:
			nai = "십대";
			break;
		case 20:
			nai = "이십대";
			break;
		case 30:
			nai = "삼십대";
			break;
		case 40:
			nai = "사대";
			break;
		}
		String[] s = {name, nai};
		model.addAttribute("result", s);
		return "result";
	}
}
