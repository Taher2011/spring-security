package com.udemy.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthoritiesLoggingAfterFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(AuthoritiesLoggingAfterFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (ObjectUtils.isNotEmpty(authentication)) {
			logger.info("User " + authentication.getName() + " is successfully authenticated and "
					+ "has the authorities " + authentication.getAuthorities().toString());
		}
		chain.doFilter(request, response);
	}

}
