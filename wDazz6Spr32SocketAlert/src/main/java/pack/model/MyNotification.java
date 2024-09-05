package pack.model;

public class MyNotification {
	private String type, message;
	
	public MyNotification() {
		
	}
	
	public MyNotification(String type, String message) {
		this.type = type;
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
