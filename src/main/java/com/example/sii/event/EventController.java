package com.example.sii.event;

import com.example.sii.user.UserRegisterDTO;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
      @RequestBody UserRegisterDTO user) {
    return eventService.registerToEvent(eventId, user);
  }

}
