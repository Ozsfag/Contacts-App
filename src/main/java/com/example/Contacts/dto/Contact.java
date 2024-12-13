package com.example.Contacts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Contact {
  private String fullName;
  private String phoneNumber;
  private String email;

  @Override
  public String toString() {
    return "fullName= "
        + fullName
        + " | "
        + "phoneNumber= "
        + phoneNumber
        + " | "
        + "email= "
        + email;
  }
}
