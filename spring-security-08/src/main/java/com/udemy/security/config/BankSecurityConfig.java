package com.udemy.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BankSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/account").authenticated().antMatchers("/card").authenticated()
				.antMatchers("/loan").authenticated().antMatchers("/balance").authenticated().antMatchers("/notice")
				.permitAll().antMatchers("/contact").permitAll().and().formLogin().and().httpBasic();
	}

	@Override
	public void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
		managerBuilder.jdbcAuthentication().dataSource(dataSource);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
