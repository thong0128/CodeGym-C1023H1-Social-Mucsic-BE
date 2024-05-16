package com.social_music.repository;

import com.social_music.model.PlaylistSong;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PlaylistSongRepository extends CrudRepository<PlaylistSong, Long> {

    Iterable<PlaylistSong> findAllSongByPlaylistId(Long playlist_id);

    void deleteAllByPlaylistId(Long playlist_id);

    @Modifying
    @Query(nativeQuery = true,value = "delete from playlist_song where playlist_song.playlist_id = :id1 and playlist_song.song_id = :id2")
    void deletePlaylistSong(@Param("id1")Long pid, @Param("id2")Long sid);

    boolean existsByPlaylistIdAndSongId(Long pllId, Long sId);

    void deleteBySongId(Long playlist_id);

}
