package com.music.player.beatbox.dto;


import lombok.Data;

@Data
public class SongDTO {
    private Long id;
    private String title;
    private String artist;
    private String genre;
    private Integer duration;   // in seconds
}
