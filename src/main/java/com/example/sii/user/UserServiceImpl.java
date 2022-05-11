package com.example.sii.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

  private final UserRepository userRepository;

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public Optional<User> getUser(UUID id) {
    return userRepository.findById(id);
  }

  @Override
  public Boolean existByEmail(String email) {
    return userRepository.existsByEmail(email);
  }

  @Override
  public Boolean existByUsername(String username) {
    return userRepository.existsByUsername(username);
  }

  @Override
  public User saveUser(User user) {
    return userRepository.save(user);
  }

}
