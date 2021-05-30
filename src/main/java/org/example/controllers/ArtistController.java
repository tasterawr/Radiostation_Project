package org.example.controllers;

import org.example.DAL.DAO.ArtistDAO;
import org.example.DAL.Models.Artist;
import org.example.DAL.repositories.ArtistRepository;

import java.sql.Date;
import java.util.List;

public class ArtistController {
    private static ArtistDAO artistRepository = new ArtistRepository();

    public void addArtist(String artistName, String careerBeginDate, Integer rating){
        Artist artist = new Artist();
        artist.setArtistName(artistName);
        artist.setCareerBeginDate(Date.valueOf(careerBeginDate));
        artist.setRating(rating);

        artistRepository.add(artist);
    }

    public List<Artist> getAllArtists(){
        return artistRepository.getAll();
    }

    public Artist getArtistById(Long id){
        return artistRepository.getById(id);
    }

    public List<Artist> getArtistsWithRatingHigher(Integer rating){
        return artistRepository.getByHigherRating(rating);
    }

    public List<Artist> getArtistsWithRatingLower(Integer rating){
        return artistRepository.getByLowerRating(rating);
    }

    public void updateArtistCareerBeginDate(Long artistId, String newCareerBeginDate){
        Artist artist = artistRepository.getById(artistId);
        artist.setCareerBeginDate(Date.valueOf(newCareerBeginDate));

        artistRepository.update(artist);
    }

    public void updateArtistRating(Long artistId, Integer rating){
        Artist artist = artistRepository.getById(artistId);
        artist.setRating(rating);

        artistRepository.update(artist);
    }

    public void deleteArtist(Long artistId){
        Artist artist = artistRepository.getById(artistId);

        artistRepository.delete(artist);
    }
}
