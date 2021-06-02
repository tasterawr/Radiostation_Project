package org.example.controllers;

import org.example.DAL.DAO.RadioDjDAO;
import org.example.DAL.Models.RadioDj;
import org.example.DAL.repositories.RadioDjRepository;

import java.util.List;

public class RadioDjController {
    private static RadioDjDAO radioDjRepository = new RadioDjRepository();

    public boolean addRadioDj(String djName, String djNickname){
        try{
            radioDjRepository.getByNickname(djNickname);
            return false;
        }
        catch (Exception e){
            RadioDj radioDj = new RadioDj();
            radioDj.setName(djName);
            radioDj.setDjNickname(djName);

            radioDjRepository.add(radioDj);
            return true;
        }
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

    public RadioDj getRadioDjByName(String djNickname){
        try{
            return radioDjRepository.getByNickname(djNickname);
        }
        catch (Exception e){
            return null;
        }
    }

    public boolean updateDjNickname(Long djId, String newNickname){
        try{
            RadioDj radioDj = radioDjRepository.getById(djId);
            radioDj.setDjNickname(newNickname);

            radioDjRepository.update(radioDj);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean updateRadioDjName(Long djId, String newRadioDjName){
        try{
            RadioDj radioDj = radioDjRepository.getById(djId);
            radioDj.setName(newRadioDjName);

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
