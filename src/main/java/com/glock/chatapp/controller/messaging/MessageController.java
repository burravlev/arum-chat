package com.glock.chatapp.controller.messaging;

import com.glock.chatapp.dto.Message;
import com.glock.chatapp.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
    private SimpMessagingTemplate template;

    @Autowired
    public MessageController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/message")
    @SendTo("/message/public")
    private Message received(@Payload Message message) {
        return message;
    }

    @MessageMapping("/private")
    public Message privateMessage(@Payload Message message) {
        //send to /user/username/private
        template.convertAndSendToUser(message.getReceiver(), "/private", message);
        System.out.println(message.getContent());
        return message;
    }
}
