package pack.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Gogek;
import pack.entity.Jikwon;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JikwonDto {
	private String no, name, jik, num, bname;
	private boolean gCheck;
	private List<GogekDto> glist;
	
	public static JikwonDto toDto(Jikwon jikwon) {
		return JikwonDto.builder()
				.no(jikwon.getNo())
				.name(jikwon.getName())
				.jik(jikwon.getJik())
				.gCheck(jikwon.getGlist().size() > 0 ? true : false)
				.bname(jikwon.getBuser().getName())
				.build();
	}
}
