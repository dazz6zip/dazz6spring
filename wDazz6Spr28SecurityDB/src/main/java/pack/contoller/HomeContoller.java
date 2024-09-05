package pack.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeContoller {

	@GetMapping("/")
	public String sijak() {
		return "redirect:/login";
	}
}
