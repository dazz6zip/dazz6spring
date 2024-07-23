package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "jikwon")
public class DataDto {

	@Id
	@Column(name = "jikwon_no")
	private String no;

	@Column(name = "jikwon_name")
	private String name;

	@Column(name = "jikwon_jik")
	private String jik;

	@Column(name = "jikwon_pay")
	private int pay;

	@Column(name = "jikwon_rating")
	private String rating;

	@Column(name = "buser_num")
	private String num;

}
