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
    public User getUserName(String username) {
        return userRepo.findUsername(username);
    }

    @Override
    public User getUserPassword(String password) {
        return userRepo.findPassword(password);
    }

    @Override
    public void deleteUser(User userId) {
        userRepo.delete(userId);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
    }
}
