package pack;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Service
public class JwtService {
	
	private Key key;
	// JWT 토큰을 서명, 검증하는 데 사용할 비밀 키 저장용 변수
	
	@PostConstruct  // 객체 생성 후, 의존성 주입이 완료되면 자동호출
	public void init() {
		key = Keys.secretKeyFor(SignatureAlgorithm.HS256);  // HS256 알고리즘을 사용해 비밀키 생성
	}
	
	public String createToken(String id) {
		return Jwts.builder()
				.setSubject(id) // 토큰 주제를 사용자 아이디로 설정
				.setIssuedAt(new Date()) // 토큰 발행 시간
				.setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 토큰 유효시간 (1시간)
				.signWith(key) // 비밀키로 토큰에 서명
				.compact(); // JWT 문자열 생성 후 반환				
	}
	
	public String getUserFromToken(String token) {
		// JWT 토큰에서 사용자 아이디 추출
		return Jwts.parserBuilder()
				.setSigningKey(key) // 토큰을 검증할 때 사용할 비밀키 설정
				.build() // parserBuilder 완성
				.parseClaimsJws(token) // 주어진 JWT 토큰을 파싱하고 검증
				.getBody() // 토큰 클레임을 가져옴
				.getSubject(); // 토큰 주제를 반환 (토큰 생성시 사용자 id 로 설정한 값, setSubject(id))
	}
	
}
