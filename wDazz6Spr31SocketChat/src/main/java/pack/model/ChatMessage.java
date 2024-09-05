package pack.model;

import lombok.Data;

@Data
public class ChatMessage {
	private String sender, content;
	private MessageType type;
	
	public enum MessageType{
		CHAT,
		JOIN,
		LEAVE
	}
}
