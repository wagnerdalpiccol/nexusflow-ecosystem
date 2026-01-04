package com.nexusflow.notification_service.infrastructure.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.nexusflow.notification_service.domain.event.UserCreatedEvent;

@Component
public class UserRegistrationListener {

	@KafkaListener(topics = "user-registration", groupId = "notification-group")
	public void listen(UserCreatedEvent event) {
	    System.out.println("-------------------------------------------------------");
	    System.out.println("NOTIFICAÇÃO: Recebido novo usuário do Kafka!");
	    System.out.println("Bem-vindo: " + event.name() + " (" + event.email() + ")");
	    System.out.println("-------------------------------------------------------");
	}
}
