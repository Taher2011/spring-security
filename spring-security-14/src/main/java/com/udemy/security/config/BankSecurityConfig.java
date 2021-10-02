package com.udemy.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.udemy.security.filter.JWTTokenGeneratorFilter;
import com.udemy.security.filter.JWTTokenValidatorFilter;

@Configuration
public class BankSecurityConfig extends WebSecurityConfigurerAdapter {

	public void configure(HttpSecurity http) throws Exception {

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().cors().and().csrf()
				.disable().authorizeRequests().and()
				.addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
				.addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class).authorizeRequests()
		.antMatchers("/user").authenticated()		
		.antMatchers("/account/*").hasRole("ADMIN")
		.antMatchers("/balance/*").hasAnyRole("USER", "ADMIN")
		.antMatchers("/loan/*").hasRole("ROOT")
		.antMatchers("/card/*").authenticated()
		.antMatchers("/notice").permitAll()
		.antMatchers("/contact").permitAll()
		.and().httpBasic();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
