package fsoft.academy.springsecurityjwt.dto;

import fsoft.academy.springsecurityjwt.common.Role;
import fsoft.academy.springsecurityjwt.entity.User;
import lombok.Getter;

@Getter
public class UserInfoDTO {
	private final Long id;
	private final String username;
	private final String fullName;
	private final Role role;

	public UserInfoDTO(User user) {
		id = user.getId();
		username = user.getUsername();
		fullName = user.getFullName();
		role = user.getRole();
	}
}
