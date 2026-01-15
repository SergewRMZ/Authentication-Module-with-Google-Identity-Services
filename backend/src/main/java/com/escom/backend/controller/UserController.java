package com.escom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escom.backend.dto.AuthDTO;
import com.escom.backend.dto.UserDTO;
import com.escom.backend.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
  @Autowired
  private UserService userService;
  
  @PostMapping("/register")
  public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDto) {
    UserDTO registeredUser = userService.register(userDto);
    return ResponseEntity.ok(registeredUser);
  }

  @PostMapping("/google")
  public ResponseEntity<AuthDTO> login(@AuthenticationPrincipal Jwt jwt) {
    AuthDTO authDTO = userService.loginWithGoogle(jwt);
    return ResponseEntity.ok(authDTO);
  }
}
