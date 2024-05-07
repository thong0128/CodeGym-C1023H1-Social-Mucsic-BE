package com.social_music.service;

import com.social_music.model.Likes;

public interface ILikeService extends GeneralService<Likes> {
    boolean checkPlaylistLike(long userId, long playlistId);
    Likes playlistLikeAction(long playlistId, long userId);
}
