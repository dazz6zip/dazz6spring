package pack;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/topic");  // "/topic"으로 시작하는 메세지는 메세지브로커로 라우팅됨
		registry.setApplicationDestinationPrefixes("/app"); // "/app"으로 시작하는 메세지를 현재 서버로 보냄
	}
	
	@Override    // STOMP 엔드포인트를 등록
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws").withSockJS();
		// "/ws" 엔드포인트는 SockJS 옵션을 통해 웹소켓을 사용할 수 있도록 설정
	}
	

}
