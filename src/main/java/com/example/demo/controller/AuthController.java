package com.example.demo.controller;

import com.example.demo.model.PrimaryUser;
import com.example.demo.repository.PrimaryUserRepository;
import com.example.demo.service.PrimaryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin(origins = "http://farmvetconnect.vercel.app")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private PrimaryUserService userService;

    @Autowired
    private PrimaryUserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody PrimaryUser registerRequest) {
        String response = userService.registerUser(registerRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<PrimaryUser> login(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        Optional<PrimaryUser> userOpt = userRepository.findByUsername(username);

        if (userOpt.isPresent()) {
            PrimaryUser user = userOpt.get();
            if (Objects.equals(password, user.getPassword())) {
                String userName = user.getUsername();
                return ResponseEntity.ok(user);
            }
        }
        return (ResponseEntity<PrimaryUser>) ResponseEntity.status(401);
    }
}
