package rogs.Axon.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import rogs.Axon.api.dto.UserRegistrationRequest;
import rogs.Axon.core.Service.UserService;

public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
            this.userService = userService;
        }

    public ResponseEntity<?> register(@RequestBody UserRegistrationRequest request) {
        try {
            userService.register(request);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
}
