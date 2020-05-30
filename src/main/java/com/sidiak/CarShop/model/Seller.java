package com.sidiak.CarShop.model;

import javax.persistence.*;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seller extends User {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "seller", targetEntity = Car.class, cascade = CascadeType.ALL)
    private List<Car> cars;

    public Seller(String username, String email, String password, boolean isActive, String firstName, String lastName, String phoneNumber) {
        super(username, email, password, isActive);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
}
