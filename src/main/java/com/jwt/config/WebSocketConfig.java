package com.jwt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSocketMessageBroker
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.enableSimpleBroker("/topic");
//        config.setApplicationDestinationPrefixes("/app");
//    }
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/gs-guide-websocket").withSockJS();
//    }
	
//	@Configuration
//	@EnableWebSocketMessageBroker
	public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
		@Override
		public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
			stompEndpointRegistry.addEndpoint("/socket")
					.setAllowedOrigins("*")
					.withSockJS();
		}

		@Override
		public void configureMessageBroker(MessageBrokerRegistry registry) {
			registry.enableSimpleBroker("/topic");
			registry.setApplicationDestinationPrefixes("/app");
		}
	}

