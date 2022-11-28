package com.glock.chatapp.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "chats")
public class ChatModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="user_chats",
            joinColumns = @JoinColumn(name="chat_id"),
            inverseJoinColumns = @JoinColumn(name="user_id")
    )
    private List<UserModel> users = new ArrayList<>();

    @OneToMany(mappedBy = "chat")
    private Set<MessageModel> messages = new TreeSet<>();

    public ChatModel() {}

    public void addUser(UserModel userModel) {
        this.users.add(userModel);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }

    public Set<MessageModel> getMessages() {
        return messages;
    }

    public void setMessages(Set<MessageModel> messages) {
        this.messages = messages;
    }
}
