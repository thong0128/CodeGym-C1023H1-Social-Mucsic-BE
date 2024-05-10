package com.social_music.repository;

import com.social_music.model.Playlist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Long> {
    Iterable<Playlist> findAllByAppUserId(long appUserId);
    Playlist findById(long id);

}
