package pack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Sangpum;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SangpumDto {
	
	private int code;
	private String sang, su, dan;
	
	public static SangpumDto toDto(Sangpum entity) {
		return SangpumDto.builder()
				.code(entity.getCode())
				.sang(entity.getSang())
				.su(entity.getSu())
				.dan(entity.getDan())
				.build();
	}
}
