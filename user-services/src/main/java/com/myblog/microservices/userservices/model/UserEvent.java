package com.myblog.microservices.userservices.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEvent {
    private String username;
    private String email;
}
