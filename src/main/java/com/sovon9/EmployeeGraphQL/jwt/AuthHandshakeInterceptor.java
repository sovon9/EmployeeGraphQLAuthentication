package com.sovon9.EmployeeGraphQL.jwt;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

//@Component
public class AuthHandshakeInterceptor //implements HandshakeInterceptor
{

//	@Override
//	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
//			Map<String, Object> attributes) throws Exception
//	{
//		 // Extract the Authorization token from the WebSocket connection handshake
//        String authHeader = request.getHeaders().getFirst("Authorization");
//
//        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//            String token = authHeader.substring(7);  // Extract token (remove 'Bearer ')
//            // You can validate token here or pass it on
//            attributes.put("token", token); // Store token for later use
//        } else {
//            // Handle missing or invalid auth header
//            return false;
//        }
//		return true;
//	}
//
//	@Override
//	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
//			Exception exception)
//	{
//		// TODO Auto-generated method stub
//		
//	}

}
