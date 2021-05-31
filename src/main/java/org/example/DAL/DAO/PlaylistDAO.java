package org.example.DAL.DAO;

import org.example.DAL.Models.Playlist;

import java.util.List;

public interface PlaylistDAO {
    void add(Playlist playlist);

    List<Playlist> getAll();

    Playlist getById(Long id);

    Playlist getByName(String playlistName);

    void update(Playlist playlist);

    void delete(Playlist playlist);
}
