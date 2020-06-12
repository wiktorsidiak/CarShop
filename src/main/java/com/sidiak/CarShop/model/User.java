package com.sidiak.CarShop.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Objects;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = { "username", "email" }))
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
    @OneToOne(optional = false, mappedBy = "user", targetEntity = Seller.class)
    private Seller seller;



    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' + +
                '}';
    }

    public User(Long userId, String username, String email, String password) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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



