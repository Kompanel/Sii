package com.example.sii.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

  List<User> getAllUsers();

  Optional<User> getUser(UUID id);

  Boolean existByEmail(String email);

  Boolean existByUsername(String username);

  User saveUser(User user);

  Optional<User> getUserByUsername(String username);
}
