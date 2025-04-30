package com.sovon9.EmployeeGraphQL.jwt;

import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.server.WebSocketGraphQlInterceptor;
import org.springframework.graphql.server.WebSocketSessionInfo;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import reactor.core.publisher.Mono;

//@Component
@Configuration
public class AuthWebSocketInterceptor implements WebSocketGraphQlInterceptor
{

	@Override
	public Mono<Object> handleConnectionInitialization(WebSocketSessionInfo sessionInfo,
			Map<String, Object> connectionInitPayload)
	{
		String bearerToken = (String) connectionInitPayload.get("Authorization");
		String token = bearerToken.substring(7);
		if (token == null) {
            return Mono.error(new RuntimeException("error during authentication")); //new AuthenticationException("No token")
        }
		
		SecurityContext securityContext = SecurityContextHolder.getContext();
		 
		return WebSocketGraphQlInterceptor.super.handleConnectionInitialization(sessionInfo, connectionInitPayload);
	}
	
	
}
