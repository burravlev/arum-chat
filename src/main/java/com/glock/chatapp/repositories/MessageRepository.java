package com.glock.chatapp.repositories;

import com.glock.chatapp.model.MessageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageModel, Long> {

}
