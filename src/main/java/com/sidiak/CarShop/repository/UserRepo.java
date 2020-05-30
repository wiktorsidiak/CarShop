package com.sidiak.CarShop.repository;

import com.sidiak.CarShop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = User.class, idClass = String.class)
public interface UserRepo extends JpaRepository<User, String> {
    User save(User user);

    User update(User user);

    void delete(User user);

    User findByUserName(String username);
}
