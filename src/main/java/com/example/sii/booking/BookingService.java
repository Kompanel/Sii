package com.example.sii.booking;

import com.example.sii.event.Event;
import com.example.sii.user.User;
import java.util.List;

public interface BookingService {

  int countOFParticipatesOfEvent(Event event);

  List<Booking> getMyBookings(User user);

  Booking saveBooking(Booking booking);

  boolean doesHaveOtherLecture(int hour, User user);

  List<Booking> getAllBookings();

  boolean removeBookingByUserAndEvent(User user, Event event);
}
