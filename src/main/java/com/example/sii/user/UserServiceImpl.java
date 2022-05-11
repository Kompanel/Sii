package com.example.sii.user;

import com.example.sii.user.dto.UserChangingEmailDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

  @Override
  public Optional<User> getUserByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  @Override
  @Transactional
  public ResponseEntity changeEmail(UserChangingEmailDTO userChangingEmailDTO) {
    Optional<User> optionalUser = userRepository.findByUsername(userChangingEmailDTO.getUsername());

    if (optionalUser.isEmpty())
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");

    User user = optionalUser.get();

    if (!user.getEmail().equals(userChangingEmailDTO.getPreviousEmail()))
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad email");

    user.setEmail(userChangingEmailDTO.getNewEmail());
    userRepository.save(user);

    return ResponseEntity.status(HttpStatus.OK).body("Success");
  }

}
