package com.udemy.security.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

	@Override
	public Collection<GrantedAuthority> convert(Jwt jwt) {
		Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");

		if (realmAccess == null || realmAccess.isEmpty()) {
			return new ArrayList<>();
		}

		List<String> roles = (List<String>) realmAccess.get("roles");

		List<String> updatedRoleNames = roles.stream().map(role -> "ROLE_" + role).collect(Collectors.toList());

		Collection<GrantedAuthority> simpleGrantedAuthority = updatedRoleNames.stream()
				.map(updatedRoleName -> new SimpleGrantedAuthority(updatedRoleName)).collect(Collectors.toList());

		return simpleGrantedAuthority;
	}

}