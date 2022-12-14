package com.glock.chatapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("chats")
    public String chats() {
        return "chat/chat-menu";
    }
}
