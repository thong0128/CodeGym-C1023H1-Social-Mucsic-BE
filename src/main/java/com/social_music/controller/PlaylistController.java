package com.social_music.controller;

import com.social_music.model.Playlist;
import com.social_music.model.PlaylistSong;
import com.social_music.model.Song;
import com.social_music.service.impl.PlaylistService;
import com.social_music.service.impl.PlaylistSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/playlist")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;
    @Autowired
    private PlaylistSongService playlistSongService;

    @GetMapping("")
    public ResponseEntity<Iterable<Playlist>> getAllPlaylist() {
        return new ResponseEntity<>(playlistService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{pid}")
    public ResponseEntity<Optional<Playlist>> getPlaylistById(@PathVariable Long pid) {
        return new ResponseEntity<>(playlistService.findById(pid), HttpStatus.OK);
    }

    @GetMapping("/song/{id}")
    public ResponseEntity<Iterable<Song>> getPlaylistSongs(@PathVariable long id) {
        return new ResponseEntity<>(playlistSongService.getSongsByPlaylistId(id), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Iterable<Playlist>> getPlaylistUsers(@PathVariable long id) {
        return new ResponseEntity<>(playlistService.getAllPlaylistsByAppUserId(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPlaylist(@RequestBody Playlist playlist) {
        return new ResponseEntity<>(playlistService.save(playlist), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlaylist(@PathVariable long id) {
        playlistService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/song/{id}&{sid}")
    public ResponseEntity<?> deletePlayListSong(@PathVariable long id, @PathVariable long sid) {
        playlistSongService.removeSongFromPlaylist(id, sid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping ("/song/create/{pllId}/{sId}")
    public ResponseEntity<PlaylistSong> createPlaylistSong(@PathVariable Long pllId, @PathVariable Long sId) {
        return new ResponseEntity<>(playlistSongService.addSongToPll(pllId, sId), HttpStatus.CREATED);
    }

    @GetMapping("/song/check/{pllId}/{sId}")
    public ResponseEntity<?> checkPlSong (@PathVariable Long pllId, @PathVariable Long sId) {
        return new ResponseEntity<>(playlistSongService.existSongInPlayList(pllId, sId), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Playlist playlist) {
        return new ResponseEntity<>(playlistService.save(playlist),HttpStatus.OK);
    }
}
