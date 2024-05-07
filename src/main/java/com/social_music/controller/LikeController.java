package com.social_music.controller;

import com.social_music.model.Likes;
import com.social_music.service.impl.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/songs")
public class LikeController {
    @Autowired
    private LikeService likeService;
    @GetMapping("/likes/{uid}/{sid}")
    public ResponseEntity<Iterable<Likes>> findAll(@PathVariable Long uid, @PathVariable Long sid) {
        return new ResponseEntity<>(likeService.findAllBySongIdAndUserId(sid, uid), HttpStatus.OK);
    }
    @PostMapping("/likes/{uid}/{sid}")
    public ResponseEntity<?> likeSong(@PathVariable Long uid, @PathVariable Long sid) {
        return new ResponseEntity<>(likeService.saveOrUpdate(uid, sid), HttpStatus.OK);
    }
    @GetMapping("/users/likes/{uid}/{sid}")
    public ResponseEntity<Boolean> checkLikeByUserIdAndSongId(@PathVariable Long uid, @PathVariable Long sid) {
        return new ResponseEntity<>(likeService.checkLikeByUserId(uid, sid), HttpStatus.OK);
    }
    @GetMapping("/playlist/likes/{uid}/{pid}")
    public ResponseEntity<Boolean> checkLikeByPlaylistIdAndUserId(@PathVariable Long uid, @PathVariable Long pid) {
        return new ResponseEntity<>(likeService.checkPlaylistLike(uid, pid), HttpStatus.OK);
    }
    @PostMapping("/playlist/likes/{uid}/{pid}")
    public ResponseEntity<?> likePlaylist(@PathVariable Long uid, @PathVariable Long pid) {
        return new ResponseEntity<>(likeService.playlistLikeAction(uid, pid), HttpStatus.OK);
    }
}
