package pack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 스프링의 설정을 위한 클래스 
@EnableWebSecurity // 스프링 시큐리티 기능 활성화
public class SecurityConfig {
// 시큐리티 기능 : 보안 설정 자동화, 인증 및 권한 부여, 비밀번호 암호화, CSRF 보호, 기본 로그인 폼 제공, user 라는 기본 사용자 계정 생성

	@Bean
	public SecurityFilterChain sfc(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((req) 
						-> req.requestMatchers("/")
								.permitAll()
								.anyRequest()
								.authenticated()) // 루트 경로 모두 허용, 그 외 인증 필요
			.formLogin((f)
						-> f.loginPage("/login") // 커스텀 로그인 페이지 설정
							.permitAll()) // 누구든지 접근 가능
			.logout((lo) // logout 설정
						-> lo.logoutUrl("/logout") // 로그아웃 요청 url
							.logoutSuccessUrl("/")
							.invalidateHttpSession(true) // 세션 무효화
							.deleteCookies("SESSIONID")
							.permitAll()) // 누구든지 접근 가능
			.csrf((csrf) -> csrf.disable()); // csrf 보호는 테스트이므로 비활성화
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService uds() {
		// 사용자 세부 정보 관리 서비스 정의
		
		/* 사용자 정보 빌드 */
		UserDetails ud = User.builder()
								.username("user")
								.password(pwe().encode("password"))
								.roles("USER")
								.build();
		return new InMemoryUserDetailsManager(ud);
		// 메모리 내 사용자 세부 정보 관리자 생성 후 
	}
	
	@Bean
	public PasswordEncoder pwe() {
		return new BCryptPasswordEncoder();
				// BCryptPasswordEncoder : 암호화 해시 함수 (현재 사용 중인 강력한 해시 매커니즘 중 하나)
				// 해시 : 입력 데이터를 고정된 길이의 고유값(해시값)으로 변환하는 과정 또는 결과
	}
}
