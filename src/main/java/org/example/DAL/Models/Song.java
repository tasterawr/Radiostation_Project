package org.example.DAL.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String songName;

    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Album album;

    private Integer duration;

    private Integer monthlyOrders;

    @JsonBackReference
    @ManyToMany(mappedBy = "songs", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Playlist> playlists = new HashSet<>();

    private Integer rating;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) && Objects.equals(songName, song.songName) && Objects.equals(album, song.album) && Objects.equals(duration, song.duration) && Objects.equals(monthlyOrders, song.monthlyOrders) && Objects.equals(playlists, song.playlists) && Objects.equals(rating, song.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, songName, album, duration, monthlyOrders, playlists, rating);
    }

    public void removePlaylist(Playlist playlist){
        playlists.remove(playlist);
    }
}
