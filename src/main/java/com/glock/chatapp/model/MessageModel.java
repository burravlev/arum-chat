package com.glock.chatapp.model;

import jakarta.persistence.*;
import org.aspectj.bridge.Message;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="messages")
public class MessageModel implements Comparable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "")
    private UserModel sender;
    @ManyToOne
    @JoinColumn(name = "")
    private UserModel receiver;

    private Date sentAt;
    @ManyToOne
    @JoinColumn(name="chat_id", nullable=false)
    private ChatModel chat;

    public MessageModel() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserModel getSender() {
        return sender;
    }

    public void setSender(UserModel sender) {
        this.sender = sender;
    }

    public UserModel getReceiver() {
        return receiver;
    }

    public void setReceiver(UserModel receiver) {
        this.receiver = receiver;
    }

    public Date getSentAt() {
        return sentAt;
    }

    public void setSentAt(Date sentAt) {
        this.sentAt = sentAt;
    }

    public ChatModel getChat() {
        return chat;
    }

    public void setChat(ChatModel chat) {
        this.chat = chat;
    }

    @Override
    public int compareTo(Object o) {
        MessageModel that = (MessageModel) o;
        return -1 * this.sentAt.compareTo(that.sentAt);
    }
}
