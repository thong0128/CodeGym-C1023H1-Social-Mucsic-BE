package com.social_music.controller;

import com.social_music.model.Song;
import com.social_music.service.impl.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private SongServiceImpl songService;
    @GetMapping
    public ResponseEntity<Iterable<Song>> findAll() {
        return new ResponseEntity<>(songService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/songs/{id}")
    public ResponseEntity<Optional<Song>> findOne(@PathVariable Long id) {
        return new ResponseEntity<>(songService.findById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createSong(@RequestBody Song song) {
        return new ResponseEntity<>(songService.save(song),HttpStatus.CREATED);
    }

}