package com.sidiak.CarShop.model.User;

import javax.persistence.*;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public UserRole(){

    }

    public UserRole(String name) {
        this.name = name;
    }

}
