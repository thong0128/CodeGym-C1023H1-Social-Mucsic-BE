package com.social_music.repository;

import com.social_music.model.PlayListSongs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayListSongsRepo extends CrudRepository<PlayListSongs, Long> {

    boolean existsByPlayListIdAndSongId(Long pllId, Long sId);

}
