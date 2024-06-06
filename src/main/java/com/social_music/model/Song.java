package com.social_music.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String img_url;
    private String song_url;
    private String author;
    private String singer;
    private String album;
    @CreationTimestamp
    private Date date;
    private int countLike = 0;
    private boolean likes;
    @ManyToOne
    private SongTypes songTypes;
    @ManyToOne
    private AppUser appUser;
    private Long listenCount = 0L;

    public Song(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
