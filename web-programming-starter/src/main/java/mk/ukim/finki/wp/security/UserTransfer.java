package mk.ukim.finki.wp.security;

import mk.ukim.finki.wp.model.User;

public class UserTransfer {

	private final User user;
	private final String username;
	private final String role;

	public UserTransfer(User user, String username, String role) {
		this.user = user;
		this.username = username;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public String getRole() {
		return role;
	}

}
