package com.music.player.beatbox.service;

import com.music.player.beatbox.dto.PlaybackStatusDTO;
import com.music.player.beatbox.enums.PlaybackStatus;
import com.music.player.beatbox.model.Playback;
import com.music.player.beatbox.model.Song;
import com.music.player.beatbox.repository.SongRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class PlaybackService {

    private final SongRepository songRepository;

    // In-memory store: user -> playback state
    private final ConcurrentHashMap<String, PlaybackStatusDTO> playbackMap = new ConcurrentHashMap<>();

    public PlaybackStatusDTO play(String username, Long songId) {
        Song song = songRepository.findById(songId)
                .orElseThrow(() -> new RuntimeException("Song not found"));

        PlaybackStatusDTO dto = new PlaybackStatusDTO();
        dto.setCurrentSongTitle(song.getTitle());
        dto.setArtist(song.getArtist());
        dto.setStatus(PlaybackStatus.PLAYING);

        playbackMap.put(username, dto);
        return dto;
    }

    public PlaybackStatusDTO pause(String username) {
        PlaybackStatusDTO dto = playbackMap.get(username);
        if (dto == null) throw new RuntimeException("No song playing");
        dto.setStatus(PlaybackStatus.PAUSED);
        return dto;
    }

    public PlaybackStatusDTO resume(String username) {
        PlaybackStatusDTO dto = playbackMap.get(username);
        if (dto == null) throw new RuntimeException("No song to resume");
        dto.setStatus(PlaybackStatus.PLAYING);
        return dto;
    }

    public PlaybackStatusDTO stop(String username) {
        PlaybackStatusDTO dto = playbackMap.get(username);
        if (dto == null) throw new RuntimeException("No song to stop");
        dto.setStatus(PlaybackStatus.STOPPED);
        return dto;
    }

    public PlaybackStatusDTO getCurrent(String username) {
        return playbackMap.getOrDefault(username, null);
    }
}