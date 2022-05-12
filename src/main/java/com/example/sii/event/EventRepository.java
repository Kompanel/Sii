package com.example.sii.event;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {

  @Query("select distinct e.title from Event e")
  List<String> getListOfSubjects();

  List<Event> findAllByTitle(String title);
}
