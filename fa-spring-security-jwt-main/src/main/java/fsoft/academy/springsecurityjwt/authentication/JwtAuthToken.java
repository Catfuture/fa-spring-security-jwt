package fsoft.academy.springsecurityjwt.authentication;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public class JwtAuthToken extends PreAuthenticatedAuthenticationToken {
	public JwtAuthToken(Object aPrincipal, Object aCredentials) {
		super(aPrincipal, aCredentials);
	}

	public JwtAuthToken(
		Object aPrincipal,
		Object aCredentials,
		Collection<? extends GrantedAuthority> anAuthorities
	) {
		super(aPrincipal, aCredentials, anAuthorities);
	}
}
