package org.example.services;

import org.example.DAL.DAO.ArtistDAO;
import org.example.DAL.Models.Artist;
import org.example.DAL.repositories.ArtistRepository;

import java.sql.Date;
import java.util.List;

public class ArtistService {
    private static ArtistDAO artistRepository = new ArtistRepository();

    public boolean addArtist(String artistName, String careerBeginDate, Integer rating){
        try{
            Artist artistCheck = artistRepository.getByName(artistName);

            return false;
        }
       catch(Exception e) {
           Artist artist = new Artist();
           artist.setArtistName(artistName);
           artist.setCareerBeginDate(Date.valueOf(careerBeginDate));
           artist.setRating(rating);

           artistRepository.add(artist);
           return true;
       }
    }

    public List<Artist> getAllArtists(){
        return artistRepository.getAll();
    }

    public Artist getArtistById(Long id){
        try{
            return artistRepository.getById(id);
        }
        catch(Exception e){
            return null;
        }
    }

    public Artist getArtistByName(String artistName){
        try{
            return artistRepository.getByName(artistName);
        }
        catch(Exception e){
            return null;
        }
    }

    public List<Artist> getArtistsWithRatingHigher(Integer rating){
        return artistRepository.getByHigherRating(rating);
    }

    public List<Artist> getArtistsWithRatingLower(Integer rating){
        return artistRepository.getByLowerRating(rating);
    }

    public boolean updateArtistName(Long artistId, String newArtistName){
        if (artistRepository.getByName(newArtistName) != null)
            return false;

        try{
            Artist artist = artistRepository.getById(artistId);
            artist.setArtistName(newArtistName);

            artistRepository.update(artist);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public boolean updateArtistCareerBeginDate(Long artistId, String newCareerBeginDate){
        try{
            Artist artist = artistRepository.getById(artistId);
            artist.setCareerBeginDate(Date.valueOf(newCareerBeginDate));

            artistRepository.update(artist);
            return true;
        }
        catch(Exception e){
            return false;
        }

    }

    public boolean updateArtistRating(Long artistId, Integer rating){
        if (rating < 0)
            return false;

        try{
            Artist artist = artistRepository.getById(artistId);
            artist.setRating(rating);

            artistRepository.update(artist);
            return true;
        }
        catch(Exception e){
            return false;
        }

    }

    public boolean deleteArtist(Long artistId){
        try{
            Artist artist = artistRepository.getById(artistId);

            artistRepository.delete(artist);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public boolean deleteArtist(String artistName){
        try{
            Artist artist = artistRepository.getByName(artistName);

            artistRepository.delete(artist);
            return true;
        }
        catch(Exception e){
            return false;
        }

    }
}
