package com.udemy.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.udemy.security.entity.Customer;
import com.udemy.security.model.CustomerDetails;
import com.udemy.security.repository.CustomerRepository;

@Service
public class CustomerDetailsService implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Customer> customer = customerRepository.findByEmail(username);
		if (!customer.isPresent()) {
			throw new UsernameNotFoundException("User " + username + " does not exist");
		}
		CustomerDetails customerDetails = new CustomerDetails(customer.get().getEmail(), customer.get().getPwd(),
				customer.get().getRole());
		return customerDetails;
	}

}
