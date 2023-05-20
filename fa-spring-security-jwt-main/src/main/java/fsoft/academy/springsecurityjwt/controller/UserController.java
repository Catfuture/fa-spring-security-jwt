package fsoft.academy.springsecurityjwt.controller;

import javax.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import fsoft.academy.springsecurityjwt.dto.LoginRequestDTO;
import fsoft.academy.springsecurityjwt.dto.LoginResponseDTO;
import fsoft.academy.springsecurityjwt.dto.UserInfoDTO;
import fsoft.academy.springsecurityjwt.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@PostMapping("/login")
	public LoginResponseDTO login(@RequestBody @Valid LoginRequestDTO dto) {
		return userService.login(dto);
	}

	@GetMapping("/current")
	@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	public UserInfoDTO getCurrentUser() {
		var currentUsername = userService.getCurrentUsername();
		return userService.getUserInfo(currentUsername);
	}

	@GetMapping("/count")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Long countUsers() {
		return userService.countUsers();
	}
}
