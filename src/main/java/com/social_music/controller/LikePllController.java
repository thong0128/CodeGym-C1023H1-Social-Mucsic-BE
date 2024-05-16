package com.social_music.controller;

import com.social_music.model.LikesPll;
import com.social_music.service.impl.LikePllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("likePll")
public class LikePllController {

    @Autowired
    private LikePllService likePllService;

    @GetMapping("/{uid}/{pllId}")
    public ResponseEntity<Iterable<LikesPll>> findAll(@PathVariable Long uid, @PathVariable Long pllId) {
        return new ResponseEntity<>(likePllService.getAllByUIdAndPllId(uid, pllId), HttpStatus.OK);
    }

    @PostMapping("/{uid}/{pllId}")
    public ResponseEntity<?> create(@PathVariable Long uid, @PathVariable Long pllId) {
        return new ResponseEntity<>(likePllService.saveOrUpdate(uid, pllId), HttpStatus.OK);
    }

    @GetMapping("/isLiked/{uid}/{pllId}")
    public ResponseEntity<Boolean> isLiked(@PathVariable Long uid, @PathVariable Long pllId) {
        return new ResponseEntity<>(likePllService.isLiked(uid, pllId), HttpStatus.OK);
    }

}
