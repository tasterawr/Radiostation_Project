package org.example.DAL.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String songName;

    @ManyToOne(cascade = CascadeType.ALL)
    private Album album;

    private Integer duration;

    private Integer monthlyOrders;

    @ManyToMany(mappedBy = "songs", cascade = CascadeType.ALL)
    private Set<Playlist> playlists;

    public Song() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getMonthlyOrders() {
        return monthlyOrders;
    }

    public void setMonthlyOrders(Integer monthlyOrders) {
        this.monthlyOrders = monthlyOrders;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    private Integer rating;
}
