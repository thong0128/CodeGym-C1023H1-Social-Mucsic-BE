package com.social_music.repository;

import com.social_music.model.PlaylistSong;
import com.social_music.model.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistSongRepository extends CrudRepository<PlaylistSong, Long> {
    Iterable<Song> findAllSongByPlaylistId(Long playlist_id);
    void deleteAllByPlaylistId(Long playlist_id);
    Iterable<PlaylistSong> findPlaylistSongByPlaylistId(Long playlist_id);
    void deleteByPlaylistIdAndSongId(Long playlist_id, Long song_id);
}
