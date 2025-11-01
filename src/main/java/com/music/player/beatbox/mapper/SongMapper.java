package com.music.player.beatbox.mapper;
import com.music.player.beatbox.dto.SongDTO;
import com.music.player.beatbox.model.Song;

public class SongMapper {

    public static SongDTO toDTO(Song song) {
        if (song == null) {
            return null;
        }
        return SongDTO.builder()
                .id(song.getId())
                .title(song.getTitle())
                .artist(song.getArtist())
                .genre(song.getGenre())
                .duration(song.getDuration())
                .build();
    }

    public static Song toEntity(SongDTO songDTO) {
        if (songDTO == null) {
            return null;
        }
        return Song.builder()
                .id(songDTO.getId())
                .title(songDTO.getTitle())
                .artist(songDTO.getArtist())
                .genre(songDTO.getGenre())
                .duration(songDTO.getDuration())
                .build();
    }
}
