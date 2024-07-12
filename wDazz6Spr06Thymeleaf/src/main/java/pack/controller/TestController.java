package pack.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("thymeleaf")
	public String sijak(Model model) {
		// 반환타입이 String -> ModelAndView를 나눈 것
		
		model.addAttribute("msg1", "타임리프 1");
		model.addAttribute("msg2", "타임리프 2");
		
		// DTO 자료 출력용
		Sangpum sp1 = new Sangpum();
		sp1.setCode("10");
		sp1.setSang("삼다수");
		sp1.setPrice("3000");
		model.addAttribute("sangpum", sp1);
		
		Sangpum sp2 = new Sangpum();
		sp2.setCode("20");
		sp2.setSang("고구마빵");
		sp2.setPrice("2000");
		
		ArrayList<Sangpum> list = new ArrayList<Sangpum>();
		list.add(sp1);
		list.add(sp2);
		
		model.addAttribute("list", list);
		model.addAttribute("sangpum", sp1);
		
		return "list1";
		// view -> templates/list1.html
		// 서버에서 수행되는 html, templates 엔진임 (일반 html 아님)
		// thymeleaf 사용시 .html이 자동으로 붙음
	}
}
