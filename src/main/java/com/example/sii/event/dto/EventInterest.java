package com.example.sii.event.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EventInterest {

  private String subject;

  private String hour;

  private String percentOfInterest;

}
