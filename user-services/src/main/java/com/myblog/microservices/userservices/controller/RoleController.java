package com.myblog.microservices.userservices.controller;

import com.myblog.microservices.userservices.model.Role;
import com.myblog.microservices.userservices.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping
    public Role createNewRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }
}
