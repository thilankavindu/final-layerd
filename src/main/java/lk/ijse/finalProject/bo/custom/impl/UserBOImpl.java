package lk.ijse.finalProject.bo.custom.impl;

import lk.ijse.finalProject.bo.custom.UserBO;
import lk.ijse.finalProject.dao.DAOFactory;
import lk.ijse.finalProject.dao.custom.UserDAO;
import lk.ijse.finalProject.dto.UserDTO;
import lk.ijse.finalProject.entity.User;

import java.sql.SQLException;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getBoFactory().getBO(DAOFactory.BOTypes.USER);
    @Override
    public boolean checkCredential(String userId, String password) throws SQLException, ClassNotFoundException {
        return userDAO.check(userId,password);
    }

    @Override
    public boolean saveUser(UserDTO userDTO) throws SQLException, ClassNotFoundException {
        return userDAO.add(new User(userDTO.getId(),userDTO.getName(),userDTO.getPass()));
    }
}
