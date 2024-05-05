package com.social_music.service;

import com.social_music.model.PlaylistSong;
import com.social_music.model.Song;

public interface IPlaylistSongService extends GeneralService<PlaylistSong> {
    Iterable<Song> getSongsByPlaylistId(long playlistId);
//    PlaylistSong addSongToPlaylist(long playlistId, long songId);
    void removeSongFromPlaylist(long playlistId, long songId);
}
