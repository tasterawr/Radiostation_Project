package org.example.Controllers;

import org.example.DAL.DAO.RadioProgramDAO;
import org.example.DAL.Models.RadioProgram;
import org.example.DAL.Repositories.RadioProgramRepository;

import java.util.List;

public class RadioProgramController {
    private static RadioProgramDAO radioProgramRepository = new RadioProgramRepository();

    public void addRadioProgram(String radioProgramName, Integer monthlyListeners, Integer songOrderPrice){
        RadioProgram radioProgram = new RadioProgram();
        radioProgram.setRadioProgramName(radioProgramName);
        radioProgram.setMonthlyListeners(monthlyListeners);
        radioProgram.setSongOrderPrice(songOrderPrice);

        radioProgramRepository.add(radioProgram);
    }

    public List<RadioProgram> getAllRadioPrograms(){
        return radioProgramRepository.getAll();
    }

    public RadioProgram getProgramById(Long programId){
        return radioProgramRepository.getById(programId);
    }

    public RadioProgram getProgramByName(String radioProgramName){
        return radioProgramRepository.getByName(radioProgramName);
    }

    public void updateMonthlyListeners(Long programId, Integer newMonthlyListeners){
        RadioProgram radioProgram = radioProgramRepository.getById(programId);
        radioProgram.setMonthlyListeners(newMonthlyListeners);

        radioProgramRepository.update(radioProgram);
    }

    public void updateSongOrderPrice(Long programId, Integer newSongOrderPrice){
        RadioProgram radioProgram = radioProgramRepository.getById(programId);
        radioProgram.setSongOrderPrice(newSongOrderPrice);

        radioProgramRepository.update(radioProgram);
    }

    public void deleteRadioProgram(Long programId){
        RadioProgram radioProgram = radioProgramRepository.getById(programId);

        radioProgramRepository.delete(radioProgram);
    }
}
