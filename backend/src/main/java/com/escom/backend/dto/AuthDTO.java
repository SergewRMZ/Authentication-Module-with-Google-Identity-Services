package com.escom.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthDTO {
  private UserDTO user;
  private String token;
}
