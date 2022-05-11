package com.example.sii.event;

import com.example.sii.user.UserLoginDTO;
import java.util.List;

public interface EventService {

  List<EventDetailsDTO> getAllEventsForPublic();

  List<Event> getMyEvents(UserLoginDTO userLoginDTO);
}
