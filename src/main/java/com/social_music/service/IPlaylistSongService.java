package com.social_music.service;

import com.social_music.model.PlaylistSong;
import com.social_music.model.Song;

public interface IPlaylistSongService extends GeneralService<PlaylistSong> {

    Iterable<Song> getSongsByPlaylistId(long playlistId);

    void removeSongFromPlaylist(long playlistId, long songId);

    void removeBySongId(Long songId);

    PlaylistSong addSongToPll(Long pllId, Long songId);

    boolean existSongInPlayList(Long pllId, Long songId);

}
