package com.glock.chatapp.dto;

import com.glock.chatapp.model.UserModel;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class User {
    private Long id;
    private String username;
    private Set<Chat> chats = new TreeSet<>();

    public User() {}

    public User(UserModel userModel) {
        this.id = userModel.getId();
        this.username = userModel.getUsername();
        this.chats = userModel.getChats().stream().map(chat -> new Chat(username, chat)).collect(Collectors.toSet());
    }

    public void addChat(Chat chat) {
        chats.add(chat);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Chat> getChats() {
        return chats;
    }

    public void setChats(Set<Chat> chats) {
        this.chats = chats;
    }
}
