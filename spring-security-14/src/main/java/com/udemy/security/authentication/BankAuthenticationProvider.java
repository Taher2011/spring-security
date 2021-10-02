package com.udemy.security.authentication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.udemy.security.entity.Authority;
import com.udemy.security.entity.Customer;
import com.udemy.security.repository.CustomerRepository;

@Component
public class BankAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		Optional<Customer> customer = customerRepository.findByEmail(userName);
		if (customer.isPresent()) {
			if (passwordEncoder.matches(pwd, customer.get().getPwd())) {
				List<GrantedAuthority> authorities = getGrantedAuthorities(customer.get().getAuthorities());
				return new UsernamePasswordAuthenticationToken(userName, pwd, authorities);
			} else {
				throw new BadCredentialsException("Invalid password");
			}
		} else {
			throw new BadCredentialsException("No user registered");
		}
	}

	private List<GrantedAuthority> getGrantedAuthorities(List<Authority> authorities) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (Authority authority : authorities) {
			grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
		}
		return grantedAuthorities;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
