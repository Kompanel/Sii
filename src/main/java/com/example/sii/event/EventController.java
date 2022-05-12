package com.example.sii.event;

import com.example.sii.event.dto.EventDetailsDTO;
import com.example.sii.event.dto.EventInterest;
import com.example.sii.event.dto.SubjectInterest;
import com.example.sii.user.dto.UserLoginDTO;
import com.example.sii.user.dto.UserRegisterDTO;
import io.swagger.v3.oas.annotations.Operation;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
public class EventController {

  private final EventService eventService;

  @GetMapping
  @Operation(summary = "Return a list of Events")
  public List<EventDetailsDTO> getAllEvents() {
    return eventService.getAllEventsForPublic();
  }

  @PostMapping("register/{eventId}")
  @Operation( summary = "Register user to the event")
  public ResponseEntity<Event> registerToEvent(@PathVariable UUID eventId,
      @RequestBody UserRegisterDTO user) throws IOException {
    return eventService.registerToEvent(eventId, user);
  }

  @PostMapping("myEvents")
  @Operation(summary = "Show my events")
  public ResponseEntity<List<Event>> getMyEvents(@RequestBody UserLoginDTO userLoginDTO) {
    return eventService.getMyEvents(userLoginDTO);
  }

  @DeleteMapping("{eventId}")
  @Operation(summary = "resign from event")
  public ResponseEntity<Object> resignFromEvent(@PathVariable UUID eventId, UserLoginDTO userLoginDTO) {
    return eventService.resignFromEvent(eventId, userLoginDTO);
  }

  @GetMapping("lectureInterest")
  @Operation(summary = "get interest rate of lectures")
  public List<EventInterest> getLectureInterest() {
    return eventService.getLectureInterest();
  }

  @GetMapping("subjectInterest")
  @Operation(summary = "get interest rate of subjects")
  public List<SubjectInterest> getSubjectInterest() {
    return eventService.getSubjectInterest();
  }

}
