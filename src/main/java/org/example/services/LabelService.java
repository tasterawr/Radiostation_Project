package org.example.services;

import org.example.DAL.DAO.LabelDAO;
import org.example.DAL.Models.Label;
import org.example.DAL.repositories.LabelRepository;

import java.sql.Date;
import java.util.List;

public class LabelService {
    private static LabelDAO labelRepository = new LabelRepository();

    public boolean addLabel(String labelName, String labelCreationDate){
        try{
            labelRepository.getByName(labelName);
            return false;
        }
        catch(Exception e){
            try{
                Label label = new Label();
                label.setLabelName(labelName);
                label.setLabelCreationDate(Date.valueOf(labelCreationDate));

                labelRepository.add(label);
                return true;
            }
            catch(Exception ex){
                return false;
            }
        }
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

    public boolean updateLabelName(Long labelId, String newLabelName){
        try{
            labelRepository.getByName(newLabelName);
            return false;
        }
        catch(Exception e){
            try{
                Label label = labelRepository.getById(labelId);
                label.setLabelName(newLabelName);

                labelRepository.update(label);
                return true;
            }
            catch(Exception ex){
                return false;
            }
        }
    }

    public boolean updateLabelCreationDate(Long labelId, String newCreationDate){
        try{
            Label label = labelRepository.getById(labelId);
            label.setLabelCreationDate(Date.valueOf(newCreationDate));

            labelRepository.update(label);
            return true;
        }
        catch(Exception e){
            return false;
        }

    }

    public boolean deleteLabel(Long labelId){
        try{
            Label label = labelRepository.getById(labelId);

            labelRepository.delete(label);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
