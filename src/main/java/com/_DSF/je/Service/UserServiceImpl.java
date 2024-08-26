package com._DSF.je.Service.Impl;

import com._DSF.je.Entity.User;
import com._DSF.je.Repository.UserRepository;
import com._DSF.je.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        // No password encoding, just save the user
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        // No password check, just return the user if found
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
