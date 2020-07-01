package com.sidiak.CarShop.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "appuser", uniqueConstraints = @UniqueConstraint(columnNames = { "username", "email" }))
@Getter
@Setter
public class User implements UserDetails {
	@NotNull
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long userId;

	@NotNull
	@Size(min = 4, max = 12)
	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@Size(min = 8, max = 16)
	@Column(name = "password")
	private String password;

	@OneToOne(optional = false, mappedBy = "user")
	private Seller seller;

	@ManyToMany
	private Collection<Role> roles;

	public User() {
	}

	public User(Long userId, String username, String email, String password, Collection<Role> roles) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User{" +
				"user_id=" + userId +
				", username='" + username + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", role='" + roles + '\'' +
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}


