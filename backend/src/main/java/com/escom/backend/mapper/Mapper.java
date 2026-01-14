package com.escom.backend.mapper;

import com.escom.backend.dto.UserDTO;
import com.escom.backend.model.User;

public class Mapper {
  // Mapeo de User a UserDTO
  public static UserDTO toUserDTO(User user) {
    if (user == null) return null;

    return UserDTO.builder()
        .id(user.getId().toString())
        .username(user.getUsername())
        .email(user.getEmail())
        .build();
  }

  public static User toUser(UserDTO userDTO) {
    if (userDTO == null) return null;

    return User.builder()
        .username(userDTO.getUsername())
        .password(userDTO.getPassword())
        .email(userDTO.getEmail())
        .build();
  }

}
