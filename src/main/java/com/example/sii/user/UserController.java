package com.example.sii.user;

import com.example.sii.user.dto.UserChangingEmailDTO;
import com.example.sii.user.dto.UserRegisterDTO;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

  private final UserService userService;

  @PutMapping("changeEmail")
  @Operation(summary = "change email")
  ResponseEntity<Object> changeEmail(@RequestBody UserChangingEmailDTO userChangingEmailDTO) {
    return userService.changeEmail(userChangingEmailDTO);
  }

  @GetMapping("registeredUsers")
  @Operation(summary = "get all registered users")
  List<UserRegisterDTO> getAllUsers(){
    return userService.getAllRegisteredUsers();
  }

}
