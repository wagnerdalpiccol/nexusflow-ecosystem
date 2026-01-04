package com.nexusflow.notification_service.domain.event;

import java.util.UUID;

public record UserCreatedEvent(
 UUID id,
 String name,
 String email
) {}
