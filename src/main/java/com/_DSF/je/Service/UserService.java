package com._DSF.je.Service;

import com._DSF.je.Entity.User;
import com._DSF.je.Enumeration.Role;
import com._DSF.je.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(String username, String email, String password, String role) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email already in use.");
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);  // Storing plain text password
        user.setRole(Role.valueOf(role));

        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found.");
        }

        User user = userOpt.get();
        if (!user.getPassword().equals(password)) {  // Checking plain text password
            throw new RuntimeException("Invalid password.");
        }

        return user;
    }
}
