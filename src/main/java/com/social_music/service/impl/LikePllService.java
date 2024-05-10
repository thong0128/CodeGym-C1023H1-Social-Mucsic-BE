package com.social_music.service.impl;

import com.social_music.model.*;
import com.social_music.repository.*;
import com.social_music.service.ILikePllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikePllService implements ILikePllService {

    @Autowired
    private LikePllRepository likePllRepository;
    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private AppUserRepository userRepository;


    @Override
    public Iterable<LikesPll> findAll() {
        return likePllRepository.findAll();
    }

    @Override
    public Optional<LikesPll> findById(Long id) {
        return likePllRepository.findById(id);
    }

    @Override
    public LikesPll save(LikesPll likesPll) {
        return likePllRepository.save(likesPll);
    }

    @Override
    public void remove(Long id) {
        likePllRepository.deleteById(id);
    }

    public LikesPll saveOrUpdate(Long uid, Long pllId) {
        LikesPll likesPll = new LikesPll();
        Playlist playlist = playlistRepository.findById(pllId).orElse(null);
        AppUser user = userRepository.findById(uid).orElse(null);
        LikesPll currentLikesPll = likePllRepository.findLikesPllByAppUserIdAndPlaylistId(uid, pllId);

        if (currentLikesPll == null){
            likesPll.setPlaylist(playlist);
            likesPll.setAppUser(user);
            likesPll.setLikeStatus(true);
            playlist.setCountLike(playlist.getCountLike()+1);
            playlistRepository.save(playlist);
            likePllRepository.save(likesPll);
        } else {
            likePllRepository.deleteById(currentLikesPll.getId());
            playlist.setCountLike(playlist.getCountLike()>0? playlist.getCountLike()-1: 0);
            playlistRepository.save(playlist);
        }
        return currentLikesPll;
    }

    @Override
    public Iterable<LikesPll> getAllByUIdAndPllId(Long uid, Long pllId) {
        return likePllRepository.findAllByAppUserIdAndPlaylistId(uid, pllId);
    }

    @Override
    public Boolean isLiked(Long uid, Long pllId) {
        return likePllRepository.existsByAppUserIdAndPlaylistId(uid, pllId);
    }
}
