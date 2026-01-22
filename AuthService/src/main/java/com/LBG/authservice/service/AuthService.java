package com.LBG.authservice.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.LBG.authservice.dto.AuthResponse;
import com.LBG.authservice.dto.LoginRequest;
import com.LBG.authservice.dto.RegisterRequest;
import com.LBG.authservice.entity.Role;
import com.LBG.authservice.entity.User;
import com.LBG.authservice.repository.RoleRepository;
import com.LBG.authservice.repository.UserRepository;
import com.LBG.authservice.security.JwtUtil;

@Service
public class AuthService {
	@Autowired
    private  UserRepository userRepository;
	@Autowired
    private   RoleRepository roleRepository;
	@Autowired
    private  PasswordEncoder passwordEncoder;

	@Autowired
	private  JwtUtil jwtUtil;

    public void register(RegisterRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Role userRole = roleRepository.findByName("USER");

        if (userRole == null) {
            throw new RuntimeException("Default role USER not found");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(Set.of(userRole));

        userRepository.save(user);
    }
    
    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername());

        if (user == null) {
            throw new RuntimeException("Invalid username or password");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        List<String> roles = user.getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toList());

        String token = jwtUtil.generateToken(
                user.getUsername(),
                user.getId(),
                roles
        );

        return new AuthResponse(token);
}
}
