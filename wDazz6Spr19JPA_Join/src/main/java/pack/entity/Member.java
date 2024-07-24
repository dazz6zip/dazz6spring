package pack.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pack.dto.MemberDto;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MEMBER_TABLE")
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long num;
	
	private String name;
	private String addr;	
	
	// dto -> entity
	public static Member toEntity(MemberDto dto) {
		return Member.builder()
				.num(dto.getNum())
				.name(dto.getName())
				.addr(dto.getAddr())
				.build();
	}
}
