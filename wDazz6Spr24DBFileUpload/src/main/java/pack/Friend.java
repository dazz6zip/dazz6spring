package pack;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Friend {
	
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment일 때만 사용
	@Id
	private int bunho;
	
	private String irum;
	
	private String junhwa;
	
	private String jikup;
	
	@Lob // blob, clob
	private byte[] sajin;
	
	private String imagetype;
	
	@Transient // DB와 관련없는 임시 데이터 저장용
	private String base64Image; // base64로 인코딩된 이미지 타입
}
