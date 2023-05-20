package fsoft.academy.springsecurityjwt.service;

import java.util.Date;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;

public interface JwtService {
	String generateJwt(Authentication auth);

	Claims extractAllClaims(String jwt);

	boolean isJwtExpired(Date issuedAt);
}
