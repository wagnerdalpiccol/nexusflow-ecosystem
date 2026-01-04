package com.nexusflow.auth_service.domain.event;

import java.util.UUID;

public record UserCreatedEvent(
 UUID id,
 String name,
 String email
) {}