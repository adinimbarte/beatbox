package com.music.player.beatbox.service;

import com.music.player.beatbox.dto.PlaylistDTO;
import com.music.player.beatbox.dto.SongDTO;
import com.music.player.beatbox.model.Playlist;

import com.music.player.beatbox.model.Song;
import com.music.player.beatbox.model.User;
import com.music.player.beatbox.repository.PlaylistRepository;
import com.music.player.beatbox.repository.SongRepository;
import com.music.player.beatbox.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final UserRepository userRepository;
    private final SongRepository songRepository;

    public PlaylistDTO createPlaylist(String username, PlaylistDTO dto) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Playlist playlist = Playlist.builder()
                .name(dto.getName())
                .user(user)
                .build();

        Playlist saved = playlistRepository.save(playlist);
        return toDTO(saved);
    }

    public List<PlaylistDTO> getUserPlaylists(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return playlistRepository.findByUser(user).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public PlaylistDTO addSongToPlaylist(String username, Long playlistId, Long songId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
        Song song = songRepository.findById(songId)
                .orElseThrow(() -> new RuntimeException("Song not found"));

        playlist.getSongs().add(song);
        return toDTO(playlistRepository.save(playlist));
    }

    public PlaylistDTO removeSongFromPlaylist(String username, Long playlistId, Long songId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
        Song song = songRepository.findById(songId)
                .orElseThrow(() -> new RuntimeException("Song not found"));

        playlist.getSongs().remove(song);
        return toDTO(playlistRepository.save(playlist));
    }

    private PlaylistDTO toDTO(Playlist playlist) {
        PlaylistDTO dto = new PlaylistDTO();
        dto.setId(playlist.getId());
        dto.setName(playlist.getName());
        dto.setSongs(playlist.getSongs().stream().map(s -> {
            var songDto = new SongDTO();
            songDto.setId(s.getId());
            songDto.setTitle(s.getTitle());
            songDto.setArtist(s.getArtist());
            songDto.setGenre(s.getGenre());
            songDto.setDuration(s.getDuration());
            return songDto;
        }).collect(Collectors.toList()));
        return dto;
    }
}