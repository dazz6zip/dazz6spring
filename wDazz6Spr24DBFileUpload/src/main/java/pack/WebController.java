package pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@Autowired
	private FriendService fs;

	@GetMapping("/")
	public String start() {
		return "start";
	}

	@GetMapping("/list")
	public String listGet(Model m) {
		List<Friend> f = fs.findAll();
		m.addAttribute("friends", f);
		return "list";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "/login";
	}

}
