package com.social_music.service;

import com.social_music.model.LikesPll;
import com.social_music.model.Playlist;

public interface ILikePllService extends GeneralService<LikesPll> {
    Iterable<LikesPll> getAllByUIdAndPllId(Long uid, Long pllId);

    Boolean isLiked(Long uid, Long pllId);
}
