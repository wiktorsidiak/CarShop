package com.sidiak.CarShop.model.User;

import javax.persistence.*;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String name;


    public UserRole(){

    }

    public UserRole(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
