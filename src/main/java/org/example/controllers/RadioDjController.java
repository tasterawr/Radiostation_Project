package org.example.controllers;

import org.example.DAL.DAO.RadioDjDAO;
import org.example.DAL.Models.RadioDj;
import org.example.DAL.repositories.RadioDjRepository;

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
        try{
            return radioDjRepository.getById(djId);
        }
        catch(Exception e){
            return null;
        }
    }

    public RadioDj getRadioDjByName(String djName){
        try{
            return radioDjRepository.getByName(djName);
        }
        catch (Exception e){
            return null;
        }
    }

    public boolean updateRadioDjName(Long djId, String newRadioDjName){
        try{
            RadioDj radioDj = radioDjRepository.getById(djId);
            radioDj.setDjName(newRadioDjName);

            radioDjRepository.update(radioDj);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean deleteDj(Long djId){
        try{
            RadioDj radioDj = radioDjRepository.getById(djId);

            radioDjRepository.delete(radioDj);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
