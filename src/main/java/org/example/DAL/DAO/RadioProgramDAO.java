package org.example.DAL.DAO;

import org.example.DAL.Models.RadioProgram;
import org.example.DAL.Models.Song;

import java.util.List;

public interface RadioProgramDAO {
    void add(RadioProgram radioProgram);

    List<RadioProgram> getAll();

    RadioProgram getById(Long id);

    RadioProgram getByName(String radioProgramName);

    void update(RadioProgram radioProgram);

    void delete(RadioProgram radioProgram);
}
