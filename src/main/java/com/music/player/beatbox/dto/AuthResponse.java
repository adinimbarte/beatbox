package com.music.player.beatbox.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

// Auth Response
@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String username;
    private String role;
}
