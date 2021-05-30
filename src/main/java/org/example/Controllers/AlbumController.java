package org.example.Controllers;

import org.example.DAL.DAO.AlbumDAO;
import org.example.DAL.DAO.ArtistDAO;
import org.example.DAL.DAO.GenreDAO;
import org.example.DAL.DAO.LabelDAO;
import org.example.DAL.Models.Album;
import org.example.DAL.Models.Artist;
import org.example.DAL.Models.Genre;
import org.example.DAL.Models.Label;
import org.example.DAL.Repositories.AlbumRepository;
import org.example.DAL.Repositories.ArtistRepository;
import org.example.DAL.Repositories.GenreRepository;
import org.example.DAL.Repositories.LabelRepository;

import java.util.List;

public class AlbumController {
    private static AlbumDAO albumRepository = new AlbumRepository();
    private static GenreDAO genreRepository = new GenreRepository();
    private static ArtistDAO artistRepository = new ArtistRepository();
    private static LabelDAO labelRepository = new LabelRepository();

    public void addAlbum(String albumName, Long genreCode, Long artistId, Integer numberOfTracks, Long labelId){
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
    }

    public List<Album> getAllAlbums(){
        return albumRepository.getAll();
    }

    public Album getAlbumById(Long id){
        return albumRepository.getById(id);
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

    public void deleteAlbum(Long albumId){
        Album album = albumRepository.getById(albumId);

        albumRepository.delete(album);
    }
}
