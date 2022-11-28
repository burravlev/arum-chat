package com.glock.chatapp.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @ManyToMany(mappedBy = "users")
    private Set<ChatModel> chats;

    public UserModel() {}

    public void addChat(ChatModel chatModel) {
        this.chats.add(chatModel);
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

    public Set<ChatModel> getChats() {
        return chats;
    }

    public void setChats(Set<ChatModel> chats) {
        this.chats = chats;
    }
}
