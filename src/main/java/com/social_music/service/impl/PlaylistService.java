package com.social_music.service.impl;

import com.social_music.model.Playlist;
import com.social_music.repository.PlaylistRepository;
import com.social_music.repository.PlaylistSongRepository;
import com.social_music.service.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistService implements IPlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private PlaylistSongRepository playlistSongRepository;
    @Override
    public Iterable<Playlist> getAllPlaylistsByAppUserId(Long appUserId) {
        return playlistRepository.findAllByAppUserId(appUserId);
    }

    @Override
    public Iterable<Playlist> getPlaylistsByTitle(String title) {
        return playlistRepository.findPlaylistByTitleContaining(title);
    }

    @Override
    public Iterable<Playlist> getSuggestPlaylist(Long uId) {
        return playlistRepository.findSuggestPlaylist(uId);
    }

    @Override
    public Iterable<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public Optional<Playlist> findById(Long id) {
        return playlistRepository.findById(id);
    }

    @Override
    public Playlist save(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public void remove(Long id) {
        playlistSongRepository.deleteAllByPlaylistId(id);
        playlistRepository.deleteById(id);
    }
}
