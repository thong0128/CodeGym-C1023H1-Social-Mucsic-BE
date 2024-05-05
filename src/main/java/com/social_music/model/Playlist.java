package com.social_music.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private AppUser appUser;
    private String title;
}
