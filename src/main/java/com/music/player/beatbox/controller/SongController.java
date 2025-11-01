package com.music.player.beatbox.controller;

import com.music.player.beatbox.dto.SongDTO;
import com.music.player.beatbox.model.Song;
import com.music.player.beatbox.service.SongService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api/songs")
public class SongController {
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping
    public ResponseEntity<SongDTO> addSong(@RequestBody SongDTO song) {
        return ResponseEntity.ok(songService.addSong(song));
    }

    @GetMapping
    public ResponseEntity<List<SongDTO>> getAllSongs() {
        return ResponseEntity.ok(songService.getAllSongs());
    }

    @GetMapping("/search")
    public ResponseEntity<List<SongDTO>> searchSongs(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String artist,
            @RequestParam(required = false) String genre) {
        return ResponseEntity.ok(songService.searchSongs(title, artist, genre));
    }
}

