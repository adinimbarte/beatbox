package com.music.player.beatbox.controller;

import com.music.player.beatbox.dto.PlaybackStatusDTO;
import com.music.player.beatbox.service.PlaybackService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;


@RestController
@RequestMapping("/playback")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class PlaybackController {

    private final PlaybackService playbackService;

    @PostMapping("/play/{songId}")
    public ResponseEntity<PlaybackStatusDTO> play(@PathVariable Long songId, Authentication authentication) {
        return ResponseEntity.ok(playbackService.play(authentication.getName(), songId));
    }

    @PostMapping("/pause")
    public ResponseEntity<PlaybackStatusDTO> pause(Authentication authentication) {
        return ResponseEntity.ok(playbackService.pause(authentication.getName()));
    }

    @PostMapping("/resume")
    public ResponseEntity<PlaybackStatusDTO> resume(Authentication authentication) {
        return ResponseEntity.ok(playbackService.resume(authentication.getName()));
    }

    @PostMapping("/stop")
    public ResponseEntity<PlaybackStatusDTO> stop(Authentication authentication) {
        return ResponseEntity.ok(playbackService.stop(authentication.getName()));
    }

    @GetMapping("/current")
    public ResponseEntity<PlaybackStatusDTO> getCurrent(Authentication authentication) {
        return ResponseEntity.ok(playbackService.getCurrent(authentication.getName()));
    }
}