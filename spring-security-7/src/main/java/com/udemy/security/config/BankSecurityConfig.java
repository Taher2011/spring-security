package com.udemy.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class BankSecurityConfig extends WebSecurityConfigurerAdapter {

	public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/account").authenticated().antMatchers("/card").authenticated()
				.antMatchers("/loan").authenticated().antMatchers("/balance").authenticated().antMatchers("/notice")
				.permitAll().antMatchers("/contact").permitAll().and().formLogin().and().httpBasic();
	}

	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		UserDetails user1 = User.withUsername("admin-1").password("12345").authorities("admin").build();
		UserDetails user2 = User.withUsername("user-1").password("12345").authorities("read").build();
		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
		userDetailsManager.createUser(user1);
		userDetailsManager.createUser(user2);
		auth.userDetailsService(userDetailsManager);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
