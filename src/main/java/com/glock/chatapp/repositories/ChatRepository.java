package com.glock.chatapp.repositories;

import com.glock.chatapp.model.ChatModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<ChatModel, Long> {

}
