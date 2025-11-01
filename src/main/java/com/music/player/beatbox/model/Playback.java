package com.music.player.beatbox.model;

import com.music.player.beatbox.enums.PlaybackStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "playback")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Playback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song currentSong;

    @Enumerated(EnumType.STRING)
    private PlaybackStatus status;  // PLAYING, PAUSED, STOPPED
}