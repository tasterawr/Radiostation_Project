package org.example.DAL.DAO;

import org.example.DAL.Models.Album;

import java.util.List;

public interface AlbumDAO {
    void add(Album album);

    List<Album> getAll();

    Album getById(Long id);

    void update(Album album);

    void delete(Album album);
}
