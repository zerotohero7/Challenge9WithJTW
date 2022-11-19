package com.example.Spring.Security.using.Spring.Data.JPA.MySQL.Spring.Boot.Repositories;

import com.example.Spring.Security.using.Spring.Data.JPA.MySQL.Spring.Boot.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    Optional<User> findByUserName(String username);

    Optional<User> findByEmail(String username);
}
