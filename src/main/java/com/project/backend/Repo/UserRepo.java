package com.project.backend.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.project.backend.Entity.User;


@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
    
    Optional<User> findOneByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);
}
