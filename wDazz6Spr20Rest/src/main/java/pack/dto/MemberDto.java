package pack.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("mdto") // 객체 별명을 주고 mapper.xml 문서에서 사용 가능
public class MemberDto {
	private int num;
	private String name, addr;
}
