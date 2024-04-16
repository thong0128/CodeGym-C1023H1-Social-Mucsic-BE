package com.social_music.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private String author;
    private String singer;
    private String genre;
    private String album;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
