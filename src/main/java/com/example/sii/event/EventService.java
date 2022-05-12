package com.example.sii.event;

import com.example.sii.event.dto.EventDetailsDTO;
import com.example.sii.event.dto.EventInterest;
import com.example.sii.event.dto.SubjectInterest;
import com.example.sii.user.dto.UserLoginDTO;
import com.example.sii.user.dto.UserRegisterDTO;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;

public interface EventService {

  List<EventDetailsDTO> getAllEventsForPublic();

  ResponseEntity<Event> registerToEvent(UUID eventId, UserRegisterDTO user) throws IOException;

  ResponseEntity<List<Event>> getMyEvents(UserLoginDTO userLoginDTO);

  List<Event> getAllEvents();

  ResponseEntity<Object> resignFromEvent(UUID eventId, UserLoginDTO userLoginDTO);

  List<EventInterest> getLectureInterest();

  List<SubjectInterest> getSubjectInterest();
}
