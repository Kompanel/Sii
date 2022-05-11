package com.example.sii.email;

import com.example.sii.event.dto.EventDetailsDTO;
import com.example.sii.user.dto.UserRegisterDTO;
import java.io.IOException;

public interface EmailService {

  void sendConfirmationEmail(UserRegisterDTO userRegisterDTO, EventDetailsDTO eventDetailsDTO);

}
