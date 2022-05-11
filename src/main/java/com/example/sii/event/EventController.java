package com.example.sii.event;

import com.example.sii.user.UserLoginDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
  private List<EventDetailsDTO> getAllEvents() {
    return eventService.getAllEventsForPublic();
  }

  @PostMapping("myEvents")
  private List<Event> getMyEvents(@RequestBody UserLoginDTO userLoginDTO) {
    return eventService.getMyEvents(userLoginDTO);
  }


}
