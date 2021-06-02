package org.example.services;

import org.example.DAL.DAO.PlaylistDAO;
import org.example.DAL.DAO.SongDAO;
import org.example.DAL.Models.Playlist;
import org.example.DAL.Models.Song;
import org.example.DAL.repositories.PlaylistRepository;
import org.example.DAL.repositories.SongRepository;

import javax.persistence.NoResultException;
import java.util.List;

public class PlaylistService {
    private static PlaylistDAO playlistRepository = new PlaylistRepository();
    private static SongDAO songRepository = new SongRepository();

    public boolean addPlaylist(String playlistName){
        try{
            Playlist playlistCheck = playlistRepository.getByName(playlistName);
            return false;
        }
        catch (Exception e){
            Playlist playlist = new Playlist();
            playlist.setPlaylistName(playlistName);

            playlistRepository.add(playlist);
            return true;
        }
    }

    public List<Playlist> getAllPlaylists(){
        return playlistRepository.getAll();
    }

    public Playlist getPlaylistById(Long playlistId){
        try{
            return playlistRepository.getById(playlistId);
        }
        catch (Exception e){
            return null;
        }

    }

    public Playlist getPlaylistByName(String playlistName){
        try{
            return playlistRepository.getByName(playlistName);
        }
        catch (Exception e){
            return null;
        }
    }

    public boolean updatePlaylistName(Long playlistId, String newPlaylistName){
        try{
            Playlist playlistCheck = playlistRepository.getByName(newPlaylistName);
            return false;
        }
        catch(Exception e){
            try{
                Playlist playlist = playlistRepository.getById(playlistId);
                playlist.setPlaylistName(newPlaylistName);

                playlistRepository.update(playlist);
                return true;
            }
            catch (Exception ex) {
                return false;
            }
        }
    }

    public Integer getNumberOfTracks(Long playlistId){
        Playlist playlist = playlistRepository.getById(playlistId);

        return playlist.getSongs().size();
    }

    public boolean addSongToPlaylist(Long playlistId, Long songId){
        try{
            Playlist playlist = playlistRepository.getById(playlistId);
            Song song = songRepository.getById(songId);

            playlist.addSong(song);
            playlistRepository.update(playlist);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public boolean removeSongFromPlaylist(Long playlistId, Long songId){
        try{
            Playlist playlist = playlistRepository.getById(playlistId);
            Song song = songRepository.getById(songId);

            playlist.removeSong(song);
            song.removePlaylist(playlist);
            playlistRepository.update(playlist);
            return true;
        }
        catch(NoResultException e){
            return false;
        }
    }

    public List<Song> getPlaylistSongs(Long playlistId){
        try{
            Playlist playlist = playlistRepository.getById(playlistId);

            return playlist.getSongs();
        }
        catch(Exception e){
            return null;
        }
    }

    public boolean deletePlaylist(Long playlistId){
        try{
            Playlist playlist = playlistRepository.getById(playlistId);

            playlistRepository.delete(playlist);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean deletePlaylist(String playlistName){
        try{
            Playlist playlist = playlistRepository.getByName(playlistName);

            playlistRepository.delete(playlist);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }
}
