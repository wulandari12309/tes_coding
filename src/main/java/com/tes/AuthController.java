package com.tes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UserService userService;

//    @PostMapping("/login")
//    public String login(@RequestBody LoginRequest request) {
//        User user = userService.authenticateUser(request.getUsername(), request.getPassword());
//        if (user != null) {
//            // Create a session and return session info (e.g., session ID or token)
//            return "Login successful";
//        }
//        return "Invalid credentials";
//    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        userService.registerUser(request.getUsername(), request.getPassword());
        return "User registered successfully";
    }
}
