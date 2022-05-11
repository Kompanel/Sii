package com.example.sii.email;

import com.example.sii.constraint.Constraints;
import com.example.sii.event.dto.EventDetailsDTO;
import com.example.sii.user.dto.UserRegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

  private final EmailRepository emailRepository;

  @Override
  public void sendConfirmationEmail(UserRegisterDTO userRegisterDTO,
      EventDetailsDTO eventDetailsDTO) {

    emailRepository.saveNotification(
        Email.builder()
        .username(userRegisterDTO.getUsername())
        .email(userRegisterDTO.getEmail())
        .title(eventDetailsDTO.getTitle())
        .room(eventDetailsDTO.getRoom())
        .hour(eventDetailsDTO.getHours())
        .build()
    );

  }
}
