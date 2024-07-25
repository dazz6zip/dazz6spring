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
	private int gcount;
	private List<GogekDto> glist;
	
	public static JikwonDto toDto(Jikwon jikwon) {
		List<GogekDto> glist = new ArrayList<GogekDto>();
		for (Gogek g : jikwon.getGlist()) {
			glist.add(GogekDto.toDto(g));
		}
		
		return JikwonDto.builder()
				.no(jikwon.getNo())
				.name(jikwon.getName())
				.jik(jikwon.getJik())
				.glist(glist)
				.bname(jikwon.getBuser().getName())
				.build();
	}
}
