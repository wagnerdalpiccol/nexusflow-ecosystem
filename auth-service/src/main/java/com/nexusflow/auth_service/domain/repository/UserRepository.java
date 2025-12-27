package com.nexusflow.auth_service.domain.repository;

import com.nexusflow.auth_service.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
