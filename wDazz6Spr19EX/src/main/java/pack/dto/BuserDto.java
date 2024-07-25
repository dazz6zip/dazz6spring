package pack.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Buser;
import pack.entity.Jikwon;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuserDto {
	private String no, name;
	private List<JikwonDto> jlist;
	
	public static BuserDto toDto(Buser buser) {
		List<JikwonDto> jlist = new ArrayList<JikwonDto>();
		for (Jikwon j : buser.getJlist()) {
			jlist.add(JikwonDto.toDto(j));
		}
		
		return BuserDto.builder()
				.no(buser.getNo())
				.name(buser.getName())
				.jlist(jlist)
				.build();
	}
}
