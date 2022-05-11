package com.example.sii.event;

import com.example.sii.event.dto.EventDetailsDTO;
import com.example.sii.user.dto.UserLoginDTO;
import com.example.sii.user.dto.UserRegisterDTO;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("events")
public class EventController {

  private final EventService eventService;

  @GetMapping
  public List<EventDetailsDTO> getAllEvents() {
    return eventService.getAllEventsForPublic();
  }

  @PostMapping("register/{eventId}")
  public ResponseEntity<Event> registerToEvent(@PathVariable UUID eventId,
      @RequestBody UserRegisterDTO user) throws IOException {
    return eventService.registerToEvent(eventId, user);
  }

  @PostMapping("myEvents")
  public ResponseEntity<List<Event>> getMyEvents(@RequestBody UserLoginDTO userLoginDTO) {
    return eventService.getMyEvents(userLoginDTO);
  }

  @DeleteMapping("{eventId}")
  public ResponseEntity<Object> resignFromEvent(@PathVariable UUID eventId, UserLoginDTO userLoginDTO) {
    return eventService.resignFromEvent(eventId, userLoginDTO);
  }

}
