package com.social_music.repository;

import com.social_music.model.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepo extends CrudRepository<Song, Long> {

    Iterable<Song> findSongByAppUserId(Long appUser_id);

    Song findSongById (Long id);

    Iterable<Song> findSongByTitleContaining(String title);

    Iterable<Song> findSongByAuthorContaining(String artist);

    Iterable<Song> findSongBySingerContaining(String singer);

    Iterable<Song> findAllByOrderByDateDesc();

    Iterable<Song> findAllByOrderByListenCountDesc();

    Iterable<Song> findAllByOrderByCountLikeDesc();
}
