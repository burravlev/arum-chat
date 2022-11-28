package com.glock.chatapp.service;

import com.glock.chatapp.dto.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User getByUsername(String username);
}
