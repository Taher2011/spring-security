package com.udemy.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@Configuration
public class BankSecurityConfig extends WebSecurityConfigurerAdapter {

	public void configure(HttpSecurity http) throws Exception {
		
		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());
		
		http.cors().and().authorizeRequests()
		.antMatchers("/account/*").hasRole("USER")
		.antMatchers("/balance/*").hasAnyRole("ADMIN")
		.antMatchers("/loan/*").authenticated()
		.antMatchers("/card/*").hasAnyRole("USER", "ADMIN")
		.antMatchers("/notice").permitAll()
		.antMatchers("/contact").permitAll()
		.and().csrf().disable().oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter);

	}

}
