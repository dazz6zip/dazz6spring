package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "mem")
public class MemData {
	
	@Id
	private String num;
	
	private String name, addr;
}
