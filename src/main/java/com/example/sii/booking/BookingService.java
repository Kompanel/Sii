package com.example.sii.booking;

import com.example.sii.event.Event;
import com.example.sii.user.User;
import java.util.List;

public interface BookingService {

  int countOFParticipatesOfEvent(Event event);

  List<Booking> getMyBookings(User user);
}
