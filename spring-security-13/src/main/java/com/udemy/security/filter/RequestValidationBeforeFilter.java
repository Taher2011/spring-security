package com.udemy.security.filter;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.util.StringUtils;

public class RequestValidationBeforeFilter implements Filter {

	public static final String AUTHENTICATION_SCHEME = "Basic";
	private Charset credentialsCharset = StandardCharsets.UTF_8;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		String header = servletRequest.getHeader(AUTHORIZATION);
		if (!StringUtils.isEmpty(header)) {
			header = header.trim();
			if (StringUtils.startsWithIgnoreCase(header, AUTHENTICATION_SCHEME)) {
				byte[] base64Token = header.substring(6).getBytes(StandardCharsets.UTF_8);
				byte[] decoded;
				try {
					decoded = Base64.getDecoder().decode(base64Token);
					String token = new String(decoded, getCredentialsCharset(servletRequest));
					int delim = token.indexOf(":");
					if (delim == -1) {
						throw new BadCredentialsException("Invalid basic authentication token");
					}
					String email = token.substring(0, delim);
					if (email.toLowerCase().contains("test")) {
						servletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
						return;
					}
				} catch (IllegalArgumentException e) {
					throw new BadCredentialsException("Failed to decode basic authentication token");
				}
			}
		}
		chain.doFilter(request, response);
	}

	protected Charset getCredentialsCharset(HttpServletRequest request) {
		return getCredentialsCharset();
	}

	public Charset getCredentialsCharset() {
		return this.credentialsCharset;
	}

}
