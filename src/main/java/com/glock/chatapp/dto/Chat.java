package com.glock.chatapp.dto;

import com.glock.chatapp.model.ChatModel;
import com.glock.chatapp.model.MessageModel;

import java.util.Set;
import java.util.stream.Collectors;

public class Chat {
    private Long id;
    private String owner;
    private String companion;

    private Set<MessageModel> messages;
    public Chat() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCompanion() {
        return companion;
    }

    public void setCompanion(String companion) {
        this.companion = companion;
    }

    public Set<MessageModel> getMessages() {
        return messages;
    }

    public void setMessages(Set<MessageModel> messages) {
        this.messages = messages;
    }

    public Chat(String username, ChatModel chatModel) {
        this.id = chatModel.getId();
        this.owner = username;
        this.companion = chatModel.getUsers()
                .stream().filter(user -> !user.getUsername().equals(username))
                .findFirst().orElse(null).getUsername();
    }
}
