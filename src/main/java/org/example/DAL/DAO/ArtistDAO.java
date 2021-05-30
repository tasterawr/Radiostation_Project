package org.example.DAL.DAO;

import org.example.DAL.Models.Artist;

import java.util.List;

public interface ArtistDAO {
    void add(Artist artist);

    List<Artist> getAll();

    Artist getById(Long id);

    Artist getByName(String artistName);

    List<Artist> getByHigherRating(Integer rating);

    List<Artist> getByLowerRating(Integer rating);

    void update(Artist artist);

    void delete(Artist artist);
}
