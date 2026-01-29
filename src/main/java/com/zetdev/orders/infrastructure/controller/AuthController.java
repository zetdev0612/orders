package com.zetdev.orders.infrastructure.controller;

import com.zetdev.orders.infrastructure.config.security.AuthenticationRequest;
import com.zetdev.orders.infrastructure.config.security.JwtService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthenticationRequest authenticationRequest) {


        String username = authenticationRequest.getUsername();
        String token = jwtService.generateToken(username);

        return Map.of("token", token);
    }
}
