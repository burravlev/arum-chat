package com.glock.chatapp.service;

import com.glock.chatapp.dto.User;
import com.glock.chatapp.model.UserModel;
import com.glock.chatapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAll().stream().map(user -> new User(user)).collect(Collectors.toList());
        return users;
    }

    @Override
    public User getByUsername(String username) {
        return new User(userRepository.findByUsername(username));
    }
}
