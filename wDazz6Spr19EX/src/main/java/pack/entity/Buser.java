package pack.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "buser")
public class Buser {

	@Id
	@Column(name = "buser_no")
	private String no;
	
	@Column(name = "buser_name")
	private String name;
	
	@OneToMany(mappedBy = "buser", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Jikwon> jlist = new ArrayList<Jikwon>();
	
}
