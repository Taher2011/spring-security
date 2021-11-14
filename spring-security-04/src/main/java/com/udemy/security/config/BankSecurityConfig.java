package com.udemy.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class BankSecurityConfig extends WebSecurityConfigurerAdapter {

	public void configure(HttpSecurity http) throws Exception {

		/* Configuration to deny all request */

		http.authorizeRequests().anyRequest().denyAll().and().formLogin().and().httpBasic();
	}

}
