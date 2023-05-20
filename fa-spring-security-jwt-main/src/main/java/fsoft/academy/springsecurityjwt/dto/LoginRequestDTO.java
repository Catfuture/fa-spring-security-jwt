package fsoft.academy.springsecurityjwt.dto;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class LoginRequestDTO {
	@NotEmpty(message = "Username is required")
	private String username;

	@NotEmpty(message = "Password is required")
	private String password;
}
