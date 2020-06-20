package com.sidiak.CarShop.service.User;

import com.sidiak.CarShop.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiсe extends UserDetailsService {


    boolean saveUser(User user);

    void deleteUser(User userId);

    User findByUsername(String username);


}
