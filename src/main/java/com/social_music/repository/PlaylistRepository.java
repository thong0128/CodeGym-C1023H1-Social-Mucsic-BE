package com.social_music.repository;

import com.social_music.model.Playlist;
import com.social_music.model.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Long> {

    Iterable<Playlist> findAllByAppUserId(long appUserId);

    Playlist findById(long id);

    Iterable<Playlist> findPlaylistByTitleContaining(String title);

    @Query(nativeQuery = true,value = "SELECT * FROM playlist ORDER BY RAND() LIMIT 6")
    Iterable<Playlist> findRandomPlaylist();

}
