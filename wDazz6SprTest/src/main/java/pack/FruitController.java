package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FruitController {

	@GetMapping("list")
	public String list(@RequestParam("sang") String sang, @RequestParam("price") int price, @RequestParam("quality") String quality, @RequestParam("su") int su, Model model) {
		
		price = quality.equals("상") ? price * 2 : price * 1;
		
		model.addAttribute("list", sang + " 금액은 " + (price * su));
		return "list";
	}
}
