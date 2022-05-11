package com.example.sii.booking;

import com.example.sii.event.Event;
import com.example.sii.user.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

  private final BookingRepository bookingRepository;


  @Override
  public int countOFParticipatesOfEvent(Event event) {
    return bookingRepository.countBookingByEvent(event);
  }

  @Override
  public List<Booking> getMyBookings(User user) {
    return bookingRepository.findAllByUser(user);
  }

  @Override
  public Booking saveBooking(Booking booking) {
    return bookingRepository.save(booking);
  }

  @Override
  public boolean doesHaveOtherLecture(int hour, User user) {

    return bookingRepository.countBookingByUserAndHourOfEvent(hour, user) != 0;
  }
}
