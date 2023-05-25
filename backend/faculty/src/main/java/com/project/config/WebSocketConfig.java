package com.project.config;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }
    public void registerCorsConfiguration(CorsRegistry registry) {
        registry.addMapping("/websocket/**")
                .allowedOrigins("http://localhost:3000", "http://localhost:3000/notification", "http://localhost:8082")
                .allowedMethods("GET", "POST")
                .allowCredentials(true);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
        .setAllowedOrigins("http://localhost:3000/notification","http://localhost:3000");

        registry.addEndpoint("/ws")
            .setAllowedOrigins("http://localhost:8082", "http://localhost:3000", "http://127.0.0.1:5500/")
            .withSockJS();
    
    }
}
