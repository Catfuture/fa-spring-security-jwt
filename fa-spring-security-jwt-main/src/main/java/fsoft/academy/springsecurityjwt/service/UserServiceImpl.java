package fsoft.academy.springsecurityjwt.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import fsoft.academy.springsecurityjwt.dto.LoginRequestDTO;
import fsoft.academy.springsecurityjwt.dto.LoginResponseDTO;
import fsoft.academy.springsecurityjwt.dto.UserInfoDTO;
import fsoft.academy.springsecurityjwt.entity.User;
import fsoft.academy.springsecurityjwt.exception.ApiException;
import fsoft.academy.springsecurityjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final AuthenticationManager authenticationManager;
	private final UserRepository userRepository;
	private final JwtService jwtService;

	@Override
	public LoginResponseDTO login(LoginRequestDTO dto) {
		Authentication auth;
		try {
			auth = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
			);
		} catch (AuthenticationException ex) {
			throw new ApiException(401, "Invalid username or password");
		}
		String accessToken = jwtService.generateJwt(auth);
		return new LoginResponseDTO(accessToken);
	}

	@Override
	public String getCurrentUsername() {
		var auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			throw new ApiException(401, "Chưa login");
		}
		return auth.getName();
	}

	@Override
	public UserInfoDTO getUserInfo(String username) {
		User user = userRepository.findByUsername(username)
			.orElseThrow(() -> new ApiException(404, "User not found"));
		return new UserInfoDTO(user);
	}

	@Override
	public Long countUsers() {
		return userRepository.count();
	}
}
