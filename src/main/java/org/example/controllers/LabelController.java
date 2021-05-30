package org.example.controllers;

import org.example.DAL.DAO.LabelDAO;
import org.example.DAL.Models.Label;
import org.example.DAL.repositories.LabelRepository;

import java.sql.Date;
import java.util.List;

public class LabelController {
    private static LabelDAO labelRepository = new LabelRepository();

    public void addLabel(String labelName, String labelCreationDate){
        Label label = new Label();
        label.setLabelName(labelName);
        label.setLabelCreationDate(Date.valueOf(labelCreationDate));

        labelRepository.add(label);
    }

    public List<Label> getAllLabels(){
        return labelRepository.getAll();
    }

    public Label getLabelById(Long labelId){
        return labelRepository.getById(labelId);
    }

    public Label getLabelByName(String labelName){
        return labelRepository.getByName(labelName);
    }

    public void updateLabelName(Long labelId, String newLabelName){
        Label label = labelRepository.getById(labelId);
        label.setLabelName(newLabelName);

        labelRepository.update(label);
    }

    public void updateLabelCreationDate(Long labelId, String newCreationDate){
        Label label = labelRepository.getById(labelId);
        label.setLabelCreationDate(Date.valueOf(newCreationDate));

        labelRepository.update(label);
    }

    public void deleteLabel(Long labelId){
        Label label = labelRepository.getById(labelId);

        labelRepository.delete(label);
    }
}
