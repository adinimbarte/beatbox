package com.music.player.beatbox.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor

// User Profile Response
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String role;
}