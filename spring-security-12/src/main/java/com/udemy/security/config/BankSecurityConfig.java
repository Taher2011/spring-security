package com.udemy.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BankSecurityConfig extends WebSecurityConfigurerAdapter {

	public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/account").hasRole("ADMIN").antMatchers("/balance")
				.hasAnyRole("USER", "ADMIN").antMatchers("/loan").hasRole("ROOT").antMatchers("/card").authenticated()
				.antMatchers("/notice").permitAll().antMatchers("/contact").permitAll().and().httpBasic();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
