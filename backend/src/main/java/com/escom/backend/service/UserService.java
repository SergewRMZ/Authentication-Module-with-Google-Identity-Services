package com.escom.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.escom.backend.dto.UserDTO;
import com.escom.backend.mapper.Mapper;
import com.escom.backend.repository.UserRepository;
import com.escom.backend.model.User;

@Service
public class UserService {
  @Autowired
  private UserRepository repo;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public UserDTO register(UserDTO userDto) {
    if(repo.findByEmail(userDto.getEmail()).isPresent()) {
      throw new RuntimeException("El correo ya está registrado");
    }
    var user = User.builder()
      .username(userDto.getUsername())
      .email(userDto.getEmail())
      .password(passwordEncoder.encode(userDto.getPassword()))
      .build();
      
    return Mapper.toUserDTO(repo.save(user));
  }
}
