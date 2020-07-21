package com.sidiak.CarShop.repository;

import java.util.Optional;

import com.sidiak.CarShop.model.User.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Long> {

        UserRole findRoleById(Long id);

        UserRole findByname(String name);
}
