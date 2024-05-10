package com.social_music.repository;

import com.social_music.model.LikesPll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikePllRepository extends CrudRepository<LikesPll, Long> {

    Iterable<LikesPll> findAllByAppUserIdAndPlaylistId(Long playlistId, Long userId);

    LikesPll findLikesPllByAppUserIdAndPlaylistId(Long userId, Long playlistId);

    Boolean existsByAppUserIdAndPlaylistId(Long userId, Long playlistId);

}
