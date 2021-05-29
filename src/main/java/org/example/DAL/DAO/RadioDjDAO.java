package org.example.DAL.DAO;

import org.example.DAL.Models.RadioDj;

import java.util.List;

public interface RadioDjDAO {
    void add(RadioDj radioDj);

    List<RadioDj> getAll();

    RadioDj getById(Long id);

    void update(RadioDj radioDj);

    void delete(RadioDj radioDj);
}
