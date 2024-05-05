package com.social_music.service.impl;

import com.social_music.model.PlaylistSong;
import com.social_music.model.Song;
import com.social_music.repository.PlaylistRepository;
import com.social_music.repository.PlaylistSongRepository;
import com.social_music.repository.SongRepo;
import com.social_music.service.IPlaylistSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistSongService implements IPlaylistSongService {
    @Autowired
    private PlaylistSongRepository playlistSongRepository;
    @Autowired
    private SongRepo songRepository;
    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public Iterable<Song> getSongsByPlaylistId(long playlistId) {
        return playlistSongRepository.findAllSongByPlaylistId(playlistId);
    }

//    @Override
//    public PlaylistSong addSongToPlaylist(long playlistId, long songId) {
//        return playlistSongRepository.addSongToPlaylistSong(playlistId, songId);
//    }

    @Override
    public void removeSongFromPlaylist(long playlistId, long songId) {
        playlistSongRepository.deleteByPlaylistIdAndSongId(playlistId, songId);
    }

    @Override
    public Iterable<PlaylistSong> findAll() {
        return playlistSongRepository.findAll();
    }

    @Override
    public Optional<PlaylistSong> findById(Long id) {
        return playlistSongRepository.findById(id);
    }

    @Override
    public PlaylistSong save(PlaylistSong playlistSong) {
        return playlistSongRepository.save(playlistSong);
    }

    @Override
    public void remove(Long id) {
        playlistSongRepository.deleteById(id);
    }
}
