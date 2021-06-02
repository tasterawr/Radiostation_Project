package org.example.services;

import org.example.DAL.DAO.AlbumDAO;
import org.example.DAL.DAO.ArtistDAO;
import org.example.DAL.DAO.GenreDAO;
import org.example.DAL.DAO.LabelDAO;
import org.example.DAL.Models.Album;
import org.example.DAL.Models.Artist;
import org.example.DAL.Models.Genre;
import org.example.DAL.Models.Label;
import org.example.DAL.repositories.AlbumRepository;
import org.example.DAL.repositories.ArtistRepository;
import org.example.DAL.repositories.GenreRepository;
import org.example.DAL.repositories.LabelRepository;

import java.util.List;

public class AlbumService {
    private static AlbumDAO albumRepository = new AlbumRepository();
    private static GenreDAO genreRepository = new GenreRepository();
    private static ArtistDAO artistRepository = new ArtistRepository();
    private static LabelDAO labelRepository = new LabelRepository();

    public boolean addAlbum(String albumName, Long genreCode, Long artistId, Integer numberOfTracks, Long labelId){
        try{
            Genre genre = genreRepository.getByGenreCode(genreCode);
            Artist artist = artistRepository.getById(artistId);
            Label label = labelRepository.getById(labelId);

            Album album = new Album();
            album.setAlbumName(albumName);
            album.setGenre(genre);
            album.setArtist(artist);
            album.setNumberOfTracks(numberOfTracks);
            album.setLabel(label);

            albumRepository.add(album);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public List<Album> getAllAlbums(){
        return albumRepository.getAll();
    }

    public Album getAlbumById(Long id){
        try{
            return albumRepository.getById(id);
        }
        catch(Exception e){
            return null;
        }

    }

    public void updateAlbumName(Long albumId, String newAlbumName){
        Album album = albumRepository.getById(albumId);
        album.setAlbumName(newAlbumName);

        albumRepository.update(album);
    }

    public void updateAlbumGenre(Long albumId, Long genreCode){
        Album album = albumRepository.getById(albumId);
        Genre genre = genreRepository.getByGenreCode(genreCode);
        album.setGenre(genre);

        albumRepository.update(album);
    }

    public void updateAlbumArtist(Long albumId, Long newArtistId){
        Album album = albumRepository.getById(albumId);
        Artist artist = artistRepository.getById(newArtistId);
        album.setArtist(artist);

        albumRepository.update(album);
    }

    public void updateAlbumArtist(Long albumId, String newArtistName){
        Album album = albumRepository.getById(albumId);
        Artist artist = artistRepository.getByName(newArtistName);
        album.setArtist(artist);

        albumRepository.update(album);
    }

    public void updateNumberOfTracks(Long albumId, Integer newNumOfTracks){
        Album album = albumRepository.getById(albumId);
        album.setNumberOfTracks(newNumOfTracks);

        albumRepository.update(album);
    }

    public boolean deleteAlbum(Long albumId){
        try{
            Album album = albumRepository.getById(albumId);

            albumRepository.delete(album);

            return true;
        }
        catch(Exception e){
            return false;
        }

    }
}
