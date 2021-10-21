package com.myblog.microservices.userservices.controller;

import com.myblog.microservices.userservices.model.AuthRequest;
import com.myblog.microservices.userservices.model.AuthResponse;
import com.myblog.microservices.userservices.model.User;
import com.myblog.microservices.userservices.model.UserEvent;
import com.myblog.microservices.userservices.security.JwtUserDetailService;
import com.myblog.microservices.userservices.service.UserService;
import lombok.RequiredArgsConstructor;
//import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final JwtUserDetailService userDetailService;
    private final UserService userService;
//    private final StreamBridge streamBridge;

    static final String USER_CREATED_OUTPUT = "userCreatedOutput";

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) throws Exception {
        return userDetailService.createJwtToken(request);
    }

    @PostMapping("/register")
    public User registerNewUser(@RequestBody User user) {
        User newUser = userService.createNewUser(user);
//        UserEvent userEvent = UserEvent.builder().username(newUser.getUsername()).email(newUser.getEmail()).build();
//        boolean sent = streamBridge.send(USER_CREATED_OUTPUT, userEvent);
//        System.out.println("Message sent " + sent);
        return newUser;
    }
}