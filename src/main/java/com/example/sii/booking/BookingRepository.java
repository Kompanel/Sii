package com.example.sii.booking;

import com.example.sii.event.Event;
import com.example.sii.user.User;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, UUID> {

  int countBookingByEvent(Event event);

  List<Booking> findAllByEvent(Event event);

  List<Booking> findAllByUser(User user);

}
