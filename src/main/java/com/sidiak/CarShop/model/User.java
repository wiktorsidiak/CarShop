package com.sidiak.CarShop.model;

import javax.persistence.*;

import java.util.Objects;
import java.util.UUID;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email"}))
@Getter
@Setter

public class User {
    @NotNull
    @Column(name = "user_id")
    UUID userId;
    @NotNull
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
    @Column(name = "is_active")
    private boolean isActive;

    @OneToOne(optional = false, mappedBy = "user", targetEntity = Seller.class)
    private Seller seller;



    public User(String username, String email, String password, boolean isActive) {
    }

    public User(UUID userId, String username, String email, String password, boolean isActive) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", is_ctive=" + isActive +
                '}';
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
}



