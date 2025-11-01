package com.music.player.beatbox.repository;

import com.music.player.beatbox.model.Playlist;
import com.music.player.beatbox.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist,Long> {
    List<Playlist> findByUser(User user);
}
