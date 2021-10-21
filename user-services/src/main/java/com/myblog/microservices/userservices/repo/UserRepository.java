package com.myblog.microservices.userservices.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myblog.microservices.userservices.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	 Optional<User> findByUsername(String username);
}
