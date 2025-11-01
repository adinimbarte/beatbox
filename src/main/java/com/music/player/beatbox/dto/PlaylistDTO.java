package com.music.player.beatbox.dto;

import lombok.Data;
import java.util.List;

@Data
public class PlaylistDTO {
    private Long id;
    private String name;
    private List<SongDTO> songs;
}
