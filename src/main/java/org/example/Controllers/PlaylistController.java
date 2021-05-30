package org.example.Controllers;

import org.example.DAL.DAO.PlaylistDAO;
import org.example.DAL.Models.Playlist;
import org.example.DAL.Models.Song;
import org.example.DAL.Repositories.PlaylistRepository;

import java.util.List;
import java.util.Set;

public class PlaylistController {
    private static PlaylistDAO playlistRepository = new PlaylistRepository();

    public void addPlaylist(String playlistName){
        Playlist playlist = new Playlist();
        playlist.setPlaylistName(playlistName);

        playlistRepository.add(playlist);
    }

    public List<Playlist> getAllPlaylists(){
        return playlistRepository.getAll();
    }

    public Playlist getPlaylistById(Long playlistId){
        return playlistRepository.getById(playlistId);
    }

    public void updatePlaylistName(Long playlistId, String newPlaylistName){
        Playlist playlist = playlistRepository.getById(playlistId);
        playlist.setPlaylistName(newPlaylistName);

        playlistRepository.update(playlist);
    }

    public void deletePlaylist(Long playlistId){
        Playlist playlist = playlistRepository.getById(playlistId);

        playlistRepository.delete(playlist);
    }

    public Set<Song> getPlaylistSongs(Long playlistId){
        Playlist playlist = playlistRepository.getById(playlistId);

        return playlist.getSongs();
    }

    public Integer getNumberOfTracks(Long playlistId){
        Playlist playlist = playlistRepository.getById(playlistId);

        return playlist.getSongs().size();
    }
}
