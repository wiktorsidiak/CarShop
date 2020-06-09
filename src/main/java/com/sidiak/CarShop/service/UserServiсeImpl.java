package com.sidiak.CarShop.service;

import com.sidiak.CarShop.model.User;
import com.sidiak.CarShop.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiсeImpl implements UserServiсe {

    @Autowired
    UserRepo userRepo;

    @Override
    public User saveUser(User user) {
        User newUser = userRepo.save(user);
        return user;
    }

    @Override
    public void deleteUser(User userId) {
        userRepo.delete(userId);
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
