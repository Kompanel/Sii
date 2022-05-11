package com.example.sii.booking;

import com.example.sii.event.Event;
import com.example.sii.user.User;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookingRepository extends JpaRepository<Booking, UUID> {

  int countBookingByEvent(Event event);

  List<Booking> findAllByEvent(Event event);

  List<Booking> findAllByUser(User user);

  @Query("select count(b) from Booking b where b.user = :user and b.event.hour = :hour")
  int countBookingByUserAndHourOfEvent(@Param("hour") int hour, @Param("user") User user);
}
