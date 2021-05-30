package org.example.DAL.DAO;

import org.example.DAL.Models.Label;

import java.util.List;

public interface LabelDAO {
    void add(Label label);

    List<Label> getAll();

    Label getById(Long id);

    Label getByName(String labelName);

    void update(Label label);

    void delete(Label label);
}
