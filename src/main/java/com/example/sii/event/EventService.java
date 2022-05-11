package com.example.sii.event;

import com.example.sii.user.UserRegisterDTO;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;

public interface EventService {

  List<EventDetailsDTO> getAllEventsForPublic();

  ResponseEntity<Event> registerToEvent(UUID eventId, UserRegisterDTO user);
}
