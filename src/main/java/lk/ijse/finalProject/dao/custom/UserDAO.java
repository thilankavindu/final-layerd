package lk.ijse.finalProject.dao.custom;

import lk.ijse.finalProject.dao.CrudDAO;
import lk.ijse.finalProject.entity.User;

import java.sql.SQLException;

public interface UserDAO extends CrudDAO<User> {
    boolean check(String userId, String password) throws SQLException, ClassNotFoundException;
}
