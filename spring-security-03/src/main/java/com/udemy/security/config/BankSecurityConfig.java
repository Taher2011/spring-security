package com.udemy.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class BankSecurityConfig extends WebSecurityConfigurerAdapter {

	public void configure(HttpSecurity http) throws Exception {

		/* Custom configuration as per requirement */

		http.authorizeRequests().antMatchers("/account").authenticated().antMatchers("/card").authenticated()
				.antMatchers("/loan").authenticated().antMatchers("/balance").authenticated().antMatchers("/notice")
				.permitAll().antMatchers("/contact").permitAll().and().formLogin().and().httpBasic();
	}

}
