package pack;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendService {
	
	@Autowired
	private FriendRepository frps;
	
	public void saveFriend(Friend f) {
		frps.save(f);
	}
	
	public List<Friend> findAll() {
		// Friend를 모두 읽어 각 객체의 사진을 Base64로 변환 후 리스트에 저장
		return frps.findAll().stream()
				.map(this::convertToBase64).collect(Collectors.toList());
	}
	
	private Friend convertToBase64(Friend f) {
		// 사진을 Base64를 인코딩해서 DB에 저장
		if (f.getSajin() != null && f.getSajin().length > 0) {
			// 사진이 존재하면 해당 블럭으로 들어옴
			String base64Image = Base64.getEncoder().encodeToString(f.getSajin());
			f.setBase64Image(base64Image);
		}
		return f;
	}
	
	// 번호 증가
	private int generateBunho() {
		Integer lastBunho = frps.findLastBunho();
		if(lastBunho == null) {
			
			return lastBunho;
		} else {
			return lastBunho + 2;
		}
	}
}
