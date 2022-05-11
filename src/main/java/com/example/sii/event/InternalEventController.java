package com.example.sii.event;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/event")
public class InternalEventController {

  private final EventService eventService;

  @GetMapping
  private List<Event> getAllEvents() {
    return eventService.getAllEvents();
  }

}
