package org.zalando.stups.stupsback.admin.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import de.zalando.zmon.security.AuthorityService;

@Component
public class SimplAuthorityService implements AuthorityService {

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(String username) {
		return AuthorityUtils.createAuthorityList("USER");
	}

}
