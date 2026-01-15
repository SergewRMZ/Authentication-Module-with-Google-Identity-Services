package com.escom.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDTO {
  private String id;
  private String username;
  @JsonIgnore
  private String password;
  private String email;
}
