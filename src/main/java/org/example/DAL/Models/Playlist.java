package org.example.DAL.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.example.util.HibernateUtil;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Playlist {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String playlistName;

    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Playlist_songs",
            joinColumns = { @JoinColumn(name = "playlist_id") },
            inverseJoinColumns = { @JoinColumn(name = "song_id") }
    )
    private List<Song> songs = new ArrayList<>();

    public List<Song> getSongs() {
        return songs;
    }

    @ManyToMany(mappedBy = "playlists",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RadioProgram> programs = new HashSet<>();

    public Playlist() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    @Transactional
    public void addSong(Song song){
        songs.add(song);
    }

    public void removeSong(Song song){
        songs.removeIf(x -> x.getId() == song.getId());
        return;
    }
}
