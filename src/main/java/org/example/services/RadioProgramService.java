package org.example.services;

import org.example.DAL.DAO.PlaylistDAO;
import org.example.DAL.DAO.RadioProgramDAO;
import org.example.DAL.Models.Playlist;
import org.example.DAL.Models.RadioProgram;
import org.example.DAL.repositories.PlaylistRepository;
import org.example.DAL.repositories.RadioProgramRepository;

import java.util.List;

public class RadioProgramService {
    private static RadioProgramDAO radioProgramRepository = new RadioProgramRepository();
    private static PlaylistDAO playlistRepository = new PlaylistRepository();

    public boolean addRadioProgram(String radioProgramName, Integer monthlyListeners, Integer songOrderPrice){
        try{
            RadioProgram radioProgramCheck = radioProgramRepository.getByName(radioProgramName);
            return false;
        }
        catch (Exception e){
            try{
                RadioProgram radioProgram = new RadioProgram();
                radioProgram.setRadioProgramName(radioProgramName);
                radioProgram.setMonthlyListeners(monthlyListeners);
                radioProgram.setSongOrderPrice(songOrderPrice);

                radioProgramRepository.add(radioProgram);
                return true;
            }
            catch (Exception ex){
                return false;
            }
        }
    }

    public List<RadioProgram> getAllRadioPrograms(){
        return radioProgramRepository.getAll();
    }

    public RadioProgram getProgramById(Long programId){
        try{
            return radioProgramRepository.getById(programId);
        }
        catch (Exception e){
            return null;
        }
    }

    public RadioProgram getProgramByName(String radioProgramName){
        try {
            return radioProgramRepository.getByName(radioProgramName);
        }
        catch (Exception e){
            return null;
        }
    }

    public List<Playlist> getProgramPlaylists(Long programId){
        try{
            RadioProgram radioProgram = radioProgramRepository.getById(programId);

            return radioProgram.getPlaylists();
        }
        catch (Exception e){
            return null;
        }
    }

    public boolean updateRadioProgramName(Long programId, String newRadioProgramName){
        try{
            RadioProgram radioProgram = radioProgramRepository.getById(programId);
            radioProgram.setRadioProgramName(newRadioProgramName);

            radioProgramRepository.update(radioProgram);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean updateMonthlyListeners(Long programId, Integer newMonthlyListeners){
        if (newMonthlyListeners < 0)
            return false;

        try{
            RadioProgram radioProgram = radioProgramRepository.getById(programId);
            radioProgram.setMonthlyListeners(newMonthlyListeners);

            radioProgramRepository.update(radioProgram);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean updateSongOrderPrice(Long programId, Integer newSongOrderPrice){
        if (newSongOrderPrice < 0)
            return false;

        try{
            RadioProgram radioProgram = radioProgramRepository.getById(programId);
            radioProgram.setSongOrderPrice(newSongOrderPrice);

            radioProgramRepository.update(radioProgram);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean addPlaylistToProgram(Long programId, Long playlistId){
        try{
            RadioProgram radioProgram = radioProgramRepository.getById(programId);
            Playlist playlist = playlistRepository.getById(playlistId);
            radioProgram.addPlaylist(playlist);

            radioProgramRepository.update(radioProgram);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean removePlaylistFromProgram(Long programId, Long playlistId){
        try{
            RadioProgram radioProgram = radioProgramRepository.getById(programId);
            Playlist playlist = playlistRepository.getById(playlistId);
            radioProgram.removePlaylist(playlist);

            radioProgramRepository.update(radioProgram);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean deleteRadioProgram(Long programId){
        try {
            RadioProgram radioProgram = radioProgramRepository.getById(programId);

            radioProgramRepository.delete(radioProgram);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean deleteRadioProgram(String radioProgramName){
        try {
            RadioProgram radioProgram = radioProgramRepository.getByName(radioProgramName);

            radioProgramRepository.delete(radioProgram);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
