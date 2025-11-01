package com.music.player.beatbox.dto;


import com.music.player.beatbox.enums.PlaybackStatus;
import lombok.Data;

@Data
public class PlaybackStatusDTO {
    private String currentSongTitle;
    private String artist;
    private PlaybackStatus status;  // PLAYING, PAUSED, STOPPED
}
