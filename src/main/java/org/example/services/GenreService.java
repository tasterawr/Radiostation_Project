package org.example.services;

import org.example.DAL.DAO.GenreDAO;
import org.example.DAL.Models.Genre;
import org.example.DAL.repositories.GenreRepository;

import java.util.List;

public class GenreService {
    private static GenreDAO genreRepository = new GenreRepository();

    public boolean addGenre(String genreName, String description){
        try{
            Genre genreCheck = genreRepository.getByGenreName(genreName);
            return false;
        }
        catch(Exception e){
            Genre genre = new Genre();
            genre.setGenreName(genreName);
            genre.setDescription(description);

            genreRepository.add(genre);
            return true;
        }
    }

    public List<Genre> getAllGenres(){
        return genreRepository.getAll();
    }

    public Genre getGenreByCode(Long genreCode){
        return genreRepository.getByGenreCode(genreCode);
    }

    public boolean setGenreName(Long genreCode, String newGenreName){
        try{
            Genre genre = genreRepository.getByGenreCode(genreCode);
            genre.setGenreName(newGenreName);

            genreRepository.update(genre);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean setGenreDescription(Long genreCode, String newDescription){
        try{
            Genre genre = genreRepository.getByGenreCode(genreCode);
            genre.setDescription(newDescription);

            genreRepository.update(genre);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean deleteGenre(Long genreCode){
        try{
            Genre genre = genreRepository.getByGenreCode(genreCode);

            genreRepository.delete(genre);
            return true;
        }
        catch(Exception e){
            return false;
        }

    }

    public boolean deleteGenre(String genreName){
        try{
            Genre genre = genreRepository.getByGenreName(genreName);

            genreRepository.delete(genre);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
