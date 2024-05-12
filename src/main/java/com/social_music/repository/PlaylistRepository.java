package com.social_music.repository;

import com.social_music.model.Playlist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Long> {

    Iterable<Playlist> findAllByAppUserId(long appUserId);

    Playlist findById(long id);

    Iterable<Playlist> findPlaylistByTitleContaining(String title);

    @Query(nativeQuery = true,value = "SELECT * FROM playlist WHERE app_user_id != :uId ORDER BY count_like DESC LIMIT 6")
    Iterable<Playlist> findSuggestPlaylist(@Param("uId") Long uId);

}
