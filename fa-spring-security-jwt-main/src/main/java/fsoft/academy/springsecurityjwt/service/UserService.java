package fsoft.academy.springsecurityjwt.service;

import fsoft.academy.springsecurityjwt.dto.LoginRequestDTO;
import fsoft.academy.springsecurityjwt.dto.LoginResponseDTO;
import fsoft.academy.springsecurityjwt.dto.UserInfoDTO;

public interface UserService {
	LoginResponseDTO login(LoginRequestDTO dto);

	String getCurrentUsername();

	UserInfoDTO getUserInfo(String username);

	Long countUsers();
}
