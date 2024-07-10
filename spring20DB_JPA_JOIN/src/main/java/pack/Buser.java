package pack;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="buser") 
@Entity
public class Buser {
	
	@Id
	@Column(name="buser_no")
	private int buserNo;
	
	@Column(name="buser_name")
	private String buserName;
}
