package org.example.services;

import org.example.DAL.DAO.RadioDjDAO;
import org.example.DAL.DAO.RadioProgramDAO;
import org.example.DAL.Models.RadioDj;
import org.example.DAL.Models.RadioProgram;
import org.example.DAL.repositories.RadioDjRepository;
import org.example.DAL.repositories.RadioProgramRepository;

import javax.persistence.NoResultException;
import java.util.List;

public class RadioDjService {
    private static RadioDjDAO radioDjRepository = new RadioDjRepository();
    private static RadioProgramDAO radioProgramRepository = new RadioProgramRepository();

    public boolean addRadioDj(String djName, String djNickname, Long djProgramId){
        try{
            radioDjRepository.getByNickname(djNickname);
            return false;
        }
        catch (NoResultException e){
            try{
                RadioProgram program = radioProgramRepository.getById(djProgramId);
                RadioDj radioDj = new RadioDj();
                radioDj.setName(djName);
                radioDj.setDjNickname(djNickname);
                radioDj.setProgram(program);

                radioDjRepository.add(radioDj);
                return true;
            }
            catch (NoResultException ex){
                return false;
            }
        }
    }

    public List<RadioDj> getAllRadioDjs(){
        return radioDjRepository.getAll();
    }

    public RadioDj getRadioDjById(Long djId){
        try{
            return radioDjRepository.getById(djId);
        }
        catch(NoResultException e){
            return null;
        }
    }

    public RadioDj getRadioDjByName(String djNickname){
        try{
            return radioDjRepository.getByNickname(djNickname);
        }
        catch (NoResultException e){
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
        catch (NoResultException e){
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
        catch (NoResultException e){
            return false;
        }
    }

    public boolean updateRadioDjProgram(Long djId, Long programId){
        try{
            RadioDj radioDj = radioDjRepository.getById(djId);
            RadioProgram program = radioProgramRepository.getById(programId);
            radioDj.setProgram(program);

            radioDjRepository.update(radioDj);
            return true;
        }
        catch (NoResultException e){
            return false;
        }
    }

    public boolean deleteDj(Long djId){
        try{
            RadioDj radioDj = radioDjRepository.getById(djId);

            radioDjRepository.delete(radioDj);
            return true;
        }
        catch (NoResultException e){
            return false;
        }
    }
}
