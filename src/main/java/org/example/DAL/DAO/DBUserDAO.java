package org.example.DAL.DAO;

import org.example.DAL.Models.Album;
import org.example.DAL.Models.DBUser;

public interface DBUserDAO {
    void add(DBUser user);

    DBUser getById(Long id);

    DBUser checkLogin(String email, String pass);

    void update(DBUser user);

    void delete(DBUser user);
}
