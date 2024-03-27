package com.multi.chatting;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		
		//브라우저: ws://localhost:9090/컨텍스트/chat ==>sockjs에서 접속할때 사용
		//여러 명 채팅 가능
		registry.addEndpoint("/chat")
		.withSockJS();//버전 낮은 브라우저에서도 적용
		
		//챗봇 관련한 엔드포인트 설정==> 나중에
		registry.addEndpoint("/chatbot") 
		.withSockJS();
		//queue 사용시 접속 클라이언트를 식별할 HandshakeHandler설정
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//해당 주소를 구독하는 서버가 클라이언트에게 메세지를 전달한다
		registry.enableSimpleBroker("/topic","/queue");
		
		//클라이언트가 서버로 보낸 메세지를 받는 prefix(접두어)
		registry.setApplicationDestinationPrefixes("/app");
		
	}

	
}
