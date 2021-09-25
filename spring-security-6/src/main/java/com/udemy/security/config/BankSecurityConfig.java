package com.udemy.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class BankSecurityConfig extends WebSecurityConfigurerAdapter {

	public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/account").authenticated().antMatchers("/card").authenticated()
				.antMatchers("/loan").authenticated().antMatchers("/balance").authenticated().antMatchers("/notice")
				.permitAll().antMatchers("/contact").permitAll().and().formLogin().and().httpBasic();
	}

	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("admin").password("1234").authorities("admin").and().withUser("user")
				.password("1234").authorities("read").and().passwordEncoder(NoOpPasswordEncoder.getInstance());

	}

}
