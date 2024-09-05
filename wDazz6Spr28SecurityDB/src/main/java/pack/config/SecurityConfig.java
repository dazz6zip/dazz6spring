package pack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import jakarta.servlet.http.HttpSessionEvent;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	/* 애플리케이션 보안 설정 담당 클래스 */
	// 특정 URL 허용 여부, 로그인 및 로그아웃 처리 방법, 사용자 인증 방법 등 포함
	
	@Bean
	public AuthenticationManager athMng(AuthenticationConfiguration athConf) throws Exception {
		return athConf.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain sfc(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(auth // 요청에 대한 인증 및 권한 부여 설정
					-> auth
					
						/* requestMatchers 안에 있는 경로들은 모두 접근 가능 */
						.requestMatchers("/auth/login", "/auth/logout", "/static/**")
						.permitAll()
						
						/* requestMatchers 에 지정되지 않은 경로들은 인증 필요 */
						.anyRequest()
						.authenticated()
						
						
			).formLogin(formLogin // 폼 기반 로그인 설정
					-> formLogin
					
						/* 로그인 페이지, 로그인 처리 페이지 경로 지정 */
						.loginPage("/auth/login")
						.loginProcessingUrl("/auth/login")
						
						/* 로그인에 필요한 username, password 파라미터 지정 */
						.usernameParameter("sabun")
						.passwordParameter("irum")
						
						/* 로그인 성공 페이지 경로 지정 / 모두 접근 가능 */
						.defaultSuccessUrl("/auth/success", true)
						.permitAll()
						
						
			).logout(logout
					-> logout
						
						/* 로그아웃 페이지, 로그아웃 처리 페이지 경로 지정 / 모두 접근 가능 */
						.logoutUrl("/auth/logout")
						.logoutSuccessUrl("/auth/login")
						.permitAll()
			);
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder pe() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public HttpSessionEventPublisher hsEp() {
		// 세션 유휴시간은 application.properties 에서도 지정 가능

		return new HttpSessionEventPublisher() {
			
			@Override
			public void sessionCreated(HttpSessionEvent event) {
				event.getSession().setMaxInactiveInterval(600); // 600초 -> 10분
				super.sessionCreated(event);
			}
			
			
		};
	}
}
