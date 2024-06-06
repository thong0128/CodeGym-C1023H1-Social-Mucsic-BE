package com.social_music.service.song;

import com.social_music.model.AppUser;
import com.social_music.model.Likes;
import com.social_music.model.Song;
import com.social_music.repository.AppUserRepository;
import com.social_music.repository.LikeRepository;
import com.social_music.repository.SongRepo;
import com.social_music.service.AppUserService;
import com.social_music.service.impl.AppUserServiceImpl;
import com.social_music.service.impl.LikeService;
import com.social_music.service.impl.SongServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class SongServiceTest {
    private SongRepo songRepo = Mockito.mock(SongRepo.class);
    private SongServiceImpl songService = new SongServiceImpl(songRepo);

    private AppUserRepository appUserRepo = Mockito.mock(AppUserRepository.class);
    private AppUserServiceImpl appUserService = new AppUserServiceImpl(appUserRepo);

    private LikeRepository likeRepo = Mockito.mock(LikeRepository.class);
    private LikeService likeService = new LikeService(likeRepo);

    @BeforeEach
    void init() {
        Song song = new Song();
        song.setId(1L);
        song.setTitle("Song1");
        List<Song> songs = Arrays.asList(song);
        doReturn(songs).when(songRepo).findAll();
        doReturn(Optional.of(song)).when(songRepo).findById(1L);


        AppUser appUser = new AppUser();
        appUser.setId(1L);
        appUser.setUserName("username1");


    }

    @Test
    @DisplayName("findAll can return list is not null")
    public void whenFindAllNotNull() {
        assertThat(songService.findAll()).isNotNull();
    }

    @Test
    @DisplayName("findAll can return a list has 1 element")
    public void whenfindAll_thenReturnListHasOneElement() {
        Iterable<Song> categories = songService.findAll();
        assertThat(categories).hasSize(1);
    }

    @Test
    @DisplayName("findbyID 2L return isPresent")
    public void whenfindById_thenReturnSongisPresent() {
        Optional<Song> categories = songService.findById(2L);
        assertThat(categories.isPresent()).isFalse();
    }

    @Test
    @DisplayName("save song use songRepo.save")
    void save () {
        Song song = new Song();
        song.setId(1L);
        song.setTitle("Song1");
        songService.save(song);
        verify(songRepo,times(1)).save(song);
    }

    @Test
    @DisplayName("delete like by songID before delete song")
    void delete() {
        Likes likes = new Likes();
        likes.setId(1L);
        likes.setLikeStatus(true);
        songService.remove(1L);
        verify(songRepo,times(1)).deleteById(1L);
    }

}
