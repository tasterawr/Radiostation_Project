package org.example.Controllers;

import org.example.DAL.DAO.RadioDjDAO;
import org.example.DAL.Models.RadioDj;
import org.example.DAL.Repositories.RadioDjRepository;

import java.util.List;

public class RadioDjController {
    private static RadioDjDAO radioDjRepository = new RadioDjRepository();

    public void addRadioDj(String djName){
        RadioDj radioDj = new RadioDj();
        radioDj.setDjName(djName);

        radioDjRepository.add(radioDj);
    }

    public List<RadioDj> getAllRadioDjs(){
        return radioDjRepository.getAll();
    }

    public RadioDj getRadioDjById(Long djId){
        return radioDjRepository.getById(djId);
    }

    public RadioDj getRadioDjByName(String djName){
        return radioDjRepository.getByName(djName);
    }

    public void deleteDj(Long djId){
        RadioDj radioDj = radioDjRepository.getById(djId);

        radioDjRepository.delete(radioDj);
    }
}
