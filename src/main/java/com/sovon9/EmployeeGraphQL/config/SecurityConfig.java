package com.sovon9.EmployeeGraphQL.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sovon9.EmployeeGraphQL.jwt.JwtAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig
{
	@Bean
	public UserDetailsService userDetailsService()
	{
		UserDetails user1 = User.withUsername("SS").password(passwordEncoder().encode("password")).build();
		return new InMemoryUserDetailsManager(user1);
	}
	
	@Bean
	public JwtAuthenticationFilter authenticationFilter()
	{
		return new JwtAuthenticationFilter();
	}
	
	@Bean
	public SecurityFilterChain getSecurityFilterChain(HttpSecurity security) throws Exception
	{
		return security.authorizeHttpRequests(auth-> 
		auth.requestMatchers("/graphiql", "/subscriptions").permitAll()
		.requestMatchers(HttpMethod.POST, "/graphql").authenticated()
		.anyRequest().permitAll())
		.csrf(csrf->csrf.disable())
		.addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
		.csrf(csrf->csrf.disable())
		.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
}
