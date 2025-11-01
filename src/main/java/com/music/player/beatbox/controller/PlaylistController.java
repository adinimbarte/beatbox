package com.music.player.beatbox.controller;

import com.music.player.beatbox.dto.PlaylistDTO;
import com.music.player.beatbox.service.PlaylistService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/playlists")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class PlaylistController {

    private final PlaylistService playlistService;

    @PostMapping
    public ResponseEntity<PlaylistDTO> createPlaylist(@RequestBody PlaylistDTO playlistDTO,
                                                      Authentication authentication) {
        return ResponseEntity.ok(playlistService.createPlaylist(authentication.getName(), playlistDTO));
    }

    @GetMapping
    public ResponseEntity<List<PlaylistDTO>> getUserPlaylists(Authentication authentication) {
        return ResponseEntity.ok(playlistService.getUserPlaylists(authentication.getName()));
    }

    @PostMapping("/{playlistId}/songs/{songId}")
    public ResponseEntity<PlaylistDTO> addSongToPlaylist(@PathVariable Long playlistId,
                                                         @PathVariable Long songId,
                                                         Authentication authentication) {
        return ResponseEntity.ok(playlistService.addSongToPlaylist(authentication.getName(), playlistId, songId));
    }

    @DeleteMapping("/{playlistId}/songs/{songId}")
    public ResponseEntity<PlaylistDTO> removeSongFromPlaylist(@PathVariable Long playlistId,
                                                              @PathVariable Long songId,
                                                              Authentication authentication) {
        return ResponseEntity.ok(playlistService.removeSongFromPlaylist(authentication.getName(), playlistId, songId));
    }
}