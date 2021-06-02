package org.example.services;

import org.example.DAL.DAO.DBUserDAO;
import org.example.DAL.Models.DBUser;
import org.example.DAL.repositories.DBUserRepository;
import org.example.util.JsonConverter;
import org.example.util.StringHandler;

public class DBUserService {
    private static DBUserDAO userRepository = new DBUserRepository();

    public void addUser(String email, String password){
        DBUser user = new DBUser();
        user.setEmail(email);
        user.setPassword(StringHandler.encryptString(password));

        userRepository.add(user);
    }

    public boolean checkLogin(String email, String password){
        try{
            userRepository.checkLogin(email, StringHandler.encryptString(password));
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public boolean setLogin(String oldLogin, String password, String newLogin){
        try{
            DBUser user = userRepository.checkLogin(oldLogin, StringHandler.encryptString(password));
            user.setEmail(newLogin);

            userRepository.update(user);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean setPassword(String oldLogin, String password, String newPassword){
        try{
            DBUser user = userRepository.checkLogin(oldLogin, StringHandler.encryptString(password));
            user.setPassword(StringHandler.encryptString(newPassword));

            userRepository.update(user);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public void deleteUser(Long userId){
        DBUser user = userRepository.getById(userId);

        userRepository.delete(user);
    }
}
