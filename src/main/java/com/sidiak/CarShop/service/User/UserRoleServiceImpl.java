package com.sidiak.CarShop.service.User;

import com.sidiak.CarShop.model.User.UserRole;
import com.sidiak.CarShop.repository.UserRoleRepo;
import com.sidiak.CarShop.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleRepo userRoleRepo;

    @Override
    public UserRole findRoleById(Long id) {
        return userRoleRepo.findRoleById(id);
    }
}
