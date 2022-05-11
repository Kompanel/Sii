package com.example.sii.user;

import com.example.sii.user.dto.UserChangingEmailDTO;
import com.example.sii.user.dto.UserRegisterDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.http.ResponseEntity;

public interface UserService {

  List<User> getAllUsers();

  User saveUser(User user);

  Optional<User> getUserByUsername(String username);

  ResponseEntity<Object> changeEmail(UserChangingEmailDTO userChangingEmailDTO);

  List<UserRegisterDTO> getAllRegisteredUsers();
}
