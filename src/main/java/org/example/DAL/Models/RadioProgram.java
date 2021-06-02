package org.example.DAL.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class RadioProgram {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String radioProgramName;

    private Integer monthlyListeners;

    private Integer songOrderPrice;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Program_playlists",
            joinColumns = { @JoinColumn(name = "program_id") },
            inverseJoinColumns = { @JoinColumn(name = "playlist_id") }
    )
    private List<Playlist> playlists = new ArrayList<>();

    public RadioProgram() {

    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRadioProgramName() {
        return radioProgramName;
    }

    public void setRadioProgramName(String radioProgramName) {
        this.radioProgramName = radioProgramName;
    }

    public Integer getMonthlyListeners() {
        return monthlyListeners;
    }

    public void setMonthlyListeners(Integer monthlyListeners) {
        this.monthlyListeners = monthlyListeners;
    }

    public Integer getSongOrderPrice() {
        return songOrderPrice;
    }

    public void setSongOrderPrice(Integer songOrderPrice) {
        this.songOrderPrice = songOrderPrice;
    }

    public void addPlaylist(Playlist playlist){
        playlists.add(playlist);
    }

    public void removePlaylist(Playlist playlist){
        playlists.removeIf(x -> x.getId() == playlist.getId());
    }
}
