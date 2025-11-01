package com.music.player.beatbox.service;

import com.music.player.beatbox.dto.SongDTO;
import com.music.player.beatbox.model.Song;


import com.music.player.beatbox.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;

    public SongDTO addSong(SongDTO dto) {
        Song song = Song.builder()
                .title(dto.getTitle())
                .artist(dto.getArtist())
                .genre(dto.getGenre())
                .duration(dto.getDuration())
                .build();
        Song saved = songRepository.save(song);
        dto.setId(saved.getId());
        return dto;
    }

    public List<SongDTO> getAllSongs() {
        return songRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<SongDTO> searchSongs(String artist , String title, String genre) {
        return songRepository.findAll().stream()
                .filter(s -> (title == null || s.getTitle().toLowerCase().contains(title.toLowerCase())) &&
                        (artist == null || s.getArtist().toLowerCase().contains(artist.toLowerCase())) &&
                        (genre == null || s.getGenre().equalsIgnoreCase(genre)))
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private SongDTO toDTO(Song song) {
        SongDTO dto = new SongDTO();
        dto.setId(song.getId());
        dto.setTitle(song.getTitle());
        dto.setArtist(song.getArtist());
        dto.setGenre(song.getGenre());
        dto.setDuration(song.getDuration());
        return dto;
    }

}