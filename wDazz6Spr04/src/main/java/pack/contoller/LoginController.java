package pack.contoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	// 로그 정보 출력용 클래스
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/login")
	public String submitCall() {
//		return "login.html"; // forward 기본값
		return "redirect:login.html"; // redirect : 명시적
//		return "redirect:http://localhost/login.html";
	}
	
	/* 클라이언트가 전달한 값 받기 */
	
	/* 방법 1 : 전통적 */
//	@PostMapping("login")
//	public String submit(HttpServletRequest request, Model model) { 
//		// jsp로 내보내기 위해 Model
//		// 만약 리턴타입이 ModelAndView라면 파라미터에 Model 필요없음
//		
//		String id = request.getParameter("id");
//		String pwd = request.getParameter("pwd");
//		System.out.println(id + " " + pwd);
//		logger.info(id + " " + pwd); // 로그 레벨 : TRACE > DEBUG > INFO > WARN > ERROR > FATAL
//		
//		String data = "";
//		if (id.equals("kor") && pwd.equals("111")) {
//			data = "로그인에 성공했습니다.";
//		} else {
//			data = "로그인에 실패했습니다.";
//		}
//		
//		model.addAttribute("data", data);
//		return "result";
//		// WEB-INF/views/result.jsp 를 부르는 것
//	}
	
	/* 방법 2 : Spring annotation */
//	public String submit(@RequestParam(value = "id")String id, @RequestParam(value = "pwd")String pwd, Model model) {
		// 클라이언트가 넘겨 주는 모든 값은 String
		// input 에서 number 등으로 지정해도 동일함
	
//	public String submit(@RequestParam(value = "id")String id, @RequestParam(value = "pwd")int pwd, Model model) {
		// @RequestParam 사용시, String 외 다른 타입으로 형 변환 가능
	
	@PostMapping("login")
	public String submit(@RequestParam(value = "id")String id, @RequestParam(value = "pwd", defaultValue = "111")int pwd, Model model) {
		// defaultValue 속성으로 초기값 부여 가능
		
		String data = "";
//		if (id.equals("kor") && pwd.equals("111")) {
		if (id.equals("kor") && pwd == 111) {
			data = "로그인에 성공했습니다.";
		} else {
			data = "로그인에 실패했습니다.";
		}
		
		model.addAttribute("data", data);
		return "result";
	}
}