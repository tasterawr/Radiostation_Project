package org.example.Controllers;

import org.example.DAL.DAO.GenreDAO;
import org.example.DAL.Models.Genre;
import org.example.DAL.Repositories.GenreRepository;

import java.util.List;

public class GenreController {
    private static GenreDAO genreRepository = new GenreRepository();

    public void addGenre(String genreName, String description){
        Genre genre = new Genre();
        genre.setGenreName(genreName);
        genre.setDescription(description);

        genreRepository.add(genre);
    }

    public List<Genre> getAllGenres(){
        return genreRepository.getAll();
    }

    public Genre getGenreByCode(Long genreCode){
        return genreRepository.getByGenreCode(genreCode);
    }

    public void setGenreName(Long genreCode, String newGenreName){
        Genre genre = genreRepository.getByGenreCode(genreCode);
        genre.setGenreName(newGenreName);

        genreRepository.update(genre);
    }

    public void setGenreDescription(Long genreCode, String newDescription){
        Genre genre = genreRepository.getByGenreCode(genreCode);
        genre.setDescription(newDescription);

        genreRepository.update(genre);
    }

    public void deleteGenre(Long genreCode){
        Genre genre = genreRepository.getByGenreCode(genreCode);

        genreRepository.delete(genre);
    }
}
