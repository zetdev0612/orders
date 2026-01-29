package com.zetdev.orders.infrastructure.config.security;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;

}