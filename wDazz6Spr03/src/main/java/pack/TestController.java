package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

/* @RestController 사용 */
// @Controller + @ResponseBody
//@RestController 
//public class TestController {
//	
//	@RequestMapping("test1")
//	public String abc() {
//		return "요청에 대한 반응 보이기";
//	}
//	
//}


/* @Controller 사용 */
// 사용자의 요청을 받아 처리한 후 지정된 뷰(템플릿 엔진 : jsp...) 에 모델 객체를 넘겨줌
@Controller  
public class TestController {
	
	@RequestMapping("test1") // GET과 POST 모두 처리
	public ModelAndView abc() {
//		System.out.println("abc() 처리");
//		return null;
		
//		return new ModelAndView("list", "msg", "jsp!"); // (viewname, key, value)
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");
		mav.addObject("msg", "jsp!");
		// request.setAttribute("msg", "jsp!"); 와 같은 의미
		// HttpServletRequest 사용. (키, 값)으로 jsp에 전송
		return mav;
	}
	
	@RequestMapping(value="test2", method=RequestMethod.GET) // GET 요청 처리
	public ModelAndView abc2() {
		return new ModelAndView("list", "msg", "성공2"); 
	}
	
	@GetMapping("test3") // GET 요청 처리
	public ModelAndView abc3() {
		return new ModelAndView("list", "msg", "성공3"); 
	}
	
	@GetMapping("test4") // GET 요청 처리
	public String abc4(Model model) {
		model.addAttribute("msg", "성공4");
		return "list"; 
	}
	
	@RequestMapping(value="test5", method=RequestMethod.POST) // POST 요청 처리
	public ModelAndView abc5() {
		return new ModelAndView("list", "msg", "성공5"); 
	}
	
	@PostMapping("test6") // GET 요청 처리
	public ModelAndView abc6() {
		return new ModelAndView("list", "msg", "성공6");
	}
	
	@PostMapping("test7") // GET 요청 처리
	public String abc7(Model model) {
		model.addAttribute("msg", "성공7");
		return "list";
	}
	
	@GetMapping("test8_1") // GET 요청 처리
	@ResponseBody // 일반 데이터 return 시 사용
	public String abc8_1() {
		String value = "일반 데이터 - String, Map, JSON 등 전달";
		return value;
	}
	
	@GetMapping("test8_2") // GET 요청 처리
	@ResponseBody // 일반 데이터 return 시 사용
	public DataDto abc8_2() {
		DataDto dto = new DataDto();
		dto.setCode(10);
		dto.setName("이름");
		return dto; // JSON 타입으로 반환 
		// {"code":10,"name":"이름"}
	}
	
}
