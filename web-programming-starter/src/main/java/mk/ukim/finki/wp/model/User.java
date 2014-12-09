package mk.ukim.finki.wp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "wp_users")
public class User extends BaseEntity {

	public static enum Role {
		ROLE_USERS, ROLE_STUDENT, ROLE_PROFESSOR, ROLE_ADMIN
	}

	private String fistName;

	private String lastName;

	@Column(unique = true)
	private String username;

	private String email;

	@Column(name = "user_password")
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "user_role", length = 20, nullable = false)
	private Role role;

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
