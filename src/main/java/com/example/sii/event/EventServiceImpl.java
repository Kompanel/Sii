package com.example.sii.event;

import com.example.sii.booking.BookingService;
import com.example.sii.constraint.Hours;
import com.example.sii.user.UserLoginDTO;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

  private final EventRepository eventRepository;

  private final BookingService bookingService;

  @Override
  public List<EventDetailsDTO> getAllEventsForPublic() {

    List<Event> events = eventRepository.findAll();
    List<EventDetailsDTO> detailsDTOS = new ArrayList<>();

    events.forEach(event ->
        detailsDTOS.add(EventDetailsDTO.builder()
            .id(event.getId())
            .title(event.getTitle())
            .room(event.getRoom())
            .hours(Hours.lecture.get(event.getHour()))
            .participates(bookingService.countOFParticipatesOfEvent(event))
            .build())
    );

    return detailsDTOS;
  }

  @Override
  public List<Event> getMyEvents(UserLoginDTO userLoginDTO) {
    return null;
  }

}
