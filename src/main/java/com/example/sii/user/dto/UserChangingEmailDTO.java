package com.example.sii.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserChangingEmailDTO {

  private String username;

  private String previousEmail;

  private String newEmail;

}
