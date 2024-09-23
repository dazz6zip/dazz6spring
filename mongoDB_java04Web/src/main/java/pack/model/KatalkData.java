package pack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "katalkfiled")
public class KatalkData {
	
	@Id
	private String id;
	
	private String req, res;
}
