package com.social_music.service.impl;

import com.social_music.model.Playlist;
import com.social_music.model.PlaylistSong;
import com.social_music.model.Song;
import com.social_music.repository.PlaylistRepository;
import com.social_music.repository.PlaylistSongRepository;
import com.social_music.repository.SongRepo;
import com.social_music.service.IPlaylistSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        ArrayList<Song> songList = new ArrayList<>();
        for (PlaylistSong song : playlistSongRepository.findAllSongByPlaylistId(playlistId)) {
            songList.add(song.getSong());
        }
        return songList;
    }

    @Override
    public void removeSongFromPlaylist(long playlistId, long songId) {
        playlistSongRepository.deletePlaylistSong(playlistId, songId);
    }

    @Override
    public void removeBySongId(Long songId) {
        playlistSongRepository.deleteBySongId(songId);
    }

    @Override
    public PlaylistSong addSongToPll(Long pllId, Long songId) {
        PlaylistSong playlistSong = new PlaylistSong();
        Optional<Playlist> playList = playlistRepository.findById(pllId);
        Optional<Song> song = songRepository.findById(songId);
        playlistSong.setPlaylist(playList.get());
        playlistSong.setSong(song.get());
        return playlistSongRepository.save(playlistSong);
    }

    @Override
    public boolean existSongInPlayList(Long pllId, Long songId) {
        return  playlistSongRepository.existsByPlaylistIdAndSongId(pllId, songId);
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
