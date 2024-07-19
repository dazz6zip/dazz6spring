package pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "gogek")
public class GogekDto {
	
	@Id
	@Column(name = "gogek_no")
	private String no;
	
	@Column(name = "gogek_name")
	private String name;

	@Column(name = "gogek_tel")
	private String tel;
}
