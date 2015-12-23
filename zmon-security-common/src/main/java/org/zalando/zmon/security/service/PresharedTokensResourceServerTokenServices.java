package org.zalando.zmon.security.service;

import com.google.common.collect.Sets;
import de.zalando.zmon.security.AuthorityService;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by hjacobs on 17.12.15.
 */
public class PresharedTokensResourceServerTokenServices implements ResourceServerTokenServices {

    private AuthorityService authorityService;

    private Environment environment;

    public PresharedTokensResourceServerTokenServices(AuthorityService authorityService, Environment environment) {
        this.authorityService = authorityService;
        this.environment = environment;
    }

    @Override
    public OAuth2Authentication loadAuthentication(String accessToken) throws AuthenticationException, InvalidTokenException {

        final String uid = environment.getProperty(String.format("preshared_tokens.%s.uid", accessToken));

        if (uid == null) {
            throw new InvalidTokenException("Invalid pre-shared token");
        }

        // expires_at is timestamp in seconds
        final Long expiresAt = environment.getProperty(String.format("preshared_tokens.%s.expires_at", accessToken), Long.class);
        if (expiresAt == null || System.currentTimeMillis() > expiresAt * 1000) {
            throw new InvalidTokenException("Pre-shared token expired");
        }

        Collection<? extends GrantedAuthority> authorities = authorityService.getAuthorities(uid);

        UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(uid, "N/A", authorities);
        Set scopes = Sets.newHashSet("uid");

        OAuth2Request request = new OAuth2Request((Map)null, "NOT_NEEDED", (Collection)null, true, scopes, (Set)null, (String)null, (Set)null, (Map)null);
        return new OAuth2Authentication(request, user);
    }

    @Override
    public OAuth2AccessToken readAccessToken(String accessToken) {
        throw new UnsupportedOperationException("Not supported: read access token");
    }
}

