package com.example.sii.email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Email {

  private String username;

  private String email;

  private String hour;

  private String title;

  private int room;

  @Override
  public String toString() {
    return "[email: " + email
        + ", username: " + username + ", title: " + title
        + ", hour: " + hour + ", room: " + room + "]";
  }
}
