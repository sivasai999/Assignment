package com.LBG.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LBG.authservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
