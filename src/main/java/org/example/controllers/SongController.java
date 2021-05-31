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

    public boolean addSong(String songName, Long albumId, Integer duration, Integer monthlyOrders, Integer rating){
        try{
            Song song = new Song();
            Album album = albumRepository.getById(albumId);
            song.setSongName(songName);
            song.setAlbum(album);
            song.setDuration(duration);
            song.setMonthlyOrders(monthlyOrders);
            song.setRating(rating);

            songRepository.add(song);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public List<Song> getAllSongs(){
        return songRepository.getAll();
    }

    public Song getSongById(Long songId) {
        return songRepository.getById(songId);
    }

    public boolean updateSongName(Long songId, String newSongName){
        try {
            Song song = songRepository.getById(songId);
            song.setSongName(newSongName);

            songRepository.update(song);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean updateSongAlbum(Long songId, Long newAlbumId){
        try{
            Album album = albumRepository.getById(newAlbumId);
            Song song = songRepository.getById(songId);
            song.setAlbum(album);

            songRepository.update(song);
            return true;
        }
        catch(Exception e){
            return false;
        }

    }

    public boolean updateMonthlyOrders(Long songId, Integer newMonthlyOrders){
        try{
            Song song = songRepository.getById(songId);
            song.setMonthlyOrders(newMonthlyOrders);

            songRepository.update(song);
            return true;
        }
        catch(Exception e){
            return false;
        }

    }

    public boolean updateRating(Long songId, Integer newRating){
        try{
            Song song = songRepository.getById(songId);
            song.setRating(newRating);

            songRepository.update(song);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    public boolean updateDuration(Long songId, Integer newDuration){
        try{
            Song song = songRepository.getById(songId);
            song.setDuration(newDuration);

            songRepository.update(song);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public boolean deleteSong(Long songId){
        try {
            Song song = songRepository.getById(songId);

            songRepository.delete(song);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }
}
