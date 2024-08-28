package pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pack.model.Jikwon;
import pack.repository.JikwonRepository;

/* 사용자 인증 시 사용자 정보를 로드하는 역할 */

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private JikwonRepository rps;
	
	@Autowired
	private PasswordEncoder pe;
	
	@Override
	public UserDetails loadUserByUsername(String sabun) throws UsernameNotFoundException {
		// 사원번호로 사용자 정보 조회, 그 결과로 UserDetails 객체를 생성한 뒤 반환함
		
		Long jikwonNo = Long.parseLong(sabun);
		
		Jikwon jikwon = rps.findById(jikwonNo)
						.orElseThrow(() -> new UsernameNotFoundException("해당 사원번호 없음 : " + sabun));
						// Jikwon Entity 의 pk 에서 사번을 찾고, orElseThrow로 예외 (찾지 못했을 경우) 처리 
		
		return User.builder()
				.username(String.valueOf(jikwon.getNo())) // 사번을 username 으로 사용
				.password(pe.encode(jikwon.getName())) // 사원명을 password 로 사용
				.roles("USER")
				.build();
	}
	
	
}
