package com.example.sii.user;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

  Boolean existsByEmail(String email);

  Boolean existsByUsername(String username);

  Optional<User> findByUsername(String username);
}
