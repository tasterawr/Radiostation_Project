package org.example.DAL.DAO;

import org.example.DAL.Models.Genre;

import java.util.List;

public interface GenreDAO {
    void add(Genre genre);

    List<Genre> getAll();

    Genre getByGenreCode(Long genreCode);

    void update(Genre genre);

    void delete(Genre genre);
}
