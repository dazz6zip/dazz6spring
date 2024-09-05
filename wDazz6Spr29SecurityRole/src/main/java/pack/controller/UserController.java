package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	// 로그인하지 않은 상태로 로그인이 필요한 정보를 요청할 경우 redirect 되는 요청 경로
	@GetMapping("/user/required_loginform")
	public String required_loginform() {
		return "user/required_loginform";
	}

	// 자발적으로 로그인 링크를 클릭하여 로그인하는 경우
	@GetMapping("/user/loginform")
	public String loginform() {
		return "user/loginform";
	}

	// 로그인 성공시 forward 되는 요청 경로
	@PostMapping("/user/login_success")
	public String login_success() {
		return "user/login_success";
	}

	// 로그인폼 제출 이후 로그인 프로세스 중에 forward 되는 경로이기 때문에 @PostMapping 사용
	@PostMapping("/user/login_fail")
	public String login_fail() {
		return "user/login_fail";
	}

	// 권한 부족시
	@GetMapping("/user/denied")
	public String denied() {
		return "user/denied";
	}

	// ROLL_STAFF, ROLE_ADMIN 만 요청 가능
	@GetMapping("/staff/user/list")
	public String list() {
		return "user/list";
	}

	// ROLL_STAFF, ROLE_ADMIN 만 요청 가능
	@GetMapping("/admin/user/manage")
	public String manage() {
		return "user/manage";
	}
	
	// 세션 허용 갯수 초과시
	@GetMapping("/user/expired")
	public String expired() {
		return "user/expired";
	}
}
