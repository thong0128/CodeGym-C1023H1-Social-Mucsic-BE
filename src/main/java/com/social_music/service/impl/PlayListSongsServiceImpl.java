package com.social_music.service.impl;

import com.social_music.model.PlayList;
import com.social_music.model.PlayListSongs;
import com.social_music.model.Song;
import com.social_music.repository.PLayListRepo;
import com.social_music.repository.PlayListSongsRepo;
import com.social_music.repository.SongRepo;
import com.social_music.service.IPlayListSongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayListSongsServiceImpl implements IPlayListSongsService {
    @Autowired
    private PlayListSongsRepo playListSongsRepo;
    @Autowired
    private PLayListRepo pLayListRepo;
    @Autowired
    private SongRepo songRepo;

    @Override
    public Iterable<PlayListSongs> findAll() {
        return playListSongsRepo.findAll();
    }

    @Override
    public Optional<PlayListSongs> findById(Long id) {
        return playListSongsRepo.findById(id);
    }

    @Override
    public PlayListSongs save(PlayListSongs playListSongs) {
        return playListSongsRepo.save(playListSongs);
    }

    @Override
    public void remove(Long id) {
        playListSongsRepo.deleteById(id);
    }


    public PlayListSongs savePlaylistSong(Long pllId, Long songId){
        PlayListSongs playListSongs = new PlayListSongs();
        Optional<PlayList> playList = pLayListRepo.findById(pllId);
        Optional<Song> song = songRepo.findById(songId);
        playListSongs.setPlayList(playList.get());
        playListSongs.setSong(song.get());
        return playListSongsRepo.save(playListSongs);
    }

    @Override
    public boolean existSongInPlayList(Long pllId, Long songId) {
        return playListSongsRepo.existsByPlayListIdAndSongId(pllId, songId);
    }
}
