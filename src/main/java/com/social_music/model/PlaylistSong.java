package com.social_music.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PlaylistSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Playlist playlist;
    @ManyToOne
    private Song song;
}
