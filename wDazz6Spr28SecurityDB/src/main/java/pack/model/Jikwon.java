package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="jikwon")
@Getter
@Setter
public class Jikwon {

	@Id
	@Column(name = "jikwon_no")
	private Long no;
	
	@Column(name = "jikwon_name")
	private String name;
}
