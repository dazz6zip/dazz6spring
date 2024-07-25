package pack.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.dto.GogekDto;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gogek")
public class Gogek {
	
	@Id
	@Column(name = "gogek_no")
	private String no;
	
	@Column(name = "gogek_name")
	private String name;
	
	@Column(name = "gogek_jumin")
	private String jumin;
	
	@Column(name = "gogek_tel")
	private String tel;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "gogek_damsano", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private Jikwon jikwon;
}
