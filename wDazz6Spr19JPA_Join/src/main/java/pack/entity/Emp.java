package pack.entity;

import java.util.Date;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
	
	@Id
	private Integer empno;
	
	private String ename;
	private String job;
	private Integer mgr; // 관리자 직원 번호
	
	@Temporal(TemporalType.DATE) // Date type mapping
	private Date hiredate;
	
	private Double comm;
	private Double sal; // 월급
	
//	private Integer deptno;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "deptno", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private Dept dept;

}
