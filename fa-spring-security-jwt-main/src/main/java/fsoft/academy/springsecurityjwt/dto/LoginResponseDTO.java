package fsoft.academy.springsecurityjwt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponseDTO {
	private String accessToken;
	// private String refreshToken;
}
