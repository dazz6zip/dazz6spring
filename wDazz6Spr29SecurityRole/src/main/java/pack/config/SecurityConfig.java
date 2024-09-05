package pack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	// 클라이언트 요청이 들어오면 filter + filter + ... => DispatcherServlet
	
	@Bean
	SecurityFilterChain sfc(HttpSecurity hs) throws Exception{
		String[] isOk = {
			"/", "/notice", "/user/loginform", "/user/login_fail", "/user/expired", "/shop"				
		};
		
		hs.csrf(csrf -> csrf.disable()) // CSRF 사용 안 하기
			.authorizeHttpRequests(config 
				// 사용자 인증 설정
				-> config
					.requestMatchers(isOk)
					.permitAll()
					.requestMatchers("/admin/**") // 특정 권한을 가진 사용자만 접근 허용
					.hasRole("ROLE_ADMIN")
					.requestMatchers("/staff/**")
					.hasAnyRole("ROLE_ADMIN", "ROLE_STAFF")
					.anyRequest()
					.authenticated()
			).formLogin(login 
				-> login
					.loginPage("/user/required_loginform") 
					.loginProcessingUrl("/user/login")
					.usernameParameter("userName")
					.passwordParameter("password")
					.successHandler(new AuthSuccessHandler())
					.failureForwardUrl("/user/login_fail")
					.permitAll()
			).logout(logout
				-> logout
					.logoutUrl("/user/logout")
					.logoutSuccessUrl("/")
					.permitAll()
			).exceptionHandling(eh
				-> eh
					.accessDeniedPage("/user/denied")
			).sessionManagement(ss
				-> ss
					.maximumSessions(1)
					.expiredUrl("/user/expired")
			)
			;
		
		return hs.build();
	}
	
	@Bean
	public PasswordEncoder pe() {
		return new BCryptPasswordEncoder();
	}
	
	AuthenticationManager athMng(HttpSecurity hs, UserDetailsService uds, BCryptPasswordEncoder pe) throws Exception {
		AuthenticationManagerBuilder athMsnBld = hs.getSharedObject(AuthenticationManagerBuilder.class);
		athMsnBld
			.userDetailsService(uds)
			.passwordEncoder(pe);
			
		return athMsnBld.build();
	}
}
