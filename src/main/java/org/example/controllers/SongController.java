package org.example.controllers;

import org.example.DAL.DAO.AlbumDAO;
import org.example.DAL.DAO.SongDAO;
import org.example.DAL.Models.Album;
import org.example.DAL.Models.Song;
import org.example.DAL.repositories.AlbumRepository;
import org.example.DAL.repositories.SongRepository;

import java.util.List;

public class SongController {
    private static SongDAO songRepository = new SongRepository();
    private static AlbumDAO albumRepository = new AlbumRepository();

    public void addSong(String songName, Long albumId, Integer duration, Integer monthlyOrders, Integer rating){
        Song song = new Song();
        Album album = albumRepository.getById(albumId);
        song.setSongName(songName);
        song.setAlbum(album);
        song.setDuration(duration);
        song.setMonthlyOrders(monthlyOrders);
        song.setRating(rating);

        songRepository.add(song);
    }

    public List<Song> getAllSongs(){
        return songRepository.getAll();
    }

    public Song getSongById(Long songId){
        return songRepository.getById(songId);
    }

    public void updateSongAlbum(Long songId, Long newAlbumId){
        Album album = albumRepository.getById(newAlbumId);
        Song song = songRepository.getById(songId);
        song.setAlbum(album);

        songRepository.update(song);
    }

    public void updateMonthlyOrders(Long songId, Integer newMonthlyOrders){
        Song song = songRepository.getById(songId);
        song.setMonthlyOrders(newMonthlyOrders);

        songRepository.update(song);
    }

    public void updateRating(Long songId, Integer newRating){
        Song song = songRepository.getById(songId);
        song.setRating(newRating);

        songRepository.update(song);
    }

    public void deleteSong(Long songId){
        Song song = songRepository.getById(songId);

        songRepository.delete(song);
    }
}
