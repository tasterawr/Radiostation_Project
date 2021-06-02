package org.example.DAL.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String albumName;

    @ManyToOne(cascade = CascadeType.ALL)
    private Genre genre;

    @ManyToOne(cascade = CascadeType.ALL)
    private Artist artist;

    private Integer numberOfTracks;

    @ManyToOne(cascade = CascadeType.ALL)
    private Label label;

    public Album() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Integer getNumberOfTracks() {
        return numberOfTracks;
    }

    public void setNumberOfTracks(Integer numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id) && Objects.equals(albumName, album.albumName) && Objects.equals(genre, album.genre) && Objects.equals(artist, album.artist) && Objects.equals(numberOfTracks, album.numberOfTracks) && Objects.equals(label, album.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, albumName, genre, artist, numberOfTracks, label);
    }
}
