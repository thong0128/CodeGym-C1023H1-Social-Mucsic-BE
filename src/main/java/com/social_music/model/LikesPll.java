package com.social_music.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class LikesPll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Playlist playlist;
    @ManyToOne
    private AppUser appUser;
    private boolean likeStatus;
}
