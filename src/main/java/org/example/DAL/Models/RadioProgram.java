package org.example.DAL.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class RadioProgram {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String radioProgramName;

    private Integer monthlyListeners;

    private Integer songOrderPrice;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Program_playlists",
            joinColumns = { @JoinColumn(name = "program_id") },
            inverseJoinColumns = { @JoinColumn(name = "playlist_id") }
    )
    private Set<Playlist> playlists = new HashSet<>();

    public RadioProgram() {

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
}
