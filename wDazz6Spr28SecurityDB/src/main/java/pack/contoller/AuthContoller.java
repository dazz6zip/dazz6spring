package pack.contoller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthContoller {

	private final AuthenticationManager athMng; 				// 인증 처리를 위한 AuthenticationManager 객체 field 로 선언
																// 로그인 인증 처리 담당

	public AuthContoller(AuthenticationManager athMng) {
		this.athMng = athMng;
	}

	

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String processLogin(@RequestParam("sabun") String sabun, @RequestParam("irum") String irum, Model model) {
		
		try {
			
			/* 사원 번호와 이름으로 인증 토큰 생성 */
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(sabun, irum);
			
			/* AuthenticationManager 로 인증 시도 */ 
			Authentication ath = athMng.authenticate(token);
			
			/* 인증에 성공할 경우 */
			SecurityContextHolder.getContext().setAuthentication(ath);
			// SecurityContextHolder에 인증 객체 저장
			
			model.addAttribute("username", irum);
			return "redirect:/auth/success";
			
		} catch (AuthenticationException e) {
			
			/* 인증에 실패할 경우 */
			model.addAttribute("error", e.getMessage());
			return "login";
		}
	}
	
	@GetMapping("/success")
	public String success(Model model) {
		Authentication ath = SecurityContextHolder.getContext().getAuthentication();
		
		String username = ath.getName();
		model.addAttribute("username", username);
		
		return "success";
	}
	
	@GetMapping("/logout")
	public String logout() {
		// SecurityConfig에 지정해 뒀기 때문에 /logout 요청이 들어오면 자동으로 logout 처리가 됨
		// return 경로만 지정하면 됨!!
		return "redirect:/auth/login";
	}
	
	@GetMapping("/gugu")
	public String gugu() {
		Authentication ath = SecurityContextHolder.getContext().getAuthentication();
		// 현재 인증된 사용자 정보 가져옴
		
		if(ath == null || !ath.isAuthenticated()) {
			// 로그인 정보가 없을 경우
			return "redirect:/auth/login";
		}
		
		return "gugu";
	}
	
	@PostMapping("/gugu")
	public String processGugu(@RequestParam("num") int num, Model model) {
		Authentication ath = SecurityContextHolder.getContext().getAuthentication();
		// 현재 인증된 사용자 정보 가져옴
		
		if(ath == null || !ath.isAuthenticated()) {
			// 로그인 정보가 없을 경우
			return "redirect:/auth/login";
		}
		
		model.addAttribute("num", num);
		return "guguresult";
	}
	

}
