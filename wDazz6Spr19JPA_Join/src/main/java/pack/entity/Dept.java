package pack.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.LazyInitializationException;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dept {

	@Id
	private Integer deptno;

	private String dname;
	private String loc;

	
	/* FetchType.LAZY */
	// Dept 사용 중 Emp는 필요할 때 로딩 (지연 로딩)
	// 세션이 열려 있는 동안 세션 관리가 필요
	// LazyInitializationException 조치 필요
	
	/* FetchType.EAGER */
	// Dept 사용 중 Emp 즉시 로딩
	// 메모리 낭비
	
	@OneToMany(mappedBy = "dept", fetch = FetchType.EAGER)
	@Builder.Default // Emp Entity 생성시 list 초기화
	private List<Emp> list = new ArrayList<Emp>();
	
	
}
