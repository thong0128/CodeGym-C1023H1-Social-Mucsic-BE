package com.social_music.service;


import com.social_music.repository.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@WebMvcTest(ISongService.class)
public class SongServiceTest {
    @MockBean
    private SongRepo songRepo;

    @Autowired
    private ISongService songService;
}
