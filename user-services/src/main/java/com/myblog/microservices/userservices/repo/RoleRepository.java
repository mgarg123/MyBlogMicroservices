package com.myblog.microservices.userservices.repo;

import com.myblog.microservices.userservices.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
