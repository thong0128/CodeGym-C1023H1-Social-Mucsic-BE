package com.social_music.service;

import com.social_music.model.PlayListSongs;

public interface IPlayListSongsService extends GeneralService<PlayListSongs> {

    PlayListSongs savePlaylistSong(Long pllId, Long songId);

    boolean existSongInPlayList(Long pllId, Long songId);
}
