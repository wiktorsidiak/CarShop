package com.sidiak.CarShop.model.User;


import com.sidiak.CarShop.model.Seller;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "appuser", uniqueConstraints = @UniqueConstraint(columnNames = { "username", "email" }))
@Getter
@Setter
public class User{
	@NotNull
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long userId;

	@NotNull
	@Size(min = 4, max = 12)
	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@Size(min = 8)
	@Column(name = "password")
	private String password;

	@Column(name = "enabled")
	private boolean isEnabled;

	@OneToOne(optional = false, mappedBy = "user")
	private Seller seller;

	@ManyToMany
	@ElementCollection(targetClass = UserRole.class, fetch = FetchType.LAZY)
	@CollectionTable(name = "appuser_role", joinColumns = @JoinColumn(name = "user_id"))
	@Column
	private Set<UserRole> roles;

	public User() {
	}

	public User(String username, String password, Set<UserRole> roles) {
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public User(String username, String email, String password, boolean isEnabled) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.isEnabled = isEnabled;
	}

	@Override
	public String toString() {
		return "User{" +
				"user_id=" + userId +
				", username='" + username + '\'' +
				", email='" + email + '\'' +
				",isEnabled" + isEnabled + '\'' +
				", password='" + password + '\'' +
				", roles='" + roles + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User) o;
		return Objects.equals(username, user.username) &&
				Objects.equals(email, user.email) &&
				Objects.equals(password, user.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(username, email, password);
	}
}


