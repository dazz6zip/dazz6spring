package pack;

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

@Configuration // 환경을 잡아 주는 클래스임을 명시하는 어노테이션
@EnableWebSecurity // WebSecurity에 관련된 환경임을 명시하는 어노테이션
public class SecurityConfig { // 기본적인 웹 보안 구성을 설정
	
	@Bean
	public SecurityFilterChain sfc(HttpSecurity http) throws Exception {
		// HttpSecurity 객체를 사용하여 보안 설정 정의
		http
			.authorizeHttpRequests(athReq -> 			// http 요청에 대한 보안 권한 설정
				athReq
					.requestMatchers("/login")
					.permitAll() 						// 위 경로(/login)는 인증 없이 누구든 접근 허용
					.anyRequest() 						// 나머지 경로 (/login 외 경로) 는
					.authenticated() 					// 인증된 경우에만 접근 허용
			).formLogin(formLogin -> 
				formLogin
					.loginPage("/login") 				// 로그인 페이지 경로 지정
					.defaultSuccessUrl("/", true) 		// 로그인 성공 후 이동 루트 지정
					.permitAll() 						// 로그인 페이지는 인증없이 누구든 접근 허용
			).logout(logout -> 
				logout
					.logoutUrl("/logout")				// 로그아웃 페이지 경로 지정 (security 기본값이 /logout 이므로 생략 가능함)
					.logoutSuccessUrl("/login?logout")	// 로그아웃 성공 후 이동 루트 지정
					.permitAll()						// 로그아웃 페이지는 인증 없이 누구든 접근 허용
			).sessionManagement(ssMng -> 
				ssMng
					.maximumSessions(1) 				// 최대 동시 세션 수 제한
					.expiredUrl("/login?expired")		// 세션 만료시 경로 지정 (로그인으로 이동)
			);
			
		return http.build();
	}
	
	@Bean
	public UserDetailsService uds() {
		UserDetails user = User
							.builder()
							.username("kor")
							.password(pe().encode("123"))
							.roles("USER") 				// default user 역할
							.build(); 					// 사용자명 / 비밀번호 역할 설정
		
		return new InMemoryUserDetailsManager(user);	// InMemoryUserDetailsManager : 사용자 정보를 메모리에 저장하고 관리하는 클래스
														// 주로 애플리케이션, 테스트 환경에서 사용
														// 영구 저장소가 아니므로 애플리케이션을 재시작하면 사라짐
	}
	
	/* 비밀번호 암호화를 위한 메소드 */
	@Bean
	public PasswordEncoder pe() {
		return new BCryptPasswordEncoder(); 			// 비밀번호 암호화를 위해 BCrypt 알고리즘 사용
														// 단방향 해시함수를 이용하여 암호화 수행
	}



}
