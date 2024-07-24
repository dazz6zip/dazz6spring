package pack.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Dept;
import pack.entity.Emp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeptDto {
	private Integer deptno;
	private String dname;
	private String loc;
	private int count; // 근무 인원수
	private List<String> names; // 근무 직원의 이름들
	
	// Entity를 Dto로 변환하기
	public static DeptDto toDto(Dept dept) {
		// 직원명 저장 리스트
		List<String> names = new ArrayList<String>();
		for (Emp e : dept.getList()) {
			names.add(e.getEname());
		}
		
		// lombok builder 로 생성자 주입값을 선택적으로 등록 (chain 사용)
		return DeptDto.builder()
				.deptno(dept.getDeptno())
				.dname(dept.getDname())
				.loc(dept.getLoc())
				.count(dept.getList().size())
				.names(names)
				.build();
	}

}
