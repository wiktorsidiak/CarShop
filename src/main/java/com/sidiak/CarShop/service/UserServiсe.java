package com.sidiak.CarShop.service;

import com.sidiak.CarShop.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiсe extends UserDetailsService {

    User saveUser(User user);

    User getUserName(String username);

    User getUserPassword(String password);

    void deleteUser(User userId);

    User findByUsername(String username);


}
