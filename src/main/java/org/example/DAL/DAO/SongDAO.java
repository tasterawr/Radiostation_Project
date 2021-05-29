package org.example.DAL.DAO;

import org.example.DAL.Models.Song;

import java.util.List;

public interface SongDAO {
    void add(Song song);

    List<Song> getAll();

    Song getById(Long id);

    void update(Song song);

    void delete(Song song);
}
