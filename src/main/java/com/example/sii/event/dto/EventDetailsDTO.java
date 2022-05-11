package com.example.sii.event.dto;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventDetailsDTO {

  private UUID id;

  private String title;

  private int room;

  private String hours;

  private int participates;

}
