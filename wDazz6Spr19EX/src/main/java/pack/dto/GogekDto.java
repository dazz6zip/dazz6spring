package pack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Gogek;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GogekDto {
	private String no, name, gen, jumin, tel, nai, damsano;
	
	public static GogekDto toDto(Gogek gogek) {
		return GogekDto.builder()
				.no(gogek.getNo())
				.name(gogek.getName())
				.gen(gogek.getJumin().substring(7, 8).equals("1") ? "남" : "여")
				.tel(gogek.getTel())
				.nai(gogek.getJumin().substring(0, 2))
				.damsano(gogek.getJikwon().getNo())
				.build();
	}
}
