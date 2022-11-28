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



    @Override
    public int compareTo(Object o) {
        MessageModel that = (MessageModel) o;
        return -1 * this.sentAt.compareTo(that.sentAt);
    }
}
