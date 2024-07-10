package pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="jikwon")
@Entity 
public class JikwonDTO { 
	
	@Id // PK 
	@Column(name="jikwon_no")
	private String no;
	
	@Column(name="jikwon_name")
	private String name;
	
	@Column(name="buser_num")
	private String team;
	
	@Column(name="jikwon_ibsail")
	private String year;

}	