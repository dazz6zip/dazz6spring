package pack;


import java.sql.Date;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor 
@Builder
@Table(name = "jikwon")
@Entity
public class Jikwon {
	@Id
	@Column(name = "jikwon_no")
	private int jikwonNo;
	
	@Column(name = "jikwon_name")
	private String jikwonName;

	@ManyToOne // 직원 입장으로 다대일 
	@JoinColumn(name = "buser_num", referencedColumnName = "buser_no")
	private Buser buser;

	@Column(name = "jikwon_ibsail")
	private Date jikwonIbsail;
}
