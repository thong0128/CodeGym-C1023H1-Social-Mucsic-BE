package com.social_music.service;

import com.social_music.model.Playlist;

public interface IPlaylistService extends GeneralService<Playlist> {
    Iterable<Playlist> getAllPlaylistsByAppUserId(Long appUserId);
}
