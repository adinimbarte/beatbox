package com.music.player.beatbox.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class SongDTO {
    private Long id;
    private String title;
    private String artist;
    private String genre;
    private Integer duration;   // in seconds
}
