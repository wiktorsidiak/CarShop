package com.sidiak.CarShop.repository;

import java.util.List;

import com.sidiak.CarShop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = User.class, idClass = String.class)
public interface UserRepo extends JpaRepository<User, String> {

    User save(User user);

    void delete(User user);

    User findUsername(String username);

    User findPassword(String password);

    User findByUsername(String username);
}
