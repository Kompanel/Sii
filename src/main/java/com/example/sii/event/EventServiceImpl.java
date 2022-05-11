package com.example.sii.event;

import com.example.sii.booking.Booking;
import com.example.sii.booking.BookingService;
import com.example.sii.constraint.Constraints;
import com.example.sii.user.User;
import com.example.sii.user.UserRegisterDTO;
import com.example.sii.user.UserService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

  private final EventRepository eventRepository;

  private final UserService userService;

  private final BookingService bookingService;

  @Override
  public List<EventDetailsDTO> getAllEventsForPublic() {

    return eventRepository
        .findAll()
        .stream()
        .map(this::eventToEventDetailsDTO)
        .collect(Collectors.toList());
  }

  @Override
  @Transactional
  public ResponseEntity registerToEvent(UUID eventId, UserRegisterDTO userRegisterDTO) {

    Optional<Event> optionalEvent = eventRepository.findById(eventId);

    if (optionalEvent.isEmpty())
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event does not exists");

    Event event = optionalEvent.get();

    if (bookingService.countOFParticipatesOfEvent(event) >= 5)
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Room full");

    Optional<User> optionalUser = userService.getUserByUsername(userRegisterDTO.getUsername());

    User user;

    if (optionalUser.isPresent()) {
      user = optionalUser.get();
      if (!userRegisterDTO.getEmail().equals(user.getEmail()))
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already taken");
    } else
      user = userService.saveUser(new User(userRegisterDTO.getUsername(), userRegisterDTO.getEmail()));

    if (bookingService.doesHaveOtherLecture(event.getHour(), user))
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already registered in this or another lecture in this hour");

    bookingService.saveBooking(new Booking(user, event));

    return ResponseEntity.status(HttpStatus.OK).body(eventToEventDetailsDTO(event));
  }

  private EventDetailsDTO eventToEventDetailsDTO(Event event) {
    return EventDetailsDTO.builder()
        .id(event.getId())
        .title(event.getTitle())
        .room(event.getRoom())
        .hours(Constraints.hours.get(event.getHour()))
        .participates(bookingService.countOFParticipatesOfEvent(event))
        .build();
  }

}
